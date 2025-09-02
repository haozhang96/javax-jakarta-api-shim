package javax.el;

import javax.shim.ShimSupport;

/**
 * @deprecated Use {@link jakarta.el.Expression} instead.
 */
@Deprecated(since = "jakarta.el.Expression")
public abstract class Expression extends jakarta.el.Expression implements ELShim {
    private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ELShim.initialize();
    }
}
