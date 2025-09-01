package javax.servlet;

/**
 * @deprecated Use {@link jakarta.servlet.ServletException} instead.
 */
@Deprecated(since = "jakarta.servlet.ServletException")
public class ServletException extends jakarta.servlet.ServletException implements ServletShim {
    private static final long serialVersionUID = javax.shim.ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.servlet.ServletException#ServletException()
     */
    public ServletException() {
        super();
    }

    /**
     * @see jakarta.servlet.ServletException#ServletException(String)
     */
    public ServletException(String message) {
        super(message);
    }

    /**
     * @see jakarta.servlet.ServletException#ServletException(String, Throwable)
     */
    public ServletException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @see jakarta.servlet.ServletException#ServletException(Throwable)
     */
    public ServletException(Throwable cause) {
        super(cause);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ServletShim.initialize();
    }
}
