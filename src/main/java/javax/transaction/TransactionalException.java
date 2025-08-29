package javax.transaction;

/**
 * @deprecated Use {@link jakarta.transaction.TransactionalException} instead.
 */
@Deprecated(since = "jakarta.transaction.TransactionalException")
public class TransactionalException extends jakarta.transaction.TransactionalException implements TransactionShim {
    private static final long serialVersionUID = javax.shim.ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.transaction.TransactionalException#TransactionalException(String, Throwable)
     */
    public TransactionalException(String message, Throwable cause) {
        super(message, cause);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        TransactionShim.initialize();
    }
}
