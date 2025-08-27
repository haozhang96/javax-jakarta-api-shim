package javax.servlet;

import java.io.IOException;

/**
 * @deprecated Use {@link jakarta.servlet.GenericServlet} instead.
 */
@Deprecated(since = "jakarta.servlet.GenericServlet")
public abstract class GenericServlet extends jakarta.servlet.GenericServlet implements Servlet, ServletConfig {
    private static final long serialVersionUID = -8592279577370996712L; // Use the ID from jakarta.servlet.

    //==================================================================================================================
    // GenericServlet Implementation Methods
    //==================================================================================================================

    @Override
    public ServletConfig getServletConfig() {
        return ServletShim.of(super.getServletConfig());
    }

    //==================================================================================================================
    // Servlet Implementation Methods
    //==================================================================================================================

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            super.init(config);
        } catch (jakarta.servlet.ServletException exception) {
            throw ServletShim.of(exception);
        }
    }

    @Override
    public void init(jakarta.servlet.ServletConfig config) throws ServletException {
        Servlet.super.init(config);
    }

    @Override
    public void init() throws ServletException {
        try {
            super.init();
        } catch (jakarta.servlet.ServletException exception) {
            throw ServletShim.of(exception);
        }
    }

    @Override
    public void service(
        jakarta.servlet.ServletRequest request,
        jakarta.servlet.ServletResponse response
    ) throws ServletException, IOException {
        Servlet.super.service(request, response);
    }

    //==================================================================================================================
    // ServletConfig Implementation Methods
    //==================================================================================================================

    @Override
    public ServletContext getServletContext() {
        return ServletShim.of(super.getServletContext());
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ServletShim.initialize();
    }
}
