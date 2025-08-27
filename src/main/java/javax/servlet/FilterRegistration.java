package javax.servlet;

import javax.shim.Shim;
import java.util.EnumSet;
import java.util.Set;

/**
 * @deprecated Use {@link jakarta.servlet.FilterRegistration} instead.
 */
@Deprecated(since = "jakarta.servlet.FilterRegistration")
@SuppressWarnings("rawtypes")
public interface FilterRegistration extends jakarta.servlet.FilterRegistration, Registration {
    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see #addMappingForServletNames(EnumSet, boolean, String...)
     */
    void addMappingForServletNames(Set dispatcherTypes, boolean isMatchAfter, String... servletNames);

    /**
     * @see #addMappingForUrlPatterns(EnumSet, boolean, String...)
     */
    void addMappingForUrlPatterns(Set dispatcherTypes, boolean isMatchAfter, String... urlPatterns);

    //==================================================================================================================
    // FilterRegistration Implementation Methods
    //==================================================================================================================

    @Override
    @SuppressWarnings("unchecked")
    default void addMappingForServletNames(EnumSet dispatcherTypes, boolean isMatchAfter, String... servletNames) {
        addMappingForServletNames(
            (Set) Shim.Enum.toJakarta(jakarta.servlet.DispatcherType.class, dispatcherTypes),
            isMatchAfter,
            servletNames
        );
    }

    @Override
    @SuppressWarnings("unchecked")
    default void addMappingForUrlPatterns(EnumSet dispatcherTypes, boolean isMatchAfter, String... urlPatterns) {
        addMappingForUrlPatterns(
            (Set) Shim.Enum.toJakarta(jakarta.servlet.DispatcherType.class, dispatcherTypes),
            isMatchAfter,
            urlPatterns
        );
    }

    //==================================================================================================================
    // FilterRegistration.Dynamic Implementation
    //==================================================================================================================

    /**
     * @deprecated Use {@link jakarta.servlet.FilterRegistration.Dynamic} instead.
     */
    @Deprecated(since = "jakarta.servlet.FilterRegistration.Dynamic")
    interface Dynamic extends jakarta.servlet.FilterRegistration.Dynamic, FilterRegistration, Registration.Dynamic { }
}
