package javax.el;

import java.util.Properties;

/**
 * @deprecated Use {@link jakarta.el.ExpressionFactory} instead.
 */
@Deprecated(since = "jakarta.el.ExpressionFactory")
public abstract class ExpressionFactory extends jakarta.el.ExpressionFactory implements ELShim {
    //==================================================================================================================
    // Factory Methods
    //==================================================================================================================

    /**
     * @see jakarta.el.ExpressionFactory#newInstance()
     */
    public static ExpressionFactory newInstance() {
        return ELShim.of(jakarta.el.ExpressionFactory.newInstance());
    }

    /**
     * @see jakarta.el.ExpressionFactory#newInstance(Properties)
     */
    public static ExpressionFactory newInstance(Properties properties) {
        return ELShim.of(jakarta.el.ExpressionFactory.newInstance(properties));
    }

    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see jakarta.el.ExpressionFactory#createValueExpression(jakarta.el.ELContext, String, Class)
     */
    public abstract ValueExpression createValueExpression(ELContext context, String expression, Class<?> expectedType);

    /**
     * @see jakarta.el.ExpressionFactory#createMethodExpression(jakarta.el.ELContext, String, Class, Class[])
     */
    public abstract MethodExpression createMethodExpression(
        ELContext context,
        String expression,
        Class<?> expectedReturnType,
        Class<?>[] expectedParameterTypes
    );

    //==================================================================================================================
    // ExpressionFactory Implementation Methods
    //==================================================================================================================

    @Override
    public jakarta.el.ValueExpression createValueExpression(
        jakarta.el.ELContext context,
        String expression,
        Class<?> expectedType
    ) {
        return new Retrofits.ValueExpression(createValueExpression(ELShim.of(context), expression, expectedType));
    }

    @Override
    public abstract jakarta.el.ValueExpression createValueExpression(Object instance, Class<?> expectedType);

    @Override
    public jakarta.el.MethodExpression createMethodExpression(
        jakarta.el.ELContext context,
        String expression,
        Class<?> expectedReturnType,
        Class<?>[] expectedParameterTypes
    ) {
        return new Retrofits.MethodExpression(createMethodExpression(
            ELShim.of(context),
            expression,
            expectedReturnType,
            expectedParameterTypes
        ));
    }

    @Override
    public ELResolver getStreamELResolver() {
        return ELShim.of(super.getStreamELResolver());
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ELShim.initialize();
    }
}
