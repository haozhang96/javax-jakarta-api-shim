package javax.xml.bind;

/**
 * @deprecated Use {@link jakarta.xml.bind.UnmarshalException} instead.
 * @apiNote This class cannot extend {@link jakarta.xml.bind.UnmarshalException} due to class hierarchy divergence.
 */
@Deprecated(since = "jakarta.xml.bind.UnmarshalException")
public class UnmarshalException extends JAXBException {
    private static final long serialVersionUID = javax.shim.ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.UnmarshalException#UnmarshalException(String)
     */
    public UnmarshalException(String message) {
        super(message);
    }

    /**
     * @see jakarta.xml.bind.UnmarshalException#UnmarshalException(String, String)
     */
    public UnmarshalException(String message, String errorCode) {
        super(message, errorCode);
    }

    /**
     * @see jakarta.xml.bind.UnmarshalException#UnmarshalException(String, String, Throwable)
     */
    public UnmarshalException(String message, String errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }

    /**
     * @see jakarta.xml.bind.UnmarshalException#UnmarshalException(String, Throwable)
     */
    public UnmarshalException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @see jakarta.xml.bind.UnmarshalException#UnmarshalException(Throwable)
     */
    public UnmarshalException(Throwable cause) {
        super(cause);
    }
}
