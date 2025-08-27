package javax.servlet;

/**
 * @deprecated Use {@link jakarta.servlet.AsyncEvent} instead.
 */
@Deprecated(since = "jakarta.servlet.AsyncEvent")
public class AsyncEvent extends jakarta.servlet.AsyncEvent implements ServletShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.servlet.AsyncEvent#AsyncEvent(jakarta.servlet.AsyncContext)
     */
    public AsyncEvent(AsyncContext context) {
        super(context);
    }

    /**
     * @see jakarta.servlet.AsyncEvent#AsyncEvent(jakarta.servlet.AsyncContext, jakarta.servlet.ServletRequest, jakarta.servlet.ServletResponse)
     */
    public AsyncEvent(AsyncContext context, ServletRequest request, ServletResponse response) {
        super(context, request, response);
    }

    /**
     * @see jakarta.servlet.AsyncEvent#AsyncEvent(jakarta.servlet.AsyncContext, Throwable)
     */
    public AsyncEvent(AsyncContext context, Throwable cause) {
        super(context, cause);
    }

    /**
     * @see jakarta.servlet.AsyncEvent#AsyncEvent(jakarta.servlet.AsyncContext, jakarta.servlet.ServletRequest, jakarta.servlet.ServletResponse, Throwable)
     */
    public AsyncEvent(AsyncContext context, ServletRequest request, ServletResponse response, Throwable cause) {
        super(context, request, response, cause);
    }

    //==================================================================================================================
    // AsyncEvent Implementation Methods
    //==================================================================================================================

    @Override
    public AsyncContext getAsyncContext() {
        return ServletShim.of(super.getAsyncContext());
    }

    @Override
    public ServletRequest getSuppliedRequest() {
        return ServletShim.of(super.getSuppliedRequest());
    }

    @Override
    public ServletResponse getSuppliedResponse() {
        return ServletShim.of(super.getSuppliedResponse());
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ServletShim.initialize();
    }
}
