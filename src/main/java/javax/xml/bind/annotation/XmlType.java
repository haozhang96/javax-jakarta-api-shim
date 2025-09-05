package javax.xml.bind.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @deprecated Use {@link jakarta.xml.bind.annotation.XmlType} instead.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Deprecated(since = "jakarta.xml.bind.annotation.XmlType")
public @interface XmlType {
    /**
     * @see jakarta.xml.bind.annotation.XmlType#name()
     */
    String name() default XmlElement.DEFAULT_NAME;

    /**
     * @see jakarta.xml.bind.annotation.XmlType#namespace()
     */
    String namespace() default XmlElement.DEFAULT_NAMESPACE;

    /**
     * @see jakarta.xml.bind.annotation.XmlType#propOrder()
     */
    String[] propOrder() default "";

    /**
     * @see jakarta.xml.bind.annotation.XmlType#factoryClass()
     */
    Class<?> factoryClass() default DEFAULT.class;

    /**
     * @see jakarta.xml.bind.annotation.XmlType#factoryMethod()
     */
    String factoryMethod() default "";

    /**
     * @see jakarta.xml.bind.annotation.XmlType.DEFAULT
     */
    final class DEFAULT {
        private DEFAULT() { }
    }
}
