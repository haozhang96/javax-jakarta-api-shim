package javax.xml.bind;

import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.attachment.AttachmentMarshaller;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Result;
import java.io.File;
import java.io.OutputStream;
import java.io.Writer;

/**
 * @deprecated Use {@link jakarta.xml.bind.Marshaller} instead.
 */
@Deprecated(since = "jakarta.xml.bind.Marshaller")
public interface Marshaller extends jakarta.xml.bind.Marshaller, JAXBShim {
    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.Marshaller#setEventHandler(jakarta.xml.bind.ValidationEventHandler)
     */
    void setEventHandler(ValidationEventHandler handler) throws JAXBException;

    /**
     * @see jakarta.xml.bind.Marshaller#setAdapter(jakarta.xml.bind.annotation.adapters.XmlAdapter)
     */
    <A extends XmlAdapter<?, ?>> void setAdapter(A adapter);

    /**
     * @see jakarta.xml.bind.Marshaller#setAdapter(Class, jakarta.xml.bind.annotation.adapters.XmlAdapter)
     */
    <A extends XmlAdapter<?, ?>> void setAdapter(Class<A> type, A adapter);

    /**
     * @see jakarta.xml.bind.Marshaller#setListener(jakarta.xml.bind.Marshaller.Listener)
     */
    void setListener(Listener listener);

    //==================================================================================================================
    // Marshaller Implementation Methods
    //==================================================================================================================

    @Override
    void marshal(Object jaxbElement, Result result) throws JAXBException;

    @Override
    void marshal(Object jaxbElement, OutputStream outputStream) throws JAXBException;

    @Override
    void marshal(Object jaxbElement, File file) throws JAXBException;

    @Override
    void marshal(Object jaxbElement, Writer writer) throws JAXBException;

    @Override
    void marshal(Object jaxbElement, ContentHandler handler) throws JAXBException;

    @Override
    void marshal(Object jaxbElement, Node node) throws JAXBException;

    @Override
    void marshal(Object jaxbElement, XMLStreamWriter writer) throws JAXBException;

    @Override
    void marshal(Object jaxbElement, XMLEventWriter writer) throws JAXBException;

    @Override
    Node getNode(Object contentTree) throws JAXBException;

    @Override
    Object getProperty(String name) throws jakarta.xml.bind.PropertyException;

    @Override
    void setProperty(String name, Object value) throws jakarta.xml.bind.PropertyException;

    @Override
    default void setEventHandler(jakarta.xml.bind.ValidationEventHandler handler) throws JAXBException {
        setEventHandler(JAXBShim.of(handler));
    }

    @Override
    ValidationEventHandler getEventHandler() throws JAXBException;

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    XmlAdapter getAdapter(Class type);

    @Override
    default void setAdapter(jakarta.xml.bind.annotation.adapters.XmlAdapter adapter) {
        setAdapter(JAXBShim.of(adapter));
    }

    @Override
    @SuppressWarnings("unchecked")
    default void setAdapter(Class type, jakarta.xml.bind.annotation.adapters.XmlAdapter adapter) {
        setAdapter(type, JAXBShim.of(adapter));
    }

    @Override
    AttachmentMarshaller getAttachmentMarshaller();

    @Override
    void setAttachmentMarshaller(jakarta.xml.bind.attachment.AttachmentMarshaller attachmentMarshaller);

    @Override
    Listener getListener();

    @Override
    default void setListener(jakarta.xml.bind.Marshaller.Listener listener) {
        setListener(JAXBShim.of(listener));
    }

    //==================================================================================================================
    // Marshaller.Listener Implementation
    //==================================================================================================================

    /**
     * @deprecated Use {@link jakarta.xml.bind.Marshaller.Listener} instead.
     */
    @Deprecated(since = "jakarta.xml.bind.Marshaller.Listener")
    abstract class Listener extends jakarta.xml.bind.Marshaller.Listener implements JAXBShim { }
}
