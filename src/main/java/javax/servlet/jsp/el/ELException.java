package javax.servlet.jsp.el;

import javax.servlet.jsp.JSPShim;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.el.ELException} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp.el.ELException")
public class ELException extends jakarta.servlet.jsp.el.ELException implements JSPShim {
    private static final long serialVersionUID = javax.shim.ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.servlet.jsp.el.ELException#ELException()
     */
    public ELException() {
        super();
    }

    /**
     * @see jakarta.servlet.jsp.el.ELException#ELException(String)
     */
    public ELException(String message) {
        super(message);
    }

    /**
     * @see jakarta.servlet.jsp.el.ELException#ELException(String, Throwable)
     */
    public ELException(String message, Throwable rootCause) {
        super(message, rootCause);
    }

    /**
     * @see jakarta.servlet.jsp.el.ELException#ELException(Throwable)
     */
    public ELException(Throwable rootCause) {
        super(rootCause);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JSPShim.initialize();
    }
}
