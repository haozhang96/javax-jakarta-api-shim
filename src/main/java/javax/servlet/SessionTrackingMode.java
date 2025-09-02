package javax.servlet;

/**
 * @deprecated Use {@link jakarta.servlet.SessionTrackingMode} instead.
 */
@Deprecated(since = "jakarta.servlet.SessionTrackingMode")
public enum SessionTrackingMode implements ServletShim.Enum<jakarta.servlet.SessionTrackingMode> {
    /**
     * @see jakarta.servlet.SessionTrackingMode#COOKIE
     */
    COOKIE,

    /**
     * @see jakarta.servlet.SessionTrackingMode#URL
     */
    URL,

    /**
     * @see jakarta.servlet.SessionTrackingMode#SSL
     */
    SSL;

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ServletShim.initialize();
    }
}
