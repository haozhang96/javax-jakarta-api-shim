package javax.xml.bind.helpers;

import javax.xml.bind.JAXBShim;
import javax.xml.bind.PrintConversionEvent;
import javax.xml.bind.ValidationEventLocator;

/**
 * @deprecated Use {@link jakarta.xml.bind.helpers.PrintConversionEventImpl} instead.
 */
@Deprecated(since = "jakarta.xml.bind.helpers.PrintConversionEventImpl")
public class PrintConversionEventImpl extends jakarta.xml.bind.helpers.PrintConversionEventImpl implements PrintConversionEvent {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.helpers.PrintConversionEventImpl#PrintConversionEventImpl(int, String, jakarta.xml.bind.ValidationEventLocator)
     */
    public PrintConversionEventImpl(int severity, String message, ValidationEventLocator locator) {
        super(severity, message, locator);
    }

    /**
     * @see jakarta.xml.bind.helpers.PrintConversionEventImpl#PrintConversionEventImpl(int, String, jakarta.xml.bind.ValidationEventLocator, Throwable)
     */
    public PrintConversionEventImpl(int severity, String message, ValidationEventLocator locator, Throwable linkedException) {
        super(severity, message, locator, linkedException);
    }

    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.helpers.PrintConversionEventImpl#setLocator(jakarta.xml.bind.ValidationEventLocator)
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
