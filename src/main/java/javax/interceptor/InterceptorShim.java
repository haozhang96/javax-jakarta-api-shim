package javax.interceptor;

import javax.shim.Shim;
import java.lang.annotation.Annotation;
import java.util.stream.Stream;

/**
 * @deprecated Use {@link jakarta.interceptor} instead.
 */
@Deprecated(since = "jakarta.interceptor")
public interface InterceptorShim extends Shim {
    //==================================================================================================================
    // Helper Methods
    //==================================================================================================================

    static void initialize() {
        Shim.initialize();
    }

    //==================================================================================================================
    // Factory Methods
    //==================================================================================================================

    static <S extends InterceptorShim> S of(Object object) {
        if (object == null || object instanceof InterceptorShim) {
            return S(object);
        } else if (object instanceof Annotation) {
            return S(of((Annotation) object));
        } else if (object instanceof jakarta.interceptor.Interceptor.Priority) {
            return S(new Facades.Interceptor$Priority(S(object)));
        } else if (object instanceof jakarta.interceptor.InvocationContext) {
            return S(new Facades.InvocationContext(S(object)));
        }

        throw new UnsupportedOperationException("Unknown type: " + object.getClass().getName());
    }

    static <S extends InterceptorShim> Stream<S> of(Object[] objects) {
        return Shim.of(InterceptorShim::of, objects);
    }

    static <S extends InterceptorShim> Stream<S> of(Iterable<?> objects) {
        return Shim.of(InterceptorShim::of, objects);
    }

    static <S extends InterceptorShim & Annotation> Stream<S> of(Annotation[] annotations) {
        return Shim.of(InterceptorShim::of, annotations);
    }

    static <S extends InterceptorShim> Class<? extends S> of(Class<S> shimType, Class<?> interfaceType) {
        return Shim.of(shimType, interfaceType);
    }

    //==================================================================================================================
    // Private Helper Methods
    //==================================================================================================================

    private static <S extends Annotation> S of(Annotation annotation) {
        if (annotation == null || annotation instanceof InterceptorShim) {
            return S(annotation);
        } else if (annotation instanceof jakarta.interceptor.AroundConstruct) {
            return S(new Facades.AroundConstruct(S(annotation)));
        } else if (annotation instanceof jakarta.interceptor.AroundInvoke) {
            return S(new Facades.AroundInvoke(S(annotation)));
        } else if (annotation instanceof jakarta.interceptor.AroundTimeout) {
            return S(new Facades.AroundTimeout(S(annotation)));
        } else if (annotation instanceof jakarta.interceptor.ExcludeClassInterceptors) {
            return S(new Facades.ExcludeClassInterceptors(S(annotation)));
        } else if (annotation instanceof jakarta.interceptor.ExcludeDefaultInterceptors) {
            return S(new Facades.ExcludeDefaultInterceptors(S(annotation)));
        } else if (annotation instanceof jakarta.interceptor.Interceptor) {
            return S(new Facades.Interceptor(S(annotation)));
        } else if (annotation instanceof jakarta.interceptor.InterceptorBinding) {
            return S(new Facades.InterceptorBinding(S(annotation)));
        } else if (annotation instanceof jakarta.interceptor.Interceptors) {
            return S(new Facades.Interceptors(S(annotation)));
        }

        throw new UnsupportedOperationException("Unknown annotation type: " + annotation.annotationType().getName());
    }

    @SuppressWarnings("unchecked")
    private static <S> S S(Object object) {
        return (S) object;
    }
}
