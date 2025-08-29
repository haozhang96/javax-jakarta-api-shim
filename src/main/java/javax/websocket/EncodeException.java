package javax.websocket;

/**
 * @deprecated Use {@link jakarta.websocket.EncodeException} instead.
 */
@Deprecated(since = "jakarta.websocket.EncodeException")
public class EncodeException extends jakarta.websocket.EncodeException implements WebSocketShim {
    private static final long serialVersionUID = javax.shim.ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.websocket.EncodeException#EncodeException(Object, String)
     */
    public EncodeException(Object object, String message) {
        super(object, message);
    }

    /**
     * @see jakarta.websocket.EncodeException#EncodeException(Object, String, Throwable)
     */
    public EncodeException(Object object, String message, Throwable cause) {
        super(object, message, cause);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        WebSocketShim.initialize();
    }
}
