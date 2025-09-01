package javax.xml.bind;

import java.util.Map;

/**
 * @deprecated Use {@link jakarta.xml.bind.JAXBContextFactory} instead.
 */
@Deprecated(since = "jakarta.xml.bind.JAXBContextFactory")
public interface JAXBContextFactory extends jakarta.xml.bind.JAXBContextFactory, JAXBShim {
    //==================================================================================================================
    // JAXBContextFactory Implementation Methods
    //==================================================================================================================

    @Override
    JAXBContext createContext(Class<?>[] classesToBeBound, Map<String, ?> properties) throws JAXBException;

    @Override
    JAXBContext createContext(
        String contextPath,
        ClassLoader classLoader,
        Map<String, ?> properties
    ) throws JAXBException;
}
