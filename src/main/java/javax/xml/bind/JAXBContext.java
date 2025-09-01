package javax.xml.bind;

import org.w3c.dom.Node;

import java.io.IOException;
import java.util.Map;

/**
 * @deprecated Use {@link jakarta.xml.bind.JAXBContext} instead.
 */
@Deprecated(since = "jakarta.xml.bind.JAXBContext")
public abstract class JAXBContext extends jakarta.xml.bind.JAXBContext implements JAXBShim {
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
    // Static Initialization
    //==================================================================================================================

    static {
        JAXBShim.initialize();
    }
}
