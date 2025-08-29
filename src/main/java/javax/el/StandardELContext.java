package javax.el;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @deprecated Use {@link jakarta.el.StandardELContext} instead.
 * @apiNote This class cannot extend {@link jakarta.el.StandardELContext} due to class hierarchy divergence.
 */
@Deprecated(since = "jakarta.el.StandardELContext")
public abstract class StandardELContext extends ELContext {
    private final jakarta.el.StandardELContext target;

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.el.StandardELContext#StandardELContext(jakarta.el.ExpressionFactory)
     */
    public StandardELContext(ExpressionFactory expressionFactory) {
        target = new jakarta.el.StandardELContext(expressionFactory);
    }

    /**
     * @see jakarta.el.StandardELContext#StandardELContext(jakarta.el.ELContext)
     */
    public StandardELContext(ELContext context) {
        target = new jakarta.el.StandardELContext(context);
    }

    //==================================================================================================================
    // Delegated Methods
    //==================================================================================================================

    /**
     * @see jakarta.el.StandardELContext#addELResolver(jakarta.el.ELResolver)
     */
    public void addELResolver(ELResolver resolver) {
        target.addELResolver(resolver);
    }

    /**
     * @see jakarta.el.StandardELContext#addELResolver(jakarta.el.ELResolver)
     */
    public void addELResolver(jakarta.el.ELResolver resolver) {
        addELResolver(ELShim.of(resolver));
    }

    @Override
    public void addEvaluationListener(EvaluationListener listener) {
        target.addEvaluationListener(listener);
    }

    @Override
    public void addEvaluationListener(jakarta.el.EvaluationListener listener) {
        addEvaluationListener(ELShim.of(listener));
    }

    @Override
    public ImportHandler getImportHandler() {
        return ELShim.of(target.getImportHandler());
    }

    @Override
    @SuppressWarnings("rawtypes")
    public List getEvaluationListeners() {
        return ELShim
            .<javax.el.EvaluationListener>of(target.getEvaluationListeners())
            .collect(Collectors.toList());
    }

    @Override
    public ELResolver getELResolver() {
        return ELShim.of(target.getELResolver());
    }

    @Override
    public FunctionMapper getFunctionMapper() {
        return ELShim.of(target.getFunctionMapper());
    }

    @Override
    public VariableMapper getVariableMapper() {
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

    @Override
    public int hashCode() {
        return target.hashCode();
    }

    @Override
    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(Object other) {
        return target.equals(other);
    }

    @Override
    public String toString() {
        return target.toString();
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ELShim.initialize();
    }
}
