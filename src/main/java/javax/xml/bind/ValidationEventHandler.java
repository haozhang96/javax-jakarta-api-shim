package javax.xml.bind;

/**
 * @deprecated Use {@link jakarta.xml.bind.ValidationEventHandler} instead.
 */
@Deprecated(since = "jakarta.xml.bind.ValidationEventHandler")
public interface ValidationEventHandler extends jakarta.xml.bind.ValidationEventHandler, JAXBShim {
    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.ValidationEventHandler#handleEvent(jakarta.xml.bind.ValidationEvent)
     */
    boolean handleEvent(ValidationEvent event);

    //==================================================================================================================
    // ValidationEventHandler Implementation Methods
    //==================================================================================================================

    @Override
    default boolean handleEvent(jakarta.xml.bind.ValidationEvent event) {
        return handleEvent(JAXBShim.of(event));
    }
}
