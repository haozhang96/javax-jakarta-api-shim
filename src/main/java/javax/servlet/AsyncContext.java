package javax.servlet;

/**
 * @deprecated Use {@link jakarta.servlet.AsyncContext} instead.
 */
@Deprecated(since = "jakarta.servlet.AsyncContext")
public interface AsyncContext extends jakarta.servlet.AsyncContext, ServletShim {
    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see #dispatch(jakarta.servlet.ServletContext, String)
     */
    void dispatch(ServletContext context, String path);

    /**
     * @see #addListener(jakarta.servlet.AsyncListener)
     */
    void addListener(AsyncListener listener);

    /**
     * @see #addListener(jakarta.servlet.AsyncListener, jakarta.servlet.ServletRequest, jakarta.servlet.ServletResponse)
     */
    void addListener(AsyncListener listener, ServletRequest request, ServletResponse response);

    //==================================================================================================================
    // AsyncContext Implementation Methods
    //==================================================================================================================

    @Override
    ServletRequest getRequest();

    @Override
    ServletResponse getResponse();

    @Override
    default void dispatch(jakarta.servlet.ServletContext context, String path) {
        dispatch(ServletShim.of(context), path);
    }

    @Override
    default void addListener(jakarta.servlet.AsyncListener listener) {
        addListener(ServletShim.of(listener));
    }

    @Override
    default void addListener(
        jakarta.servlet.AsyncListener listener,
        jakarta.servlet.ServletRequest request,
        jakarta.servlet.ServletResponse response
    ) {
        addListener(ServletShim.of(listener), ServletShim.of(request), ServletShim.of(response));
    }

    @Override
    @SuppressWarnings("unchecked")
    AsyncListener createListener(Class clazz) throws ServletException;
}
