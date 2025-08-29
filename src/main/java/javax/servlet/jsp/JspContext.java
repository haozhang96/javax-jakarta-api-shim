package javax.servlet.jsp;

import javax.el.ELContext;
import javax.servlet.jsp.el.ExpressionEvaluator;
import javax.servlet.jsp.el.VariableResolver;
import java.io.Writer;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.JspContext} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp.JspContext")
public abstract class JspContext extends jakarta.servlet.jsp.JspContext implements JSPShim {
    //==================================================================================================================
    // JspContext Implementation Methods
    //==================================================================================================================

    @Deprecated
    @Override
    public abstract ExpressionEvaluator getExpressionEvaluator();

    @Deprecated
    @Override
    public abstract VariableResolver getVariableResolver();

    @Override
    public abstract ELContext getELContext();

    @Override
    public abstract JspWriter getOut();

    @Override
    public JspWriter pushBody(Writer writer) {
        return JSPShim.of(super.pushBody(writer));
    }

    @Override
    public JspWriter popBody() {
        return JSPShim.of(super.popBody());
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JSPShim.initialize();
    }
}
