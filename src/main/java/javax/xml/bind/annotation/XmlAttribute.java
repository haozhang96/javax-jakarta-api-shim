package javax.xml.bind.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @deprecated Use {@link jakarta.xml.bind.annotation.XmlAttribute} instead.
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Deprecated(since = "jakarta.xml.bind.annotation.XmlAttribute")
public @interface XmlAttribute {
    /**
     * @see jakarta.xml.bind.annotation.XmlAttribute#name()
     */
    String name() default XmlElement.DEFAULT_NAME;

    /**
     * @see jakarta.xml.bind.annotation.XmlAttribute#namespace()
     */
    String namespace() default XmlElement.DEFAULT_NAMESPACE;

    /**
     * @see jakarta.xml.bind.annotation.XmlAttribute#required()
     */
    boolean required() default false;
}
