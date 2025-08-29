package javax.el;

/**
 * @deprecated Use {@link jakarta.el.BeanNameResolver} instead.
 */
@Deprecated(since = "jakarta.el.BeanNameResolver")
public abstract class BeanNameResolver extends jakarta.el.BeanNameResolver implements ELShim {
    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ELShim.initialize();
    }
}
