package javax.xml.bind;

import javax.shim.Shim;
import javax.shim.ShimSupport;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.helpers.AbstractMarshallerImpl;
import javax.xml.bind.helpers.AbstractUnmarshallerImpl;
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
        try {
            ShimSupport.ensureInitialized(
                JAXB.class, JAXBContext.class, JAXBContextFactory.class, JAXBElement.class, JAXBException.class,
                Marshaller.class, Unmarshaller.class, AbstractMarshallerImpl.class, AbstractUnmarshallerImpl.class,
                DatatypeConverter.class, DatatypeConverterInterface.class, Binder.class, XmlAdapter.class,
                XmlElement.class, XmlRootElement.class, XmlType.class, XmlJavaTypeAdapter.class
            );
        } finally {
            Shim.initialize();
        }
    }

    //==================================================================================================================
    // Factory Methods
    //==================================================================================================================

    @SuppressWarnings("rawtypes")
    static <S extends JAXBShim> S of(Object object) {
        //==============================================================================================================
        // Specializations
        //==============================================================================================================

        if (object == null || object instanceof JAXBShim) {
            return S(object);
        } else if (object instanceof jakarta.xml.bind.JAXBException) {
            return S(of((jakarta.xml.bind.JAXBException) object));
        } else if (object instanceof java.lang.Enum<?>) {
            return S(of((java.lang.Enum) object));
        } else if (object instanceof Annotation) {
            return S(of((Annotation) object));
        } else if (object instanceof jakarta.xml.bind.annotation.adapters.XmlAdapter<?, ?>) {
            return S(of((jakarta.xml.bind.annotation.adapters.XmlAdapter<?, ?>) object));

        //==============================================================================================================
        // Core
        //==============================================================================================================

        } else if (object instanceof jakarta.xml.bind.DataBindingException) {
            return S(new Facades.DataBindingException(S(object)));
        } else if (object instanceof jakarta.xml.bind.DatatypeConverterInterface) {
            return S(new Facades.DatatypeConverterInterface(S(object)));
        } else if (object instanceof jakarta.xml.bind.JAXBElement<?>) {
            return S(new Facades.JAXBElement<>(S(object)));
        } else if (object instanceof jakarta.xml.bind.TypeConstraintException) {
            return S(new Facades.TypeConstraintException(S(object)));
        }

        return ShimSupport.throwUnknownType(null, object);
    }

    static <S extends JAXBException> S of(jakarta.xml.bind.JAXBException exception) {
        if (exception == null || exception instanceof JAXBShim) {
            return S(exception);
        } else if (exception instanceof jakarta.xml.bind.MarshalException) {
            return S(new Facades.MarshalException(S(exception)));
        } else if (exception instanceof jakarta.xml.bind.PropertyException) {
            return S(new Facades.PropertyException(S(exception)));
        } else if (exception instanceof jakarta.xml.bind.UnmarshalException) {
            return S(new Facades.UnmarshalException(S(exception)));
        } else if (exception instanceof jakarta.xml.bind.ValidationException) {
            return S(new Facades.ValidationException(S(exception)));
        }

        return S(new Facades.JAXBException(S(exception)));
    }

    static <S extends JAXBShim> Stream<S> of(Object[] objects) {
        return Shim.of(JAXBShim::of, objects);
    }

    static <S extends JAXBShim> Stream<S> of(Iterable<?> objects) {
        return Shim.of(JAXBShim::of, objects);
    }

    static <S extends JAXBShim> Class<? extends S> of(Class<?> baseType, Class<S> shimType) {
        return Shim.of(baseType, shimType);
    }

    //==================================================================================================================
    // Private Helper Methods
    //==================================================================================================================

    private static <S extends java.lang.Enum<S>> S of(java.lang.Enum<?> enumeration) {
        if (enumeration == null || enumeration instanceof JAXBShim) {
            return S(enumeration);
        } else if (enumeration instanceof jakarta.xml.bind.annotation.XmlAccessOrder) {
            return S(XmlAccessOrder.valueOf(enumeration.name()));
        } else if (enumeration instanceof jakarta.xml.bind.annotation.XmlAccessType) {
            return S(XmlAccessType.valueOf(enumeration.name()));
        } else if (enumeration instanceof jakarta.xml.bind.annotation.XmlNsForm) {
            return S(XmlNsForm.valueOf(enumeration.name()));
        }

        return ShimSupport.throwUnknownType(null, enumeration);
    }

    private static <S extends Annotation> S of(Annotation annotation) {
        if (annotation == null || annotation instanceof JAXBShim) {
            return S(annotation);
        } else if (annotation instanceof jakarta.xml.bind.annotation.XmlAccessorOrder) {
            return S(new Facades.XmlAccessorOrder(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.XmlAccessorType) {
            return S(new Facades.XmlAccessorType(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.XmlAnyAttribute) {
            return S(new Facades.XmlAnyAttribute(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.XmlAnyElement) {
            return S(new Facades.XmlAnyElement(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.XmlAttachmentRef) {
            return S(new Facades.XmlAttachmentRef(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.XmlAttribute) {
            return S(new Facades.XmlAttribute(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.XmlElement) {
            return S(new Facades.XmlElement(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.XmlElementDecl) {
            return S(new Facades.XmlElementDecl(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.XmlElementRef) {
            return S(new Facades.XmlElementRef(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.XmlElementRefs) {
            return S(new Facades.XmlElementRefs(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.XmlElements) {
            return S(new Facades.XmlElements(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.XmlElementWrapper) {
            return S(new Facades.XmlElementWrapper(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.XmlEnum) {
            return S(new Facades.XmlEnum(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.XmlEnumValue) {
            return S(new Facades.XmlEnumValue(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.XmlID) {
            return S(new Facades.XmlID(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.XmlIDREF) {
            return S(new Facades.XmlIDREF(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.XmlInlineBinaryData) {
            return S(new Facades.XmlInlineBinaryData(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter) {
            return S(new Facades.XmlJavaTypeAdapter(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapters) {
            return S(new Facades.XmlJavaTypeAdapters(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.XmlList) {
            return S(new Facades.XmlList(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.XmlMimeType) {
            return S(new Facades.XmlMimeType(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.XmlMixed) {
            return S(new Facades.XmlMixed(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.XmlNs) {
            return S(new Facades.XmlNs(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.XmlRegistry) {
            return S(new Facades.XmlRegistry(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.XmlRootElement) {
            return S(new Facades.XmlRootElement(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.XmlSchema) {
            return S(new Facades.XmlSchema(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.XmlSchemaType) {
            return S(new Facades.XmlSchemaType(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.XmlSchemaTypes) {
            return S(new Facades.XmlSchemaTypes(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.XmlSeeAlso) {
            return S(new Facades.XmlSeeAlso(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.XmlTransient) {
            return S(new Facades.XmlTransient(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.XmlType) {
            return S(new Facades.XmlType(S(annotation)));
        } else if (annotation instanceof jakarta.xml.bind.annotation.XmlValue) {
            return S(new Facades.XmlValue(S(annotation)));
        }

        return ShimSupport.throwUnknownType(null, annotation);
    }

    private static <S extends XmlAdapter<?, ?>> S of(jakarta.xml.bind.annotation.adapters.XmlAdapter<?, ?> adapter) {
        if (adapter == null || adapter instanceof JAXBShim) {
            return S(adapter);
        } else if (adapter instanceof jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter) {
            return S(new Facades.CollapsedStringAdapter(S(adapter)));
        } else if (adapter instanceof jakarta.xml.bind.annotation.adapters.HexBinaryAdapter) {
            return S(new Facades.HexBinaryAdapter(S(adapter)));
        } else if (adapter instanceof jakarta.xml.bind.annotation.adapters.NormalizedStringAdapter) {
            return S(new Facades.NormalizedStringAdapter(S(adapter)));
        }

        return S(new Facades.XmlAdapter<>(S(adapter)));
    }

    @SuppressWarnings("unchecked")
    private static <S> S S(Object object) {
        return (S) object;
    }
}
