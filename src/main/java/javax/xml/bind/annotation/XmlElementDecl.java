package javax.xml.bind.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @deprecated Use {@link jakarta.xml.bind.annotation.XmlElementDecl} instead.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Deprecated(since = "jakarta.xml.bind.annotation.XmlElementDecl")
public @interface XmlElementDecl {
    /**
     * @see jakarta.xml.bind.annotation.XmlElementDecl#name()
     */
    String name();

    /**
     * @see jakarta.xml.bind.annotation.XmlElementDecl#namespace()
     */
    String namespace() default XmlElement.DEFAULT_NAMESPACE;

    /**
     * @see jakarta.xml.bind.annotation.XmlElementDecl#substitutionHeadName()
     */
    String substitutionHeadName() default "";

    /**
     * @see jakarta.xml.bind.annotation.XmlElementDecl#substitutionHeadNamespace()
     */
    String substitutionHeadNamespace() default XmlElement.DEFAULT_NAMESPACE;

    /**
     * @see jakarta.xml.bind.annotation.XmlElementDecl#defaultValue()
     */
    String defaultValue() default XmlElement.DEFAULT_VALUE;

    /**
     * @see jakarta.xml.bind.annotation.XmlElementDecl#scope()
     */
    Class<?> scope() default jakarta.xml.bind.annotation.XmlElementDecl.GLOBAL.class;
}
