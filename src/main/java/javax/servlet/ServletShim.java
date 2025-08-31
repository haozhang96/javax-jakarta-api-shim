package javax.servlet;

import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.MappingMatch;
import javax.shim.Shim;
import javax.shim.ShimSupport;
import java.lang.annotation.Annotation;
import java.util.EventListener;
import java.util.EventObject;
import java.util.stream.Stream;

/**
 * @deprecated Use {@link jakarta.servlet} instead.
 */
@Deprecated(since = "jakarta.servlet")
public interface ServletShim extends Shim {
    //==================================================================================================================
    // Helper Methods
    //==================================================================================================================

    static void initialize() {
        Shim.initialize();
    }

    //==================================================================================================================
    // Factory Methods
    //==================================================================================================================

    @SuppressWarnings("rawtypes")
    static <S extends ServletShim> S of(Object object) {
        //==============================================================================================================
        // Specializations
        //==============================================================================================================

        if (object == null || object instanceof ServletShim) {
            return S(object);
        } else if (object instanceof jakarta.servlet.ServletException) {
            return S(of((jakarta.servlet.ServletException) object));
        } else if (object instanceof java.lang.Enum<?>) {
            return S(of((java.lang.Enum) object));
        } else if (object instanceof Annotation) {
            return S(of((Annotation) object));
        } else if (object instanceof EventListener) {
            return S(of((EventListener) object));
        } else if (object instanceof EventObject) {
            return S(of((EventObject) object));

        //==============================================================================================================
        // Implementations
        //==============================================================================================================

        } else if (object instanceof jakarta.servlet.http.Cookie) {
            return S(new Facades.Cookie(S(object)));
        } else if (object instanceof jakarta.servlet.http.HttpFilter) {
            return S(new Facades.HttpFilter(S(object)));
        } else if (object instanceof jakarta.servlet.http.HttpServlet) {
            return S(new Facades.HttpServlet(S(object)));
        } else if (object instanceof jakarta.servlet.GenericFilter) {
            return S(new Facades.GenericFilter(S(object)));
        } else if (object instanceof jakarta.servlet.GenericServlet) {
            return S(new Facades.GenericServlet(S(object)));
        } else if (object instanceof jakarta.servlet.ServletInputStream) {
            return S(new Facades.ServletInputStream(S(object)));
        } else if (object instanceof jakarta.servlet.ServletOutputStream) {
            return S(new Facades.ServletOutputStream(S(object)));

        //==============================================================================================================
        // Wrappers
        //==============================================================================================================

        } else if (object instanceof jakarta.servlet.http.HttpServletRequestWrapper) {
            return S(new Facades.HttpServletRequestWrapper(S(object)));
        } else if (object instanceof jakarta.servlet.http.HttpServletResponseWrapper) {
            return S(new Facades.HttpServletResponseWrapper(S(object)));
        } else if (object instanceof jakarta.servlet.ServletRequestWrapper) {
            return S(new Facades.ServletRequestWrapper(S(object)));
        } else if (object instanceof jakarta.servlet.ServletResponseWrapper) {
            return S(new Facades.ServletResponseWrapper(S(object)));

        //==============================================================================================================
        // Core
        //==============================================================================================================

        } else if (object instanceof jakarta.servlet.AsyncContext) {
            return S(new Facades.AsyncContext(S(object)));
        } else if (object instanceof jakarta.servlet.AsyncEvent) {
            return S(new Facades.AsyncEvent(S(object)));
        } else if (object instanceof jakarta.servlet.Filter) {
            return S(new Facades.Filter(S(object)));
        } else if (object instanceof jakarta.servlet.FilterChain) {
            return S(new Facades.FilterChain(S(object)));
        } else if (object instanceof jakarta.servlet.FilterConfig) {
            return S(new Facades.FilterConfig(S(object)));
        } else if (object instanceof jakarta.servlet.FilterRegistration.Dynamic) {
            return S(new Facades.FilterRegistration$Dynamic(S(object)));
        } else if (object instanceof jakarta.servlet.FilterRegistration) {
            return S(new Facades.FilterRegistration(S(object)));
        } else if (object instanceof jakarta.servlet.http.HttpServletMapping) {
            return S(new Facades.HttpServletMapping(S(object)));
        } else if (object instanceof jakarta.servlet.http.HttpServletRequest) {
            return S(new Facades.HttpServletRequest(S(object)));
        } else if (object instanceof jakarta.servlet.http.HttpServletResponse) {
            return S(new Facades.HttpServletResponse(S(object)));
        } else if (object instanceof jakarta.servlet.http.HttpSession) {
            return S(new Facades.HttpSession(S(object)));
        } else if (object instanceof jakarta.servlet.http.HttpUpgradeHandler) {
            return S(new Facades.HttpUpgradeHandler(S(object)));
        } else if (object instanceof jakarta.servlet.http.Part) {
            return S(new Facades.Part(S(object)));
        } else if (object instanceof jakarta.servlet.http.PushBuilder) {
            return S(new Facades.PushBuilder(S(object)));
        } else if (object instanceof jakarta.servlet.RequestDispatcher) {
            return S(new Facades.RequestDispatcher(S(object)));
        } else if (object instanceof jakarta.servlet.Servlet) {
            return S(new Facades.Servlet(S(object)));
        } else if (object instanceof jakarta.servlet.ServletConfig) {
            return S(new Facades.ServletConfig(S(object)));
        } else if (object instanceof jakarta.servlet.ServletConnection) {
            return S(new Facades.ServletConnection(S(object)));
        } else if (object instanceof jakarta.servlet.ServletContainerInitializer) {
            return S(new Facades.ServletContainerInitializer(S(object)));
        } else if (object instanceof jakarta.servlet.ServletContext) {
            return S(new Facades.ServletContext(S(object)));
        } else if (object instanceof jakarta.servlet.ServletRegistration.Dynamic) {
            return S(new Facades.ServletRegistration$Dynamic(S(object)));
        } else if (object instanceof jakarta.servlet.ServletRegistration) {
            return S(new Facades.ServletRegistration(S(object)));
        } else if (object instanceof jakarta.servlet.ServletRequest) {
            return S(new Facades.ServletRequest(S(object)));
        } else if (object instanceof jakarta.servlet.ServletResponse) {
            return S(new Facades.ServletResponse(S(object)));
        } else if (object instanceof jakarta.servlet.SessionCookieConfig) {
            return S(new Facades.SessionCookieConfig(S(object)));
        } else if (object instanceof jakarta.servlet.http.WebConnection) {
            return S(new Facades.WebConnection(S(object)));
        } else if (object instanceof jakarta.servlet.Registration.Dynamic) {
            return S(new Facades.Registration$Dynamic(S(object)));
        } else if (object instanceof jakarta.servlet.Registration) {
            return S(new Facades.Registration(S(object)));

        //==============================================================================================================
        // Others
        //==============================================================================================================

        } else if (object instanceof jakarta.servlet.ServletSecurityElement) {
            return S(new Facades.ServletSecurityElement(S(object)));
        } else if (object instanceof jakarta.servlet.HttpMethodConstraintElement) {
            return S(new Facades.HttpMethodConstraintElement(S(object)));
        } else if (object instanceof jakarta.servlet.HttpConstraintElement) {
            return S(new Facades.HttpConstraintElement(S(object)));
        } else if (object instanceof jakarta.servlet.MultipartConfigElement) {
            return S(new Facades.MultipartConfigElement(S(object)));
        }

        return ShimSupport.throwUnknownType(null, object);
    }

    static <S extends ServletException> S of(jakarta.servlet.ServletException exception) {
        if (exception == null || exception instanceof ServletShim) {
            return S(exception);
        } else if (exception instanceof jakarta.servlet.UnavailableException) {
            return S(new Facades.UnavailableException(S(exception)));
        }

        return S(new Facades.ServletException(exception));
    }

    static <S extends ServletShim> Stream<S> of(Object[] objects) {
        return Shim.of(ServletShim::of, objects);
    }

    static <S extends ServletShim> Stream<S> of(Iterable<?> objects) {
        return Shim.of(ServletShim::of, objects);
    }

    static <S extends ServletShim & Annotation> Stream<S> of(Annotation[] annotations) {
        return Shim.of(ServletShim::of, annotations);
    }

    static <S extends ServletShim> Class<? extends S> of(Class<S> shimType, Class<?> interfaceType) {
        return Shim.of(shimType, interfaceType);
    }

    //==================================================================================================================
    // Enum-specific Implementation
    //==================================================================================================================

    /**
     * @deprecated Use {@link jakarta.servlet} instead.
     */
    @Deprecated(since = "jakarta.servlet")
    interface Enum<E extends java.lang.Enum<E>> extends ServletShim, Shim.Enum<E> { }

    //==================================================================================================================
    // Private Helper Methods
    //==================================================================================================================

    private static <S extends java.lang.Enum<S>> S of(java.lang.Enum<?> enumeration) {
        if (enumeration == null || enumeration instanceof ServletShim) {
            return S(enumeration);
        } else if (enumeration instanceof jakarta.servlet.DispatcherType) {
            return S(DispatcherType.valueOf(enumeration.name()));
        } else if (enumeration instanceof jakarta.servlet.SessionTrackingMode) {
            return S(SessionTrackingMode.valueOf(enumeration.name()));
        } else if (enumeration instanceof jakarta.servlet.http.MappingMatch) {
            return S(MappingMatch.valueOf(enumeration.name()));
        } else if (enumeration instanceof jakarta.servlet.annotation.ServletSecurity.EmptyRoleSemantic) {
            return S(ServletSecurity.EmptyRoleSemantic.valueOf(enumeration.name()));
        } else if (enumeration instanceof jakarta.servlet.annotation.ServletSecurity.TransportGuarantee) {
            return S(ServletSecurity.TransportGuarantee.valueOf(enumeration.name()));
        }

        return ShimSupport.throwUnknownType(null, enumeration);
    }

    private static <S extends Annotation> S of(Annotation annotation) {
        if (annotation == null || annotation instanceof ServletShim) {
            return S(annotation);
        } else if (annotation instanceof jakarta.servlet.annotation.HandlesTypes) {
            return S(new Facades.HandlesTypes(S(annotation)));
        } else if (annotation instanceof jakarta.servlet.annotation.HttpConstraint) {
            return S(new Facades.HttpConstraint(S(annotation)));
        } else if (annotation instanceof jakarta.servlet.annotation.HttpMethodConstraint) {
            return S(new Facades.HttpMethodConstraint(S(annotation)));
        } else if (annotation instanceof jakarta.servlet.annotation.MultipartConfig) {
            return S(new Facades.MultipartConfig(S(annotation)));
        } else if (annotation instanceof jakarta.servlet.annotation.ServletSecurity) {
            return S(new Facades.ServletSecurity(S(annotation)));
        } else if (annotation instanceof jakarta.servlet.annotation.WebFilter) {
            return S(new Facades.WebFilter(S(annotation)));
        } else if (annotation instanceof jakarta.servlet.annotation.WebInitParam) {
            return S(new Facades.WebInitParam(S(annotation)));
        } else if (annotation instanceof jakarta.servlet.annotation.WebListener) {
            return S(new Facades.WebListener(S(annotation)));
        } else if (annotation instanceof jakarta.servlet.annotation.WebServlet) {
            return S(new Facades.WebServlet(S(annotation)));
        }

        return ShimSupport.throwUnknownType(null, annotation);
    }

    private static <S extends EventListener> S of(EventListener listener) {
        if (listener == null || listener instanceof ServletShim) {
            return S(listener);
        } else if (listener instanceof jakarta.servlet.AsyncListener) {
            return S(new Facades.AsyncListener(S(listener)));
        } else if (listener instanceof jakarta.servlet.http.HttpSessionActivationListener) {
            return S(new Facades.HttpSessionActivationListener(S(listener)));
        } else if (listener instanceof jakarta.servlet.http.HttpSessionAttributeListener) {
            return S(new Facades.HttpSessionAttributeListener(S(listener)));
        } else if (listener instanceof jakarta.servlet.http.HttpSessionBindingListener) {
            return S(new Facades.HttpSessionBindingListener(S(listener)));
        } else if (listener instanceof jakarta.servlet.http.HttpSessionIdListener) {
            return S(new Facades.HttpSessionIdListener(S(listener)));
        } else if (listener instanceof jakarta.servlet.http.HttpSessionListener) {
            return S(new Facades.HttpSessionListener(S(listener)));
        } else if (listener instanceof jakarta.servlet.ReadListener) {
            return S(new Facades.ReadListener(S(listener)));
        } else if (listener instanceof jakarta.servlet.ServletContextAttributeListener) {
            return S(new Facades.ServletContextAttributeListener(S(listener)));
        } else if (listener instanceof jakarta.servlet.ServletContextListener) {
            return S(new Facades.ServletContextListener(S(listener)));
        } else if (listener instanceof jakarta.servlet.ServletRequestAttributeListener) {
            return S(new Facades.ServletRequestAttributeListener(S(listener)));
        } else if (listener instanceof jakarta.servlet.ServletRequestListener) {
            return S(new Facades.ServletRequestListener(S(listener)));
        } else if (listener instanceof jakarta.servlet.WriteListener) {
            return S(new Facades.WriteListener(S(listener)));
        }

        return ShimSupport.throwUnknownType("event listener", listener);
    }

    private static <S extends EventObject> S of(EventObject event) {
        if (event == null || event instanceof ServletShim) {
            return S(event);
        } else if (event instanceof jakarta.servlet.http.HttpSessionBindingEvent) {
            return S(new Facades.HttpSessionBindingEvent(S(event)));
        } else if (event instanceof jakarta.servlet.http.HttpSessionEvent) {
            return S(new Facades.HttpSessionEvent(S(event)));
        } else if (event instanceof jakarta.servlet.ServletContextAttributeEvent) {
            return S(new Facades.ServletContextAttributeEvent(S(event)));
        } else if (event instanceof jakarta.servlet.ServletContextEvent) {
            return S(new Facades.ServletContextEvent(S(event)));
        } else if (event instanceof jakarta.servlet.ServletRequestAttributeEvent) {
            return S(new Facades.ServletRequestAttributeEvent(S(event)));
        } else if (event instanceof jakarta.servlet.ServletRequestEvent) {
            return S(new Facades.ServletRequestEvent(S(event)));
        }

        return ShimSupport.throwUnknownType("event", event);
    }

    @SuppressWarnings("unchecked")
    private static <S> S S(Object object) {
        return (S) object;
    }
}
