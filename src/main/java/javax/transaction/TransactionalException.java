package javax.transaction;

/**
 * @deprecated Use {@link jakarta.transaction.TransactionalException} instead.
 */
@Deprecated(since = "jakarta.transaction.TransactionalException")
public class TransactionalException extends jakarta.transaction.TransactionalException implements TransactionShim {
    private static final long serialVersionUID = -8196645329560986417L; // Use the ID from jakarta.transaction.

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
