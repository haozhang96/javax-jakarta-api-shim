package javax.xml.bind.annotation.adapters;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @deprecated Use {@link jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter} instead.
 */
@Target({ElementType.PACKAGE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Deprecated(since = "jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter")
public @interface XmlJavaTypeAdapter {
    /**
     * @see jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter#value()
     */
    @SuppressWarnings("rawtypes")
    Class<? extends XmlAdapter> value();

    /**
     * @see jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter#type()
     */
    Class<?> type() default jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT.class;
}
