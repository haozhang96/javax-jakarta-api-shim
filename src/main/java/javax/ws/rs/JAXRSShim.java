package javax.ws.rs;

import javax.shim.Shim;
import javax.shim.ShimSupport;
import java.lang.annotation.Annotation;
import java.util.stream.Stream;

/**
 * @deprecated Use {@link jakarta.ws.rs} instead.
 */
@Deprecated(since = "jakarta.ws.rs")
public interface JAXRSShim extends Shim {
    //==================================================================================================================
    // Helper Methods
    //==================================================================================================================

    static void initialize() {
        Shim.initialize();
    }

    //==================================================================================================================
    // Factory Methods
    //==================================================================================================================

    static <S extends JAXRSShim> S of(Object object) {
        if (object == null || object instanceof JAXRSShim) {
            return S(object);
        } else if (object instanceof Annotation) {
            return S(of((Annotation) object));
        }

        return ShimSupport.throwUnknownType(null, object);
    }

    static <S extends JAXRSShim> Stream<S> of(Object[] objects) {
        return Shim.of(JAXRSShim::of, objects);
    }

    static <S extends JAXRSShim> Stream<S> of(Iterable<?> objects) {
        return Shim.of(JAXRSShim::of, objects);
    }

    static <S extends JAXRSShim> Class<? extends S> of(Class<?> baseType, Class<S> shimType) {
        return Shim.of(baseType, shimType);
    }

    //==================================================================================================================
    // Private Helper Methods
    //==================================================================================================================

    private static <S extends Annotation> S of(Annotation annotation) {
        if (annotation == null || annotation instanceof JAXRSShim) {
            return S(annotation);
        }

        return ShimSupport.throwUnknownType(null, annotation);
    }

    @SuppressWarnings("unchecked")
    private static <S> S S(Object object) {
        return (S) object;
    }
}
