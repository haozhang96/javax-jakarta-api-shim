package javax.servlet.jsp;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.JspException} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp.JspException")
public class JspException extends jakarta.servlet.jsp.JspException implements JSPShim {
    private static final long serialVersionUID = javax.shim.ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.servlet.jsp.JspException#JspException()
     */
    public JspException() {
        super();
    }

    /**
     * @see jakarta.servlet.jsp.JspException#JspException(String)
     */
    public JspException(String message) {
        super(message);
    }

    /**
     * @see jakarta.servlet.jsp.JspException#JspException(String, Throwable)
     */
    public JspException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @see jakarta.servlet.jsp.JspException#JspException(Throwable)
     */
    public JspException(Throwable cause) {
        super(cause);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JSPShim.initialize();
    }
}
