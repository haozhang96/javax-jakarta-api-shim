package javax.el;

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
            return null;
        }

        @Override
        public Object invoke(jakarta.el.ELContext context, Object[] parameters) {
            return null;
        }

        @Override
        public boolean isParametersProvided() {
            return super.isParametersProvided();
        }

        @Override
        public jakarta.el.MethodReference getMethodReference(jakarta.el.ELContext context) {
            return super.getMethodReference(context);
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

    final class StandardELContext extends jakarta.el.StandardELContext implements ELShim.Retrofit {
        private final javax.el.StandardELContext target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        StandardELContext(javax.el.StandardELContext target) {
            super(target);
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
