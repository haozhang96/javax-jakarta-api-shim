package javax.el;

/**
 * @deprecated Use {@link jakarta.el.FunctionMapper} instead.
 */
@Deprecated(since = "jakarta.el.FunctionMapper")
public abstract class FunctionMapper extends jakarta.el.FunctionMapper implements ELShim {
    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ELShim.initialize();
    }
}
