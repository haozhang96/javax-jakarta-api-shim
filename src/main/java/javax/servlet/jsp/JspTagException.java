package javax.servlet.jsp;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.JspTagException} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp.JspTagException")
public class JspTagException extends JspException {
    private static final long serialVersionUID = javax.shim.ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.servlet.jsp.JspTagException#JspTagException()
     */
    public JspTagException() {
        super();
    }

    /**
     * @see jakarta.servlet.jsp.JspTagException#JspTagException(String)
     */
    public JspTagException(String message) {
        super(message);
    }

    /**
     * @see jakarta.servlet.jsp.JspTagException#JspTagException(String, Throwable)
     */
    public JspTagException(String message, Throwable rootCause) {
        super(message, rootCause);
    }

    /**
     * @see jakarta.servlet.jsp.JspTagException#JspTagException(Throwable)
     */
    public JspTagException(Throwable rootCause) {
        super(rootCause);
    }
}
