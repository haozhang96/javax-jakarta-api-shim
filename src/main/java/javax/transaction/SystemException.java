package javax.transaction;

import javax.shim.ShimSupport;

/**
 * @deprecated Use {@link jakarta.transaction.SystemException} instead.
 */
@Deprecated(since = "jakarta.transaction.SystemException")
public class SystemException extends jakarta.transaction.SystemException implements TransactionShim {
    private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

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
