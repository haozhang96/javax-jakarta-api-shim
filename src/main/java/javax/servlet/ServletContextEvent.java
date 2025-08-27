package javax.servlet;

/**
 * @deprecated Use {@link jakarta.servlet.ServletContextEvent} instead.
 */
@Deprecated(since = "jakarta.servlet.ServletContextEvent")
public class ServletContextEvent extends jakarta.servlet.ServletContextEvent implements ServletShim {
    private static final long serialVersionUID = -7501701636134222423L; // Use the ID from jakarta.servlet.

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.servlet.ServletContextEvent#ServletContextEvent(jakarta.servlet.ServletContext)
     */
    public ServletContextEvent(ServletContext source) {
        super(source);
    }

    //==================================================================================================================
    // ServletContextEvent Implementation Methods
    //==================================================================================================================

    @Override
    public ServletContext getServletContext() {
        return ServletShim.of(super.getServletContext());
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ServletShim.initialize();
    }
}
