package javax.xml.bind.annotation.adapters;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @deprecated Use {@link jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapters} instead.
 */
@Target(ElementType.PACKAGE)
@Retention(RetentionPolicy.RUNTIME)
@Deprecated(since = "jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapters")
public @interface XmlJavaTypeAdapters {
    /**
     * @see jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapters#value()
     */
    XmlJavaTypeAdapter[] value();
}
