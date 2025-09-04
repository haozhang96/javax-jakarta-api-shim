package javax.xml.bind.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @deprecated Use {@link jakarta.xml.bind.annotation.XmlSchemaType} instead.
 */
@Target({ElementType.PACKAGE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Deprecated(since = "jakarta.xml.bind.annotation.XmlSchemaType")
public @interface XmlSchemaType {
    /**
     * @see jakarta.xml.bind.annotation.XmlSchemaType#name()
     */
    String name();

    /**
     * @see jakarta.xml.bind.annotation.XmlSchemaType#namespace()
     */
    String namespace() default "http://www.w3.org/2001/XMLSchema";

    /**
     * @see jakarta.xml.bind.annotation.XmlSchemaType#type()
     */
    Class<?> type() default DEFAULT.class;

    /**
     * @see jakarta.xml.bind.annotation.XmlSchemaType.DEFAULT
     */
    final class DEFAULT {
        private DEFAULT() { }
    }
}
