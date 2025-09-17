package javax.shim;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.ref.Reference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
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

    private static final Map<String, Boolean> CLASS_EXISTENCE = new ConcurrentHashMap<>();
    private static final Map<String, String> JAVAX_TO_JAKARTA_CLASS_NAMES = new ConcurrentHashMap<>();
    private static final Map<String, String> JAKARTA_TO_JAVAX_CLASS_NAMES = new ConcurrentHashMap<>();
    private static final Set<Class<?>> INITIALIZED_CLASSES = Collections.newSetFromMap(new WeakHashMap<>());
    private static final Set<Class<?>> LOGGED_ENTRY_POINT_CLASSES = Collections.newSetFromMap(new WeakHashMap<>());
    private static final String JAVAX = "javax.";
    private static final String JAKARTA = "jakarta.";
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
     * Determine whether the {@link Class} with a given name is a {@code javax} class.
     *
     * @param className The name of the {@link Class} to determine whether it's a {@code javax} class
     */
    public static boolean isJavax(String className) {
        return JAVAX_TO_JAKARTA_CLASS_NAMES.containsKey(className)
            || JAKARTA_TO_JAVAX_CLASS_NAMES.containsValue(className)
            || classExists(className) && isInPackage(JAVAX_PACKAGES, className);
    }

    /**
     * Determine whether the {@link Class} with a given name is a {@code jakarta} class.
     *
     * @param className The name of the {@link Class} to determine whether it's a {@code jakarta} class
     */
    public static boolean isJakarta(String className) {
        return JAKARTA_TO_JAVAX_CLASS_NAMES.containsKey(className)
            || JAVAX_TO_JAKARTA_CLASS_NAMES.containsValue(className)
            || classExists(className) && isInPackage(JAKARTA_PACKAGES, className);
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
     * Convert a given {@code jakarta} class name into its {@code javax} counterpart.
     * <br/><br/>
     *
     * <b>Note:</b> The returned {@code javax} class name may not exist; use {@link #toJavax(Class)} instead.
     *
     * @param className The {@code jakarta} class name to convert into its {@code javax} counterpart
     */
    public static String toJavax(String className) {
        if (!isJakarta(className)) {
            return className;
        }

        return JAKARTA_TO_JAVAX_CLASS_NAMES.computeIfAbsent(className, jakartaClassName -> {
            final var javaxClassName = JAVAX + className.substring(JAKARTA.length());
            JAVAX_TO_JAKARTA_CLASS_NAMES.putIfAbsent(javaxClassName, jakartaClassName); // Bi-directional mapping
            return javaxClassName;
        });
    }

    /**
     * Convert a given {@code jakarta} {@link Class} into its {@code javax} counterpart.
     *
     * @param clazz The {@code jakarta} {@link Class} to convert into its {@code javax} counterpart
     */
    public static Class<?> toJavax(Class<?> clazz) {
        final var className = toJavax(clazz.getName());
        try {
            return Class.forName(className, true, getClassLoader(clazz));
        } catch (ClassNotFoundException exception) {
            throw new NoClassDefFoundError("Unknown javax type: " + className);
        }
    }

    /**
     * Convert the current {@code javax} {@link Class} invoking this method into its {@code jakarta} counterpart.
     */
    public static Class<?> toJakarta() {
        return toJakarta(STACK_WALKER.getCallerClass());
    }

    /**
     * Convert a given {@code javax} class name into its {@code jakarta} counterpart.
     * <br/><br/>
     *
     * <b>Note:</b> The returned {@code jakarta} class name may not exist; use {@link #toJakarta(Class)} instead.
     *
     * @param className The {@code javax} class name to convert into its {@code jakarta} counterpart
     */
    public static String toJakarta(String className) {
        if (!isJavax(className)) {
            return className;
        }

        return JAVAX_TO_JAKARTA_CLASS_NAMES.computeIfAbsent(className, javaxClassName -> {
            final var jakartaClassName = JAKARTA + className.substring(JAVAX.length());
            JAKARTA_TO_JAVAX_CLASS_NAMES.putIfAbsent(jakartaClassName, javaxClassName); // Bi-directional mapping
            return jakartaClassName;
        });
    }

    /**
     * Convert a given {@code javax} {@link Class} into its {@code jakarta} counterpart.
     *
     * @param clazz The {@code javax} {@link Class} to convert into its {@code jakarta} counterpart
     */
    public static Class<?> toJakarta(Class<?> clazz) {
        var className = toJakarta(clazz.getName());
        if (!classExists(className)) {
            // Try walking up the class hierarchy to see if it extends a jakarta class.
            className =
                Stream
                    .<Class<?>>iterate(clazz.getSuperclass(), Objects::nonNull, Class::getSuperclass)
                    .map(Class::getName)
                    .map(ShimSupport::toJakarta)
                    .dropWhile(Predicate.not(ShimSupport::classExists))
                    .findFirst()
                    .orElse(className);
            JAVAX_TO_JAKARTA_CLASS_NAMES.replace(clazz.getName(), className);
        }

        try {
            return Class.forName(className, true, getClassLoader(clazz));
        } catch (ClassNotFoundException exception) {
            throw new NoClassDefFoundError("Unknown jakarta type: " + className);
        }
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
     * Determine whether the {@link Class} with a given name exists under the {@link ClassLoader} of the {@link Class}
     *   invoking this method.
     *
     * @param className The name of the {@link Class} to determine whether it exists under the {@link ClassLoader} of
     *                  the {@link Class} invoking this method
     */
    public static boolean classExists(String className) {
        return classExists(className, getClassLoader(STACK_WALKER.getCallerClass()));
    }

    /**
     * Determine whether the {@link Class} with a given name exists under a given {@link ClassLoader}.
     *
     * @param className The name of the {@link Class} to determine whether it exists under the given {@link ClassLoader}
     * @param classLoader The {@link ClassLoader} to use for determining the existence of the {@link Class} with the
     *                    given name
     */
    public static boolean classExists(String className, ClassLoader classLoader) {
        return className != null && CLASS_EXISTENCE.computeIfAbsent(className, ignored -> {
            try {
                Class.forName(className, false, classLoader);
                return true;
            } catch (ClassNotFoundException exception) {
                return false;
            }
        });
    }

    /**
     * Determine the concrete {@link ClassLoader} to use for a given {@link Class}, if possible.
     *
     * @param clazz The {@link Class} to determine the concrete {@link ClassLoader} to use for
     */
    public static ClassLoader getClassLoader(Class<?> clazz) {
        final var callerClass = STACK_WALKER.getCallerClass();
        return getClassLoader(Objects.requireNonNullElse(clazz.getClassLoader(), callerClass.getClassLoader()));
    }

    /**
     * Determine the concrete {@link ClassLoader} to use for a given potentially {@code null} {@link ClassLoader}, if
     *   possible.
     *
     * @param classLoader The potentially {@code null} {@link ClassLoader} to determine the concrete {@link ClassLoader}
     *                    to use for
     */
    public static ClassLoader getClassLoader(ClassLoader classLoader) {
        return Optional
            .ofNullable(classLoader)
            .or(() -> Optional.ofNullable(Thread.currentThread().getContextClassLoader()))
            .or(() -> Optional.ofNullable(STACK_WALKER.getCallerClass().getClassLoader()))
            .orElseGet(ClassLoader::getSystemClassLoader);
    }

    /**
     * Ensure that a given list of {@link Class}(es) have been initialized.
     *
     * @param classes The {@link Class}(es) to ensure initialization for
     *
     * @see sun.misc.Unsafe#ensureClassInitialized(Class)
     */
    public static void ensureInitialized(Class<?>... classes) {
        for (final var clazz : classes) {
            if (INITIALIZED_CLASSES.add(clazz)) {
                Unsafe.ensureClassInitialized(clazz);
            }
        }
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
     * Determine the {@code serialVersionUID} to use for the {@code javax} {@link Class} invoking this method by
     *   inspecting its {@code jakarta} counterpart.
     *
     * @throws UnsupportedOperationException An exception indicating a failure to determine the {@code serialVersionUID}
     *                                       to use for the {@code javax} {@link Class} invoking this method
     */
    public static long getSerialVersionUID() {
        final var clazz = STACK_WALKER.getCallerClass();
        if (!isJavax(clazz.getName())) {
            throw new UnsupportedOperationException("Not a javax class: " + clazz.getName());
        } else if (!Serializable.class.isAssignableFrom(clazz)) {
            throw new UnsupportedOperationException("Not a serializable class: " + clazz.getName());
        }

        try {
            return getSerialVersionUID(toJakarta(clazz));
        } catch (IllegalStateException exception) {
            throw new UnsupportedOperationException("Cannot determine serialVersionUID for class: " + clazz.getName());
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
        final var packageName = STACK_WALKER.getCallerClass().getPackageName();
        final Class<?> type;
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
            packageName, label != null ? label + " " : "", type.getName()
        ));
    }

    //==================================================================================================================
    // Package-private Support Methods
    //==================================================================================================================

    static void logEntryPoint(Class<? extends Shim> shimClass, Class<?> targetClass) {
        if (!LOGGED_ENTRY_POINT_CLASSES.add(targetClass)) {
            return;
        }

        final var stackTrace =
            STACK_WALKER.walk(stackFrames ->
                stackFrames
                    .skip(1L)
                    .dropWhile(stackFrame ->
                        isJavax(stackFrame.getClassName())
                            || Shim.class.isAssignableFrom(stackFrame.getDeclaringClass())
                    )
                    .limit(1L)
                    .map(StackWalker.StackFrame::toString)
                    .collect(Collectors.joining(System.lineSeparator() + "\tat ", System.lineSeparator() + "\tat ", ""))
            );
        System.out.format("[*] Shimming: %s -> %s%s%n", targetClass.getName(), shimClass.getName(), stackTrace);
    }

    //==================================================================================================================
    // Private Helper Methods
    //==================================================================================================================

    private static long getSerialVersionUID(Class<?> clazz) {
        return ShimReflector.call(clazz, (lookup, ignored) ->
            lookup
                .findStaticVarHandle(clazz, "serialVersionUID", long.class)
                .get()
        );
    }

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

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        Reference.reachabilityFence(ShimPatcher.STRICT);
    }
}
