package javax.el;

/**
 * @deprecated Use {@link jakarta.el.TypeConverter} instead.
 * @apiNote This class cannot extend {@link jakarta.el.TypeConverter} due to class hierarchy divergence.
 */
@Deprecated(since = "jakarta.el.TypeConverter")
public abstract class TypeConverter extends ELResolver {
    //==================================================================================================================
    // ELResolver Implementation Methods
    //==================================================================================================================

    @Override
    public abstract <T> T convertToType(ELContext context, Object object, Class<T> targetType);

    @Override
    public Object getValue(ELContext context, Object bean, Object property) {
        return null;
    }

    @Override
    public Class<?> getType(ELContext context, Object bean, Object property) {
        return null;
    }

    @Override
    public void setValue(ELContext context, Object bean, Object property, Object value) {
        // Do nothing.
    }

    @Override
    public boolean isReadOnly(ELContext context, Object bean, Object property) {
        return false;
    }

    @Override
    public Class<?> getCommonPropertyType(ELContext context, Object bean) {
        return null;
    }
}
