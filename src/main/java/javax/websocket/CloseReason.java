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
    public enum CloseCodes implements CloseCode, WebSocketShim.Enum<jakarta.websocket.CloseReason.CloseCodes> {
        /**
         * @see jakarta.websocket.CloseReason.CloseCodes#NORMAL_CLOSURE
         */
        NORMAL_CLOSURE,

        /**
         * @see jakarta.websocket.CloseReason.CloseCodes#GOING_AWAY
         */
        GOING_AWAY,

        /**
         * @see jakarta.websocket.CloseReason.CloseCodes#PROTOCOL_ERROR
         */
        PROTOCOL_ERROR,

        /**
         * @see jakarta.websocket.CloseReason.CloseCodes#CANNOT_ACCEPT
         */
        CANNOT_ACCEPT,

        /**
         * @see jakarta.websocket.CloseReason.CloseCodes#RESERVED
         */
        RESERVED,

        /**
         * @see jakarta.websocket.CloseReason.CloseCodes#NO_STATUS_CODE
         */
        NO_STATUS_CODE,

        /**
         * @see jakarta.websocket.CloseReason.CloseCodes#CLOSED_ABNORMALLY
         */
        CLOSED_ABNORMALLY,

        /**
         * @see jakarta.websocket.CloseReason.CloseCodes#NOT_CONSISTENT
         */
        NOT_CONSISTENT,

        /**
         * @see jakarta.websocket.CloseReason.CloseCodes#VIOLATED_POLICY
         */
        VIOLATED_POLICY,

        /**
         * @see jakarta.websocket.CloseReason.CloseCodes#TOO_BIG
         */
        TOO_BIG,

        /**
         * @see jakarta.websocket.CloseReason.CloseCodes#NO_EXTENSION
         */
        NO_EXTENSION,

        /**
         * @see jakarta.websocket.CloseReason.CloseCodes#UNEXPECTED_CONDITION
         */
        UNEXPECTED_CONDITION,

        /**
         * @see jakarta.websocket.CloseReason.CloseCodes#SERVICE_RESTART
         */
        SERVICE_RESTART,

        /**
         * @see jakarta.websocket.CloseReason.CloseCodes#TRY_AGAIN_LATER
         */
        TRY_AGAIN_LATER,

        /**
         * @see jakarta.websocket.CloseReason.CloseCodes#TLS_HANDSHAKE_FAILURE
         */
        TLS_HANDSHAKE_FAILURE;

        //==============================================================================================================
        // CloseCode Implementation Methods
        //==============================================================================================================

        @Override
        public int getCode() {
            return toJakarta().getCode();
        }

        //==============================================================================================================
        // Factory Methods
        //==============================================================================================================

        public static CloseCode getCloseCode(int code) {
            return WebSocketShim.of(jakarta.websocket.CloseReason.CloseCodes.getCloseCode(code));
        }
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        WebSocketShim.initialize();
    }
}
