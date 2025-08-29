package javax.websocket;

/**
 * @deprecated Use {@link jakarta.websocket.DeploymentException} instead.
 */
@Deprecated(since = "jakarta.websocket.DeploymentException")
public class DeploymentException extends jakarta.websocket.DeploymentException implements WebSocketShim {
    private static final long serialVersionUID = javax.shim.ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.websocket.DeploymentException#DeploymentException(String)
     */
    public DeploymentException(String message) {
        super(message);
    }

    /**
     * @see jakarta.websocket.DeploymentException#DeploymentException(String, Throwable)
     */
    public DeploymentException(String message, Throwable cause) {
        super(message, cause);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        WebSocketShim.initialize();
    }
}
