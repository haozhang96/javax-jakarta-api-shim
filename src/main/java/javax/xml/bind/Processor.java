package javax.xml.bind;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.validation.Schema;

/**
 * @deprecated Use {@link Marshaller} and {@link Unmarshaller} instead.
 * @implNote This interface exists to consolidate common methods in {@link Marshaller} and {@link Unmarshaller}.
 */
@Deprecated(since = "javax.xml.bind.Marshaller, javax.xml.bind.Unmarshaller")
@SuppressWarnings({"unchecked", "rawtypes"})
interface Processor<L, LS extends JAXBShim> extends JAXBShim {
    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.Marshaller#getEventHandler()
     * @see jakarta.xml.bind.Unmarshaller#getEventHandler()
     */
    ValidationEventHandler getEventHandler() throws JAXBException;

    /**
     * @see jakarta.xml.bind.Marshaller#setEventHandler(jakarta.xml.bind.ValidationEventHandler)
     * @see jakarta.xml.bind.Unmarshaller#setEventHandler(jakarta.xml.bind.ValidationEventHandler)
     */
    void setEventHandler(ValidationEventHandler handler) throws JAXBException;

    /**
     * @see jakarta.xml.bind.Marshaller#getAdapter(Class)
     * @see jakarta.xml.bind.Unmarshaller#getAdapter(Class)
     */
    XmlAdapter getAdapter(Class type);

    /**
     * @see jakarta.xml.bind.Marshaller#setAdapter(jakarta.xml.bind.annotation.adapters.XmlAdapter)
     * @see jakarta.xml.bind.Unmarshaller#setAdapter(jakarta.xml.bind.annotation.adapters.XmlAdapter)
     */
    <A extends XmlAdapter<?, ?>> void setAdapter(A adapter);

    /**
     * @see jakarta.xml.bind.Marshaller#setAdapter(Class, jakarta.xml.bind.annotation.adapters.XmlAdapter)
     * @see jakarta.xml.bind.Unmarshaller#setAdapter(Class, jakarta.xml.bind.annotation.adapters.XmlAdapter)
     */
    <A extends XmlAdapter<?, ?>> void setAdapter(Class<A> type, A adapter);

    /**
     * @see jakarta.xml.bind.Marshaller#setListener(jakarta.xml.bind.Marshaller.Listener)
     * @see jakarta.xml.bind.Unmarshaller#setListener(jakarta.xml.bind.Unmarshaller.Listener)
     */
    void setListener(LS listener);

    //==================================================================================================================
    // Marshaller/Unmarshaller Implementation Methods
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.Marshaller#setEventHandler(jakarta.xml.bind.ValidationEventHandler)
     * @see jakarta.xml.bind.Unmarshaller#setEventHandler(jakarta.xml.bind.ValidationEventHandler)
     */
    default void setEventHandler(jakarta.xml.bind.ValidationEventHandler handler) throws JAXBException {
        setEventHandler(JAXBShim.of(handler));
    }

    /**
     * @see jakarta.xml.bind.Marshaller#setAdapter(jakarta.xml.bind.annotation.adapters.XmlAdapter)
     * @see jakarta.xml.bind.Unmarshaller#setAdapter(jakarta.xml.bind.annotation.adapters.XmlAdapter)
     */
    default void setAdapter(jakarta.xml.bind.annotation.adapters.XmlAdapter adapter) {
        setAdapter(JAXBShim.of(adapter));
    }

    /**
     * @see jakarta.xml.bind.Marshaller#setAdapter(Class, jakarta.xml.bind.annotation.adapters.XmlAdapter)
     * @see jakarta.xml.bind.Unmarshaller#setAdapter(Class, jakarta.xml.bind.annotation.adapters.XmlAdapter)
     */
    @SuppressWarnings("unchecked")
    default void setAdapter(Class type, jakarta.xml.bind.annotation.adapters.XmlAdapter adapter) {
        setAdapter(type, JAXBShim.of(adapter));
    }

    /**
     * @see jakarta.xml.bind.Marshaller#getListener()
     * @see jakarta.xml.bind.Unmarshaller#getListener()
     */
    LS getListener();

    /**
     * @see jakarta.xml.bind.Marshaller#setListener(jakarta.xml.bind.Marshaller.Listener)
     * @see jakarta.xml.bind.Unmarshaller#setListener(jakarta.xml.bind.Unmarshaller.Listener)
     */
    default void setListener(L listener) {
        setListener(JAXBShim.<LS>of(listener));
    }

    /**
     * @see jakarta.xml.bind.Marshaller#getProperty(String)
     * @see jakarta.xml.bind.Unmarshaller#getProperty(String)
     */
    Object getProperty(String name) throws jakarta.xml.bind.PropertyException;

    /**
     * @see jakarta.xml.bind.Marshaller#setProperty(String, Object)
     * @see jakarta.xml.bind.Unmarshaller#setProperty(String, Object)
     */
    void setProperty(String name, Object value) throws jakarta.xml.bind.PropertyException;

    /**
     * @see jakarta.xml.bind.Marshaller#getSchema()
     * @see jakarta.xml.bind.Unmarshaller#getSchema()
     */
    Schema getSchema();

    /**
     * @see jakarta.xml.bind.Marshaller#setSchema(Schema)
     * @see jakarta.xml.bind.Unmarshaller#setSchema(Schema)
     */
    void setSchema(Schema schema);
}
