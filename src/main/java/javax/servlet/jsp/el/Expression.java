package javax.servlet.jsp.el;

import javax.servlet.jsp.JSPShim;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.el.Expression} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp.el.Expression")
public abstract class Expression extends jakarta.servlet.jsp.el.Expression implements JSPShim {
    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see jakarta.servlet.jsp.el.Expression#evaluate(jakarta.servlet.jsp.el.VariableResolver)
     */
    public abstract Object evaluate(VariableResolver variableResolver) throws ELException;
    
    //==================================================================================================================
    // Expression Implementation Methods
    //==================================================================================================================

    @Override
    public Object evaluate(jakarta.servlet.jsp.el.VariableResolver variableResolver) throws ELException {
        return evaluate(JSPShim.of(variableResolver));
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JSPShim.initialize();
    }
}
