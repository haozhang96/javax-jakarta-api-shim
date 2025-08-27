package javax.websocket;

/**
 * @deprecated Use {@link jakarta.websocket.Endpoint} instead.
 */
@Deprecated(since = "jakarta.websocket.Endpoint")
public abstract class Endpoint extends jakarta.websocket.Endpoint implements WebSocketShim {
    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    public abstract void onOpen(Session session, EndpointConfig config);

    public void onClose(Session session, CloseReason closeReason) {
        super.onClose(session, closeReason);
    }

    public void onError(Session session, Throwable cause) {
        super.onError(session, cause);
    }

    //==================================================================================================================
    // Endpoint Implementation Methods
    //==================================================================================================================

    @Override
    public void onOpen(jakarta.websocket.Session session, jakarta.websocket.EndpointConfig config) {
        onOpen(WebSocketShim.of(session), WebSocketShim.of(config));
    }

    @Override
    public void onClose(jakarta.websocket.Session session, jakarta.websocket.CloseReason closeReason) {
        onClose(WebSocketShim.of(session), WebSocketShim.of(closeReason));
    }

    @Override
    public void onError(jakarta.websocket.Session session, Throwable cause) {
        onError(WebSocketShim.of(session), cause);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        WebSocketShim.initialize();
    }
}
