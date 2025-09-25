package javax.el;

import javax.shim.ShimSupport;
import java.lang.invoke.MethodHandles;

/**
 * @deprecated Use {@link jakarta.el.ELManager} instead.
 */
@Deprecated(since = "jakarta.el.ELManager")
public class ELManager extends jakarta.el.ELManager implements ELShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    public ELManager() {
        ShimSupport.Reflect.call(MethodHandles.lookup(), ShimSupport.Class.toJakarta(), (lookup, clazz) -> {
            lookup
                .findVarHandle(clazz, "elContext", jakarta.el.StandardELContext.class)
                .set(this, new Retrofits.StandardELContext(new StandardELContext(getExpressionFactory())));
            return null;
        });
    }

    //==================================================================================================================
    // Factory Methods
    //==================================================================================================================

    /**
     * @see jakarta.el.ExpressionFactory#newInstance()
     */
    public static ExpressionFactory getExpressionFactory() {
        return ELShim.of(jakarta.el.ELManager.getExpressionFactory());
    }

    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see jakarta.el.ELManager#setELContext(jakarta.el.ELContext)
     */
    public ELContext setELContext(ELContext context) {
        return ELShim.of(super.setELContext(context));
    }

    /**
     * @see jakarta.el.ELManager#addBeanNameResolver(jakarta.el.BeanNameResolver)
     */
    public void addBeanNameResolver(BeanNameResolver beanNameResolver) {
        super.addBeanNameResolver(beanNameResolver);
    }

    /**
     * @see jakarta.el.ELManager#addELResolver(jakarta.el.ELResolver)
     */
    public void addELResolver(ELResolver resolver) {
        super.addELResolver(resolver);
    }

    /**
     * @see jakarta.el.ELManager#setVariable(String, jakarta.el.ValueExpression)
     */
    public void setVariable(String variable, ValueExpression expression) {
        super.setVariable(variable, new Retrofits.ValueExpression(expression));
    }

    /**
     * @see jakarta.el.ELManager#addEvaluationListener(jakarta.el.EvaluationListener)
     */
    public void addEvaluationListener(EvaluationListener listener) {
        super.addEvaluationListener(listener);
    }

    //==================================================================================================================
    // ELManager Implementation Methods
    //==================================================================================================================

    @Override
    public ELContext setELContext(jakarta.el.ELContext context) {
        return setELContext(ELShim.of(context));
    }

    @Override
    public void addBeanNameResolver(jakarta.el.BeanNameResolver beanNameResolver) {
        addBeanNameResolver(ELShim.of(beanNameResolver));
    }

    @Override
    public void addELResolver(jakarta.el.ELResolver resolver) {
        addELResolver(ELShim.of(resolver));
    }

    @Override
    public void setVariable(String variable, jakarta.el.ValueExpression expression) {
        setVariable(variable, ELShim.<ValueExpression>of(expression));
    }

    @Override
    public void addEvaluationListener(jakarta.el.EvaluationListener listener) {
        addEvaluationListener(ELShim.of(listener));
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ELShim.initialize();
    }
}
