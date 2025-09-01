package javax.xml.bind;

import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.attachment.AttachmentUnmarshaller;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;

/**
 * @deprecated Use {@link jakarta.xml.bind.Unmarshaller} instead.
 */
@Deprecated(since = "jakarta.xml.bind.Unmarshaller")
public interface Unmarshaller extends jakarta.xml.bind.Unmarshaller, JAXBShim {
    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.Marshaller#setEventHandler(jakarta.xml.bind.ValidationEventHandler)
     */
    void setEventHandler(ValidationEventHandler handler) throws JAXBException;

    /**
     * @see jakarta.xml.bind.Unmarshaller#setAdapter(jakarta.xml.bind.annotation.adapters.XmlAdapter)
     */
    <A extends XmlAdapter<?, ?>> void setAdapter(A adapter);

    /**
     * @see jakarta.xml.bind.Unmarshaller#setAdapter(Class, jakarta.xml.bind.annotation.adapters.XmlAdapter)
     */
    <A extends XmlAdapter<?, ?>> void setAdapter(Class<A> type, A adapter);

    /**
     * @see jakarta.xml.bind.Unmarshaller#setAttachmentUnmarshaller(jakarta.xml.bind.attachment.AttachmentUnmarshaller)
     */
    void setAttachmentUnmarshaller(AttachmentUnmarshaller attachmentUnmarshaller);

    /**
     * @see jakarta.xml.bind.Unmarshaller#setListener(jakarta.xml.bind.Unmarshaller.Listener)
     */
    void setListener(Listener listener);

    //==================================================================================================================
    // Unmarshaller Implementation Methods
    //==================================================================================================================

    @Override
    Object unmarshal(File file) throws JAXBException;

    @Override
    Object unmarshal(InputStream inputStream) throws JAXBException;

    @Override
    Object unmarshal(Reader reader) throws JAXBException;

    @Override
    Object unmarshal(URL url) throws JAXBException;

    @Override
    Object unmarshal(InputSource source) throws JAXBException;

    @Override
    Object unmarshal(Node node) throws JAXBException;

    @Override
    <T> JAXBElement<T> unmarshal(Node node, Class<T> declaredType) throws JAXBException;

    @Override
    Object unmarshal(Source source) throws JAXBException;

    @Override
    <T> JAXBElement<T> unmarshal(Source source, Class<T> declaredType) throws JAXBException;

    @Override
    Object unmarshal(XMLStreamReader reader) throws JAXBException;

    @Override
    <T> JAXBElement<T> unmarshal(XMLStreamReader reader, Class<T> declaredType) throws JAXBException;

    @Override
    Object unmarshal(XMLEventReader reader) throws JAXBException;

    @Override
    <T> JAXBElement<T> unmarshal(XMLEventReader reader, Class<T> declaredType) throws JAXBException;

    @Override
    UnmarshallerHandler getUnmarshallerHandler();

    @Override
    ValidationEventHandler getEventHandler() throws JAXBException;

    @Override
    default void setEventHandler(jakarta.xml.bind.ValidationEventHandler handler) throws JAXBException {
        setEventHandler(JAXBShim.of(handler));
    }

    @Override
    Object getProperty(String name) throws jakarta.xml.bind.PropertyException;

    @Override
    void setProperty(String name, Object value) throws jakarta.xml.bind.PropertyException;

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
    AttachmentUnmarshaller getAttachmentUnmarshaller();

    @Override
    default void setAttachmentUnmarshaller(jakarta.xml.bind.attachment.AttachmentUnmarshaller attachmentUnmarshaller) {
        setAttachmentUnmarshaller(JAXBShim.of(attachmentUnmarshaller));
    }

    @Override
    Listener getListener();

    @Override
    default void setListener(jakarta.xml.bind.Unmarshaller.Listener listener) {
        setListener(JAXBShim.of(listener));
    }

    //==================================================================================================================
    // Unmarshaller.Listener Implementation
    //==================================================================================================================

    /**
     * @deprecated Use {@link jakarta.xml.bind.Unmarshaller.Listener} instead.
     */
    @Deprecated(since = "jakarta.xml.bind.Unmarshaller.Listener")
    abstract class Listener extends jakarta.xml.bind.Unmarshaller.Listener implements JAXBShim { }
}
