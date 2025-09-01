package javax.xml.bind;

import javax.shim.ShimSupport;

/**
 * @deprecated Use {@link jakarta.xml.bind.TypeConstraintException} instead.
 */
@Deprecated(since = "jakarta.xml.bind.TypeConstraintException")
public class TypeConstraintException extends jakarta.xml.bind.TypeConstraintException implements JAXBShim {
    private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.TypeConstraintException#TypeConstraintException(String)
     */
    public TypeConstraintException(String message) {
        super(message);
    }

    /**
     * @see jakarta.xml.bind.TypeConstraintException#TypeConstraintException(String, String)
     */
    public TypeConstraintException(String message, String errorCode) {
        super(message, errorCode);
    }

    /**
     * @see jakarta.xml.bind.TypeConstraintException#TypeConstraintException(String, String, Throwable)
     */
    public TypeConstraintException(String message, String errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }

    /**
     * @see jakarta.xml.bind.TypeConstraintException#TypeConstraintException(String, Throwable)
     */
    public TypeConstraintException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @see jakarta.xml.bind.TypeConstraintException#TypeConstraintException(Throwable)
     */
    public TypeConstraintException(Throwable cause) {
        super(cause);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JAXBShim.initialize();
    }
}
