package javax.el;

import java.beans.FeatureDescriptor;
import java.util.Iterator;

/**
 * @deprecated Use {@link jakarta.el.BeanNameELResolver} instead.
 * @apiNote This class cannot extend {@link jakarta.el.BeanNameELResolver} due to class hierarchy divergence.
 */
@Deprecated(since = "jakarta.el.BeanNameELResolver")
public class BeanNameELResolver extends ELResolver {
    private final jakarta.el.BeanNameELResolver target;

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.el.BeanNameELResolver#BeanNameELResolver(jakarta.el.BeanNameResolver)
     */
    public BeanNameELResolver(BeanNameResolver beanNameResolver) {
        target = new jakarta.el.BeanNameELResolver(beanNameResolver);
    }

    //==================================================================================================================
    // Delegated Methods
    //==================================================================================================================

    @Override
    public Object getValue(ELContext context, Object bean, Object property) {
        return target.getValue(context, bean, property);
    }

    @Override
    public Object getValue(jakarta.el.ELContext context, Object bean, Object property) {
        return target.getValue(context, bean, property);
    }

    @Override
    public void setValue(ELContext context, Object bean, Object property, Object value) {
        target.setValue(context, bean, property, value);
    }

    @Override
    public void setValue(jakarta.el.ELContext context, Object bean, Object property, Object value) {
        target.setValue(context, bean, property, value);
    }

    @Override
    public boolean isReadOnly(ELContext context, Object bean, Object property) {
        return target.isReadOnly(context, bean, property);
    }

    @Override
    public boolean isReadOnly(jakarta.el.ELContext context, Object bean, Object property) {
        return target.isReadOnly(context, bean, property);
    }

    @Override
    public Class<?> getType(ELContext context, Object bean, Object property) {
        return target.getType(context, bean, property);
    }

    @Override
    public Class<?> getType(jakarta.el.ELContext context, Object bean, Object property) {
        return target.getType(context, bean, property);
    }

    @Override
    public Class<?> getCommonPropertyType(ELContext context, Object bean) {
        return target.getCommonPropertyType(context, bean);
    }

    @Override
    public Class<?> getCommonPropertyType(jakarta.el.ELContext context, Object bean) {
        return target.getCommonPropertyType(context, bean);
    }

    @Override
    public <T> T convertToType(ELContext context, Object object, Class<T> targetType) {
        return target.convertToType(context, object, targetType);
    }

    @Override
    public <T> T convertToType(jakarta.el.ELContext context, Object object, Class<T> targetType) {
        return target.convertToType(context, object, targetType);
    }

    @Override
    public Object invoke(
        ELContext context,
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

    @Deprecated(since = "Expression Language 5.0", forRemoval = true)
    @Override
    public Iterator<FeatureDescriptor> getFeatureDescriptors(ELContext context, Object bean) {
        return target.getFeatureDescriptors(context, bean);
    }

    @Deprecated(since = "Expression Language 5.0", forRemoval = true)
    @Override
    public Iterator<FeatureDescriptor> getFeatureDescriptors(jakarta.el.ELContext context, Object bean) {
        return target.getFeatureDescriptors(context, bean);
    }

    //==================================================================================================================
    // Retrofit
    //==================================================================================================================

    /**
     * @deprecated Use {@link jakarta.el.BeanNameELResolver} instead.
     */
    @Deprecated(since = "jakarta.el.BeanNameELResolver")
    public static class Retrofit extends Retrofits.BeanNameELResolver {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        public Retrofit(BeanNameELResolver target) {
            super(target);
        }
    }
}
