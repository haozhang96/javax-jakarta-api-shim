package javax.transaction;

import javax.shim.ShimSupport;

/**
 * @deprecated Use {@link jakarta.transaction.HeuristicMixedException} instead.
 */
@Deprecated(since = "jakarta.transaction.HeuristicMixedException")
public class HeuristicMixedException extends jakarta.transaction.HeuristicMixedException implements TransactionShim {
    private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.transaction.HeuristicMixedException#HeuristicMixedException()
     */
    public HeuristicMixedException() {
        super();
    }

    /**
     * @see jakarta.transaction.HeuristicMixedException#HeuristicMixedException(String)
     */
    public HeuristicMixedException(String message) {
        super(message);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        TransactionShim.initialize();
    }
}
