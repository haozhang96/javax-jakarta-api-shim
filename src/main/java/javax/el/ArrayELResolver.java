package javax.el;

import java.beans.FeatureDescriptor;
import java.util.Iterator;

/**
 * @deprecated Use {@link jakarta.el.ArrayELResolver} instead.
 * @apiNote This class cannot extend {@link jakarta.el.ArrayELResolver} due to class hierarchy divergence.
 */
@Deprecated(since = "jakarta.el.ArrayELResolver")
public class ArrayELResolver extends ELResolver {
    private final jakarta.el.ArrayELResolver target;

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.el.ArrayELResolver#ArrayELResolver()
     */
    public ArrayELResolver() {
        target = new jakarta.el.ArrayELResolver();
    }

    /**
     * @see jakarta.el.ArrayELResolver#ArrayELResolver(boolean)
     */
    public ArrayELResolver(boolean isReadOnly) {
        target = new jakarta.el.ArrayELResolver(isReadOnly);
    }

    //==================================================================================================================
    // Delegated Methods
    //==================================================================================================================

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
