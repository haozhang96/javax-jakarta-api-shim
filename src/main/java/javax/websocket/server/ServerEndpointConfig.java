package javax.websocket.server;

import javax.websocket.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @deprecated Use {@link jakarta.websocket.server.ServerEndpointConfig} instead.
 */
@Deprecated(since = "jakarta.websocket.server.ServerEndpointConfig")
@SuppressWarnings("unchecked")
public interface ServerEndpointConfig extends jakarta.websocket.server.ServerEndpointConfig, EndpointConfig {
    //==================================================================================================================
    // ServerEndpointConfig Implementation Methods
    //==================================================================================================================

    @Override
    @SuppressWarnings("rawtypes")
    List getExtensions();

    @Override
    Configurator getConfigurator();

    //==================================================================================================================
    // ServerEndpointConfig.Configurator Implementation
    //==================================================================================================================

    /**
     * @deprecated Use {@link jakarta.websocket.server.ServerEndpointConfig.Configurator} instead.
     */
    @Deprecated(since = "jakarta.websocket.server.ServerEndpointConfig.Configurator")
    class Configurator extends jakarta.websocket.server.ServerEndpointConfig.Configurator implements WebSocketShim {
        //==============================================================================================================
        // Shim Methods
        //==============================================================================================================

        public void modifyHandshake(
            ServerEndpointConfig endpointConfig,
            HandshakeRequest request,
            HandshakeResponse response
        ) {
            super.modifyHandshake(endpointConfig, request, response);
        }

        //==============================================================================================================
        // ServerEndpointConfig.Configurator Implementation Methods
        //==============================================================================================================

        @Override
        public Configurator getContainerDefaultConfigurator() {
            return WebSocketShim.of(super.getContainerDefaultConfigurator());
        }

        @Override
        public List<Extension> getNegotiatedExtensions(List installed, List requested) {
            return WebSocketShim
                .<Extension>of(super.getNegotiatedExtensions(installed, requested))
                .collect(Collectors.toList());
        }

        @Override
        public void modifyHandshake(
            jakarta.websocket.server.ServerEndpointConfig endpointConfig,
            jakarta.websocket.server.HandshakeRequest request,
            jakarta.websocket.HandshakeResponse response
        ) {
            modifyHandshake(WebSocketShim.of(endpointConfig), WebSocketShim.of(request), WebSocketShim.of(response));
        }
    }

    //==================================================================================================================
    // ServerEndpointConfig.Builder Implementation
    //==================================================================================================================

    /**
     * @deprecated Use {@link jakarta.websocket.server.ServerEndpointConfig.Builder} instead.
     */
    @Deprecated(since = "jakarta.websocket.server.ServerEndpointConfig.Builder")
    class Builder extends Facade<jakarta.websocket.server.ServerEndpointConfig.Builder> {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        private Builder(Class<?> endpointClass, String path) {
            this(jakarta.websocket.server.ServerEndpointConfig.Builder.create(endpointClass, path));
        }

        protected Builder(jakarta.websocket.server.ServerEndpointConfig.Builder target) {
            super(target);
        }

        //==============================================================================================================
        // Factory Methods
        //==============================================================================================================

        /**
         * @see jakarta.websocket.server.ServerEndpointConfig.Builder#create(Class, String)
         */
        public static Builder create(Class<?> endpointClass, String path) {
            return new Builder(endpointClass, path);
        }

        //==============================================================================================================
        // ServerEndpointConfig.Builder Implementation Methods
        //==============================================================================================================

        /**
         * @see jakarta.websocket.server.ServerEndpointConfig.Builder#build()
         */
        public ServerEndpointConfig build() {
            return WebSocketShim.of(target.build());
        }

        /**
         * @see jakarta.websocket.server.ServerEndpointConfig.Builder#encoders(List)
         */
        public Builder encoders(List<Class<? extends Encoder>> encoders) {
            return WebSocketShim.of(target.encoders(Collections.unmodifiableList(encoders)));
        }

        /**
         * @see jakarta.websocket.server.ServerEndpointConfig.Builder#decoders(List)
         */
        public Builder decoders(List<Class<? extends Decoder>> decoders) {
            return WebSocketShim.of(target.decoders(Collections.unmodifiableList(decoders)));
        }

        /**
         * @see jakarta.websocket.server.ServerEndpointConfig.Builder#subprotocols(List)
         */
        public Builder subprotocols(List<String> subprotocols) {
            return WebSocketShim.of(target.subprotocols(subprotocols));
        }

        /**
         * @see jakarta.websocket.server.ServerEndpointConfig.Builder#extensions(List)
         */
        public Builder extensions(List<Extension> extensions) {
            return WebSocketShim.of(target.extensions(Collections.unmodifiableList(extensions)));
        }

        /**
         * @see jakarta.websocket.server.ServerEndpointConfig.Builder#configurator(jakarta.websocket.server.ServerEndpointConfig.Configurator)
         */
        public Builder configurator(Configurator serverEndpointConfigurator) {
            return WebSocketShim.of(target.configurator(serverEndpointConfigurator));
        }
    }
}
