package javax.xml.bind.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @deprecated Use {@link jakarta.xml.bind.annotation.XmlSchema} instead.
 */
@Target(ElementType.PACKAGE)
@Retention(RetentionPolicy.RUNTIME)
@Deprecated(since = "jakarta.xml.bind.annotation.XmlSchema")
public @interface XmlSchema {
    /**
     * @see jakarta.xml.bind.annotation.XmlSchema#NO_LOCATION
     */
    String NO_LOCATION = jakarta.xml.bind.annotation.XmlSchema.NO_LOCATION;

    /**
     * @see jakarta.xml.bind.annotation.XmlSchema#xmlns()
     */
    XmlNs[] xmlns() default {};

    /**
     * @see jakarta.xml.bind.annotation.XmlSchema#namespace()
     */
    String namespace() default "";

    /**
     * @see jakarta.xml.bind.annotation.XmlSchema#elementFormDefault()
     */
    XmlNsForm elementFormDefault() default XmlNsForm.UNSET;

    /**
     * @see jakarta.xml.bind.annotation.XmlSchema#attributeFormDefault()
     */
    XmlNsForm attributeFormDefault() default XmlNsForm.UNSET;

    /**
     * @see jakarta.xml.bind.annotation.XmlSchema#location()
     */
    String location() default NO_LOCATION;
}
