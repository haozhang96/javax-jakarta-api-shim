package javax.websocket;

/**
 * @deprecated Use {@link jakarta.websocket.CloseReason} instead.
 */
@Deprecated(since = "jakarta.websocket.CloseReason")
public class CloseReason extends jakarta.websocket.CloseReason implements WebSocketShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.websocket.CloseReason#CloseReason(jakarta.websocket.CloseReason.CloseCode, String)
     */
    public CloseReason(CloseCode closeCode, String reasonPhrase) {
        super(closeCode, reasonPhrase);
    }

    //==================================================================================================================
    // CloseReason Implementation Methods
    //==================================================================================================================

    @Override
    public CloseCode getCloseCode() {
        return WebSocketShim.of(super.getCloseCode());
    }

    //==================================================================================================================
    // CloseReason.CloseCode Implementation
    //==================================================================================================================

    /**
     * @deprecated Use {@link jakarta.websocket.CloseReason.CloseCode} instead.
     */
    @FunctionalInterface
    @Deprecated(since = "jakarta.websocket.CloseReason.CloseCode")
    public interface CloseCode extends jakarta.websocket.CloseReason.CloseCode, WebSocketShim { }

    //==================================================================================================================
    // CloseReason.CloseCodes Implementation
    //==================================================================================================================

    /**
     * @deprecated Use {@link jakarta.websocket.CloseReason.CloseCodes} instead.
     */
    @Deprecated(since = "jakarta.websocket.CloseReason.CloseCodes")
    public enum CloseCodes implements CloseCode {
        NORMAL_CLOSURE(jakarta.websocket.CloseReason.CloseCodes.NORMAL_CLOSURE),
        GOING_AWAY(jakarta.websocket.CloseReason.CloseCodes.GOING_AWAY),
        PROTOCOL_ERROR(jakarta.websocket.CloseReason.CloseCodes.PROTOCOL_ERROR),
        CANNOT_ACCEPT(jakarta.websocket.CloseReason.CloseCodes.CANNOT_ACCEPT),
        RESERVED(jakarta.websocket.CloseReason.CloseCodes.RESERVED),
        NO_STATUS_CODE(jakarta.websocket.CloseReason.CloseCodes.NO_STATUS_CODE),
        CLOSED_ABNORMALLY(jakarta.websocket.CloseReason.CloseCodes.CLOSED_ABNORMALLY),
        NOT_CONSISTENT(jakarta.websocket.CloseReason.CloseCodes.NOT_CONSISTENT),
        VIOLATED_POLICY(jakarta.websocket.CloseReason.CloseCodes.VIOLATED_POLICY),
        TOO_BIG(jakarta.websocket.CloseReason.CloseCodes.TOO_BIG),
        NO_EXTENSION(jakarta.websocket.CloseReason.CloseCodes.NO_EXTENSION),
        UNEXPECTED_CONDITION(jakarta.websocket.CloseReason.CloseCodes.UNEXPECTED_CONDITION),
        SERVICE_RESTART(jakarta.websocket.CloseReason.CloseCodes.SERVICE_RESTART),
        TRY_AGAIN_LATER(jakarta.websocket.CloseReason.CloseCodes.TRY_AGAIN_LATER),
        TLS_HANDSHAKE_FAILURE(jakarta.websocket.CloseReason.CloseCodes.TLS_HANDSHAKE_FAILURE);

        //==============================================================================================================
        // Enumeration Set-up
        //==============================================================================================================

        private final jakarta.websocket.CloseReason.CloseCodes target;

        CloseCodes(jakarta.websocket.CloseReason.CloseCodes target) {
            this.target = target;
        }

        //==============================================================================================================
        // CloseCode Implementation Methods
        //==============================================================================================================

        @Override
        public int getCode() {
            return target.getCode();
        }

        //==============================================================================================================
        // Factory Methods
        //==============================================================================================================

        public static CloseCode getCloseCode(int code) {
            return WebSocketShim.of(jakarta.websocket.CloseReason.CloseCodes.getCloseCode(code));
        }
    }
}
