package javax.xml.bind.util;

import javax.xml.bind.JAXBShim;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

/**
 * @deprecated Use {@link jakarta.xml.bind.util.ValidationEventCollector} instead.
 */
@Deprecated(since = "jakarta.xml.bind.util.ValidationEventCollector")
public class ValidationEventCollector extends jakarta.xml.bind.util.ValidationEventCollector implements ValidationEventHandler {
    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    @Override
    public boolean handleEvent(ValidationEvent event) {
        return super.handleEvent(event);
    }

    //==================================================================================================================
    // ValidationEventCollector Implementation Methods
    //==================================================================================================================

    @Override
    public ValidationEvent[] getEvents() {
        return JAXBShim
            .<ValidationEvent>of(super.getEvents())
            .toArray(ValidationEvent[]::new);
    }

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
