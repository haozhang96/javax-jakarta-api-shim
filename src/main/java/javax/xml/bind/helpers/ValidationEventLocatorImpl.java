package javax.xml.bind.helpers;

import org.w3c.dom.Node;
import org.xml.sax.Locator;
import org.xml.sax.SAXParseException;

import javax.xml.bind.JAXBShim;
import javax.xml.bind.ValidationEventLocator;

/**
 * @deprecated Use {@link jakarta.xml.bind.helpers.ValidationEventLocatorImpl} instead.
 */
@Deprecated(since = "jakarta.xml.bind.helpers.ValidationEventLocatorImpl")
public class ValidationEventLocatorImpl extends jakarta.xml.bind.helpers.ValidationEventLocatorImpl implements ValidationEventLocator {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.helpers.ValidationEventLocatorImpl#ValidationEventLocatorImpl(Locator)
     */
    public ValidationEventLocatorImpl(Locator locator) {
        super(locator);
    }

    /**
     * @see jakarta.xml.bind.helpers.ValidationEventLocatorImpl#ValidationEventLocatorImpl(SAXParseException)
     */
    public ValidationEventLocatorImpl(SAXParseException exception) {
        super(exception);
    }

    /**
     * @see jakarta.xml.bind.helpers.ValidationEventLocatorImpl#ValidationEventLocatorImpl(Node)
     */
    public ValidationEventLocatorImpl(Node node) {
        super(node);
    }

    /**
     * @see jakarta.xml.bind.helpers.ValidationEventLocatorImpl#ValidationEventLocatorImpl(Object)
     */
    public ValidationEventLocatorImpl(Object object) {
        super(object);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JAXBShim.initialize();
    }
}
