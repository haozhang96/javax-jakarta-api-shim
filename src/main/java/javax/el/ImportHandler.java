package javax.el;

/**
 * @deprecated Use {@link jakarta.el.ImportHandler} instead.
 */
@Deprecated(since = "jakarta.el.ImportHandler")
public abstract class ImportHandler extends jakarta.el.ImportHandler implements ELShim {
    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ELShim.initialize();
    }
}
