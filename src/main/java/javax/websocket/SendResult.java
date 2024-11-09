package javax.websocket;

import javax.Shim;

/**
 * @deprecated Use {@link jakarta.websocket.SendResult} instead.
 * @apiNote This class cannot extend {@link jakarta.websocket.SendResult} due to it being a final class.
 */
@Deprecated(since = "jakarta.websocket.SendResult")
public class SendResult extends Shim.Facade<jakarta.websocket.SendResult> implements WebSocketShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.websocket.SendResult#SendResult()
     */
    public SendResult() {
        this(new jakarta.websocket.SendResult());
    }

    /**
     * @see jakarta.websocket.SendResult#SendResult(Throwable)
     */
    public SendResult(Throwable cause) {
        this(new jakarta.websocket.SendResult(cause));
    }

    protected SendResult(jakarta.websocket.SendResult target) {
        super(target);
    }

    //==================================================================================================================
    // SendResult Implementation Methods
    //==================================================================================================================

    /**
     * @see jakarta.websocket.SendResult#getException()
     */
    public Throwable getException() {
        return target.getException();
    }

    /**
     * @see jakarta.websocket.SendResult#isOK()
     */
    public boolean isOK() {
        return target.isOK();
    }

    //==================================================================================================================
    // Accessor Methods
    //==================================================================================================================

    jakarta.websocket.SendResult getTarget() {
        return target;
    }
}
