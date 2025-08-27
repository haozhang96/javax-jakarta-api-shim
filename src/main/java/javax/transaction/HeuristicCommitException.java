package javax.transaction;

/**
 * @deprecated Use {@link jakarta.transaction.HeuristicCommitException} instead.
 */
@Deprecated(since = "jakarta.transaction.HeuristicCommitException")
public class HeuristicCommitException extends jakarta.transaction.HeuristicCommitException implements TransactionShim {
    private static final long serialVersionUID = -3977609782149921760L; // Use the ID from jakarta.transaction.

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.transaction.HeuristicCommitException#HeuristicCommitException()
     */
    public HeuristicCommitException() {
        super();
    }

    /**
     * @see jakarta.transaction.HeuristicCommitException#HeuristicCommitException(String)
     */
    public HeuristicCommitException(String message) {
        super(message);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        TransactionShim.initialize();
    }
}
