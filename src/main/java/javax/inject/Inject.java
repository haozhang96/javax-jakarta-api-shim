package javax.inject;

import java.lang.annotation.*;

/**
 * @deprecated Use {@link jakarta.inject.Inject} instead.
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Deprecated(since = "jakarta.inject.Inject")
public @interface Inject { }
