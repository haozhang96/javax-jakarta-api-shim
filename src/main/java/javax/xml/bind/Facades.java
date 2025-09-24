package javax.xml.bind;

import org.w3c.dom.Node;
import org.xml.sax.*;

import javax.shim.ShimSupport;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.validation.Schema;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.security.Permission;
import java.security.PermissionCollection;
import java.util.Calendar;
import java.util.Map;

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
        public javax.xml.bind.annotation.XmlNsForm elementFormDefault() {
            return JAXBShim.of(target.elementFormDefault());
        }

        @Override
        public javax.xml.bind.annotation.XmlNsForm attributeFormDefault() {
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

    final class Binder<XmlNode> extends javax.xml.bind.Binder<XmlNode> {
        private final jakarta.xml.bind.Binder<XmlNode> target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Binder(jakarta.xml.bind.Binder<XmlNode> target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Object unmarshal(XmlNode xmlNode) throws javax.xml.bind.JAXBException {
            try {
                return target.unmarshal(xmlNode);
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public <T> javax.xml.bind.JAXBElement<T> unmarshal(
            XmlNode xmlNode,
            Class<T> declaredType
        ) throws javax.xml.bind.JAXBException {
            try {
                return JAXBShim.of(target.unmarshal(xmlNode, declaredType));
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public void marshal(Object jaxbObject, XmlNode xmlNode) throws javax.xml.bind.JAXBException {
            try {
                target.marshal(jaxbObject, xmlNode);
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public XmlNode getXMLNode(Object jaxbObject) {
            return target.getXMLNode(jaxbObject);
        }

        @Override
        public Object getJAXBNode(XmlNode xmlNode) {
            return target.getJAXBNode(xmlNode);
        }

        @Override
        public XmlNode updateXML(Object jaxbObject) throws javax.xml.bind.JAXBException {
            try {
                return target.updateXML(jaxbObject);
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public XmlNode updateXML(Object jaxbObject, XmlNode xmlNode) throws javax.xml.bind.JAXBException {
            try {
                return target.updateXML(jaxbObject, xmlNode);
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public Object updateJAXB(XmlNode xmlNode) throws javax.xml.bind.JAXBException {
            try {
                return target.updateJAXB(xmlNode);
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public javax.xml.bind.ValidationEventHandler getEventHandler() throws javax.xml.bind.JAXBException {
            try {
                return JAXBShim.of(target.getEventHandler());
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public void setEventHandler(javax.xml.bind.ValidationEventHandler handler) throws javax.xml.bind.JAXBException {
            try {
                target.setEventHandler(handler);
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public void setEventHandler(jakarta.xml.bind.ValidationEventHandler handler) throws javax.xml.bind.JAXBException {
            try {
                target.setEventHandler(handler);
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public Object getProperty(String name) throws jakarta.xml.bind.PropertyException {
            return target.getProperty(name);
        }

        @Override
        public void setProperty(String name, Object value) throws jakarta.xml.bind.PropertyException {
            target.setProperty(name, value);
        }

        @Override
        public Schema getSchema() {
            return target.getSchema();
        }

        @Override
        public void setSchema(Schema schema) {
            target.setSchema(schema);
        }
    }

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
        public String printString(String value) {
            return target.printString(value);
        }

        @Override
        public byte[] parseBase64Binary(String lexicalXSDBase64Binary) {
            return target.parseBase64Binary(lexicalXSDBase64Binary);
        }

        @Override
        public String printBase64Binary(byte[] value) {
            return target.printBase64Binary(value);
        }

        @Override
        public byte[] parseHexBinary(String lexicalXSDHexBinary) {
            return target.parseHexBinary(lexicalXSDHexBinary);
        }

        @Override
        public String printHexBinary(byte[] value) {
            return target.printHexBinary(value);
        }

        @Override
        public boolean parseBoolean(String lexicalXSDBoolean) {
            return target.parseBoolean(lexicalXSDBoolean);
        }

        @Override
        public String printBoolean(boolean value) {
            return target.printBoolean(value);
        }

        @Override
        public byte parseByte(String lexicalXSDByte) {
            return target.parseByte(lexicalXSDByte);
        }

        @Override
        public String printByte(byte value) {
            return target.printByte(value);
        }

        @Override
        public short parseShort(String lexicalXSDShort) {
            return target.parseShort(lexicalXSDShort);
        }

        @Override
        public String printShort(short value) {
            return target.printShort(value);
        }

        @Override
        public int parseUnsignedShort(String lexicalXSDUnsignedShort) {
            return target.parseUnsignedShort(lexicalXSDUnsignedShort);
        }

        @Override
        public String printUnsignedShort(int value) {
            return target.printUnsignedShort(value);
        }

        @Override
        public int parseInt(String lexicalXSDInt) {
            return target.parseInt(lexicalXSDInt);
        }

        @Override
        public String printInt(int value) {
            return target.printInt(value);
        }

        @Override
        public long parseUnsignedInt(String lexicalXSDUnsignedInt) {
            return target.parseUnsignedInt(lexicalXSDUnsignedInt);
        }

        @Override
        public String printUnsignedInt(long value) {
            return target.printUnsignedInt(value);
        }

        @Override
        public long parseLong(String lexicalXSDLong) {
            return target.parseLong(lexicalXSDLong);
        }

        @Override
        public String printLong(long value) {
            return target.printLong(value);
        }

        @Override
        public float parseFloat(String lexicalXSDFloat) {
            return target.parseFloat(lexicalXSDFloat);
        }

        @Override
        public String printFloat(float value) {
            return target.printFloat(value);
        }

        @Override
        public double parseDouble(String lexicalXSDDouble) {
            return target.parseDouble(lexicalXSDDouble);
        }

        @Override
        public String printDouble(double value) {
            return target.printDouble(value);
        }

        @Override
        public BigInteger parseInteger(String lexicalXSDInteger) {
            return target.parseInteger(lexicalXSDInteger);
        }

        @Override
        public String printInteger(BigInteger value) {
            return target.printInteger(value);
        }

        @Override
        public BigDecimal parseDecimal(String lexicalXSDDecimal) {
            return target.parseDecimal(lexicalXSDDecimal);
        }

        @Override
        public String printDecimal(BigDecimal value) {
            return target.printDecimal(value);
        }

        @Override
        public Calendar parseDate(String lexicalXSDDate) {
            return target.parseDate(lexicalXSDDate);
        }

        @Override
        public String printDate(Calendar value) {
            return target.printDate(value);
        }

        @Override
        public Calendar parseTime(String lexicalXSDTime) {
            return target.parseTime(lexicalXSDTime);
        }

        @Override
        public String printTime(Calendar value) {
            return target.printTime(value);
        }

        @Override
        public Calendar parseDateTime(String lexicalXSDDateTime) {
            return target.parseDateTime(lexicalXSDDateTime);
        }

        @Override
        public String printDateTime(Calendar value) {
            return target.printDateTime(value);
        }

        @Override
        public QName parseQName(String lexicalXSDQName, NamespaceContext namespaceContext) {
            return target.parseQName(lexicalXSDQName, namespaceContext);
        }

        @Override
        public String printQName(QName value, NamespaceContext namespaceContext) {
            return target.printQName(value, namespaceContext);
        }

        @Override
        public String parseAnySimpleType(String lexicalXSDAnySimpleType) {
            return target.parseAnySimpleType(lexicalXSDAnySimpleType);
        }

        @Override
        public String printAnySimpleType(String value) {
            return target.printAnySimpleType(value);
        }
    }

    final class Element extends JAXBShim.Facade<jakarta.xml.bind.Element> implements javax.xml.bind.Element {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Element(jakarta.xml.bind.Element target) {
            super(target);
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

    final class JAXBContext extends javax.xml.bind.JAXBContext {
        private final jakarta.xml.bind.JAXBContext target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        JAXBContext(jakarta.xml.bind.JAXBContext target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.xml.bind.Unmarshaller createUnmarshaller() throws javax.xml.bind.JAXBException {
            try {
                return JAXBShim.of(target.createUnmarshaller());
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public javax.xml.bind.Marshaller createMarshaller() throws javax.xml.bind.JAXBException {
            try {
                return JAXBShim.of(target.createMarshaller());
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public javax.xml.bind.Binder<Node> createBinder() {
            return JAXBShim.of(target.createBinder());
        }

        @Override
        public <T> javax.xml.bind.Binder<T> createBinder(Class<T> domType) {
            return JAXBShim.of(target.createBinder(domType));
        }

        @Override
        public javax.xml.bind.JAXBIntrospector createJAXBIntrospector() {
            return JAXBShim.of(target.createJAXBIntrospector());
        }

        @Override
        public void generateSchema(javax.xml.bind.SchemaOutputResolver outputResolver) throws IOException {
            target.generateSchema(outputResolver);
        }

        @Override
        public void generateSchema(jakarta.xml.bind.SchemaOutputResolver outputResolver) throws IOException {
            target.generateSchema(outputResolver);
        }
    }

    final class JAXBContextFactory extends JAXBShim.Facade<jakarta.xml.bind.JAXBContextFactory> implements javax.xml.bind.JAXBContextFactory {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        JAXBContextFactory(jakarta.xml.bind.JAXBContextFactory target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.xml.bind.JAXBContext createContext(
            Class<?>[] classesToBeBound,
            Map<String, ?> properties
        ) throws javax.xml.bind.JAXBException {
            try {
                return JAXBShim.of(target.createContext(classesToBeBound, properties));
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public javax.xml.bind.JAXBContext createContext(
            String contextPath,
            ClassLoader classLoader,
            Map<String, ?> properties
        ) throws javax.xml.bind.JAXBException {
            try {
                return JAXBShim.of(target.createContext(contextPath, classLoader, properties));
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
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

    final class JAXBIntrospector extends javax.xml.bind.JAXBIntrospector {
        private final jakarta.xml.bind.JAXBIntrospector target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        JAXBIntrospector(jakarta.xml.bind.JAXBIntrospector target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public boolean isElement(Object object) {
            return target.isElement(object);
        }

        @Override
        public QName getElementName(Object jaxbElement) {
            return target.getElementName(jaxbElement);
        }
    }

    final class JAXBPermission extends javax.xml.bind.JAXBPermission {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        private final jakarta.xml.bind.JAXBPermission target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        JAXBPermission(jakarta.xml.bind.JAXBPermission target) {
            super(target.getName());
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public boolean implies(Permission permission) {
            return target.implies(permission);
        }

        @Override
        public String getActions() {
            return target.getActions();
        }

        @Override
        public PermissionCollection newPermissionCollection() {
            return target.newPermissionCollection();
        }

        @Override
        public void checkGuard(Object object) throws SecurityException {
            target.checkGuard(object);
        }

        @Override
        public boolean equals(Object other) {
            return target.equals(other);
        }

        @Override
        public int hashCode() {
            return target.hashCode();
        }

        @Override
        public String toString() {
            return target.toString();
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

    final class Marshaller extends JAXBShim.Facade<jakarta.xml.bind.Marshaller> implements javax.xml.bind.Marshaller {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Marshaller(jakarta.xml.bind.Marshaller target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void marshal(Object jaxbElement, Result result) throws javax.xml.bind.JAXBException {
            try {
                target.marshal(jaxbElement, result);
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public void marshal(Object jaxbElement, Node node) throws javax.xml.bind.JAXBException {
            try {
                target.marshal(jaxbElement, node);
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public void marshal(Object jaxbElement, File file) throws javax.xml.bind.JAXBException {
            try {
                target.marshal(jaxbElement, file);
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public void marshal(Object jaxbElement, ContentHandler handler) throws javax.xml.bind.JAXBException {
            try {
                target.marshal(jaxbElement, handler);
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public void marshal(Object jaxbElement, OutputStream outputStream) throws javax.xml.bind.JAXBException {
            try {
                target.marshal(jaxbElement, outputStream);
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public void marshal(Object jaxbElement, Writer writer) throws javax.xml.bind.JAXBException {
            try {
                target.marshal(jaxbElement, writer);
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public void marshal(Object jaxbElement, XMLStreamWriter writer) throws javax.xml.bind.JAXBException {
            try {
                target.marshal(jaxbElement, writer);
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public void marshal(Object jaxbElement, XMLEventWriter writer) throws javax.xml.bind.JAXBException {
            try {
                target.marshal(jaxbElement, writer);
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public Node getNode(Object contentTree) throws javax.xml.bind.JAXBException {
            try {
                return target.getNode(contentTree);
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public javax.xml.bind.ValidationEventHandler getEventHandler() throws javax.xml.bind.JAXBException {
            try {
                return JAXBShim.of(target.getEventHandler());
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public void setEventHandler(
            javax.xml.bind.ValidationEventHandler handler
        ) throws javax.xml.bind.JAXBException {
            try {
                target.setEventHandler(handler);
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public void setEventHandler(
            jakarta.xml.bind.ValidationEventHandler handler
        ) throws javax.xml.bind.JAXBException {
            try {
                target.setEventHandler(handler);
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public javax.xml.bind.annotation.adapters.XmlAdapter getAdapter(Class type) {
            return JAXBShim.of(target.getAdapter(type));
        }

        @Override
        public <A extends javax.xml.bind.annotation.adapters.XmlAdapter<?, ?>> void setAdapter(A adapter) {
            target.setAdapter(adapter);
        }

        @Override
        public void setAdapter(jakarta.xml.bind.annotation.adapters.XmlAdapter adapter) {
            target.setAdapter(adapter);
        }

        @Override
        public <A extends javax.xml.bind.annotation.adapters.XmlAdapter<?, ?>> void setAdapter(
            Class<A> type,
            A adapter
        ) {
            target.setAdapter(type, adapter);
        }

        @Override
        public void setAdapter(Class type, jakarta.xml.bind.annotation.adapters.XmlAdapter adapter) {
            target.setAdapter(type, adapter);
        }

        @Override
        public javax.xml.bind.attachment.AttachmentMarshaller getAttachmentMarshaller() {
            return JAXBShim.of(target.getAttachmentMarshaller());
        }

        @Override
        public void setAttachmentMarshaller(javax.xml.bind.attachment.AttachmentMarshaller attachmentMarshaller) {
            target.setAttachmentMarshaller(attachmentMarshaller);
        }

        @Override
        public void setAttachmentMarshaller(jakarta.xml.bind.attachment.AttachmentMarshaller attachmentMarshaller) {
            target.setAttachmentMarshaller(attachmentMarshaller);
        }

        @Override
        public javax.xml.bind.Marshaller.Listener getListener() {
            return JAXBShim.of(target.getListener());
        }

        @Override
        public void setListener(javax.xml.bind.Marshaller.Listener listener) {
            target.setListener(listener);
        }

        @Override
        public void setListener(jakarta.xml.bind.Marshaller.Listener listener) {
            target.setListener(listener);
        }

        @Override
        public Object getProperty(String name) throws jakarta.xml.bind.PropertyException {
            return target.getProperty(name);
        }

        @Override
        public void setProperty(String name, Object value) throws jakarta.xml.bind.PropertyException {
            target.setProperty(name, value);
        }

        @Override
        public Schema getSchema() {
            return target.getSchema();
        }

        @Override
        public void setSchema(Schema schema) {
            target.setSchema(schema);
        }
    }

    final class Marshaller$Listener extends javax.xml.bind.Marshaller.Listener {
        private final jakarta.xml.bind.Marshaller.Listener target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Marshaller$Listener(jakarta.xml.bind.Marshaller.Listener target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void beforeMarshal(Object source) {
            target.beforeMarshal(source);
        }

        @Override
        public void afterMarshal(Object source) {
            target.afterMarshal(source);
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

    final class NotIdentifiableEvent extends JAXBShim.Facade<jakarta.xml.bind.NotIdentifiableEvent> implements javax.xml.bind.NotIdentifiableEvent {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        NotIdentifiableEvent(jakarta.xml.bind.NotIdentifiableEvent target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public int getSeverity() {
            return target.getSeverity();
        }

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public Throwable getLinkedException() {
            return target.getLinkedException();
        }

        @Override
        public javax.xml.bind.ValidationEventLocator getLocator() {
            return JAXBShim.of(target.getLocator());
        }
    }

    final class ParseConversionEvent extends JAXBShim.Facade<jakarta.xml.bind.ParseConversionEvent> implements javax.xml.bind.ParseConversionEvent {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ParseConversionEvent(jakarta.xml.bind.ParseConversionEvent target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public int getSeverity() {
            return target.getSeverity();
        }

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public Throwable getLinkedException() {
            return target.getLinkedException();
        }

        @Override
        public javax.xml.bind.ValidationEventLocator getLocator() {
            return JAXBShim.of(target.getLocator());
        }
    }

    final class PrintConversionEvent extends JAXBShim.Facade<jakarta.xml.bind.PrintConversionEvent> implements javax.xml.bind.PrintConversionEvent {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        PrintConversionEvent(jakarta.xml.bind.PrintConversionEvent target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public int getSeverity() {
            return target.getSeverity();
        }

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public Throwable getLinkedException() {
            return target.getLinkedException();
        }

        @Override
        public javax.xml.bind.ValidationEventLocator getLocator() {
            return JAXBShim.of(target.getLocator());
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

    final class SchemaOutputResolver extends javax.xml.bind.SchemaOutputResolver {
        private final jakarta.xml.bind.SchemaOutputResolver target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        SchemaOutputResolver(jakarta.xml.bind.SchemaOutputResolver target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Result createOutput(String namespaceURI, String suggestedFileName) throws IOException {
            return target.createOutput(namespaceURI, suggestedFileName);
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

    final class Unmarshaller extends JAXBShim.Facade<jakarta.xml.bind.Unmarshaller> implements javax.xml.bind.Unmarshaller {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Unmarshaller(jakarta.xml.bind.Unmarshaller target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Object unmarshal(Source source) throws javax.xml.bind.JAXBException {
            try {
                return target.unmarshal(source);
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public Object unmarshal(Node node) throws javax.xml.bind.JAXBException {
            try {
                return target.unmarshal(node);
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public Object unmarshal(URL url) throws javax.xml.bind.JAXBException {
            try {
                return target.unmarshal(url);
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public Object unmarshal(File file) throws javax.xml.bind.JAXBException {
            try {
                return target.unmarshal(file);
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public Object unmarshal(InputSource source) throws javax.xml.bind.JAXBException {
            try {
                return target.unmarshal(source);
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public Object unmarshal(InputStream inputStream) throws javax.xml.bind.JAXBException {
            try {
                return target.unmarshal(inputStream);
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public Object unmarshal(Reader reader) throws javax.xml.bind.JAXBException {
            try {
                return target.unmarshal(reader);
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public Object unmarshal(XMLStreamReader reader) throws javax.xml.bind.JAXBException {
            try {
                return target.unmarshal(reader);
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public Object unmarshal(XMLEventReader reader) throws javax.xml.bind.JAXBException {
            try {
                return target.unmarshal(reader);
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public <T> javax.xml.bind.JAXBElement<T> unmarshal(
            Source source,
            Class<T> declaredType
        ) throws javax.xml.bind.JAXBException {
            try {
                return JAXBShim.of(target.unmarshal(source, declaredType));
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public <T> javax.xml.bind.JAXBElement<T> unmarshal(
            Node node,
            Class<T> declaredType
        ) throws javax.xml.bind.JAXBException {
            try {
                return JAXBShim.of(target.unmarshal(node, declaredType));
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public <T> javax.xml.bind.JAXBElement<T> unmarshal(
            XMLStreamReader reader,
            Class<T> declaredType
        ) throws javax.xml.bind.JAXBException {
            try {
                return JAXBShim.of(target.unmarshal(reader, declaredType));
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public <T> javax.xml.bind.JAXBElement<T> unmarshal(
            XMLEventReader reader,
            Class<T> declaredType
        ) throws javax.xml.bind.JAXBException {
            try {
                return JAXBShim.of(target.unmarshal(reader, declaredType));
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public javax.xml.bind.UnmarshallerHandler getUnmarshallerHandler() {
            return JAXBShim.of(target.getUnmarshallerHandler());
        }

        @Override
        public javax.xml.bind.ValidationEventHandler getEventHandler() throws javax.xml.bind.JAXBException {
            try {
                return JAXBShim.of(target.getEventHandler());
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public void setEventHandler(
            javax.xml.bind.ValidationEventHandler handler
        ) throws javax.xml.bind.JAXBException {
            try {
                target.setEventHandler(handler);
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public void setEventHandler(
            jakarta.xml.bind.ValidationEventHandler handler
        ) throws javax.xml.bind.JAXBException {
            try {
                target.setEventHandler(handler);
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public javax.xml.bind.annotation.adapters.XmlAdapter getAdapter(Class type) {
            return JAXBShim.of(target.getAdapter(type));
        }

        @Override
        public <A extends javax.xml.bind.annotation.adapters.XmlAdapter<?, ?>> void setAdapter(A adapter) {
            target.setAdapter(adapter);
        }

        @Override
        public void setAdapter(jakarta.xml.bind.annotation.adapters.XmlAdapter adapter) {
            target.setAdapter(adapter);
        }

        @Override
        public <A extends javax.xml.bind.annotation.adapters.XmlAdapter<?, ?>> void setAdapter(
            Class<A> type,
            A adapter
        ) {
            target.setAdapter(type, adapter);
        }

        @Override
        public void setAdapter(Class type, jakarta.xml.bind.annotation.adapters.XmlAdapter adapter) {
            target.setAdapter(type, adapter);
        }

        @Override
        public javax.xml.bind.attachment.AttachmentUnmarshaller getAttachmentUnmarshaller() {
            return JAXBShim.of(target.getAttachmentUnmarshaller());
        }

        @Override
        public void setAttachmentUnmarshaller(
            javax.xml.bind.attachment.AttachmentUnmarshaller attachmentUnmarshaller
        ) {
            target.setAttachmentUnmarshaller(attachmentUnmarshaller);
        }

        @Override
        public void setAttachmentUnmarshaller(
            jakarta.xml.bind.attachment.AttachmentUnmarshaller attachmentUnmarshaller
        ) {
            target.setAttachmentUnmarshaller(attachmentUnmarshaller);
        }

        @Override
        public javax.xml.bind.Unmarshaller.Listener getListener() {
            return JAXBShim.of(target.getListener());
        }

        @Override
        public void setListener(javax.xml.bind.Unmarshaller.Listener listener) {
            target.setListener(listener);
        }

        @Override
        public void setListener(jakarta.xml.bind.Unmarshaller.Listener listener) {
            target.setListener(listener);
        }

        @Override
        public Object getProperty(String name) throws jakarta.xml.bind.PropertyException {
            return target.getProperty(name);
        }

        @Override
        public void setProperty(String name, Object value) throws jakarta.xml.bind.PropertyException {
            target.setProperty(name, value);
        }

        @Override
        public Schema getSchema() {
            return target.getSchema();
        }

        @Override
        public void setSchema(Schema schema) {
            target.setSchema(schema);
        }
    }

    final class Unmarshaller$Listener extends javax.xml.bind.Unmarshaller.Listener {
        private final jakarta.xml.bind.Unmarshaller.Listener target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Unmarshaller$Listener(jakarta.xml.bind.Unmarshaller.Listener target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void beforeUnmarshal(Object target, Object parent) {
            this.target.beforeUnmarshal(target, parent);
        }

        @Override
        public void afterUnmarshal(Object target, Object parent) {
            this.target.afterUnmarshal(target, parent);
        }
    }

    final class UnmarshallerHandler extends JAXBShim.Facade<jakarta.xml.bind.UnmarshallerHandler> implements javax.xml.bind.UnmarshallerHandler {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        UnmarshallerHandler(jakarta.xml.bind.UnmarshallerHandler target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Object getResult() throws javax.xml.bind.JAXBException, IllegalStateException {
            try {
                return target.getResult();
            } catch (jakarta.xml.bind.JAXBException exception) {
                throw JAXBShim.of(exception);
            }
        }

        @Override
        public void setDocumentLocator(Locator locator) {
            target.setDocumentLocator(locator);
        }

        @Override
        public void startDocument() throws SAXException {
            target.startDocument();
        }

        @Override
        public void endDocument() throws SAXException {
            target.endDocument();
        }

        @Override
        public void startPrefixMapping(String prefix, String uri) throws SAXException {
            target.startPrefixMapping(prefix, uri);
        }

        @Override
        public void endPrefixMapping(String prefix) throws SAXException {
            target.endPrefixMapping(prefix);
        }

        @Override
        public void startElement(
            String uri,
            String localName,
            String qName,
            Attributes attributes
        ) throws SAXException {
            target.startElement(uri, localName, qName, attributes);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            target.endElement(uri, localName, qName);
        }

        @Override
        public void characters(char[] characters, int start, int length) throws SAXException {
            target.characters(characters, start, length);
        }

        @Override
        public void ignorableWhitespace(char[] characters, int start, int length) throws SAXException {
            target.ignorableWhitespace(characters, start, length);
        }

        @Override
        public void processingInstruction(String target, String data) throws SAXException {
            this.target.processingInstruction(target, data);
        }

        @Override
        public void skippedEntity(String name) throws SAXException {
            target.skippedEntity(name);
        }
    }

    final class ValidationEvent extends JAXBShim.Facade<jakarta.xml.bind.ValidationEvent> implements javax.xml.bind.ValidationEvent {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ValidationEvent(jakarta.xml.bind.ValidationEvent target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public int getSeverity() {
            return target.getSeverity();
        }

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public Throwable getLinkedException() {
            return target.getLinkedException();
        }

        @Override
        public javax.xml.bind.ValidationEventLocator getLocator() {
            return JAXBShim.of(target.getLocator());
        }
    }

    final class ValidationEventHandler extends JAXBShim.Facade<jakarta.xml.bind.ValidationEventHandler> implements javax.xml.bind.ValidationEventHandler {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ValidationEventHandler(jakarta.xml.bind.ValidationEventHandler target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public boolean handleEvent(javax.xml.bind.ValidationEvent event) {
            return target.handleEvent(event);
        }

        @Override
        public boolean handleEvent(jakarta.xml.bind.ValidationEvent event) {
            return target.handleEvent(event);
        }
    }

    final class ValidationEventLocator extends JAXBShim.Facade<jakarta.xml.bind.ValidationEventLocator> implements javax.xml.bind.ValidationEventLocator {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ValidationEventLocator(jakarta.xml.bind.ValidationEventLocator target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public URL getURL() {
            return target.getURL();
        }

        @Override
        public int getOffset() {
            return target.getOffset();
        }

        @Override
        public int getLineNumber() {
            return target.getLineNumber();
        }

        @Override
        public int getColumnNumber() {
            return target.getColumnNumber();
        }

        @Override
        public Object getObject() {
            return target.getObject();
        }

        @Override
        public Node getNode() {
            return target.getNode();
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
