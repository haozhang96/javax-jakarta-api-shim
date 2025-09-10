package javax.activation;

import javax.shim.ShimSupport;

/**
 * @deprecated Use {@link jakarta.activation.MimeTypeParseException} instead.
 */
@Deprecated(since = "jakarta.activation.MimeTypeParseException")
public class MimeTypeParseException extends jakarta.activation.MimeTypeParseException implements ActivationShim {
    private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.activation.MimeTypeParseException#MimeTypeParseException()
     */
    public MimeTypeParseException() {
        super();
    }

    /**
     * @see jakarta.activation.MimeTypeParseException#MimeTypeParseException(String)
     */
    public MimeTypeParseException(String message) {
        super(message);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ActivationShim.initialize();
    }
}
