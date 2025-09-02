package javax.xml.bind.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @deprecated Use {@link jakarta.xml.bind.annotation.XmlAnyElement} instead.
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Deprecated(since = "jakarta.xml.bind.annotation.XmlAnyElement")
public @interface XmlAnyElement {
    /**
     * @see jakarta.xml.bind.annotation.XmlAnyElement#value()
     */
    Class<? extends DomHandler> value() default W3CDomHandler.class;

    /**
     * @see jakarta.xml.bind.annotation.XmlAnyElement#lax()
     */
    boolean lax() default false;
}
