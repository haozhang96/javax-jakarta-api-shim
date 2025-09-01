package javax.xml.bind;

/**
 * @deprecated Use {@link jakarta.xml.bind.SchemaOutputResolver} instead.
 */
@Deprecated(since = "jakarta.xml.bind.SchemaOutputResolver")
public abstract class SchemaOutputResolver extends jakarta.xml.bind.SchemaOutputResolver implements JAXBShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.SchemaOutputResolver#SchemaOutputResolver()
     */
    protected SchemaOutputResolver() {
        super();
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JAXBShim.initialize();
    }
}
