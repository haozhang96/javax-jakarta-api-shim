package javax.shim;

import javassist.ClassPool;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Deprecated
public final class ShimSupport {
    static final StackWalker STACK_WALKER = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);

    private static final ShimPatcher PATCHER = new ShimPatcher(ClassPool.getDefault());
    private static final Set<Class<?>> LOGGED_ENTRY_POINT_CLASSES = Collections.newSetFromMap(new WeakHashMap<>());

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    private ShimSupport() {
        throw new UnsupportedOperationException();
    }

    //==================================================================================================================
    // Support Methods
    //==================================================================================================================

    public static long getSerialVersionUID() {
        return getSerialVersionUID(STACK_WALKER.getCallerClass().getSuperclass());
    }

    public static long getSerialVersionUID(Class<?> clazz) {
        try {
            final var serialVersionUID = clazz.getDeclaredField("serialVersionUID");
            return serialVersionUID.trySetAccessible() ? serialVersionUID.getLong(null) : 1L; // Default to 1L.
        } catch (ReflectiveOperationException exception) {
            throw new UnsupportedOperationException(
                "Failed to determine serialVersionUID for class: " + clazz.getName(),
                exception
            );
        }
    }

    public static <T> T throwUnknownType(String label, Object object) {
        final String packageName = STACK_WALKER.getCallerClass().getPackageName();
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

    @SuppressWarnings("unchecked")
    static <T> T proxy(Shim.Facade<T> facade, T target) {
        final var proxyType =
            (Class<?>) ((ParameterizedType) facade.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        if (!proxyType.isInterface()) {
            return target;
        }

        return (T) Proxy.newProxyInstance(
            target.getClass().getClassLoader(),
            new Class<?>[] {proxyType, Serializable.class, Cloneable.class},
            (proxy, method, arguments) -> {
                try {
                    return method.invoke(target, arguments);
                } catch (InvocationTargetException exception) {
                    final var cause = exception.getCause();
                    if (!(cause instanceof LinkageError) && !(cause.getCause() instanceof LinkageError)) {
                        throw cause;
                    }

                    PATCHER.patch(method.getDeclaringClass());
                    return method.invoke(target, arguments);
                }
            }
        );
    }

    static void logEntryPoint(Class<? extends Shim> shimClass, Object shimTarget) {
        if (!LOGGED_ENTRY_POINT_CLASSES.add(shimTarget.getClass())) {
            return;
        }

        final var stackTrace =
            STACK_WALKER.walk(stackFrames ->
                stackFrames
                    .skip(1L)
                    .dropWhile(stackFrame -> Shim.class.isAssignableFrom(stackFrame.getDeclaringClass()))
                    .limit(1L)
                    .map(StackWalker.StackFrame::toString)
                    .collect(Collectors.joining(System.lineSeparator() + "\t", System.lineSeparator() + "\t", ""))
            );
        System.err.format("Shimming: %s -> %s%s%n", shimTarget.getClass().getName(), shimClass.getName(), stackTrace);
    }

    static String toJakarta(String name) {
        return name.startsWith("javax") ? "jakarta" + name.substring("javax".length()) : name;
    }

    @SuppressWarnings("unchecked")
    static <T> Class<T> toJakarta(Class<?> clazz) {
        final var className = toJakarta(clazz.getName());
        try {
            return (Class<T>) Class.forName(className);
        } catch (ClassNotFoundException exception) {
            throw new LinkageError("Unknown jakarta type: " + className, exception);
        }
    }

    static <T> Stream<T> stream(Iterable<T> iterable) {
        return iterable instanceof Collection<?>
            ? ((Collection<T>) iterable).stream()
            : StreamSupport.stream(iterable.spliterator(), false);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        // Spring Framework
        PATCHER.patch("org.springframework.web.filter.OncePerRequestFilter");
//        PATCHER.patch(
//            "org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory",
//            "io.undertow.servlet.core.DeploymentManagerImpl"
//        );
        PATCHER.patch(
            "org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory",
            "org.springframework.boot.autoconfigure.websocket.servlet.TomcatWebSocketServletWebServerCustomizer",
            "org.springframework.web.util.ServletRequestPathUtils$Servlet4Delegate"
        );
        PATCHER.patch(
            clazz -> clazz.getDeclaredMethod("skipServletPathDetermination").setBody("return false;"),
            "org.springframework.web.util.UrlPathHelper"
        );

        // Apache Tomcat/Catalina/Coyote
        PATCHER.patch("org.apache.catalina.core.ApplicationFilterRegistration");
    }
}
