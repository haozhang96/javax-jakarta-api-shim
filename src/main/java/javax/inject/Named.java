package javax.inject;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @deprecated Use {@link jakarta.inject.Named} instead.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Deprecated(since = "jakarta.inject.Named")
public @interface Named {
    /**
     * @see jakarta.inject.Named#value()
     */
    String value() default "";
}
