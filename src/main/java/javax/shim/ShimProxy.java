package javax.shim;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;

import java.lang.reflect.*;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * This class helps create self-shimming/-patching proxies.
 *
 * @param <T>
 */
@Deprecated
final class ShimProxy<T> implements InvocationHandler, MethodHandler {
    private final T target;

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    ShimProxy() {
        target = null;
    }

    ShimProxy(T target) {
        this.target = Objects.requireNonNull(target);
    }

    //==================================================================================================================
    // Implementation Methods
    //==================================================================================================================

    T of(Class<? extends T> type) {
        final T proxy = Unsafe.allocateInstance(of(target != null ? target.getClass() : Object.class, type));
        if (Proxy.isProxyClass(proxy.getClass())) {
            ShimReflector.call(Proxy.class, (lookup, clazz) ->
                lookup
                    .findVarHandle(clazz, "h", InvocationHandler.class)
                    .compareAndSet(proxy, null, this)
            );
        } else if (ProxyFactory.isProxyClass(proxy.getClass())) {
            ((javassist.util.proxy.Proxy) proxy).setHandler(this);
        }

        if (target != null) {
            getClassHierarchy(proxy)
                .map(Class::getDeclaredFields)
                .flatMap(Stream::of)
                .filter(field -> !Modifier.isStatic(field.getModifiers()))
                .forEach(field -> Unsafe.copyField(field, target, proxy));
        }

        return proxy;
    }

    <S extends T> Class<? extends S> of(Class<?> baseType, Class<S> shimType) {
        if (!shimType.isInterface()) {
            throw new IllegalArgumentException("Interface type required for proxy class: " + shimType.getName());
        } else if (baseType.isInterface()) {
            return Proxy
                .getProxyClass(baseType.getClassLoader(), getInterfaceTypes(baseType, shimType))
                .asSubclass(shimType);
        }

        var proxyFactory = new ProxyFactory();
        getClassHierarchy(baseType)
            .filter(Predicate.not(this::isFinalClass))
            .findFirst()
            .ifPresent(proxyFactory::setSuperclass);
        proxyFactory.setInterfaces(getInterfaceTypes(shimType));
        proxyFactory.setHandler(this);
        return proxyFactory
            .createClass()
            .asSubclass(shimType);
    }

    //==================================================================================================================
    // InvocationHandler Implementation Methods
    //==================================================================================================================

    @Override
    public Object invoke(Object proxy, Method method, Object[] arguments) throws Throwable {
        final Callable<?> invocation =
            () -> method.invoke(target == null || isProxyClass(method.getDeclaringClass()) ? proxy : target, arguments);

        try {
            return invocation.call();
        } catch (InvocationTargetException exception) {
//            Throwable cause = exception;
//            do {
//                cause = cause.getCause();
//            } while (cause != null && !(cause instanceof LinkageError));

//            if (cause == null || !ShimSupport.isShimmable(cause)) {
//                throw exception.getCause();
//            } else {
//                ShimPatcher.STRICT.patch(cause.getStackTrace()[0].getClassName());
//            }

            final var className =
                Stream
                    .iterate(exception.getCause(), Objects::nonNull, Throwable::getCause)
                    .dropWhile(Predicate.not(LinkageError.class::isInstance))
                    .filter(ShimSupport::isShimmable)
                    .findFirst()
                    .map(Throwable::getStackTrace)
                    .map(stackTrace -> stackTrace[0])
                    .map(StackTraceElement::getClassName)
                    .orElseThrow(exception::getCause);
            ShimPatcher.STRICT.patch(className);
        }

        try {
            return invocation.call();
        } catch (InvocationTargetException exception) {
            throw exception.getCause();
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

    private Class<?>[] getInterfaceTypes(Class<?>... interfaceTypes) {
        return Stream
            .concat(Stream.of(interfaceTypes), getClassHierarchy(target).map(Class::getInterfaces).flatMap(Stream::of))
            .filter(Objects::nonNull)
            .distinct()
            .toArray(Class<?>[]::new);
    }

    private Stream<Class<?>> getClassHierarchy(Object object) {
        return getClassHierarchy(object != null ? object.getClass() : null);
    }

    private Stream<Class<?>> getClassHierarchy(Class<?> clazz) {
        return Stream
            .<Class<?>>iterate(clazz, Objects::nonNull, Class::getSuperclass)
            .dropWhile(this::isProxyClass);
    }

    private boolean isFinalClass(Class<?> clazz) {
        return Modifier.isFinal(clazz.getModifiers());
    }

    private boolean isProxyClass(Class<?> clazz) {
        return Proxy.isProxyClass(clazz) || ProxyFactory.isProxyClass(clazz);
    }
}
