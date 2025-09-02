package javax.jws;

import javax.jws.soap.SOAPBinding;
import javax.shim.Shim;
import javax.shim.ShimSupport;
import java.lang.annotation.Annotation;
import java.util.stream.Stream;

/**
 * @deprecated Use {@link jakarta.jws} instead.
 */
@Deprecated(since = "jakarta.jws")
public interface JWSShim extends Shim {
    //==================================================================================================================
    // Helper Methods
    //==================================================================================================================

    static void initialize() {
        Shim.initialize();
    }

    //==================================================================================================================
    // Factory Methods
    //==================================================================================================================

    @SuppressWarnings("rawtypes")
    static <S extends JWSShim> S of(Object object) {
        if (object == null || object instanceof JWSShim) {
            return S(object);
        } else if (object instanceof java.lang.Enum<?>) {
            return S(of((java.lang.Enum) object));
        } else if (object instanceof Annotation) {
            return S(of((Annotation) object));
        }

        return ShimSupport.throwUnknownType(null, object);
    }

    static <S extends JWSShim> Stream<S> of(Object[] objects) {
        return Shim.of(JWSShim::of, objects);
    }

    static <S extends JWSShim> Stream<S> of(Iterable<?> objects) {
        return Shim.of(JWSShim::of, objects);
    }

    static <S extends JWSShim> Class<? extends S> of(Class<S> shimType, Class<?> interfaceType) {
        return Shim.of(shimType, interfaceType);
    }

    //==================================================================================================================
    // Enum-specific Implementation
    //==================================================================================================================

    /**
     * @deprecated Use {@link jakarta.jws} instead.
     */
    @Deprecated(since = "jakarta.jws")
    interface Enum<E extends java.lang.Enum<E>> extends JWSShim, Shim.Enum<E> { }

    //==================================================================================================================
    // Private Helper Methods
    //==================================================================================================================

    private static <S extends java.lang.Enum<S>> S of(java.lang.Enum<?> enumeration) {
        if (enumeration == null || enumeration instanceof JWSShim) {
            return S(enumeration);
        } else if (enumeration instanceof jakarta.jws.soap.SOAPBinding.ParameterStyle) {
            return S(SOAPBinding.ParameterStyle.valueOf(enumeration.name()));
        } else if (enumeration instanceof jakarta.jws.soap.SOAPBinding.Style) {
            return S(SOAPBinding.Style.valueOf(enumeration.name()));
        } else if (enumeration instanceof jakarta.jws.soap.SOAPBinding.Use) {
            return S(SOAPBinding.Use.valueOf(enumeration.name()));
        } else if (enumeration instanceof jakarta.jws.WebParam.Mode) {
            return S(WebParam.Mode.valueOf(enumeration.name()));
        }

        return ShimSupport.throwUnknownType(null, enumeration);
    }

    private static <S extends Annotation> S of(Annotation annotation) {
        if (annotation == null || annotation instanceof JWSShim) {
            return S(annotation);
        } else if (annotation instanceof jakarta.jws.HandlerChain) {
            return S(new Facades.HandlerChain(S(annotation)));
        } else if (annotation instanceof jakarta.jws.soap.InitParam) {
            return S(new Facades.InitParam(S(annotation)));
        } else if (annotation instanceof jakarta.jws.Oneway) {
            return S(new Facades.Oneway(S(annotation)));
        } else if (annotation instanceof jakarta.jws.soap.SOAPBinding) {
            return S(new Facades.SOAPBinding(S(annotation)));
        } else if (annotation instanceof jakarta.jws.soap.SOAPMessageHandler) {
            return S(new Facades.SOAPMessageHandler(S(annotation)));
        } else if (annotation instanceof jakarta.jws.soap.SOAPMessageHandlers) {
            return S(new Facades.SOAPMessageHandlers(S(annotation)));
        } else if (annotation instanceof jakarta.jws.WebMethod) {
            return S(new Facades.WebMethod(S(annotation)));
        } else if (annotation instanceof jakarta.jws.WebParam) {
            return S(new Facades.WebParam(S(annotation)));
        } else if (annotation instanceof jakarta.jws.WebResult) {
            return S(new Facades.WebResult(S(annotation)));
        } else if (annotation instanceof jakarta.jws.WebService) {
            return S(new Facades.WebService(S(annotation)));
        }

        return ShimSupport.throwUnknownType(null, annotation);
    }

    @SuppressWarnings("unchecked")
    private static <S> S S(Object object) {
        return (S) object;
    }
}
