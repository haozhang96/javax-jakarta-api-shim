package javax.servlet;

import java.io.IOException;

/**
 * @deprecated Use {@link jakarta.servlet.ServletRequest} instead.
 */
@Deprecated(since = "jakarta.servlet.ServletRequest")
public interface ServletRequest extends jakarta.servlet.ServletRequest, ServletShim {
    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see #startAsync(jakarta.servlet.ServletRequest, jakarta.servlet.ServletResponse)
     */
    AsyncContext startAsync(ServletRequest request, ServletResponse response) throws IllegalStateException;

    /**
     * @deprecated This method has been deprecated and/or removed since Servlet 2.1.
     */
    @Deprecated(since = "Servlet 2.1", forRemoval = true)
    default String getRealPath(String path) {
        return getServletContext().getRealPath(path);
    }

    //==================================================================================================================
    // ServletRequest Implementation Methods
    //==================================================================================================================

    @Override
    ServletInputStream getInputStream() throws IOException;

    @Override
    RequestDispatcher getRequestDispatcher(String path);

    @Override
    ServletContext getServletContext();

    @Override
    AsyncContext startAsync() throws IllegalStateException;

    @Override
    default AsyncContext startAsync(
        jakarta.servlet.ServletRequest request,
        jakarta.servlet.ServletResponse response
    ) throws IllegalStateException {
        return startAsync(ServletShim.of(request), ServletShim.of(response));
    }

//    @Override
//    DispatcherType getDispatcherType();

    @Override
    AsyncContext getAsyncContext();

    @Override
    ServletConnection getServletConnection();
}
