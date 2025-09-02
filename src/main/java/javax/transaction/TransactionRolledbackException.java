package javax.transaction;

import javax.shim.ShimSupport;

/**
 * @deprecated Use {@link jakarta.transaction.TransactionRolledbackException} instead.
 */
@Deprecated(since = "jakarta.transaction.TransactionRolledbackException")
public class TransactionRolledbackException extends jakarta.transaction.TransactionRolledbackException implements TransactionShim {
    private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.transaction.TransactionRolledbackException#TransactionRolledbackException()
     */
    public TransactionRolledbackException() {
        super();
    }

    /**
     * @see jakarta.transaction.TransactionRolledbackException#TransactionRolledbackException(String)
     */
    public TransactionRolledbackException(String message) {
        super(message);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        TransactionShim.initialize();
    }
}
