package javax.servlet.jsp.tagext;

import javax.servlet.jsp.JSPShim;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import java.io.IOException;
import java.io.Writer;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.tagext.JspFragment} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp.tagext.JspFragment")
public abstract class JspFragment extends jakarta.servlet.jsp.tagext.JspFragment implements JSPShim {
    //==================================================================================================================
    // JspFragment Implementation Methods
    //==================================================================================================================

    @Override
    public abstract void invoke(Writer out) throws JspException, IOException;

    @Override
    public abstract JspContext getJspContext();

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JSPShim.initialize();
    }
}
