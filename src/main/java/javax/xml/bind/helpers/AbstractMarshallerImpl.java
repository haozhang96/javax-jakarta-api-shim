package javax.xml.bind.helpers;

import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;

import javax.xml.bind.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.attachment.AttachmentMarshaller;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Result;
import javax.xml.validation.Schema;
import java.io.File;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/**
 * @deprecated Use {@link jakarta.xml.bind.helpers.AbstractMarshallerImpl} instead.
 * @apiNote This class cannot extend {@link jakarta.xml.bind.helpers.AbstractMarshallerImpl} due to it declaring
 *          incompatible final methods.
 */
@Deprecated(since = "jakarta.xml.bind.helpers.AbstractMarshallerImpl")
@SuppressWarnings("JavadocReference")
public abstract class AbstractMarshallerImpl implements Marshaller {
    private final Delegate target = new Delegate();

    //==================================================================================================================
    // Delegated Methods
    //==================================================================================================================

    @Override
    public void marshal(Object jaxbElement, Node node) throws JAXBException {
        try {
            target.marshal(JAXBElement.wrap(jaxbElement), node);
        } catch (jakarta.xml.bind.JAXBException exception) {
            throw JAXBShim.of(exception);
        }
    }

    @Override
    public void marshal(Object jaxbElement, File file) throws JAXBException {
        try {
            target.marshal(JAXBElement.wrap(jaxbElement), file);
        } catch (jakarta.xml.bind.JAXBException exception) {
            throw JAXBShim.of(exception);
        }
    }

    @Override
    public void marshal(Object jaxbElement, ContentHandler handler) throws JAXBException {
        try {
            target.marshal(JAXBElement.wrap(jaxbElement), handler);
        } catch (jakarta.xml.bind.JAXBException exception) {
            throw JAXBShim.of(exception);
        }
    }

    @Override
    public void marshal(Object jaxbElement, OutputStream outputStream) throws JAXBException {
        try {
            target.marshal(JAXBElement.wrap(jaxbElement), outputStream);
        } catch (jakarta.xml.bind.JAXBException exception) {
            throw JAXBShim.of(exception);
        }
    }

    @Override
    public void marshal(Object jaxbElement, Writer writer) throws JAXBException {
        try {
            target.marshal(JAXBElement.wrap(jaxbElement), writer);
        } catch (jakarta.xml.bind.JAXBException exception) {
            throw JAXBShim.of(exception);
        }
    }

    @Override
    public void marshal(Object jaxbElement, XMLEventWriter writer) throws JAXBException {
        try {
            target.marshal(JAXBElement.wrap(jaxbElement), writer);
        } catch (jakarta.xml.bind.JAXBException exception) {
            throw JAXBShim.of(exception);
        }
    }

    @Override
    public void marshal(Object jaxbElement, XMLStreamWriter writer) throws JAXBException {
        try {
            target.marshal(JAXBElement.wrap(jaxbElement), writer);
        } catch (jakarta.xml.bind.JAXBException exception) {
            throw JAXBShim.of(exception);
        }
    }

    @Override
    public Node getNode(Object contentTree) throws JAXBException {
        try {
            return target.getNode(contentTree);
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
    public AttachmentMarshaller getAttachmentMarshaller() {
        return JAXBShim.of(target.getAttachmentMarshaller());
    }

    @Override
    public void setAttachmentMarshaller(AttachmentMarshaller attachmentMarshaller) {
        target.setAttachmentMarshaller(attachmentMarshaller);
    }

    @Override
    public Marshaller.Listener getListener() {
        return JAXBShim.of(target.getListener());
    }

    @Override
    public void setListener(Marshaller.Listener listener) {
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
     * @see jakarta.xml.bind.helpers.AbstractMarshallerImpl#getEncoding()
     */
    protected String getEncoding() {
        return target.getEncoding();
    }

    /**
     * @see jakarta.xml.bind.helpers.AbstractMarshallerImpl#setEncoding(String)
     */
    protected void setEncoding(String encoding) {
        target.setEncoding(encoding);
    }

    /**
     * @see jakarta.xml.bind.helpers.AbstractMarshallerImpl#getSchemaLocation()
     */
    protected String getSchemaLocation() {
        return target.getSchemaLocation();
    }

    /**
     * @see jakarta.xml.bind.helpers.AbstractMarshallerImpl#setSchemaLocation(String)
     */
    protected void setSchemaLocation(String location) {
        target.setSchemaLocation(location);
    }

    /**
     * @see jakarta.xml.bind.helpers.AbstractMarshallerImpl#getNoNSSchemaLocation()
     */
    protected String getNoNSSchemaLocation() {
        return target.getNoNSSchemaLocation();
    }

    /**
     * @see jakarta.xml.bind.helpers.AbstractMarshallerImpl#setNoNSSchemaLocation(String)
     */
    protected void setNoNSSchemaLocation(String location) {
        target.setNoNSSchemaLocation(location);
    }

    /**
     * @see jakarta.xml.bind.helpers.AbstractMarshallerImpl#isFormattedOutput()
     */
    protected boolean isFormattedOutput() {
        return target.isFormattedOutput();
    }

    /**
     * @see jakarta.xml.bind.helpers.AbstractMarshallerImpl#setFormattedOutput(boolean)
     */
    protected void setFormattedOutput(boolean formattedOutput) {
        target.setFormattedOutput(formattedOutput);
    }

    /**
     * @see jakarta.xml.bind.helpers.AbstractMarshallerImpl#isFragment()
     */
    protected boolean isFragment() {
        return target.isFragment();
    }

    /**
     * @see jakarta.xml.bind.helpers.AbstractMarshallerImpl#setFragment(boolean)
     */
    protected void setFragment(boolean fragment) {
        target.setFragment(fragment);
    }

    /**
     * @see jakarta.xml.bind.helpers.AbstractMarshallerImpl#getJavaEncoding(String)
     */
    protected String getJavaEncoding(String encoding) throws UnsupportedEncodingException {
        return target.getJavaEncoding(encoding);
    }

    //==================================================================================================================
    // Delegate
    //==================================================================================================================

    private final class Delegate extends jakarta.xml.bind.helpers.AbstractMarshallerImpl {
        @Override
        public void marshal(Object jaxbElement, Result result) throws jakarta.xml.bind.JAXBException {
            AbstractMarshallerImpl.this.marshal(JAXBElement.wrap(jaxbElement), result);
        }

        @Override
        protected String getEncoding() {
            return super.getEncoding();
        }

        @Override
        protected void setEncoding(String encoding) {
            super.setEncoding(encoding);
        }

        @Override
        protected String getSchemaLocation() {
            return super.getSchemaLocation();
        }

        @Override
        protected void setSchemaLocation(String location) {
            super.setSchemaLocation(location);
        }

        @Override
        protected String getNoNSSchemaLocation() {
            return super.getNoNSSchemaLocation();
        }

        @Override
        protected void setNoNSSchemaLocation(String location) {
            super.setNoNSSchemaLocation(location);
        }

        @Override
        protected boolean isFormattedOutput() {
            return super.isFormattedOutput();
        }

        @Override
        protected void setFormattedOutput(boolean formattedOutput) {
            super.setFormattedOutput(formattedOutput);
        }

        @Override
        protected boolean isFragment() {
            return super.isFragment();
        }

        @Override
        protected void setFragment(boolean fragment) {
            super.setFragment(fragment);
        }

        @Override
        protected String getJavaEncoding(String encoding) throws UnsupportedEncodingException {
            return super.getJavaEncoding(encoding);
        }
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JAXBShim.initialize();
    }
}
