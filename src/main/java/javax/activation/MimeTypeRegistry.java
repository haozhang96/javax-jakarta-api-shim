package javax.activation;

/**
 * @deprecated Use {@link jakarta.activation.MimeTypeRegistry} instead.
 */
@Deprecated(since = "jakarta.activation.MimeTypeRegistry")
public interface MimeTypeRegistry extends jakarta.activation.MimeTypeRegistry, ActivationShim {
    //==================================================================================================================
    // MimeTypeRegistry Implementation Methods
    //==================================================================================================================

    @Override
    MimeTypeEntry getMimeTypeEntry(String fileExtension);
}
