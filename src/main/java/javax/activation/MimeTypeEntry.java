package javax.activation;

/**
 * @deprecated Use {@link jakarta.activation.MimeTypeEntry} instead.
 */
@Deprecated(since = "jakarta.activation.MimeTypeEntry")
public class MimeTypeEntry extends jakarta.activation.MimeTypeEntry implements ActivationShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.activation.MimeTypeEntry#MimeTypeEntry(String, String)
     */
    public MimeTypeEntry(String mimeType, String fileExtension) {
        super(mimeType, fileExtension);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ActivationShim.initialize();
    }
}
