package javax.transaction;

/**
 * @deprecated Use {@link jakarta.transaction.NotSupportedException} instead.
 */
@Deprecated(since = "jakarta.transaction.NotSupportedException")
public class NotSupportedException extends jakarta.transaction.NotSupportedException implements TransactionShim {
    private static final long serialVersionUID = 56870312332816390L; // Use the ID from jakarta.transaction.

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.transaction.NotSupportedException#NotSupportedException()
     */
    public NotSupportedException() {
        super();
    }

    /**
     * @see jakarta.transaction.NotSupportedException#NotSupportedException(String)
     */
    public NotSupportedException(String message) {
        super(message);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        TransactionShim.initialize();
    }
}
