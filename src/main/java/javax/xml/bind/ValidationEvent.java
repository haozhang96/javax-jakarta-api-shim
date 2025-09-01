package javax.xml.bind;

/**
 * @deprecated Use {@link jakarta.xml.bind.ValidationEvent} instead.
 */
@Deprecated(since = "jakarta.xml.bind.ValidationEvent")
public interface ValidationEvent extends jakarta.xml.bind.ValidationEvent, JAXBShim {
    //==================================================================================================================
    // ValidationEvent Implementation Methods
    //==================================================================================================================

    @Override
    ValidationEventLocator getLocator();
}
