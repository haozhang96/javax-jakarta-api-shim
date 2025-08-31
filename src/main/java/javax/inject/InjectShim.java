package javax.inject;

import javax.shim.Shim;
import javax.shim.ShimSupport;
import java.lang.annotation.Annotation;
import java.util.stream.Stream;

/**
 * @deprecated Use {@link jakarta.inject} instead.
 */
@Deprecated(since = "jakarta.inject")
public interface InjectShim extends Shim {
    //==================================================================================================================
    // Helper Methods
    //==================================================================================================================

    static void initialize() {
        Shim.initialize();
    }

    //==================================================================================================================
    // Factory Methods
    //==================================================================================================================

    static <S extends InjectShim> S of(Object object) {
        if (object == null || object instanceof InjectShim) {
            return S(object);
        } else if (object instanceof Annotation) {
            return S(of((Annotation) object));
        } else if (object instanceof jakarta.inject.Provider<?>) {
            return S(new Facades.Provider<>(S(object)));
        }

        return ShimSupport.throwUnknownType(null, object);
    }

    static <S extends InjectShim> Stream<S> of(Object[] objects) {
        return Shim.of(InjectShim::of, objects);
    }

    static <S extends InjectShim> Stream<S> of(Iterable<?> objects) {
        return Shim.of(InjectShim::of, objects);
    }

    static <S extends InjectShim> Class<? extends S> of(Class<S> shimType, Class<?> interfaceType) {
        return Shim.of(shimType, interfaceType);
    }

    //==================================================================================================================
    // Private Helper Methods
    //==================================================================================================================

    private static <S extends Annotation> S of(Annotation annotation) {
        if (annotation == null || annotation instanceof InjectShim) {
            return S(annotation);
        } else if (annotation instanceof jakarta.inject.Inject) {
            return S(new Facades.Inject(S(annotation)));
        } else if (annotation instanceof jakarta.inject.Named) {
            return S(new Facades.Named(S(annotation)));
        } else if (annotation instanceof jakarta.inject.Qualifier) {
            return S(new Facades.Qualifier(S(annotation)));
        } else if (annotation instanceof jakarta.inject.Scope) {
            return S(new Facades.Scope(S(annotation)));
        } else if (annotation instanceof jakarta.inject.Singleton) {
            return S(new Facades.Singleton(S(annotation)));
        }

        return ShimSupport.throwUnknownType(null, annotation);
    }

    @SuppressWarnings("unchecked")
    private static <S> S S(Object object) {
        return (S) object;
    }
}
