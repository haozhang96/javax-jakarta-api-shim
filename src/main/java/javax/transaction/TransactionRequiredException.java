package javax.transaction;

import javax.shim.ShimSupport;

/**
 * @deprecated Use {@link jakarta.transaction.TransactionRequiredException} instead.
 */
@Deprecated(since = "jakarta.transaction.TransactionRequiredException")
public class TransactionRequiredException extends jakarta.transaction.TransactionRequiredException implements TransactionShim {
    private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.transaction.TransactionRequiredException#TransactionRequiredException()
     */
    public TransactionRequiredException() {
        super();
    }

    /**
     * @see jakarta.transaction.TransactionRequiredException#TransactionRequiredException(String)
     */
    public TransactionRequiredException(String message) {
        super(message);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        TransactionShim.initialize();
    }
}
