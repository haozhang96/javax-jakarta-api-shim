package javax.servlet.jsp.tagext;

import javax.servlet.jsp.JSPShim;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.tagext.VariableInfo} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp.tagext.VariableInfo")
public class VariableInfo extends jakarta.servlet.jsp.tagext.VariableInfo implements JSPShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.servlet.jsp.tagext.VariableInfo#VariableInfo(String, String, boolean, int)
     */
    public VariableInfo(String name, String className, boolean declare, int scope) {
        super(name, className, declare, scope);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JSPShim.initialize();
    }
}
