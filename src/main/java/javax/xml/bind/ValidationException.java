package javax.xml.bind;

import javax.shim.ShimSupport;

/**
 * @deprecated Use {@link jakarta.xml.bind.ValidationException} instead.
 * @apiNote This class cannot extend {@link jakarta.xml.bind.ValidationException} due to class hierarchy divergence.
 */
@Deprecated(since = "jakarta.xml.bind.ValidationException")
public class ValidationException extends JAXBException {
    private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.ValidationException#ValidationException(String)
     */
    public ValidationException(String message) {
        super(message);
    }

    /**
     * @see jakarta.xml.bind.ValidationException#ValidationException(String, String)
     */
    public ValidationException(String message, String errorCode) {
        super(message, errorCode);
    }

    /**
     * @see jakarta.xml.bind.ValidationException#ValidationException(String, String, Throwable)
     */
    public ValidationException(String message, String errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }

    /**
     * @see jakarta.xml.bind.ValidationException#ValidationException(String, Throwable)
     */
    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @see jakarta.xml.bind.ValidationException#ValidationException(Throwable)
     */
    public ValidationException(Throwable cause) {
        super(cause);
    }
}
