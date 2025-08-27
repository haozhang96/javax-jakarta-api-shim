package javax.servlet;

/**
 * @deprecated Use {@link jakarta.servlet.SessionTrackingMode} instead.
 */
@Deprecated(since = "jakarta.servlet.SessionTrackingMode")
public enum SessionTrackingMode implements ServletShim.Enum<jakarta.servlet.SessionTrackingMode> {
    COOKIE, URL, SSL;

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ServletShim.initialize();
    }
}
