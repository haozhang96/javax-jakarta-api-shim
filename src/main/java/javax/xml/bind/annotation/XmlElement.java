package javax.xml.bind.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @deprecated Use {@link jakarta.xml.bind.annotation.XmlElement} instead.
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Deprecated(since = "jakarta.xml.bind.annotation.XmlElement")
public @interface XmlElement {
    /**
     * @see jakarta.xml.bind.annotation.XmlElement#name()
     * @see jakarta.xml.bind.annotation.XmlRootElement#name()
     * @see jakarta.xml.bind.annotation.XmlType#name()
     */
    String DEFAULT_NAME = "##default";

    /**
     * @see jakarta.xml.bind.annotation.XmlElement#namespace()
     * @see jakarta.xml.bind.annotation.XmlRootElement#namespace()
     * @see jakarta.xml.bind.annotation.XmlType#namespace()
     */
    String DEFAULT_NAMESPACE = DEFAULT_NAME;

    /**
     * @see jakarta.xml.bind.annotation.XmlElement#defaultValue()
     * @see jakarta.xml.bind.annotation.XmlElementDecl#defaultValue()
     */
    String DEFAULT_VALUE = "\u0000";

    /**
     * @see jakarta.xml.bind.annotation.XmlElement#name()
     */
    String name() default DEFAULT_NAME;

    /**
     * @see jakarta.xml.bind.annotation.XmlElement#namespace()
     */
    String namespace() default DEFAULT_NAMESPACE;

    /**
     * @see jakarta.xml.bind.annotation.XmlElement#nillable()
     */
    boolean nillable() default false;

    /**
     * @see jakarta.xml.bind.annotation.XmlElement#required()
     */
    boolean required() default false;

    /**
     * @see jakarta.xml.bind.annotation.XmlElement#defaultValue()
     */
    String defaultValue() default DEFAULT_VALUE;

    /**
     * @see jakarta.xml.bind.annotation.XmlElement#type()
     */
    Class<?> type() default jakarta.xml.bind.annotation.XmlElement.DEFAULT.class;
}
