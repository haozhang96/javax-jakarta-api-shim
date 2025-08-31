package javax.annotation;

import javax.shim.Shim;
import javax.shim.ShimSupport;
import java.lang.annotation.Annotation;
import java.util.stream.Stream;

/**
 * @deprecated Use {@link jakarta.annotation} instead.
 */
@Deprecated(since = "jakarta.annotation")
public interface AnnotationShim extends Shim {
    //==================================================================================================================
    // Helper Methods
    //==================================================================================================================

    static void initialize() {
        Shim.initialize();
    }

    //==================================================================================================================
    // Factory Methods
    //==================================================================================================================

    @SuppressWarnings("rawtypes")
    static <S extends AnnotationShim> S of(Object object) {
        if (object == null || object instanceof AnnotationShim) {
            return S(object);
        } else if (object instanceof java.lang.Enum<?>) {
            return S(of((java.lang.Enum) object));
        } else if (object instanceof Annotation) {
            return S(of((Annotation) object));
        }

        return ShimSupport.throwUnknownType(null, object);
    }

    static <S extends AnnotationShim> Stream<S> of(Object[] objects) {
        return Shim.of(AnnotationShim::of, objects);
    }

    static <S extends AnnotationShim> Stream<S> of(Iterable<?> objects) {
        return Shim.of(AnnotationShim::of, objects);
    }

    static <S extends AnnotationShim & Annotation> Stream<S> of(Annotation[] annotations) {
        return Shim.of(AnnotationShim::of, annotations);
    }

    static <S extends AnnotationShim> Class<? extends S> of(Class<S> shimType, Class<?> interfaceType) {
        return Shim.of(shimType, interfaceType);
    }

    //==================================================================================================================
    // Enum-specific Implementation
    //==================================================================================================================

    /**
     * @deprecated Use {@link jakarta.annotation} instead.
     */
    @Deprecated(since = "jakarta.annotation")
    interface Enum<E extends java.lang.Enum<E>> extends AnnotationShim, Shim.Enum<E> { }

    //==================================================================================================================
    // Private Helper Methods
    //==================================================================================================================

    private static <S extends java.lang.Enum<S>> S of(java.lang.Enum<?> enumeration) {
        if (enumeration == null || enumeration instanceof AnnotationShim) {
            return S(enumeration);
        } else if (enumeration instanceof jakarta.annotation.Resource.AuthenticationType) {
            return S(Resource.AuthenticationType.valueOf(enumeration.toString()));
        }

        return ShimSupport.throwUnknownType(null, enumeration);
    }

    private static <S extends Annotation> S of(Annotation annotation) {
        if (annotation == null || annotation instanceof AnnotationShim) {
            return S(annotation);
        } else if (annotation instanceof jakarta.annotation.sql.DataSourceDefinition) {
            return S(new Facades.DataSourceDefinition(S(annotation)));
        } else if (annotation instanceof jakarta.annotation.sql.DataSourceDefinitions) {
            return S(new Facades.DataSourceDefinitions(S(annotation)));
        } else if (annotation instanceof jakarta.annotation.security.DeclareRoles) {
            return S(new Facades.DeclareRoles(S(annotation)));
        } else if (annotation instanceof jakarta.annotation.security.DenyAll) {
            return S(new Facades.DenyAll(S(annotation)));
        } else if (annotation instanceof jakarta.annotation.ManagedBean) {
            return S(new Facades.ManagedBean(S(annotation)));
        } else if (annotation instanceof jakarta.annotation.security.PermitAll) {
            return S(new Facades.PermitAll(S(annotation)));
        } else if (annotation instanceof jakarta.annotation.PostConstruct) {
            return S(new Facades.PostConstruct(S(annotation)));
        } else if (annotation instanceof jakarta.annotation.PreDestroy) {
            return S(new Facades.PreDestroy(S(annotation)));
        } else if (annotation instanceof jakarta.annotation.Priority) {
            return S(new Facades.Priority(S(annotation)));
        } else if (annotation instanceof jakarta.annotation.Resource) {
            return S(new Facades.Resource(S(annotation)));
        } else if (annotation instanceof jakarta.annotation.Resources) {
            return S(new Facades.Resources(S(annotation)));
        }

        return ShimSupport.throwUnknownType(null, annotation);
    }

    @SuppressWarnings("unchecked")
    private static <S> S S(Object object) {
        return (S) object;
    }
}
