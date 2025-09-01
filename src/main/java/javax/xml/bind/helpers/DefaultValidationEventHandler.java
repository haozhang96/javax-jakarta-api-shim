package javax.xml.bind.helpers;

import javax.xml.bind.JAXBShim;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

/**
 * @deprecated Use {@link jakarta.xml.bind.helpers.DefaultValidationEventHandler} instead.
 */
@Deprecated(since = "jakarta.xml.bind.helpers.DefaultValidationEventHandler")
public class DefaultValidationEventHandler extends jakarta.xml.bind.helpers.DefaultValidationEventHandler implements ValidationEventHandler {
    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    @Override
    public boolean handleEvent(ValidationEvent event) {
        return super.handleEvent(event);
    }

    //==================================================================================================================
    // DefaultValidationEventHandler Implementation Methods
    //==================================================================================================================

    @Override
    public boolean handleEvent(jakarta.xml.bind.ValidationEvent event) {
        return handleEvent(JAXBShim.of(event));
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JAXBShim.initialize();
    }
}
