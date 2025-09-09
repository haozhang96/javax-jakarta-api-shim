package javax.servlet.jsp;

import javax.el.ELContextListener;
import javax.el.ELResolver;
import javax.el.ELShim;
import javax.el.ExpressionFactory;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.JspApplicationContext} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp.JspApplicationContext")
public interface JspApplicationContext extends jakarta.servlet.jsp.JspApplicationContext, JSPShim {
    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see jakarta.servlet.jsp.JspApplicationContext#addELResolver(jakarta.el.ELResolver)
     */
    void addELResolver(ELResolver resolver);

    /**
     * @see jakarta.servlet.jsp.JspApplicationContext#addELContextListener(jakarta.el.ELContextListener)
     */
    void addELContextListener(ELContextListener listener);

    //==================================================================================================================
    // JspApplicationContext Implementation Methods
    //==================================================================================================================

    @Override
    default void addELResolver(jakarta.el.ELResolver resolver) {
        addELResolver(ELShim.of(resolver));
    }

    @Override
    ExpressionFactory getExpressionFactory();

    @Override
    default void addELContextListener(jakarta.el.ELContextListener listener) {
        addELContextListener(ELShim.of(listener));
    }
}
