package javax.websocket;

import javax.shim.Shim;
import java.lang.annotation.Annotation;
import java.util.stream.Stream;

/**
 * @deprecated Use {@link jakarta.websocket} instead.
 */
@Deprecated(since = "jakarta.websocket")
public interface WebSocketShim extends Shim {
    //==================================================================================================================
    // Helper Methods
    //==================================================================================================================

    static void initialize() {
        Shim.initialize();
    }

    //==================================================================================================================
    // Factory Methods
    //==================================================================================================================

    static <S extends WebSocketShim> S of(Object object) {
        //==============================================================================================================
        // Specializations
        //==============================================================================================================

        if (object == null || object instanceof WebSocketShim) {
            return S(object);
        } else if (object instanceof Exception) {
            return S(of((Exception) object));
        } else if (object instanceof Annotation) {
            return S(of((Annotation) object));

        //==============================================================================================================
        // Server-specific APIs
        //==============================================================================================================

        } else if (object instanceof jakarta.websocket.server.HandshakeRequest) {
            return S(new Facades.HandshakeRequest(S(object)));
        } else if (object instanceof jakarta.websocket.server.ServerApplicationConfig) {
            return S(new Facades.ServerApplicationConfig(S(object)));
        } else if (object instanceof jakarta.websocket.server.ServerContainer) {
            return S(new Facades.ServerContainer(S(object)));
        } else if (object instanceof jakarta.websocket.server.ServerEndpointConfig) {
            return S(new Facades.ServerEndpointConfig(S(object)));
        } else if (object instanceof jakarta.websocket.server.ServerEndpointConfig.Builder) {
            return S(new Facades.ServerEndpointConfig$Builder(S(object)));
        } else if (object instanceof jakarta.websocket.server.ServerEndpointConfig.Configurator) {
            return S(new Facades.ServerEndpointConfig$Configurator(S(object)));

        //==============================================================================================================
        // Core & Client-specific APIs
        //==============================================================================================================

        } else if (object instanceof jakarta.websocket.ClientEndpointConfig) {
            return S(new Facades.ClientEndpointConfig(S(object)));
        } else if (object instanceof jakarta.websocket.ClientEndpointConfig.Builder) {
            return S(new Facades.ClientEndpointConfig$Builder(S(object)));
        } else if (object instanceof jakarta.websocket.ClientEndpointConfig.Configurator) {
            return S(new Facades.ClientEndpointConfig$Configurator(S(object)));
        } else if (object instanceof jakarta.websocket.CloseReason) {
            return S(new Facades.CloseReason(S(object)));
        } else if (object instanceof jakarta.websocket.CloseReason.CloseCode) {
            return S(new Facades.CloseReason$CloseCode(S(object)));
        } else if (object instanceof jakarta.websocket.ContainerProvider) {
            return S(new Facades.ContainerProvider(S(object)));
        } else if (object instanceof jakarta.websocket.Decoder.Binary) {
            return S(new Facades.Decoder$Binary<>(S(object)));
        } else if (object instanceof jakarta.websocket.Decoder.BinaryStream) {
            return S(new Facades.Decoder$BinaryStream<>(S(object)));
        } else if (object instanceof jakarta.websocket.Decoder.Text) {
            return S(new Facades.Decoder$Text<>(S(object)));
        } else if (object instanceof jakarta.websocket.Decoder.TextStream) {
            return S(new Facades.Decoder$TextStream<>(S(object)));
        } else if (object instanceof jakarta.websocket.Decoder) {
            return S(new Facades.Decoder(S(object)));
        } else if (object instanceof jakarta.websocket.Encoder.Binary) {
            return S(new Facades.Encoder$Binary<>(S(object)));
        } else if (object instanceof jakarta.websocket.Encoder.BinaryStream) {
            return S(new Facades.Encoder$BinaryStream<>(S(object)));
        } else if (object instanceof jakarta.websocket.Encoder.Text) {
            return S(new Facades.Encoder$Text<>(S(object)));
        } else if (object instanceof jakarta.websocket.Encoder.TextStream) {
            return S(new Facades.Encoder$TextStream<>(S(object)));
        } else if (object instanceof jakarta.websocket.Encoder) {
            return S(new Facades.Encoder(S(object)));
        } else if (object instanceof jakarta.websocket.Endpoint) {
            return S(new Facades.Endpoint(S(object)));
        } else if (object instanceof jakarta.websocket.EndpointConfig) {
            return S(new Facades.EndpointConfig(S(object)));
        } else if (object instanceof jakarta.websocket.Extension) {
            return S(new Facades.Extension(S(object)));
        } else if (object instanceof jakarta.websocket.Extension.Parameter) {
            return S(new Facades.Extension$Parameter(S(object)));
        } else if (object instanceof jakarta.websocket.HandshakeResponse) {
            return S(new Facades.HandshakeResponse(S(object)));
        } else if (object instanceof jakarta.websocket.MessageHandler.Partial) {
            return S(new Facades.MessageHandler$Partial<>(S(object)));
        } else if (object instanceof jakarta.websocket.MessageHandler.Whole) {
            return S(new Facades.MessageHandler$Whole<>(S(object)));
        } else if (object instanceof jakarta.websocket.MessageHandler) {
            return S(new Facades.MessageHandler(S(object)));
        } else if (object instanceof jakarta.websocket.PongMessage) {
            return S(new Facades.PongMessage(S(object)));
        } else if (object instanceof jakarta.websocket.RemoteEndpoint.Async) {
            return S(new Facades.RemoteEndpoint$Async(S(object)));
        } else if (object instanceof jakarta.websocket.RemoteEndpoint.Basic) {
            return S(new Facades.RemoteEndpoint$Basic(S(object)));
        } else if (object instanceof jakarta.websocket.RemoteEndpoint) {
            return S(new Facades.RemoteEndpoint(S(object)));
        } else if (object instanceof jakarta.websocket.SendHandler) {
            return S(new Facades.SendHandler(S(object)));
        } else if (object instanceof jakarta.websocket.SendResult) {
            return S(new Facades.SendResult(S(object)));
        } else if (object instanceof jakarta.websocket.Session) {
            return S(new Facades.Session(S(object)));
        } else if (object instanceof jakarta.websocket.WebSocketContainer) {
            return S(new Facades.WebSocketContainer(S(object)));

        //==============================================================================================================
        // Others
        //==============================================================================================================

        }

        throw new UnsupportedOperationException("Unknown type: " + object.getClass().getName());
    }

    static <S extends Exception & WebSocketShim> S of(Exception exception) {
        if (exception == null || exception instanceof WebSocketShim) {
            return S(exception);
        } else if (exception instanceof jakarta.websocket.DecodeException) {
            return S(new Facades.DecodeException(S(exception)));
        } else if (exception instanceof jakarta.websocket.DeploymentException) {
            return S(new Facades.DeploymentException(S(exception)));
        } else if (exception instanceof jakarta.websocket.EncodeException) {
            return S(new Facades.EncodeException(S(exception)));
        } else if (exception instanceof jakarta.websocket.SessionException) {
            return S(new Facades.SessionException(S(exception)));
        }

        throw new UnsupportedOperationException("Unknown exception type: " + exception.getClass().getName());
    }

    static <S extends WebSocketShim> Stream<S> of(Object... objects) {
        return Shim.of(WebSocketShim::of, objects);
    }

    static <S extends WebSocketShim> Stream<S> of(Iterable<?> objects) {
        return Shim.of(WebSocketShim::of, objects);
    }

    static <S extends WebSocketShim & Annotation> Stream<S> of(Annotation... annotations) {
        return Shim.of(WebSocketShim::of, annotations);
    }

    static <S extends WebSocketShim> Class<? extends S> of(Class<S> shimType, Class<?> interfaceType) {
        return Shim.of(shimType, interfaceType);
    }

    //==================================================================================================================
    // Enum-specific Implementation
    //==================================================================================================================

    /**
     * @deprecated Use {@link jakarta.websocket} instead.
     */
    @Deprecated(since = "jakarta.websocket")
    interface Enum<E extends java.lang.Enum<E>> extends WebSocketShim, Shim.Enum<E> { }

    //==================================================================================================================
    // Private Helper Methods
    //==================================================================================================================

    private static <S extends Annotation> S of(Annotation annotation) {
        if (annotation == null || annotation instanceof WebSocketShim) {
            return S(annotation);
        } else if (annotation instanceof jakarta.websocket.ClientEndpoint) {
            return S(new Facades.ClientEndpoint(S(annotation)));
        } else if (annotation instanceof jakarta.websocket.OnClose) {
            return S(new Facades.OnClose(S(annotation)));
        } else if (annotation instanceof jakarta.websocket.OnError) {
            return S(new Facades.OnError(S(annotation)));
        } else if (annotation instanceof jakarta.websocket.OnMessage) {
            return S(new Facades.OnMessage(S(annotation)));
        } else if (annotation instanceof jakarta.websocket.OnOpen) {
            return S(new Facades.OnOpen(S(annotation)));
        } else if (annotation instanceof jakarta.websocket.server.PathParam) {
            return S(new Facades.PathParam(S(annotation)));
        } else if (annotation instanceof jakarta.websocket.server.ServerEndpoint) {
            return S(new Facades.ServerEndpoint(S(annotation)));
        }

        throw new UnsupportedOperationException("Unknown annotation type: " + annotation.annotationType().getName());
    }

    @SuppressWarnings("unchecked")
    private static <S> S S(Object object) {
        return (S) object;
    }
}
