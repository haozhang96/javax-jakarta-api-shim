package javax.el;

/**
 * @deprecated Use {@link jakarta.el.EvaluationListener} instead.
 */
@Deprecated(since = "jakarta.el.EvaluationListener")
public abstract class EvaluationListener extends jakarta.el.EvaluationListener implements ELShim {
    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see jakarta.el.EvaluationListener#beforeEvaluation(jakarta.el.ELContext, String)
     */
    public abstract void beforeEvaluation(ELContext context, String expression);

    /**
     * @see jakarta.el.EvaluationListener#afterEvaluation(jakarta.el.ELContext, String)
     */
    public abstract void afterEvaluation(ELContext context, String expression);

    /**
     * @see jakarta.el.EvaluationListener#propertyResolved(jakarta.el.ELContext, Object, Object)
     */
    public abstract void propertyResolved(ELContext context, Object bean, Object property);

    //==================================================================================================================
    // EvaluationListener Implementation Methods
    //==================================================================================================================

    @Override
    public void beforeEvaluation(jakarta.el.ELContext context, String expression) {
        beforeEvaluation(ELShim.of(context), expression);
    }

    @Override
    public void afterEvaluation(jakarta.el.ELContext context, String expression) {
        afterEvaluation(ELShim.of(context), expression);
    }

    @Override
    public void propertyResolved(jakarta.el.ELContext context, Object bean, Object property) {
        propertyResolved(ELShim.of(context), bean, property);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ELShim.initialize();
    }
}
