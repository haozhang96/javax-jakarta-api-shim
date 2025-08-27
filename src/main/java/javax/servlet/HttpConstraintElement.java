package javax.servlet;

import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;

/**
 * @deprecated Use {@link jakarta.servlet.HttpConstraintElement} instead.
 */
@Deprecated(since = "jakarta.servlet.HttpConstraintElement")
public class HttpConstraintElement extends jakarta.servlet.HttpConstraintElement implements ServletShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.servlet.HttpConstraintElement#HttpConstraintElement()
     */
    public HttpConstraintElement() {
        super();
    }

    /**
     * @see jakarta.servlet.HttpConstraintElement#HttpConstraintElement(jakarta.servlet.annotation.ServletSecurity.EmptyRoleSemantic)
     */
    public HttpConstraintElement(ServletSecurity.EmptyRoleSemantic semantic) {
        super(jakarta.servlet.annotation.ServletSecurity.EmptyRoleSemantic.valueOf(semantic.name()));
    }

    /**
     * @see jakarta.servlet.HttpConstraintElement#HttpConstraintElement(jakarta.servlet.annotation.ServletSecurity.TransportGuarantee, String...)
     */
    public HttpConstraintElement(ServletSecurity.TransportGuarantee guarantee, String... roleNames) {
        super(jakarta.servlet.annotation.ServletSecurity.TransportGuarantee.valueOf(guarantee.name()), roleNames);
    }

    /**
     * @see jakarta.servlet.HttpConstraintElement#HttpConstraintElement(jakarta.servlet.annotation.ServletSecurity.EmptyRoleSemantic, jakarta.servlet.annotation.ServletSecurity.TransportGuarantee, String...)
     */
    public HttpConstraintElement(
        ServletSecurity.EmptyRoleSemantic semantic,
        ServletSecurity.TransportGuarantee guarantee,
        String... roleNames
    ) {
        this(
            jakarta.servlet.annotation.ServletSecurity.EmptyRoleSemantic.valueOf(semantic.name()),
            jakarta.servlet.annotation.ServletSecurity.TransportGuarantee.valueOf(guarantee.name()),
            roleNames
        );
    }

    HttpConstraintElement(HttpConstraint annotation) {
        this(annotation.value(), annotation.transportGuarantee(), annotation.rolesAllowed());
    }

    HttpConstraintElement(jakarta.servlet.annotation.HttpConstraint annotation) {
        this(annotation.value(), annotation.transportGuarantee(), annotation.rolesAllowed());
    }

    HttpConstraintElement(
        jakarta.servlet.annotation.ServletSecurity.EmptyRoleSemantic semantic,
        jakarta.servlet.annotation.ServletSecurity.TransportGuarantee guarantee,
        String... roleNames
    ) {
        super(semantic, guarantee, roleNames);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ServletShim.initialize();
    }
}
