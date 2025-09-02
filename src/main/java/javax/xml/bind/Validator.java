package javax.xml.bind;

/**
 * @deprecated This method has been deprecated and/or removed since XML Binding 2.0.
 */
@Deprecated(since = "XML Binding 2.0", forRemoval = true)
public interface Validator extends JAXBShim {
    //==================================================================================================================
    // Validator Implementation Methods
    //==================================================================================================================

    boolean validateRoot(Object root) throws JAXBException;

    boolean validate(Object tree) throws JAXBException;

    ValidationEventHandler getEventHandler();

    void setEventHandler(ValidationEventHandler handler);

    Object getProperty(String name) throws PropertyException;

    void setProperty(String name, Object value) throws PropertyException;
}
