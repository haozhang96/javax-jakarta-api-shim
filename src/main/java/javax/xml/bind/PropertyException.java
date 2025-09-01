package javax.xml.bind;

import javax.shim.ShimSupport;

/**
 * @deprecated Use {@link jakarta.xml.bind.PropertyException} instead.
 * @apiNote This class cannot extend {@link jakarta.xml.bind.PropertyException} due to class hierarchy divergence.
 */
@Deprecated(since = "jakarta.xml.bind.PropertyException")
public class PropertyException extends JAXBException {
    private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.PropertyException#PropertyException(String, Object)
     */
    public PropertyException(String name, Object value) {
        super(new jakarta.xml.bind.PropertyException(name, value).getMessage());
    }

    /**
     * @see jakarta.xml.bind.PropertyException#PropertyException(String)
     */
    public PropertyException(String message) {
        super(message);
    }

    /**
     * @see jakarta.xml.bind.PropertyException#PropertyException(String, String)
     */
    public PropertyException(String message, String errorCode) {
        super(message, errorCode);
    }

    /**
     * @see jakarta.xml.bind.PropertyException#PropertyException(String, String, Throwable)
     */
    public PropertyException(String message, String errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }

    /**
     * @see jakarta.xml.bind.PropertyException#PropertyException(String, Throwable)
     */
    public PropertyException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @see jakarta.xml.bind.PropertyException#PropertyException(Throwable)
     */
    public PropertyException(Throwable cause) {
        super(cause);
    }
}
