package javax.shim;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Deprecated(since = "javax.shim")
public final class ShimSupport {
    public static final StackWalker STACK_WALKER = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
    public static final ShimPatcher PATCHER = ShimPatcher.INSTANCE;

    private static final Set<Class<?>> LOGGED_ENTRY_POINT_CLASSES = Collections.newSetFromMap(new WeakHashMap<>());
    private static final Set<String> JAVAX_PACKAGES =
        new HashSet<>(Set.of(
            "javax.activation", "javax.annotation", "javax.el", "javax.inject", "javax.interceptor", "javax.jms",
            "javax.jws", "javax.servlet", "javax.transaction", "javax.validation", "javax.websocket", "javax.ws.rs",
            "javax.xml.bind", "javax.xml.soap", "javax.xml.ws"
        ));
    private static final Set<String> JAKARTA_PACKAGES =
        JAVAX_PACKAGES
            .stream()
            .map(packageName -> "jakarta" + packageName.substring("javax".length()))
            .collect(Collectors.toSet());

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    private ShimSupport() {
        throw new UnsupportedOperationException();
    }

    //==================================================================================================================
    // Support Methods
    //==================================================================================================================

    public static Class<?> toJakarta() {
        return toJakarta(STACK_WALKER.getCallerClass());
    }

    public static Class<?> toJakarta(Class<?> clazz) {
        final var className =
            Shim.Facade.class.isAssignableFrom(clazz)
                ? Shim.Facade.getTargetClass(clazz.asSubclass(Shim.Facade.class)).getName()
                : toJakarta(clazz.getName());
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException exception) {
            throw new NoClassDefFoundError("Unknown jakarta type: " + className);
        }
    }

    public static String toJakarta(String className) {
        return isJavax(className) ? "jakarta" + className.substring("javax".length()) : className;
    }

    public static String toJavax(String className) {
        return isJakarta(className) ? "javax" + className.substring("jakarta".length()) : className;
    }

    public static boolean isJakarta(String className) {
        return isInPackage(JAKARTA_PACKAGES, className);
    }

    public static boolean isJavax(String className) {
        return isInPackage(JAVAX_PACKAGES, className);
    }

    public static MethodHandles.Lookup reflect(String className) {
        return reflect(MethodHandles.lookup(), className);
    }

    public static MethodHandles.Lookup reflect(Class<?> clazz) {
        return reflect(MethodHandles.lookup(), clazz);
    }

    public static <T> T reflect(String className, ReflectiveAction action) {
        return reflect(MethodHandles.lookup(), className, action);
    }

    public static <T> T reflect(Class<?> clazz, ReflectiveAction action) {
        return reflect(MethodHandles.lookup(), clazz, action);
    }

    public static MethodHandles.Lookup reflect(MethodHandles.Lookup lookup, String className) {
        return reflect(lookup, className, (lookup$, clazz$) -> lookup$);
    }

    public static MethodHandles.Lookup reflect(MethodHandles.Lookup lookup, Class<?> clazz) {
        return reflect(lookup, clazz, (lookup$, clazz$) -> lookup$);
    }

    public static <T> T reflect(MethodHandles.Lookup lookup, String className, ReflectiveAction action) {
        try {
            return reflect(lookup, Class.forName(className, true, lookup.lookupClass().getClassLoader()), action);
        } catch (ClassNotFoundException exception) {
            throw new IllegalStateException("Cannot find class to perform reflective action: " + className, exception);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T reflect(MethodHandles.Lookup lookup, Class<?> clazz, ReflectiveAction action) {
        try {
            return (T) action.apply(MethodHandles.privateLookupIn(clazz, lookup), clazz);
        } catch (Throwable cause) {
            throw new IllegalStateException("Failed to perform reflective action on class: " + clazz.getName(), cause);
        }
    }

    public static void ensureInitialized(Class<?>... classes) {
        for (final var clazz : classes) {
            try {
                Class.forName(clazz.getName(), true, clazz.getClassLoader());
            } catch (ClassNotFoundException exception) {
                throw new InternalError(exception);
            }
        }
    }

    public static <T> Stream<T> stream(Iterable<T> iterable) {
        return iterable instanceof Collection<?>
            ? ((Collection<T>) iterable).stream()
            : StreamSupport.stream(iterable.spliterator(), false);
    }

    public static long getSerialVersionUID() {
        final var clazz = STACK_WALKER.getCallerClass();
        if (!Serializable.class.isAssignableFrom(clazz)) {
            throw new UnsupportedOperationException("Not a serializable class: " + clazz.getName());
        }

        try {
            return getSerialVersionUID(toJakarta(clazz));
        } catch (IllegalStateException | NoClassDefFoundError exception) {
            var superClass = clazz;
            do {
                superClass = superClass.getSuperclass();
            } while (superClass != null && !superClass.getPackageName().startsWith("jakarta"));

            if (superClass != null) {
                try {
                    return getSerialVersionUID(superClass);
                } catch (IllegalStateException innerException) {
                    // Ignore.
                }
            }
        }

        throw new UnsupportedOperationException("Failed to determine serialVersionUID for class: " + clazz.getName());
    }

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
    // Helpers
    //==================================================================================================================

    @FunctionalInterface
    public interface ReflectiveAction {
        Object apply(MethodHandles.Lookup lookup, Class<?> clazz) throws Throwable;
    }

    //==================================================================================================================
    // Package-private Support Methods
    //==================================================================================================================

    static <T> T proxy(Shim.Facade<T> facade, T target) {
        final var clazz = facade.getTargetClass();
        if (!clazz.isInterface()) {
            return target;
        }

        return clazz.cast(Proxy.newProxyInstance(
            target.getClass().getClassLoader(),
            new Class<?>[] {clazz, Serializable.class, Cloneable.class},
            (proxy, method, arguments) -> {
                try {
                    return method.invoke(target, arguments);
                } catch (InvocationTargetException exception) {
                    Throwable cause = exception;
                    do {
                        cause = cause.getCause();
                    } while (cause != null && !(cause instanceof LinkageError));

                    if (cause == null) {
                        throw exception.getCause();
                    } else {
                        PATCHER.patch(cause.getStackTrace()[0].getClassName());
                        PATCHER.patch(method.getDeclaringClass());
//                        STACK_WALKER.walk(stackFrames ->
//                            stackFrames
//                                .skip(1L)
//                                .map(StackWalker.StackFrame::getDeclaringClass)
//                                .dropWhile(clazz$ -> Proxy.isProxyClass(clazz$) || Shim.class.isAssignableFrom(clazz$))
//                                .findFirst()
//                        ).ifPresent(PATCHER::patch);
                    }
                }

                try {
                    return method.invoke(target, arguments);
                } catch (InvocationTargetException exception) {
                    throw exception.getCause();
                }
            }
        ));
    }

    static void logEntryPoint(Class<? extends Shim> shimClass, Class<?> targetClass) {
        if (!LOGGED_ENTRY_POINT_CLASSES.add(targetClass)) {
            return;
        }

        final var stackTrace =
            STACK_WALKER.walk(stackFrames ->
                stackFrames
                    .skip(1L)
                    .dropWhile(stackFrame ->
                        stackFrame.getDeclaringClass().getPackageName().startsWith("javax")
                            || Shim.class.isAssignableFrom(stackFrame.getDeclaringClass())
                    )
                    .limit(2L)
                    .map(StackWalker.StackFrame::toString)
                    .collect(Collectors.joining(System.lineSeparator() + "\t at ", System.lineSeparator() + "\t at ", ""))
            );
        System.out.format("[*] Shimming: %s -> %s%s%n", targetClass.getName(), shimClass.getName(), stackTrace);
    }

    //==================================================================================================================
    // Private Helper Methods
    //==================================================================================================================

    private static long getSerialVersionUID(Class<?> clazz) {
        return reflect(clazz, (lookup, ignored) ->
            lookup
                .findStaticVarHandle(clazz, "serialVersionUID", long.class)
                .get()
        );
    }

    private static boolean isInPackage(Collection<String> packageNames, String className) {
        final var packageName =
            className.indexOf('.') != -1 ? className.substring(0, className.lastIndexOf('.')) : className;
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
        // Spring Framework
        PATCHER.patch("org.springframework.web.filter.OncePerRequestFilter");
        PATCHER.patch(
            clazz -> clazz.getDeclaredMethod("skipServletPathDetermination").setBody("return false;"),
            "org.springframework.web.util.UrlPathHelper"
        );
        PATCHER.patch(
            "org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory",
            "org.springframework.boot.autoconfigure.websocket.servlet.TomcatWebSocketServletWebServerCustomizer"
        );
//        PATCHER.patch(
//            "org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory",
//            "io.undertow.servlet.core.DeploymentManagerImpl"
//        );

        // Apache Tomcat/Catalina/Coyote
        PATCHER.patch("org.apache.catalina.core.ApplicationFilterRegistration");
    }
}
