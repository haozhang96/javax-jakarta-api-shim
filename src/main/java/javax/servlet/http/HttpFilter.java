package javax.servlet.http;

import javax.servlet.*;
import java.io.IOException;

/**
 * @deprecated Use {@link jakarta.servlet.http.HttpFilter} instead.
 */
@Deprecated(since = "jakarta.servlet.http.HttpFilter")
public abstract class HttpFilter extends GenericFilter {
    private static final long serialVersionUID = javax.shim.ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // HttpFilter Implementation Methods
    //==================================================================================================================

    /**
     * @see jakarta.servlet.http.HttpFilter#doFilter(jakarta.servlet.http.HttpServletRequest, jakarta.servlet.http.HttpServletResponse, jakarta.servlet.FilterChain)
     */
    @SuppressWarnings("JavadocReference")
    protected void doFilter(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain chain
    ) throws ServletException, IOException {
        chain.doFilter(request, response);
    }

    //==================================================================================================================
    // Filter Implementation Methods
    //==================================================================================================================

    @Override
    public void doFilter(
        ServletRequest request,
        ServletResponse response,
        FilterChain chain
    ) throws ServletException, IOException {
        if (!(request instanceof HttpServletRequest && response instanceof HttpServletResponse)) {
            throw new ServletException("non-HTTP request or response");
        }

        doFilter((HttpServletRequest) request, (HttpServletResponse) response, chain);
    }

    @Override
    public void doFilter(
        jakarta.servlet.ServletRequest request,
        jakarta.servlet.ServletResponse response,
        jakarta.servlet.FilterChain chain
    ) throws ServletException, IOException {
        if (!(request instanceof jakarta.servlet.http.HttpServletRequest && response instanceof jakarta.servlet.http.HttpServletResponse)) {
            throw new ServletException("non-HTTP request or response");
        }

        try {
            super.doFilter(request, response, chain);
        } catch (jakarta.servlet.ServletException exception) {
            throw ServletShim.of(exception);
        }
    }
}
