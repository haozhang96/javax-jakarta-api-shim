package javax.websocket;

/**
 * @deprecated Use {@link jakarta.websocket.DeploymentException} instead.
 */
@Deprecated(since = "jakarta.websocket.DeploymentException")
public class DeploymentException extends jakarta.websocket.DeploymentException implements WebSocketShim {
    private static final long serialVersionUID = 7576860738144220015L; // Use the ID from jakarta.websocket.

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
