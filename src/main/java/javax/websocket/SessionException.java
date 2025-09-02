package javax.websocket;

import javax.shim.ShimSupport;

/**
 * @deprecated Use {@link jakarta.websocket.SessionException} instead.
 */
@Deprecated(since = "jakarta.websocket.SessionException")
public class SessionException extends jakarta.websocket.SessionException implements WebSocketShim {
    private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.websocket.SessionException#SessionException(String, Throwable, jakarta.websocket.Session)
     */
    public SessionException(String message, Throwable cause, Session session) {
        super(message, cause, session);
    }

    //==================================================================================================================
    // SessionException Implementation Methods
    //==================================================================================================================

    @Override
    public Session getSession() {
        return WebSocketShim.of(super.getSession());
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        WebSocketShim.initialize();
    }
}
