package javax.xml.bind.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @deprecated Use {@link jakarta.xml.bind.annotation.XmlRootElement} instead.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Deprecated(since = "jakarta.xml.bind.annotation.XmlRootElement")
public @interface XmlRootElement {
    /**
     * @see jakarta.xml.bind.annotation.XmlRootElement#name()
     */
    String name() default XmlElement.DEFAULT_NAME;

    /**
     * @see jakarta.xml.bind.annotation.XmlRootElement#namespace()
     */
    String namespace() default XmlElement.DEFAULT_NAMESPACE;
}
