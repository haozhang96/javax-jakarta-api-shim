package javax.el;

import javax.shim.ShimSupport;

/**
 * @deprecated Use {@link jakarta.el.ELException} instead.
 */
@Deprecated(since = "jakarta.el.ELException")
public class ELException extends jakarta.el.ELException implements ELShim {
    private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

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
    public ELException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @see jakarta.el.ELException#ELException(Throwable)
     */
    public ELException(Throwable cause) {
        super(cause);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ELShim.initialize();
    }
}
