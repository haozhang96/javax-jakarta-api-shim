package javax.servlet.annotation;

import javax.servlet.ServletShim;
import java.lang.annotation.*;

/**
 * @deprecated Use {@link jakarta.servlet.annotation.ServletSecurity} instead.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Deprecated(since = "jakarta.servlet.annotation.ServletSecurity")
public @interface ServletSecurity {
    /**
     * @see jakarta.servlet.annotation.ServletSecurity#value()
     */
    HttpConstraint value() default @HttpConstraint;

    /**
     * @see jakarta.servlet.annotation.ServletSecurity#httpMethodConstraints()
     */
    HttpMethodConstraint[] httpMethodConstraints() default {};

    /**
     * @deprecated Use {@link jakarta.servlet.annotation.ServletSecurity.EmptyRoleSemantic} instead.
     */
    @Deprecated(since = "jakarta.servlet.annotation.ServletSecurity.EmptyRoleSemantic")
    enum EmptyRoleSemantic implements ServletShim.Enum<jakarta.servlet.annotation.ServletSecurity.EmptyRoleSemantic> {
        PERMIT, DENY
    }

    /**
     * @deprecated Use {@link jakarta.servlet.annotation.ServletSecurity.TransportGuarantee} instead.
     */
    @Deprecated(since = "jakarta.servlet.annotation.ServletSecurity.TransportGuarantee")
    enum TransportGuarantee implements ServletShim.Enum<jakarta.servlet.annotation.ServletSecurity.TransportGuarantee> {
        NONE, CONFIDENTIAL
    }
}
