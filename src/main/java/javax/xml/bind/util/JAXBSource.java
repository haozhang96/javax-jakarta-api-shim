package javax.xml.bind.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBShim;
import javax.xml.bind.Marshaller;

/**
 * @deprecated Use {@link jakarta.xml.bind.util.JAXBSource} instead.
 */
@Deprecated(since = "jakarta.xml.bind.util.JAXBSource")
public class JAXBSource extends jakarta.xml.bind.util.JAXBSource implements JAXBShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.util.JAXBSource#JAXBSource(jakarta.xml.bind.JAXBContext, Object)
     */
    public JAXBSource(JAXBContext context, Object jaxbObject) throws jakarta.xml.bind.JAXBException {
        super(context, jaxbObject);
    }

    /**
     * @see jakarta.xml.bind.util.JAXBSource#JAXBSource(jakarta.xml.bind.Marshaller, Object)
     */
    public JAXBSource(Marshaller marshaller, Object jaxbObject) throws jakarta.xml.bind.JAXBException {
        super(marshaller, jaxbObject);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JAXBShim.initialize();
    }
}
