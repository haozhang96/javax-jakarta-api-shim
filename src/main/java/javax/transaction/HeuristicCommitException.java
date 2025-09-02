package javax.transaction;

import javax.shim.ShimSupport;

/**
 * @deprecated Use {@link jakarta.transaction.HeuristicCommitException} instead.
 */
@Deprecated(since = "jakarta.transaction.HeuristicCommitException")
public class HeuristicCommitException extends jakarta.transaction.HeuristicCommitException implements TransactionShim {
    private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

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
