package javax.shim;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.VarHandle;
import java.lang.reflect.*;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
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
 * @param <T> The type of the target object being proxied
 */
@Deprecated
final class ShimProxy<T> implements InvocationHandler, MethodHandler {
    private static final ShimProxy<Object> NO_TARGET = new ShimProxy<>();
    private static final Map<Integer, Class<?>> PROXY_CLASSES = new ConcurrentHashMap<>(1 << 9);
    private static final Map<Class<?>, Collection<Field>> FIELDS = new WeakHashMap<>(1 << 9);
    private static final Map<Class<?>, Collection<Method>> METHODS = new WeakHashMap<>(1 << 9);
    private static final Map<Method, MethodHandle> METHOD_HANDLES = new WeakHashMap<>(1 << 11);
    private static final Map<Method, MethodHandle> EXACT_INVOKERS = new WeakHashMap<>(1 << 11);
    private static final VarHandle PROXY_INVOCATION_HANDLER =
        ShimReflector.call(Proxy.class, (lookup, clazz) -> lookup.findVarHandle(clazz, "h", InvocationHandler.class));

    private final T target;
    private final Map<Method, MethodHandle> invokers = new ConcurrentHashMap<>(1 << 7);

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    private ShimProxy() {
        target = null;
    }

    private ShimProxy(T target) {
        this.target = Objects.requireNonNull(target);
    }

    //==================================================================================================================
    // Implementation Methods
    //==================================================================================================================

    static <T> T create(T target, Class<? extends T> type) {
        return isProxy(target.getClass()) && type.isInstance(target) ? target : new ShimProxy<>(target).create(type);
    }

    static <T> Class<? extends T> create(Class<?> baseType, Class<T> shimType) {
        return isProxy(baseType) && shimType.isAssignableFrom(baseType)
            ? baseType.asSubclass(shimType)
            : NO_TARGET.createClass(baseType, shimType);
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

    private T create(Class<? extends T> type) {
        T proxy = Unsafe.allocateInstance(createClass(target != null ? target.getClass() : Object.class, type));
        setHandler(proxy);
        copyFields(proxy);
        return proxy;
    }

    private <S extends T> Class<? extends S> createClass(Class<?> baseType, Class<S> shimType) {
        return PROXY_CLASSES.computeIfAbsent(baseType.hashCode() ^ shimType.hashCode(), ignored -> {
            if (!shimType.isInterface()) {
                throw new IllegalArgumentException("Interface type required for proxy class: " + shimType.getName());
            } else if (baseType.isInterface()) {
                return Proxy
                    .getProxyClass(ShimSupport.getClassLoader(baseType), getInterfaceTypes(target, baseType, shimType));
            }

            var proxyFactory = new ProxyFactory();
            getClassHierarchy(baseType)
                .filter(clazz -> clazz != Object.class && !Modifier.isFinal(clazz.getModifiers()))
                .findFirst()
                .ifPresent(proxyFactory::setSuperclass);
            proxyFactory.setInterfaces(getInterfaceTypes(target, shimType));
            proxyFactory.setHandler(this);
            return proxyFactory.createClass();
        }).asSubclass(shimType);
    }

    private Object invoke(Method method, Object[] arguments) throws Throwable {
        return invokers
            .computeIfAbsent(method, ignored -> getInvoker(method).bindTo(unreflect(method).bindTo(target)))
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
        if (target != null) {
            getFields(proxy.getClass().getSuperclass()).forEach(field -> Unsafe.copyField(field, target, proxy));
        }
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

    private static Class<?>[] getInterfaceTypes(Object target, Class<?>... interfaceTypes) {
        return Stream
            .concat(
                getHierarchy(target != null ? target.getClass() : null, Class::getInterfaces),
                Stream.of(interfaceTypes)
            )
            .distinct()
            .toArray(Class<?>[]::new);
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

    private static Collection<Method> getMethods(Class<?> clazz) {
        return METHODS.computeIfAbsent(clazz, ignored -> getMembers(clazz, Class::getDeclaredMethods));
    }

    private static MethodHandle getInvoker(Method method) {
        return EXACT_INVOKERS.computeIfAbsent(method, ignored ->
            MethodHandles.exactInvoker(MethodType.methodType(method.getReturnType(), method.getParameterTypes()))
        );
    }

    private static MethodHandle unreflect(Method method) {
        return METHOD_HANDLES.computeIfAbsent(method, ignored ->
            ShimReflector.call(method.getDeclaringClass(), (lookup, clazz) -> lookup.unreflect(method))
        );
    }

    private static boolean isProxy(Class<?> clazz) {
        return Proxy.isProxyClass(clazz) || ProxyFactory.isProxyClass(clazz);
    }
}
