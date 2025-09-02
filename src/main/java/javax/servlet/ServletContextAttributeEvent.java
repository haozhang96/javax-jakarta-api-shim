package javax.servlet;

import javax.shim.ShimSupport;

/**
 * @deprecated Use {@link jakarta.servlet.ServletContextAttributeEvent} instead.
 */
@Deprecated(since = "jakarta.servlet.ServletContextAttributeEvent")
public class ServletContextAttributeEvent extends ServletContextEvent {
    private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

    private final String name;
    private final Object value;

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.servlet.ServletContextAttributeEvent#ServletContextAttributeEvent(jakarta.servlet.ServletContext, String, Object)
     */
    public ServletContextAttributeEvent(ServletContext source, String name, Object value) {
        super(source);
        this.name = name;
        this.value = value;
    }

    //==================================================================================================================
    // Accessor Methods
    //==================================================================================================================

    /**
     * @see jakarta.servlet.ServletContextAttributeEvent#getName()
     */
    public String getName() {
        return name;
    }

    /**
     * @see jakarta.servlet.ServletContextAttributeEvent#getValue()
     */
    public Object getValue() {
        return value;
    }
}
