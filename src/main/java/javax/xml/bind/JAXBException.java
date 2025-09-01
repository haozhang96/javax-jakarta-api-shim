package javax.xml.bind;

import javax.shim.ShimSupport;

/**
 * @deprecated Use {@link jakarta.xml.bind.JAXBException} instead.
 */
@Deprecated(since = "jakarta.xml.bind.JAXBException")
public class JAXBException extends jakarta.xml.bind.JAXBException implements JAXBShim {
    private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.JAXBException#JAXBException(String)
     */
    public JAXBException(String message) {
        super(message);
    }

    /**
     * @see jakarta.xml.bind.JAXBException#JAXBException(String, String)
     */
    public JAXBException(String message, String errorCode) {
        super(message, errorCode);
    }

    /**
     * @see jakarta.xml.bind.JAXBException#JAXBException(String, String, Throwable)
     */
    public JAXBException(String message, String errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }

    /**
     * @see jakarta.xml.bind.JAXBException#JAXBException(String, Throwable)
     */
    public JAXBException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @see jakarta.xml.bind.JAXBException#JAXBException(Throwable)
     */
    public JAXBException(Throwable cause) {
        super(cause);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JAXBShim.initialize();
    }
}
