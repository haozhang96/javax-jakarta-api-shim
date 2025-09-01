package javax.xml.bind;

/**
 * @deprecated Use {@link jakarta.xml.bind.DataBindingException} instead.
 */
@Deprecated(since = "jakarta.xml.bind.DataBindingException")
public class DataBindingException extends jakarta.xml.bind.DataBindingException implements JAXBShim {
    private static final long serialVersionUID = javax.shim.ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.DataBindingException#DataBindingException(String, Throwable)
     */
    public DataBindingException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @see jakarta.xml.bind.DataBindingException#DataBindingException(Throwable)
     */
    public DataBindingException(Throwable cause) {
        super(cause);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JAXBShim.initialize();
    }
}
