package javax.el;

/**
 * @deprecated Use {@link jakarta.el.Expression} instead.
 */
@Deprecated(since = "jakarta.el.Expression")
public abstract class Expression extends jakarta.el.Expression implements ELShim {
    private static final long serialVersionUID = javax.shim.ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ELShim.initialize();
    }
}
