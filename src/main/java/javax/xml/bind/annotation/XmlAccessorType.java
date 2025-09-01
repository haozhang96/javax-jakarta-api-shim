package javax.xml.bind.annotation;

import java.lang.annotation.*;

/**
 * @deprecated Use {@link jakarta.xml.bind.annotation.XmlAccessorType} instead.
 */
@Target({ElementType.PACKAGE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Deprecated(since = "jakarta.xml.bind.annotation.XmlAccessorType")
public @interface XmlAccessorType {
    /**
     * @see jakarta.xml.bind.annotation.XmlAccessorType#value()
     */
    XmlAccessType value() default XmlAccessType.PUBLIC_MEMBER;
}
