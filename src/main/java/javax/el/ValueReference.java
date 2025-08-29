package javax.el;

/**
 * @deprecated Use {@link jakarta.el.ValueReference} instead.
 */
@Deprecated(since = "jakarta.el.ValueReference")
public class ValueReference extends jakarta.el.ValueReference implements ELShim {
    private static final long serialVersionUID = javax.shim.ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.el.ValueReference#ValueReference(Object, Object)
     */
    public ValueReference(Object bean, Object property) {
        super(bean, property);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ELShim.initialize();
    }
}
