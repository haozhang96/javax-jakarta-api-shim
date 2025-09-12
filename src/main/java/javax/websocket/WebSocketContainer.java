package javax.websocket;

import java.io.IOException;
import java.net.URI;
import java.util.Set;

/**
 * @deprecated Use {@link jakarta.websocket.WebSocketContainer} instead.
 */
@Deprecated(since = "jakarta.websocket.WebSocketContainer")
public interface WebSocketContainer extends jakarta.websocket.WebSocketContainer, WebSocketShim {
    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    Session connectToServer(
        Endpoint endpointInstance,
        ClientEndpointConfig endpointConfig,
        URI path
    ) throws DeploymentException, IOException;

    Session connectToServer(
        Class<? extends Endpoint> endpointClass,
        ClientEndpointConfig endpointConfig,
        URI path
    ) throws DeploymentException, IOException;

    //==================================================================================================================
    // WebSocketContainer Implementation Methods
    //==================================================================================================================

    @Override
    Session connectToServer(Object annotatedEndpointInstance, URI path) throws DeploymentException, IOException;

    @Override
    Session connectToServer(Class<?> annotatedEndpointClass, URI path) throws DeploymentException, IOException;

    @Override
    default Session connectToServer(
        jakarta.websocket.Endpoint endpointInstance,
        jakarta.websocket.ClientEndpointConfig endpointConfig,
        URI path
    ) throws DeploymentException, IOException {
        return connectToServer(WebSocketShim.<Endpoint>of(endpointInstance), WebSocketShim.of(endpointConfig), path);
    }

    @Override
    default Session connectToServer(
        Class<? extends jakarta.websocket.Endpoint> endpointClass,
        jakarta.websocket.ClientEndpointConfig endpointConfig,
        URI path
    ) throws DeploymentException, IOException {
        return connectToServer(WebSocketShim.of(endpointClass, Endpoint.class), WebSocketShim.of(endpointConfig), path);
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    Set getInstalledExtensions();
}
