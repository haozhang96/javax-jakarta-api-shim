package javax.servlet.jsp;

import javax.servlet.ServletShim;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.JspException} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp.JspException")
public class JspException extends jakarta.servlet.jsp.JspException implements JSPShim {
    private static final long serialVersionUID = -724329986255528641L; // Use the ID from jakarta.servlet.jsp.

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
    public JspException(String message, Throwable rootCause) {
        super(message, rootCause);
    }

    /**
     * @see jakarta.servlet.jsp.JspException#JspException(Throwable)
     */
    public JspException(Throwable rootCause) {
        super(rootCause);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ServletShim.initialize();
    }
}
