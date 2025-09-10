package javax.activation;

/**
 * @deprecated Use {@link jakarta.activation.DataContentHandlerFactory} instead.
 */
@Deprecated(since = "jakarta.activation.DataContentHandlerFactory")
public interface DataContentHandlerFactory extends jakarta.activation.DataContentHandlerFactory, ActivationShim {
    //==================================================================================================================
    // DataContentHandlerFactory Implementation Methods
    //==================================================================================================================

    @Override
    DataContentHandler createDataContentHandler(String mimeType);
}
