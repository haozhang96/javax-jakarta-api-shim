package javax.xml.ws;

import javax.shim.Shim;
import javax.shim.ShimSupport;
import java.lang.annotation.Annotation;
import java.util.stream.Stream;

/**
 * @deprecated Use {@link jakarta.xml.ws} instead.
 */
@Deprecated(since = "jakarta.xml.ws")
public interface JAXWSShim extends Shim {
    //==================================================================================================================
    // Helper Methods
    //==================================================================================================================

    static void initialize() {
        Shim.initialize();
    }

    //==================================================================================================================
    // Factory Methods
    //==================================================================================================================

    static <S extends JAXWSShim> S of(Object object) {
        if (object == null || object instanceof JAXWSShim) {
            return S(object);
        } else if (object instanceof Annotation) {
            return S(of((Annotation) object));
        }

        return ShimSupport.throwUnknownType(null, object);
    }

    static <S extends JAXWSShim> Stream<S> of(Object[] objects) {
        return Shim.of(JAXWSShim::of, objects);
    }

    static <S extends JAXWSShim> Stream<S> of(Iterable<?> objects) {
        return Shim.of(JAXWSShim::of, objects);
    }

    static <S extends JAXWSShim> Class<? extends S> of(Class<S> shimType, Class<?> interfaceType) {
        return Shim.of(shimType, interfaceType);
    }

    //==================================================================================================================
    // Private Helper Methods
    //==================================================================================================================

    private static <S extends Annotation> S of(Annotation annotation) {
        if (annotation == null || annotation instanceof JAXWSShim) {
            return S(annotation);
        }

        return ShimSupport.throwUnknownType(null, annotation);
    }

    @SuppressWarnings("unchecked")
    private static <S> S S(Object object) {
        return (S) object;
    }
}
