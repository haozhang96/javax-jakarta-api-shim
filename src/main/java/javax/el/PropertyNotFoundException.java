package javax.el;

/**
 * @deprecated Use {@link jakarta.el.PropertyNotFoundException} instead.
 * @apiNote This class cannot extend {@link jakarta.el.PropertyNotFoundException} due to class hierarchy divergence.
 * 
 */
@Deprecated(since = "jakarta.el.PropertyNotFoundException")
public class PropertyNotFoundException extends ELException {
    private static final long serialVersionUID =
        javax.shim.ShimSupport.getSerialVersionUID(jakarta.el.PropertyNotFoundException.class);

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.el.PropertyNotFoundException#PropertyNotFoundException()
     */
    public PropertyNotFoundException() {
        super();
    }

    /**
     * @see jakarta.el.PropertyNotFoundException#PropertyNotFoundException(String)
     */
    public PropertyNotFoundException(String message) {
        super(message);
    }

    /**
     * @see jakarta.el.PropertyNotFoundException#PropertyNotFoundException(String, Throwable)
     */
    public PropertyNotFoundException(String message, Throwable rootCause) {
        super(message, rootCause);
    }

    /**
     * @see jakarta.el.PropertyNotFoundException#PropertyNotFoundException(Throwable)
     */
    public PropertyNotFoundException(Throwable rootCause) {
        super(rootCause);
    }
}
