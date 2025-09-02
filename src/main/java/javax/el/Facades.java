package javax.el;

import javax.shim.ShimSupport;
import java.beans.FeatureDescriptor;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This interface contains {@link jakarta.el}-to-{@link javax.el} facades used for wrapping Jakarta Expression Language
 *   objects into their Java Expression Language counterparts.
 *
 * @deprecated Use {@link jakarta.el} instead.
 */
@Deprecated(since = "jakarta.el")
@SuppressWarnings("all")
interface Facades {
    //==================================================================================================================
    // Classes
    //==================================================================================================================

    final class ArrayELResolver extends javax.el.ArrayELResolver {
        private final jakarta.el.ArrayELResolver target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ArrayELResolver(jakarta.el.ArrayELResolver target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Object getValue(javax.el.ELContext context, Object bean, Object property) {
            return target.getValue(context, bean, property);
        }

        @Override
        public Object getValue(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getValue(context, bean, property);
        }

        @Override
        public void setValue(javax.el.ELContext context, Object bean, Object property, Object value) {
            target.setValue(context, bean, property, value);
        }

        @Override
        public void setValue(jakarta.el.ELContext context, Object bean, Object property, Object value) {
            target.setValue(context, bean, property, value);
        }

        @Override
        public boolean isReadOnly(javax.el.ELContext context, Object bean, Object property) {
            return target.isReadOnly(context, bean, property);
        }

        @Override
        public boolean isReadOnly(jakarta.el.ELContext context, Object bean, Object property) {
            return target.isReadOnly(context, bean, property);
        }

        @Override
        public Class<?> getType(javax.el.ELContext context, Object bean, Object property) {
            return target.getType(context, bean, property);
        }

        @Override
        public Class<?> getType(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getType(context, bean, property);
        }

        @Override
        public Class<?> getCommonPropertyType(javax.el.ELContext context, Object bean) {
            return target.getCommonPropertyType(context, bean);
        }

        @Override
        public Class<?> getCommonPropertyType(jakarta.el.ELContext context, Object bean) {
            return target.getCommonPropertyType(context, bean);
        }

        @Override
        public <T> T convertToType(javax.el.ELContext context, Object object, Class<T> targetType) {
            return target.convertToType(context, object, targetType);
        }

        @Override
        public <T> T convertToType(jakarta.el.ELContext context, Object object, Class<T> targetType) {
            return target.convertToType(context, object, targetType);
        }

        @Override
        public Object invoke(
            javax.el.ELContext context,
            Object bean,
            Object method,
            Class<?>[] parameterTypes,
            Object[] parameters
        ) {
            return target.invoke(context, bean, method, parameterTypes, parameters);
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
        public Iterator<FeatureDescriptor> getFeatureDescriptors(javax.el.ELContext context, Object bean) {
            return target.getFeatureDescriptors(context, bean);
        }

        @Override
        public Iterator<FeatureDescriptor> getFeatureDescriptors(jakarta.el.ELContext context, Object bean) {
            return target.getFeatureDescriptors(context, bean);
        }
    }

    final class BeanNameELResolver extends javax.el.BeanNameELResolver {
        private final jakarta.el.BeanNameELResolver target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        BeanNameELResolver(jakarta.el.BeanNameELResolver target) {
            super(null);
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Object getValue(javax.el.ELContext context, Object bean, Object property) {
            return target.getValue(context, bean, property);
        }

        @Override
        public Object getValue(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getValue(context, bean, property);
        }

        @Override
        public void setValue(javax.el.ELContext context, Object bean, Object property, Object value) {
            target.setValue(context, bean, property, value);
        }

        @Override
        public void setValue(jakarta.el.ELContext context, Object bean, Object property, Object value) {
            target.setValue(context, bean, property, value);
        }

        @Override
        public boolean isReadOnly(javax.el.ELContext context, Object bean, Object property) {
            return target.isReadOnly(context, bean, property);
        }

        @Override
        public boolean isReadOnly(jakarta.el.ELContext context, Object bean, Object property) {
            return target.isReadOnly(context, bean, property);
        }

        @Override
        public Class<?> getType(javax.el.ELContext context, Object bean, Object property) {
            return target.getType(context, bean, property);
        }

        @Override
        public Class<?> getType(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getType(context, bean, property);
        }

        @Override
        public Class<?> getCommonPropertyType(javax.el.ELContext context, Object bean) {
            return target.getCommonPropertyType(context, bean);
        }

        @Override
        public Class<?> getCommonPropertyType(jakarta.el.ELContext context, Object bean) {
            return target.getCommonPropertyType(context, bean);
        }

        @Override
        public <T> T convertToType(javax.el.ELContext context, Object object, Class<T> targetType) {
            return target.convertToType(context, object, targetType);
        }

        @Override
        public <T> T convertToType(jakarta.el.ELContext context, Object object, Class<T> targetType) {
            return target.convertToType(context, object, targetType);
        }

        @Override
        public Object invoke(
            javax.el.ELContext context,
            Object bean,
            Object method,
            Class<?>[] parameterTypes,
            Object[] parameters
        ) {
            return target.invoke(context, bean, method, parameterTypes, parameters);
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
        public Iterator<FeatureDescriptor> getFeatureDescriptors(javax.el.ELContext context, Object bean) {
            return target.getFeatureDescriptors(context, bean);
        }

        @Override
        public Iterator<FeatureDescriptor> getFeatureDescriptors(jakarta.el.ELContext context, Object bean) {
            return target.getFeatureDescriptors(context, bean);
        }
    }

    final class BeanNameResolver extends javax.el.BeanNameResolver {
        private final jakarta.el.BeanNameResolver target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        BeanNameResolver(jakarta.el.BeanNameResolver target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public boolean isNameResolved(String beanName) {
            return target.isNameResolved(beanName);
        }

        @Override
        public Object getBean(String beanName) {
            return target.getBean(beanName);
        }

        @Override
        public void setBeanValue(String beanName, Object value) throws javax.el.PropertyNotWritableException {
            try {
                target.setBeanValue(beanName, value);
            } catch (jakarta.el.PropertyNotWritableException exception) {
                throw ELShim.of(exception);
            }
        }

        @Override
        public boolean isReadOnly(String beanName) {
            return target.isReadOnly(beanName);
        }

        @Override
        public boolean canCreateBean(String beanName) {
            return target.canCreateBean(beanName);
        }
    }

    final class CompositeELResolver extends javax.el.CompositeELResolver {
        private final jakarta.el.CompositeELResolver target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        CompositeELResolver(jakarta.el.CompositeELResolver target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void add(javax.el.ELResolver resolver) {
            target.add(resolver);
        }

        @Override
        public void add(jakarta.el.ELResolver resolver) {
            target.add(resolver);
        }

        @Override
        public Object getValue(javax.el.ELContext context, Object bean, Object property) {
            return target.getValue(context, bean, property);
        }

        @Override
        public Object getValue(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getValue(context, bean, property);
        }

        @Override
        public void setValue(javax.el.ELContext context, Object bean, Object property, Object value) {
            target.setValue(context, bean, property, value);
        }

        @Override
        public void setValue(jakarta.el.ELContext context, Object bean, Object property, Object value) {
            target.setValue(context, bean, property, value);
        }

        @Override
        public boolean isReadOnly(javax.el.ELContext context, Object bean, Object property) {
            return target.isReadOnly(context, bean, property);
        }

        @Override
        public boolean isReadOnly(jakarta.el.ELContext context, Object bean, Object property) {
            return target.isReadOnly(context, bean, property);
        }

        @Override
        public Class<?> getType(javax.el.ELContext context, Object bean, Object property) {
            return target.getType(context, bean, property);
        }

        @Override
        public Class<?> getType(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getType(context, bean, property);
        }

        @Override
        public Class<?> getCommonPropertyType(javax.el.ELContext context, Object bean) {
            return target.getCommonPropertyType(context, bean);
        }

        @Override
        public Class<?> getCommonPropertyType(jakarta.el.ELContext context, Object bean) {
            return target.getCommonPropertyType(context, bean);
        }

        @Override
        public <T> T convertToType(javax.el.ELContext context, Object object, Class<T> targetType) {
            return target.convertToType(context, object, targetType);
        }

        @Override
        public <T> T convertToType(jakarta.el.ELContext context, Object object, Class<T> targetType) {
            return target.convertToType(context, object, targetType);
        }

        @Override
        public Object invoke(
            javax.el.ELContext context,
            Object bean,
            Object method,
            Class<?>[] parameterTypes,
            Object[] parameters
        ) {
            return target.invoke(context, bean, method, parameterTypes, parameters);
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
        public Iterator<FeatureDescriptor> getFeatureDescriptors(javax.el.ELContext context, Object bean) {
            return target.getFeatureDescriptors(context, bean);
        }

        @Override
        public Iterator<FeatureDescriptor> getFeatureDescriptors(jakarta.el.ELContext context, Object bean) {
            return target.getFeatureDescriptors(context, bean);
        }
    }

    final class ELClass extends javax.el.ELClass {
        private final jakarta.el.ELClass target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ELClass(jakarta.el.ELClass target) {
            super(target.getKlass());
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Class<?> getKlass() {
            return target.getKlass();
        }
    }

    final class ELContext extends javax.el.ELContext {
        private final jakarta.el.ELContext target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ELContext(jakarta.el.ELContext target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.el.ImportHandler getImportHandler() {
            return ELShim.of(target.getImportHandler());
        }

        @Override
        public void addEvaluationListener(javax.el.EvaluationListener listener) {
            target.addEvaluationListener(listener);
        }

        @Override
        public void addEvaluationListener(jakarta.el.EvaluationListener listener) {
            target.addEvaluationListener(listener);
        }

        @Override
        public List getEvaluationListeners() {
            return ELShim
                .<javax.el.EvaluationListener>of(target.getEvaluationListeners())
                .collect(Collectors.toList());
        }

        @Override
        public javax.el.ELResolver getELResolver() {
            return ELShim.of(target.getELResolver());
        }

        @Override
        public javax.el.FunctionMapper getFunctionMapper() {
            return ELShim.of(target.getFunctionMapper());
        }

        @Override
        public javax.el.VariableMapper getVariableMapper() {
            return ELShim.of(target.getVariableMapper());
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
    }

    final class ELContextEvent extends javax.el.ELContextEvent {
        private final jakarta.el.ELContextEvent target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ELContextEvent(jakarta.el.ELContextEvent target) {
            super(ELShim.of(target.getELContext()));
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.el.ELContext getELContext() {
            return ELShim.of(target.getELContext());
        }
    }

    final class ELContextListener extends ELShim.Facade<jakarta.el.ELContextListener> implements javax.el.ELContextListener {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ELContextListener(jakarta.el.ELContextListener target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void contextCreated(javax.el.ELContextEvent event) {
            target.contextCreated(event);
        }

        @Override
        public void contextCreated(jakarta.el.ELContextEvent event) {
            target.contextCreated(event);
        }
    }

    final class ELException extends javax.el.ELException {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();
        
        private final jakarta.el.ELException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ELException(jakarta.el.ELException target) {
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

    final class ELManager extends javax.el.ELManager {
        private final jakarta.el.ELManager target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ELManager(jakarta.el.ELManager target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.el.ELContext setELContext(javax.el.ELContext context) {
            return ELShim.of(target.setELContext(context));
        }

        @Override
        public javax.el.ELContext setELContext(jakarta.el.ELContext context) {
            return ELShim.of(target.setELContext(context));
        }

        @Override
        public void addBeanNameResolver(javax.el.BeanNameResolver beanNameResolver) {
            target.addBeanNameResolver(beanNameResolver);
        }

        @Override
        public void addBeanNameResolver(jakarta.el.BeanNameResolver beanNameResolver) {
            target.addBeanNameResolver(beanNameResolver);
        }

        @Override
        public void addELResolver(javax.el.ELResolver resolver) {
            target.addELResolver(resolver);
        }

        @Override
        public void addELResolver(jakarta.el.ELResolver resolver) {
            target.addELResolver(resolver);
        }

        @Override
        public void setVariable(String variable, javax.el.ValueExpression expression) {
            target.setVariable(variable, new Retrofits.ValueExpression(expression));
        }

        @Override
        public void setVariable(String variable, jakarta.el.ValueExpression expression) {
            target.setVariable(variable, expression);
        }

        @Override
        public void addEvaluationListener(javax.el.EvaluationListener listener) {
            target.addEvaluationListener(listener);
        }

        @Override
        public void addEvaluationListener(jakarta.el.EvaluationListener listener) {
            target.addEvaluationListener(listener);
        }

        @Override
        public jakarta.el.StandardELContext getELContext() {
            return target.getELContext();
        }

        @Override
        public void mapFunction(String prefix, String function, Method method) {
            target.mapFunction(prefix, function, method);
        }

        @Override
        public void importStatic(String staticMemberName) throws javax.el.ELException {
            try {
                target.importStatic(staticMemberName);
            } catch (jakarta.el.ELException exception) {
                throw ELShim.of(exception);
            }
        }

        @Override
        public void importClass(String className) throws javax.el.ELException {
            try {
                target.importClass(className);
            } catch (jakarta.el.ELException exception) {
                throw ELShim.of(exception);
            }
        }

        @Override
        public void importPackage(String packageName) {
            target.importPackage(packageName);
        }

        @Override
        public Object defineBean(String name, Object bean) {
            return target.defineBean(name, bean);
        }
    }

    final class ELProcessor extends javax.el.ELProcessor {
        private final jakarta.el.ELProcessor target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ELProcessor(jakarta.el.ELProcessor target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.el.ELManager getELManager() {
            return ELShim.of(target.getELManager());
        }

        @Override
        public <T> T eval(String expression) {
            return target.eval(expression);
        }

        @Override
        public <T> T getValue(String expression, Class<T> expectedType) {
            return target.getValue(expression, expectedType);
        }

        @Override
        public void setValue(String expression, Object value) {
            target.setValue(expression, value);
        }

        @Override
        public void setVariable(String var, String expression) {
            target.setVariable(var, expression);
        }

        @Override
        public void defineFunction(
            String prefix,
            String function,
            String className,
            String method
        ) throws ClassNotFoundException, NoSuchMethodException {
            target.defineFunction(prefix, function, className, method);
        }

        @Override
        public void defineFunction(String prefix, String function, Method method) throws NoSuchMethodException {
            target.defineFunction(prefix, function, method);
        }

        @Override
        public void defineBean(String name, Object bean) {
            target.defineBean(name, bean);
        }
    }

    final class ELResolver extends javax.el.ELResolver {
        private final jakarta.el.ELResolver target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ELResolver(jakarta.el.ELResolver target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Object getValue(javax.el.ELContext context, Object bean, Object property) {
            return target.getValue(context, bean, property);
        }

        @Override
        public Object getValue(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getValue(context, bean, property);
        }

        @Override
        public void setValue(javax.el.ELContext context, Object bean, Object property, Object value) {
            target.setValue(context, bean, property, value);
        }

        @Override
        public void setValue(jakarta.el.ELContext context, Object bean, Object property, Object value) {
            target.setValue(context, bean, property, value);
        }

        @Override
        public boolean isReadOnly(javax.el.ELContext context, Object bean, Object property) {
            return target.isReadOnly(context, bean, property);
        }

        @Override
        public boolean isReadOnly(jakarta.el.ELContext context, Object bean, Object property) {
            return target.isReadOnly(context, bean, property);
        }

        @Override
        public Class<?> getType(javax.el.ELContext context, Object bean, Object property) {
            return target.getType(context, bean, property);
        }

        @Override
        public Class<?> getType(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getType(context, bean, property);
        }

        @Override
        public Class<?> getCommonPropertyType(javax.el.ELContext context, Object bean) {
            return target.getCommonPropertyType(context, bean);
        }

        @Override
        public Class<?> getCommonPropertyType(jakarta.el.ELContext context, Object bean) {
            return target.getCommonPropertyType(context, bean);
        }

        @Override
        public <T> T convertToType(javax.el.ELContext context, Object object, Class<T> targetType) {
            return target.convertToType(context, object, targetType);
        }

        @Override
        public <T> T convertToType(jakarta.el.ELContext context, Object object, Class<T> targetType) {
            return target.convertToType(context, object, targetType);
        }

        @Override
        public Object invoke(
            javax.el.ELContext context,
            Object bean,
            Object method,
            Class<?>[] parameterTypes,
            Object[] parameters
        ) {
            return target.invoke(context, bean, method, parameterTypes, parameters);
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
        public Iterator<FeatureDescriptor> getFeatureDescriptors(javax.el.ELContext context, Object bean) {
            return target.getFeatureDescriptors(context, bean);
        }

        @Override
        public Iterator<FeatureDescriptor> getFeatureDescriptors(jakarta.el.ELContext context, Object bean) {
            return target.getFeatureDescriptors(context, bean);
        }
    }

    final class Expression extends javax.el.Expression {
        private final jakarta.el.Expression target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Expression(jakarta.el.Expression target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

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

    final class ExpressionFactory extends javax.el.ExpressionFactory {
        private final jakarta.el.ExpressionFactory target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ExpressionFactory(jakarta.el.ExpressionFactory target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public jakarta.el.ValueExpression createValueExpression(Object instance, Class<?> expectedType) {
            return target.createValueExpression(instance, expectedType);
        }

        @Override
        public javax.el.ValueExpression createValueExpression(
            javax.el.ELContext context,
            String expression,
            Class<?> expectedType
        ) {
            return ELShim.of(target.createValueExpression(context, expression, expectedType));
        }

        @Override
        public jakarta.el.ValueExpression createValueExpression(
            jakarta.el.ELContext context,
            String expression,
            Class<?> expectedType
        ) {
            return target.createValueExpression(context, expression, expectedType);
        }

        @Override
        public javax.el.MethodExpression createMethodExpression(
            javax.el.ELContext context,
            String expression,
            Class<?> expectedReturnType,
            Class<?>[] expectedParameterTypes
        ) {
            return ELShim
                .of(target.createMethodExpression(context, expression, expectedReturnType, expectedParameterTypes));
        }

        @Override
        public jakarta.el.MethodExpression createMethodExpression(
            jakarta.el.ELContext context,
            String expression,
            Class<?> expectedReturnType,
            Class<?>[] expectedParameterTypes
        ) {
            return target.createMethodExpression(context, expression, expectedReturnType, expectedParameterTypes);
        }

        @Override
        public javax.el.ELResolver getStreamELResolver() {
            return ELShim.of(target.getStreamELResolver());
        }

        @Override
        public Map<String, Method> getInitFunctionMap() {
            return target.getInitFunctionMap();
        }

        @Override
        public <T> T coerceToType(Object object, Class<T> targetType) {
            return target.coerceToType(object, targetType);
        }
    }

    final class EvaluationListener extends javax.el.EvaluationListener {
        private final jakarta.el.EvaluationListener target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        EvaluationListener(jakarta.el.EvaluationListener target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void beforeEvaluation(javax.el.ELContext context, String expression) {
            target.beforeEvaluation(context, expression);
        }

        @Override
        public void beforeEvaluation(jakarta.el.ELContext context, String expression) {
            target.beforeEvaluation(context, expression);
        }

        @Override
        public void afterEvaluation(javax.el.ELContext context, String expression) {
            target.afterEvaluation(context, expression);
        }

        @Override
        public void afterEvaluation(jakarta.el.ELContext context, String expression) {
            target.afterEvaluation(context, expression);
        }

        @Override
        public void propertyResolved(javax.el.ELContext context, Object bean, Object property) {
            target.propertyResolved(context, bean, property);
        }

        @Override
        public void propertyResolved(jakarta.el.ELContext context, Object bean, Object property) {
            target.propertyResolved(context, bean, property);
        }
    }

    final class FunctionMapper extends javax.el.FunctionMapper {
        private final jakarta.el.FunctionMapper target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        FunctionMapper(jakarta.el.FunctionMapper target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Method resolveFunction(String prefix, String localName) {
            return target.resolveFunction(prefix, localName);
        }

        @Override
        public void mapFunction(String prefix, String localName, Method method) {
            target.mapFunction(prefix, localName, method);
        }
    }

    final class ImportHandler extends javax.el.ImportHandler {
        private final jakarta.el.ImportHandler target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ImportHandler(jakarta.el.ImportHandler target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void importStatic(String name) throws javax.el.ELException {
            try {
                target.importStatic(name);
            } catch (jakarta.el.ELException exception) {
                throw ELShim.of(exception);
            }
        }

        @Override
        public void importClass(String name) throws javax.el.ELException {
            try {
                target.importClass(name);
            } catch (jakarta.el.ELException exception) {
                throw ELShim.of(exception);
            }
        }

        @Override
        public void importPackage(String packageName) {
            target.importPackage(packageName);
        }

        @Override
        public Class<?> resolveClass(String name) {
            return target.resolveClass(name);
        }

        @Override
        public Class<?> resolveStatic(String name) {
            return target.resolveStatic(name);
        }
    }

    final class LambdaExpression extends javax.el.LambdaExpression {
        private final jakarta.el.LambdaExpression target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        LambdaExpression(jakarta.el.LambdaExpression target) {
            super(null, null);
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void setELContext(javax.el.ELContext context) {
            target.setELContext(context);
        }

        @Override
        public void setELContext(jakarta.el.ELContext context) {
            target.setELContext(context);
        }

        @Override
        public Object invoke(javax.el.ELContext context, Object... arguments) throws javax.el.ELException {
            try {
                return target.invoke(context, arguments);
            } catch (jakarta.el.ELException exception) {
                throw ELShim.of(exception);
            }
        }

        @Override
        public Object invoke(jakarta.el.ELContext context, Object... arguments) throws javax.el.ELException {
            try {
                return target.invoke(context, arguments);
            } catch (jakarta.el.ELException exception) {
                throw ELShim.of(exception);
            }
        }

        @Override
        public Object invoke(Object... arguments) throws javax.el.ELException {
            try {
                return target.invoke(arguments);
            } catch (jakarta.el.ELException exception) {
                throw ELShim.of(exception);
            }
        }
    }

    final class ListELResolver extends javax.el.ListELResolver {
        private final jakarta.el.ListELResolver target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ListELResolver(jakarta.el.ListELResolver target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Object getValue(javax.el.ELContext context, Object bean, Object property) {
            return target.getValue(context, bean, property);
        }

        @Override
        public Object getValue(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getValue(context, bean, property);
        }

        @Override
        public void setValue(javax.el.ELContext context, Object bean, Object property, Object value) {
            target.setValue(context, bean, property, value);
        }

        @Override
        public void setValue(jakarta.el.ELContext context, Object bean, Object property, Object value) {
            target.setValue(context, bean, property, value);
        }

        @Override
        public boolean isReadOnly(javax.el.ELContext context, Object bean, Object property) {
            return target.isReadOnly(context, bean, property);
        }

        @Override
        public boolean isReadOnly(jakarta.el.ELContext context, Object bean, Object property) {
            return target.isReadOnly(context, bean, property);
        }

        @Override
        public Class<?> getType(javax.el.ELContext context, Object bean, Object property) {
            return target.getType(context, bean, property);
        }

        @Override
        public Class<?> getType(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getType(context, bean, property);
        }

        @Override
        public Class<?> getCommonPropertyType(javax.el.ELContext context, Object bean) {
            return target.getCommonPropertyType(context, bean);
        }

        @Override
        public Class<?> getCommonPropertyType(jakarta.el.ELContext context, Object bean) {
            return target.getCommonPropertyType(context, bean);
        }

        @Override
        public <T> T convertToType(javax.el.ELContext context, Object object, Class<T> targetType) {
            return target.convertToType(context, object, targetType);
        }

        @Override
        public <T> T convertToType(jakarta.el.ELContext context, Object object, Class<T> targetType) {
            return target.convertToType(context, object, targetType);
        }

        @Override
        public Object invoke(
            javax.el.ELContext context,
            Object bean,
            Object method,
            Class<?>[] parameterTypes,
            Object[] parameters
        ) {
            return target.invoke(context, bean, method, parameterTypes, parameters);
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
        public Iterator<FeatureDescriptor> getFeatureDescriptors(javax.el.ELContext context, Object bean) {
            return target.getFeatureDescriptors(context, bean);
        }

        @Override
        public Iterator<FeatureDescriptor> getFeatureDescriptors(jakarta.el.ELContext context, Object bean) {
            return target.getFeatureDescriptors(context, bean);
        }
    }

    final class MapELResolver extends javax.el.MapELResolver {
        private final jakarta.el.MapELResolver target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        MapELResolver(jakarta.el.MapELResolver target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Object getValue(javax.el.ELContext context, Object bean, Object property) {
            return target.getValue(context, bean, property);
        }

        @Override
        public Object getValue(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getValue(context, bean, property);
        }

        @Override
        public void setValue(javax.el.ELContext context, Object bean, Object property, Object value) {
            target.setValue(context, bean, property, value);
        }

        @Override
        public void setValue(jakarta.el.ELContext context, Object bean, Object property, Object value) {
            target.setValue(context, bean, property, value);
        }

        @Override
        public boolean isReadOnly(javax.el.ELContext context, Object bean, Object property) {
            return target.isReadOnly(context, bean, property);
        }

        @Override
        public boolean isReadOnly(jakarta.el.ELContext context, Object bean, Object property) {
            return target.isReadOnly(context, bean, property);
        }

        @Override
        public Class<?> getType(javax.el.ELContext context, Object bean, Object property) {
            return target.getType(context, bean, property);
        }

        @Override
        public Class<?> getType(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getType(context, bean, property);
        }

        @Override
        public Class<?> getCommonPropertyType(javax.el.ELContext context, Object bean) {
            return target.getCommonPropertyType(context, bean);
        }

        @Override
        public Class<?> getCommonPropertyType(jakarta.el.ELContext context, Object bean) {
            return target.getCommonPropertyType(context, bean);
        }

        @Override
        public <T> T convertToType(javax.el.ELContext context, Object object, Class<T> targetType) {
            return target.convertToType(context, object, targetType);
        }

        @Override
        public <T> T convertToType(jakarta.el.ELContext context, Object object, Class<T> targetType) {
            return target.convertToType(context, object, targetType);
        }

        @Override
        public Object invoke(
            javax.el.ELContext context,
            Object bean,
            Object method,
            Class<?>[] parameterTypes,
            Object[] parameters
        ) {
            return target.invoke(context, bean, method, parameterTypes, parameters);
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
        public Iterator<FeatureDescriptor> getFeatureDescriptors(javax.el.ELContext context, Object bean) {
            return target.getFeatureDescriptors(context, bean);
        }

        @Override
        public Iterator<FeatureDescriptor> getFeatureDescriptors(jakarta.el.ELContext context, Object bean) {
            return target.getFeatureDescriptors(context, bean);
        }
    }

    final class MethodExpression extends javax.el.MethodExpression {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        private final jakarta.el.MethodExpression target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        MethodExpression(jakarta.el.MethodExpression target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.el.MethodInfo getMethodInfo(javax.el.ELContext context) {
            return ELShim.of(target.getMethodInfo(context));
        }

        @Override
        public Object invoke(javax.el.ELContext context, Object[] parameters) {
            return target.invoke(context, parameters);
        }

        @Override
        public boolean isParametersProvided() {
            return target.isParametersProvided();
        }

        @Override
        public javax.el.MethodReference getMethodReference(javax.el.ELContext context) {
            return ELShim.of(target.getMethodReference(context));
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

    final class MethodInfo extends javax.el.MethodInfo {
        private final jakarta.el.MethodInfo target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        MethodInfo(jakarta.el.MethodInfo target) {
            super(target.getName(), target.getReturnType(), target.getParamTypes());
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getName() {
            return target.getName();
        }

        @Override
        public Class<?> getReturnType() {
            return target.getReturnType();
        }

        @Override
        public Class<?>[] getParamTypes() {
            return target.getParamTypes();
        }

        @Override
        public int hashCode() {
            return target.hashCode();
        }

        @Override
        public boolean equals(Object other) {
            return target.equals(other);
        }
    }

    final class MethodNotFoundException extends javax.el.MethodNotFoundException {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        private final jakarta.el.MethodNotFoundException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        MethodNotFoundException(jakarta.el.MethodNotFoundException target) {
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

    final class MethodReference extends javax.el.MethodReference {
        private final jakarta.el.MethodReference target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        MethodReference(jakarta.el.MethodReference target) {
            super(
                target.getBase(),
                ELShim.of(target.getMethodInfo()),
                target.getAnnotations(),
                target.getEvaluatedParameters()
            );
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.el.MethodInfo getMethodInfo() {
            return ELShim.of(target.getMethodInfo());
        }

        @Override
        public Object getBase() {
            return target.getBase();
        }

        @Override
        public Annotation[] getAnnotations() {
            return target.getAnnotations();
        }

        @Override
        public Object[] getEvaluatedParameters() {
            return target.getEvaluatedParameters();
        }

        @Override
        public int hashCode() {
            return target.hashCode();
        }

        @Override
        public boolean equals(Object other) {
            return target.equals(other);
        }
    }

    final class PropertyNotFoundException extends javax.el.PropertyNotFoundException {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        private final jakarta.el.PropertyNotFoundException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        PropertyNotFoundException(jakarta.el.PropertyNotFoundException target) {
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

    final class PropertyNotWritableException extends javax.el.PropertyNotWritableException {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        private final jakarta.el.PropertyNotWritableException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        PropertyNotWritableException(jakarta.el.PropertyNotWritableException target) {
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

    final class ResourceBundleELResolver extends javax.el.ResourceBundleELResolver {
        private final jakarta.el.ResourceBundleELResolver target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ResourceBundleELResolver(jakarta.el.ResourceBundleELResolver target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Object getValue(javax.el.ELContext context, Object bean, Object property) {
            return target.getValue(context, bean, property);
        }

        @Override
        public Object getValue(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getValue(context, bean, property);
        }

        @Override
        public void setValue(javax.el.ELContext context, Object bean, Object property, Object value) {
            target.setValue(context, bean, property, value);
        }

        @Override
        public void setValue(jakarta.el.ELContext context, Object bean, Object property, Object value) {
            target.setValue(context, bean, property, value);
        }

        @Override
        public boolean isReadOnly(javax.el.ELContext context, Object bean, Object property) {
            return target.isReadOnly(context, bean, property);
        }

        @Override
        public boolean isReadOnly(jakarta.el.ELContext context, Object bean, Object property) {
            return target.isReadOnly(context, bean, property);
        }

        @Override
        public Class<?> getType(javax.el.ELContext context, Object bean, Object property) {
            return target.getType(context, bean, property);
        }

        @Override
        public Class<?> getType(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getType(context, bean, property);
        }

        @Override
        public Class<?> getCommonPropertyType(javax.el.ELContext context, Object bean) {
            return target.getCommonPropertyType(context, bean);
        }

        @Override
        public Class<?> getCommonPropertyType(jakarta.el.ELContext context, Object bean) {
            return target.getCommonPropertyType(context, bean);
        }

        @Override
        public <T> T convertToType(javax.el.ELContext context, Object object, Class<T> targetType) {
            return target.convertToType(context, object, targetType);
        }

        @Override
        public <T> T convertToType(jakarta.el.ELContext context, Object object, Class<T> targetType) {
            return target.convertToType(context, object, targetType);
        }

        @Override
        public Object invoke(
            javax.el.ELContext context,
            Object bean,
            Object method,
            Class<?>[] parameterTypes,
            Object[] parameters
        ) {
            return target.invoke(context, bean, method, parameterTypes, parameters);
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
        public Iterator<FeatureDescriptor> getFeatureDescriptors(javax.el.ELContext context, Object bean) {
            return target.getFeatureDescriptors(context, bean);
        }

        @Override
        public Iterator<FeatureDescriptor> getFeatureDescriptors(jakarta.el.ELContext context, Object bean) {
            return target.getFeatureDescriptors(context, bean);
        }
    }

    final class StandardELContext extends javax.el.StandardELContext {
        private final jakarta.el.StandardELContext target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        StandardELContext(jakarta.el.StandardELContext target) {
            super(new ELContext(target));
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.el.ImportHandler getImportHandler() {
            return ELShim.of(target.getImportHandler());
        }

        @Override
        public void addEvaluationListener(javax.el.EvaluationListener listener) {
            target.addEvaluationListener(listener);
        }

        @Override
        public void addEvaluationListener(jakarta.el.EvaluationListener listener) {
            target.addEvaluationListener(listener);
        }

        @Override
        public List getEvaluationListeners() {
            return ELShim
                .<javax.el.EvaluationListener>of(target.getEvaluationListeners())
                .collect(Collectors.toList());
        }

        @Override
        public javax.el.ELResolver getELResolver() {
            return ELShim.of(target.getELResolver());
        }

        @Override
        public void addELResolver(javax.el.ELResolver resolver) {
            target.addELResolver(resolver);
        }

        @Override
        public void addELResolver(jakarta.el.ELResolver resolver) {
            target.addELResolver(resolver);
        }

        @Override
        public javax.el.FunctionMapper getFunctionMapper() {
            return ELShim.of(target.getFunctionMapper());
        }

        @Override
        public javax.el.VariableMapper getVariableMapper() {
            return ELShim.of(target.getVariableMapper());
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
    }

    final class StaticFieldELResolver extends javax.el.StaticFieldELResolver {
        private final jakarta.el.StaticFieldELResolver target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        StaticFieldELResolver(jakarta.el.StaticFieldELResolver target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Object getValue(javax.el.ELContext context, Object bean, Object property) {
            return target.getValue(context, bean, property);
        }

        @Override
        public Object getValue(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getValue(context, bean, property);
        }

        @Override
        public void setValue(javax.el.ELContext context, Object bean, Object property, Object value) {
            target.setValue(context, bean, property, value);
        }

        @Override
        public void setValue(jakarta.el.ELContext context, Object bean, Object property, Object value) {
            target.setValue(context, bean, property, value);
        }

        @Override
        public boolean isReadOnly(javax.el.ELContext context, Object bean, Object property) {
            return target.isReadOnly(context, bean, property);
        }

        @Override
        public boolean isReadOnly(jakarta.el.ELContext context, Object bean, Object property) {
            return target.isReadOnly(context, bean, property);
        }

        @Override
        public Class<?> getType(javax.el.ELContext context, Object bean, Object property) {
            return target.getType(context, bean, property);
        }

        @Override
        public Class<?> getType(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getType(context, bean, property);
        }

        @Override
        public Class<?> getCommonPropertyType(javax.el.ELContext context, Object bean) {
            return target.getCommonPropertyType(context, bean);
        }

        @Override
        public Class<?> getCommonPropertyType(jakarta.el.ELContext context, Object bean) {
            return target.getCommonPropertyType(context, bean);
        }

        @Override
        public <T> T convertToType(javax.el.ELContext context, Object object, Class<T> targetType) {
            return target.convertToType(context, object, targetType);
        }

        @Override
        public <T> T convertToType(jakarta.el.ELContext context, Object object, Class<T> targetType) {
            return target.convertToType(context, object, targetType);
        }

        @Override
        public Object invoke(
            javax.el.ELContext context,
            Object bean,
            Object method,
            Class<?>[] parameterTypes,
            Object[] parameters
        ) {
            return target.invoke(context, bean, method, parameterTypes, parameters);
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
        public Iterator<FeatureDescriptor> getFeatureDescriptors(javax.el.ELContext context, Object bean) {
            return target.getFeatureDescriptors(context, bean);
        }

        @Override
        public Iterator<FeatureDescriptor> getFeatureDescriptors(jakarta.el.ELContext context, Object bean) {
            return target.getFeatureDescriptors(context, bean);
        }
    }

    final class TypeConverter extends javax.el.TypeConverter {
        private final jakarta.el.TypeConverter target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        TypeConverter(jakarta.el.TypeConverter target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Object getValue(javax.el.ELContext context, Object bean, Object property) {
            return target.getValue(context, bean, property);
        }

        @Override
        public Object getValue(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getValue(context, bean, property);
        }

        @Override
        public void setValue(javax.el.ELContext context, Object bean, Object property, Object value) {
            target.setValue(context, bean, property, value);
        }

        @Override
        public void setValue(jakarta.el.ELContext context, Object bean, Object property, Object value) {
            target.setValue(context, bean, property, value);
        }

        @Override
        public boolean isReadOnly(javax.el.ELContext context, Object bean, Object property) {
            return target.isReadOnly(context, bean, property);
        }

        @Override
        public boolean isReadOnly(jakarta.el.ELContext context, Object bean, Object property) {
            return target.isReadOnly(context, bean, property);
        }

        @Override
        public Class<?> getType(javax.el.ELContext context, Object bean, Object property) {
            return target.getType(context, bean, property);
        }

        @Override
        public Class<?> getType(jakarta.el.ELContext context, Object bean, Object property) {
            return target.getType(context, bean, property);
        }

        @Override
        public Class<?> getCommonPropertyType(javax.el.ELContext context, Object bean) {
            return target.getCommonPropertyType(context, bean);
        }

        @Override
        public Class<?> getCommonPropertyType(jakarta.el.ELContext context, Object bean) {
            return target.getCommonPropertyType(context, bean);
        }

        @Override
        public <T> T convertToType(javax.el.ELContext context, Object object, Class<T> targetType) {
            return target.convertToType(context, object, targetType);
        }

        @Override
        public <T> T convertToType(jakarta.el.ELContext context, Object object, Class<T> targetType) {
            return target.convertToType(context, object, targetType);
        }

        @Override
        public Object invoke(
            javax.el.ELContext context,
            Object bean,
            Object method,
            Class<?>[] parameterTypes,
            Object[] parameters
        ) {
            return target.invoke(context, bean, method, parameterTypes, parameters);
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
        public Iterator<FeatureDescriptor> getFeatureDescriptors(javax.el.ELContext context, Object bean) {
            return target.getFeatureDescriptors(context, bean);
        }

        @Override
        public Iterator<FeatureDescriptor> getFeatureDescriptors(jakarta.el.ELContext context, Object bean) {
            return target.getFeatureDescriptors(context, bean);
        }
    }

    final class ValueExpression extends javax.el.ValueExpression {
        private final jakarta.el.ValueExpression target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ValueExpression(jakarta.el.ValueExpression target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public <T> T getValue(javax.el.ELContext context) {
            return target.getValue(context);
        }

        @Override
        public void setValue(javax.el.ELContext context, Object value) {
            target.setValue(context, value);
        }

        @Override
        public boolean isReadOnly(javax.el.ELContext context) {
            return target.isReadOnly(context);
        }

        @Override
        public Class<?> getType(javax.el.ELContext context) {
            return target.getType(context);
        }

        @Override
        public Class<?> getExpectedType() {
            return target.getExpectedType();
        }

        @Override
        public javax.el.ValueReference getValueReference(javax.el.ELContext context) {
            return ELShim.of(target.getValueReference(context));
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

    final class ValueReference extends javax.el.ValueReference {
        private final jakarta.el.ValueReference target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ValueReference(jakarta.el.ValueReference target) {
            super(target.getBase(), target.getProperty());
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Object getBase() {
            return target.getBase();
        }

        @Override
        public Object getProperty() {
            return target.getProperty();
        }
    }

    final class VariableMapper extends javax.el.VariableMapper {
        private final jakarta.el.VariableMapper target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        VariableMapper(jakarta.el.VariableMapper target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.el.ValueExpression setVariable(String variable, javax.el.ValueExpression expression) {
            return ELShim.of(target.setVariable(variable, new Retrofits.ValueExpression(expression)));
        }

        @Override
        public jakarta.el.ValueExpression setVariable(String variable, jakarta.el.ValueExpression expression) {
            return target.setVariable(variable, expression);
        }

        @Override
        public jakarta.el.ValueExpression resolveVariable(String variable) {
            return target.resolveVariable(variable);
        }
    }
}
