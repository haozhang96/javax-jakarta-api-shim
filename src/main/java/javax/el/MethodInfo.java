package javax.el;

/**
 * @deprecated Use {@link jakarta.el.MethodInfo} instead.
 */
@Deprecated(since = "jakarta.el.MethodInfo")
public class MethodInfo extends jakarta.el.MethodInfo implements ELShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.el.MethodInfo#MethodInfo(String, Class, Class[])
     */
    public MethodInfo(String name, Class<?> returnType, Class<?>[] parameterTypes) {
        super(name, returnType, parameterTypes);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ELShim.initialize();
    }
}
