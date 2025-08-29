package javax.el;

/**
 * @deprecated Use {@link jakarta.el.PropertyNotWritableException} instead.
 */
@Deprecated(since = "jakarta.el.PropertyNotWritableException")
public class PropertyNotWritableException extends ELException implements ELShim {
    private static final long serialVersionUID =
        javax.shim.ShimSupport.getSerialVersionUID(jakarta.el.PropertyNotWritableException.class);

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
    public PropertyNotWritableException(String message, Throwable rootCause) {
        super(message, rootCause);
    }

    /**
     * @see jakarta.el.PropertyNotWritableException#PropertyNotWritableException(Throwable)
     */
    public PropertyNotWritableException(Throwable rootCause) {
        super(rootCause);
    }
}
