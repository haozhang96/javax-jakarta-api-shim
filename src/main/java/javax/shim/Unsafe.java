package javax.shim;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;

/**
 * This class exposes certain {@link sun.misc.Unsafe} mechanics to the {@code javax-jakarta-api-shim} library without
 *   requiring compile-time dependency on it.
 * <br/><br/>
 *
 * In particular, this class leverages {@link sun.misc.Unsafe}'s ability to modify {@code final} fields and instantiate
 *   objects without invoking their constructors.
 *
 * @deprecated This class should only be used internally by the {@code javax-jakarta-api-shim} library.
 * @see sun.misc.Unsafe
 */
@Deprecated(since = "javax-jakarta-api-shim")
@SuppressWarnings("unchecked")
public final class Unsafe {
    private static final Map<Class<?>, Map.Entry<MethodHandle, MethodHandle>> FIELD_ACCESSORS;
    private static final MethodHandle STATIC_FIELD_BASE;
    private static final MethodHandle STATIC_FIELD_OFFSET;
    private static final MethodHandle OBJECT_FIELD_OFFSET;
    private static final MethodHandle ENSURE_CLASS_INITIALIZED;
    private static final MethodHandle ALLOCATE_INSTANCE;
    private static final MethodHandle THROW_EXCEPTION;

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    private Unsafe() {
        throw new UnsupportedOperationException();
    }

    //==================================================================================================================
    // Helper Methods
    //==================================================================================================================

    /**
     * @see sun.misc.Unsafe#staticFieldBase(Field)
     * @see sun.misc.Unsafe#staticFieldOffset(Field)
     * @see sun.misc.Unsafe#objectFieldOffset(Field)
     * @see sun.misc.Unsafe#getObject(Object, long)
     */
    public static <T> T getField(Field field) {
        return getField(field, null);
    }

    /**
     * @see sun.misc.Unsafe#staticFieldBase(Field)
     * @see sun.misc.Unsafe#staticFieldOffset(Field)
     * @see sun.misc.Unsafe#objectFieldOffset(Field)
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
            throw ShimSupport.rethrow(cause);
        }
    }

    /**
     * @see sun.misc.Unsafe#staticFieldBase(Field)
     * @see sun.misc.Unsafe#staticFieldOffset(Field)
     * @see sun.misc.Unsafe#objectFieldOffset(Field)
     * @see sun.misc.Unsafe#putObject(Object, long, Object)
     */
    public static <T> T setField(Field field, T value) {
        return setField(field, null, value);
    }

    /**
     * @see sun.misc.Unsafe#staticFieldBase(Field)
     * @see sun.misc.Unsafe#staticFieldOffset(Field)
     * @see sun.misc.Unsafe#objectFieldOffset(Field)
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
            throw ShimSupport.rethrow(cause);
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
     * @see sun.misc.Unsafe#ensureClassInitialized(Class)
     */
    public static <T> Class<T> ensureClassInitialized(Class<T> clazz) {
        try {
            ENSURE_CLASS_INITIALIZED.invokeExact(clazz);
            return clazz;
        } catch (Throwable cause) {
            throw ShimSupport.rethrow(cause);
        }
    }

    /**
     * @see sun.misc.Unsafe#allocateInstance(Class)
     */
    public static <T> T allocateInstance(Class<T> clazz) {
        try {
            return (T) ALLOCATE_INSTANCE.invokeExact(clazz);
        } catch (Throwable cause) {
            throw ShimSupport.rethrow(cause);
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
            throw ShimSupport.rethrow(cause);
        }
    }

    //==================================================================================================================
    // Private Helper Methods
    //==================================================================================================================

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

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        final MethodHandle[] methods =
            ShimReflector.call("sun.misc.Unsafe", (lookup, unsafeClass) -> {
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
                    lookup.bind(unsafe, "ensureClassInitialized", MethodType.methodType(void.class, Class.class)),
                    lookup.bind(unsafe, "allocateInstance", MethodType.methodType(Object.class, Class.class)),
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
        ENSURE_CLASS_INITIALIZED = methods[index++];
        ALLOCATE_INSTANCE = methods[index++];
        THROW_EXCEPTION = methods[index++];
    }
}
