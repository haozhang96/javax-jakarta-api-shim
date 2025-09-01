package javax.xml.bind;

import javax.shim.ShimSupport;

/**
 * @deprecated Use {@link jakarta.xml.bind.MarshalException} instead.
 * @apiNote This class cannot extend {@link jakarta.xml.bind.MarshalException} due to class hierarchy divergence.
 */
@Deprecated(since = "jakarta.xml.bind.MarshalException")
public class MarshalException extends JAXBException {
    private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.MarshalException#MarshalException(String)
     */
    public MarshalException(String message) {
        super(message);
    }

    /**
     * @see jakarta.xml.bind.MarshalException#MarshalException(String, String)
     */
    public MarshalException(String message, String errorCode) {
        super(message, errorCode);
    }

    /**
     * @see jakarta.xml.bind.MarshalException#MarshalException(String, String, Throwable)
     */
    public MarshalException(String message, String errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }

    /**
     * @see jakarta.xml.bind.MarshalException#MarshalException(String, Throwable)
     */
    public MarshalException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @see jakarta.xml.bind.MarshalException#MarshalException(Throwable)
     */
    public MarshalException(Throwable cause) {
        super(cause);
    }
}
