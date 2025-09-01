package javax.validation;

import javax.shim.Shim;
import javax.shim.ShimSupport;
import java.lang.annotation.Annotation;
import java.util.stream.Stream;

/**
 * @deprecated Use {@link jakarta.validation} instead.
 */
@Deprecated(since = "jakarta.validation")
public interface ValidationShim extends Shim {
    //==================================================================================================================
    // Helper Methods
    //==================================================================================================================

    static void initialize() {
        Shim.initialize();
    }

    //==================================================================================================================
    // Factory Methods
    //==================================================================================================================

    static <S extends ValidationShim> S of(Object object) {
        if (object == null || object instanceof ValidationShim) {
            return S(object);
        } else if (object instanceof Annotation) {
            return S(of((Annotation) object));
        }

        return ShimSupport.throwUnknownType(null, object);
    }

    static <S extends ValidationShim> Stream<S> of(Object[] objects) {
        return Shim.of(ValidationShim::of, objects);
    }

    static <S extends ValidationShim> Stream<S> of(Iterable<?> objects) {
        return Shim.of(ValidationShim::of, objects);
    }

    static <S extends ValidationShim> Class<? extends S> of(Class<S> shimType, Class<?> interfaceType) {
        return Shim.of(shimType, interfaceType);
    }

    //==================================================================================================================
    // Private Helper Methods
    //==================================================================================================================

    private static <S extends Annotation> S of(Annotation annotation) {
        if (annotation == null || annotation instanceof ValidationShim) {
            return S(annotation);
        }

        return ShimSupport.throwUnknownType(null, annotation);
    }

    @SuppressWarnings("unchecked")
    private static <S> S S(Object object) {
        return (S) object;
    }
}
