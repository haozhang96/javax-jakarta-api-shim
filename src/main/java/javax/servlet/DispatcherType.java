package javax.servlet;

/**
 * @deprecated Use {@link jakarta.servlet.DispatcherType} instead.
 */
@Deprecated(since = "jakarta.servlet.DispatcherType")
public enum DispatcherType implements ServletShim.Enum<jakarta.servlet.DispatcherType> {
    /**
     * @see jakarta.servlet.DispatcherType#FORWARD
     */
    FORWARD,

    /**
     * @see jakarta.servlet.DispatcherType#INCLUDE
     */
    INCLUDE,

    /**
     * @see jakarta.servlet.DispatcherType#REQUEST
     */
    REQUEST,

    /**
     * @see jakarta.servlet.DispatcherType#ASYNC
     */
    ASYNC,

    /**
     * @see jakarta.servlet.DispatcherType#ERROR
     */
    ERROR;

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ServletShim.initialize();
    }
}
