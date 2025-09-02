package javax.servlet.jsp.el;

import javax.servlet.jsp.JSPShim;
import javax.shim.ShimSupport;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.el.ELException} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp.el.ELException")
public class ELException extends jakarta.servlet.jsp.el.ELException implements JSPShim {
    private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

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
    public ELException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @see jakarta.servlet.jsp.el.ELException#ELException(Throwable)
     */
    public ELException(Throwable cause) {
        super(cause);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JSPShim.initialize();
    }
}
