package javax.xml.bind;

import javax.shim.ShimSupport;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

/**
 * This interface contains {@link jakarta.xml.bind}-to-{@link javax.xml.bind} facades used for wrapping Jakarta XML
 *   Binding objects into their Java XML Binding counterparts.
 *
 * @deprecated Use {@link jakarta.xml.bind} instead.
 */
@Deprecated(since = "jakarta.xml.bind")
@SuppressWarnings("all")
interface Facades {
    //==================================================================================================================
    // Annotations
    //==================================================================================================================

    final class XmlAccessorOrder extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlAccessorOrder> implements javax.xml.bind.annotation.XmlAccessorOrder, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlAccessorOrder(jakarta.xml.bind.annotation.XmlAccessorOrder target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.xml.bind.annotation.XmlAccessOrder value() {
            return JAXBShim.of(target.value());
        }
    }

    final class XmlAccessorType extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlAccessorType> implements javax.xml.bind.annotation.XmlAccessorType, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessorType target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.xml.bind.annotation.XmlAccessType value() {
            return JAXBShim.of(target.value());
        }
    }

    final class XmlAnyAttribute extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlAnyAttribute> implements javax.xml.bind.annotation.XmlAnyAttribute, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlAnyAttribute(jakarta.xml.bind.annotation.XmlAnyAttribute target) {
            super(target);
        }
    }

    final class XmlAnyElement extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlAnyElement> implements javax.xml.bind.annotation.XmlAnyElement, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlAnyElement(jakarta.xml.bind.annotation.XmlAnyElement target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Class<? extends javax.xml.bind.annotation.DomHandler> value() {
            return JAXBShim.of(target.value(), javax.xml.bind.annotation.DomHandler.class);
        }

        @Override
        public boolean lax() {
            return target.lax();
        }
    }

    final class XmlAttachmentRef extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlAttachmentRef> implements javax.xml.bind.annotation.XmlAttachmentRef, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlAttachmentRef(jakarta.xml.bind.annotation.XmlAttachmentRef target) {
            super(target);
        }
    }

    final class XmlAttribute extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlAttribute> implements javax.xml.bind.annotation.XmlAttribute, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlAttribute(jakarta.xml.bind.annotation.XmlAttribute target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String name() {
            return target.name();
        }

        @Override
        public String namespace() {
            return target.namespace();
        }

        @Override
        public boolean required() {
            return target.required();
        }
    }

    final class XmlElement extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlElement> implements javax.xml.bind.annotation.XmlElement, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlElement(jakarta.xml.bind.annotation.XmlElement target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String name() {
            return target.name();
        }

        @Override
        public String namespace() {
            return target.namespace();
        }

        @Override
        public boolean nillable() {
            return target.nillable();
        }

        @Override
        public boolean required() {
            return target.required();
        }

        @Override
        public String defaultValue() {
            return target.defaultValue();
        }

        @Override
        public Class<?> type() {
            return target.type();
        }
    }

    final class XmlElementDecl extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlElementDecl> implements javax.xml.bind.annotation.XmlElementDecl, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlElementDecl(jakarta.xml.bind.annotation.XmlElementDecl target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String name() {
            return target.name();
        }

        @Override
        public String namespace() {
            return target.namespace();
        }

        @Override
        public String substitutionHeadName() {
            return target.substitutionHeadName();
        }

        @Override
        public String substitutionHeadNamespace() {
            return target.substitutionHeadNamespace();
        }

        @Override
        public String defaultValue() {
            return target.defaultValue();
        }

        @Override
        public Class<?> scope() {
            return target.scope();
        }
    }

    final class XmlElementRef extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlElementRef> implements javax.xml.bind.annotation.XmlElementRef, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlElementRef(jakarta.xml.bind.annotation.XmlElementRef target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String name() {
            return target.name();
        }

        @Override
        public String namespace() {
            return target.namespace();
        }

        @Override
        public boolean required() {
            return target.required();
        }

        @Override
        public Class<?> type() {
            return target.type();
        }
    }

    final class XmlElementRefs extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlElementRefs> implements javax.xml.bind.annotation.XmlElementRefs, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlElementRefs(jakarta.xml.bind.annotation.XmlElementRefs target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.xml.bind.annotation.XmlElementRef[] value() {
            return JAXBShim
                .of(target.value())
                .toArray(javax.xml.bind.annotation.XmlElementRef[]::new);
        }
    }

    final class XmlElements extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlElements> implements javax.xml.bind.annotation.XmlElements, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlElements(jakarta.xml.bind.annotation.XmlElements target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.xml.bind.annotation.XmlElement[] value() {
            return JAXBShim
                .of(target.value())
                .toArray(javax.xml.bind.annotation.XmlElement[]::new);
        }
    }

    final class XmlElementWrapper extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlElementWrapper> implements javax.xml.bind.annotation.XmlElementWrapper, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlElementWrapper(jakarta.xml.bind.annotation.XmlElementWrapper target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String name() {
            return target.name();
        }

        @Override
        public String namespace() {
            return target.namespace();
        }

        @Override
        public boolean nillable() {
            return target.nillable();
        }

        @Override
        public boolean required() {
            return target.required();
        }
    }

    final class XmlEnum extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlEnum> implements javax.xml.bind.annotation.XmlEnum, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlEnum(jakarta.xml.bind.annotation.XmlEnum target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Class<?> value() {
            return target.value();
        }
    }

    final class XmlEnumValue extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlEnumValue> implements javax.xml.bind.annotation.XmlEnumValue, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlEnumValue(jakarta.xml.bind.annotation.XmlEnumValue target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String value() {
            return target.value();
        }
    }

    final class XmlID extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlID> implements javax.xml.bind.annotation.XmlID, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlID(jakarta.xml.bind.annotation.XmlID target) {
            super(target);
        }
    }

    final class XmlIDREF extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlIDREF> implements javax.xml.bind.annotation.XmlIDREF, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlIDREF(jakarta.xml.bind.annotation.XmlIDREF target) {
            super(target);
        }
    }

    final class XmlInlineBinaryData extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlInlineBinaryData> implements javax.xml.bind.annotation.XmlInlineBinaryData, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlInlineBinaryData(jakarta.xml.bind.annotation.XmlInlineBinaryData target) {
            super(target);
        }
    }

    final class XmlJavaTypeAdapter extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter> implements javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlJavaTypeAdapter(jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Class<? extends javax.xml.bind.annotation.adapters.XmlAdapter> value() {
            return JAXBShim.of(target.value(), javax.xml.bind.annotation.adapters.XmlAdapter.class);
        }

        @Override
        public Class<?> type() {
            return target.type();
        }
    }

    final class XmlJavaTypeAdapters extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapters> implements javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlJavaTypeAdapters(jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapters target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter[] value() {
            return JAXBShim
                .of(target.value())
                .toArray(javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter[]::new);
        }
    }

    final class XmlList extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlList> implements javax.xml.bind.annotation.XmlList, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlList(jakarta.xml.bind.annotation.XmlList target) {
            super(target);
        }
    }

    final class XmlMimeType extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlMimeType> implements javax.xml.bind.annotation.XmlMimeType, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlMimeType(jakarta.xml.bind.annotation.XmlMimeType target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String value() {
            return target.value();
        }
    }

    final class XmlMixed extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlMixed> implements javax.xml.bind.annotation.XmlMixed, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlMixed(jakarta.xml.bind.annotation.XmlMixed target) {
            super(target);
        }
    }

    final class XmlNs extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlNs> implements javax.xml.bind.annotation.XmlNs, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlNs(jakarta.xml.bind.annotation.XmlNs target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String prefix() {
            return target.prefix();
        }

        @Override
        public String namespaceURI() {
            return target.namespaceURI();
        }
    }

    final class XmlRegistry extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlRegistry> implements javax.xml.bind.annotation.XmlRegistry, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlRegistry(jakarta.xml.bind.annotation.XmlRegistry target) {
            super(target);
        }
    }

    final class XmlRootElement extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlRootElement> implements javax.xml.bind.annotation.XmlRootElement, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlRootElement(jakarta.xml.bind.annotation.XmlRootElement target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String name() {
            return target.name();
        }

        @Override
        public String namespace() {
            return target.namespace();
        }
    }

    final class XmlSchema extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlSchema> implements javax.xml.bind.annotation.XmlSchema, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlSchema(jakarta.xml.bind.annotation.XmlSchema target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.xml.bind.annotation.XmlNs[] xmlns() {
            return JAXBShim
                .of(target.xmlns())
                .toArray(javax.xml.bind.annotation.XmlNs[]::new);
        }

        @Override
        public String namespace() {
            return target.namespace();
        }

        @Override
        public XmlNsForm elementFormDefault() {
            return JAXBShim.of(target.elementFormDefault());
        }

        @Override
        public XmlNsForm attributeFormDefault() {
            return JAXBShim.of(target.attributeFormDefault());
        }

        @Override
        public String location() {
            return target.location();
        }
    }

    final class XmlSchemaType extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlSchemaType> implements javax.xml.bind.annotation.XmlSchemaType, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlSchemaType(jakarta.xml.bind.annotation.XmlSchemaType target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String name() {
            return target.name();
        }

        @Override
        public String namespace() {
            return target.namespace();
        }

        @Override
        public Class<?> type() {
            return target.type();
        }
    }

    final class XmlSchemaTypes extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlSchemaTypes> implements javax.xml.bind.annotation.XmlSchemaTypes, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlSchemaTypes(jakarta.xml.bind.annotation.XmlSchemaTypes target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.xml.bind.annotation.XmlSchemaType[] value() {
            return JAXBShim
                .of(target.value())
                .toArray(javax.xml.bind.annotation.XmlSchemaType[]::new);
        }
    }

    final class XmlSeeAlso extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlSeeAlso> implements javax.xml.bind.annotation.XmlSeeAlso, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlSeeAlso(jakarta.xml.bind.annotation.XmlSeeAlso target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Class<?>[] value() {
            return target.value();
        }
    }

    final class XmlTransient extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlTransient> implements javax.xml.bind.annotation.XmlTransient, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlTransient(jakarta.xml.bind.annotation.XmlTransient target) {
            super(target);
        }
    }

    final class XmlType extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlType> implements javax.xml.bind.annotation.XmlType, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlType(jakarta.xml.bind.annotation.XmlType target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String name() {
            return target.name();
        }

        @Override
        public String namespace() {
            return target.namespace();
        }

        @Override
        public String[] propOrder() {
            return target.propOrder();
        }

        @Override
        public Class<?> factoryClass() {
            return target.factoryClass();
        }

        @Override
        public String factoryMethod() {
            return target.factoryMethod();
        }
    }

    final class XmlValue extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlValue> implements javax.xml.bind.annotation.XmlValue, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlValue(jakarta.xml.bind.annotation.XmlValue target) {
            super(target);
        }
    }

    //==================================================================================================================
    // Classes
    //==================================================================================================================

    final class CollapsedStringAdapter extends javax.xml.bind.annotation.adapters.CollapsedStringAdapter {
        private final jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        CollapsedStringAdapter(jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String unmarshal(String string) {
            return target.unmarshal(string);
        }

        @Override
        public String marshal(String string) {
            return target.marshal(string);
        }
    }

    final class DataBindingException extends javax.xml.bind.DataBindingException {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        private final jakarta.xml.bind.DataBindingException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        DataBindingException(jakarta.xml.bind.DataBindingException target) {
            super(target.getMessage(), target.getCause());
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public String getLocalizedMessage() {
            return target.getLocalizedMessage();
        }

        @Override
        public Throwable getCause() {
            return target.getCause();
        }

        @Override
        public Throwable initCause(Throwable cause) {
            return target.initCause(cause);
        }

        @Override
        public String toString() {
            return target.toString();
        }

        @Override
        public void printStackTrace() {
            target.printStackTrace();
        }

        @Override
        public void printStackTrace(PrintStream s) {
            target.printStackTrace(s);
        }

        @Override
        public void printStackTrace(PrintWriter s) {
            target.printStackTrace(s);
        }

        @Override
        public Throwable fillInStackTrace() {
            try {
                return super.fillInStackTrace();
            } finally {
                if (target != null) {
                    target.fillInStackTrace();
                }
            }
        }

        @Override
        public StackTraceElement[] getStackTrace() {
            return target.getStackTrace();
        }

        @Override
        public void setStackTrace(StackTraceElement[] stackTrace) {
            target.setStackTrace(stackTrace);
        }
    }

    final class DatatypeConverterInterface extends JAXBShim.Facade<jakarta.xml.bind.DatatypeConverterInterface> implements javax.xml.bind.DatatypeConverterInterface {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        DatatypeConverterInterface(jakarta.xml.bind.DatatypeConverterInterface target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String parseString(String lexicalXSDString) {
            return target.parseString(lexicalXSDString);
        }

        @Override
        public BigInteger parseInteger(String lexicalXSDInteger) {
            return target.parseInteger(lexicalXSDInteger);
        }

        @Override
        public int parseInt(String lexicalXSDInt) {
            return target.parseInt(lexicalXSDInt);
        }

        @Override
        public long parseLong(String lexicalXSDLong) {
            return target.parseLong(lexicalXSDLong);
        }

        @Override
        public short parseShort(String lexicalXSDShort) {
            return target.parseShort(lexicalXSDShort);
        }

        @Override
        public BigDecimal parseDecimal(String lexicalXSDDecimal) {
            return target.parseDecimal(lexicalXSDDecimal);
        }

        @Override
        public float parseFloat(String lexicalXSDFloat) {
            return target.parseFloat(lexicalXSDFloat);
        }

        @Override
        public double parseDouble(String lexicalXSDDouble) {
            return target.parseDouble(lexicalXSDDouble);
        }

        @Override
        public boolean parseBoolean(String lexicalXSDBoolean) {
            return target.parseBoolean(lexicalXSDBoolean);
        }

        @Override
        public byte parseByte(String lexicalXSDByte) {
            return target.parseByte(lexicalXSDByte);
        }

        @Override
        public QName parseQName(String lexicalXSDQName, NamespaceContext nsc) {
            return target.parseQName(lexicalXSDQName, nsc);
        }

        @Override
        public Calendar parseDateTime(String lexicalXSDDateTime) {
            return target.parseDateTime(lexicalXSDDateTime);
        }

        @Override
        public byte[] parseBase64Binary(String lexicalXSDBase64Binary) {
            return target.parseBase64Binary(lexicalXSDBase64Binary);
        }

        @Override
        public byte[] parseHexBinary(String lexicalXSDHexBinary) {
            return target.parseHexBinary(lexicalXSDHexBinary);
        }

        @Override
        public long parseUnsignedInt(String lexicalXSDUnsignedInt) {
            return target.parseUnsignedInt(lexicalXSDUnsignedInt);
        }

        @Override
        public int parseUnsignedShort(String lexicalXSDUnsignedShort) {
            return target.parseUnsignedShort(lexicalXSDUnsignedShort);
        }

        @Override
        public Calendar parseTime(String lexicalXSDTime) {
            return target.parseTime(lexicalXSDTime);
        }

        @Override
        public Calendar parseDate(String lexicalXSDDate) {
            return target.parseDate(lexicalXSDDate);
        }

        @Override
        public String parseAnySimpleType(String lexicalXSDAnySimpleType) {
            return target.parseAnySimpleType(lexicalXSDAnySimpleType);
        }

        @Override
        public String printString(String val) {
            return target.printString(val);
        }

        @Override
        public String printInteger(BigInteger val) {
            return target.printInteger(val);
        }

        @Override
        public String printInt(int val) {
            return target.printInt(val);
        }

        @Override
        public String printLong(long val) {
            return target.printLong(val);
        }

        @Override
        public String printShort(short val) {
            return target.printShort(val);
        }

        @Override
        public String printDecimal(BigDecimal val) {
            return target.printDecimal(val);
        }

        @Override
        public String printFloat(float val) {
            return target.printFloat(val);
        }

        @Override
        public String printDouble(double val) {
            return target.printDouble(val);
        }

        @Override
        public String printBoolean(boolean val) {
            return target.printBoolean(val);
        }

        @Override
        public String printByte(byte val) {
            return target.printByte(val);
        }

        @Override
        public String printQName(QName val, NamespaceContext nsc) {
            return target.printQName(val, nsc);
        }

        @Override
        public String printDateTime(Calendar val) {
            return target.printDateTime(val);
        }

        @Override
        public String printBase64Binary(byte[] val) {
            return target.printBase64Binary(val);
        }

        @Override
        public String printHexBinary(byte[] val) {
            return target.printHexBinary(val);
        }

        @Override
        public String printUnsignedInt(long val) {
            return target.printUnsignedInt(val);
        }

        @Override
        public String printUnsignedShort(int val) {
            return target.printUnsignedShort(val);
        }

        @Override
        public String printTime(Calendar val) {
            return target.printTime(val);
        }

        @Override
        public String printDate(Calendar val) {
            return target.printDate(val);
        }

        @Override
        public String printAnySimpleType(String val) {
            return target.printAnySimpleType(val);
        }
    }

    final class HexBinaryAdapter extends javax.xml.bind.annotation.adapters.HexBinaryAdapter {
        private final jakarta.xml.bind.annotation.adapters.HexBinaryAdapter target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        HexBinaryAdapter(jakarta.xml.bind.annotation.adapters.HexBinaryAdapter target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public byte[] unmarshal(String string) {
            return target.unmarshal(string);
        }

        @Override
        public String marshal(byte[] bytes) {
            return target.marshal(bytes);
        }
    }

    final class JAXBElement<T> extends javax.xml.bind.JAXBElement<T> {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        private final jakarta.xml.bind.JAXBElement<T> target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        JAXBElement(jakarta.xml.bind.JAXBElement<T> target) {
            super(target.getName(), target.getDeclaredType(), target.getScope(), target.getValue());
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public QName getName() {
            return target.getName();
        }

        @Override
        public Class<T> getDeclaredType() {
            return target.getDeclaredType();
        }

        @Override
        public Class<?> getScope() {
            return target.getScope();
        }

        @Override
        public T getValue() {
            return target.getValue();
        }

        @Override
        public void setValue(T value) {
            target.setValue(value);
        }

        @Override
        public boolean isNil() {
            return target.isNil();
        }

        @Override
        public void setNil(boolean nil) {
            super.setNil(nil);
        }

        @Override
        public boolean isGlobalScope() {
            return target.isGlobalScope();
        }

        @Override
        public boolean isTypeSubstituted() {
            return target.isTypeSubstituted();
        }
    }

    final class JAXBException extends javax.xml.bind.JAXBException {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        private final jakarta.xml.bind.JAXBException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        JAXBException(jakarta.xml.bind.JAXBException target) {
            super(target.getMessage(), target.getErrorCode(), target.getCause());
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getErrorCode() {
            return target.getErrorCode();
        }

        @Override
        public Throwable getLinkedException() {
            return target.getLinkedException();
        }

        @Override
        public void setLinkedException(Throwable exception) {
            target.setLinkedException(exception);
        }

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public String getLocalizedMessage() {
            return target.getLocalizedMessage();
        }

        @Override
        public Throwable getCause() {
            return target.getCause();
        }

        @Override
        public Throwable initCause(Throwable cause) {
            return target.initCause(cause);
        }

        @Override
        public String toString() {
            return target.toString();
        }

        @Override
        public void printStackTrace() {
            target.printStackTrace();
        }

        @Override
        public void printStackTrace(PrintStream s) {
            target.printStackTrace(s);
        }

        @Override
        public void printStackTrace(PrintWriter s) {
            target.printStackTrace(s);
        }

        @Override
        public Throwable fillInStackTrace() {
            try {
                return super.fillInStackTrace();
            } finally {
                if (target != null) {
                    target.fillInStackTrace();
                }
            }
        }

        @Override
        public StackTraceElement[] getStackTrace() {
            return target.getStackTrace();
        }

        @Override
        public void setStackTrace(StackTraceElement[] stackTrace) {
            target.setStackTrace(stackTrace);
        }
    }

    final class MarshalException extends javax.xml.bind.MarshalException {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        private final jakarta.xml.bind.MarshalException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        MarshalException(jakarta.xml.bind.MarshalException target) {
            super(target.getMessage(), target.getErrorCode(), target.getCause());
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getErrorCode() {
            return target.getErrorCode();
        }

        @Override
        public Throwable getLinkedException() {
            return target.getLinkedException();
        }

        @Override
        public void setLinkedException(Throwable exception) {
            target.setLinkedException(exception);
        }

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public String getLocalizedMessage() {
            return target.getLocalizedMessage();
        }

        @Override
        public Throwable getCause() {
            return target.getCause();
        }

        @Override
        public Throwable initCause(Throwable cause) {
            return target.initCause(cause);
        }

        @Override
        public String toString() {
            return target.toString();
        }

        @Override
        public void printStackTrace() {
            target.printStackTrace();
        }

        @Override
        public void printStackTrace(PrintStream s) {
            target.printStackTrace(s);
        }

        @Override
        public void printStackTrace(PrintWriter s) {
            target.printStackTrace(s);
        }

        @Override
        public Throwable fillInStackTrace() {
            try {
                return super.fillInStackTrace();
            } finally {
                if (target != null) {
                    target.fillInStackTrace();
                }
            }
        }

        @Override
        public StackTraceElement[] getStackTrace() {
            return target.getStackTrace();
        }

        @Override
        public void setStackTrace(StackTraceElement[] stackTrace) {
            target.setStackTrace(stackTrace);
        }
    }

    final class NormalizedStringAdapter extends javax.xml.bind.annotation.adapters.NormalizedStringAdapter {
        private final jakarta.xml.bind.annotation.adapters.NormalizedStringAdapter target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        NormalizedStringAdapter(jakarta.xml.bind.annotation.adapters.NormalizedStringAdapter target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String unmarshal(String string) {
            return target.unmarshal(string);
        }

        @Override
        public String marshal(String string) {
            return target.marshal(string);
        }
    }

    final class PropertyException extends javax.xml.bind.PropertyException {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        private final jakarta.xml.bind.PropertyException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        PropertyException(jakarta.xml.bind.PropertyException target) {
            super(target.getMessage(), target.getErrorCode(), target.getCause());
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getErrorCode() {
            return target.getErrorCode();
        }

        @Override
        public Throwable getLinkedException() {
            return target.getLinkedException();
        }

        @Override
        public void setLinkedException(Throwable exception) {
            target.setLinkedException(exception);
        }

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public String getLocalizedMessage() {
            return target.getLocalizedMessage();
        }

        @Override
        public Throwable getCause() {
            return target.getCause();
        }

        @Override
        public Throwable initCause(Throwable cause) {
            return target.initCause(cause);
        }

        @Override
        public String toString() {
            return target.toString();
        }

        @Override
        public void printStackTrace() {
            target.printStackTrace();
        }

        @Override
        public void printStackTrace(PrintStream s) {
            target.printStackTrace(s);
        }

        @Override
        public void printStackTrace(PrintWriter s) {
            target.printStackTrace(s);
        }

        @Override
        public Throwable fillInStackTrace() {
            try {
                return super.fillInStackTrace();
            } finally {
                if (target != null) {
                    target.fillInStackTrace();
                }
            }
        }

        @Override
        public StackTraceElement[] getStackTrace() {
            return target.getStackTrace();
        }

        @Override
        public void setStackTrace(StackTraceElement[] stackTrace) {
            target.setStackTrace(stackTrace);
        }
    }

    final class TypeConstraintException extends javax.xml.bind.TypeConstraintException {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        private final jakarta.xml.bind.TypeConstraintException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        TypeConstraintException(jakarta.xml.bind.TypeConstraintException target) {
            super(target.getMessage(), target.getCause());
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public String getLocalizedMessage() {
            return target.getLocalizedMessage();
        }

        @Override
        public Throwable getCause() {
            return target.getCause();
        }

        @Override
        public Throwable initCause(Throwable cause) {
            return target.initCause(cause);
        }

        @Override
        public String toString() {
            return target.toString();
        }

        @Override
        public void printStackTrace() {
            target.printStackTrace();
        }

        @Override
        public void printStackTrace(PrintStream s) {
            target.printStackTrace(s);
        }

        @Override
        public void printStackTrace(PrintWriter s) {
            target.printStackTrace(s);
        }

        @Override
        public Throwable fillInStackTrace() {
            try {
                return super.fillInStackTrace();
            } finally {
                if (target != null) {
                    target.fillInStackTrace();
                }
            }
        }

        @Override
        public StackTraceElement[] getStackTrace() {
            return target.getStackTrace();
        }

        @Override
        public void setStackTrace(StackTraceElement[] stackTrace) {
            target.setStackTrace(stackTrace);
        }
    }

    final class UnmarshalException extends javax.xml.bind.UnmarshalException {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        private final jakarta.xml.bind.UnmarshalException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        UnmarshalException(jakarta.xml.bind.UnmarshalException target) {
            super(target.getMessage(), target.getErrorCode(), target.getCause());
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getErrorCode() {
            return target.getErrorCode();
        }

        @Override
        public Throwable getLinkedException() {
            return target.getLinkedException();
        }

        @Override
        public void setLinkedException(Throwable exception) {
            target.setLinkedException(exception);
        }

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public String getLocalizedMessage() {
            return target.getLocalizedMessage();
        }

        @Override
        public Throwable getCause() {
            return target.getCause();
        }

        @Override
        public Throwable initCause(Throwable cause) {
            return target.initCause(cause);
        }

        @Override
        public String toString() {
            return target.toString();
        }

        @Override
        public void printStackTrace() {
            target.printStackTrace();
        }

        @Override
        public void printStackTrace(PrintStream s) {
            target.printStackTrace(s);
        }

        @Override
        public void printStackTrace(PrintWriter s) {
            target.printStackTrace(s);
        }

        @Override
        public Throwable fillInStackTrace() {
            try {
                return super.fillInStackTrace();
            } finally {
                if (target != null) {
                    target.fillInStackTrace();
                }
            }
        }

        @Override
        public StackTraceElement[] getStackTrace() {
            return target.getStackTrace();
        }

        @Override
        public void setStackTrace(StackTraceElement[] stackTrace) {
            target.setStackTrace(stackTrace);
        }
    }

    final class ValidationException extends javax.xml.bind.ValidationException {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        private final jakarta.xml.bind.ValidationException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ValidationException(jakarta.xml.bind.ValidationException target) {
            super(target.getMessage(), target.getErrorCode(), target.getCause());
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getErrorCode() {
            return target.getErrorCode();
        }

        @Override
        public Throwable getLinkedException() {
            return target.getLinkedException();
        }

        @Override
        public void setLinkedException(Throwable exception) {
            target.setLinkedException(exception);
        }

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public String getLocalizedMessage() {
            return target.getLocalizedMessage();
        }

        @Override
        public Throwable getCause() {
            return target.getCause();
        }

        @Override
        public Throwable initCause(Throwable cause) {
            return target.initCause(cause);
        }

        @Override
        public String toString() {
            return target.toString();
        }

        @Override
        public void printStackTrace() {
            target.printStackTrace();
        }

        @Override
        public void printStackTrace(PrintStream s) {
            target.printStackTrace(s);
        }

        @Override
        public void printStackTrace(PrintWriter s) {
            target.printStackTrace(s);
        }

        @Override
        public Throwable fillInStackTrace() {
            try {
                return super.fillInStackTrace();
            } finally {
                if (target != null) {
                    target.fillInStackTrace();
                }
            }
        }

        @Override
        public StackTraceElement[] getStackTrace() {
            return target.getStackTrace();
        }

        @Override
        public void setStackTrace(StackTraceElement[] stackTrace) {
            target.setStackTrace(stackTrace);
        }
    }

    final class XmlAdapter<ValueType, BoundType> extends javax.xml.bind.annotation.adapters.XmlAdapter<ValueType, BoundType> {
        private final jakarta.xml.bind.annotation.adapters.XmlAdapter<ValueType, BoundType> target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlAdapter(jakarta.xml.bind.annotation.adapters.XmlAdapter<ValueType, BoundType> target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public BoundType unmarshal(ValueType value) throws Exception {
            return target.unmarshal(value);
        }

        @Override
        public ValueType marshal(BoundType value) throws Exception {
            return target.marshal(value);
        }
    }
}
