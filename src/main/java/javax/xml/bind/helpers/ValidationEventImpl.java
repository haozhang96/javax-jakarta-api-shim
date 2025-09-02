package javax.xml.bind.helpers;

import javax.xml.bind.JAXBShim;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventLocator;

/**
 * @deprecated Use {@link jakarta.xml.bind.helpers.ValidationEventImpl} instead.
 */
@Deprecated(since = "jakarta.xml.bind.helpers.ValidationEventImpl")
public class ValidationEventImpl extends jakarta.xml.bind.helpers.ValidationEventImpl implements ValidationEvent {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.helpers.ValidationEventImpl#ValidationEventImpl(int, String, jakarta.xml.bind.ValidationEventLocator)
     */
    public ValidationEventImpl(int severity, String message, ValidationEventLocator locator) {
        super(severity, message, locator);
    }

    /**
     * @see jakarta.xml.bind.helpers.ValidationEventImpl#ValidationEventImpl(int, String, jakarta.xml.bind.ValidationEventLocator, Throwable)
     */
    public ValidationEventImpl(int severity, String message, ValidationEventLocator locator, Throwable linkedException) {
        super(severity, message, locator, linkedException);
    }

    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.helpers.ValidationEventImpl#setLocator(jakarta.xml.bind.ValidationEventLocator)
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
