package javax.websocket;

import javax.shim.ShimSupport;
import java.nio.ByteBuffer;

/**
 * @deprecated Use {@link jakarta.websocket.DecodeException} instead.
 */
@Deprecated(since = "jakarta.websocket.DecodeException")
public class DecodeException extends jakarta.websocket.DecodeException implements WebSocketShim {
    private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.websocket.DecodeException#DecodeException(String, String)
     */
    public DecodeException(String text, String message) {
        super(text, message);
    }

    /**
     * @see jakarta.websocket.DecodeException#DecodeException(ByteBuffer, String)
     */
    public DecodeException(ByteBuffer bytes, String message) {
        super(bytes, message);
    }

    /**
     * @see jakarta.websocket.DecodeException#DecodeException(String, String, Throwable)
     */
    public DecodeException(String text, String message, Throwable cause) {
        super(text, message, cause);
    }

    /**
     * @see jakarta.websocket.DecodeException#DecodeException(ByteBuffer, String, Throwable)
     */
    public DecodeException(ByteBuffer bytes, String message, Throwable cause) {
        super(bytes, message, cause);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        WebSocketShim.initialize();
    }
}
