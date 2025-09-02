package javax.xml.bind.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @deprecated Use {@link jakarta.xml.bind.annotation.XmlNs} instead.
 */
@Target({})
@Retention(RetentionPolicy.RUNTIME)
@Deprecated(since = "jakarta.xml.bind.annotation.XmlNs")
public @interface XmlNs {
    /**
     * @see jakarta.xml.bind.annotation.XmlNs#prefix()
     */
    String prefix();

    /**
     * @see jakarta.xml.bind.annotation.XmlNs#namespaceURI()
     */
    String namespaceURI();
}
