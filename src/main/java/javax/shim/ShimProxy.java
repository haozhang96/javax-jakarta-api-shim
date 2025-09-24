package javax.shim;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.lang.ref.Cleaner;
import java.lang.ref.WeakReference;
import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class helps create self-patching proxy classes and objects using Java's built-in {@link Proxy} and
 *   {@link javassist}'s {@link ProxyFactory}.
 * <br/><br/>
 *
 * Method invocations that fail due to {@link LinkageError}s (e.g., {@link NoClassDefFoundError},
 *   {@link NoSuchMethodError}, {@link NoSuchFieldError}) and {@link ClassCastException}s related to
 *   {@code javax}/{@code jakarta} namespaces will be reattempted after using {@link ShimPatcher} to patch the
 *   offending incompatible classes.
 *
 * @deprecated This class should only be used internally by the {@code javax-jakarta-api-shim} library.
 */
@Deprecated(since = "javax-jakarta-api-shim")
final class ShimProxy extends WeakReference<Object> implements InvocationHandler, MethodHandler {
    private static final ShimProxy STATIC = new ShimProxy();
    private static final Cleaner CLEANER = Cleaner.create();
    private static final Map<Integer, ShimProxy> CACHE = new ConcurrentHashMap<>(1 << 9);
    private static final Map<Integer, Class<?>> PROXY_CLASSES = new ConcurrentHashMap<>(1 << 8);
    private static final Map<Class<?>, Collection<Field>> FIELDS = new WeakHashMap<>(1 << 8);
    private static final Map<Method, MethodHandle> METHOD_HANDLES = new WeakHashMap<>(1 << 11);
    private static final Set<Class<?>> KNOWN_ENTRY_POINTS = Collections.newSetFromMap(new WeakHashMap<>(1 << 8));
    private static final VarHandle PROXY_INVOCATION_HANDLER =
        ShimReflector.call(Proxy.class, (lookup, clazz) -> lookup.findVarHandle(clazz, "h", InvocationHandler.class));

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    private ShimProxy() {
        super(null);
    }

    private ShimProxy(Object target) {
        super(Objects.requireNonNull(target));
        logEntryPoint(target);

        final var hashCode = System.identityHashCode(target);
        CLEANER.register(target, () -> CACHE.remove(hashCode));
    }

    //==================================================================================================================
    // Implementation Methods
    //==================================================================================================================

    static <T> T of(T target, Class<? extends T> type) {
        return shouldProxy(target.getClass(), type)
            ? CACHE.computeIfAbsent(System.identityHashCode(target), ignored -> new ShimProxy(target)).create(type)
            : target;
    }

    static <T> Class<? extends T> of(Class<?> baseType, Class<T> shimType) {
        return shouldProxy(baseType, shimType) ? STATIC.createClass(baseType, shimType) : baseType.asSubclass(shimType);
    }

    //==================================================================================================================
    // InvocationHandler Implementation Methods
    //==================================================================================================================

    @Override
    public Object invoke(Object proxy, Method method, Object[] arguments) throws Throwable {
        try {
            return isProxy(method.getDeclaringClass()) ? method.invoke(proxy, arguments) : invoke(method, arguments);
        } catch (Throwable cause) {
            patch(cause);
            return invoke(proxy, method, arguments);
        }
    }

    //==================================================================================================================
    // MethodHandler Implementation Methods
    //==================================================================================================================

    @Override
    public Object invoke(Object proxy, Method method, Method proceed, Object[] arguments) throws Throwable {
        return invoke(proxy, Objects.requireNonNullElse(proceed, method), arguments);
    }

    //==================================================================================================================
    // Private Helper Methods
    //==================================================================================================================

    private Optional<Object> getTarget() {
        return Optional.ofNullable(get());
    }

    private Class<?> getTargetClass() {
        return getTarget()
            .<Class<?>>map(Object::getClass)
            .orElse(Object.class);
    }

    private <T> T create(Class<? extends T> type) {
        T proxy = Unsafe.allocateInstance(createClass(getTargetClass(), type));
        setHandler(proxy);
        copyFields(proxy);
        return proxy;
    }

    private <T> Class<? extends T> createClass(Class<?> baseType, Class<T> shimType) {
        return PROXY_CLASSES.computeIfAbsent(baseType.hashCode() ^ shimType.hashCode(), ignored -> {
            if (!shimType.isInterface()) {
                throw new IllegalArgumentException("Interface type required for shim: " + shimType.getName());
            } else if (baseType.isInterface()) {
                return Proxy.getProxyClass(ShimSupport.getClassLoader(baseType), getInterfaceTypes(baseType, shimType));
            }

            var proxyFactory = new ProxyFactory();
            getClassHierarchy(baseType)
                .filter(clazz -> clazz != Object.class && !Modifier.isFinal(clazz.getModifiers()))
                .findFirst()
                .ifPresent(proxyFactory::setSuperclass);
            proxyFactory.setInterfaces(getInterfaceTypes(shimType));
            return proxyFactory.createClass();
        }).asSubclass(shimType);
    }

    private Object invoke(Method method, Object... arguments) throws Throwable {
        return getTarget()
            .map(unreflect(method)::bindTo)
            .orElseThrow(() -> new IllegalStateException("Proxy target is no longer available."))
            .invokeWithArguments(arguments);
    }

    private static void patch(Throwable cause) throws Throwable {
        Stream
            .iterate(cause, Objects::nonNull, Throwable::getCause)
            .dropWhile(cause$ -> !(cause$ instanceof LinkageError || cause$ instanceof ClassCastException))
            .filter(ShimSupport::isShimmable)
            .findFirst()
            .map(Throwable::getStackTrace)
            .map(stackTrace -> stackTrace[0])
            .map(StackTraceElement::getClassName)
            .ifPresentOrElse(ShimPatcher.STRICT::patch, () -> ShimSupport.rethrow(cause));
    }

    private void setHandler(Object proxy) {
        if (Proxy.isProxyClass(proxy.getClass())) {
            PROXY_INVOCATION_HANDLER.set(proxy, this);
        } else if (ProxyFactory.isProxyClass(proxy.getClass())) {
            ((javassist.util.proxy.Proxy) proxy).setHandler(this);
        }
    }

    private void copyFields(Object proxy) {
        getTarget().ifPresent(target ->
            getFields(proxy.getClass().getSuperclass()).forEach(field -> Unsafe.copyField(field, target, proxy))
        );
    }

    private Class<?>[] getInterfaceTypes(Class<?>... interfaceTypes) {
        return Stream
            .concat(Stream.of(interfaceTypes), getHierarchy(getTargetClass(), Class::getInterfaces))
            .distinct()
            .toArray(Class<?>[]::new);
    }

    private static Stream<Class<?>> getClassHierarchy(Class<?> clazz) {
        return Stream
            .<Class<?>>iterate(clazz, Objects::nonNull, Class::getSuperclass)
            .dropWhile(ShimProxy::isProxy);
    }

    private static <T> Stream<T> getHierarchy(Class<?> clazz, Function<? super Class<?>, ? extends T[]> extractor) {
        return getClassHierarchy(clazz)
            .map(extractor)
            .flatMap(Stream::of)
            .parallel();
    }

    private static <M extends Member> Collection<M> getMembers(
        Class<?> clazz,
        Function<? super Class<?>, ? extends M[]> members
    ) {
        return getHierarchy(clazz, members)
            .filter(member -> !Modifier.isStatic(member.getModifiers()))
            .collect(Collectors.toUnmodifiableSet());
    }

    private static Collection<Field> getFields(Class<?> clazz) {
        return FIELDS.computeIfAbsent(clazz, ignored -> getMembers(clazz, Class::getDeclaredFields));
    }

    private static MethodHandle unreflect(Method method) {
        return METHOD_HANDLES.computeIfAbsent(method, ignored ->
            ShimReflector.call(method.getDeclaringClass(), (lookup, clazz) -> lookup.unreflect(method))
        );
    }

    private static void logEntryPoint(Object target) {
        if (!KNOWN_ENTRY_POINTS.add(target.getClass())) {
            return;
        }

        final var depth = 5L;
        ShimLogger.INFO.accept(String.format(
            "[*] Shimming: %s -> %s%s",
            target.getClass().getName(),
            ShimSupport.STACK_WALKER.walk(stackFrames ->
                stackFrames
                    .skip(depth + 1L)
                    .<Class<?>>map(StackWalker.StackFrame::getDeclaringClass)
                    .map(Class::getName)
                    .findFirst()
                    .orElse("?")
            ),
            ShimSupport.STACK_WALKER.walk(stackFrames ->
                stackFrames
                    .skip(depth)
                    .dropWhile(stackFrame -> Shim.class.isAssignableFrom(stackFrame.getDeclaringClass()))
                    .limit(1L)
                    .map(StackWalker.StackFrame::toString)
                    .collect(Collectors.joining(System.lineSeparator() + "\tat ", System.lineSeparator() + "\tat ", ""))
            )
        ));
    }

    private static boolean isProxy(Class<?> clazz) {
        return Proxy.isProxyClass(clazz) || ProxyFactory.isProxyClass(clazz);
    }

    private static boolean shouldProxy(Class<?> baseType, Class<?> shimType) {
        return !isProxy(baseType) || !shimType.isAssignableFrom(baseType);
    }
}
