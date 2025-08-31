package javax.el;

import java.util.List;

/**
 * @deprecated Use {@link jakarta.el.LambdaExpression} instead.
 */
@Deprecated(since = "jakarta.el.LambdaExpression")
public class LambdaExpression extends jakarta.el.LambdaExpression implements ELShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    public LambdaExpression(List<String> formalParameters, ValueExpression expression) {
        super(formalParameters, new Retrofits.ValueExpression(expression));
    }

    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see jakarta.el.LambdaExpression#setELContext(jakarta.el.ELContext)
     */
    public void setELContext(ELContext context) {
        super.setELContext(context);
    }

    /**
     * @see jakarta.el.LambdaExpression#invoke(jakarta.el.ELContext, Object...)
     */
    public Object invoke(ELContext context, Object... arguments) throws ELException {
        try {
            return super.invoke(context, arguments);
        } catch (jakarta.el.ELException exception) {
            throw ELShim.of(exception);
        }
    }

    //==================================================================================================================
    // LambdaExpression Implementation Methods
    //==================================================================================================================

    @Override
    public void setELContext(jakarta.el.ELContext context) {
        setELContext(ELShim.of(context));
    }

    @Override
    public Object invoke(jakarta.el.ELContext context, Object... arguments) throws ELException {
        return invoke(ELShim.of(context), arguments);
    }

    @Override
    public Object invoke(Object... arguments) throws ELException {
        try {
            return super.invoke(arguments);
        } catch (jakarta.el.ELException exception) {
            throw ELShim.of(exception);
        }
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ELShim.initialize();
    }
}
