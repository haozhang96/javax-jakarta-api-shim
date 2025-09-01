package javax.xml.bind.annotation;

import javax.xml.bind.JAXBShim;

/**
 * @deprecated Use {@link jakarta.xml.bind.annotation.XmlNsForm} instead.
 */
@Deprecated(since = "jakarta.xml.bind.annotation.XmlNsForm")
public enum XmlNsForm implements JAXBShim.Enum<jakarta.xml.bind.annotation.XmlNsForm> {
    UNQUALIFIED, QUALIFIED, UNSET;

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JAXBShim.initialize();
    }
}
