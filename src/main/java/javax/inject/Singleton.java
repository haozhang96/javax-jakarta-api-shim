package javax.inject;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @deprecated Use {@link jakarta.inject.Singleton} instead.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Deprecated(since = "jakarta.inject.Singleton")
public @interface Singleton { }
