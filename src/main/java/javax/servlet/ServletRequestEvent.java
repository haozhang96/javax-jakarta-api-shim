package javax.servlet;

import javax.shim.ShimSupport;

/**
 * @deprecated Use {@link jakarta.servlet.ServletRequestEvent} instead.
 */
@Deprecated(since = "jakarta.servlet.ServletRequestEvent")
public class ServletRequestEvent extends jakarta.servlet.ServletRequestEvent implements ServletShim {
    private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.servlet.ServletRequestEvent#ServletRequestEvent(jakarta.servlet.ServletContext, jakarta.servlet.ServletRequest)
     */
    public ServletRequestEvent(ServletContext source, ServletRequest request) {
        super(source, request);
    }

    ServletRequestEvent(ServletRequest request) {
        this(request.getServletContext(), request);
    }

    //==================================================================================================================
    // ServletRequestEvent Implementation Methods
    //==================================================================================================================

    @Override
    public ServletContext getServletContext() {
        return ServletShim.of(super.getServletContext());
    }

    @Override
    public ServletRequest getServletRequest() {
        return ServletShim.of(super.getServletRequest());
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ServletShim.initialize();
    }
}
