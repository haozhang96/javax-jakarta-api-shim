package javax.shim;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.ref.Reference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * This class contains miscellaneous support methods and objects for the {@code javax-jakarta-api-shim} library.
 *
 * @deprecated This class should only be used internally by the {@code javax-jakarta-api-shim} library.
 */
@Deprecated(since = "javax-jakarta-api-shim")
public final class ShimSupport {
    public static final StackWalker STACK_WALKER = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);

    private static final String JAVAX = "javax.";
    private static final String JAKARTA = "jakarta.";

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    private ShimSupport() {
        throw new UnsupportedOperationException();
    }

    //==================================================================================================================
    // Support Methods
    //==================================================================================================================

    /**
     * Retrieve the property/attribute with a given {@value #JAKARTA}- or {@value #JAVAX}-prefixed name using a given
     *   {@link String}-accepting getter {@link Function}, using its {@value #JAKARTA}- or {@value #JAVAX}-prefixed
     *   counterpart if necessary.
     *
     * @param getter The {@link Function} to use for retrieving the property with the given {@value #JAKARTA}- or
     *               {@value #JAVAX}-prefixed name
     * @param name The {@value #JAKARTA}- or {@value #JAVAX}-prefixed name of the property to retrieve using the given
     *             getter {@link Function}
     * @param <T> The resulting type of the property retrieved using the given getter {@link Function}
     */
    public static <T> T getPrefixedProperty(Function<? super String, ? extends T> getter, String name) {
        return Optional
            .<T>ofNullable(getter.apply(name.replace(JAVAX, JAKARTA)))
            .orElseGet(() -> getter.apply(name.replace(JAKARTA, JAVAX)));
    }

    /**
     * Determine whether a given {@link Throwable} is shimmable - holding a message that contains either {@value #JAVAX}
     *   or {@value #JAKARTA}.
     *
     * @param cause The {@link Throwable} to determine whether it's shimmable
     */
    public static boolean isShimmable(Throwable cause) {
        final var message = cause.getMessage();
        return message != null && (message.contains(JAVAX) || message.contains(JAKARTA));
    }

    /**
     * Construct a {@link Stream} from a given {@link Iterable}.
     *
     * @param iterable The {@link Iterable} to construct the {@link Stream} from
     * @param <T> The type of elements encountered by the given {@link Iterable} and the constructed {@link Stream}
     *
     * @see Collection#stream()
     * @see StreamSupport#stream(Spliterator, boolean)
     */
    public static <T> Stream<T> stream(Iterable<T> iterable) {
        return iterable instanceof Collection<?>
            ? ((Collection<T>) iterable).stream()
            : StreamSupport.stream(iterable.spliterator(), false);
    }

    /**
     * Throw a given (potentially checked) {@link Throwable} without the compiler check.
     *
     * @param cause The (potentially checked) {@link Throwable} to throw without the compiler check
     */
    @SuppressWarnings("unchecked")
    public static <X extends Throwable> X rethrow(Throwable cause) throws X {
        throw cause instanceof InvocationTargetException || cause instanceof UndeclaredThrowableException
            ? (X) Objects.requireNonNullElse(cause.getCause(), cause)
            : (X) cause;
    }

    /**
     * Determine the {@code serialVersionUID} to use for the {@code javax} {@link java.lang.Class} invoking this method
     *   by inspecting its {@code jakarta} counterpart.
     *
     * @throws UnsupportedOperationException An exception indicating a failure to determine the {@code serialVersionUID}
     *                                       to use for the {@code javax} {@link java.lang.Class} invoking this method
     */
    public static long getSerialVersionUID() {
        final var javaxClass = STACK_WALKER.getCallerClass();
        if (!Class.isJavax(javaxClass.getName())) {
            throw new UnsupportedOperationException("Not a javax class: " + javaxClass.getName());
        } else if (!Serializable.class.isAssignableFrom(javaxClass)) {
            throw new UnsupportedOperationException("Not a serializable class: " + javaxClass.getName());
        }

        try {
            return Reflect.call(Class.toJakarta(javaxClass), (lookup, jakartaClass) ->
                lookup
                    .findStaticVarHandle(jakartaClass, "serialVersionUID", long.class)
                    .get()
            );
        } catch (IllegalStateException exception) {
            throw new UnsupportedOperationException(
                "Cannot determine serialVersionUID for class: " + javaxClass.getName()
            );
        }
    }

    /**
     * Throw an {@link UnsupportedOperationException} with a message describing the inability to shim a given object,
     *   using a given label for the object's description where applicable.
     *
     * @param label The label describing the given object (e.g., event listener); may be {@code null} to describe the
     *              given object generically or based on known types (e.g., annotation, enumeration, exception)
     * @param object The object to throw the {@link UnsupportedOperationException} for
     *
     * @throws UnsupportedOperationException An exception indicating the inability to shim the given object of an
     *                                       unknown type
     */
    public static <T> T throwUnknownType(String label, Object object) throws UnsupportedOperationException {
        final java.lang.Class<?> type;
        if (object instanceof Annotation) {
            label = "annotation";
            type = ((Annotation) object).annotationType();
        } else if (object instanceof Enum<?>) {
            label = "enumeration";
            type = ((Enum<?>) object).getDeclaringClass();
        } else {
            label = object instanceof Exception ? "exception" : label;
            type = object.getClass();
        }

        throw new UnsupportedOperationException(String.format(
            "Cannot shim unknown %s %stype: %s",
            STACK_WALKER.getCallerClass().getPackageName(), label != null ? label + " " : "", type.getName()
        ));
    }

    //==================================================================================================================
    // Class Support
    //==================================================================================================================

    /**
     * This class contains miscellaneous {@link java.lang.Class}-related support methods for the
     *   {@code javax-jakarta-api-shim} library.
     *
     * @deprecated This class should only be used internally by the {@code javax-jakarta-api-shim} library.
     */
    @Deprecated(since = "javax-jakarta-api-shim")
    public static final class Class {
        private static final Map<String, Boolean> EXISTENCE = new ConcurrentHashMap<>();
        private static final Set<java.lang.Class<?>> INITIALIZED = Collections.newSetFromMap(new WeakHashMap<>());
        private static final Map<String, String> JAVAX_TO_JAKARTA_MAPPINGS = new ConcurrentHashMap<>();
        private static final Map<String, String> JAKARTA_TO_JAVAX_MAPPINGS = new ConcurrentHashMap<>();
        private static final Set<String> JAVAX_PACKAGES =
            Stream
                .of(
                    "activation", "annotation", "el", "inject", "interceptor", "jms", "jws", "servlet", "transaction",
                    "validation", "websocket", "ws.rs", "xml.bind", "xml.soap", "xml.ws"
                )
                .map(JAVAX::concat)
                .collect(Collectors.toCollection(ConcurrentHashMap::newKeySet));
        private static final Set<String> JAKARTA_PACKAGES =
            JAVAX_PACKAGES
                .stream()
                .map(packageName -> JAKARTA + packageName.substring(JAVAX.length())) // We cannot use toJakarta() yet.
                .collect(Collectors.toCollection(ConcurrentHashMap::newKeySet));

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        private Class() {
            throw new UnsupportedOperationException();
        }

        //==============================================================================================================
        // Support Methods
        //==============================================================================================================

        /**
         * Determine whether the {@link java.lang.Class} with a given name is a {@code javax} class.
         *
         * @param className The name of the {@link java.lang.Class} to determine whether it's a {@code javax} class
         */
        public static boolean isJavax(String className) {
            return JAVAX_TO_JAKARTA_MAPPINGS.containsKey(className)
                || JAKARTA_TO_JAVAX_MAPPINGS.containsValue(className)
                || exists(className) && isInPackage(JAVAX_PACKAGES, className);
        }

        /**
         * Determine whether the {@link java.lang.Class} with a given name is a {@code jakarta} class.
         *
         * @param className The name of the {@link java.lang.Class} to determine whether it's a {@code jakarta} class
         */
        public static boolean isJakarta(String className) {
            return JAKARTA_TO_JAVAX_MAPPINGS.containsKey(className)
                || JAVAX_TO_JAKARTA_MAPPINGS.containsValue(className)
                || exists(className) && isInPackage(JAKARTA_PACKAGES, className);
        }

        /**
         * Convert a given {@code jakarta} class name into its {@code javax} counterpart.
         * <br/><br/>
         *
         * <b>Note:</b> The returned {@code javax} class name may not exist; use {@link #toJavax(java.lang.Class)}
         *   instead.
         *
         * @param className The {@code jakarta} class name to convert into its {@code javax} counterpart
         */
        public static String toJavax(String className) {
            if (!isJakarta(className)) {
                return className;
            }

            return JAKARTA_TO_JAVAX_MAPPINGS.computeIfAbsent(className, jakartaClassName -> {
                final var javaxClassName = JAVAX + className.substring(JAKARTA.length());
                JAVAX_TO_JAKARTA_MAPPINGS.putIfAbsent(javaxClassName, jakartaClassName); // Bi-directional mapping
                return javaxClassName;
            });
        }

        /**
         * Convert a given {@code jakarta} {@link java.lang.Class} into its {@code javax} counterpart.
         *
         * @param clazz The {@code jakarta} {@link java.lang.Class} to convert into its {@code javax} counterpart
         */
        public static java.lang.Class<?> toJavax(java.lang.Class<?> clazz) {
            return load(toJavax(clazz.getName()), loaderOf(clazz));
        }

        /**
         * Convert the current {@code javax} {@link java.lang.Class} invoking this method into its {@code jakarta}
         *   counterpart.
         */
        public static java.lang.Class<?> toJakarta() {
            return toJakarta(STACK_WALKER.getCallerClass());
        }

        /**
         * Convert a given {@code javax} class name into its {@code jakarta} counterpart.
         * <br/><br/>
         *
         * <b>Note:</b> The returned {@code jakarta} class name may not exist; use {@link #toJakarta(java.lang.Class)}
         *   instead.
         *
         * @param className The {@code javax} class name to convert into its {@code jakarta} counterpart
         */
        public static String toJakarta(String className) {
            if (!isJavax(className)) {
                return className;
            }

            return JAVAX_TO_JAKARTA_MAPPINGS.computeIfAbsent(className, javaxClassName -> {
                final var jakartaClassName = JAKARTA + className.substring(JAVAX.length());
                JAKARTA_TO_JAVAX_MAPPINGS.putIfAbsent(jakartaClassName, javaxClassName); // Bi-directional mapping
                return jakartaClassName;
            });
        }

        /**
         * Convert a given {@code javax} {@link java.lang.Class} into its {@code jakarta} counterpart.
         *
         * @param clazz The {@code javax} {@link java.lang.Class} to convert into its {@code jakarta} counterpart
         */
        public static java.lang.Class<?> toJakarta(java.lang.Class<?> clazz) {
            var className = toJakarta(clazz.getName());
            if (!exists(className)) {
                // Try walking up the class hierarchy to see if it extends a jakarta class.
                className =
                    hierarchyOf(clazz.getSuperclass())
                        .map(java.lang.Class::getName)
                        .map(Class::toJakarta)
                        .dropWhile(Predicate.not(Class::exists))
                        .findFirst()
                        .orElse(className);
                JAVAX_TO_JAKARTA_MAPPINGS.put(clazz.getName(), className);
            }

            return load(className, loaderOf(clazz));
        }

        /**
         * Load and initialize the {@link java.lang.Class} with a given name using the {@link ClassLoader} of the
         *   {@link java.lang.Class} invoking this method.
         *
         * @param className The name of the {@link java.lang.Class} to load using the {@link ClassLoader} of the
         *                  {@link java.lang.Class} invoking this method
         */
        public static java.lang.Class<?> load(String className) {
            return load(className, loaderOf(STACK_WALKER.getCallerClass()));
        }

        /**
         * Load and initialize the {@link java.lang.Class} with a given name using a given {@link ClassLoader}.
         *
         * @param className The name of the {@link java.lang.Class} to load using the given {@link ClassLoader}
         * @param classLoader The {@link ClassLoader} to use for loading the {@link java.lang.Class} with the given name
         */
        public static java.lang.Class<?> load(String className, ClassLoader classLoader) {
            try {
                return java.lang.Class.forName(className, true, loaderOf(classLoader));
            } catch (ClassNotFoundException exception) {
                final var root = className.substring(0, className.indexOf('.'));
                throw rethrow(new NoClassDefFoundError("Unknown " + root + " type: " + className).initCause(exception));
            }
        }

        /**
         * Determine the concrete {@link ClassLoader} to use for a given {@link java.lang.Class}, if possible.
         *
         * @param clazz The {@link java.lang.Class} to determine the concrete {@link ClassLoader} to use for
         */
        public static ClassLoader loaderOf(java.lang.Class<?> clazz) {
            final var callerClass = STACK_WALKER.getCallerClass();
            return loaderOf(Objects.requireNonNullElse(clazz.getClassLoader(), callerClass.getClassLoader()));
        }

        /**
         * Determine the concrete {@link ClassLoader} to use for a given potentially {@code null} {@link ClassLoader},
         *   if possible.
         *
         * @param classLoader The potentially {@code null} {@link ClassLoader} to determine the concrete
         *                    {@link ClassLoader} to use for
         */
        public static ClassLoader loaderOf(ClassLoader classLoader) {
            return Optional
                .ofNullable(classLoader)
                .or(() -> Optional.ofNullable(Thread.currentThread().getContextClassLoader()))
                .or(() -> Optional.ofNullable(STACK_WALKER.getCallerClass().getClassLoader()))
                .orElseGet(ClassLoader::getSystemClassLoader);
        }

        /**
         * Retrieve a {@link Stream} of the {@link java.lang.Class} hierarchy of a given {@link java.lang.Class}.
         *
         * @param clazz The {@link java.lang.Class} retrieve the {@link Stream} of the {@link java.lang.Class} hierarchy
         *              of
         */
        public static Stream<java.lang.Class<?>> hierarchyOf(java.lang.Class<?> clazz) {
            return Stream.iterate(clazz, Objects::nonNull, java.lang.Class::getSuperclass);
        }

        /**
         * Determine whether the {@link java.lang.Class} with a given name exists under the {@link ClassLoader} of the
         *   {@link java.lang.Class} invoking this method.
         *
         * @param className The name of the {@link java.lang.Class} to determine whether it exists under the
         *                  {@link ClassLoader} of the {@link java.lang.Class} invoking this method
         */
        public static boolean exists(String className) {
            return exists(className, loaderOf(STACK_WALKER.getCallerClass()));
        }

        /**
         * Determine whether the {@link java.lang.Class} with a given name exists under a given {@link ClassLoader}.
         *
         * @param className The name of the {@link java.lang.Class} to determine whether it exists under the given
         *                  {@link ClassLoader}
         * @param classLoader The {@link ClassLoader} to use for determining the existence of the
         *                    {@link java.lang.Class} with the given name
         */
        public static boolean exists(String className, ClassLoader classLoader) {
            return className != null && EXISTENCE.computeIfAbsent(className, ignored -> {
                try {
                    java.lang.Class.forName(className, false, loaderOf(classLoader));
                    return true;
                } catch (ClassNotFoundException exception) {
                    return false;
                }
            });
        }

        /**
         * Ensure that a given list of {@link java.lang.Class}(es) have been initialized.
         *
         * @param classes The {@link java.lang.Class}(es) to ensure initialization for
         *
         * @see sun.misc.Unsafe#ensureClassInitialized(java.lang.Class)
         */
        public static void ensureInitialized(java.lang.Class<?>... classes) {
            for (final var clazz : classes) {
                if (INITIALIZED.add(clazz)) {
                    Unsafe.ensureClassInitialized(clazz);
                }
            }
        }

        //==============================================================================================================
        // Private Helper Methods
        //==============================================================================================================

        private static boolean isInPackage(Collection<String> packageNames, String className) {
            final var lastDot = className.lastIndexOf('.');
            final var packageName = lastDot != -1 ? className.substring(0, lastDot) : className;
            if (packageNames.contains(packageName)) {
                return true;
            }

            for (final var packageName$ : packageNames) {
                if (packageName.startsWith(packageName$)) {
                    return packageNames.add(packageName);
                }
            }

            return false;
        }
    }

    //==================================================================================================================
    // Reflection Support
    //==================================================================================================================

    /**
     * This class defines a reflective action (any action that throws a {@link ReflectiveOperationException}) that
     *   requires the use of a
     *   {@linkplain MethodHandles#privateLookupIn(java.lang.Class, MethodHandles.Lookup) privileged lookup}.
     *
     * @deprecated This class should only be used internally by the {@code javax-jakarta-api-shim} library.
     */
    @FunctionalInterface
    @Deprecated(since = "javax-jakarta-api-shim")
    public interface Reflect {
        //==============================================================================================================
        // Implementation Methods
        //==============================================================================================================

        /**
         * Perform the reflective action on a given {@link java.lang.Class} using its associated
         *   {@linkplain MethodHandles#privateLookupIn(java.lang.Class, MethodHandles.Lookup) privileged lookup}.
         *
         * @param lookup The privileged {@link MethodHandles.Lookup} to use for introspecting the given
         *               {@link java.lang.Class}
         * @param clazz The {@link java.lang.Class} to perform the reflective action on using the given privileged
         *              {@link MethodHandles.Lookup}
         *
         * @throws Throwable Any exception thrown by the reflective action
         */
        Object call(MethodHandles.Lookup lookup, java.lang.Class<?> clazz) throws Throwable;

        //==============================================================================================================
        // Helper Methods
        //==============================================================================================================

        /**
         * Call a given {@link Reflect} for the {@link java.lang.Class} with a given name using
         *   {@linkplain MethodHandles#privateLookupIn(java.lang.Class, MethodHandles.Lookup) full lookup privileges}
         *   available to this class.
         *
         * @param className The name of the {@link java.lang.Class} to introspect using the given {@link Reflect}
         * @param action The {@link Reflect} to use for performing reflective actions on the {@link java.lang.Class}
         *               with the given name
         * @param <T> The expected type of the resulting {@link Reflect} call
         * @param <X> The type of {@link Throwable} expected to be thrown by the given {@link Reflect}
         * @return The result of the {@link Reflect} call
         *
         * @throws X Any {@link Throwable} that may have been thrown by the given {@link Reflect}
         */
        static <T, X extends Throwable> T call(String className, Reflect action) throws X {
            return call(MethodHandles.lookup(), className, action);
        }

        /**
         * Call a given {@link Reflect} for a given {@link java.lang.Class} using
         *   {@linkplain MethodHandles#privateLookupIn(java.lang.Class, MethodHandles.Lookup) full lookup privileges}
         *   available to this class.
         *
         * @param clazz The {@link java.lang.Class} to introspect using the given {@link Reflect}
         * @param action The {@link Reflect} to use for performing reflective actions on the given
         *               {@link java.lang.Class}
         * @param <T> The expected type of the resulting {@link Reflect} call
         * @param <X> The type of {@link Throwable} expected to be thrown by the given {@link Reflect}
         * @return The result of the {@link Reflect} call
         *
         * @throws X Any {@link Throwable} that may have been thrown by the given {@link Reflect}
         */
        static <T, X extends Throwable> T call(java.lang.Class<?> clazz, Reflect action) throws X {
            return call(MethodHandles.lookup(), clazz, action);
        }

        /**
         * Call a given {@link Reflect} for the {@link java.lang.Class} with a given name after granting a given
         *   {@link MethodHandles.Lookup}
         *   {@linkplain MethodHandles#privateLookupIn(java.lang.Class, MethodHandles.Lookup) full lookup privileges}.
         *
         * @param lookup The {@link MethodHandles.Lookup} to use for introspecting the {@link java.lang.Class} with the
         *               given name using the given {@link Reflect}; typically passed in directly as a
         *               {@link MethodHandles#lookup()} call
         * @param className The name of the {@link java.lang.Class} to introspect using the given
         *                  {@link MethodHandles.Lookup} and {@link Reflect}
         * @param action The {@link Reflect} to use for performing reflective actions on the {@link java.lang.Class}
         *               with the given name using the given {@link MethodHandles.Lookup}
         * @param <T> The expected type of the resulting {@link Reflect} call
         * @param <X> The type of {@link Throwable} expected to be thrown by the given {@link Reflect}
         * @return The result of the {@link Reflect} call
         *
         * @throws X Any {@link Throwable} that may have been thrown by the given {@link Reflect}
         */
        static <T, X extends Throwable> T call(
            MethodHandles.Lookup lookup,
            String className,
            Reflect action
        ) throws X {
            final var callerClass = STACK_WALKER.getCallerClass();
            final var classLoader =
                Objects.requireNonNullElse(lookup.lookupClass().getClassLoader(), callerClass.getClassLoader());
            return call(lookup, Class.load(className, classLoader), action);
        }

        /**
         * Call a given {@link Reflect} for a given {@link java.lang.Class} after granting a given
         *   {@link MethodHandles.Lookup}
         *   {@linkplain MethodHandles#privateLookupIn(java.lang.Class, MethodHandles.Lookup) full lookup privileges}.
         *
         * @param lookup The {@link MethodHandles.Lookup} to use for introspecting the given {@link java.lang.Class}
         *               using the given {@link Reflect}; typically passed in directly as a
         *               {@link MethodHandles#lookup()} call
         * @param clazz The {@link java.lang.Class} to introspect using the given {@link MethodHandles.Lookup} and
         *              {@link Reflect}
         * @param action The {@link Reflect} to use for performing reflective actions on the given
         *               {@link java.lang.Class} using the given {@link MethodHandles.Lookup}
         * @param <T> The expected type of the resulting {@link Reflect} call
         * @param <X> The type of {@link Throwable} expected to be thrown by the given {@link Reflect}
         * @return The result of the {@link Reflect} call
         *
         * @throws X Any {@link Throwable} that may have been thrown by the given {@link Reflect}
         */
        @SuppressWarnings("unchecked")
        static <T, X extends Throwable> T call(
            MethodHandles.Lookup lookup,
            java.lang.Class<?> clazz,
            Reflect action
        ) throws X {
            try {
                return (T) action.call(MethodHandles.privateLookupIn(clazz, lookup), clazz);
            } catch (Throwable cause) {
                throw rethrow(cause);
            }
        }
    }

    //==================================================================================================================
    // sun.misc.Unsafe Support
    //==================================================================================================================

    /**
     * This class exposes certain {@link sun.misc.Unsafe} mechanics to the {@code javax-jakarta-api-shim} library
     *   without requiring compile-time dependency on it.
     * <br/><br/>
     *
     * In particular, this class leverages {@link sun.misc.Unsafe}'s ability to modify {@code final} fields and
     *   instantiate objects without invoking their constructors.
     *
     * @deprecated This class should only be used internally by the {@code javax-jakarta-api-shim} library.
     * @see sun.misc.Unsafe
     */
    @Deprecated(since = "javax-jakarta-api-shim")
    @SuppressWarnings("unchecked")
    public static final class Unsafe {
        private static final Map<java.lang.Class<?>, Map.Entry<MethodHandle, MethodHandle>> FIELD_ACCESSORS;
        private static final MethodHandle STATIC_FIELD_BASE;
        private static final MethodHandle STATIC_FIELD_OFFSET;
        private static final MethodHandle OBJECT_FIELD_OFFSET;
        private static final MethodHandle SHOULD_BE_INITIALIZED;
        private static final MethodHandle ENSURE_CLASS_INITIALIZED;
        private static final MethodHandle ALLOCATE_INSTANCE;
        private static final MethodHandle THROW_EXCEPTION;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        private Unsafe() {
            throw new UnsupportedOperationException();
        }

        //==============================================================================================================
        // Helper Methods
        //==============================================================================================================

        /**
         * @see sun.misc.Unsafe#staticFieldBase(Field)
         * @see sun.misc.Unsafe#staticFieldOffset(Field)
         * @see sun.misc.Unsafe#getObject(Object, long)
         */
        public static <T> T getField(Field field) {
            return getField(field, null);
        }

        /**
         * @see sun.misc.Unsafe#objectFieldOffset(Field)
         * @see sun.misc.Unsafe#staticFieldBase(Field)
         * @see sun.misc.Unsafe#staticFieldOffset(Field)
         * @see sun.misc.Unsafe#getObject(Object, long)
         */
        public static <T> T getField(Field field, Object target) {
            try {
                return (T)
                    FIELD_ACCESSORS
                        .getOrDefault(field.getType(), FIELD_ACCESSORS.get(Object.class))
                        .getKey()
                        .invoke(getFieldBase(field, target), getFieldOffset(field));
            } catch (Throwable cause) {
                throw rethrow(cause);
            }
        }

        /**
         * @see sun.misc.Unsafe#staticFieldBase(Field)
         * @see sun.misc.Unsafe#staticFieldOffset(Field)
         * @see sun.misc.Unsafe#putObject(Object, long, Object)
         */
        public static <T> T setField(Field field, T value) {
            return setField(field, null, value);
        }

        /**
         * @see sun.misc.Unsafe#objectFieldOffset(Field)
         * @see sun.misc.Unsafe#staticFieldBase(Field)
         * @see sun.misc.Unsafe#staticFieldOffset(Field)
         * @see sun.misc.Unsafe#putObject(Object, long, Object)
         */
        public static <T> T setField(Field field, Object target, T value) {
            try {
                FIELD_ACCESSORS
                    .getOrDefault(field.getType(), FIELD_ACCESSORS.get(Object.class))
                    .getValue()
                    .invoke(getFieldBase(field, target), getFieldOffset(field), value);
                return value;
            } catch (Throwable cause) {
                throw rethrow(cause);
            }
        }

        /**
         * @see sun.misc.Unsafe#staticFieldBase(Field)
         * @see sun.misc.Unsafe#staticFieldOffset(Field)
         * @see sun.misc.Unsafe#objectFieldOffset(Field)
         * @see sun.misc.Unsafe#getObject(Object, long)
         * @see sun.misc.Unsafe#putObject(Object, long, Object)
         */
        public static <T> void copyField(Field field, T source, T target) {
            setField(field, target, getField(field, source));
        }

        /**
         * @see sun.misc.Unsafe#ensureClassInitialized(java.lang.Class)
         * @see sun.misc.Unsafe#shouldBeInitialized(java.lang.Class)
         */
        public static <T> java.lang.Class<T> ensureClassInitialized(java.lang.Class<T> clazz) {
            try {
                if ((boolean) SHOULD_BE_INITIALIZED.invokeExact(clazz)) {
                    ENSURE_CLASS_INITIALIZED.invokeExact(clazz);
                }

                return clazz;
            } catch (Throwable cause) {
                throw rethrow(cause);
            }
        }

        /**
         * @see sun.misc.Unsafe#allocateInstance(java.lang.Class)
         */
        public static <T> T allocateInstance(java.lang.Class<? extends T> clazz) {
            try {
                return clazz.cast(ALLOCATE_INSTANCE.invokeExact(clazz));
            } catch (Throwable cause) {
                throw rethrow(cause);
            }
        }

        /**
         * @see sun.misc.Unsafe#throwException(Throwable)
         */
        public static <X extends Throwable> X throwException(Throwable cause) throws X {
            try {
                THROW_EXCEPTION.invokeExact(cause);
                throw (X) cause;
            } catch (Throwable ignored) {
                throw rethrow(cause);
            }
        }

        //==============================================================================================================
        // Private Helper Methods
        //==============================================================================================================

        /**
         * @see sun.misc.Unsafe#staticFieldBase(Field)
         */
        private static Object getFieldBase(Field field, Object target) throws Throwable {
            return Modifier.isStatic(field.getModifiers()) ? STATIC_FIELD_BASE.invokeExact(field) : target;
        }

        /**
         * @see sun.misc.Unsafe#staticFieldOffset(Field)
         * @see sun.misc.Unsafe#objectFieldOffset(Field)
         */
        private static long getFieldOffset(Field field) throws Throwable {
            return Modifier.isStatic(field.getModifiers())
                ? (long) STATIC_FIELD_OFFSET.invokeExact(field)
                : (long) OBJECT_FIELD_OFFSET.invokeExact(field);
        }

        //==============================================================================================================
        // Static Initialization
        //==============================================================================================================

        static {
            final MethodHandle[] methods =
                Reflect.call("sun.misc.Unsafe", (lookup, unsafeClass) -> {
                    final var unsafe =
                        lookup
                            .findStaticVarHandle(unsafeClass, "theUnsafe", unsafeClass)
                            .get();
                    final var accessor = MethodType.methodType(void.class, Object.class, long.class);
                    return new MethodHandle[] {
                        lookup.bind(unsafe, "getObject", accessor.changeReturnType(Object.class)),
                        lookup.bind(unsafe, "putObject", accessor.appendParameterTypes(Object.class)),
                        lookup.bind(unsafe, "getBoolean", accessor.changeReturnType(boolean.class)),
                        lookup.bind(unsafe, "putBoolean", accessor.appendParameterTypes(boolean.class)),
                        lookup.bind(unsafe, "getByte", accessor.changeReturnType(byte.class)),
                        lookup.bind(unsafe, "putByte", accessor.appendParameterTypes(byte.class)),
                        lookup.bind(unsafe, "getShort", accessor.changeReturnType(short.class)),
                        lookup.bind(unsafe, "putShort", accessor.appendParameterTypes(short.class)),
                        lookup.bind(unsafe, "getChar", accessor.changeReturnType(char.class)),
                        lookup.bind(unsafe, "putChar", accessor.appendParameterTypes(char.class)),
                        lookup.bind(unsafe, "getInt", accessor.changeReturnType(int.class)),
                        lookup.bind(unsafe, "putInt", accessor.appendParameterTypes(int.class)),
                        lookup.bind(unsafe, "getLong", accessor.changeReturnType(long.class)),
                        lookup.bind(unsafe, "putLong", accessor.appendParameterTypes(long.class)),
                        lookup.bind(unsafe, "getFloat", accessor.changeReturnType(float.class)),
                        lookup.bind(unsafe, "putFloat", accessor.appendParameterTypes(float.class)),
                        lookup.bind(unsafe, "getDouble", accessor.changeReturnType(double.class)),
                        lookup.bind(unsafe, "putDouble", accessor.appendParameterTypes(double.class)),
                        lookup.bind(unsafe, "staticFieldBase", MethodType.methodType(Object.class, Field.class)),
                        lookup.bind(unsafe, "staticFieldOffset", MethodType.methodType(long.class, Field.class)),
                        lookup.bind(unsafe, "objectFieldOffset", MethodType.methodType(long.class, Field.class)),
                        lookup.bind(unsafe, "shouldBeInitialized", MethodType.methodType(boolean.class, java.lang.Class.class)),
                        lookup.bind(unsafe, "ensureClassInitialized", MethodType.methodType(void.class, java.lang.Class.class)),
                        lookup.bind(unsafe, "allocateInstance", MethodType.methodType(Object.class, java.lang.Class.class)),
                        lookup.bind(unsafe, "throwException", MethodType.methodType(void.class, Throwable.class)),
                    };
                });

            var index = 0;
            FIELD_ACCESSORS =
                Map.of(
                    Object.class, Map.entry(methods[index++], methods[index++]),
                    boolean.class, Map.entry(methods[index++], methods[index++]),
                    byte.class, Map.entry(methods[index++], methods[index++]),
                    short.class, Map.entry(methods[index++], methods[index++]),
                    char.class, Map.entry(methods[index++], methods[index++]),
                    int.class, Map.entry(methods[index++], methods[index++]),
                    long.class, Map.entry(methods[index++], methods[index++]),
                    float.class, Map.entry(methods[index++], methods[index++]),
                    double.class, Map.entry(methods[index++], methods[index++])
                );
            STATIC_FIELD_BASE = methods[index++];
            STATIC_FIELD_OFFSET = methods[index++];
            OBJECT_FIELD_OFFSET = methods[index++];
            SHOULD_BE_INITIALIZED = methods[index++];
            ENSURE_CLASS_INITIALIZED = methods[index++];
            ALLOCATE_INSTANCE = methods[index++];
            THROW_EXCEPTION = methods[index++];
        }
    }

    /**
     * This class contains logging-related support objects for the {@code javax-jakarta-api-shim} library.
     *
     * @deprecated This class should only be used internally by the {@code javax-jakarta-api-shim} library.
     */
    @Deprecated(since = "javax-jakarta-api-shim")
    public interface Logger {
        Consumer<Object> DEBUG = System.err::println;
        Consumer<Object> INFO = System.out::println;
        BiConsumer<Object, Throwable> ERROR =
            (message, cause) -> {
                System.err.println(message);
                Optional.ofNullable(cause).ifPresent(Throwable::printStackTrace);
            };
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        Reference.reachabilityFence(ShimPatcher.STRICT);
    }
}
