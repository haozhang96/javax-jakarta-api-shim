package javax.el;

import javax.shim.ShimSupport;

/**
 * @deprecated Use {@link jakarta.el.ValueExpression} instead.
 * @apiNote This class cannot extend {@link jakarta.el.ValueExpression} due to class hierarchy divergence.
 */
@Deprecated(since = "jakarta.el.ValueExpression")
public abstract class ValueExpression extends Expression {
    private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // ValueExpression Implementation Methods
    //==================================================================================================================

    /**
     * @see jakarta.el.ValueExpression#getValue(jakarta.el.ELContext)
     */
    public abstract <T> T getValue(ELContext context);

    /**
     * @see jakarta.el.ValueExpression#setValue(jakarta.el.ELContext, Object)
     */
    public abstract void setValue(ELContext context, Object value);

    /**
     * @see jakarta.el.ValueExpression#isReadOnly(jakarta.el.ELContext)
     */
    public abstract boolean isReadOnly(ELContext context);

    /**
     * @see jakarta.el.ValueExpression#getType(jakarta.el.ELContext)
     */
    public abstract Class<?> getType(ELContext context);

    /**
     * @see jakarta.el.ValueExpression#getExpectedType()
     */
    public abstract Class<?> getExpectedType();

    /**
     * @see jakarta.el.ValueExpression#getValueReference(jakarta.el.ELContext)
     */
    public ValueReference getValueReference(ELContext context) {
        return null;
    }

    //==================================================================================================================
    // Retrofit
    //==================================================================================================================

    /**
     * @deprecated Use {@link jakarta.el.ValueExpression} instead.
     */
    @Deprecated(since = "jakarta.el.ValueExpression")
    public static class Retrofit extends Retrofits.ValueExpression {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        public Retrofit(ValueExpression target) {
            super(target);
        }
    }
}
