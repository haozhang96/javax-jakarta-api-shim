package javax.servlet;

import java.io.IOException;

/**
 * @deprecated Use {@link jakarta.servlet.ServletResponseWrapper} instead.
 */
@Deprecated(since = "jakarta.servlet.ServletResponseWrapper")
public class ServletResponseWrapper extends jakarta.servlet.ServletResponseWrapper implements ServletResponse {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.servlet.ServletResponseWrapper#ServletResponseWrapper(jakarta.servlet.ServletResponse)
     */
    public ServletResponseWrapper(ServletResponse response) {
        super(response);
    }

    protected ServletResponseWrapper(jakarta.servlet.ServletResponse response) {
        super(shim(response));
    }

    //==================================================================================================================
    // ServletResponseWrapper Implementation Methods
    //==================================================================================================================

    @Override
    public ServletResponse getResponse() {
        return ServletShim.of(super.getResponse());
    }

    //==================================================================================================================
    // ServletResponse Implementation Methods
    //==================================================================================================================

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return ServletShim.of(super.getOutputStream());
    }

    //==================================================================================================================
    // Private Helper Methods
    //==================================================================================================================

    /**
     * @implNote This method exists to avoid circular dependency between {@link ServletShim#of(Object)} and
     *           {@link ServletResponseWrapper}.
     */
    private static ServletResponse shim(jakarta.servlet.ServletResponse response) {
        if (response instanceof ServletResponse) {
            return (ServletResponse) response;
        } else if (response instanceof jakarta.servlet.http.HttpServletResponse) {
            return new Facades.HttpServletResponse((jakarta.servlet.http.HttpServletResponse) response);
        } else {
            return new Facades.ServletResponse(response);
        }
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ServletShim.initialize();
    }
}
