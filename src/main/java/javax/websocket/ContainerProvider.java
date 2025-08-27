package javax.websocket;

/**
 * @deprecated Use {@link jakarta.websocket.ContainerProvider} instead.
 */
@Deprecated(since = "jakarta.websocket.ContainerProvider")
public abstract class ContainerProvider extends jakarta.websocket.ContainerProvider implements WebSocketShim {
    //==================================================================================================================
    // Factory Methods
    //==================================================================================================================

    /**
     * @see jakarta.websocket.ContainerProvider#getWebSocketContainer()
     */
    public static WebSocketContainer getWebSocketContainer() {
        return WebSocketShim.of(jakarta.websocket.ContainerProvider.getWebSocketContainer());
    }

    //==================================================================================================================
    // ContainerProvider Implementation Methods
    //==================================================================================================================

    @Override
    protected abstract WebSocketContainer getContainer();

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        WebSocketShim.initialize();
    }
}
