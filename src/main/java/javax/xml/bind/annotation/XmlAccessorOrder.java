package javax.xml.bind.annotation;

import java.lang.annotation.*;

/**
 * @deprecated Use {@link jakarta.xml.bind.annotation.XmlAccessorOrder} instead.
 */
@Target({ElementType.PACKAGE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Deprecated(since = "jakarta.xml.bind.annotation.XmlAccessorOrder")
public @interface XmlAccessorOrder {
    /**
     * @see jakarta.xml.bind.annotation.XmlAccessorOrder#value()
     */
    XmlAccessOrder value() default XmlAccessOrder.UNDEFINED;
}
