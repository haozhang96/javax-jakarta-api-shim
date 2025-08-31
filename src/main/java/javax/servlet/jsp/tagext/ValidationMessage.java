package javax.servlet.jsp.tagext;

import javax.servlet.jsp.JSPShim;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.tagext.ValidationMessage} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp.tagext.ValidationMessage")
public class ValidationMessage extends jakarta.servlet.jsp.tagext.ValidationMessage implements JSPShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.servlet.jsp.tagext.ValidationMessage#ValidationMessage(String, String)
     */
    public ValidationMessage(String id, String message) {
        super(id, message);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JSPShim.initialize();
    }
}
