package javax.shim;

import java.lang.invoke.MethodHandles;

/**
 * This class defines a reflective action (any action that throws a {@link ReflectiveOperationException}) that requires
 *   the use of a {@linkplain MethodHandles#privateLookupIn(Class, MethodHandles.Lookup) privileged lookup}.
 *
 * @deprecated This class should only be used internally by the {@code javax-jakarta-api-shim} library.
 */
@FunctionalInterface
@Deprecated(since = "javax-jakarta-api-shim")
public interface ShimReflector {
    //==================================================================================================================
    // Implementation Methods
    //==================================================================================================================

    /**
     * Perform the reflective action on a given {@link Class} using its associated
     *   {@linkplain MethodHandles#privateLookupIn(Class, MethodHandles.Lookup) privileged lookup}.
     *
     * @param lookup The privileged {@link MethodHandles.Lookup} to use for introspecting the given {@link Class}
     * @param clazz The {@link Class} to perform the reflective action on using the given privileged
     *              {@link MethodHandles.Lookup}
     *
     * @throws Throwable Any exception thrown by the reflective action
     */
    Object call(MethodHandles.Lookup lookup, Class<?> clazz) throws Throwable;

    //==================================================================================================================
    // Helper Methods
    //==================================================================================================================

    /**
     * Call a given {@link ShimReflector} for the {@link Class} with a given name using
     *   {@linkplain MethodHandles#privateLookupIn(Class, MethodHandles.Lookup) full lookup privileges} available to
     *   this class.
     *
     * @param className The name of the {@link Class} to introspect using the given {@link ShimReflector}
     * @param reflector The {@link ShimReflector} to use for performing reflective actions on the {@link Class} with the
     *                  given name
     * @param <T> The expected type of the resulting {@link ShimReflector} call
     * @param <X> The type of {@link Throwable} expected to be thrown by the given {@link ShimReflector}
     * @return The result of the {@link ShimReflector} call
     *
     * @throws X Any {@link Throwable} that may have been thrown by the given {@link ShimReflector}
     */
    static <T, X extends Throwable> T call(String className, ShimReflector reflector) throws X {
        return call(MethodHandles.lookup(), className, reflector);
    }

    /**
     * Call a given {@link ShimReflector} for a given {@link Class} using
     *   {@linkplain MethodHandles#privateLookupIn(Class, MethodHandles.Lookup) full lookup privileges} available to
     *   this class.
     *
     * @param clazz The {@link Class} to introspect using the given {@link ShimReflector}
     * @param reflector The {@link ShimReflector} to use for performing reflective actions on the given {@link Class}
     * @param <T> The expected type of the resulting {@link ShimReflector} call
     * @param <X> The type of {@link Throwable} expected to be thrown by the given {@link ShimReflector}
     * @return The result of the {@link ShimReflector} call
     *
     * @throws X Any {@link Throwable} that may have been thrown by the given {@link ShimReflector}
     */
    static <T, X extends Throwable> T call(Class<?> clazz, ShimReflector reflector) throws X {
        return call(MethodHandles.lookup(), clazz, reflector);
    }

    /**
     * Call a given {@link ShimReflector} for the {@link Class} with a given name after granting a given
     *   {@link MethodHandles.Lookup}
     *   {@linkplain MethodHandles#privateLookupIn(Class, MethodHandles.Lookup) full lookup privileges}.
     *
     * @param lookup The {@link MethodHandles.Lookup} to use for introspecting the {@link Class} with the given name
     *               using the given {@link ShimReflector}; typically passed in directly as a
     *               {@link MethodHandles#lookup()} call
     * @param className The name of the {@link Class} to introspect using the given {@link MethodHandles.Lookup} and
     *                  {@link ShimReflector}
     * @param reflector The {@link ShimReflector} to use for performing reflective actions on the {@link Class} with the
     *                  given name using the given {@link MethodHandles.Lookup}
     * @param <T> The expected type of the resulting {@link ShimReflector} call
     * @param <X> The type of {@link Throwable} expected to be thrown by the given {@link ShimReflector}
     * @return The result of the {@link ShimReflector} call
     *
     * @throws X Any {@link Throwable} that may have been thrown by the given {@link ShimReflector}
     */
    static <T, X extends Throwable> T call(
        MethodHandles.Lookup lookup,
        String className,
        ShimReflector reflector
    ) throws X {
        try {
            return call(lookup, Class.forName(className, true, lookup.lookupClass().getClassLoader()), reflector);
        } catch (ClassNotFoundException exception) {
            throw new IllegalStateException("Cannot find class to perform reflective action: " + className, exception);
        }
    }

    /**
     * Call a given {@link ShimReflector} for a given {@link Class} after granting a given {@link MethodHandles.Lookup}
     *   {@linkplain MethodHandles#privateLookupIn(Class, MethodHandles.Lookup) full lookup privileges}.
     *
     * @param lookup The {@link MethodHandles.Lookup} to use for introspecting the given {@link Class} using the given
     *               {@link ShimReflector}; typically passed in directly as a {@link MethodHandles#lookup()} call
     * @param clazz The {@link Class} to introspect using the given {@link MethodHandles.Lookup} and
     *              {@link ShimReflector}
     * @param reflector The {@link ShimReflector} to use for performing reflective actions on the given {@link Class}
     *                  using the given {@link MethodHandles.Lookup}
     * @param <T> The expected type of the resulting {@link ShimReflector} call
     * @param <X> The type of {@link Throwable} expected to be thrown by the given {@link ShimReflector}
     * @return The result of the {@link ShimReflector} call
     *
     * @throws X Any {@link Throwable} that may have been thrown by the given {@link ShimReflector}
     */
    @SuppressWarnings("unchecked")
    static <T, X extends Throwable> T call(
        MethodHandles.Lookup lookup,
        Class<?> clazz,
        ShimReflector reflector
    ) throws X {
        try {
            return (T) reflector.call(MethodHandles.privateLookupIn(clazz, lookup), clazz);
        } catch (Throwable cause) {
            throw ShimSupport.rethrow(cause);
        }
    }
}
