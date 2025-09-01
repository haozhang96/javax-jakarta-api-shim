package javax.xml.bind;

/**
 * @deprecated Use {@link jakarta.xml.bind.JAXBIntrospector} instead.
 */
@Deprecated(since = "jakarta.xml.bind.JAXBIntrospector")
public abstract class JAXBIntrospector extends jakarta.xml.bind.JAXBIntrospector implements JAXBShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.JAXBIntrospector#JAXBIntrospector()
     */
    protected JAXBIntrospector() {
        super();
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JAXBShim.initialize();
    }
}
