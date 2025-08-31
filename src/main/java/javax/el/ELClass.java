package javax.el;

/**
 * @deprecated Use {@link jakarta.el.ELClass} instead.
 */
@Deprecated(since = "jakarta.el.ELClass")
public class ELClass extends jakarta.el.ELClass implements ELShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.el.ELClass#ELClass(Class)
     */
    public ELClass(Class<?> clazz) {
        super(clazz);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ELShim.initialize();
    }
}
