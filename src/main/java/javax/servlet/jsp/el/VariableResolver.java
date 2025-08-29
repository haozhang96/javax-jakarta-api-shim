package javax.servlet.jsp.el;

import javax.servlet.jsp.JSPShim;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.el.VariableResolver} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp.el.VariableResolver")
public interface VariableResolver extends jakarta.servlet.jsp.el.VariableResolver, JSPShim {
    //==================================================================================================================
    // VariableResolver Implementation Methods
    //==================================================================================================================

    @Override
    Object resolveVariable(String name) throws ELException;
}
