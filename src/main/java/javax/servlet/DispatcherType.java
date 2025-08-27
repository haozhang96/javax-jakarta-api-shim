package javax.servlet;

/**
 * @deprecated Use {@link jakarta.servlet.DispatcherType} instead.
 */
@Deprecated(since = "jakarta.servlet.DispatcherType")
public enum DispatcherType implements ServletShim.Enum<jakarta.servlet.DispatcherType> {
    FORWARD, INCLUDE, REQUEST, ASYNC, ERROR;

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ServletShim.initialize();
    }
}
