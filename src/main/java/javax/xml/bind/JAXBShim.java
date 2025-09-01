package javax.xml.bind;

import javax.shim.Shim;
import javax.shim.ShimSupport;
import java.lang.annotation.Annotation;
import java.util.stream.Stream;

/**
 * @deprecated Use {@link jakarta.xml.bind} instead.
 */
@Deprecated(since = "jakarta.xml.bind")
public interface JAXBShim extends Shim {
    //==================================================================================================================
    // Helper Methods
    //==================================================================================================================

    static void initialize() {
        Shim.initialize();
    }

    //==================================================================================================================
    // Factory Methods
    //==================================================================================================================

    static <S extends JAXBShim> S of(Object object) {
        if (object == null || object instanceof JAXBShim) {
            return S(object);
        } else if (object instanceof jakarta.xml.bind.JAXBException) {
            return S(of((jakarta.xml.bind.JAXBException) object));
        } else if (object instanceof Annotation) {
            return S(of((Annotation) object));
        } else if (object instanceof jakarta.xml.bind.DatatypeConverterInterface) {
            return S(new Facades.DatatypeConverterInterface(S(object)));
        }

        return ShimSupport.throwUnknownType(null, object);
    }

    static <S extends JAXBException> S of(jakarta.xml.bind.JAXBException exception) {
        if (exception == null || exception instanceof JAXBShim) {
            return S(exception);
//        } else if (exception instanceof jakarta.xml.bind.MarshalException) {
//            return S(new Facades.MarshalException(S(exception)));
//        } else if (exception instanceof jakarta.xml.bind.UnmarshalException) {
//            return S(new Facades.UnmarshalException(S(exception)));
//        } else if (exception instanceof jakarta.xml.bind.PropertyException) {
//            return S(new Facades.PropertyException(S(exception)));
        }

        return S(new Facades.JAXBException(S(exception)));
    }

    static <S extends JAXBShim> Stream<S> of(Object[] objects) {
        return Shim.of(JAXBShim::of, objects);
    }

    static <S extends JAXBShim> Stream<S> of(Iterable<?> objects) {
        return Shim.of(JAXBShim::of, objects);
    }

    static <S extends JAXBShim> Class<? extends S> of(Class<S> shimType, Class<?> interfaceType) {
        return Shim.of(shimType, interfaceType);
    }

    //==================================================================================================================
    // Private Helper Methods
    //==================================================================================================================

    private static <S extends Annotation> S of(Annotation annotation) {
        if (annotation == null || annotation instanceof JAXBShim) {
            return S(annotation);
        }

        return ShimSupport.throwUnknownType(null, annotation);
    }

    @SuppressWarnings("unchecked")
    private static <S> S S(Object object) {
        return (S) object;
    }
}
