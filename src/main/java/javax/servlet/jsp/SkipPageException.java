package javax.servlet.jsp;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.SkipPageException} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp.SkipPageException")
public class SkipPageException extends JspException {
    private static final long serialVersionUID = javax.shim.ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.servlet.jsp.SkipPageException#SkipPageException()
     */
    public SkipPageException() {
        super();
    }

    /**
     * @see jakarta.servlet.jsp.SkipPageException#SkipPageException(String)
     */
    public SkipPageException(String message) {
        super(message);
    }

    /**
     * @see jakarta.servlet.jsp.SkipPageException#SkipPageException(String, Throwable)
     */
    public SkipPageException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @see jakarta.servlet.jsp.SkipPageException#SkipPageException(Throwable)
     */
    public SkipPageException(Throwable cause) {
        super(cause);
    }
}
