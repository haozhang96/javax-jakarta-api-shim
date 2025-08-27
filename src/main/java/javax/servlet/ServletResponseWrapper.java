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
    public ServletResponseWrapper(ServletResponse request) {
        super(request);
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
    // Static Initialization
    //==================================================================================================================

    static {
        ServletShim.initialize();
    }
}
