package javax.el;

import java.beans.FeatureDescriptor;
import java.util.Iterator;

/**
 * @deprecated Use {@link jakarta.el.ELResolver} instead.
 */
@Deprecated(since = "jakarta.el.ELResolver")
public abstract class ELResolver extends jakarta.el.ELResolver implements ELShim {
    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see jakarta.el.ELResolver#invoke(jakarta.el.ELContext, Object, Object, Class[], Object[])
     */
    public Object invoke(
        ELContext context,
        Object bean,
        Object method,
        Class<?>[] parameterTypes,
        Object[] parameters
    ) {
        return super.invoke(context, bean, method, parameterTypes, parameters);
    }

    /**
     * @see jakarta.el.ELResolver#getFeatureDescriptors(jakarta.el.ELContext, Object)
     */
    @Deprecated(since = "5.0", forRemoval = true)
    public Iterator<FeatureDescriptor> getFeatureDescriptors(ELContext context, Object bean) {
        return super.getFeatureDescriptors(context, bean);
    }

    /**
     * @see jakarta.el.ELResolver#convertToType(jakarta.el.ELContext, Object, Class)
     */
    public <T> T convertToType(ELContext context, Object object, Class<T> targetType) {
        return super.convertToType(context, object, targetType);
    }

    /**
     * @see jakarta.el.ELResolver#getValue(jakarta.el.ELContext, Object, Object)
     */
    public abstract Object getValue(ELContext context, Object bean, Object property);

    /**
     * @see jakarta.el.ELResolver#getType(jakarta.el.ELContext, Object, Object)
     */
    public abstract Class<?> getType(ELContext context, Object bean, Object property);

    /**
     * @see jakarta.el.ELResolver#setValue(jakarta.el.ELContext, Object, Object, Object)
     */
    public abstract void setValue(ELContext context, Object bean, Object property, Object value);

    /**
     * @see jakarta.el.ELResolver#isReadOnly(jakarta.el.ELContext, Object, Object)
     */
    public abstract boolean isReadOnly(ELContext context, Object bean, Object property);

    /**
     * @see jakarta.el.ELResolver#getCommonPropertyType(jakarta.el.ELContext, Object)
     */
    public abstract Class<?> getCommonPropertyType(ELContext context, Object bean);

    //==================================================================================================================
    // ELResolver Implementation Methods
    //==================================================================================================================

    @Override
    public Object invoke(
        jakarta.el.ELContext context,
        Object bean,
        Object method,
        Class<?>[] parameterTypes,
        Object[] parameters
    ) {
        return invoke(ELShim.of(context), bean, method, parameterTypes, parameters);
    }

    @Deprecated(since = "5.0", forRemoval = true)
    @Override
    public Iterator<FeatureDescriptor> getFeatureDescriptors(jakarta.el.ELContext context, Object bean) {
        return getFeatureDescriptors(ELShim.of(context), bean);
    }

    @Override
    public <T> T convertToType(jakarta.el.ELContext context, Object object, Class<T> targetType) {
        return convertToType(ELShim.of(context), object, targetType);
    }

    @Override
    public Object getValue(jakarta.el.ELContext context, Object bean, Object property) {
        return getValue(ELShim.of(context), bean, property);
    }

    @Override
    public Class<?> getType(jakarta.el.ELContext context, Object bean, Object property) {
        return getType(ELShim.of(context), bean, property);
    }

    @Override
    public void setValue(jakarta.el.ELContext context, Object bean, Object property, Object value) {
        setValue(ELShim.of(context), bean, property, value);
    }

    @Override
    public boolean isReadOnly(jakarta.el.ELContext context, Object bean, Object property) {
        return isReadOnly(ELShim.of(context), bean, property);
    }

    @Override
    public Class<?> getCommonPropertyType(jakarta.el.ELContext context, Object bean) {
        return getCommonPropertyType(ELShim.of(context), bean);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ELShim.initialize();
    }
}
