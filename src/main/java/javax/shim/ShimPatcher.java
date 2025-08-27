package javax.shim;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import javassist.bytecode.Descriptor;
import javassist.expr.*;
import javassist.util.HotSwapAgent;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Deprecated
final class ShimPatcher extends ExprEditor {
    private final ClassPool classPool;
    private final Patch patch = clazz -> clazz.instrument(this);
    private final boolean ignoreFailures;

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    ShimPatcher(ClassPool classPool) {
        this(classPool, true);
    }

    ShimPatcher(ClassPool classPool, boolean ignoreFailures) {
        this.classPool = classPool;
        this.ignoreFailures = ignoreFailures;

        classPool.importPackage(ShimSupport.STACK_WALKER.getCallerClass().getPackageName());
        classPool.importPackage(InputStream.class.getPackageName());
        classPool.importPackage(Map.class.getPackageName());
        classPool.importPackage(ConcurrentMap.class.getPackageName());
        classPool.importPackage(Stream.class.getPackageName());
        classPool.importPackage(Function.class.getPackageName());
    }

    //==================================================================================================================
    // Implementation Methods
    //==================================================================================================================

    void patch(String... classNames) {
        patch(patch, classNames);
    }

    void patch(Class<?>... classes) {
        patch(patch, classes);
    }

    void patch(CtClass... classes) {
        patch(patch, classes);
    }

    void patch(Patch patch, String... classNames) {
        try {
            patch(patch, classPool.get(classNames));
        } catch (NotFoundException exception) {
            if (!ignoreFailures) {
                throw new LinkageError("Failed to patch classes: " + Arrays.toString(classNames), exception);
            }
        }
    }

    void patch(Patch patch, Class<?>... classes) {
        patch(patch, Stream.of(classes).map(Class::getName).toArray(String[]::new));
    }

    void patch(Patch patch, CtClass... classes) {
        for (final var clazz : classes) {
            try {
                patch.patch(clazz);
                HotSwapAgent.redefine(Class.forName(clazz.getName()), clazz);
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
        try {
            expression.getConstructor();
        } catch (NotFoundException exception) {
            throw new CannotCompileException(exception);
        }
    }

    @Override
    public void edit(NewArray expression) throws CannotCompileException {
        try {
            expression.getComponentType();
        } catch (NotFoundException exception) {
            throw new CannotCompileException(exception);
        }
    }

    @Override
    public void edit(MethodCall expression) throws CannotCompileException {
        try {
            expression.getMethod();
        } catch (NotFoundException exception) {
            patch(expression);
        }
    }

    @Override
    public void edit(ConstructorCall expression) throws CannotCompileException {
        try {
            expression.getConstructor();
        } catch (NotFoundException exception) {
            patch(expression);
        }
    }

    private void patch(MethodCall expression) throws CannotCompileException {
        try {
            final var parameterTypes = Descriptor.getParameterTypes(expression.getSignature(), classPool);
            final var parameters =
                IntStream
                    .range(0, parameterTypes.length)
                    .mapToObj(index -> Map.entry(index, parameterTypes[index]))
                    .map(parameterType ->
                        String.format("(%s) $%d", toJakarta(parameterType.getValue().getName()), parameterType.getKey() + 1)
                    )
                    .collect(Collectors.joining(", "));
            expression.replace(String.format("$_ = $proceed(%s);", parameters), this);
        } catch (NotFoundException exception) {
            throw new CannotCompileException(exception);
        }
    }

    @Override
    public void edit(FieldAccess expression) throws CannotCompileException {
        try {
            expression.getField();
        } catch (NotFoundException exception) {
            expression.replace(String.format("$_ = %s.%s;", toJakarta(expression.getClassName()), expression.getFieldName()), this);
        }
    }

    @Override
    public void edit(Instanceof expression) throws CannotCompileException {
        try {
            expression.getType();
        } catch (NotFoundException exception) {
            throw new CannotCompileException(exception);
        }
    }

    @Override
    public void edit(Cast expression) throws CannotCompileException {
        try {
            expression.getType();
        } catch (NotFoundException exception) {
            throw new CannotCompileException(exception);
        }
    }

    @Override
    public void edit(Handler expression) throws CannotCompileException {
        try {
            expression.getType();
        } catch (NotFoundException exception) {
            throw new CannotCompileException(exception);
        }
    }

    //==================================================================================================================
    // Helpers
    //==================================================================================================================

    @FunctionalInterface
    interface Patch {
        void patch(CtClass clazz) throws CannotCompileException, NotFoundException, IOException, ReflectiveOperationException;
    }

    /**
     * @implNote This method is required to resolve a circular class-loading issue with {@link ShimSupport}.
     */
    private String toJakarta(String name) {
        return ShimSupport.toJakarta(name);
    }
}
