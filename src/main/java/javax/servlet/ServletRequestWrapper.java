package javax.servlet;

import java.io.IOException;

/**
 * @deprecated Use {@link jakarta.servlet.ServletRequestWrapper} instead.
 */
@Deprecated(since = "jakarta.servlet.ServletRequestWrapper")
public class ServletRequestWrapper extends jakarta.servlet.ServletRequestWrapper implements ServletRequest {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.servlet.ServletRequestWrapper#ServletRequestWrapper(jakarta.servlet.ServletRequest)
     */
    public ServletRequestWrapper(ServletRequest request) {
        super(request);
    }

    //==================================================================================================================
    // ServletRequestWrapper Implementation Methods
    //==================================================================================================================

    @Override
    public ServletRequest getRequest() {
        return ServletShim.of(super.getRequest());
    }

    //==================================================================================================================
    // ServletRequest Implementation Methods
    //==================================================================================================================

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return ServletShim.of(super.getInputStream());
    }

    @Override
    public RequestDispatcher getRequestDispatcher(String path) {
        return ServletShim.of(super.getRequestDispatcher(path));
    }

    @Override
    public ServletContext getServletContext() {
        return ServletShim.of(super.getServletContext());
    }

    @Override
    public AsyncContext startAsync() throws IllegalStateException {
        return ServletShim.of(super.startAsync());
    }

    @Override
    public AsyncContext startAsync(ServletRequest request, ServletResponse response) throws IllegalStateException {
        return ServletShim.of(super.startAsync(request, response));
    }

    @Override
    public AsyncContext startAsync(
        jakarta.servlet.ServletRequest request,
        jakarta.servlet.ServletResponse response
    ) throws IllegalStateException {
        return ServletRequest.super.startAsync(request, response);
    }

//    @Override
//    public DispatcherType getDispatcherType() {
//        return ServletShim.of(super.getDispatcherType());
//    }

    @Override
    public AsyncContext getAsyncContext() {
        return ServletShim.of(super.getAsyncContext());
    }

    @Override
    public ServletConnection getServletConnection() {
        return ServletShim.of(super.getServletContext());
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ServletShim.initialize();
    }
}
