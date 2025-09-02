package javax.xml.bind.helpers;

import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.bind.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.attachment.AttachmentUnmarshaller;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import javax.xml.validation.Schema;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;

/**
 * @deprecated Use {@link jakarta.xml.bind.helpers.AbstractUnmarshallerImpl} instead.
 * @apiNote This class cannot extend {@link jakarta.xml.bind.helpers.AbstractUnmarshallerImpl} due to it declaring
 *          incompatible final methods.
 */
@Deprecated(since = "jakarta.xml.bind.helpers.AbstractUnmarshallerImpl")
@SuppressWarnings("JavadocReference")
public abstract class AbstractUnmarshallerImpl implements Unmarshaller {
    private final Delegate target = new Delegate();

    //==================================================================================================================
    // Delegated Methods
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.helpers.AbstractUnmarshallerImpl#unmarshal(XMLReader, InputSource)
     */
    protected abstract Object unmarshal(XMLReader reader, InputSource source) throws JAXBException;

    @Override
    public Object unmarshal(Source source) throws JAXBException {
        try {
            return target.unmarshal(source);
        } catch (jakarta.xml.bind.JAXBException exception) {
            throw JAXBShim.of(exception);
        }
    }

    @Override
    public Object unmarshal(URL url) throws JAXBException {
        try {
            return target.unmarshal(url);
        } catch (jakarta.xml.bind.JAXBException exception) {
            throw JAXBShim.of(exception);
        }
    }

    @Override
    public Object unmarshal(File file) throws JAXBException {
        try {
            return target.unmarshal(file);
        } catch (jakarta.xml.bind.JAXBException exception) {
            throw JAXBShim.of(exception);
        }
    }

    @Override
    public Object unmarshal(InputSource source) throws JAXBException {
        try {
            return target.unmarshal(source);
        } catch (jakarta.xml.bind.JAXBException exception) {
            throw JAXBShim.of(exception);
        }
    }

    @Override
    public Object unmarshal(InputStream inputStream) throws JAXBException {
        try {
            return target.unmarshal(inputStream);
        } catch (jakarta.xml.bind.JAXBException exception) {
            throw JAXBShim.of(exception);
        }
    }

    @Override
    public Object unmarshal(Reader reader) throws JAXBException {
        try {
            return target.unmarshal(reader);
        } catch (jakarta.xml.bind.JAXBException exception) {
            throw JAXBShim.of(exception);
        }
    }

    @Override
    public Object unmarshal(XMLStreamReader reader) throws JAXBException {
        try {
            return target.unmarshal(reader);
        } catch (jakarta.xml.bind.JAXBException exception) {
            throw JAXBShim.of(exception);
        }
    }

    @Override
    public Object unmarshal(XMLEventReader reader) throws JAXBException {
        try {
            return target.unmarshal(reader);
        } catch (jakarta.xml.bind.JAXBException exception) {
            throw JAXBShim.of(exception);
        }
    }

    @Override
    public <T> JAXBElement<T> unmarshal(Node node, Class<T> declaredType) throws JAXBException {
        try {
            return JAXBShim.of(target.unmarshal(node, declaredType));
        } catch (jakarta.xml.bind.JAXBException exception) {
            throw JAXBShim.of(exception);
        }
    }

    @Override
    public <T> JAXBElement<T> unmarshal(Source source, Class<T> declaredType) throws JAXBException {
        try {
            return JAXBShim.of(target.unmarshal(source, declaredType));
        } catch (jakarta.xml.bind.JAXBException exception) {
            throw JAXBShim.of(exception);
        }
    }

    @Override
    public <T> JAXBElement<T> unmarshal(XMLStreamReader reader, Class<T> declaredType) throws JAXBException {
        try {
            return JAXBShim.of(target.unmarshal(reader, declaredType));
        } catch (jakarta.xml.bind.JAXBException exception) {
            throw JAXBShim.of(exception);
        }
    }

    @Override
    public <T> JAXBElement<T> unmarshal(XMLEventReader reader, Class<T> declaredType) throws JAXBException {
        try {
            return JAXBShim.of(target.unmarshal(reader, declaredType));
        } catch (jakarta.xml.bind.JAXBException exception) {
            throw JAXBShim.of(exception);
        }
    }

    @Override
    public ValidationEventHandler getEventHandler() throws JAXBException {
        try {
            return JAXBShim.of(target.getEventHandler());
        } catch (jakarta.xml.bind.JAXBException exception) {
            throw JAXBShim.of(exception);
        }
    }

    @Override
    public void setEventHandler(ValidationEventHandler handler) throws JAXBException {
        try {
            target.setEventHandler(handler);
        } catch (jakarta.xml.bind.JAXBException exception) {
            throw JAXBShim.of(exception);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public XmlAdapter getAdapter(Class type) {
        return JAXBShim.of(target.getAdapter(type));
    }

    @Override
    public <A extends XmlAdapter<?, ?>> void setAdapter(A adapter) {
        target.setAdapter(adapter);
    }

    @Override
    public <A extends XmlAdapter<?, ?>> void setAdapter(Class<A> type, A adapter) {
        target.setAdapter(type, adapter);
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
    public AttachmentUnmarshaller getAttachmentUnmarshaller() {
        return JAXBShim.of(target.getAttachmentUnmarshaller());
    }

    @Override
    public void setAttachmentUnmarshaller(AttachmentUnmarshaller attachmentUnmarshaller) {
        target.setAttachmentUnmarshaller(attachmentUnmarshaller);
    }

    @Override
    public Listener getListener() {
        return JAXBShim.of(target.getListener());
    }

    @Override
    public void setListener(Listener listener) {
        target.setListener(listener);
    }

    @Override
    public Schema getSchema() {
        return target.getSchema();
    }

    @Override
    public void setSchema(Schema schema) {
        target.setSchema(schema);
    }

    /**
     * @see jakarta.xml.bind.helpers.AbstractUnmarshallerImpl#getXMLReader()
     */
    protected XMLReader getXMLReader() throws JAXBException {
        try {
            return target.getXMLReader();
        } catch (jakarta.xml.bind.JAXBException exception) {
            throw JAXBShim.of(exception);
        }
    }

    /**
     * @see jakarta.xml.bind.helpers.AbstractUnmarshallerImpl#createUnmarshalException(SAXException)
     */
    protected UnmarshalException createUnmarshalException(SAXException exception) {
        return JAXBShim.of(target.createUnmarshalException(exception));
    }

    //==================================================================================================================
    // Delegate
    //==================================================================================================================

    private final class Delegate extends jakarta.xml.bind.helpers.AbstractUnmarshallerImpl {
        @Override
        protected Object unmarshal(XMLReader reader, InputSource source) throws jakarta.xml.bind.JAXBException {
            return AbstractUnmarshallerImpl.this.unmarshal(reader, source);
        }

        @Override
        public Object unmarshal(Node node) throws jakarta.xml.bind.JAXBException {
            return AbstractUnmarshallerImpl.this.unmarshal(node);
        }

        @Override
        public UnmarshallerHandler getUnmarshallerHandler() {
            return AbstractUnmarshallerImpl.this.getUnmarshallerHandler();
        }

        @Override
        protected XMLReader getXMLReader() throws jakarta.xml.bind.JAXBException {
            return super.getXMLReader();
        }

        @Override
        protected jakarta.xml.bind.UnmarshalException createUnmarshalException(SAXException exception) {
            return super.createUnmarshalException(exception);
        }
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JAXBShim.initialize();
    }
}
