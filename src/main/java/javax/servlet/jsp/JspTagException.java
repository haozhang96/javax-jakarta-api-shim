package javax.servlet.jsp;

import javax.shim.ShimSupport;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.JspTagException} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp.JspTagException")
public class JspTagException extends JspException {
    private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

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
    public JspTagException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @see jakarta.servlet.jsp.JspTagException#JspTagException(Throwable)
     */
    public JspTagException(Throwable cause) {
        super(cause);
    }
}
