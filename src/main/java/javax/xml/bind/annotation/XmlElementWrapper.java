package javax.xml.bind.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @deprecated Use {@link jakarta.xml.bind.annotation.XmlElementWrapper} instead.
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Deprecated(since = "jakarta.xml.bind.annotation.XmlElementWrapper")
public @interface XmlElementWrapper {
    /**
     * @see jakarta.xml.bind.annotation.XmlElementWrapper#name()
     */
    String name() default XmlElement.DEFAULT_NAME;

    /**
     * @see jakarta.xml.bind.annotation.XmlElementWrapper#namespace()
     */
    String namespace() default XmlElement.DEFAULT_NAMESPACE;

    /**
     * @see jakarta.xml.bind.annotation.XmlElementWrapper#nillable()
     */
    boolean nillable() default false;

    /**
     * @see jakarta.xml.bind.annotation.XmlElementWrapper#required()
     */
    boolean required() default false;
}
