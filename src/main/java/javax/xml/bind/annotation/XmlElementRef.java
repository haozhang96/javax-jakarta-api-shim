package javax.xml.bind.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @deprecated Use {@link jakarta.xml.bind.annotation.XmlElementRef} instead.
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Deprecated(since = "jakarta.xml.bind.annotation.XmlElementRef")
public @interface XmlElementRef {
    /**
     * @see jakarta.xml.bind.annotation.XmlElementRef#name()
     */
    String name() default XmlElement.DEFAULT_NAME;

    /**
     * @see jakarta.xml.bind.annotation.XmlElementRef#namespace()
     */
    String namespace() default XmlElement.DEFAULT_NAMESPACE;

    /**
     * @see jakarta.xml.bind.annotation.XmlElementRef#required()
     */
    boolean required() default true;

    /**
     * @see jakarta.xml.bind.annotation.XmlElementRef#type()
     */
    Class<?> type() default jakarta.xml.bind.annotation.XmlElementRef.DEFAULT.class;
}
