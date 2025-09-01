package javax.xml.bind.annotation;

import javax.xml.bind.JAXBShim;

/**
 * @deprecated Use {@link jakarta.xml.bind.annotation.XmlAccessType} instead.
 */
@Deprecated(since = "jakarta.xml.bind.annotation.XmlAccessType")
public enum XmlAccessType implements JAXBShim.Enum<jakarta.xml.bind.annotation.XmlAccessType> {
    /**
     * @see jakarta.xml.bind.annotation.XmlAccessType#PROPERTY
     */
    PROPERTY,

    /**
     * @see jakarta.xml.bind.annotation.XmlAccessType#FIELD
     */
    FIELD,

    /**
     * @see jakarta.xml.bind.annotation.XmlAccessType#PUBLIC_MEMBER
     */
    PUBLIC_MEMBER,

    /**
     * @see jakarta.xml.bind.annotation.XmlAccessType#NONE
     */
    NONE;

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JAXBShim.initialize();
    }
}
