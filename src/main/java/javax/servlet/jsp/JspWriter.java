package javax.servlet.jsp;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.JspWriter} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp.JspWriter")
public abstract class JspWriter extends jakarta.servlet.jsp.JspWriter implements JSPShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.servlet.jsp.JspWriter#JspWriter(int, boolean)
     */
    protected JspWriter(int bufferSize, boolean autoFlush) {
        super(bufferSize, autoFlush);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JSPShim.initialize();
    }
}
