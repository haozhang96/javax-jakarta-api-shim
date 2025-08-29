package javax.servlet.jsp.el;

import javax.servlet.jsp.JSPShim;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.el.ExpressionEvaluator} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp.el.ExpressionEvaluator")
public abstract class ExpressionEvaluator extends jakarta.servlet.jsp.el.ExpressionEvaluator implements JSPShim {
    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see jakarta.servlet.jsp.el.ExpressionEvaluator#parseExpression(String, Class, jakarta.servlet.jsp.el.FunctionMapper)
     */
    public abstract Expression parseExpression(
        String expression,
        Class<?> expectedType,
        FunctionMapper functionMapper
    ) throws ELException;

    /**
     * @see jakarta.servlet.jsp.el.ExpressionEvaluator#evaluate(String, Class, jakarta.servlet.jsp.el.VariableResolver, jakarta.servlet.jsp.el.FunctionMapper)
     */
    public abstract Object evaluate(
        String expression,
        Class<?> expectedType,
        VariableResolver variableResolver,
        FunctionMapper functionMapper
    ) throws ELException;

    //==================================================================================================================
    // ExpressionEvaluator Implementation Methods
    //==================================================================================================================

    @Override
    public Expression parseExpression(
        String expression,
        Class<?> expectedType,
        jakarta.servlet.jsp.el.FunctionMapper functionMapper
    ) throws ELException {
        return parseExpression(expression, expectedType, JSPShim.of(functionMapper));
    }

    @Override
    public Object evaluate(
        String expression,
        Class<?> expectedType,
        jakarta.servlet.jsp.el.VariableResolver variableResolver,
        jakarta.servlet.jsp.el.FunctionMapper functionMapper
    ) throws ELException {
        return evaluate(expression, expectedType, JSPShim.of(variableResolver), JSPShim.of(functionMapper));
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JSPShim.initialize();
    }
}
