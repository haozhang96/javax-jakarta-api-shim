package javax.xml.bind;

import org.w3c.dom.Node;

import javax.shim.ShimSupport;
import java.io.IOException;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.function.Predicate;

/**
 * @deprecated Use {@link jakarta.xml.bind.JAXBContext} instead.
 */
@Deprecated(since = "jakarta.xml.bind.JAXBContext")
public abstract class JAXBContext extends jakarta.xml.bind.JAXBContext implements JAXBShim {
    private static final String DEFAULT_JAVAX_RUNTIME_PACKAGE = "com.sun.xml.bind.v2"; // JAXB 2.0 (javax)
    private static final String DEFAULT_JAKARTA_RUNTIME_PACKAGE = "org.glassfish.jaxb.runtime.v2"; // JAXB 3.0 (jakarta)

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.JAXBContext#JAXBContext()
     */
    protected JAXBContext() {
        super();
    }

    //==================================================================================================================
    // Factory Methods
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.JAXBContext#newInstance(String)
     */
    public static JAXBContext newInstance(String contextPath) throws JAXBException {
        try {
            return JAXBShim.of(jakarta.xml.bind.JAXBContext.newInstance(contextPath));
        } catch (jakarta.xml.bind.JAXBException exception) {
            throw JAXBShim.of(exception);
        }
    }

    /**
     * @see jakarta.xml.bind.JAXBContext#newInstance(String, ClassLoader)
     */
    public static JAXBContext newInstance(String contextPath, ClassLoader classLoader) throws JAXBException {
        try {
            return JAXBShim.of(jakarta.xml.bind.JAXBContext.newInstance(contextPath, classLoader));
        } catch (jakarta.xml.bind.JAXBException exception) {
            throw JAXBShim.of(exception);
        }
    }

    /**
     * @see jakarta.xml.bind.JAXBContext#newInstance(String, ClassLoader, Map)
     */
    public static JAXBContext newInstance(
        String contextPath,
        ClassLoader classLoader,
        Map<String, ?> properties
    ) throws JAXBException {
        try {
            return JAXBShim.of(jakarta.xml.bind.JAXBContext.newInstance(contextPath, classLoader, properties));
        } catch (jakarta.xml.bind.JAXBException exception) {
            throw JAXBShim.of(exception);
        }
    }

    /**
     * @see jakarta.xml.bind.JAXBContext#newInstance(Class...)
     */
    public static JAXBContext newInstance(Class<?>... classes) throws JAXBException {
        try {
            return JAXBShim.of(jakarta.xml.bind.JAXBContext.newInstance(classes));
        } catch (jakarta.xml.bind.JAXBException exception) {
            throw JAXBShim.of(exception);
        }
    }

    /**
     * @see jakarta.xml.bind.JAXBContext#newInstance(Class[], Map)
     */
    public static JAXBContext newInstance(Class<?>[] classes, Map<String, ?> properties) throws JAXBException {
        try {
            return JAXBShim.of(jakarta.xml.bind.JAXBContext.newInstance(classes, properties));
        } catch (jakarta.xml.bind.JAXBException exception) {
            throw JAXBShim.of(exception);
        }
    }

    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.JAXBContext#generateSchema(jakarta.xml.bind.SchemaOutputResolver)
     */
    public void generateSchema(SchemaOutputResolver outputResolver) throws IOException {
        super.generateSchema(outputResolver);
    }

    //==================================================================================================================
    // JAXBContext Implementation Methods
    //==================================================================================================================

    @Override
    public abstract Unmarshaller createUnmarshaller() throws JAXBException;

    @Override
    public abstract Marshaller createMarshaller() throws JAXBException;

    @Override
    public Binder<Node> createBinder() {
        return JAXBShim.of(super.createBinder());
    }

    @Override
    public <T> Binder<T> createBinder(Class<T> domType) {
        return JAXBShim.of(super.createBinder(domType));
    }

    @Override
    public JAXBIntrospector createJAXBIntrospector() {
        return JAXBShim.of(super.createJAXBIntrospector());
    }

    @Override
    public void generateSchema(jakarta.xml.bind.SchemaOutputResolver outputResolver) throws IOException {
        generateSchema(JAXBShim.of(outputResolver));
    }

    //==================================================================================================================
    // Private Helper Methods
    //==================================================================================================================

    private static void setFactory(Class<? extends jakarta.xml.bind.JAXBContextFactory> spi, String defaultClassName) {
        final var hasCustomFactories =
            ServiceLoader
                .load(spi)
                .stream()
                .map(ServiceLoader.Provider::type)
                .map(Class::getName)
                .anyMatch(Predicate.not(defaultClassName::equals));
        if (!hasCustomFactories && ShimSupport.classExists(defaultClassName)) {
            System
                .getProperties()
                .putIfAbsent(JAXBContext.JAXB_CONTEXT_FACTORY, defaultClassName);
        }
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        try {
            final var factoryName = JAXBContextFactory.class.getSimpleName();
            setFactory(jakarta.xml.bind.JAXBContextFactory.class, DEFAULT_JAKARTA_RUNTIME_PACKAGE + "." + factoryName);
            setFactory(javax.xml.bind.JAXBContextFactory.class, DEFAULT_JAVAX_RUNTIME_PACKAGE + "." + factoryName);
        } finally {
            JAXBShim.initialize();
        }
    }
}
