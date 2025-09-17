package javax.shim;

import java.io.Serializable;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.ParameterizedType;
import java.util.EnumSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This interface defines a {@link javax}-{@link jakarta} shim object that sits between the two APIs to enhance
 *   compile-time and runtime interoperability.
 *
 * @deprecated Use {@link jakarta} instead.
 */
@Deprecated(since = "jakarta")
public interface Shim {
    //==================================================================================================================
    // Object Implementation Methods
    //==================================================================================================================

    @Override
    boolean equals(Object other);

    @Override
    int hashCode();

    @Override
    String toString();

    //==================================================================================================================
    // Helper Methods
    //==================================================================================================================

    static void initialize() {
        // This method helps ensure the earliest initialization possible for our classes before any bundled classes in
        //   other dependencies.
        ShimSupport.ensureInitialized();
    }

    static <S extends Shim> Stream<S> of(Function<Object, ? extends S> shim, Object[] objects) {
        return objects != null ? Stream.of(objects).map(shim) : Stream.empty();
    }

    static <S extends Shim> Stream<S> of(Function<Object, ? extends S> shim, Iterable<?> objects) {
        return objects != null ? ShimSupport.stream(objects).map(shim) : Stream.empty();
    }

    static <S extends Shim> Class<? extends S> of(Class<?> baseType, Class<S> shimType) {
        return ShimProxy.create(baseType, shimType);
    }

    //==================================================================================================================
    // Retrofit-specific Implementation
    //==================================================================================================================

    /**
     * This interface defines a {@link javax}-to-{@link jakarta} retrofitting {@link Shim} that is required in cases
     *   where different inheritance hierarchies require "retrofitting" a {@link javax} shim back to its {@link jakarta}
     *   counterpart, as Java does not support extending multiple classes like it supports implementing multiple
     *   interfaces.
     * <br/><br/>
     *
     * For example, {@link javax.servlet.jsp.PageContext} extends {@link javax.servlet.jsp.JspContext}, which extends
     *   {@link jakarta.servlet.jsp.JspContext}. However, in cases where a {@link jakarta.servlet.jsp.PageContext} is
     *   needed, there is no way of making {@link javax.servlet.jsp.PageContext} extend its {@link jakarta} counterpart
     *   directly. Thus, a retrofitting shim would be required.
     *
     * @deprecated Use {@link jakarta} instead.
     */
    @Deprecated(since = "jakarta")
    interface Retrofit extends Shim { }

    //==================================================================================================================
    // Enum-specific Implementation
    //==================================================================================================================

    /**
     * This interface defines an {@link java.lang.Enum}-specific {@link Shim}.
     *
     * @deprecated Use {@link jakarta} instead.
     */
    @Deprecated(since = "jakarta")
    interface Enum<E extends java.lang.Enum<E>> extends Shim, Serializable {
        //==============================================================================================================
        // Helper Methods
        //==============================================================================================================

        static <E extends java.lang.Enum<E>> EnumSet<E> toJakarta(Class<E> type, Iterable<? extends Enum<E>> values) {
            return ShimSupport
                .stream(values)
                .map(Enum::toJakarta)
                .collect(Collectors.toCollection(() -> EnumSet.noneOf(type)));
        }

        //==============================================================================================================
        // Implementation Methods
        //==============================================================================================================

        @SuppressWarnings("unchecked")
        default E toJakarta() {
            return java.lang.Enum.valueOf((Class<E>) ShimSupport.toJakarta(getDeclaringClass()), name());
        }

        //==============================================================================================================
        // Enum Implementation Methods
        //==============================================================================================================

        /**
         * @see java.lang.Enum#name()
         */
        String name();

        /**
         * @see java.lang.Enum#ordinal()
         */
        int ordinal();

        /**
         * @see java.lang.Enum#getDeclaringClass()
         */
        Class<? extends java.lang.Enum<?>> getDeclaringClass();
    }

    //==================================================================================================================
    // Facade
    //==================================================================================================================

    /**
     * This class is an abstract {@link jakarta}-to-{@link javax} {@link Shim} meant for interfaces and delegation-style
     *   implementations, defining an accessible and potentially proxied {@link #target} for easy access and
     *   implementing all {@link Object} methods.
     *
     * @deprecated Use {@link jakarta} instead.
     */
    @Deprecated(since = "jakarta")
    abstract class Facade<T> implements Shim, Serializable, Cloneable {
        private static final MethodHandle FINALIZER =
            ShimReflector.call(MethodHandles.lookup(), Object.class, (lookup, clazz) ->
                lookup.findVirtual(clazz, "finalize", MethodType.methodType(void.class))
            );

        protected final T target; // Conditionally serializable

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        protected Facade(T target) {
            this.target = ShimProxy.create(target, getTargetClass());
            ShimSupport.logEntryPoint(getClass(), target.getClass());
        }

        //==============================================================================================================
        // Implementation Methods
        //==============================================================================================================

        @SuppressWarnings("unchecked")
        protected final Class<T> getTargetClass() {
            return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }

        //==============================================================================================================
        // Object Implementation Methods
        //==============================================================================================================

        @Override
        @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
        public final boolean equals(Object other) {
            return target.equals(other);
        }

        @Override
        public final int hashCode() {
            return target.hashCode();
        }

        @Override
        public final String toString() {
            return target.toString();
        }

        @Override
        @SuppressWarnings("unchecked")
        public final Facade<T> clone() {
            try {
                return getClass().cast(super.clone());
            } catch (CloneNotSupportedException exception) {
                // This should never happen since we implement Cloneable.
                throw new InternalError(exception);
            }
        }

        @Override
        @SuppressWarnings("deprecation")
        protected final void finalize() throws Throwable {
            try {
                FINALIZER.invokeExact(target);
            } finally {
                super.finalize();
            }
        }

        //==============================================================================================================
        // Annotation-specific Facade
        //==============================================================================================================

        /**
         * @deprecated Use {@link jakarta} instead.
         */
        @Deprecated(since = "jakarta")
        public abstract static class Annotation<A extends java.lang.annotation.Annotation> extends Facade<A> implements java.lang.annotation.Annotation {
            //==========================================================================================================
            // Constructors
            //==========================================================================================================

            protected Annotation(A target) {
                super(target);
            }

            //==========================================================================================================
            // Annotation Implementation Methods
            //==========================================================================================================

            @Override
            public final Class<? extends java.lang.annotation.Annotation> annotationType() {
                return target.annotationType();
            }
        }

        //==============================================================================================================
        // Static Initialization
        //==============================================================================================================

        static {
            initialize();
        }
    }
}
