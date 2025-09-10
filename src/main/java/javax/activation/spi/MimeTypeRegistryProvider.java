package javax.activation.spi;

import javax.activation.ActivationShim;
import javax.activation.MimeTypeRegistry;
import java.io.IOException;
import java.io.InputStream;

/**
 * @deprecated Use {@link jakarta.activation.spi.MimeTypeRegistryProvider} instead.
 */
@Deprecated(since = "jakarta.activation.spi.MimeTypeRegistryProvider")
public interface MimeTypeRegistryProvider extends jakarta.activation.spi.MimeTypeRegistryProvider, ActivationShim {
    //==================================================================================================================
    // MimeTypeRegistryProvider Implementation Methods
    //==================================================================================================================

    @Override
    MimeTypeRegistry getByFileName(String fileName) throws IOException;

    @Override
    MimeTypeRegistry getByInputStream(InputStream inputStream) throws IOException;

    @Override
    MimeTypeRegistry getInMemory();
}
