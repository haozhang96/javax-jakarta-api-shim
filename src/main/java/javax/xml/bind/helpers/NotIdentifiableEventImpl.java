package javax.xml.bind.helpers;

import javax.xml.bind.JAXBShim;
import javax.xml.bind.NotIdentifiableEvent;
import javax.xml.bind.ValidationEventLocator;

/**
 * @deprecated Use {@link jakarta.xml.bind.helpers.NotIdentifiableEventImpl} instead.
 */
@Deprecated(since = "jakarta.xml.bind.helpers.NotIdentifiableEventImpl")
public class NotIdentifiableEventImpl extends jakarta.xml.bind.helpers.NotIdentifiableEventImpl implements NotIdentifiableEvent {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.helpers.NotIdentifiableEventImpl#NotIdentifiableEventImpl(int, String, jakarta.xml.bind.ValidationEventLocator)
     */
    public NotIdentifiableEventImpl(int severity, String message, ValidationEventLocator locator) {
        super(severity, message, locator);
    }

    /**
     * @see jakarta.xml.bind.helpers.NotIdentifiableEventImpl#NotIdentifiableEventImpl(int, String, jakarta.xml.bind.ValidationEventLocator, Throwable)
     */
    public NotIdentifiableEventImpl(int severity, String message, ValidationEventLocator locator, Throwable linkedException) {
        super(severity, message, locator, linkedException);
    }

    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.helpers.NotIdentifiableEventImpl#setLocator(jakarta.xml.bind.ValidationEventLocator)
     */
    public void setLocator(ValidationEventLocator locator) {
        super.setLocator(locator);
    }

    //==================================================================================================================
    // ValidationEvent Implementation Methods
    //==================================================================================================================

    @Override
    public ValidationEventLocator getLocator() {
        return JAXBShim.of(super.getLocator());
    }

    @Override
    public void setLocator(jakarta.xml.bind.ValidationEventLocator locator) {
        setLocator(JAXBShim.of(locator));
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JAXBShim.initialize();
    }
}
