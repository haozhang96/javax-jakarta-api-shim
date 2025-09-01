package javax.xml.bind;

/**
 * @deprecated Use {@link jakarta.xml.bind.Binder} instead.
 */
@Deprecated(since = "jakarta.xml.bind.Binder")
public abstract class Binder<XmlNode> extends jakarta.xml.bind.Binder<XmlNode> implements JAXBShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.Binder#Binder()
     */
    protected Binder() {
        super();
    }

    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.Binder#setEventHandler(jakarta.xml.bind.ValidationEventHandler)
     */
    public abstract void setEventHandler(ValidationEventHandler handler) throws JAXBException;

    //==================================================================================================================
    // Binder Implementation Methods
    //==================================================================================================================

    @Override
    public abstract Object unmarshal(XmlNode xmlNode) throws JAXBException;

    @Override
    public abstract <T> JAXBElement<T> unmarshal(XmlNode xmlNode, Class<T> declaredType) throws JAXBException;

    @Override
    public abstract void marshal(Object jaxbObject, XmlNode xmlNode) throws JAXBException;

    @Override
    public abstract XmlNode updateXML(Object jaxbObject) throws JAXBException;

    @Override
    public abstract XmlNode updateXML(Object jaxbObject, XmlNode xmlNode) throws JAXBException;

    @Override
    public abstract Object updateJAXB(XmlNode xmlNode) throws JAXBException;

    @Override
    public void setEventHandler(jakarta.xml.bind.ValidationEventHandler handler) throws JAXBException {
        setEventHandler(JAXBShim.of(handler));
    }

    @Override
    public abstract ValidationEventHandler getEventHandler() throws JAXBException;

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JAXBShim.initialize();
    }
}
