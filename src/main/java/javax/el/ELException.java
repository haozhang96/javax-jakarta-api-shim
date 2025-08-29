package javax.el;

/**
 * @deprecated Use {@link jakarta.el.ELException} instead.
 */
@Deprecated(since = "jakarta.el.ELException")
public class ELException extends jakarta.el.ELException implements ELShim {
    private static final long serialVersionUID = javax.shim.ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.el.ELException#ELException()
     */
    public ELException() {
        super();
    }

    /**
     * @see jakarta.el.ELException#ELException(String)
     */
    public ELException(String message) {
        super(message);
    }

    /**
     * @see jakarta.el.ELException#ELException(String, Throwable)
     */
    public ELException(String message, Throwable rootCause) {
        super(message, rootCause);
    }

    /**
     * @see jakarta.el.ELException#ELException(Throwable)
     */
    public ELException(Throwable rootCause) {
        super(rootCause);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ELShim.initialize();
    }
}
