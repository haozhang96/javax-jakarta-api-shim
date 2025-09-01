package javax.xml.bind.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @deprecated Use {@link jakarta.xml.bind.annotation.XmlElements} instead.
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Deprecated(since = "jakarta.xml.bind.annotation.XmlElements")
public @interface XmlElements {
    /**
     * @see jakarta.xml.bind.annotation.XmlElements#value()
     */
    XmlElement[] value();
}
