package javax.transaction;

/**
 * @deprecated Use {@link jakarta.transaction.RollbackException} instead.
 */
@Deprecated(since = "jakarta.transaction.RollbackException")
public class RollbackException extends jakarta.transaction.RollbackException implements TransactionShim {
    private static final long serialVersionUID = 4151607774785285395L; // Use the ID from jakarta.transaction.

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.transaction.RollbackException#RollbackException()
     */
    public RollbackException() {
        super();
    }

    /**
     * @see jakarta.transaction.RollbackException#RollbackException(String)
     */
    public RollbackException(String message) {
        super(message);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        TransactionShim.initialize();
    }
}
