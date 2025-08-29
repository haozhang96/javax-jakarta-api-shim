package javax.servlet;

/**
 * @deprecated Use {@link jakarta.servlet.ServletRequestAttributeEvent} instead.
 */
@Deprecated(since = "jakarta.servlet.ServletRequestAttributeEvent")
public class ServletRequestAttributeEvent extends ServletRequestEvent {
    private static final long serialVersionUID = javax.shim.ShimSupport.getSerialVersionUID();

    private final String name;
    private final Object value;

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.servlet.ServletRequestAttributeEvent#ServletRequestAttributeEvent(jakarta.servlet.ServletContext, jakarta.servlet.ServletRequest, String, Object)
     */
    public ServletRequestAttributeEvent(ServletContext source, ServletRequest request, String name, Object value) {
        super(source, request);
        this.name = name;
        this.value = value;
    }

    ServletRequestAttributeEvent(ServletRequest request, String name, Object value) {
        this(request.getServletContext(), request, name, value);
    }

    //==================================================================================================================
    // Accessor Methods
    //==================================================================================================================

    /**
     * @see jakarta.servlet.ServletRequestAttributeEvent#getName()
     */
    public String getName() {
        return name;
    }

    /**
     * @see jakarta.servlet.ServletRequestAttributeEvent#getValue()
     */
    public Object getValue() {
        return value;
    }
}
