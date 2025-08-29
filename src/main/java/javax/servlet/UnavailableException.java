package javax.servlet;

/**
 * @deprecated Use {@link jakarta.servlet.UnavailableException} instead.
 */
@Deprecated(since = "jakarta.servlet.UnavailableException")
public class UnavailableException extends ServletException {
    private static final long serialVersionUID = javax.shim.ShimSupport.getSerialVersionUID();
    private static final int INDETERMINATE = -1;

    private final int seconds;

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.servlet.UnavailableException#UnavailableException(String)
     */
    public UnavailableException(String message) {
        this(message, INDETERMINATE);
    }

    /**
     * @deprecated This constructor has been deprecated and/or removed since Servlet 2.2.
     */
    @Deprecated(since = "Servlet 2.2", forRemoval = true)
    public UnavailableException(Servlet servlet, String message) {
        this(message);
    }

    /**
     * @see jakarta.servlet.UnavailableException#UnavailableException(String, int)
     */
    public UnavailableException(String message, int seconds) {
        super(message);
        this.seconds = seconds != 0 ? Math.max(seconds, INDETERMINATE) : INDETERMINATE;
    }

    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @deprecated This method has been deprecated and/or removed since Servlet 2.2.
     */
    @Deprecated(since = "Servlet 2.2", forRemoval = true)
    public Servlet getServlet() {
        return null;
    }

    //==================================================================================================================
    // UnavailableException Implementation Methods
    //==================================================================================================================

    /**
     * @see jakarta.servlet.UnavailableException#isPermanent()
     */
    public boolean isPermanent() {
        return getUnavailableSeconds() == INDETERMINATE;
    }

    /**
     * @see jakarta.servlet.UnavailableException#getUnavailableSeconds()
     */
    public int getUnavailableSeconds() {
        return seconds;
    }
}
