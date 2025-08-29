package javax.transaction;

/**
 * @deprecated Use {@link jakarta.transaction.HeuristicRollbackException} instead.
 */
@Deprecated(since = "jakarta.transaction.HeuristicRollbackException")
public class HeuristicRollbackException extends jakarta.transaction.HeuristicRollbackException implements TransactionShim {
    private static final long serialVersionUID = javax.shim.ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.transaction.HeuristicRollbackException#HeuristicRollbackException()
     */
    public HeuristicRollbackException() {
        super();
    }

    /**
     * @see jakarta.transaction.HeuristicRollbackException#HeuristicRollbackException(String)
     */
    public HeuristicRollbackException(String message) {
        super(message);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        TransactionShim.initialize();
    }
}
