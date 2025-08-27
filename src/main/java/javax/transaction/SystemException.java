package javax.transaction;

/**
 * @deprecated Use {@link jakarta.transaction.SystemException} instead.
 */
@Deprecated(since = "jakarta.transaction.SystemException")
public class SystemException extends jakarta.transaction.SystemException implements TransactionShim {
    private static final long serialVersionUID = 839699079412719325L; // Use the ID from jakarta.transaction.

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.transaction.SystemException#SystemException()
     */
    public SystemException() {
        super();
    }

    /**
     * @see jakarta.transaction.SystemException#SystemException(String)
     */
    public SystemException(String message) {
        super(message);
    }

    /**
     * @see jakarta.transaction.SystemException#SystemException(int)
     */
    public SystemException(int errorCode) {
        super(errorCode);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        TransactionShim.initialize();
    }
}
