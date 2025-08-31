package javax.servlet.jsp.tagext;

import javax.servlet.jsp.JSPShim;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.tagext.TagVariableInfo} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp.tagext.TagVariableInfo")
public class TagVariableInfo extends jakarta.servlet.jsp.tagext.TagVariableInfo implements JSPShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.servlet.jsp.tagext.TagVariableInfo#TagVariableInfo(String, String, String, boolean, int)
     */
    public TagVariableInfo(String nameGiven, String nameFromAttribute, String className, boolean declare, int scope) {
        super(nameGiven, nameFromAttribute, className, declare, scope);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JSPShim.initialize();
    }
}
