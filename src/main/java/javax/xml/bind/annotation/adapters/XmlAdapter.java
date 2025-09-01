package javax.xml.bind.annotation.adapters;

import javax.xml.bind.JAXBShim;

/**
 * @deprecated Use {@link jakarta.xml.bind.annotation.adapters.XmlAdapter} instead.
 */
@Deprecated(since = "jakarta.xml.bind.annotation.adapters.XmlAdapter")
public abstract class XmlAdapter<ValueType, BoundType> extends jakarta.xml.bind.annotation.adapters.XmlAdapter<ValueType, BoundType> implements JAXBShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.annotation.adapters.XmlAdapter#XmlAdapter()
     */
    protected XmlAdapter() {
        super();
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JAXBShim.initialize();
    }
}
