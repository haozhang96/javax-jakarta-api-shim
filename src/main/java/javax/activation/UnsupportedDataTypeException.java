package javax.activation;

import javax.shim.ShimSupport;

/**
 * @deprecated Use {@link jakarta.activation.UnsupportedDataTypeException} instead.
 */
@Deprecated(since = "jakarta.activation.UnsupportedDataTypeException")
public class UnsupportedDataTypeException extends jakarta.activation.UnsupportedDataTypeException implements ActivationShim {
    private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.activation.UnsupportedDataTypeException#UnsupportedDataTypeException()
     */
    public UnsupportedDataTypeException() {
        super();
    }

    /**
     * @see jakarta.activation.UnsupportedDataTypeException#UnsupportedDataTypeException(String)
     */
    public UnsupportedDataTypeException(String message) {
        super(message);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ActivationShim.initialize();
    }
}
