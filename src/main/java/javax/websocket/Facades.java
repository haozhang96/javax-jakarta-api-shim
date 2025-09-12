package javax.websocket;

import javax.net.ssl.SSLContext;
import javax.shim.ShimReflector;
import javax.shim.ShimSupport;
import java.io.*;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.net.URI;
import java.nio.ByteBuffer;
import java.security.Principal;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This interface contains {@link jakarta.websocket}-to-{@link javax.websocket} facades used for wrapping Jakarta
 *   WebSocket objects into their Java WebSocket counterparts.
 *
 * @deprecated Use {@link jakarta.websocket} instead.
 */
@Deprecated(since = "jakarta.websocket")
@SuppressWarnings("all")
interface Facades {
    //==================================================================================================================
    // Annotations
    //==================================================================================================================

    final class ClientEndpoint extends WebSocketShim.Facade.Annotation<jakarta.websocket.ClientEndpoint> implements javax.websocket.ClientEndpoint, WebSocketShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ClientEndpoint(jakarta.websocket.ClientEndpoint target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String[] subprotocols() {
            return target.subprotocols();
        }

        @Override
        public Class<? extends javax.websocket.Decoder>[] decoders() {
            return Stream
                .of(target.decoders())
                .map(clazz -> WebSocketShim.<javax.websocket.Decoder>of(clazz, javax.websocket.Decoder.class))
                .toArray(Class[]::new);
        }

        @Override
        public Class<? extends javax.websocket.Encoder>[] encoders() {
            return Stream
                .of(target.encoders())
                .map(clazz -> WebSocketShim.<javax.websocket.Encoder>of(clazz, javax.websocket.Encoder.class))
                .toArray(Class[]::new);
        }

        @Override
        public Class<? extends javax.websocket.ClientEndpointConfig.Configurator> configurator() {
            return WebSocketShim.of(target.configurator(), javax.websocket.ClientEndpointConfig.Configurator.class);
        }
    }

    final class OnClose extends WebSocketShim.Facade.Annotation<jakarta.websocket.OnClose> implements javax.websocket.OnClose, WebSocketShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        OnClose(jakarta.websocket.OnClose target) {
            super(target);
        }
    }

    final class OnError extends WebSocketShim.Facade.Annotation<jakarta.websocket.OnError> implements javax.websocket.OnError, WebSocketShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        OnError(jakarta.websocket.OnError target) {
            super(target);
        }
    }

    final class OnMessage extends WebSocketShim.Facade.Annotation<jakarta.websocket.OnMessage> implements javax.websocket.OnMessage, WebSocketShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        OnMessage(jakarta.websocket.OnMessage target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public long maxMessageSize() {
            return target.maxMessageSize();
        }
    }

    final class OnOpen extends WebSocketShim.Facade.Annotation<jakarta.websocket.OnOpen> implements javax.websocket.OnOpen, WebSocketShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        OnOpen(jakarta.websocket.OnOpen target) {
            super(target);
        }
    }

    final class PathParam extends WebSocketShim.Facade.Annotation<jakarta.websocket.server.PathParam> implements javax.websocket.server.PathParam, WebSocketShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        PathParam(jakarta.websocket.server.PathParam target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String value() {
            return target.value();
        }
    }

    final class ServerEndpoint extends WebSocketShim.Facade.Annotation<jakarta.websocket.server.ServerEndpoint> implements javax.websocket.server.ServerEndpoint, WebSocketShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ServerEndpoint(jakarta.websocket.server.ServerEndpoint target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String value() {
            return target.value();
        }

        @Override
        public String[] subprotocols() {
            return target.subprotocols();
        }

        @Override
        public Class<? extends javax.websocket.Decoder>[] decoders() {
            return Stream
                .of(target.decoders())
                .map(clazz -> WebSocketShim.<javax.websocket.Decoder>of(clazz, javax.websocket.Decoder.class))
                .toArray(Class[]::new);
        }

        @Override
        public Class<? extends javax.websocket.Encoder>[] encoders() {
            return Stream
                .of(target.encoders())
                .map(clazz -> WebSocketShim.<javax.websocket.Encoder>of(clazz, javax.websocket.Encoder.class))
                .toArray(Class[]::new);
        }

        @Override
        public Class<? extends javax.websocket.server.ServerEndpointConfig.Configurator> configurator() {
            return WebSocketShim
                .of(target.configurator(), javax.websocket.server.ServerEndpointConfig.Configurator.class);
        }
    }

    //==================================================================================================================
    // Classes
    //==================================================================================================================

    final class ClientEndpointConfig extends WebSocketShim.Facade<jakarta.websocket.ClientEndpointConfig> implements javax.websocket.ClientEndpointConfig {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ClientEndpointConfig(jakarta.websocket.ClientEndpointConfig target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public List getExtensions() {
            return WebSocketShim
                .<javax.websocket.Extension>of(target.getExtensions())
                .collect(Collectors.toList());
        }

        @Override
        public javax.websocket.ClientEndpointConfig.Configurator getConfigurator() {
            return WebSocketShim.of(target.getConfigurator());
        }

        @Override
        public List<String> getPreferredSubprotocols() {
            return target.getPreferredSubprotocols();
        }

        @Override
        public SSLContext getSSLContext() {
            return target.getSSLContext();
        }

        @Override
        public List getEncoders() {
            return target
                .getEncoders()
                .stream()
                .map(clazz -> WebSocketShim.<javax.websocket.Encoder>of(clazz, javax.websocket.Encoder.class))
                .collect(Collectors.toList());
        }

        @Override
        public List getDecoders() {
            return target
                .getDecoders()
                .stream()
                .map(clazz -> WebSocketShim.<javax.websocket.Decoder>of(clazz, javax.websocket.Decoder.class))
                .collect(Collectors.toList());
        }

        @Override
        public Map<String, Object> getUserProperties() {
            return target.getUserProperties();
        }
    }

    final class ClientEndpointConfig$Builder extends javax.websocket.ClientEndpointConfig.Builder {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ClientEndpointConfig$Builder(jakarta.websocket.ClientEndpointConfig.Builder target) {
            super(target);
        }
    }

    final class ClientEndpointConfig$Configurator extends javax.websocket.ClientEndpointConfig.Configurator {
        private final jakarta.websocket.ClientEndpointConfig.Configurator target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ClientEndpointConfig$Configurator(jakarta.websocket.ClientEndpointConfig.Configurator target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void beforeRequest(Map<String, List<String>> headers) {
            target.beforeRequest(headers);
        }

        @Override
        public void afterResponse(javax.websocket.HandshakeResponse handshakeResponse) {
            target.afterResponse(handshakeResponse);
        }

        @Override
        public void afterResponse(jakarta.websocket.HandshakeResponse handshakeResponse) {
            target.afterResponse(handshakeResponse);
        }
    }

    final class CloseReason extends javax.websocket.CloseReason {
        private final jakarta.websocket.CloseReason target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        CloseReason(jakarta.websocket.CloseReason target) {
            super(WebSocketShim.of(target.getCloseCode()), target.getReasonPhrase());
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.websocket.CloseReason.CloseCode getCloseCode() {
            return WebSocketShim.of(target.getCloseCode());
        }

        @Override
        public String getReasonPhrase() {
            return target.getReasonPhrase();
        }

        @Override
        public String toString() {
            return target.toString();
        }
    }

    final class CloseReason$CloseCode extends WebSocketShim.Facade<jakarta.websocket.CloseReason.CloseCode> implements javax.websocket.CloseReason.CloseCode {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        CloseReason$CloseCode(jakarta.websocket.CloseReason.CloseCode target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public int getCode() {
            return target.getCode();
        }
    }

    final class ContainerProvider extends javax.websocket.ContainerProvider {
        private final jakarta.websocket.ContainerProvider target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ContainerProvider(jakarta.websocket.ContainerProvider target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        protected javax.websocket.WebSocketContainer getContainer() {
            final var container =
                ShimReflector.call(MethodHandles.lookup(), ShimSupport.toJakarta(), (lookup, clazz) ->
                    (jakarta.websocket.WebSocketContainer)
                        lookup
                            .bind(target, "getContainer", MethodType.methodType(jakarta.websocket.WebSocketContainer.class))
                            .invokeExact()
                );
            return WebSocketShim.of(container);
        }
    }

    final class DecodeException extends javax.websocket.DecodeException {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        private final jakarta.websocket.DecodeException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        DecodeException(jakarta.websocket.DecodeException target) {
            super(target.getBytes(), target.getMessage(), target.getCause());
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public ByteBuffer getBytes() {
            return target.getBytes();
        }

        @Override
        public String getText() {
            return target.getText();
        }

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public String getLocalizedMessage() {
            return target.getLocalizedMessage();
        }

        @Override
        public Throwable getCause() {
            return target.getCause();
        }

        @Override
        public Throwable initCause(Throwable cause) {
            return target.initCause(cause);
        }

        @Override
        public String toString() {
            return target.toString();
        }

        @Override
        public void printStackTrace() {
            target.printStackTrace();
        }

        @Override
        public void printStackTrace(PrintStream s) {
            target.printStackTrace(s);
        }

        @Override
        public void printStackTrace(PrintWriter s) {
            target.printStackTrace(s);
        }

        @Override
        public Throwable fillInStackTrace() {
            try {
                return super.fillInStackTrace();
            } finally {
                if (target != null) {
                    target.fillInStackTrace();
                }
            }
        }

        @Override
        public StackTraceElement[] getStackTrace() {
            return target.getStackTrace();
        }

        @Override
        public void setStackTrace(StackTraceElement[] stackTrace) {
            target.setStackTrace(stackTrace);
        }
    }

    final class Decoder extends WebSocketShim.Facade<jakarta.websocket.Decoder> implements javax.websocket.Decoder {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Decoder(jakarta.websocket.Decoder target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void init(javax.websocket.EndpointConfig config) {
            target.init(config);
        }

        @Override
        public void init(jakarta.websocket.EndpointConfig config) {
            target.init(config);
        }

        @Override
        public void destroy() {
            target.destroy();
        }
    }

    final class Decoder$Binary<T> extends WebSocketShim.Facade<jakarta.websocket.Decoder.Binary<T>> implements javax.websocket.Decoder.Binary<T> {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Decoder$Binary(jakarta.websocket.Decoder.Binary<T> target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public T decode(ByteBuffer bytes) throws javax.websocket.DecodeException {
            try {
                return target.decode(bytes);
            } catch (jakarta.websocket.DecodeException exception) {
                throw WebSocketShim.<javax.websocket.DecodeException>of(exception);
            }
        }
        @Override
        public boolean willDecode(ByteBuffer bytes) {
            return target.willDecode(bytes);
        }

        @Override
        public void init(javax.websocket.EndpointConfig config) {
            target.init(config);
        }

        @Override
        public void init(jakarta.websocket.EndpointConfig config) {
            target.init(config);
        }

        @Override
        public void destroy() {
            target.destroy();
        }
    }

    final class Decoder$BinaryStream<T> extends WebSocketShim.Facade<jakarta.websocket.Decoder.BinaryStream<T>> implements javax.websocket.Decoder.BinaryStream<T> {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Decoder$BinaryStream(jakarta.websocket.Decoder.BinaryStream<T> target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public T decode(InputStream stream) throws javax.websocket.DecodeException, IOException {
            try {
                return target.decode(stream);
            } catch (jakarta.websocket.DecodeException exception) {
                throw WebSocketShim.<javax.websocket.DecodeException>of(exception);
            }
        }

        @Override
        public void init(javax.websocket.EndpointConfig config) {
            target.init(config);
        }

        @Override
        public void init(jakarta.websocket.EndpointConfig config) {
            target.init(config);
        }

        @Override
        public void destroy() {
            target.destroy();
        }
    }

    final class Decoder$Text<T> extends WebSocketShim.Facade<jakarta.websocket.Decoder.Text<T>> implements javax.websocket.Decoder.Text<T> {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Decoder$Text(jakarta.websocket.Decoder.Text<T> target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public T decode(String text) throws javax.websocket.DecodeException {
            try {
                return target.decode(text);
            } catch (jakarta.websocket.DecodeException exception) {
                throw WebSocketShim.<javax.websocket.DecodeException>of(exception);
            }
        }
        @Override
        public boolean willDecode(String text) {
            return target.willDecode(text);
        }

        @Override
        public void init(javax.websocket.EndpointConfig config) {
            target.init(config);
        }

        @Override
        public void init(jakarta.websocket.EndpointConfig config) {
            target.init(config);
        }

        @Override
        public void destroy() {
            target.destroy();
        }
    }

    final class Decoder$TextStream<T> extends WebSocketShim.Facade<jakarta.websocket.Decoder.TextStream<T>> implements javax.websocket.Decoder.TextStream<T> {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Decoder$TextStream(jakarta.websocket.Decoder.TextStream<T> target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public T decode(Reader reader) throws javax.websocket.DecodeException, IOException {
            try {
                return target.decode(reader);
            } catch (jakarta.websocket.DecodeException exception) {
                throw WebSocketShim.<javax.websocket.DecodeException>of(exception);
            }
        }

        @Override
        public void init(javax.websocket.EndpointConfig config) {
            target.init(config);
        }

        @Override
        public void init(jakarta.websocket.EndpointConfig config) {
            target.init(config);
        }

        @Override
        public void destroy() {
            target.destroy();
        }
    }

    final class DeploymentException extends javax.websocket.DeploymentException {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        private final jakarta.websocket.DeploymentException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        DeploymentException(jakarta.websocket.DeploymentException target) {
            super(target.getMessage(), target.getCause());
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public String getLocalizedMessage() {
            return target.getLocalizedMessage();
        }

        @Override
        public Throwable getCause() {
            return target.getCause();
        }

        @Override
        public Throwable initCause(Throwable cause) {
            return target.initCause(cause);
        }

        @Override
        public String toString() {
            return target.toString();
        }

        @Override
        public void printStackTrace() {
            target.printStackTrace();
        }

        @Override
        public void printStackTrace(PrintStream s) {
            target.printStackTrace(s);
        }

        @Override
        public void printStackTrace(PrintWriter s) {
            target.printStackTrace(s);
        }

        @Override
        public Throwable fillInStackTrace() {
            try {
                return super.fillInStackTrace();
            } finally {
                if (target != null) {
                    target.fillInStackTrace();
                }
            }
        }

        @Override
        public StackTraceElement[] getStackTrace() {
            return target.getStackTrace();
        }

        @Override
        public void setStackTrace(StackTraceElement[] stackTrace) {
            target.setStackTrace(stackTrace);
        }
    }

    final class EncodeException extends javax.websocket.EncodeException {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        private final jakarta.websocket.EncodeException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        EncodeException(jakarta.websocket.EncodeException target) {
            super(target.getObject(), target.getMessage(), target.getCause());
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Object getObject() {
            return target.getObject();
        }

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public String getLocalizedMessage() {
            return target.getLocalizedMessage();
        }

        @Override
        public Throwable getCause() {
            return target.getCause();
        }

        @Override
        public Throwable initCause(Throwable cause) {
            return target.initCause(cause);
        }

        @Override
        public String toString() {
            return target.toString();
        }

        @Override
        public void printStackTrace() {
            target.printStackTrace();
        }

        @Override
        public void printStackTrace(PrintStream s) {
            target.printStackTrace(s);
        }

        @Override
        public void printStackTrace(PrintWriter s) {
            target.printStackTrace(s);
        }

        @Override
        public Throwable fillInStackTrace() {
            try {
                return super.fillInStackTrace();
            } finally {
                if (target != null) {
                    target.fillInStackTrace();
                }
            }
        }

        @Override
        public StackTraceElement[] getStackTrace() {
            return target.getStackTrace();
        }

        @Override
        public void setStackTrace(StackTraceElement[] stackTrace) {
            target.setStackTrace(stackTrace);
        }
    }

    final class Encoder extends WebSocketShim.Facade<jakarta.websocket.Encoder> implements javax.websocket.Encoder {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Encoder(jakarta.websocket.Encoder target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void init(javax.websocket.EndpointConfig config) {
            target.init(config);
        }

        @Override
        public void init(jakarta.websocket.EndpointConfig config) {
            target.init(config);
        }

        @Override
        public void destroy() {
            target.destroy();
        }
    }

    final class Encoder$Binary<T> extends WebSocketShim.Facade<jakarta.websocket.Encoder.Binary<T>> implements javax.websocket.Encoder.Binary<T> {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Encoder$Binary(jakarta.websocket.Encoder.Binary<T> target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public ByteBuffer encode(T object) throws javax.websocket.EncodeException {
            try {
                return target.encode(object);
            } catch (jakarta.websocket.EncodeException exception) {
                throw WebSocketShim.<javax.websocket.EncodeException>of(exception);
            }
        }

        @Override
        public void init(javax.websocket.EndpointConfig config) {
            target.init(config);
        }

        @Override
        public void init(jakarta.websocket.EndpointConfig config) {
            target.init(config);
        }

        @Override
        public void destroy() {
            target.destroy();
        }
    }

    final class Encoder$BinaryStream<T> extends WebSocketShim.Facade<jakarta.websocket.Encoder.BinaryStream<T>> implements javax.websocket.Encoder.BinaryStream<T> {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Encoder$BinaryStream(jakarta.websocket.Encoder.BinaryStream<T> target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void encode(T object, OutputStream stream) throws javax.websocket.EncodeException, IOException {
            try {
                target.encode(object, stream);
            } catch (jakarta.websocket.EncodeException exception) {
                throw WebSocketShim.<javax.websocket.EncodeException>of(exception);
            }
        }

        @Override
        public void init(javax.websocket.EndpointConfig config) {
            target.init(config);
        }

        @Override
        public void init(jakarta.websocket.EndpointConfig config) {
            target.init(config);
        }

        @Override
        public void destroy() {
            target.destroy();
        }
    }

    final class Encoder$Text<T> extends WebSocketShim.Facade<jakarta.websocket.Encoder.Text<T>> implements javax.websocket.Encoder.Text<T> {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Encoder$Text(jakarta.websocket.Encoder.Text<T> target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String encode(T object) throws javax.websocket.EncodeException {
            try {
                return target.encode(object);
            } catch (jakarta.websocket.EncodeException exception) {
                throw WebSocketShim.<javax.websocket.EncodeException>of(exception);
            }
        }

        @Override
        public void init(javax.websocket.EndpointConfig config) {
            target.init(config);
        }

        @Override
        public void init(jakarta.websocket.EndpointConfig config) {
            target.init(config);
        }

        @Override
        public void destroy() {
            target.destroy();
        }
    }

    final class Encoder$TextStream<T> extends WebSocketShim.Facade<jakarta.websocket.Encoder.TextStream<T>> implements javax.websocket.Encoder.TextStream<T> {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Encoder$TextStream(jakarta.websocket.Encoder.TextStream<T> target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void encode(T object, Writer writer) throws javax.websocket.EncodeException, IOException {
            try {
                target.encode(object, writer);
            } catch (jakarta.websocket.EncodeException exception) {
                throw WebSocketShim.<javax.websocket.EncodeException>of(exception);
            }
        }

        @Override
        public void init(javax.websocket.EndpointConfig config) {
            target.init(config);
        }

        @Override
        public void init(jakarta.websocket.EndpointConfig config) {
            target.init(config);
        }

        @Override
        public void destroy() {
            target.destroy();
        }
    }

    final class Endpoint extends javax.websocket.Endpoint {
        private final jakarta.websocket.Endpoint target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Endpoint(jakarta.websocket.Endpoint target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void onOpen(javax.websocket.Session session, javax.websocket.EndpointConfig config) {
            target.onOpen(session, config);
        }

        @Override
        public void onOpen(jakarta.websocket.Session session, jakarta.websocket.EndpointConfig config) {
            target.onOpen(session, config);
        }

        @Override
        public void onClose(javax.websocket.Session session, javax.websocket.CloseReason closeReason) {
            target.onClose(session, closeReason);
        }

        @Override
        public void onClose(jakarta.websocket.Session session, jakarta.websocket.CloseReason closeReason) {
            target.onClose(session, closeReason);
        }

        @Override
        public void onError(javax.websocket.Session session, Throwable cause) {
            target.onError(session, cause);
        }

        @Override
        public void onError(jakarta.websocket.Session session, Throwable cause) {
            target.onError(session, cause);
        }
    }

    final class EndpointConfig extends WebSocketShim.Facade<jakarta.websocket.EndpointConfig> implements javax.websocket.EndpointConfig {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        EndpointConfig(jakarta.websocket.EndpointConfig target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public List getEncoders() {
            return WebSocketShim
                .<javax.websocket.Encoder>of(target.getEncoders())
                .collect(Collectors.toList());
        }

        @Override
        public List getDecoders() {
            return WebSocketShim
                .<javax.websocket.Decoder>of(target.getDecoders())
                .collect(Collectors.toList());
        }

        @Override
        public Map<String, Object> getUserProperties() {
            return target.getUserProperties();
        }
    }

    final class Extension extends WebSocketShim.Facade<jakarta.websocket.Extension> implements javax.websocket.Extension {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Extension(jakarta.websocket.Extension target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getName() {
            return target.getName();
        }

        @Override
        public List getParameters() {
            return WebSocketShim
                .<javax.websocket.Extension.Parameter>of(target.getParameters())
                .collect(Collectors.toList());
        }
    }

    final class Extension$Parameter extends WebSocketShim.Facade<jakarta.websocket.Extension.Parameter> implements javax.websocket.Extension.Parameter {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Extension$Parameter(jakarta.websocket.Extension.Parameter target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getName() {
            return target.getName();
        }

        @Override
        public String getValue() {
            return target.getValue();
        }
    }

    final class HandshakeRequest extends WebSocketShim.Facade<jakarta.websocket.server.HandshakeRequest> implements javax.websocket.server.HandshakeRequest {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        HandshakeRequest(jakarta.websocket.server.HandshakeRequest target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Map<String, List<String>> getHeaders() {
            return target.getHeaders();
        }

        @Override
        public Principal getUserPrincipal() {
            return target.getUserPrincipal();
        }

        @Override
        public URI getRequestURI() {
            return target.getRequestURI();
        }

        @Override
        public boolean isUserInRole(String role) {
            return target.isUserInRole(role);
        }

        @Override
        public Object getHttpSession() {
            return target.getHttpSession();
        }

        @Override
        public Map<String, List<String>> getParameterMap() {
            return target.getParameterMap();
        }

        @Override
        public String getQueryString() {
            return target.getQueryString();
        }
    }

    final class HandshakeResponse extends WebSocketShim.Facade<jakarta.websocket.HandshakeResponse> implements javax.websocket.HandshakeResponse {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        HandshakeResponse(jakarta.websocket.HandshakeResponse target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Map<String, List<String>> getHeaders() {
            return target.getHeaders();
        }
    }

    final class MessageHandler extends WebSocketShim.Facade<jakarta.websocket.MessageHandler> implements javax.websocket.MessageHandler {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        MessageHandler(jakarta.websocket.MessageHandler target) {
            super(target);
        }
    }

    final class MessageHandler$Partial<T> extends WebSocketShim.Facade<jakarta.websocket.MessageHandler.Partial<T>> implements javax.websocket.MessageHandler.Partial<T> {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        MessageHandler$Partial(jakarta.websocket.MessageHandler.Partial<T> target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void onMessage(T partialMessage, boolean last) {
            target.onMessage(partialMessage, last);
        }
    }

    final class MessageHandler$Whole<T> extends WebSocketShim.Facade<jakarta.websocket.MessageHandler.Whole<T>> implements javax.websocket.MessageHandler.Whole<T> {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        MessageHandler$Whole(jakarta.websocket.MessageHandler.Whole<T> target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void onMessage(T message) {
            target.onMessage(message);
        }
    }

    final class PongMessage extends WebSocketShim.Facade<jakarta.websocket.PongMessage> implements javax.websocket.PongMessage {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        PongMessage(jakarta.websocket.PongMessage target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public ByteBuffer getApplicationData() {
            return target.getApplicationData();
        }
    }

    final class RemoteEndpoint extends WebSocketShim.Facade<jakarta.websocket.RemoteEndpoint> implements javax.websocket.RemoteEndpoint {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        RemoteEndpoint(jakarta.websocket.RemoteEndpoint target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void setBatchingAllowed(boolean allowed) throws IOException {
            target.setBatchingAllowed(allowed);
        }

        @Override
        public boolean getBatchingAllowed() {
            return target.getBatchingAllowed();
        }

        @Override
        public void flushBatch() throws IOException {
            target.flushBatch();
        }

        @Override
        public void sendPing(ByteBuffer applicationData) throws IOException, IllegalArgumentException {
            target.sendPing(applicationData);
        }

        @Override
        public void sendPong(ByteBuffer applicationData) throws IOException, IllegalArgumentException {
            target.sendPong(applicationData);
        }
    }

    final class RemoteEndpoint$Async extends WebSocketShim.Facade<jakarta.websocket.RemoteEndpoint.Async> implements javax.websocket.RemoteEndpoint.Async {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        RemoteEndpoint$Async(jakarta.websocket.RemoteEndpoint.Async target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public long getSendTimeout() {
            return target.getSendTimeout();
        }

        @Override
        public void setSendTimeout(long timeoutmillis) {
            target.setSendTimeout(timeoutmillis);
        }

        @Override
        public void sendText(String text, javax.websocket.SendHandler handler) {
            target.sendText(text, handler);
        }

        @Override
        public void sendText(String text, jakarta.websocket.SendHandler handler) {
            target.sendText(text, handler);
        }

        @Override
        public Future<Void> sendText(String text) {
            return target.sendText(text);
        }

        @Override
        public Future<Void> sendBinary(ByteBuffer data) {
            return target.sendBinary(data);
        }

        @Override
        public void sendBinary(ByteBuffer data, javax.websocket.SendHandler handler) {
            target.sendBinary(data, handler);
        }

        @Override
        public void sendBinary(ByteBuffer data, jakarta.websocket.SendHandler handler) {
            target.sendBinary(data, handler);
        }

        @Override
        public Future<Void> sendObject(Object data) {
            return target.sendObject(data);
        }

        @Override
        public void sendObject(Object data, javax.websocket.SendHandler handler) {
            target.sendObject(data, handler);
        }

        @Override
        public void sendObject(Object data, jakarta.websocket.SendHandler handler) {
            target.sendObject(data, handler);
        }

        @Override
        public void setBatchingAllowed(boolean allowed) throws IOException {
            target.setBatchingAllowed(allowed);
        }

        @Override
        public boolean getBatchingAllowed() {
            return target.getBatchingAllowed();
        }

        @Override
        public void flushBatch() throws IOException {
            target.flushBatch();
        }

        @Override
        public void sendPing(ByteBuffer applicationData) throws IOException, IllegalArgumentException {
            target.sendPing(applicationData);
        }

        @Override
        public void sendPong(ByteBuffer applicationData) throws IOException, IllegalArgumentException {
            target.sendPong(applicationData);
        }
    }

    final class RemoteEndpoint$Basic extends WebSocketShim.Facade<jakarta.websocket.RemoteEndpoint.Basic> implements javax.websocket.RemoteEndpoint.Basic {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        RemoteEndpoint$Basic(jakarta.websocket.RemoteEndpoint.Basic target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void sendText(String text) throws IOException {
            target.sendText(text);
        }

        @Override
        public void sendBinary(ByteBuffer data) throws IOException {
            target.sendBinary(data);
        }

        @Override
        public void sendText(String partialMessage, boolean isLast) throws IOException {
            target.sendText(partialMessage, isLast);
        }

        @Override
        public void sendBinary(ByteBuffer partialByte, boolean isLast) throws IOException {
            target.sendBinary(partialByte, isLast);
        }

        @Override
        public OutputStream getSendStream() throws IOException {
            return target.getSendStream();
        }

        @Override
        public Writer getSendWriter() throws IOException {
            return target.getSendWriter();
        }

        @Override
        public void sendObject(Object data) throws javax.websocket.EncodeException, IOException {
            try {
                target.sendObject(data);
            } catch (jakarta.websocket.EncodeException exception) {
                throw WebSocketShim.<javax.websocket.EncodeException>of(exception);
            }
        }

        @Override
        public void setBatchingAllowed(boolean allowed) throws IOException {
            target.setBatchingAllowed(allowed);
        }

        @Override
        public boolean getBatchingAllowed() {
            return target.getBatchingAllowed();
        }

        @Override
        public void flushBatch() throws IOException {
            target.flushBatch();
        }

        @Override
        public void sendPing(ByteBuffer applicationData) throws IOException, IllegalArgumentException {
            target.sendPing(applicationData);
        }

        @Override
        public void sendPong(ByteBuffer applicationData) throws IOException, IllegalArgumentException {
            target.sendPong(applicationData);
        }
    }

    final class SendHandler extends WebSocketShim.Facade<jakarta.websocket.SendHandler> implements javax.websocket.SendHandler {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        SendHandler(jakarta.websocket.SendHandler target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void onResult(javax.websocket.SendResult result) {
            target.onResult(result.getTarget());
        }

        @Override
        public void onResult(jakarta.websocket.SendResult result) {
            target.onResult(result);
        }
    }

    final class SendResult extends javax.websocket.SendResult {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        SendResult(jakarta.websocket.SendResult target) {
            super(target);
        }
    }

    final class ServerApplicationConfig extends WebSocketShim.Facade<jakarta.websocket.server.ServerApplicationConfig> implements javax.websocket.server.ServerApplicationConfig {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ServerApplicationConfig(jakarta.websocket.server.ServerApplicationConfig target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Set getEndpointConfigs(Set endpointClasses) {
            return WebSocketShim
                .<javax.websocket.server.ServerEndpointConfig>of(target.getEndpointConfigs(endpointClasses))
                .collect(Collectors.toCollection(LinkedHashSet::new));
        }

        @Override
        public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scanned) {
            return target.getAnnotatedEndpointClasses(scanned);
        }
    }

    final class ServerContainer extends WebSocketShim.Facade<jakarta.websocket.server.ServerContainer> implements javax.websocket.server.ServerContainer {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ServerContainer(jakarta.websocket.server.ServerContainer target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void addEndpoint(Class<?> endpointClass) throws javax.websocket.DeploymentException {
            try {
                target.addEndpoint(endpointClass);
            } catch (jakarta.websocket.DeploymentException exception) {
                throw WebSocketShim.<javax.websocket.DeploymentException>of(exception);
            }
        }

        @Override
        public void addEndpoint(
            javax.websocket.server.ServerEndpointConfig endpointConfig
        ) throws javax.websocket.DeploymentException {
            try {
                target.addEndpoint(endpointConfig);
            } catch (jakarta.websocket.DeploymentException exception) {
                throw WebSocketShim.<javax.websocket.DeploymentException>of(exception);
            }
        }

        @Override
        public void addEndpoint(
            jakarta.websocket.server.ServerEndpointConfig endpointConfig
        ) throws javax.websocket.DeploymentException {
            try {
                target.addEndpoint(endpointConfig);
            } catch (jakarta.websocket.DeploymentException exception) {
                throw WebSocketShim.<javax.websocket.DeploymentException>of(exception);
            }
        }

        @Override
        public void upgradeHttpToWebSocket(
            Object httpServletRequest,
            Object httpServletResponse,
            javax.websocket.server.ServerEndpointConfig endpointConfig,
            Map<String, String> pathParameters
        ) throws javax.websocket.DeploymentException, IOException {
            try {
                target.upgradeHttpToWebSocket(httpServletRequest, httpServletResponse, endpointConfig, pathParameters);
            } catch (jakarta.websocket.DeploymentException exception) {
                throw WebSocketShim.<javax.websocket.DeploymentException>of(exception);
            }
        }

        @Override
        public void upgradeHttpToWebSocket(
            Object httpServletRequest,
            Object httpServletResponse,
            jakarta.websocket.server.ServerEndpointConfig endpointConfig,
            Map<String, String> pathParameters
        ) throws javax.websocket.DeploymentException, IOException {
            try {
                target.upgradeHttpToWebSocket(httpServletRequest, httpServletResponse, endpointConfig, pathParameters);
            } catch (jakarta.websocket.DeploymentException exception) {
                throw WebSocketShim.<javax.websocket.DeploymentException>of(exception);
            }
        }

        @Override
        public long getDefaultAsyncSendTimeout() {
            return target.getDefaultAsyncSendTimeout();
        }

        @Override
        public void setAsyncSendTimeout(long timeout) {
            target.setAsyncSendTimeout(timeout);
        }

        @Override
        public long getDefaultMaxSessionIdleTimeout() {
            return target.getDefaultMaxSessionIdleTimeout();
        }

        @Override
        public void setDefaultMaxSessionIdleTimeout(long timeout) {
            target.setDefaultMaxSessionIdleTimeout(timeout);
        }

        @Override
        public int getDefaultMaxBinaryMessageBufferSize() {
            return target.getDefaultMaxBinaryMessageBufferSize();
        }

        @Override
        public void setDefaultMaxBinaryMessageBufferSize(int max) {
            target.setDefaultMaxBinaryMessageBufferSize(max);
        }

        @Override
        public int getDefaultMaxTextMessageBufferSize() {
            return target.getDefaultMaxTextMessageBufferSize();
        }

        @Override
        public void setDefaultMaxTextMessageBufferSize(int max) {
            target.setDefaultMaxTextMessageBufferSize(max);
        }

        @Override
        public Set getInstalledExtensions() {
            return WebSocketShim
                .<javax.websocket.Extension>of(target.getInstalledExtensions())
                .collect(Collectors.toCollection(LinkedHashSet::new));
        }

        @Override
        public javax.websocket.Session connectToServer(
            javax.websocket.Endpoint endpointInstance,
            javax.websocket.ClientEndpointConfig endpointConfig,
            URI path
        ) throws javax.websocket.DeploymentException, IOException {
            try {
                return WebSocketShim.of(target.connectToServer(endpointInstance, endpointConfig, path));
            } catch (jakarta.websocket.DeploymentException exception) {
                throw WebSocketShim.<javax.websocket.DeploymentException>of(exception);
            }
        }

        @Override
        public javax.websocket.Session connectToServer(
            jakarta.websocket.Endpoint endpointInstance,
            jakarta.websocket.ClientEndpointConfig endpointConfig,
            URI path
        ) throws javax.websocket.DeploymentException, IOException {
            try {
                return WebSocketShim.of(target.connectToServer(endpointInstance, endpointConfig, path));
            } catch (jakarta.websocket.DeploymentException exception) {
                throw WebSocketShim.<javax.websocket.DeploymentException>of(exception);
            }
        }

        @Override
        public javax.websocket.Session connectToServer(
            Class<? extends javax.websocket.Endpoint> endpointClass,
            javax.websocket.ClientEndpointConfig endpointConfig,
            URI path
        ) throws javax.websocket.DeploymentException, IOException {
            try {
                return WebSocketShim.of(target.connectToServer(endpointClass, endpointConfig, path));
            } catch (jakarta.websocket.DeploymentException exception) {
                throw WebSocketShim.<javax.websocket.DeploymentException>of(exception);
            }
        }

        @Override
        public javax.websocket.Session connectToServer(
            Class<? extends jakarta.websocket.Endpoint> endpointClass,
            jakarta.websocket.ClientEndpointConfig endpointConfig,
            URI path
        ) throws javax.websocket.DeploymentException, IOException {
            try {
                return WebSocketShim.of(target.connectToServer(endpointClass, endpointConfig, path));
            } catch (jakarta.websocket.DeploymentException exception) {
                throw WebSocketShim.<javax.websocket.DeploymentException>of(exception);
            }
        }

        @Override
        public javax.websocket.Session connectToServer(
            Object annotatedEndpointInstance,
            URI path
        ) throws javax.websocket.DeploymentException, IOException {
            try {
                return WebSocketShim.of(target.connectToServer(annotatedEndpointInstance, path));
            } catch (jakarta.websocket.DeploymentException exception) {
                throw WebSocketShim.<javax.websocket.DeploymentException>of(exception);
            }
        }

        @Override
        public javax.websocket.Session connectToServer(
            Class<?> annotatedEndpointClass,
            URI path
        ) throws javax.websocket.DeploymentException, IOException {
            try {
                return WebSocketShim.of(target.connectToServer(annotatedEndpointClass, path));
            } catch (jakarta.websocket.DeploymentException exception) {
                throw WebSocketShim.<javax.websocket.DeploymentException>of(exception);
            }
        }
    }

    final class ServerEndpointConfig extends WebSocketShim.Facade<jakarta.websocket.server.ServerEndpointConfig> implements javax.websocket.server.ServerEndpointConfig {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ServerEndpointConfig(jakarta.websocket.server.ServerEndpointConfig target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public List getExtensions() {
            return WebSocketShim
                .<javax.websocket.Extension>of(target.getExtensions())
                .collect(Collectors.toList());
        }

        @Override
        public javax.websocket.server.ServerEndpointConfig.Configurator getConfigurator() {
            return WebSocketShim.of(target.getConfigurator());
        }

        @Override
        public Class<?> getEndpointClass() {
            return target.getEndpointClass();
        }

        @Override
        public String getPath() {
            return target.getPath();
        }

        @Override
        public List<String> getSubprotocols() {
            return target.getSubprotocols();
        }

        @Override
        public List getEncoders() {
            return target
                .getEncoders()
                .stream()
                .map(clazz -> WebSocketShim.<javax.websocket.Encoder>of(clazz, javax.websocket.Encoder.class))
                .collect(Collectors.toList());
        }

        @Override
        public List getDecoders() {
            return target
                .getDecoders()
                .stream()
                .map(clazz -> WebSocketShim.<javax.websocket.Decoder>of(clazz, javax.websocket.Decoder.class))
                .collect(Collectors.toList());
        }

        @Override
        public Map<String, Object> getUserProperties() {
            return target.getUserProperties();
        }
    }

    final class ServerEndpointConfig$Builder extends javax.websocket.server.ServerEndpointConfig.Builder {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ServerEndpointConfig$Builder(jakarta.websocket.server.ServerEndpointConfig.Builder target) {
            super(target);
        }
    }

    final class ServerEndpointConfig$Configurator extends javax.websocket.server.ServerEndpointConfig.Configurator {
        private final jakarta.websocket.server.ServerEndpointConfig.Configurator target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ServerEndpointConfig$Configurator(jakarta.websocket.server.ServerEndpointConfig.Configurator target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.websocket.server.ServerEndpointConfig.Configurator getContainerDefaultConfigurator() {
            return WebSocketShim.of(target.getContainerDefaultConfigurator());
        }

        @Override
        public String getNegotiatedSubprotocol(List<String> supported, List<String> requested) {
            return target.getNegotiatedSubprotocol(supported, requested);
        }

        @Override
        public List<javax.websocket.Extension> getNegotiatedExtensions(List installed, List requested) {
            return WebSocketShim
                .<javax.websocket.Extension>of(target.getNegotiatedExtensions(installed, requested))
                .collect(Collectors.toList());
        }

        @Override
        public boolean checkOrigin(String originHeaderValue) {
            return target.checkOrigin(originHeaderValue);
        }

        @Override
        public void modifyHandshake(
            javax.websocket.server.ServerEndpointConfig endpointConfig,
            javax.websocket.server.HandshakeRequest request,
            javax.websocket.HandshakeResponse response
        ) {
            target.modifyHandshake(endpointConfig, request, response);
        }

        @Override
        public void modifyHandshake(
            jakarta.websocket.server.ServerEndpointConfig endpointConfig,
            jakarta.websocket.server.HandshakeRequest request,
            jakarta.websocket.HandshakeResponse response
        ) {
            target.modifyHandshake(endpointConfig, request, response);
        }

        @Override
        public <T> T getEndpointInstance(Class<T> endpointClass) throws InstantiationException {
            return target.getEndpointInstance(endpointClass);
        }
    }

    final class Session extends WebSocketShim.Facade<jakarta.websocket.Session> implements javax.websocket.Session {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Session(jakarta.websocket.Session target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.websocket.WebSocketContainer getContainer() {
            return WebSocketShim.of(target.getContainer());
        }

        @Override
        public void addMessageHandler(javax.websocket.MessageHandler handler) throws IllegalStateException {
            target.addMessageHandler(handler);
        }

        @Override
        public void addMessageHandler(jakarta.websocket.MessageHandler handler) throws IllegalStateException {
            target.addMessageHandler(handler);
        }

        @Override
        public <T> void addMessageHandler(Class<T> clazz, javax.websocket.MessageHandler.Whole<T> handler) {
            target.addMessageHandler(clazz, handler);
        }

        @Override
        public <T> void addMessageHandler(Class<T> clazz, jakarta.websocket.MessageHandler.Whole<T> handler) {
            target.addMessageHandler(clazz, handler);
        }

        @Override
        public <T> void addMessageHandler(Class<T> clazz, javax.websocket.MessageHandler.Partial<T> handler) {
            target.addMessageHandler(clazz, handler);
        }

        @Override
        public <T> void addMessageHandler(Class<T> clazz, jakarta.websocket.MessageHandler.Partial<T> handler) {
            target.addMessageHandler(clazz, handler);
        }

        @Override
        public Set getMessageHandlers() {
            return WebSocketShim
                .<javax.websocket.MessageHandler>of(target.getMessageHandlers())
                .collect(Collectors.toCollection(LinkedHashSet::new));
        }

        @Override
        public void removeMessageHandler(javax.websocket.MessageHandler handler) {
            target.removeMessageHandler(handler);
        }

        @Override
        public void removeMessageHandler(jakarta.websocket.MessageHandler handler) {
            target.removeMessageHandler(handler);
        }

        @Override
        public String getProtocolVersion() {
            return target.getProtocolVersion();
        }

        @Override
        public String getNegotiatedSubprotocol() {
            return target.getNegotiatedSubprotocol();
        }

        @Override
        public List getNegotiatedExtensions() {
            return WebSocketShim
                .<javax.websocket.Extension>of(target.getNegotiatedExtensions())
                .collect(Collectors.toList());
        }

        @Override
        public boolean isSecure() {
            return target.isSecure();
        }

        @Override
        public boolean isOpen() {
            return target.isOpen();
        }

        @Override
        public long getMaxIdleTimeout() {
            return target.getMaxIdleTimeout();
        }

        @Override
        public void setMaxIdleTimeout(long milliseconds) {
            target.setMaxIdleTimeout(milliseconds);
        }

        @Override
        public void setMaxBinaryMessageBufferSize(int length) {
            target.setMaxBinaryMessageBufferSize(length);
        }

        @Override
        public int getMaxBinaryMessageBufferSize() {
            return target.getMaxBinaryMessageBufferSize();
        }

        @Override
        public void setMaxTextMessageBufferSize(int length) {
            target.setMaxTextMessageBufferSize(length);
        }

        @Override
        public int getMaxTextMessageBufferSize() {
            return target.getMaxTextMessageBufferSize();
        }

        @Override
        public javax.websocket.RemoteEndpoint.Async getAsyncRemote() {
            return WebSocketShim.of(target.getAsyncRemote());
        }

        @Override
        public javax.websocket.RemoteEndpoint.Basic getBasicRemote() {
            return WebSocketShim.of(target.getBasicRemote());
        }

        @Override
        public String getId() {
            return target.getId();
        }

        @Override
        public void close() throws IOException {
            target.close();
        }

        @Override
        public void close(javax.websocket.CloseReason reason) throws IOException {
            target.close(reason);
        }

        @Override
        public void close(jakarta.websocket.CloseReason closeReason) throws IOException {
            target.close(closeReason);
        }

        @Override
        public URI getRequestURI() {
            return target.getRequestURI();
        }

        @Override
        public Map<String, List<String>> getRequestParameterMap() {
            return target.getRequestParameterMap();
        }

        @Override
        public String getQueryString() {
            return target.getQueryString();
        }

        @Override
        public Map<String, String> getPathParameters() {
            return target.getPathParameters();
        }

        @Override
        public Map<String, Object> getUserProperties() {
            return target.getUserProperties();
        }

        @Override
        public Principal getUserPrincipal() {
            return target.getUserPrincipal();
        }

        @Override
        public Set getOpenSessions() {
            return WebSocketShim
                .<javax.websocket.Session>of(target.getOpenSessions())
                .collect(Collectors.toCollection(LinkedHashSet::new));
        }
    }

    final class SessionException extends javax.websocket.SessionException {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        private final jakarta.websocket.SessionException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        SessionException(jakarta.websocket.SessionException target) {
            super(target.getMessage(), target.getCause(), WebSocketShim.of(target.getSession()));
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.websocket.Session getSession() {
            return WebSocketShim.of(target.getSession());
        }

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public String getLocalizedMessage() {
            return target.getLocalizedMessage();
        }

        @Override
        public Throwable getCause() {
            return target.getCause();
        }

        @Override
        public Throwable initCause(Throwable cause) {
            return target.initCause(cause);
        }

        @Override
        public String toString() {
            return target.toString();
        }

        @Override
        public void printStackTrace() {
            target.printStackTrace();
        }

        @Override
        public void printStackTrace(PrintStream s) {
            target.printStackTrace(s);
        }

        @Override
        public void printStackTrace(PrintWriter s) {
            target.printStackTrace(s);
        }

        @Override
        public Throwable fillInStackTrace() {
            try {
                return super.fillInStackTrace();
            } finally {
                if (target != null) {
                    target.fillInStackTrace();
                }
            }
        }

        @Override
        public StackTraceElement[] getStackTrace() {
            return target.getStackTrace();
        }

        @Override
        public void setStackTrace(StackTraceElement[] stackTrace) {
            target.setStackTrace(stackTrace);
        }
    }

    final class WebSocketContainer extends WebSocketShim.Facade<jakarta.websocket.WebSocketContainer> implements javax.websocket.WebSocketContainer {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        WebSocketContainer(jakarta.websocket.WebSocketContainer target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public long getDefaultAsyncSendTimeout() {
            return target.getDefaultAsyncSendTimeout();
        }

        @Override
        public void setAsyncSendTimeout(long timeout) {
            target.setAsyncSendTimeout(timeout);
        }

        @Override
        public javax.websocket.Session connectToServer(
            Object annotatedEndpointInstance,
            URI path
        ) throws javax.websocket.DeploymentException, IOException {
            try {
                return WebSocketShim.of(target.connectToServer(annotatedEndpointInstance, path));
            } catch (jakarta.websocket.DeploymentException exception) {
                throw WebSocketShim.<javax.websocket.DeploymentException>of(exception);
            }
        }

        @Override
        public javax.websocket.Session connectToServer(
            Class<?> annotatedEndpointClass,
            URI path
        ) throws javax.websocket.DeploymentException, IOException {
            try {
                return WebSocketShim.of(target.connectToServer(annotatedEndpointClass, path));
            } catch (jakarta.websocket.DeploymentException exception) {
                throw WebSocketShim.<javax.websocket.DeploymentException>of(exception);
            }
        }

        @Override
        public javax.websocket.Session connectToServer(
            javax.websocket.Endpoint endpointInstance,
            javax.websocket.ClientEndpointConfig endpointConfig,
            URI path
        ) throws javax.websocket.DeploymentException, IOException {
            try {
                return WebSocketShim.of(target.connectToServer(endpointInstance, endpointConfig, path));
            } catch (jakarta.websocket.DeploymentException exception) {
                throw WebSocketShim.<javax.websocket.DeploymentException>of(exception);
            }
        }

        @Override
        public javax.websocket.Session connectToServer(
            jakarta.websocket.Endpoint endpointInstance,
            jakarta.websocket.ClientEndpointConfig endpointConfig,
            URI path
        ) throws javax.websocket.DeploymentException, IOException {
            try {
                return WebSocketShim.of(target.connectToServer(endpointInstance, endpointConfig, path));
            } catch (jakarta.websocket.DeploymentException exception) {
                throw WebSocketShim.<javax.websocket.DeploymentException>of(exception);
            }
        }

        @Override
        public javax.websocket.Session connectToServer(
            Class<? extends javax.websocket.Endpoint> endpointClass,
            javax.websocket.ClientEndpointConfig endpointConfig,
            URI path
        ) throws javax.websocket.DeploymentException, IOException {
            try {
                return WebSocketShim.of(target.connectToServer(endpointClass, endpointConfig, path));
            } catch (jakarta.websocket.DeploymentException exception) {
                throw WebSocketShim.<javax.websocket.DeploymentException>of(exception);
            }
        }

        @Override
        public javax.websocket.Session connectToServer(
            Class<? extends jakarta.websocket.Endpoint> endpointClass,
            jakarta.websocket.ClientEndpointConfig endpointConfig,
            URI path
        ) throws javax.websocket.DeploymentException, IOException {
            try {
                return WebSocketShim.of(target.connectToServer(endpointClass, endpointConfig, path));
            } catch (jakarta.websocket.DeploymentException exception) {
                throw WebSocketShim.<javax.websocket.DeploymentException>of(exception);
            }
        }

        @Override
        public long getDefaultMaxSessionIdleTimeout() {
            return target.getDefaultMaxSessionIdleTimeout();
        }

        @Override
        public void setDefaultMaxSessionIdleTimeout(long timeout) {
            target.setDefaultMaxSessionIdleTimeout(timeout);
        }

        @Override
        public int getDefaultMaxBinaryMessageBufferSize() {
            return target.getDefaultMaxBinaryMessageBufferSize();
        }

        @Override
        public void setDefaultMaxBinaryMessageBufferSize(int max) {
            target.setDefaultMaxBinaryMessageBufferSize(max);
        }

        @Override
        public int getDefaultMaxTextMessageBufferSize() {
            return target.getDefaultMaxTextMessageBufferSize();
        }

        @Override
        public void setDefaultMaxTextMessageBufferSize(int max) {
            target.setDefaultMaxTextMessageBufferSize(max);
        }

        @Override
        public Set getInstalledExtensions() {
            return WebSocketShim
                .<javax.websocket.Extension>of(target.getInstalledExtensions())
                .collect(Collectors.toCollection(LinkedHashSet::new));
        }
    }
}
