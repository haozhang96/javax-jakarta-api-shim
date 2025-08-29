package javax.el;

import java.lang.annotation.Annotation;

/**
 * @deprecated Use {@link jakarta.el.MethodReference} instead.
 */
@Deprecated(since = "jakarta.el.MethodReference")
public class MethodReference extends jakarta.el.MethodReference implements ELShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.el.MethodReference#MethodReference(Object, jakarta.el.MethodInfo, Annotation[], Object[])
     */
    public MethodReference(Object bean, MethodInfo methodInfo, Annotation[] annotations, Object[] evaluatedParameters) {
        super(bean, methodInfo, annotations, evaluatedParameters);
    }

    //==================================================================================================================
    // MethodReference Implementation Methods
    //==================================================================================================================

    @Override
    public MethodInfo getMethodInfo() {
        return ELShim.of(super.getMethodInfo());
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ELShim.initialize();
    }
}
