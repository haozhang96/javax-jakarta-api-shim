package javax.servlet.jsp.el;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.el.ELParseException} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp.el.ELParseException")
public class ELParseException extends ELException {
    private static final long serialVersionUID = javax.shim.ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.servlet.jsp.el.ELParseException#ELParseException()
     */
    public ELParseException() {
        super();
    }

    /**
     * @see jakarta.servlet.jsp.el.ELParseException#ELParseException(String)
     */
    public ELParseException(String message) {
        super(message);
    }
}
