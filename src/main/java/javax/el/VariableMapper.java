package javax.el;

/**
 * @deprecated Use {@link jakarta.el.VariableMapper} instead.
 */
@Deprecated(since = "jakarta.el.VariableMapper")
public abstract class VariableMapper extends jakarta.el.VariableMapper implements ELShim {
    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    public abstract ValueExpression setVariable(String variable, ValueExpression expression);

    //==================================================================================================================
    // VariableMapper Implementation Methods
    //==================================================================================================================

    @Override
    public abstract jakarta.el.ValueExpression resolveVariable(String variable); // TODO

    @Override
    public jakarta.el.ValueExpression setVariable(String variable, jakarta.el.ValueExpression expression) {
        return new Retrofits.ValueExpression(setVariable(variable, ELShim.<ValueExpression>of(expression)));
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ELShim.initialize();
    }
}
