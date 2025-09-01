package javax.xml.bind.annotation;

import javax.xml.bind.JAXBShim;

/**
 * @deprecated Use {@link jakarta.xml.bind.annotation.XmlAccessOrder} instead.
 */
@Deprecated(since = "jakarta.xml.bind.annotation.XmlAccessOrder")
public enum XmlAccessOrder implements JAXBShim.Enum<jakarta.xml.bind.annotation.XmlAccessOrder> {
    /**
     * @see jakarta.xml.bind.annotation.XmlAccessOrder#UNDEFINED
     */
    UNDEFINED,

    /**
     * @see jakarta.xml.bind.annotation.XmlAccessOrder#ALPHABETICAL
     */
    ALPHABETICAL;

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JAXBShim.initialize();
    }
}
