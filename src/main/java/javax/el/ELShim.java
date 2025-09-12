package javax.el;

import javax.shim.Shim;
import javax.shim.ShimSupport;
import java.lang.annotation.Annotation;
import java.util.stream.Stream;

/**
 * @deprecated Use {@link jakarta.el} instead.
 */
@Deprecated(since = "jakarta.el")
public interface ELShim extends Shim {
    //==================================================================================================================
    // Helper Methods
    //==================================================================================================================

    static void initialize() {
        Shim.initialize();
    }

    //==================================================================================================================
    // Factory Methods
    //==================================================================================================================

    static <S extends ELShim> S of(Object object) {
        //==============================================================================================================
        // Specializations
        //==============================================================================================================

        if (object == null || object instanceof ELShim) {
            return S(object);
        } else if (object instanceof jakarta.el.ELException) {
            return S(of((jakarta.el.ELException) object));
        } else if (object instanceof Annotation) {
            return S(of((Annotation) object));

        //==============================================================================================================
        // Contexts
        //==============================================================================================================

        } else if (object instanceof jakarta.el.StandardELContext) {
            return S(new Facades.StandardELContext(S(object)));
        } else if (object instanceof jakarta.el.ELContext) {
            return S(new Facades.ELContext(S(object)));

        //==============================================================================================================
        // Expressions
        //==============================================================================================================

        } else if (object instanceof jakarta.el.MethodExpression) {
            return S(new Facades.MethodExpression(S(object)));
        } else if (object instanceof jakarta.el.ValueExpression) {
            return S(new Facades.ValueExpression(S(object)));
        } else if (object instanceof jakarta.el.Expression) {
            return S(new Facades.Expression(S(object)));

        //==============================================================================================================
        // Resolvers
        //==============================================================================================================

        } else if (object instanceof jakarta.el.ArrayELResolver) {
            return S(new Facades.ArrayELResolver(S(object)));
        } else if (object instanceof jakarta.el.BeanNameELResolver) {
            return S(new Facades.BeanNameELResolver(S(object)));
        } else if (object instanceof jakarta.el.CompositeELResolver) {
            return S(new Facades.CompositeELResolver(S(object)));
        } else if (object instanceof jakarta.el.ListELResolver) {
            return S(new Facades.ListELResolver(S(object)));
        } else if (object instanceof jakarta.el.MapELResolver) {
            return S(new Facades.MapELResolver(S(object)));
        } else if (object instanceof jakarta.el.ResourceBundleELResolver) {
            return S(new Facades.ResourceBundleELResolver(S(object)));
        } else if (object instanceof jakarta.el.StaticFieldELResolver) {
            return S(new Facades.StaticFieldELResolver(S(object)));
        } else if (object instanceof jakarta.el.TypeConverter) {
            return S(new Facades.TypeConverter(S(object)));
        } else if (object instanceof jakarta.el.ELResolver) {
            return S(new Facades.ELResolver(S(object)));

        //==============================================================================================================
        // Core
        //==============================================================================================================

        } else if (object instanceof jakarta.el.BeanNameResolver) {
            return S(new Facades.BeanNameResolver(S(object)));
        } else if (object instanceof jakarta.el.ELClass) {
            return S(new Facades.ELClass(S(object)));
        } else if (object instanceof jakarta.el.ELContextEvent) {
            return S(new Facades.ELContextEvent(S(object)));
        } else if (object instanceof jakarta.el.ELContextListener) {
            return S(new Facades.ELContextListener(S(object)));
        } else if (object instanceof jakarta.el.ELManager) {
            return S(new Facades.ELManager(S(object)));
        } else if (object instanceof jakarta.el.ELProcessor) {
            return S(new Facades.ELProcessor(S(object)));
        } else if (object instanceof jakarta.el.EvaluationListener) {
            return S(new Facades.EvaluationListener(S(object)));
        } else if (object instanceof jakarta.el.ExpressionFactory) {
            return S(new Facades.ExpressionFactory(S(object)));
        } else if (object instanceof jakarta.el.FunctionMapper) {
            return S(new Facades.FunctionMapper(S(object)));
        } else if (object instanceof jakarta.el.ImportHandler) {
            return S(new Facades.ImportHandler(S(object)));
        } else if (object instanceof jakarta.el.LambdaExpression) {
            return S(new Facades.LambdaExpression(S(object)));
        } else if (object instanceof jakarta.el.MethodInfo) {
            return S(new Facades.MethodInfo(S(object)));
        } else if (object instanceof jakarta.el.MethodReference) {
            return S(new Facades.MethodReference(S(object)));
        } else if (object instanceof jakarta.el.ValueReference) {
            return S(new Facades.ValueReference(S(object)));
        } else if (object instanceof jakarta.el.VariableMapper) {
            return S(new Facades.VariableMapper(S(object)));
        }

        return ShimSupport.throwUnknownType(null, object);
    }

    static <S extends ELException> S of(jakarta.el.ELException exception) {
        if (exception == null || exception instanceof ELShim) {
            return S(exception);
        } else if (exception instanceof jakarta.el.MethodNotFoundException) {
            return S(new Facades.MethodNotFoundException(S(exception)));
        } else if (exception instanceof jakarta.el.PropertyNotFoundException) {
            return S(new Facades.PropertyNotFoundException(S(exception)));
        } else if (exception instanceof jakarta.el.PropertyNotWritableException) {
            return S(new Facades.PropertyNotWritableException(S(exception)));
        }

        return S(new Facades.ELException(exception));
    }

    static <S extends ELShim> Stream<S> of(Object[] objects) {
        return Shim.of(ELShim::of, objects);
    }

    static <S extends ELShim> Stream<S> of(Iterable<?> objects) {
        return Shim.of(ELShim::of, objects);
    }

    static <S extends ELShim> Class<? extends S> of(Class<?> baseType, Class<S> shimType) {
        return Shim.of(baseType, shimType);
    }

    //==================================================================================================================
    // Private Helper Methods
    //==================================================================================================================

    private static <S extends Annotation> S of(Annotation annotation) {
        if (annotation == null || annotation instanceof ELShim) {
            return S(annotation);
        }

        return ShimSupport.throwUnknownType(null, annotation);
    }

    @SuppressWarnings("unchecked")
    private static <S> S S(Object object) {
        return (S) object;
    }
}
