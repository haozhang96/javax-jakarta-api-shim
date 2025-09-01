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
        final var clazz = STACK_WALKER.getCallerClass();
        if (!Serializable.class.isAssignableFrom(clazz)) {
            throw new UnsupportedOperationException(
                "Cannot determine serialVersionUID for non-serializable class: " + clazz.getName()
            );
        }

        final var superClass = clazz.getSuperclass();
        final var jakartaClass = superClass.getPackageName().startsWith("jakarta") ? superClass : toJakarta(clazz);
        try {
            final var serialVersionUID = jakartaClass.getDeclaredField("serialVersionUID");
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

    static <T> T proxy(Shim.Facade<T> facade, T target) {
        @SuppressWarnings("unchecked")
        final Class<T> clazz =
            (Class<T>) ((ParameterizedType) facade.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
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

    static void logEntryPoint(Class<? extends Shim> clazz, Object target) {
        if (!LOGGED_ENTRY_POINT_CLASSES.add(target.getClass())) {
            return;
        }

        final var stackTrace =
            STACK_WALKER.walk(stackFrames ->
                stackFrames
                    .skip(1L)
                    .dropWhile(stackFrame -> Shim.class.isAssignableFrom(stackFrame.getDeclaringClass()))
                    .limit(2L)
                    .map(StackWalker.StackFrame::toString)
                    .collect(Collectors.joining(System.lineSeparator() + "\t at ", System.lineSeparator() + "\t at ", ""))
            );
        System.out.format("[*] Shimming: %s -> %s%s%n", target.getClass().getName(), clazz.getName(), stackTrace);
    }

    static String toJakarta(String name) {
        return name.startsWith("javax") ? "jakarta" + name.substring("javax".length()) : name;
    }

    static Class<?> toJakarta(Class<?> clazz) {
        final var className =
            Shim.Facade.class.isAssignableFrom(clazz)
                ? ((Class<?>) ((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()[0]).getName()
                : toJakarta(clazz.getName());
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException exception) {
            throw new NoClassDefFoundError("Unknown jakarta type: " + className);
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
