package javax.servlet;

/**
 * @deprecated Use {@link jakarta.servlet.ServletException} instead.
 */
@Deprecated(since = "jakarta.servlet.ServletException")
public class ServletException extends jakarta.servlet.ServletException implements ServletShim {
    private static final long serialVersionUID = 4221302886851315160L; // Use the ID from jakarta.servlet.

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
    public ServletException(String message, Throwable rootCause) {
        super(message, rootCause);
    }

    /**
     * @see jakarta.servlet.ServletException#ServletException(Throwable)
     */
    public ServletException(Throwable rootCause) {
        super(rootCause);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ServletShim.initialize();
    }
}
