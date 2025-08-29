package javax.el;

import javax.shim.Shim;
import java.lang.annotation.Annotation;
import java.util.stream.Stream;

/**
 * @deprecated Use {@link jakarta.el} instead.
 */
@Deprecated(since = "jakarta.el")
public interface ELShim extends Shim {
    //==================================================================================================================
    // Helper Methods
    //==================================================================================================================

    static void initialize() {
        Shim.initialize();
    }

    //==================================================================================================================
    // Factory Methods
    //==================================================================================================================

    static <S extends ELShim> S of(Object object) {
        if (object == null || object instanceof ELShim) {
            return S(object);
        } else if (object instanceof Annotation) {
            return S(of((Annotation) object));
        }

        throw new UnsupportedOperationException("Unknown type: " + object.getClass().getName());
    }

    static <S extends ELShim> Stream<S> of(Object[] objects) {
        return Shim.of(ELShim::of, objects);
    }

    static <S extends ELShim> Stream<S> of(Iterable<?> objects) {
        return Shim.of(ELShim::of, objects);
    }

    static <S extends ELShim & Annotation> Stream<S> of(Annotation[] annotations) {
        return Shim.of(ELShim::of, annotations);
    }

    static <S extends ELShim> Class<? extends S> of(Class<S> shimType, Class<?> interfaceType) {
        return Shim.of(shimType, interfaceType);
    }

    //==================================================================================================================
    // Private Helper Methods
    //==================================================================================================================

    private static <S extends Annotation> S of(Annotation annotation) {
        if (annotation == null || annotation instanceof ELShim) {
            return S(annotation);
        }

        throw new UnsupportedOperationException("Unknown annotation type: " + annotation.annotationType().getName());
    }

    @SuppressWarnings("unchecked")
    private static <S> S S(Object object) {
        return (S) object;
    }
}
