package javax.activation;

import org.junit.jupiter.api.Test;

class ActivationTest {
    @Test
    void test() {
        final var dataFlavor = new Facades.ActivationDataFlavor(new ActivationDataFlavor("application/xml", "XML"));
        dataFlavor.normalizeMimeType(dataFlavor.getMimeType());
    }
}
