package javax.activation.spi;

import javax.activation.ActivationShim;
import javax.activation.MailcapRegistry;
import java.io.IOException;
import java.io.InputStream;

/**
 * @deprecated Use {@link jakarta.activation.spi.MailcapRegistryProvider} instead.
 */
@Deprecated(since = "jakarta.activation.spi.MailcapRegistryProvider")
public interface MailcapRegistryProvider extends jakarta.activation.spi.MailcapRegistryProvider, ActivationShim {
    //==================================================================================================================
    // MailcapRegistryProvider Implementation Methods
    //==================================================================================================================

    @Override
    MailcapRegistry getByFileName(String fileName) throws IOException;

    @Override
    MailcapRegistry getByInputStream(InputStream inputStream) throws IOException;

    @Override
    MailcapRegistry getInMemory();
}
