package javax.el;

import java.beans.FeatureDescriptor;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * This interface contains {@link javax.el}-to-{@link jakarta.el} retrofits used for wrapping Java Expression Language
 *   objects into their Jakarta Expression Language counterparts.
 *
 * @deprecated Use {@link jakarta.el} instead.
 */
@Deprecated(since = "jakarta.el")
@SuppressWarnings("all")
interface Retrofits {
    //==================================================================================================================
    // Classes
    //==================================================================================================================

    final class ArrayELResolver extends jakarta.el.ArrayELResolver implements ELShim.Retrofit {
        private final javax.el.ArrayELResolver target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ArrayELResolver(javax.el.ArrayELResolver target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Object getValue(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getValue(context, bean, property);
        }

        @Override
        public void setValue(jakarta.el.ELContext context, Object bean, Object property, Object value) {
            target.setValue(context, bean, property, value);
        }

        @Override
        public boolean isReadOnly(jakarta.el.ELContext context, Object bean, Object property) {
            return target.isReadOnly(context, bean, property);
        }

        @Override
        public Class<?> getType(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getType(context, bean, property);
        }

        @Override
        public Class<?> getCommonPropertyType(jakarta.el.ELContext context, Object bean) {
            return target.getCommonPropertyType(context, bean);
        }

        @Override
        public <T> T convertToType(jakarta.el.ELContext context, Object object, Class<T> targetType) {
            return target.convertToType(context, object, targetType);
        }

        @Override
        public Object invoke(
            jakarta.el.ELContext context,
            Object bean,
            Object method,
            Class<?>[] parameterTypes,
            Object[] parameters
        ) {
            return target.invoke(context, bean, method, parameterTypes, parameters);
        }

        @Override
        public Iterator<FeatureDescriptor> getFeatureDescriptors(jakarta.el.ELContext context, Object bean) {
            return target.getFeatureDescriptors(context, bean);
        }
    }

    final class BeanNameELResolver extends jakarta.el.BeanNameELResolver implements ELShim.Retrofit {
        private final javax.el.BeanNameELResolver target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        BeanNameELResolver(javax.el.BeanNameELResolver target) {
            super(null);
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Object getValue(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getValue(context, bean, property);
        }

        @Override
        public void setValue(jakarta.el.ELContext context, Object bean, Object property, Object value) {
            target.setValue(context, bean, property, value);
        }

        @Override
        public boolean isReadOnly(jakarta.el.ELContext context, Object bean, Object property) {
            return target.isReadOnly(context, bean, property);
        }

        @Override
        public Class<?> getType(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getType(context, bean, property);
        }

        @Override
        public Class<?> getCommonPropertyType(jakarta.el.ELContext context, Object bean) {
            return target.getCommonPropertyType(context, bean);
        }

        @Override
        public <T> T convertToType(jakarta.el.ELContext context, Object object, Class<T> targetType) {
            return target.convertToType(context, object, targetType);
        }

        @Override
        public Object invoke(
            jakarta.el.ELContext context,
            Object bean,
            Object method,
            Class<?>[] parameterTypes,
            Object[] parameters
        ) {
            return target.invoke(context, bean, method, parameterTypes, parameters);
        }

        @Override
        public Iterator<FeatureDescriptor> getFeatureDescriptors(jakarta.el.ELContext context, Object bean) {
            return target.getFeatureDescriptors(context, bean);
        }
    }

    final class CompositeELResolver extends jakarta.el.CompositeELResolver implements ELShim.Retrofit {
        private final javax.el.CompositeELResolver target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        CompositeELResolver(javax.el.CompositeELResolver target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void add(jakarta.el.ELResolver resolver) {
            target.add(resolver);
        }

        @Override
        public Object getValue(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getValue(context, bean, property);
        }

        @Override
        public void setValue(jakarta.el.ELContext context, Object bean, Object property, Object value) {
            target.setValue(context, bean, property, value);
        }

        @Override
        public boolean isReadOnly(jakarta.el.ELContext context, Object bean, Object property) {
            return target.isReadOnly(context, bean, property);
        }

        @Override
        public Class<?> getType(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getType(context, bean, property);
        }

        @Override
        public Class<?> getCommonPropertyType(jakarta.el.ELContext context, Object bean) {
            return target.getCommonPropertyType(context, bean);
        }

        @Override
        public <T> T convertToType(jakarta.el.ELContext context, Object object, Class<T> targetType) {
            return target.convertToType(context, object, targetType);
        }

        @Override
        public Object invoke(
            jakarta.el.ELContext context,
            Object bean,
            Object method,
            Class<?>[] parameterTypes,
            Object[] parameters
        ) {
            return target.invoke(context, bean, method, parameterTypes, parameters);
        }

        @Override
        public Iterator<FeatureDescriptor> getFeatureDescriptors(jakarta.el.ELContext context, Object bean) {
            return target.getFeatureDescriptors(context, bean);
        }
    }

    final class ListELResolver extends jakarta.el.ListELResolver implements ELShim.Retrofit {
        private final javax.el.ListELResolver target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ListELResolver(javax.el.ListELResolver target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Object getValue(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getValue(context, bean, property);
        }

        @Override
        public void setValue(jakarta.el.ELContext context, Object bean, Object property, Object value) {
            target.setValue(context, bean, property, value);
        }

        @Override
        public boolean isReadOnly(jakarta.el.ELContext context, Object bean, Object property) {
            return target.isReadOnly(context, bean, property);
        }

        @Override
        public Class<?> getType(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getType(context, bean, property);
        }

        @Override
        public Class<?> getCommonPropertyType(jakarta.el.ELContext context, Object bean) {
            return target.getCommonPropertyType(context, bean);
        }

        @Override
        public <T> T convertToType(jakarta.el.ELContext context, Object object, Class<T> targetType) {
            return target.convertToType(context, object, targetType);
        }

        @Override
        public Object invoke(
            jakarta.el.ELContext context,
            Object bean,
            Object method,
            Class<?>[] parameterTypes,
            Object[] parameters
        ) {
            return target.invoke(context, bean, method, parameterTypes, parameters);
        }

        @Override
        public Iterator<FeatureDescriptor> getFeatureDescriptors(jakarta.el.ELContext context, Object bean) {
            return target.getFeatureDescriptors(context, bean);
        }
    }

    final class MapELResolver extends jakarta.el.MapELResolver implements ELShim.Retrofit {
        private final javax.el.MapELResolver target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        MapELResolver(javax.el.MapELResolver target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Object getValue(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getValue(context, bean, property);
        }

        @Override
        public void setValue(jakarta.el.ELContext context, Object bean, Object property, Object value) {
            target.setValue(context, bean, property, value);
        }

        @Override
        public boolean isReadOnly(jakarta.el.ELContext context, Object bean, Object property) {
            return target.isReadOnly(context, bean, property);
        }

        @Override
        public Class<?> getType(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getType(context, bean, property);
        }

        @Override
        public Class<?> getCommonPropertyType(jakarta.el.ELContext context, Object bean) {
            return target.getCommonPropertyType(context, bean);
        }

        @Override
        public <T> T convertToType(jakarta.el.ELContext context, Object object, Class<T> targetType) {
            return target.convertToType(context, object, targetType);
        }

        @Override
        public Object invoke(
            jakarta.el.ELContext context,
            Object bean,
            Object method,
            Class<?>[] parameterTypes,
            Object[] parameters
        ) {
            return target.invoke(context, bean, method, parameterTypes, parameters);
        }

        @Override
        public Iterator<FeatureDescriptor> getFeatureDescriptors(jakarta.el.ELContext context, Object bean) {
            return target.getFeatureDescriptors(context, bean);
        }
    }

    final class MethodExpression extends jakarta.el.MethodExpression implements ELShim.Retrofit {
        private static final long serialVersionUID = javax.shim.ShimSupport.getSerialVersionUID();

        private final javax.el.MethodExpression target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        MethodExpression(javax.el.MethodExpression target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public jakarta.el.MethodInfo getMethodInfo(jakarta.el.ELContext context) {
            return target.getMethodInfo(ELShim.of(context));
        }

        @Override
        public Object invoke(jakarta.el.ELContext context, Object[] parameters) {
            return target.invoke(ELShim.of(context), parameters);
        }

        @Override
        public boolean isParametersProvided() {
            return target.isParametersProvided();
        }

        @Override
        public jakarta.el.MethodReference getMethodReference(jakarta.el.ELContext context) {
            return target.getMethodReference(ELShim.of(context));
        }

        @Override
        public String getExpressionString() {
            return target.getExpressionString();
        }

        @Override
        public boolean equals(Object other) {
            return target.equals(other);
        }

        @Override
        public int hashCode() {
            return target.hashCode();
        }

        @Override
        public boolean isLiteralText() {
            return target.isLiteralText();
        }
    }

    final class MethodNotFoundException extends jakarta.el.MethodNotFoundException implements ELShim.Retrofit {
        private final javax.el.MethodNotFoundException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        MethodNotFoundException(javax.el.MethodNotFoundException target) {
            super(target.getMessage(), target.getCause());
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public String getLocalizedMessage() {
            return target.getLocalizedMessage();
        }

        @Override
        public Throwable getCause() {
            return target.getCause();
        }

        @Override
        public Throwable initCause(Throwable cause) {
            return target.initCause(cause);
        }

        @Override
        public String toString() {
            return target.toString();
        }

        @Override
        public void printStackTrace() {
            target.printStackTrace();
        }

        @Override
        public void printStackTrace(PrintStream s) {
            target.printStackTrace(s);
        }

        @Override
        public void printStackTrace(PrintWriter s) {
            target.printStackTrace(s);
        }

        @Override
        public Throwable fillInStackTrace() {
            try {
                return super.fillInStackTrace();
            } finally {
                if (target != null) {
                    target.fillInStackTrace();
                }
            }
        }

        @Override
        public StackTraceElement[] getStackTrace() {
            return target.getStackTrace();
        }

        @Override
        public void setStackTrace(StackTraceElement[] stackTrace) {
            target.setStackTrace(stackTrace);
        }
    }

    final class PropertyNotFoundException extends jakarta.el.PropertyNotFoundException implements ELShim.Retrofit {
        private final javax.el.PropertyNotFoundException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        PropertyNotFoundException(javax.el.PropertyNotFoundException target) {
            super(target.getMessage(), target.getCause());
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public String getLocalizedMessage() {
            return target.getLocalizedMessage();
        }

        @Override
        public Throwable getCause() {
            return target.getCause();
        }

        @Override
        public Throwable initCause(Throwable cause) {
            return target.initCause(cause);
        }

        @Override
        public String toString() {
            return target.toString();
        }

        @Override
        public void printStackTrace() {
            target.printStackTrace();
        }

        @Override
        public void printStackTrace(PrintStream s) {
            target.printStackTrace(s);
        }

        @Override
        public void printStackTrace(PrintWriter s) {
            target.printStackTrace(s);
        }

        @Override
        public Throwable fillInStackTrace() {
            try {
                return super.fillInStackTrace();
            } finally {
                if (target != null) {
                    target.fillInStackTrace();
                }
            }
        }

        @Override
        public StackTraceElement[] getStackTrace() {
            return target.getStackTrace();
        }

        @Override
        public void setStackTrace(StackTraceElement[] stackTrace) {
            target.setStackTrace(stackTrace);
        }
    }

    final class PropertyNotWritableException extends jakarta.el.PropertyNotWritableException implements ELShim.Retrofit {
        private final javax.el.PropertyNotWritableException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        PropertyNotWritableException(javax.el.PropertyNotWritableException target) {
            super(target.getMessage(), target.getCause());
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public String getLocalizedMessage() {
            return target.getLocalizedMessage();
        }

        @Override
        public Throwable getCause() {
            return target.getCause();
        }

        @Override
        public Throwable initCause(Throwable cause) {
            return target.initCause(cause);
        }

        @Override
        public String toString() {
            return target.toString();
        }

        @Override
        public void printStackTrace() {
            target.printStackTrace();
        }

        @Override
        public void printStackTrace(PrintStream s) {
            target.printStackTrace(s);
        }

        @Override
        public void printStackTrace(PrintWriter s) {
            target.printStackTrace(s);
        }

        @Override
        public Throwable fillInStackTrace() {
            try {
                return super.fillInStackTrace();
            } finally {
                if (target != null) {
                    target.fillInStackTrace();
                }
            }
        }

        @Override
        public StackTraceElement[] getStackTrace() {
            return target.getStackTrace();
        }

        @Override
        public void setStackTrace(StackTraceElement[] stackTrace) {
            target.setStackTrace(stackTrace);
        }
    }

    final class ResourceBundleELResolver extends jakarta.el.ResourceBundleELResolver implements ELShim.Retrofit {
        private final javax.el.ResourceBundleELResolver target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ResourceBundleELResolver(javax.el.ResourceBundleELResolver target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Object getValue(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getValue(context, bean, property);
        }

        @Override
        public void setValue(jakarta.el.ELContext context, Object bean, Object property, Object value) {
            target.setValue(context, bean, property, value);
        }

        @Override
        public boolean isReadOnly(jakarta.el.ELContext context, Object bean, Object property) {
            return target.isReadOnly(context, bean, property);
        }

        @Override
        public Class<?> getType(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getType(context, bean, property);
        }

        @Override
        public Class<?> getCommonPropertyType(jakarta.el.ELContext context, Object bean) {
            return target.getCommonPropertyType(context, bean);
        }

        @Override
        public <T> T convertToType(jakarta.el.ELContext context, Object object, Class<T> targetType) {
            return target.convertToType(context, object, targetType);
        }

        @Override
        public Object invoke(
            jakarta.el.ELContext context,
            Object bean,
            Object method,
            Class<?>[] parameterTypes,
            Object[] parameters
        ) {
            return target.invoke(context, bean, method, parameterTypes, parameters);
        }

        @Override
        public Iterator<FeatureDescriptor> getFeatureDescriptors(jakarta.el.ELContext context, Object bean) {
            return target.getFeatureDescriptors(context, bean);
        }
    }

    final class StandardELContext extends jakarta.el.StandardELContext implements ELShim.Retrofit {
        private final javax.el.StandardELContext target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        StandardELContext(javax.el.StandardELContext target) {
            super(ELManager.getExpressionFactory());
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void addELResolver(jakarta.el.ELResolver resolver) {
            target.addELResolver(ELShim.of(resolver));
        }

        @Override
        public void addEvaluationListener(jakarta.el.EvaluationListener listener) {
            target.addEvaluationListener(listener);
        }

        @Override
        public jakarta.el.ImportHandler getImportHandler() {
            return target.getImportHandler();
        }

        @Override
        public List<jakarta.el.EvaluationListener> getEvaluationListeners() {
            return target.getEvaluationListeners();
        }

        @Override
        public jakarta.el.ELResolver getELResolver() {
            return target.getELResolver();
        }

        @Override
        public jakarta.el.FunctionMapper getFunctionMapper() {
            return target.getFunctionMapper();
        }

        @Override
        public jakarta.el.VariableMapper getVariableMapper() {
            return target.getVariableMapper();
        }

        @Override
        public void setPropertyResolved(boolean resolved) {
            target.setPropertyResolved(resolved);
        }

        @Override
        public void setPropertyResolved(Object bean, Object property) {
            target.setPropertyResolved(bean, property);
        }

        @Override
        public boolean isPropertyResolved() {
            return target.isPropertyResolved();
        }

        @Override
        public void putContext(Class<?> key, Object contextObject) {
            target.putContext(key, contextObject);
        }

        @Override
        public Object getContext(Class<?> key) {
            return target.getContext(key);
        }

        @Override
        public Locale getLocale() {
            return target.getLocale();
        }

        @Override
        public void setLocale(Locale locale) {
            target.setLocale(locale);
        }

        @Override
        public void notifyBeforeEvaluation(String expression) {
            target.notifyBeforeEvaluation(expression);
        }

        @Override
        public void notifyAfterEvaluation(String expression) {
            target.notifyAfterEvaluation(expression);
        }

        @Override
        public void notifyPropertyResolved(Object bean, Object property) {
            target.notifyPropertyResolved(bean, property);
        }

        @Override
        public boolean isLambdaArgument(String argument) {
            return target.isLambdaArgument(argument);
        }

        @Override
        public Object getLambdaArgument(String argument) {
            return target.getLambdaArgument(argument);
        }

        @Override
        public void enterLambdaScope(Map<String, Object> arguments) {
            target.enterLambdaScope(arguments);
        }

        @Override
        public void exitLambdaScope() {
            target.exitLambdaScope();
        }

        @Override
        public <T> T convertToType(Object object, Class<T> targetType) {
            return target.convertToType(object, targetType);
        }

        @Override
        public int hashCode() {
            return target.hashCode();
        }

        @Override
        public boolean equals(Object other) {
            return target.equals(other);
        }

        @Override
        public String toString() {
            return target.toString();
        }
    }

    final class StaticFieldELResolver extends jakarta.el.StaticFieldELResolver implements ELShim.Retrofit {
        private final javax.el.StaticFieldELResolver target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        StaticFieldELResolver(javax.el.StaticFieldELResolver target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Object getValue(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getValue(context, bean, property);
        }

        @Override
        public void setValue(jakarta.el.ELContext context, Object bean, Object property, Object value) {
            target.setValue(context, bean, property, value);
        }

        @Override
        public boolean isReadOnly(jakarta.el.ELContext context, Object bean, Object property) {
            return target.isReadOnly(context, bean, property);
        }

        @Override
        public Class<?> getType(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getType(context, bean, property);
        }

        @Override
        public Class<?> getCommonPropertyType(jakarta.el.ELContext context, Object bean) {
            return target.getCommonPropertyType(context, bean);
        }

        @Override
        public <T> T convertToType(jakarta.el.ELContext context, Object object, Class<T> targetType) {
            return target.convertToType(context, object, targetType);
        }

        @Override
        public Object invoke(
            jakarta.el.ELContext context,
            Object bean,
            Object method,
            Class<?>[] parameterTypes,
            Object[] parameters
        ) {
            return target.invoke(context, bean, method, parameterTypes, parameters);
        }

        @Override
        public Iterator<FeatureDescriptor> getFeatureDescriptors(jakarta.el.ELContext context, Object bean) {
            return target.getFeatureDescriptors(context, bean);
        }
    }

    final class TypeConverter extends jakarta.el.TypeConverter implements ELShim.Retrofit {
        private final javax.el.TypeConverter target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        TypeConverter(javax.el.TypeConverter target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Object getValue(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getValue(context, bean, property);
        }

        @Override
        public void setValue(jakarta.el.ELContext context, Object bean, Object property, Object value) {
            target.setValue(context, bean, property, value);
        }

        @Override
        public boolean isReadOnly(jakarta.el.ELContext context, Object bean, Object property) {
            return target.isReadOnly(context, bean, property);
        }

        @Override
        public Class<?> getType(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getType(context, bean, property);
        }

        @Override
        public Class<?> getCommonPropertyType(jakarta.el.ELContext context, Object bean) {
            return target.getCommonPropertyType(context, bean);
        }

        @Override
        public <T> T convertToType(jakarta.el.ELContext context, Object object, Class<T> targetType) {
            return target.convertToType(context, object, targetType);
        }

        @Override
        public Object invoke(
            jakarta.el.ELContext context,
            Object bean,
            Object method,
            Class<?>[] parameterTypes,
            Object[] parameters
        ) {
            return target.invoke(context, bean, method, parameterTypes, parameters);
        }

        @Override
        public Iterator<FeatureDescriptor> getFeatureDescriptors(jakarta.el.ELContext context, Object bean) {
            return target.getFeatureDescriptors(context, bean);
        }
    }

    final class ValueExpression extends jakarta.el.ValueExpression implements ELShim.Retrofit {
        private static final long serialVersionUID = javax.shim.ShimSupport.getSerialVersionUID();

        private final javax.el.ValueExpression target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ValueExpression(javax.el.ValueExpression target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public jakarta.el.ValueReference getValueReference(jakarta.el.ELContext context) {
            return target.getValueReference(ELShim.of(context));
        }

        @Override
        public <T> T getValue(jakarta.el.ELContext context) {
            return target.getValue(ELShim.of(context));
        }

        @Override
        public void setValue(jakarta.el.ELContext context, Object value) {
            target.setValue(ELShim.of(context), value);
        }

        @Override
        public boolean isReadOnly(jakarta.el.ELContext context) {
            return target.isReadOnly(ELShim.of(context));
        }

        @Override
        public Class<?> getType(jakarta.el.ELContext context) {
            return target.getType(ELShim.of(context));
        }

        @Override
        public Class<?> getExpectedType() {
            return target.getExpectedType();
        }

        @Override
        public String getExpressionString() {
            return target.getExpressionString();
        }

        @Override
        public boolean equals(Object other) {
            return target.equals(other);
        }

        @Override
        public int hashCode() {
            return target.hashCode();
        }

        @Override
        public boolean isLiteralText() {
            return target.isLiteralText();
        }
    }
}
