package javax.transaction;

/**
 * @deprecated Use {@link jakarta.transaction.InvalidTransactionException} instead.
 */
@Deprecated(since = "jakarta.transaction.InvalidTransactionException")
public class InvalidTransactionException extends jakarta.transaction.InvalidTransactionException implements TransactionShim {
    private static final long serialVersionUID = 3597320220337691496L; // Use the ID from jakarta.transaction.

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.transaction.InvalidTransactionException#InvalidTransactionException()
     */
    public InvalidTransactionException() {
        super();
    }

    /**
     * @see jakarta.transaction.InvalidTransactionException#InvalidTransactionException(String)
     */
    public InvalidTransactionException(String message) {
        super(message);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        TransactionShim.initialize();
    }
}
