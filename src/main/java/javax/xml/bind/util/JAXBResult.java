package javax.xml.bind.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBShim;
import javax.xml.bind.Unmarshaller;

/**
 * @deprecated Use {@link jakarta.xml.bind.util.JAXBResult} instead.
 */
@Deprecated(since = "jakarta.xml.bind.util.JAXBResult")
public class JAXBResult extends jakarta.xml.bind.util.JAXBResult implements JAXBShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.util.JAXBResult#JAXBResult(jakarta.xml.bind.JAXBContext)
     */
    public JAXBResult(JAXBContext context) throws jakarta.xml.bind.JAXBException {
        super(context);
    }

    /**
     * @see jakarta.xml.bind.util.JAXBResult#JAXBResult(jakarta.xml.bind.Unmarshaller)
     */
    public JAXBResult(Unmarshaller unmarshaller) throws jakarta.xml.bind.JAXBException {
        super(unmarshaller);
    }

    //==================================================================================================================
    // JAXBResult Implementation Methods
    //==================================================================================================================

    @Override
    public Object getResult() throws JAXBException {
        try {
            return super.getResult();
        } catch (jakarta.xml.bind.JAXBException exception) {
            throw JAXBShim.of(exception);
        }
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JAXBShim.initialize();
    }
}
