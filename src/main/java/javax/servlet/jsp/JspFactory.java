package javax.servlet.jsp;

import javax.servlet.*;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.JspFactory} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp.JspFactory")
public abstract class JspFactory extends jakarta.servlet.jsp.JspFactory implements JSPShim {
    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    public abstract PageContext getPageContext(
        Servlet servlet,
        ServletRequest request,
        ServletResponse response,
        String errorPageURL,
        boolean needsSession,
        int bufferSize,
        boolean autoFlush
    );

    public abstract void releasePageContext(PageContext context);

    public abstract JspApplicationContext getJspApplicationContext(ServletContext context);

    //==================================================================================================================
    // JspFactory Implementation Methods
    //==================================================================================================================

    @Override
    public jakarta.servlet.jsp.PageContext getPageContext(
        jakarta.servlet.Servlet servlet,
        jakarta.servlet.ServletRequest request,
        jakarta.servlet.ServletResponse response,
        String errorPageURL,
        boolean needsSession,
        int bufferSize,
        boolean autoFlush
    ) {
        return new Retrofits.PageContext(getPageContext(
            ServletShim.of(servlet),
            ServletShim.of(request),
            ServletShim.of(response),
            errorPageURL,
            needsSession,
            bufferSize,
            autoFlush
        ));
    }

    @Override
    public void releasePageContext(jakarta.servlet.jsp.PageContext context) {
        releasePageContext(JSPShim.<PageContext>of(context));
    }

    @Override
    public abstract JspEngineInfo getEngineInfo();

    @Override
    public JspApplicationContext getJspApplicationContext(jakarta.servlet.ServletContext context) {
        return getJspApplicationContext(ServletShim.of(context));
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JSPShim.initialize();
    }
}
