package javax.el;

import javax.shim.ShimSupport;

/**
 * @deprecated Use {@link jakarta.el.PropertyNotWritableException} instead.
 * @apiNote This class cannot extend {@link jakarta.el.PropertyNotWritableException} due to class hierarchy divergence.
 */
@Deprecated(since = "jakarta.el.PropertyNotWritableException")
public class PropertyNotWritableException extends ELException {
    private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.el.PropertyNotWritableException#PropertyNotWritableException()
     */
    public PropertyNotWritableException() {
        super();
    }

    /**
     * @see jakarta.el.PropertyNotWritableException#PropertyNotWritableException(String)
     */
    public PropertyNotWritableException(String message) {
        super(message);
    }

    /**
     * @see jakarta.el.PropertyNotWritableException#PropertyNotWritableException(String, Throwable)
     */
    public PropertyNotWritableException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @see jakarta.el.PropertyNotWritableException#PropertyNotWritableException(Throwable)
     */
    public PropertyNotWritableException(Throwable cause) {
        super(cause);
    }
}
