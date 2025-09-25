package javax.shim;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import javassist.bytecode.Descriptor;
import javassist.expr.*;
import javassist.util.HotSwapAgent;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * This class leverages {@link javassist}'s {@link HotSwapAgent} to dynamically instrument incompatible classes at
 *   runtime to perform the following {@code javax}/{@code jakarta} type swapping, where applicable:
 * <ul>
 *   <li>Object and array instantiations</li>
 *   <li>Method and constructor invocations (target, arguments, return values)</li>
 *   <li>Field accesses</li>
 *   <li>Type casts</li>
 *   <li>{@code instanceof} checks</li>
 * </ul>
 *
 * @deprecated This class should only be used internally by the {@code javax-jakarta-api-shim} library.
 */
@Deprecated(since = "javax-jakarta-api-shim")
public class ShimPatcher extends ExprEditor {
    public static final ShimPatcher STRICT = new ShimPatcher(new ClassPool(true));
    public static final ShimPatcher LENIENT = new ShimPatcher(STRICT.classPool, true);

    private static final String HOT_SPOT_VIRTUAL_MACHINE = "sun.tools.attach.HotSpotVirtualMachine";
    private static final Set<String> UNPATCHABLE_CLASSES = Set.of();

    private final ClassPool classPool;
    private final Patch patch = clazz -> clazz.instrument(this);
    private final Set<Integer> patched = ConcurrentHashMap.newKeySet();
    private final boolean ignoreFailures;

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    protected ShimPatcher() {
        this(STRICT);
    }

    protected ShimPatcher(ShimPatcher parent) {
        this(parent.classPool, parent.ignoreFailures);
    }

    protected ShimPatcher(ClassPool classPool) {
        this(classPool, false);
    }

    protected ShimPatcher(ClassPool classPool, boolean ignoreFailures) {
        this.classPool = classPool;
        this.ignoreFailures = ignoreFailures;
    }

    //==================================================================================================================
    // Patching Implementation
    //==================================================================================================================

    @FunctionalInterface
    public interface Patch {
        void patch(CtClass clazz) throws CannotCompileException, NotFoundException, IOException, ReflectiveOperationException;
    }

    public void patch() {
        patch(ShimSupport.toJakarta(ShimSupport.STACK_WALKER.getCallerClass()));
    }

    public void patch(String... classNames) {
        patch(patch, classNames);
    }

    public void patch(Class<?>... classes) {
        patch(patch, classes);
    }

    public void patch(CtClass... classes) {
        patch(patch, classes);
    }

    public void patch(Patch patch) {
        patch(patch, ShimSupport.toJakarta(ShimSupport.STACK_WALKER.getCallerClass()));
    }

    public void patch(Patch patch, String... classNames) {
        try {
            patch(patch, classPool.get(classNames));
        } catch (NotFoundException exception) {
            if (!ignoreFailures) {
                throw new LinkageError("Failed to patch classes: " + Arrays.toString(classNames), exception);
            }
        }
    }

    public void patch(Patch patch, Class<?>... classes) {
        patch(patch, Stream.of(classes).map(Class::getName).toArray(String[]::new));
    }

    public void patch(Patch patch, CtClass... classes) {
        for (final var clazz : classes) {
            if (shouldNotPatch(clazz, patch)) {
                continue;
            }

            try {
                ShimLogger.INFO.accept("[*] Patching: " + clazz.getName());
                patch.patch(clazz);
                HotSwapAgent.redefine(Class.forName(clazz.getName(), false, classPool.getClassLoader()), clazz);
            } catch (CannotCompileException | NotFoundException | IOException | ReflectiveOperationException exception) {
                if (!ignoreFailures) {
                    throw new LinkageError("Failed to patch class: " + clazz.getName(), exception);
                }
            }
        }
    }

    //==================================================================================================================
    // ExprEditor Implementation Methods
    //==================================================================================================================

    @Override
    public void edit(NewExpr expression) throws CannotCompileException {
        replace(expression, new Replacer() {
            @Override
            public String replacement() {
                return String.format(
                    "$_ = new %s(%s);",
                    swapType(expression.getClassName()), swapParameterTypes(expression.getSignature())
                );
            }

            @Override
            public boolean replace() {
                try {
                    return expression.getConstructor() == null;
                } catch (NotFoundException exception) {
                    return shouldReplace(expression.getClassName());
                }
            }
        });
    }

    @Override
    public void edit(NewArray expression) throws CannotCompileException {
        replace(expression, new Replacer() {
            @Override
            public String replacement() throws NotFoundException {
                return String.format(
                    "$_ = new %s[%d];",
                    swapType(expression.getComponentType().getName()), expression.getDimension()
                );
            }

            @Override
            public boolean replace() {
                try {
                    return expression.getComponentType() == null;
                } catch (NotFoundException exception) {
                    return ShimSupport.isShimmable(exception);
                }
            }
        });
    }

    @Override
    public void edit(ConstructorCall expression) throws CannotCompileException {
        edit((MethodCall) expression);
    }

    @Override
    public void edit(MethodCall expression) throws CannotCompileException {
        replace(expression, new Replacer() {
            @Override
            public String replacement() throws NotFoundException {
                final var signature = expression.getSignature();
                final var returnType = Descriptor.getReturnType(signature, classPool);
                return String.format(
                    "$_ = (%s) $proceed(%s);",
                    swapType(returnType.getName()), swapParameterTypes(signature)
                );
            }

            @Override
            public boolean replace() throws NotFoundException {
                try {
                    final var member =
                        expression instanceof ConstructorCall
                            ? ((ConstructorCall) expression).getConstructor()
                            : expression.getMethod();
                    return member == null;
                } catch (NotFoundException exception) {
                    final var signature = expression.getSignature();
                    final var parameterTypes = Descriptor.getParameterTypes(signature, classPool);
                    return shouldReplace(expression.getClassName())
                        || shouldReplace(Descriptor.getReturnType(signature, classPool).getName())
                        || Stream.of(parameterTypes).map(CtClass::getName).anyMatch(ShimPatcher.this::shouldReplace);
                }
            }
        });
    }

    @Override
    public void edit(FieldAccess expression) throws CannotCompileException {
        replace(expression, new Replacer() {
            @Override
            public String replacement() {
                return String.format("$_ = %s.%s;", swapType(expression.getClassName()), expression.getFieldName());
            }

            @Override
            public boolean replace() {
                try {
                    return expression.getField() == null;
                } catch (NotFoundException exception) {
                    return shouldReplace(expression.getClassName());
                }
            }
        });
    }

    @Override
    public void edit(Instanceof expression) throws CannotCompileException {
        replace(expression, new Replacer() {
            @Override
            public String replacement() throws NotFoundException {
                return String.format("$_ = $1 instanceof %s;", swapType(expression.getType().getName()));
            }

            @Override
            public boolean replace() {
                try {
                    return expression.getType() == null;
                } catch (NotFoundException exception) {
                    return ShimSupport.isShimmable(exception);
                }
            }
        });
    }

    @Override
    public void edit(Cast expression) throws CannotCompileException {
        replace(expression, new Replacer() {
            @Override
            public String replacement() throws NotFoundException {
                return String.format("$_ = (%s) $1;", swapType(expression.getType().getName()));
            }

            @Override
            public boolean replace() {
                try {
                    return expression.getType() == null;
                } catch (NotFoundException exception) {
                    return ShimSupport.isShimmable(exception);
                }
            }
        });
    }

    @Override
    public void edit(Handler expression) throws CannotCompileException {
        try {
            if (!expression.isFinally()) {
                expression.getType();
            }
        } catch (NotFoundException exception) {
            throw new CannotCompileException(exception);
        }
    }

    //==================================================================================================================
    // Protected Helpers
    //==================================================================================================================

    @FunctionalInterface
    protected interface Replacer {
        String replacement() throws NotFoundException;

        default boolean replace() throws NotFoundException {
            return true;
        }

        default boolean recursive() {
            return false;
        }
    }

    protected void replace(Expr expression, Replacer replacer) throws CannotCompileException {
        try {
            if (replacer.replace()) {
                expression.replace(getReplacement(expression, replacer), replacer.recursive() ? this : null);
            }
        } catch (NotFoundException exception) {
            try {
                expression.replace(getReplacement(expression, replacer), replacer.recursive() ? this : null);
            } catch (NotFoundException innerException) {
                if (!ignoreFailures) {
                    throw new CannotCompileException(exception);
                }
            }
        }
    }

    protected boolean shouldReplace(String className) {
        return !UNPATCHABLE_CLASSES.contains(className)
            && (ShimSupport.isJavax(className) || ShimSupport.isJakarta(className));
    }

    protected String swapType(String className) {
        if (className.equals("void")) {
            return "$r";
        }

        return ShimSupport.isJakarta(className) ? ShimSupport.toJavax(className) : ShimSupport.toJakarta(className);
    }

    protected String swapParameterTypes(String signature) {
        return swapParameterTypes(signature, parameter -> true);
    }

    protected String swapParameterTypes(String signature, Predicate<? super CtClass> condition) {
        try {
            final var parameterTypes = Descriptor.getParameterTypes(signature, classPool);
            return IntStream
                .range(0, parameterTypes.length)
                .filter(index -> condition.test(parameterTypes[index]))
                .mapToObj(index -> String.format("(%s) $%d", swapType(parameterTypes[index].getName()), index + 1))
                .collect(Collectors.joining(", "));
        } catch (NotFoundException exception) {
            return "$$";
        }
    }

    //==================================================================================================================
    // Private Helper Methods
    //==================================================================================================================

    private boolean shouldNotPatch(CtClass clazz, Patch patch) {
        return UNPATCHABLE_CLASSES.contains(clazz.getName())
            || !ShimSupport.classExists(clazz.getName(), classPool.getClassLoader())
            || clazz.getPackageName().startsWith("java") // java, javax, javassist
            || clazz.getPackageName().startsWith("sun")
            || !patched.add(Objects.hash(clazz, patch));
    }

    private String getReplacement(Expr expression, Replacer replacer) throws NotFoundException {
        final var location = expression.where().getLongName();

        final String description;
        if (expression instanceof MethodCall) {
            final var method = (MethodCall) expression;
            final var signature = method.getSignature();
            final var parameters = Descriptor.toString(signature);
            String returnType;
            try {
                returnType = Descriptor.getReturnType(signature, classPool).getName();
            } catch (NotFoundException exception) {
                returnType = "?";
            }

            description =
                String.format("%s %s.%s%s", returnType, method.getClassName(), method.getMethodName(), parameters);
        } else {
            description = location;
        }

        final var replacement = replacer.replacement();
        ShimLogger.INFO.accept(String.format(
            "[*] Replacement %s: %s -> %s%n\tat %s(%s:%d)",
            expression.getClass().getSimpleName(),
            description,
            replacement,
            location.substring(0, location.lastIndexOf('(')),
            expression.getFileName(),
            expression.getLineNumber()
        ));
        return replacement;
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        // Set up the JVM for Javassist's HotSwapAgent.
        if (ShimSupport.classExists(HOT_SPOT_VIRTUAL_MACHINE)) {
            try {
                Unsafe.setField(Class.forName(HOT_SPOT_VIRTUAL_MACHINE).getDeclaredField("ALLOW_ATTACH_SELF"), true);
            } catch (ReflectiveOperationException exception) {
                ShimLogger.DEBUG.accept("Enable shim patching using the -Djdk.attach.allowAttachSelf JVM flag.");
            }
        }

        // Patch Spring Framework.
        STRICT.patch("org.springframework.web.filter.OncePerRequestFilter");
        STRICT.patch(
            clazz -> clazz.getDeclaredMethod("skipServletPathDetermination").setBody("return false;"),
            "org.springframework.web.util.UrlPathHelper"
        );

        // Patch Apache Tomcat/Catalina/Coyote.
        if (ShimSupport.classExists("org.apache.catalina.startup.Tomcat")) {
            STRICT.patch(
                "org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory",
                "org.springframework.boot.autoconfigure.websocket.servlet.TomcatWebSocketServletWebServerCustomizer"
            );
        }
    }
}
