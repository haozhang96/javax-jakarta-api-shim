package javax.servlet.jsp;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.JspEngineInfo} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp.JspEngineInfo")
public abstract class JspEngineInfo extends jakarta.servlet.jsp.JspEngineInfo implements JSPShim {
    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JSPShim.initialize();
    }
}
