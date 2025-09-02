package javax.xml.bind.helpers;

import javax.xml.bind.JAXBShim;
import javax.xml.bind.ParseConversionEvent;
import javax.xml.bind.ValidationEventLocator;

/**
 * @deprecated Use {@link jakarta.xml.bind.helpers.ParseConversionEventImpl} instead.
 */
@Deprecated(since = "jakarta.xml.bind.helpers.ParseConversionEventImpl")
public class ParseConversionEventImpl extends jakarta.xml.bind.helpers.ParseConversionEventImpl implements ParseConversionEvent {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.helpers.ParseConversionEventImpl#ParseConversionEventImpl(int, String, jakarta.xml.bind.ValidationEventLocator)
     */
    public ParseConversionEventImpl(int severity, String message, ValidationEventLocator locator) {
        super(severity, message, locator);
    }

    /**
     * @see jakarta.xml.bind.helpers.ParseConversionEventImpl#ParseConversionEventImpl(int, String, jakarta.xml.bind.ValidationEventLocator, Throwable)
     */
    public ParseConversionEventImpl(int severity, String message, ValidationEventLocator locator, Throwable linkedException) {
        super(severity, message, locator, linkedException);
    }

    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.helpers.ParseConversionEventImpl#setLocator(jakarta.xml.bind.ValidationEventLocator)
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
