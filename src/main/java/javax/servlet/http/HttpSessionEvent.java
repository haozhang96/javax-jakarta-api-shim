package javax.servlet.http;

import javax.servlet.ServletShim;

/**
 * @deprecated Use {@link jakarta.servlet.http.HttpSessionEvent} instead.
 */
@Deprecated(since = "jakarta.servlet.http.HttpSessionEvent")
public class HttpSessionEvent extends jakarta.servlet.http.HttpSessionEvent implements ServletShim {
    private static final long serialVersionUID = javax.shim.ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.servlet.http.HttpSessionEvent#HttpSessionEvent(jakarta.servlet.http.HttpSession)
     */
    public HttpSessionEvent(HttpSession source) {
        super(source);
    }

    //==================================================================================================================
    // HttpSessionEvent Implementation Methods
    //==================================================================================================================

    @Override
    public HttpSession getSession() {
        return ServletShim.of(super.getSession());
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ServletShim.initialize();
    }
}
