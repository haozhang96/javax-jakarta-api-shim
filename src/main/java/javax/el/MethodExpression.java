package javax.el;

/**
 * @deprecated Use {@link jakarta.el.MethodExpression} instead.
 * @apiNote This class cannot extend {@link jakarta.el.MethodExpression} due to class hierarchy divergence.
 */
@Deprecated(since = "jakarta.el.MethodExpression")
public abstract class MethodExpression extends Expression {
    private static final long serialVersionUID = javax.shim.ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // MethodExpression Implementation Methods
    //==================================================================================================================

    /**
     * @see jakarta.el.MethodExpression#getMethodInfo(jakarta.el.ELContext)
     */
    public abstract MethodInfo getMethodInfo(ELContext context);

    /**
     * @see jakarta.el.MethodExpression#invoke(jakarta.el.ELContext, Object[])
     */
    public abstract Object invoke(ELContext context, Object[] parameters);

    /**
     * @see jakarta.el.MethodExpression#isParametersProvided()
     */
    public boolean isParametersProvided() {
        return false;
    }

    /**
     * @see jakarta.el.MethodExpression#getMethodReference(jakarta.el.ELContext)
     */
    public MethodReference getMethodReference(ELContext context) {
        context.notifyBeforeEvaluation(getExpressionString());
        context.notifyAfterEvaluation(getExpressionString());
        return null;
    }
}
