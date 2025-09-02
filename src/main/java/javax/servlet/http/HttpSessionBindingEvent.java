package javax.servlet.http;

import javax.shim.ShimSupport;

/**
 * @deprecated Use {@link jakarta.servlet.http.HttpSessionBindingEvent} instead.
 */
@Deprecated(since = "jakarta.servlet.http.HttpSessionBindingEvent")
public class HttpSessionBindingEvent extends HttpSessionEvent {
    private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

    private final String name;
    private final Object value;

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.servlet.http.HttpSessionBindingEvent#HttpSessionBindingEvent(jakarta.servlet.http.HttpSession, String)
     */
    public HttpSessionBindingEvent(HttpSession source, String name) {
        this(source, name, null);
    }

    /**
     * @see jakarta.servlet.http.HttpSessionBindingEvent#HttpSessionBindingEvent(jakarta.servlet.http.HttpSession, String, Object)
     */
    public HttpSessionBindingEvent(HttpSession source, String name, Object value) {
        super(source);
        this.name = name;
        this.value = value;
    }

    //==================================================================================================================
    // Accessor Methods
    //==================================================================================================================

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
