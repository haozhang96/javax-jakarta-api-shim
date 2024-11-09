package javax;

import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
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

    static <S> Class<? extends S> of(Class<S> shimType, Class<?> interfaceType) {
        if (shimType.isAssignableFrom(interfaceType)) {
            return interfaceType.asSubclass(shimType);
        }

        return Proxy
            .getProxyClass(MethodHandles.lookup().lookupClass().getClassLoader(), shimType, interfaceType)
            .asSubclass(shimType);
    }

    static <S> Stream<S> of(Function<Object, ? extends S> shimFactory, Object[] objects) {
        return Stream
            .of(objects)
            .map(shimFactory);
    }

    static <S> Stream<S> of(Function<Object, ? extends S> shimFactory, Iterable<?> objects) {
        final var stream =
            objects instanceof Collection<?>
                ? ((Collection<?>) objects).stream()
                : StreamSupport.stream(objects.spliterator(), false);
        return stream.map(shimFactory);
    }

    //==================================================================================================================
    // Facade
    //==================================================================================================================

    /**
     * @deprecated Use {@link jakarta} instead.
     */
    @Deprecated(since = "jakarta")
    abstract class Facade<T> implements Shim, Serializable, Cloneable {
        private static final StackWalker STACK_WALKER = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);

        protected final T target; // Conditionally serializable

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        protected Facade(T target) {
            this.target = Objects.requireNonNull(target);
            logEntryPoint();
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
        protected final Facade<T> clone() {
            try {
                return getClass().cast(super.clone());
            } catch (CloneNotSupportedException exception) {
                // This should never happen since we implement Cloneable.
                throw new InternalError(exception);
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
        // Private Helper Methods
        //==============================================================================================================

        private void logEntryPoint() {
            final var stackTrace =
                STACK_WALKER.walk(stackFrames ->
                    stackFrames
                        .dropWhile(stackFrame -> Shim.class.isAssignableFrom(stackFrame.getDeclaringClass()))
                        .limit(5L)
                        .map(StackWalker.StackFrame::toString)
                        .collect(Collectors.joining(System.lineSeparator() + "\t", System.lineSeparator() + "\t", ""))
                );
            System
                .getLogger(getClass().getName())
                .log(System.Logger.Level.INFO, "Shimming -> " + target.getClass().getName() + stackTrace);
        }
    }
}
