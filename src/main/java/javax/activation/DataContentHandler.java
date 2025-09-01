package javax.activation;

import java.io.IOException;

/**
 * @deprecated Use {@link jakarta.activation.DataContentHandler} instead.
 */
@Deprecated(since = "jakarta.activation.DataContentHandler")
public interface DataContentHandler extends jakarta.activation.DataContentHandler, ActivationShim {
    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see jakarta.activation.DataContentHandler#getTransferData(jakarta.activation.ActivationDataFlavor, jakarta.activation.DataSource)
     */
    Object getTransferData(ActivationDataFlavor dataFlavor, DataSource dataSource) throws IOException;

    /**
     * @see jakarta.activation.DataContentHandler#getContent(jakarta.activation.DataSource)
     */
    Object getContent(DataSource dataSource) throws IOException;

    //==================================================================================================================
    // DataContentHandler Implementation Methods
    //==================================================================================================================

    @Override
    ActivationDataFlavor[] getTransferDataFlavors();

    @Override
    default Object getTransferData(
        jakarta.activation.ActivationDataFlavor dataFlavor,
        jakarta.activation.DataSource dataSource
    ) throws IOException {
        return getTransferData(ActivationShim.of(dataFlavor), ActivationShim.of(dataSource));
    }

    @Override
    default Object getContent(jakarta.activation.DataSource dataSource) throws IOException {
        return getContent(ActivationShim.of(dataSource));
    }
}
