package javax.el;

/**
 * @deprecated Use {@link jakarta.el.ELContextEvent} instead.
 */
@Deprecated(since = "jakarta.el.ELContextEvent")
public class ELContextEvent extends jakarta.el.ELContextEvent implements ELShim {
    private static final long serialVersionUID = javax.shim.ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.el.ELContextEvent#ELContextEvent(jakarta.el.ELContext)
     */
    public ELContextEvent(ELContext source) {
        super(source);
    }

    //==================================================================================================================
    // ServletContextEvent Implementation Methods
    //==================================================================================================================

    @Override
    public ELContext getELContext() {
        return ELShim.of(super.getELContext());
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ELShim.initialize();
    }
}
