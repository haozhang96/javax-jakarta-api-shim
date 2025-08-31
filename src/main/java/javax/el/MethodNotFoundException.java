package javax.el;

/**
 * @deprecated Use {@link jakarta.el.MethodNotFoundException} instead.
 * @apiNote This class cannot extend {@link jakarta.el.MethodNotFoundException} due to class hierarchy divergence.
 */
@Deprecated(since = "jakarta.el.MethodNotFoundException")
public class MethodNotFoundException extends ELException implements ELShim {
    private static final long serialVersionUID =
        javax.shim.ShimSupport.getSerialVersionUID(jakarta.el.MethodNotFoundException.class);

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.el.MethodNotFoundException#MethodNotFoundException()
     */
    public MethodNotFoundException() {
        super();
    }

    /**
     * @see jakarta.el.MethodNotFoundException#MethodNotFoundException(String)
     */
    public MethodNotFoundException(String message) {
        super(message);
    }

    /**
     * @see jakarta.el.MethodNotFoundException#MethodNotFoundException(String, Throwable)
     */
    public MethodNotFoundException(String message, Throwable rootCause) {
        super(message, rootCause);
    }

    /**
     * @see jakarta.el.MethodNotFoundException#MethodNotFoundException(Throwable)
     */
    public MethodNotFoundException(Throwable rootCause) {
        super(rootCause);
    }
}
