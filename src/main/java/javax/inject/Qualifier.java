package javax.inject;

import java.lang.annotation.*;

/**
 * @deprecated Use {@link jakarta.inject.Qualifier} instead.
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Deprecated(since = "jakarta.inject.Qualifier")
public @interface Qualifier { }
