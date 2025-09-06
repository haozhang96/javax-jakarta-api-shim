package javax.servlet.jsp.tagext;

import javax.servlet.jsp.JSPShim;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.tagext.FunctionInfo} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp.tagext.FunctionInfo")
public class FunctionInfo extends jakarta.servlet.jsp.tagext.FunctionInfo implements JSPShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.servlet.jsp.tagext.FunctionInfo#FunctionInfo(String, String, String)
     */
    public FunctionInfo(String name, String clazz, String signature) {
        super(name, clazz, signature);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JSPShim.initialize();
    }
}
