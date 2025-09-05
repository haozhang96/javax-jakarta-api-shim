package javax.servlet;

import javax.shim.Shim;
import javax.shim.ShimSupport;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Principal;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * This interface contains {@link jakarta.servlet}-to-{@link javax.servlet} facades used for wrapping Jakarta Servlet
 *   objects into their Java Servlet counterparts.
 *
 * @deprecated Use {@link jakarta.servlet} instead.
 */
@Deprecated(since = "jakarta.servlet")
@SuppressWarnings("all")
interface Facades {
    //==================================================================================================================
    // Annotations
    //==================================================================================================================

    final class HandlesTypes extends ServletShim.Facade.Annotation<jakarta.servlet.annotation.HandlesTypes> implements javax.servlet.annotation.HandlesTypes, ServletShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        HandlesTypes(jakarta.servlet.annotation.HandlesTypes target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Class<?>[] value() {
            return target.value();
        }
    }

    final class HttpConstraint extends ServletShim.Facade.Annotation<jakarta.servlet.annotation.HttpConstraint> implements javax.servlet.annotation.HttpConstraint, ServletShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        HttpConstraint(jakarta.servlet.annotation.HttpConstraint target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.servlet.annotation.ServletSecurity.EmptyRoleSemantic value() {
            return ServletShim.of(target.value());
        }

        @Override
        public javax.servlet.annotation.ServletSecurity.TransportGuarantee transportGuarantee() {
            return ServletShim.of(target.transportGuarantee());
        }

        @Override
        public String[] rolesAllowed() {
            return target.rolesAllowed();
        }
    }

    final class HttpMethodConstraint extends ServletShim.Facade.Annotation<jakarta.servlet.annotation.HttpMethodConstraint> implements javax.servlet.annotation.HttpMethodConstraint, ServletShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        HttpMethodConstraint(jakarta.servlet.annotation.HttpMethodConstraint target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String value() {
            return target.value();
        }

        @Override
        public javax.servlet.annotation.ServletSecurity.EmptyRoleSemantic emptyRoleSemantic() {
            return ServletShim.of(target.value());
        }

        @Override
        public javax.servlet.annotation.ServletSecurity.TransportGuarantee transportGuarantee() {
            return ServletShim.of(target.transportGuarantee());
        }

        @Override
        public String[] rolesAllowed() {
            return target.rolesAllowed();
        }
    }

    final class MultipartConfig extends ServletShim.Facade.Annotation<jakarta.servlet.annotation.MultipartConfig> implements javax.servlet.annotation.MultipartConfig, ServletShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        MultipartConfig(jakarta.servlet.annotation.MultipartConfig target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String location() {
            return target.location();
        }

        @Override
        public long maxFileSize() {
            return target.maxFileSize();
        }

        @Override
        public long maxRequestSize() {
            return target.maxRequestSize();
        }

        @Override
        public int fileSizeThreshold() {
            return target.fileSizeThreshold();
        }
    }

    final class ServletSecurity extends ServletShim.Facade.Annotation<jakarta.servlet.annotation.ServletSecurity> implements javax.servlet.annotation.ServletSecurity, ServletShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ServletSecurity(jakarta.servlet.annotation.ServletSecurity target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.servlet.annotation.HttpConstraint value() {
            return ServletShim.of(target.value());
        }

        @Override
        public javax.servlet.annotation.HttpMethodConstraint[] httpMethodConstraints() {
            return ServletShim
                .of(target.httpMethodConstraints())
                .toArray(javax.servlet.annotation.HttpMethodConstraint[]::new);
        }
    }

    final class WebFilter extends ServletShim.Facade.Annotation<jakarta.servlet.annotation.WebFilter> implements javax.servlet.annotation.WebFilter, ServletShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        WebFilter(jakarta.servlet.annotation.WebFilter target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String description() {
            return target.description();
        }

        @Override
        public String displayName() {
            return target.displayName();
        }

        @Override
        public javax.servlet.annotation.WebInitParam[] initParams() {
            return ServletShim
                .of(target.initParams())
                .toArray(javax.servlet.annotation.WebInitParam[]::new);
        }

        @Override
        public String filterName() {
            return target.filterName();
        }

        @Override
        public String smallIcon() {
            return target.smallIcon();
        }

        @Override
        public String largeIcon() {
            return target.largeIcon();
        }

        @Override
        public String[] servletNames() {
            return target.servletNames();
        }

        @Override
        public String[] value() {
            return target.value();
        }

        @Override
        public String[] urlPatterns() {
            return target.urlPatterns();
        }

        @Override
        public javax.servlet.DispatcherType[] dispatcherTypes() {
            return ServletShim
                .<javax.servlet.DispatcherType>of(target.dispatcherTypes())
                .toArray(javax.servlet.DispatcherType[]::new);
        }

        @Override
        public boolean asyncSupported() {
            return target.asyncSupported();
        }
    }

    final class WebInitParam extends ServletShim.Facade.Annotation<jakarta.servlet.annotation.WebInitParam> implements javax.servlet.annotation.WebInitParam, ServletShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        WebInitParam(jakarta.servlet.annotation.WebInitParam target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String name() {
            return target.name();
        }

        @Override
        public String value() {
            return target.value();
        }

        @Override
        public String description() {
            return target.description();
        }
    }

    final class WebListener extends ServletShim.Facade.Annotation<jakarta.servlet.annotation.WebListener> implements javax.servlet.annotation.WebListener, ServletShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        WebListener(jakarta.servlet.annotation.WebListener target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String value() {
            return target.value();
        }
    }

    final class WebServlet extends ServletShim.Facade.Annotation<jakarta.servlet.annotation.WebServlet> implements javax.servlet.annotation.WebServlet, ServletShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        WebServlet(jakarta.servlet.annotation.WebServlet target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String name() {
            return target.name();
        }

        @Override
        public String[] value() {
            return target.value();
        }

        @Override
        public String[] urlPatterns() {
            return target.urlPatterns();
        }

        @Override
        public int loadOnStartup() {
            return target.loadOnStartup();
        }

        @Override
        public javax.servlet.annotation.WebInitParam[] initParams() {
            return ServletShim
                .of(target.initParams())
                .toArray(javax.servlet.annotation.WebInitParam[]::new);
        }

        @Override
        public boolean asyncSupported() {
            return target.asyncSupported();
        }

        @Override
        public String smallIcon() {
            return target.smallIcon();
        }

        @Override
        public String largeIcon() {
            return target.largeIcon();
        }

        @Override
        public String description() {
            return target.description();
        }

        @Override
        public String displayName() {
            return target.displayName();
        }
    }

    //==================================================================================================================
    // Classes
    //==================================================================================================================

    final class AsyncContext extends ServletShim.Facade<jakarta.servlet.AsyncContext> implements javax.servlet.AsyncContext {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        AsyncContext(jakarta.servlet.AsyncContext target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void dispatch(javax.servlet.ServletContext context, String path) {
            target.dispatch(context, path);
        }

        @Override
        public void dispatch(jakarta.servlet.ServletContext context, String path) {
            target.dispatch(context, path);
        }

        @Override
        public void addListener(javax.servlet.AsyncListener listener) {
            target.addListener(listener);
        }

        @Override
        public void addListener(jakarta.servlet.AsyncListener listener) {
            target.addListener(listener);
        }

        @Override
        public void addListener(
            javax.servlet.AsyncListener listener,
            javax.servlet.ServletRequest request,
            javax.servlet.ServletResponse response
        ) {
            target.addListener(listener, request, response);
        }

        @Override
        public void addListener(
            jakarta.servlet.AsyncListener listener,
            jakarta.servlet.ServletRequest request,
            jakarta.servlet.ServletResponse response
        ) {
            target.addListener(listener, request, response);
        }

        @Override
        public javax.servlet.AsyncListener createListener(Class clazz) throws javax.servlet.ServletException {
            try {
                return ServletShim.of(target.createListener(clazz.asSubclass(jakarta.servlet.AsyncListener.class)));
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public javax.servlet.ServletResponse getResponse() {
            return ServletShim.of(target.getResponse());
        }

        @Override
        public javax.servlet.ServletRequest getRequest() {
            return ServletShim.of(target.getRequest());
        }

        @Override
        public boolean hasOriginalRequestAndResponse() {
            return target.hasOriginalRequestAndResponse();
        }

        @Override
        public void dispatch() {
            target.dispatch();
        }

        @Override
        public void dispatch(String path) {
            target.dispatch(path);
        }

        @Override
        public void complete() {
            target.complete();
        }

        @Override
        public void start(Runnable run) {
            target.start(run);
        }

        @Override
        public void setTimeout(long timeout) {
            target.setTimeout(timeout);
        }

        @Override
        public long getTimeout() {
            return target.getTimeout();
        }
    }

    final class AsyncEvent extends javax.servlet.AsyncEvent {
        private final jakarta.servlet.AsyncEvent target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        AsyncEvent(jakarta.servlet.AsyncEvent target) {
            super(
                ServletShim.of(target.getAsyncContext()),
                ServletShim.of(target.getSuppliedRequest()),
                ServletShim.of(target.getSuppliedResponse()),
                target.getThrowable()
            );
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.servlet.AsyncContext getAsyncContext() {
            return ServletShim.of(target.getAsyncContext());
        }

        @Override
        public javax.servlet.ServletRequest getSuppliedRequest() {
            return ServletShim.of(target.getSuppliedRequest());
        }

        @Override
        public javax.servlet.ServletResponse getSuppliedResponse() {
            return ServletShim.of(target.getSuppliedResponse());
        }

        @Override
        public Throwable getThrowable() {
            return target.getThrowable();
        }
    }

    final class AsyncListener extends ServletShim.Facade<jakarta.servlet.AsyncListener> implements javax.servlet.AsyncListener {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        AsyncListener(jakarta.servlet.AsyncListener target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void onComplete(javax.servlet.AsyncEvent event) throws IOException {
            target.onComplete(event);
        }

        @Override
        public void onComplete(jakarta.servlet.AsyncEvent event) throws IOException {
            target.onComplete(event);
        }

        @Override
        public void onTimeout(javax.servlet.AsyncEvent event) throws IOException {
            target.onTimeout(event);
        }

        @Override
        public void onTimeout(jakarta.servlet.AsyncEvent event) throws IOException {
            target.onTimeout(event);
        }

        @Override
        public void onError(javax.servlet.AsyncEvent event) throws IOException {
            target.onError(event);
        }

        @Override
        public void onError(jakarta.servlet.AsyncEvent event) throws IOException {
            target.onError(event);
        }

        @Override
        public void onStartAsync(javax.servlet.AsyncEvent event) throws IOException {
            target.onStartAsync(event);
        }

        @Override
        public void onStartAsync(jakarta.servlet.AsyncEvent event) throws IOException {
            target.onStartAsync(event);
        }
    }

    @SuppressWarnings("removal")
    final class Cookie extends javax.servlet.http.Cookie {
        private final jakarta.servlet.http.Cookie target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Cookie(jakarta.servlet.http.Cookie target) {
            super(target.getName(), target.getValue());
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void setComment(String purpose) {
            target.setComment(purpose);
        }

        @Override
        public String getComment() {
            return target.getComment();
        }

        @Override
        public void setDomain(String domain) {
            target.setDomain(domain);
        }

        @Override
        public String getDomain() {
            return target.getDomain();
        }

        @Override
        public void setMaxAge(int expiry) {
            target.setMaxAge(expiry);
        }

        @Override
        public int getMaxAge() {
            return target.getMaxAge();
        }

        @Override
        public void setPath(String uri) {
            target.setPath(uri);
        }

        @Override
        public String getPath() {
            return target.getPath();
        }

        @Override
        public void setSecure(boolean flag) {
            target.setSecure(flag);
        }

        @Override
        public boolean getSecure() {
            return target.getSecure();
        }

        @Override
        public String getName() {
            return target.getName();
        }

        @Override
        public void setValue(String newValue) {
            target.setValue(newValue);
        }

        @Override
        public String getValue() {
            return target.getValue();
        }

        @Override
        public int getVersion() {
            return target.getVersion();
        }

        @Override
        public void setVersion(int v) {
            target.setVersion(v);
        }

        @Override
        public Object clone() {
            return target.clone();
        }

        @Override
        public void setHttpOnly(boolean httpOnly) {
            target.setHttpOnly(httpOnly);
        }

        @Override
        public boolean isHttpOnly() {
            return target.isHttpOnly();
        }

        @Override
        public void setAttribute(String name, String value) {
            target.setAttribute(name, value);
        }

        @Override
        public String getAttribute(String name) {
            return target.getAttribute(name);
        }

        @Override
        public Map<String, String> getAttributes() {
            return target.getAttributes();
        }

        @Override
        public int hashCode() {
            return target.hashCode();
        }

        @Override
        public boolean equals(Object other) {
            return target.equals(other);
        }

        @Override
        public String toString() {
            return target.toString();
        }
    }

    final class Filter extends ServletShim.Facade<jakarta.servlet.Filter> implements javax.servlet.Filter {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Filter(jakarta.servlet.Filter target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {
            try {
                target.init(config);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void init(jakarta.servlet.FilterConfig config) throws javax.servlet.ServletException {
            try {
                target.init(config);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void doFilter(
            javax.servlet.ServletRequest request,
            javax.servlet.ServletResponse response,
            javax.servlet.FilterChain chain
        ) throws javax.servlet.ServletException, IOException {
            try {
                target.doFilter(request, response, chain);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void doFilter(
            jakarta.servlet.ServletRequest request,
            jakarta.servlet.ServletResponse response,
            jakarta.servlet.FilterChain chain
        ) throws javax.servlet.ServletException, IOException {
            try {
                target.doFilter(request, response, chain);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void destroy() {
            target.destroy();
        }
    }

    final class FilterChain extends ServletShim.Facade<jakarta.servlet.FilterChain> implements javax.servlet.FilterChain {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        FilterChain(jakarta.servlet.FilterChain target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void doFilter(
            javax.servlet.ServletRequest request,
            javax.servlet.ServletResponse response
        ) throws javax.servlet.ServletException, IOException {
            try {
                target.doFilter(request, response);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void doFilter(
            jakarta.servlet.ServletRequest request,
            jakarta.servlet.ServletResponse response
        ) throws javax.servlet.ServletException, IOException {
            try {
                target.doFilter(request, response);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }
    }

    final class FilterConfig extends ServletShim.Facade<jakarta.servlet.FilterConfig> implements javax.servlet.FilterConfig {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        FilterConfig(jakarta.servlet.FilterConfig target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getFilterName() {
            return target.getFilterName();
        }

        @Override
        public javax.servlet.ServletContext getServletContext() {
            return ServletShim.of(target.getServletContext());
        }

        @Override
        public String getInitParameter(String name) {
            return target.getInitParameter(name);
        }

        @Override
        public Enumeration<String> getInitParameterNames() {
            return target.getInitParameterNames();
        }
    }

    final class FilterRegistration extends ServletShim.Facade<jakarta.servlet.FilterRegistration> implements javax.servlet.FilterRegistration {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        FilterRegistration(jakarta.servlet.FilterRegistration target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void addMappingForServletNames(Set dispatcherTypes, boolean isMatchAfter, String... servletNames) {
            target.addMappingForServletNames(
                Shim.Enum.toJakarta(jakarta.servlet.DispatcherType.class, dispatcherTypes),
                isMatchAfter,
                servletNames
            );
        }

        @Override
        public void addMappingForServletNames(EnumSet dispatcherTypes, boolean isMatchAfter, String... servletNames) {
            target.addMappingForServletNames(
                Shim.Enum.toJakarta(jakarta.servlet.DispatcherType.class, dispatcherTypes),
                isMatchAfter,
                servletNames
            );
        }

        @Override
        public void addMappingForUrlPatterns(Set dispatcherTypes, boolean isMatchAfter, String... urlPatterns) {
            target.addMappingForUrlPatterns(
                Shim.Enum.toJakarta(jakarta.servlet.DispatcherType.class, dispatcherTypes),
                isMatchAfter,
                urlPatterns
            );
        }

        @Override
        public void addMappingForUrlPatterns(EnumSet dispatcherTypes, boolean isMatchAfter, String... urlPatterns) {
            target.addMappingForUrlPatterns(
                Shim.Enum.toJakarta(jakarta.servlet.DispatcherType.class, dispatcherTypes),
                isMatchAfter,
                urlPatterns
            );
        }

        @Override
        public Collection<String> getServletNameMappings() {
            return target.getServletNameMappings();
        }

        @Override
        public Collection<String> getUrlPatternMappings() {
            return target.getUrlPatternMappings();
        }

        @Override
        public String getName() {
            return target.getName();
        }

        @Override
        public String getClassName() {
            return target.getClassName();
        }

        @Override
        public boolean setInitParameter(String name, String value) {
            return target.setInitParameter(name, value);
        }

        @Override
        public String getInitParameter(String name) {
            return target.getInitParameter(name);
        }

        @Override
        public Set<String> setInitParameters(Map<String, String> initParameters) {
            return target.setInitParameters(initParameters);
        }

        @Override
        public Map<String, String> getInitParameters() {
            return target.getInitParameters();
        }
    }

    final class FilterRegistration$Dynamic extends ServletShim.Facade<jakarta.servlet.FilterRegistration.Dynamic> implements javax.servlet.FilterRegistration.Dynamic {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        FilterRegistration$Dynamic(jakarta.servlet.FilterRegistration.Dynamic target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void addMappingForServletNames(Set dispatcherTypes, boolean isMatchAfter, String... servletNames) {
            target.addMappingForServletNames(
                Shim.Enum.toJakarta(jakarta.servlet.DispatcherType.class, dispatcherTypes),
                isMatchAfter,
                servletNames
            );
        }

        @Override
        public void addMappingForServletNames(EnumSet dispatcherTypes, boolean isMatchAfter, String... servletNames) {
            target.addMappingForServletNames(
                Shim.Enum.toJakarta(jakarta.servlet.DispatcherType.class, dispatcherTypes),
                isMatchAfter,
                servletNames
            );
        }

        @Override
        public void addMappingForUrlPatterns(Set dispatcherTypes, boolean isMatchAfter, String... urlPatterns) {
            target.addMappingForUrlPatterns(
                Shim.Enum.toJakarta(jakarta.servlet.DispatcherType.class, dispatcherTypes),
                isMatchAfter,
                urlPatterns
            );
        }

        @Override
        public void addMappingForUrlPatterns(EnumSet dispatcherTypes, boolean isMatchAfter, String... urlPatterns) {
            target.addMappingForUrlPatterns(
                Shim.Enum.toJakarta(jakarta.servlet.DispatcherType.class, dispatcherTypes),
                isMatchAfter,
                urlPatterns
            );
        }

        @Override
        public Collection<String> getServletNameMappings() {
            return target.getServletNameMappings();
        }

        @Override
        public Collection<String> getUrlPatternMappings() {
            return target.getUrlPatternMappings();
        }

        @Override
        public String getName() {
            return target.getName();
        }

        @Override
        public String getClassName() {
            return target.getClassName();
        }

        @Override
        public boolean setInitParameter(String name, String value) {
            return target.setInitParameter(name, value);
        }

        @Override
        public String getInitParameter(String name) {
            return target.getInitParameter(name);
        }

        @Override
        public Set<String> setInitParameters(Map<String, String> initParameters) {
            return target.setInitParameters(initParameters);
        }

        @Override
        public Map<String, String> getInitParameters() {
            return target.getInitParameters();
        }

        @Override
        public void setAsyncSupported(boolean isAsyncSupported) {
            target.setAsyncSupported(isAsyncSupported);
        }
    }

    final class GenericFilter extends javax.servlet.GenericFilter {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        private final jakarta.servlet.GenericFilter target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        GenericFilter(jakarta.servlet.GenericFilter target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getInitParameter(String name) {
            return target.getInitParameter(name);
        }

        @Override
        public Enumeration<String> getInitParameterNames() {
            return target.getInitParameterNames();
        }

        @Override
        public javax.servlet.FilterConfig getFilterConfig() {
            return ServletShim.of(target.getFilterConfig());
        }

        @Override
        public javax.servlet.ServletContext getServletContext() {
            return ServletShim.of(target.getServletContext());
        }

        @Override
        public void init(jakarta.servlet.FilterConfig config) throws javax.servlet.ServletException {
            try {
                target.init(config);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void init() throws javax.servlet.ServletException {
            try {
                target.init();
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public String getFilterName() {
            return target.getFilterName();
        }

        @Override
        public void doFilter(
            javax.servlet.ServletRequest request,
            javax.servlet.ServletResponse response,
            javax.servlet.FilterChain chain
        ) throws javax.servlet.ServletException, IOException {
            try {
                target.doFilter(request, response, chain);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void doFilter(
            jakarta.servlet.ServletRequest request,
            jakarta.servlet.ServletResponse response,
            jakarta.servlet.FilterChain chain
        ) throws javax.servlet.ServletException, IOException {
            try {
                target.doFilter(request, response, chain);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void destroy() {
            target.destroy();
        }
    }

    final class GenericServlet extends javax.servlet.GenericServlet {
        private final jakarta.servlet.GenericServlet target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        GenericServlet(jakarta.servlet.GenericServlet target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void destroy() {
            target.destroy();
        }

        @Override
        public String getInitParameter(String name) {
            return target.getInitParameter(name);
        }

        @Override
        public Enumeration<String> getInitParameterNames() {
            return target.getInitParameterNames();
        }

        @Override
        public javax.servlet.ServletConfig getServletConfig() {
            return ServletShim.of(target.getServletConfig());
        }

        @Override
        public javax.servlet.ServletContext getServletContext() {
            return ServletShim.of(target.getServletContext());
        }

        @Override
        public String getServletInfo() {
            return target.getServletInfo();
        }

        @Override
        public void init(jakarta.servlet.ServletConfig config) throws javax.servlet.ServletException {
            try {
                target.init(config);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void init() throws javax.servlet.ServletException {
            try {
                target.init();
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void log(String message) {
            target.log(message);
        }

        @Override
        public void log(String message, Throwable cause) {
            target.log(message, cause);
        }

        @Override
        public void service(
            javax.servlet.ServletRequest request,
            javax.servlet.ServletResponse response
        ) throws javax.servlet.ServletException, IOException {
            try {
                target.service(request, response);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void service(
            jakarta.servlet.ServletRequest request,
            jakarta.servlet.ServletResponse response
        ) throws javax.servlet.ServletException, IOException {
            try {
                target.service(request, response);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public String getServletName() {
            return target.getServletName();
        }
    }

    final class HttpConstraintElement extends javax.servlet.HttpConstraintElement {
        private final jakarta.servlet.HttpConstraintElement target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        HttpConstraintElement(jakarta.servlet.HttpConstraintElement target) {
            super(target.getEmptyRoleSemantic(), target.getTransportGuarantee(), target.getRolesAllowed());
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public jakarta.servlet.annotation.ServletSecurity.EmptyRoleSemantic getEmptyRoleSemantic() {
            return target.getEmptyRoleSemantic();
        }

        @Override
        public jakarta.servlet.annotation.ServletSecurity.TransportGuarantee getTransportGuarantee() {
            return target.getTransportGuarantee();
        }

        @Override
        public String[] getRolesAllowed() {
            return target.getRolesAllowed();
        }
    }

    final class HttpFilter extends javax.servlet.http.HttpFilter {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        private final jakarta.servlet.http.HttpFilter target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        HttpFilter(jakarta.servlet.http.HttpFilter target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void doFilter(
            javax.servlet.ServletRequest request,
            javax.servlet.ServletResponse response,
            javax.servlet.FilterChain chain
        ) throws javax.servlet.ServletException, IOException {
            try {
                target.doFilter(request, response, chain);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void doFilter(
            jakarta.servlet.ServletRequest request,
            jakarta.servlet.ServletResponse response,
            jakarta.servlet.FilterChain chain
        ) throws javax.servlet.ServletException, IOException {
            try {
                target.doFilter(request, response, chain);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public String getInitParameter(String name) {
            return target.getInitParameter(name);
        }

        @Override
        public Enumeration<String> getInitParameterNames() {
            return target.getInitParameterNames();
        }

        @Override
        public javax.servlet.FilterConfig getFilterConfig() {
            return ServletShim.of(target.getFilterConfig());
        }

        @Override
        public javax.servlet.ServletContext getServletContext() {
            return ServletShim.of(target.getServletContext());
        }

        @Override
        public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {
            try {
                target.init(config);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void init(jakarta.servlet.FilterConfig config) throws javax.servlet.ServletException {
            try {
                target.init(config);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void init() throws javax.servlet.ServletException {
            try {
                target.init();
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public String getFilterName() {
            return target.getFilterName();
        }

        @Override
        public void destroy() {
            target.destroy();
        }
    }

    final class HttpMethodConstraintElement extends javax.servlet.HttpMethodConstraintElement {
        private final jakarta.servlet.HttpMethodConstraintElement target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        HttpMethodConstraintElement(jakarta.servlet.HttpMethodConstraintElement target) {
            super(target.getMethodName(), target);
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getMethodName() {
            return target.getMethodName();
        }

        @Override
        public jakarta.servlet.annotation.ServletSecurity.EmptyRoleSemantic getEmptyRoleSemantic() {
            return target.getEmptyRoleSemantic();
        }

        @Override
        public jakarta.servlet.annotation.ServletSecurity.TransportGuarantee getTransportGuarantee() {
            return target.getTransportGuarantee();
        }

        @Override
        public String[] getRolesAllowed() {
            return target.getRolesAllowed();
        }
    }

    final class HttpServlet extends javax.servlet.http.HttpServlet {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        private final jakarta.servlet.http.HttpServlet target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        HttpServlet(jakarta.servlet.http.HttpServlet target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void init(javax.servlet.ServletConfig config) throws javax.servlet.ServletException {
            try {
                target.init(config);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void init(jakarta.servlet.ServletConfig config) throws javax.servlet.ServletException {
            try {
                target.init(config);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void service(
            javax.servlet.ServletRequest request,
            javax.servlet.ServletResponse response
        ) throws javax.servlet.ServletException, IOException {
            try {
                target.service(request, response);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void service(
            jakarta.servlet.ServletRequest request,
            jakarta.servlet.ServletResponse response
        ) throws javax.servlet.ServletException, IOException {
            try {
                target.service(request, response);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void destroy() {
            target.destroy();
        }

        @Override
        public String getInitParameter(String name) {
            return target.getInitParameter(name);
        }

        @Override
        public Enumeration<String> getInitParameterNames() {
            return target.getInitParameterNames();
        }

        @Override
        public javax.servlet.ServletConfig getServletConfig() {
            return ServletShim.of(target.getServletConfig());
        }

        @Override
        public javax.servlet.ServletContext getServletContext() {
            return ServletShim.of(target.getServletContext());
        }

        @Override
        public String getServletInfo() {
            return target.getServletInfo();
        }

        @Override
        public void init() throws javax.servlet.ServletException {
            try {
                target.init();
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void log(String message) {
            target.log(message);
        }

        @Override
        public void log(String message, Throwable cause) {
            target.log(message, cause);
        }

        @Override
        public String getServletName() {
            return target.getServletName();
        }
    }

    final class HttpServletMapping extends ServletShim.Facade<jakarta.servlet.http.HttpServletMapping> implements javax.servlet.http.HttpServletMapping {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        HttpServletMapping(jakarta.servlet.http.HttpServletMapping target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getMatchValue() {
            return target.getMatchValue();
        }

        @Override
        public String getPattern() {
            return target.getPattern();
        }

        @Override
        public String getServletName() {
            return target.getServletName();
        }

        @Override
        public jakarta.servlet.http.MappingMatch getMappingMatch() {
            return target.getMappingMatch();
        }
    }

    final class HttpServletRequest extends ServletShim.Facade<jakarta.servlet.http.HttpServletRequest> implements javax.servlet.http.HttpServletRequest {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        HttpServletRequest(jakarta.servlet.http.HttpServletRequest target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getAuthType() {
            return target.getAuthType();
        }

        @Override
        public javax.servlet.http.Cookie[] getCookies() {
            return ServletShim
                .<javax.servlet.http.Cookie>of(target.getCookies())
                .toArray(javax.servlet.http.Cookie[]::new);
        }

        @Override
        public long getDateHeader(String name) {
            return target.getDateHeader(name);
        }

        @Override
        public String getHeader(String name) {
            return target.getHeader(name);
        }

        @Override
        public Enumeration<String> getHeaders(String name) {
            return target.getHeaders(name);
        }

        @Override
        public Enumeration<String> getHeaderNames() {
            return target.getHeaderNames();
        }

        @Override
        public int getIntHeader(String name) {
            return target.getIntHeader(name);
        }

        @Override
        public javax.servlet.http.HttpServletMapping getHttpServletMapping() {
            return ServletShim.of(target.getHttpServletMapping());
        }

        @Override
        public String getMethod() {
            return target.getMethod();
        }

        @Override
        public String getPathInfo() {
            return target.getPathInfo();
        }

        @Override
        public String getPathTranslated() {
            return target.getPathTranslated();
        }

        @Override
        public javax.servlet.http.PushBuilder newPushBuilder() {
            return ServletShim.of(target.newPushBuilder());
        }

        @Override
        public String getContextPath() {
            return target.getContextPath();
        }

        @Override
        public String getQueryString() {
            return target.getQueryString();
        }

        @Override
        public String getRemoteUser() {
            return target.getRemoteUser();
        }

        @Override
        public boolean isUserInRole(String role) {
            return target.isUserInRole(role);
        }

        @Override
        public Principal getUserPrincipal() {
            return target.getUserPrincipal();
        }

        @Override
        public String getRequestedSessionId() {
            return target.getRequestedSessionId();
        }

        @Override
        public String getRequestURI() {
            return target.getRequestURI();
        }

        @Override
        public StringBuffer getRequestURL() {
            return target.getRequestURL();
        }

        @Override
        public String getServletPath() {
            return target.getServletPath();
        }

        @Override
        public javax.servlet.http.HttpSession getSession(boolean create) {
            return ServletShim.of(target.getSession(create));
        }

        @Override
        public javax.servlet.http.HttpSession getSession() {
            return ServletShim.of(target.getSession());
        }

        @Override
        public String changeSessionId() {
            return target.changeSessionId();
        }

        @Override
        public boolean isRequestedSessionIdValid() {
            return target.isRequestedSessionIdValid();
        }

        @Override
        public boolean isRequestedSessionIdFromCookie() {
            return target.isRequestedSessionIdFromCookie();
        }

        @Override
        public boolean isRequestedSessionIdFromURL() {
            return target.isRequestedSessionIdFromURL();
        }

        @Override
        public boolean authenticate(
            javax.servlet.http.HttpServletResponse response
        ) throws javax.servlet.ServletException, IOException {
            try {
                return target.authenticate(response);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public boolean authenticate(
            jakarta.servlet.http.HttpServletResponse response
        ) throws javax.servlet.ServletException, IOException {
            try {
                return target.authenticate(response);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void login(String username, String password) throws javax.servlet.ServletException {
            try {
                target.login(username, password);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void logout() throws javax.servlet.ServletException {
            try {
                target.logout();
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public Collection getParts() throws javax.servlet.ServletException, IOException {
            try {
                return ServletShim
                    .<javax.servlet.http.Part>of(target.getParts())
                    .collect(Collectors.toList());
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public javax.servlet.http.Part getPart(String name) throws javax.servlet.ServletException, IOException {
            try {
                return ServletShim.of(target.getPart(name));
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public javax.servlet.http.HttpUpgradeHandler upgrade(
            Class clazz
        ) throws javax.servlet.ServletException, IOException {
            try {
                return ServletShim.of(target.upgrade(clazz.asSubclass(jakarta.servlet.http.HttpUpgradeHandler.class)));
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public Map<String, String> getTrailerFields() {
            return target.getTrailerFields();
        }

        @Override
        public boolean isTrailerFieldsReady() {
            return target.isTrailerFieldsReady();
        }

        @Override
        public Object getAttribute(String name) {
            return target.getAttribute(name);
        }

        @Override
        public Enumeration<String> getAttributeNames() {
            return target.getAttributeNames();
        }

        @Override
        public String getCharacterEncoding() {
            return target.getCharacterEncoding();
        }

        @Override
        public void setCharacterEncoding(String encoding) throws UnsupportedEncodingException {
            target.setCharacterEncoding(encoding);
        }

        @Override
        public int getContentLength() {
            return target.getContentLength();
        }

        @Override
        public long getContentLengthLong() {
            return target.getContentLengthLong();
        }

        @Override
        public String getContentType() {
            return target.getContentType();
        }

        @Override
        public javax.servlet.ServletInputStream getInputStream() throws IOException {
            return ServletShim.of(target.getInputStream());
        }

        @Override
        public String getParameter(String name) {
            return target.getParameter(name);
        }

        @Override
        public Enumeration<String> getParameterNames() {
            return target.getParameterNames();
        }

        @Override
        public String[] getParameterValues(String name) {
            return target.getParameterValues(name);
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            return target.getParameterMap();
        }

        @Override
        public String getProtocol() {
            return target.getProtocol();
        }

        @Override
        public String getScheme() {
            return target.getScheme();
        }

        @Override
        public String getServerName() {
            return target.getServerName();
        }

        @Override
        public int getServerPort() {
            return target.getServerPort();
        }

        @Override
        public BufferedReader getReader() throws IOException {
            return target.getReader();
        }

        @Override
        public String getRemoteAddr() {
            return target.getRemoteAddr();
        }

        @Override
        public String getRemoteHost() {
            return target.getRemoteHost();
        }

        @Override
        public void setAttribute(String name, Object o) {
            target.setAttribute(name, o);
        }

        @Override
        public void removeAttribute(String name) {
            target.removeAttribute(name);
        }

        @Override
        public Locale getLocale() {
            return target.getLocale();
        }

        @Override
        public Enumeration<Locale> getLocales() {
            return target.getLocales();
        }

        @Override
        public boolean isSecure() {
            return target.isSecure();
        }

        @Override
        public javax.servlet.RequestDispatcher getRequestDispatcher(String path) {
            return ServletShim.of(target.getRequestDispatcher(path));
        }

        @Override
        public int getRemotePort() {
            return target.getRemotePort();
        }

        @Override
        public String getLocalName() {
            return target.getLocalName();
        }

        @Override
        public String getLocalAddr() {
            return target.getLocalAddr();
        }

        @Override
        public int getLocalPort() {
            return target.getLocalPort();
        }

        @Override
        public javax.servlet.ServletContext getServletContext() {
            return ServletShim.of(target.getServletContext());
        }

        @Override
        public javax.servlet.AsyncContext startAsync() throws IllegalStateException {
            return ServletShim.of(target.startAsync());
        }

        @Override
        public javax.servlet.AsyncContext startAsync(
            javax.servlet.ServletRequest request,
            javax.servlet.ServletResponse response
        ) throws IllegalStateException {
            return ServletShim.of(target.startAsync(request, response));
        }

        @Override
        public javax.servlet.AsyncContext startAsync(
            jakarta.servlet.ServletRequest request,
            jakarta.servlet.ServletResponse response
        ) throws IllegalStateException {
            return ServletShim.of(target.startAsync(request, response));
        }

        @Override
        public boolean isAsyncStarted() {
            return target.isAsyncStarted();
        }

        @Override
        public boolean isAsyncSupported() {
            return target.isAsyncSupported();
        }

        @Override
        public javax.servlet.AsyncContext getAsyncContext() {
            return ServletShim.of(target.getAsyncContext());
        }

        @Override
        public jakarta.servlet.DispatcherType getDispatcherType() {
            return target.getDispatcherType();
        }

        @Override
        public String getRequestId() {
            return target.getRequestId();
        }

        @Override
        public String getProtocolRequestId() {
            return target.getProtocolRequestId();
        }

        @Override
        public javax.servlet.ServletConnection getServletConnection() {
            return ServletShim.of(target.getServletConnection());
        }
    }

    final class HttpServletRequestWrapper extends javax.servlet.http.HttpServletRequestWrapper {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        HttpServletRequestWrapper(jakarta.servlet.http.HttpServletRequest target) {
            super(target);
        }
    }

    final class HttpServletResponse extends ServletShim.Facade<jakarta.servlet.http.HttpServletResponse> implements javax.servlet.http.HttpServletResponse {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        HttpServletResponse(jakarta.servlet.http.HttpServletResponse target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void addCookie(javax.servlet.http.Cookie cookie) {
            target.addCookie(cookie);
        }

        @Override
        public void addCookie(jakarta.servlet.http.Cookie cookie) {
            target.addCookie(cookie);
        }

        @Override
        public boolean containsHeader(String name) {
            return target.containsHeader(name);
        }

        @Override
        public String encodeURL(String url) {
            return target.encodeURL(url);
        }

        @Override
        public String encodeRedirectURL(String url) {
            return target.encodeRedirectURL(url);
        }

        @Override
        public void sendError(int statusCode, String message) throws IOException {
            target.sendError(statusCode, message);
        }

        @Override
        public void sendError(int statusCode) throws IOException {
            target.sendError(statusCode);
        }

        @Override
        public void sendRedirect(String location) throws IOException {
            target.sendRedirect(location);
        }

        @Override
        public void setDateHeader(String name, long date) {
            target.setDateHeader(name, date);
        }

        @Override
        public void addDateHeader(String name, long date) {
            target.addDateHeader(name, date);
        }

        @Override
        public void setHeader(String name, String value) {
            target.setHeader(name, value);
        }

        @Override
        public void addHeader(String name, String value) {
            target.addHeader(name, value);
        }

        @Override
        public void setIntHeader(String name, int value) {
            target.setIntHeader(name, value);
        }

        @Override
        public void addIntHeader(String name, int value) {
            target.addIntHeader(name, value);
        }

        @Override
        public void setStatus(int sc) {
            target.setStatus(sc);
        }

        @Override
        public int getStatus() {
            return target.getStatus();
        }

        @Override
        public String getHeader(String name) {
            return target.getHeader(name);
        }

        @Override
        public Collection<String> getHeaders(String name) {
            return target.getHeaders(name);
        }

        @Override
        public Collection<String> getHeaderNames() {
            return target.getHeaderNames();
        }

        @Override
        public void setTrailerFields(Supplier<Map<String, String>> supplier) {
            target.setTrailerFields(supplier);
        }

        @Override
        public Supplier<Map<String, String>> getTrailerFields() {
            return target.getTrailerFields();
        }

        @Override
        public String getCharacterEncoding() {
            return target.getCharacterEncoding();
        }

        @Override
        public String getContentType() {
            return target.getContentType();
        }

        @Override
        public javax.servlet.ServletOutputStream getOutputStream() throws IOException {
            return ServletShim.of(target.getOutputStream());
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            return target.getWriter();
        }

        @Override
        public void setCharacterEncoding(String charset) {
            target.setCharacterEncoding(charset);
        }

        @Override
        public void setContentLength(int len) {
            target.setContentLength(len);
        }

        @Override
        public void setContentLengthLong(long len) {
            target.setContentLengthLong(len);
        }

        @Override
        public void setContentType(String type) {
            target.setContentType(type);
        }

        @Override
        public void setBufferSize(int size) {
            target.setBufferSize(size);
        }

        @Override
        public int getBufferSize() {
            return target.getBufferSize();
        }

        @Override
        public void flushBuffer() throws IOException {
            target.flushBuffer();
        }

        @Override
        public void resetBuffer() {
            target.resetBuffer();
        }

        @Override
        public boolean isCommitted() {
            return target.isCommitted();
        }

        @Override
        public void reset() {
            target.reset();
        }

        @Override
        public void setLocale(Locale loc) {
            target.setLocale(loc);
        }

        @Override
        public Locale getLocale() {
            return target.getLocale();
        }
    }

    final class HttpServletResponseWrapper extends javax.servlet.http.HttpServletResponseWrapper {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        HttpServletResponseWrapper(jakarta.servlet.http.HttpServletResponse target) {
            super(target);
        }
    }

    final class HttpSession extends ServletShim.Facade<jakarta.servlet.http.HttpSession> implements javax.servlet.http.HttpSession {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        HttpSession(jakarta.servlet.http.HttpSession target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public long getCreationTime() {
            return target.getCreationTime();
        }

        @Override
        public String getId() {
            return target.getId();
        }

        @Override
        public long getLastAccessedTime() {
            return target.getLastAccessedTime();
        }

        @Override
        public javax.servlet.ServletContext getServletContext() {
            return ServletShim.of(target.getServletContext());
        }

        @Override
        public void setMaxInactiveInterval(int interval) {
            target.setMaxInactiveInterval(interval);
        }

        @Override
        public int getMaxInactiveInterval() {
            return target.getMaxInactiveInterval();
        }

        @Override
        public Object getAttribute(String name) {
            return target.getAttribute(name);
        }

        @Override
        public Enumeration<String> getAttributeNames() {
            return target.getAttributeNames();
        }

        @Override
        public void setAttribute(String name, Object value) {
            target.setAttribute(name, value);
        }

        @Override
        public void removeAttribute(String name) {
            target.removeAttribute(name);
        }

        @Override
        public void invalidate() {
            target.invalidate();
        }

        @Override
        public boolean isNew() {
            return target.isNew();
        }
    }

    final class HttpSessionActivationListener extends ServletShim.Facade<jakarta.servlet.http.HttpSessionActivationListener> implements javax.servlet.http.HttpSessionActivationListener {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        HttpSessionActivationListener(jakarta.servlet.http.HttpSessionActivationListener target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void sessionDidActivate(javax.servlet.http.HttpSessionEvent event) {
            target.sessionDidActivate(event);
        }

        @Override
        public void sessionDidActivate(jakarta.servlet.http.HttpSessionEvent event) {
            target.sessionDidActivate(event);
        }

        @Override
        public void sessionWillPassivate(javax.servlet.http.HttpSessionEvent event) {
            target.sessionWillPassivate(event);
        }

        @Override
        public void sessionWillPassivate(jakarta.servlet.http.HttpSessionEvent event) {
            target.sessionWillPassivate(event);
        }
    }

    final class HttpSessionAttributeListener extends ServletShim.Facade<jakarta.servlet.http.HttpSessionAttributeListener> implements javax.servlet.http.HttpSessionAttributeListener {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        HttpSessionAttributeListener(jakarta.servlet.http.HttpSessionAttributeListener target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void attributeAdded(javax.servlet.http.HttpSessionBindingEvent event) {
            target.attributeAdded(new jakarta.servlet.http.HttpSessionBindingEvent(
                event.getSession(),
                event.getName(),
                event.getValue()
            ));
        }

        @Override
        public void attributeAdded(jakarta.servlet.http.HttpSessionBindingEvent event) {
            target.attributeAdded(event);
        }

        @Override
        public void attributeRemoved(javax.servlet.http.HttpSessionBindingEvent event) {
            target.attributeRemoved(new jakarta.servlet.http.HttpSessionBindingEvent(
                event.getSession(),
                event.getName(),
                event.getValue()
            ));
        }

        @Override
        public void attributeRemoved(jakarta.servlet.http.HttpSessionBindingEvent event) {
            target.attributeRemoved(event);
        }

        @Override
        public void attributeReplaced(javax.servlet.http.HttpSessionBindingEvent event) {
            target.attributeReplaced(new jakarta.servlet.http.HttpSessionBindingEvent(
                event.getSession(),
                event.getName(),
                event.getValue()
            ));
        }

        @Override
        public void attributeReplaced(jakarta.servlet.http.HttpSessionBindingEvent event) {
            target.attributeReplaced(event);
        }
    }

    final class HttpSessionBindingEvent extends javax.servlet.http.HttpSessionBindingEvent {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        private final jakarta.servlet.http.HttpSessionBindingEvent target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        HttpSessionBindingEvent(jakarta.servlet.http.HttpSessionBindingEvent target) {
            super(ServletShim.of(target.getSession()), target.getName(), target.getValue());
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getName() {
            return target.getName();
        }

        @Override
        public Object getValue() {
            return target.getValue();
        }

        @Override
        public javax.servlet.http.HttpSession getSession() {
            return ServletShim.of(target.getSession());
        }

        @Override
        public Object getSource() {
            return target.getSource();
        }

        @Override
        public String toString() {
            return target.toString();
        }
    }

    final class HttpSessionBindingListener extends ServletShim.Facade<jakarta.servlet.http.HttpSessionBindingListener> implements javax.servlet.http.HttpSessionBindingListener {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        HttpSessionBindingListener(jakarta.servlet.http.HttpSessionBindingListener target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void valueBound(javax.servlet.http.HttpSessionBindingEvent event) {
            target.valueBound(new jakarta.servlet.http.HttpSessionBindingEvent(
                event.getSession(),
                event.getName(),
                event.getValue()
            ));
        }

        @Override
        public void valueBound(jakarta.servlet.http.HttpSessionBindingEvent event) {
            target.valueBound(event);
        }

        @Override
        public void valueUnbound(javax.servlet.http.HttpSessionBindingEvent event) {
            target.valueUnbound(new jakarta.servlet.http.HttpSessionBindingEvent(
                event.getSession(),
                event.getName(),
                event.getValue()
            ));
        }

        @Override
        public void valueUnbound(jakarta.servlet.http.HttpSessionBindingEvent event) {
            target.valueUnbound(event);
        }
    }

    final class HttpSessionEvent extends javax.servlet.http.HttpSessionEvent {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        private final jakarta.servlet.http.HttpSessionEvent target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        HttpSessionEvent(jakarta.servlet.http.HttpSessionEvent target) {
            super(ServletShim.of(target.getSession()));
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.servlet.http.HttpSession getSession() {
            return ServletShim.of(target.getSession());
        }

        @Override
        public Object getSource() {
            return target.getSource();
        }

        @Override
        public String toString() {
            return target.toString();
        }
    }

    final class HttpSessionIdListener extends ServletShim.Facade<jakarta.servlet.http.HttpSessionIdListener> implements javax.servlet.http.HttpSessionIdListener {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        HttpSessionIdListener(jakarta.servlet.http.HttpSessionIdListener target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void sessionIdChanged(javax.servlet.http.HttpSessionEvent event, String oldSessionId) {
            target.sessionIdChanged(event, oldSessionId);
        }

        @Override
        public void sessionIdChanged(jakarta.servlet.http.HttpSessionEvent event, String oldSessionId) {
            target.sessionIdChanged(event, oldSessionId);
        }
    }

    final class HttpSessionListener extends ServletShim.Facade<jakarta.servlet.http.HttpSessionListener> implements javax.servlet.http.HttpSessionListener {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        HttpSessionListener(jakarta.servlet.http.HttpSessionListener target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void sessionCreated(javax.servlet.http.HttpSessionEvent event) {
            target.sessionCreated(event);
        }

        @Override
        public void sessionCreated(jakarta.servlet.http.HttpSessionEvent event) {
            target.sessionCreated(event);
        }

        @Override
        public void sessionDestroyed(javax.servlet.http.HttpSessionEvent event) {
            target.sessionDestroyed(event);
        }

        @Override
        public void sessionDestroyed(jakarta.servlet.http.HttpSessionEvent event) {
            target.sessionDestroyed(event);
        }
    }

    final class HttpUpgradeHandler extends ServletShim.Facade<jakarta.servlet.http.HttpUpgradeHandler> implements javax.servlet.http.HttpUpgradeHandler {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        HttpUpgradeHandler(jakarta.servlet.http.HttpUpgradeHandler target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void init(javax.servlet.http.WebConnection connection) {
            target.init(connection);
        }

        @Override
        public void init(jakarta.servlet.http.WebConnection connection) {
            target.init(connection);
        }

        @Override
        public void destroy() {
            target.destroy();
        }
    }

    final class MultipartConfigElement extends javax.servlet.MultipartConfigElement {
        private final jakarta.servlet.MultipartConfigElement target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        MultipartConfigElement(jakarta.servlet.MultipartConfigElement target) {
            super(
                target.getLocation(),
                target.getMaxFileSize(),
                target.getMaxRequestSize(),
                target.getFileSizeThreshold()
            );
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getLocation() {
            return target.getLocation();
        }

        @Override
        public long getMaxFileSize() {
            return target.getMaxFileSize();
        }

        @Override
        public long getMaxRequestSize() {
            return target.getMaxRequestSize();
        }

        @Override
        public int getFileSizeThreshold() {
            return target.getFileSizeThreshold();
        }
    }

    final class Part extends ServletShim.Facade<jakarta.servlet.http.Part> implements javax.servlet.http.Part {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Part(jakarta.servlet.http.Part target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public InputStream getInputStream() throws IOException {
            return target.getInputStream();
        }

        @Override
        public String getContentType() {
            return target.getContentType();
        }

        @Override
        public String getName() {
            return target.getName();
        }

        @Override
        public String getSubmittedFileName() {
            return target.getSubmittedFileName();
        }

        @Override
        public long getSize() {
            return target.getSize();
        }

        @Override
        public void write(String fileName) throws IOException {
            target.write(fileName);
        }

        @Override
        public void delete() throws IOException {
            target.delete();
        }

        @Override
        public String getHeader(String name) {
            return target.getHeader(name);
        }

        @Override
        public Collection<String> getHeaders(String name) {
            return target.getHeaders(name);
        }

        @Override
        public Collection<String> getHeaderNames() {
            return target.getHeaderNames();
        }
    }

    final class PushBuilder extends ServletShim.Facade<jakarta.servlet.http.PushBuilder> implements javax.servlet.http.PushBuilder {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        PushBuilder(jakarta.servlet.http.PushBuilder target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.servlet.http.PushBuilder method(String method) {
            return ServletShim.of(target.method(method));
        }

        @Override
        public javax.servlet.http.PushBuilder queryString(String queryString) {
            return ServletShim.of(target.queryString(queryString));
        }

        @Override
        public javax.servlet.http.PushBuilder sessionId(String sessionId) {
            return ServletShim.of(target.sessionId(sessionId));
        }

        @Override
        public javax.servlet.http.PushBuilder setHeader(String name, String value) {
            return ServletShim.of(target.setHeader(name, value));
        }

        @Override
        public javax.servlet.http.PushBuilder addHeader(String name, String value) {
            return ServletShim.of(target.addHeader(name, value));
        }

        @Override
        public javax.servlet.http.PushBuilder removeHeader(String name) {
            return ServletShim.of(target.removeHeader(name));
        }

        @Override
        public javax.servlet.http.PushBuilder path(String path) {
            return ServletShim.of(target.path(path));
        }

        @Override
        public void push() {
            target.push();
        }

        @Override
        public String getMethod() {
            return target.getMethod();
        }

        @Override
        public String getQueryString() {
            return target.getQueryString();
        }

        @Override
        public String getSessionId() {
            return target.getSessionId();
        }

        @Override
        public Set<String> getHeaderNames() {
            return target.getHeaderNames();
        }

        @Override
        public String getHeader(String name) {
            return target.getHeader(name);
        }

        @Override
        public String getPath() {
            return target.getPath();
        }
    }

    final class ReadListener extends ServletShim.Facade<jakarta.servlet.ReadListener> implements javax.servlet.ReadListener {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ReadListener(jakarta.servlet.ReadListener target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void onDataAvailable() throws IOException {
            target.onDataAvailable();
        }

        @Override
        public void onAllDataRead() throws IOException {
            target.onAllDataRead();
        }

        @Override
        public void onError(Throwable cause) {
            target.onError(cause);
        }
    }

    final class Registration extends ServletShim.Facade<jakarta.servlet.Registration> implements javax.servlet.Registration {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Registration(jakarta.servlet.Registration target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getName() {
            return target.getName();
        }

        @Override
        public String getClassName() {
            return target.getClassName();
        }

        @Override
        public boolean setInitParameter(String name, String value) {
            return target.setInitParameter(name, value);
        }

        @Override
        public String getInitParameter(String name) {
            return target.getInitParameter(name);
        }

        @Override
        public Set<String> setInitParameters(Map<String, String> initParameters) {
            return target.setInitParameters(initParameters);
        }

        @Override
        public Map<String, String> getInitParameters() {
            return target.getInitParameters();
        }
    }

    final class Registration$Dynamic extends ServletShim.Facade<jakarta.servlet.Registration.Dynamic> implements javax.servlet.Registration.Dynamic {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Registration$Dynamic(jakarta.servlet.Registration.Dynamic target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getName() {
            return target.getName();
        }

        @Override
        public String getClassName() {
            return target.getClassName();
        }

        @Override
        public boolean setInitParameter(String name, String value) {
            return target.setInitParameter(name, value);
        }

        @Override
        public String getInitParameter(String name) {
            return target.getInitParameter(name);
        }

        @Override
        public Set<String> setInitParameters(Map<String, String> initParameters) {
            return target.setInitParameters(initParameters);
        }

        @Override
        public Map<String, String> getInitParameters() {
            return target.getInitParameters();
        }

        @Override
        public void setAsyncSupported(boolean isAsyncSupported) {
            target.setAsyncSupported(isAsyncSupported);
        }
    }

    final class RequestDispatcher extends ServletShim.Facade<jakarta.servlet.RequestDispatcher> implements javax.servlet.RequestDispatcher {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        RequestDispatcher(jakarta.servlet.RequestDispatcher target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void forward(
            javax.servlet.ServletRequest request,
            javax.servlet.ServletResponse response
        ) throws javax.servlet.ServletException, IOException {
            try {
                target.forward(request, response);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void forward(
            jakarta.servlet.ServletRequest request,
            jakarta.servlet.ServletResponse response
        ) throws javax.servlet.ServletException, IOException {
            try {
                target.forward(request, response);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void include(
            javax.servlet.ServletRequest request,
            javax.servlet.ServletResponse response
        ) throws javax.servlet.ServletException, IOException {
            try {
                target.include(request, response);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void include(
            jakarta.servlet.ServletRequest request,
            jakarta.servlet.ServletResponse response
        ) throws javax.servlet.ServletException, IOException {
            try {
                target.include(request, response);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }
    }

    final class Servlet extends ServletShim.Facade<jakarta.servlet.Servlet> implements javax.servlet.Servlet {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Servlet(jakarta.servlet.Servlet target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void init(javax.servlet.ServletConfig config) throws javax.servlet.ServletException {
            try {
                target.init(config);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void init(jakarta.servlet.ServletConfig config) throws javax.servlet.ServletException {
            try {
                target.init(config);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void service(
            javax.servlet.ServletRequest request,
            javax.servlet.ServletResponse response
        ) throws javax.servlet.ServletException, IOException {
            try {
                target.service(request, response);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void service(
            jakarta.servlet.ServletRequest request,
            jakarta.servlet.ServletResponse response
        ) throws javax.servlet.ServletException, IOException {
            try {
                target.service(request, response);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public javax.servlet.ServletConfig getServletConfig() {
            return ServletShim.of(target.getServletConfig());
        }

        @Override
        public String getServletInfo() {
            return target.getServletInfo();
        }

        @Override
        public void destroy() {
            target.destroy();
        }
    }

    final class ServletConfig extends ServletShim.Facade<jakarta.servlet.ServletConfig> implements javax.servlet.ServletConfig {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ServletConfig(jakarta.servlet.ServletConfig target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.servlet.ServletContext getServletContext() {
            return ServletShim.of(target.getServletContext());
        }

        @Override
        public String getServletName() {
            return target.getServletName();
        }

        @Override
        public String getInitParameter(String name) {
            return target.getInitParameter(name);
        }

        @Override
        public Enumeration<String> getInitParameterNames() {
            return target.getInitParameterNames();
        }
    }

    final class ServletConnection extends ServletShim.Facade<jakarta.servlet.ServletConnection> implements javax.servlet.ServletConnection {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ServletConnection(jakarta.servlet.ServletConnection target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getConnectionId() {
            return target.getConnectionId();
        }

        @Override
        public String getProtocol() {
            return target.getProtocol();
        }

        @Override
        public String getProtocolConnectionId() {
            return target.getProtocolConnectionId();
        }

        @Override
        public boolean isSecure() {
            return target.isSecure();
        }
    }

    final class ServletContainerInitializer extends ServletShim.Facade<jakarta.servlet.ServletContainerInitializer> implements javax.servlet.ServletContainerInitializer {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ServletContainerInitializer(jakarta.servlet.ServletContainerInitializer target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void onStartup(
            Set<Class<?>> classes,
            javax.servlet.ServletContext context
        ) throws javax.servlet.ServletException {
            try {
                target.onStartup(classes, context);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void onStartup(
            Set<Class<?>> classes,
            jakarta.servlet.ServletContext context
        ) throws javax.servlet.ServletException {
            try {
                target.onStartup(classes, context);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }
    }

    final class ServletContext extends ServletShim.Facade<jakarta.servlet.ServletContext> implements javax.servlet.ServletContext {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ServletContext(jakarta.servlet.ServletContext target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getContextPath() {
            return target.getContextPath();
        }

        @Override
        public javax.servlet.ServletContext getContext(String uriPath) {
            return ServletShim.of(target.getContext(uriPath));
        }

        @Override
        public int getMajorVersion() {
            return target.getMajorVersion();
        }

        @Override
        public int getMinorVersion() {
            return target.getMinorVersion();
        }

        @Override
        public int getEffectiveMajorVersion() {
            return target.getEffectiveMajorVersion();
        }

        @Override
        public int getEffectiveMinorVersion() {
            return target.getEffectiveMinorVersion();
        }

        @Override
        public String getMimeType(String file) {
            return target.getMimeType(file);
        }

        @Override
        public Set<String> getResourcePaths(String path) {
            return target.getResourcePaths(path);
        }

        @Override
        public URL getResource(String path) throws MalformedURLException {
            return target.getResource(path);
        }

        @Override
        public InputStream getResourceAsStream(String path) {
            return target.getResourceAsStream(path);
        }

        @Override
        public javax.servlet.RequestDispatcher getRequestDispatcher(String path) {
            return ServletShim.of(target.getRequestDispatcher(path));
        }

        @Override
        public javax.servlet.RequestDispatcher getNamedDispatcher(String name) {
            return ServletShim.of(target.getNamedDispatcher(name));
        }

        @Override
        public void log(String message) {
            target.log(message);
        }

        @Override
        public void log(String message, Throwable cause) {
            target.log(message, cause);
        }

        @Override
        public String getRealPath(String path) {
            return target.getRealPath(path);
        }

        @Override
        public String getServerInfo() {
            return target.getServerInfo();
        }

        @Override
        public String getInitParameter(String name) {
            return target.getInitParameter(name);
        }

        @Override
        public Enumeration<String> getInitParameterNames() {
            return target.getInitParameterNames();
        }

        @Override
        public boolean setInitParameter(String name, String value) {
            return target.setInitParameter(name, value);
        }

        @Override
        public Object getAttribute(String name) {
            return target.getAttribute(name);
        }

        @Override
        public Enumeration<String> getAttributeNames() {
            return target.getAttributeNames();
        }

        @Override
        public void setAttribute(String name, Object object) {
            target.setAttribute(name, object);
        }

        @Override
        public void removeAttribute(String name) {
            target.removeAttribute(name);
        }

        @Override
        public String getServletContextName() {
            return target.getServletContextName();
        }

        @Override
        public javax.servlet.ServletRegistration.Dynamic addServlet(String name, String className) {
            return ServletShim.of(target.addServlet(name, className));
        }

        @Override
        public javax.servlet.ServletRegistration.Dynamic addServlet(String name, javax.servlet.Servlet servlet) {
            return ServletShim.of(target.addServlet(name, servlet));
        }

        @Override
        public javax.servlet.ServletRegistration.Dynamic addServlet(String name, jakarta.servlet.Servlet servlet) {
            return ServletShim.of(target.addServlet(name, servlet));
        }

        @Override
        public javax.servlet.ServletRegistration.Dynamic addServlet(String name, Class clazz) {
            return ServletShim.of(target.addServlet(name, clazz.asSubclass(jakarta.servlet.Servlet.class)));
        }

        @Override
        public javax.servlet.ServletRegistration.Dynamic addJspFile(String name, String file) {
            return ServletShim.of(target.addJspFile(name, file));
        }

        @Override
        public javax.servlet.Servlet createServlet(Class clazz) throws javax.servlet.ServletException {
            try {
                return ServletShim.of(target.createServlet(clazz.asSubclass(jakarta.servlet.Servlet.class)));
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public javax.servlet.ServletRegistration getServletRegistration(String name) {
            return ServletShim.of(target.getServletRegistration(name));
        }

        @Override
        public Map getServletRegistrations() {
            return target
                .getServletRegistrations()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    ((Function<Object, javax.servlet.ServletRegistration>) ServletShim::of).compose(Map.Entry::getValue)
                ));
        }

        @Override
        public javax.servlet.FilterRegistration.Dynamic addFilter(String name, String className) {
            return ServletShim.of(target.addFilter(name, className));
        }

        @Override
        public javax.servlet.FilterRegistration.Dynamic addFilter(String name, javax.servlet.Filter filter) {
            return ServletShim.of(target.addFilter(name, filter));
        }

        @Override
        public javax.servlet.FilterRegistration.Dynamic addFilter(String name, jakarta.servlet.Filter filter) {
            return ServletShim.of(target.addFilter(name, filter));
        }

        @Override
        public javax.servlet.FilterRegistration.Dynamic addFilter(String name, Class clazz) {
            return ServletShim.of(target.addFilter(name, clazz.asSubclass(jakarta.servlet.Filter.class)));
        }

        @Override
        public javax.servlet.Filter createFilter(Class clazz) throws javax.servlet.ServletException {
            try {
                return ServletShim.of(target.createFilter(clazz.asSubclass(jakarta.servlet.Filter.class)));
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public javax.servlet.FilterRegistration getFilterRegistration(String name) {
            return ServletShim.of(target.getFilterRegistration(name));
        }

        @Override
        public Map getFilterRegistrations() {
            return target
                .getFilterRegistrations()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    ((Function<Object, javax.servlet.FilterRegistration>) ServletShim::of).compose(Map.Entry::getValue)
                ));
        }

        @Override
        public SessionCookieConfig getSessionCookieConfig() {
            return ServletShim.of(target.getSessionCookieConfig());
        }

        @Override
        public void setSessionTrackingModes(Set sessionTrackingModes) {
            target.setSessionTrackingModes(Shim.Enum.toJakarta(jakarta.servlet.SessionTrackingMode.class, sessionTrackingModes));
        }

        @Override
        public Set getDefaultSessionTrackingModes() {
            return ServletShim
                .<javax.servlet.SessionTrackingMode>of(target.getDefaultSessionTrackingModes())
                .collect(Collectors.toCollection(LinkedHashSet::new));
        }

        @Override
        public Set getEffectiveSessionTrackingModes() {
            return ServletShim
                .<javax.servlet.SessionTrackingMode>of(target.getEffectiveSessionTrackingModes())
                .collect(Collectors.toCollection(LinkedHashSet::new));
        }

        @Override
        public void addListener(String className) {
            target.addListener(className);
        }

        @Override
        public <T extends EventListener> void addListener(T listener) {
            target.addListener(listener);
        }

        @Override
        public void addListener(Class<? extends EventListener> clazz) {
            target.addListener(clazz);
        }

        @Override
        public <T extends EventListener> T createListener(Class<T> clazz) throws javax.servlet.ServletException {
            try {
                return target.createListener(clazz);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public javax.servlet.descriptor.JspConfigDescriptor getJspConfigDescriptor() {
            return ServletShim.of(target.getJspConfigDescriptor());
        }

        @Override
        public ClassLoader getClassLoader() {
            return target.getClassLoader();
        }

        @Override
        public void declareRoles(String... roleNames) {
            target.declareRoles(roleNames);
        }

        @Override
        public String getVirtualServerName() {
            return target.getVirtualServerName();
        }

        @Override
        public int getSessionTimeout() {
            return target.getSessionTimeout();
        }

        @Override
        public void setSessionTimeout(int sessionTimeout) {
            target.setSessionTimeout(sessionTimeout);
        }

        @Override
        public String getRequestCharacterEncoding() {
            return target.getRequestCharacterEncoding();
        }

        @Override
        public void setRequestCharacterEncoding(String encoding) {
            target.setRequestCharacterEncoding(encoding);
        }

        @Override
        public String getResponseCharacterEncoding() {
            return target.getResponseCharacterEncoding();
        }

        @Override
        public void setResponseCharacterEncoding(String encoding) {
            target.setResponseCharacterEncoding(encoding);
        }
    }

    final class ServletContextAttributeEvent extends javax.servlet.ServletContextAttributeEvent {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        private final jakarta.servlet.ServletContextAttributeEvent target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ServletContextAttributeEvent(jakarta.servlet.ServletContextAttributeEvent target) {
            super(ServletShim.of(target.getServletContext()), target.getName(), target.getValue());
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getName() {
            return target.getName();
        }

        @Override
        public Object getValue() {
            return target.getValue();
        }

        @Override
        public javax.servlet.ServletContext getServletContext() {
            return ServletShim.of(target.getServletContext());
        }

        @Override
        public Object getSource() {
            return target.getSource();
        }

        @Override
        public String toString() {
            return target.toString();
        }
    }

    final class ServletContextAttributeListener extends ServletShim.Facade<jakarta.servlet.ServletContextAttributeListener> implements javax.servlet.ServletContextAttributeListener {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ServletContextAttributeListener(jakarta.servlet.ServletContextAttributeListener target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void attributeAdded(javax.servlet.ServletContextAttributeEvent event) {
            target.attributeAdded(new jakarta.servlet.ServletContextAttributeEvent(
                event.getServletContext(),
                event.getName(),
                event.getValue()
            ));
        }

        @Override
        public void attributeAdded(jakarta.servlet.ServletContextAttributeEvent event) {
            target.attributeAdded(event);
        }

        @Override
        public void attributeRemoved(javax.servlet.ServletContextAttributeEvent event) {
            target.attributeRemoved(new jakarta.servlet.ServletContextAttributeEvent(
                event.getServletContext(),
                event.getName(),
                event.getValue()
            ));
        }

        @Override
        public void attributeRemoved(jakarta.servlet.ServletContextAttributeEvent event) {
            target.attributeRemoved(event);
        }

        @Override
        public void attributeReplaced(javax.servlet.ServletContextAttributeEvent event) {
            target.attributeReplaced(new jakarta.servlet.ServletContextAttributeEvent(
                event.getServletContext(),
                event.getName(),
                event.getValue()
            ));
        }

        @Override
        public void attributeReplaced(jakarta.servlet.ServletContextAttributeEvent event) {
            target.attributeReplaced(event);
        }
    }

    final class ServletContextEvent extends javax.servlet.ServletContextEvent {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        private final jakarta.servlet.ServletContextEvent target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ServletContextEvent(jakarta.servlet.ServletContextEvent target) {
            super(ServletShim.of(target.getServletContext()));
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.servlet.ServletContext getServletContext() {
            return ServletShim.of(target.getServletContext());
        }

        @Override
        public Object getSource() {
            return target.getSource();
        }

        @Override
        public String toString() {
            return target.toString();
        }
    }

    final class ServletContextListener extends ServletShim.Facade<jakarta.servlet.ServletContextListener> implements javax.servlet.ServletContextListener {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ServletContextListener(jakarta.servlet.ServletContextListener target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void contextInitialized(javax.servlet.ServletContextEvent event) {
            target.contextInitialized(event);
        }

        @Override
        public void contextInitialized(jakarta.servlet.ServletContextEvent event) {
            target.contextInitialized(event);
        }

        @Override
        public void contextDestroyed(javax.servlet.ServletContextEvent event) {
            target.contextDestroyed(event);
        }

        @Override
        public void contextDestroyed(jakarta.servlet.ServletContextEvent event) {
            target.contextDestroyed(event);
        }
    }

    final class ServletRequestAttributeEvent extends javax.servlet.ServletRequestAttributeEvent {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        private final jakarta.servlet.ServletRequestAttributeEvent target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ServletRequestAttributeEvent(jakarta.servlet.ServletRequestAttributeEvent target) {
            super(ServletShim.of(target.getServletContext()), target.getName(), target.getValue());
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getName() {
            return target.getName();
        }

        @Override
        public Object getValue() {
            return target.getValue();
        }

        @Override
        public javax.servlet.ServletContext getServletContext() {
            return ServletShim.of(target.getServletContext());
        }

        @Override
        public javax.servlet.ServletRequest getServletRequest() {
            return ServletShim.of(target.getServletRequest());
        }

        @Override
        public Object getSource() {
            return target.getSource();
        }

        @Override
        public String toString() {
            return target.toString();
        }
    }

    final class ServletRequestAttributeListener extends ServletShim.Facade<jakarta.servlet.ServletRequestAttributeListener> implements javax.servlet.ServletRequestAttributeListener {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ServletRequestAttributeListener(jakarta.servlet.ServletRequestAttributeListener target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void attributeAdded(javax.servlet.ServletRequestAttributeEvent event) {
            target.attributeAdded(new jakarta.servlet.ServletRequestAttributeEvent(
                event.getServletContext(),
                event.getServletRequest(),
                event.getName(),
                event.getValue()
            ));
        }

        @Override
        public void attributeAdded(jakarta.servlet.ServletRequestAttributeEvent event) {
            target.attributeAdded(event);
        }

        @Override
        public void attributeRemoved(javax.servlet.ServletRequestAttributeEvent event) {
            target.attributeRemoved(new jakarta.servlet.ServletRequestAttributeEvent(
                event.getServletContext(),
                event.getServletRequest(),
                event.getName(),
                event.getValue()
            ));
        }

        @Override
        public void attributeRemoved(jakarta.servlet.ServletRequestAttributeEvent event) {
            target.attributeRemoved(event);
        }

        @Override
        public void attributeReplaced(javax.servlet.ServletRequestAttributeEvent event) {
            target.attributeReplaced(new jakarta.servlet.ServletRequestAttributeEvent(
                event.getServletContext(),
                event.getServletRequest(),
                event.getName(),
                event.getValue()
            ));
        }

        @Override
        public void attributeReplaced(jakarta.servlet.ServletRequestAttributeEvent event) {
            target.attributeReplaced(event);
        }
    }

    final class ServletRequestEvent extends javax.servlet.ServletRequestEvent {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        private final jakarta.servlet.ServletRequestEvent target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ServletRequestEvent(jakarta.servlet.ServletRequestEvent target) {
            super(ServletShim.of(target.getServletRequest()));
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.servlet.ServletRequest getServletRequest() {
            return ServletShim.of(target.getServletRequest());
        }

        @Override
        public javax.servlet.ServletContext getServletContext() {
            return ServletShim.of(target.getServletContext());
        }

        @Override
        public Object getSource() {
            return target.getSource();
        }

        @Override
        public String toString() {
            return target.toString();
        }
    }

    final class ServletRequestListener extends ServletShim.Facade<jakarta.servlet.ServletRequestListener> implements javax.servlet.ServletRequestListener {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ServletRequestListener(jakarta.servlet.ServletRequestListener target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void requestInitialized(javax.servlet.ServletRequestEvent event) {
            target.requestInitialized(event);
        }

        @Override
        public void requestInitialized(jakarta.servlet.ServletRequestEvent event) {
            target.requestInitialized(event);
        }

        @Override
        public void requestDestroyed(javax.servlet.ServletRequestEvent event) {
            target.requestDestroyed(event);
        }

        @Override
        public void requestDestroyed(jakarta.servlet.ServletRequestEvent event) {
            target.requestDestroyed(event);
        }
    }

    final class ServletException extends javax.servlet.ServletException {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        private final jakarta.servlet.ServletException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ServletException(jakarta.servlet.ServletException target) {
            super(target.getMessage(), target.getRootCause());
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Throwable getRootCause() {
            return target.getRootCause();
        }

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public String getLocalizedMessage() {
            return target.getLocalizedMessage();
        }

        @Override
        public Throwable getCause() {
            return target.getCause();
        }

        @Override
        public Throwable initCause(Throwable cause) {
            return target.initCause(cause);
        }

        @Override
        public String toString() {
            return target.toString();
        }

        @Override
        public void printStackTrace() {
            target.printStackTrace();
        }

        @Override
        public void printStackTrace(PrintStream s) {
            target.printStackTrace(s);
        }

        @Override
        public void printStackTrace(PrintWriter s) {
            target.printStackTrace(s);
        }

        @Override
        public Throwable fillInStackTrace() {
            try {
                return super.fillInStackTrace();
            } finally {
                if (target != null) {
                    target.fillInStackTrace();
                }
            }
        }

        @Override
        public StackTraceElement[] getStackTrace() {
            return target.getStackTrace();
        }

        @Override
        public void setStackTrace(StackTraceElement[] stackTrace) {
            target.setStackTrace(stackTrace);
        }
    }

    final class ServletInputStream extends javax.servlet.ServletInputStream {
        private final jakarta.servlet.ServletInputStream target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ServletInputStream(jakarta.servlet.ServletInputStream target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public int readLine(byte[] b, int off, int len) throws IOException {
            return target.readLine(b, off, len);
        }

        @Override
        public boolean isFinished() {
            return target.isFinished();
        }

        @Override
        public boolean isReady() {
            return target.isReady();
        }

        @Override
        public void setReadListener(javax.servlet.ReadListener readListener) {
            target.setReadListener(readListener);
        }

        @Override
        public void setReadListener(jakarta.servlet.ReadListener readListener) {
            target.setReadListener(readListener);
        }

        @Override
        public int read() throws IOException {
            return target.read();
        }

        @Override
        public int read(byte[] b) throws IOException {
            return target.read(b);
        }

        @Override
        public int read(byte[] b, int off, int len) throws IOException {
            return target.read(b, off, len);
        }

        @Override
        public byte[] readAllBytes() throws IOException {
            return target.readAllBytes();
        }

        @Override
        public byte[] readNBytes(int len) throws IOException {
            return target.readNBytes(len);
        }

        @Override
        public int readNBytes(byte[] b, int off, int len) throws IOException {
            return target.readNBytes(b, off, len);
        }

        @Override
        public long skip(long n) throws IOException {
            return target.skip(n);
        }

        @Override
        public int available() throws IOException {
            return target.available();
        }

        @Override
        public void close() throws IOException {
            target.close();
        }

        @Override
        public void mark(int limit) {
            target.mark(limit);
        }

        @Override
        public void reset() throws IOException {
            target.reset();
        }

        @Override
        public boolean markSupported() {
            return target.markSupported();
        }

        @Override
        public long transferTo(OutputStream out) throws IOException {
            return target.transferTo(out);
        }
    }

    final class ServletOutputStream extends javax.servlet.ServletOutputStream {
        private final jakarta.servlet.ServletOutputStream target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ServletOutputStream(jakarta.servlet.ServletOutputStream target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void print(String s) throws IOException {
            target.print(s);
        }

        @Override
        public void print(boolean b) throws IOException {
            target.print(b);
        }

        @Override
        public void print(char c) throws IOException {
            target.print(c);
        }

        @Override
        public void print(int i) throws IOException {
            target.print(i);
        }

        @Override
        public void print(long l) throws IOException {
            target.print(l);
        }

        @Override
        public void print(float f) throws IOException {
            target.print(f);
        }

        @Override
        public void print(double d) throws IOException {
            target.print(d);
        }

        @Override
        public void println() throws IOException {
            target.println();
        }

        @Override
        public void println(String s) throws IOException {
            target.println(s);
        }

        @Override
        public void println(boolean b) throws IOException {
            target.println(b);
        }

        @Override
        public void println(char c) throws IOException {
            target.println(c);
        }

        @Override
        public void println(int i) throws IOException {
            target.println(i);
        }

        @Override
        public void println(long l) throws IOException {
            target.println(l);
        }

        @Override
        public void println(float f) throws IOException {
            target.println(f);
        }

        @Override
        public void println(double d) throws IOException {
            target.println(d);
        }

        @Override
        public boolean isReady() {
            return target.isReady();
        }

        @Override
        public void setWriteListener(javax.servlet.WriteListener writeListener) {
            target.setWriteListener(writeListener);
        }

        @Override
        public void setWriteListener(jakarta.servlet.WriteListener writeListener) {
            target.setWriteListener(writeListener);
        }

        @Override
        public void write(int b) throws IOException {
            target.write(b);
        }

        @Override
        public void write(byte[] b) throws IOException {
            target.write(b);
        }

        @Override
        public void write(byte[] b, int off, int len) throws IOException {
            target.write(b, off, len);
        }

        @Override
        public void flush() throws IOException {
            target.flush();
        }

        @Override
        public void close() throws IOException {
            target.close();
        }
    }

    final class ServletRegistration extends ServletShim.Facade<jakarta.servlet.ServletRegistration> implements javax.servlet.ServletRegistration {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ServletRegistration(jakarta.servlet.ServletRegistration target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Set<String> addMapping(String... urlPatterns) {
            return target.addMapping(urlPatterns);
        }

        @Override
        public Collection<String> getMappings() {
            return target.getMappings();
        }

        @Override
        public String getRunAsRole() {
            return target.getRunAsRole();
        }

        @Override
        public String getName() {
            return target.getName();
        }

        @Override
        public String getClassName() {
            return target.getClassName();
        }

        @Override
        public boolean setInitParameter(String name, String value) {
            return target.setInitParameter(name, value);
        }

        @Override
        public String getInitParameter(String name) {
            return target.getInitParameter(name);
        }

        @Override
        public Set<String> setInitParameters(Map<String, String> initParameters) {
            return target.setInitParameters(initParameters);
        }

        @Override
        public Map<String, String> getInitParameters() {
            return target.getInitParameters();
        }
    }

    final class ServletRegistration$Dynamic extends ServletShim.Facade<jakarta.servlet.ServletRegistration.Dynamic> implements javax.servlet.ServletRegistration.Dynamic {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ServletRegistration$Dynamic(jakarta.servlet.ServletRegistration.Dynamic target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Set<String> addMapping(String... urlPatterns) {
            return target.addMapping(urlPatterns);
        }

        @Override
        public Collection<String> getMappings() {
            return target.getMappings();
        }

        @Override
        public String getRunAsRole() {
            return target.getRunAsRole();
        }

        @Override
        public void setRunAsRole(String roleName) {
            target.setRunAsRole(roleName);
        }

        @Override
        public void setLoadOnStartup(int loadOnStartup) {
            target.setLoadOnStartup(loadOnStartup);
        }

        @Override
        public Set<String> setServletSecurity(javax.servlet.ServletSecurityElement constraint) {
            // This is a little more involved since the shim's hierarchy diverged.
            final var methodConstraints =
                constraint
                    .getHttpMethodConstraints()
                    .stream()
                    .map(methodConstraint -> new jakarta.servlet.HttpMethodConstraintElement(
                        methodConstraint.getMethodName(),
                        methodConstraint
                    ))
                    .collect(Collectors.toList());
            return target.setServletSecurity(new jakarta.servlet.ServletSecurityElement(constraint, methodConstraints));
        }

        @Override
        public Set<String> setServletSecurity(jakarta.servlet.ServletSecurityElement constraint) {
            return target.setServletSecurity(constraint);
        }

        @Override
        public void setMultipartConfig(javax.servlet.MultipartConfigElement multipartConfig) {
            target.setMultipartConfig(multipartConfig);
        }

        @Override
        public void setMultipartConfig(jakarta.servlet.MultipartConfigElement multipartConfig) {
            target.setMultipartConfig(multipartConfig);
        }

        @Override
        public String getName() {
            return target.getName();
        }

        @Override
        public String getClassName() {
            return target.getClassName();
        }

        @Override
        public boolean setInitParameter(String name, String value) {
            return target.setInitParameter(name, value);
        }

        @Override
        public String getInitParameter(String name) {
            return target.getInitParameter(name);
        }

        @Override
        public Set<String> setInitParameters(Map<String, String> initParameters) {
            return target.setInitParameters(initParameters);
        }

        @Override
        public Map<String, String> getInitParameters() {
            return target.getInitParameters();
        }

        @Override
        public void setAsyncSupported(boolean isAsyncSupported) {
            target.setAsyncSupported(isAsyncSupported);
        }
    }

    final class ServletRequest extends ServletShim.Facade<jakarta.servlet.ServletRequest> implements javax.servlet.ServletRequest {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ServletRequest(jakarta.servlet.ServletRequest target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Object getAttribute(String name) {
            return target.getAttribute(name);
        }

        @Override
        public Enumeration<String> getAttributeNames() {
            return target.getAttributeNames();
        }

        @Override
        public String getCharacterEncoding() {
            return target.getCharacterEncoding();
        }

        @Override
        public void setCharacterEncoding(String encoding) throws UnsupportedEncodingException {
            target.setCharacterEncoding(encoding);
        }

        @Override
        public int getContentLength() {
            return target.getContentLength();
        }

        @Override
        public long getContentLengthLong() {
            return target.getContentLengthLong();
        }

        @Override
        public String getContentType() {
            return target.getContentType();
        }

        @Override
        public javax.servlet.ServletInputStream getInputStream() throws IOException {
            return ServletShim.of(target.getInputStream());
        }

        @Override
        public String getParameter(String name) {
            return target.getParameter(name);
        }

        @Override
        public Enumeration<String> getParameterNames() {
            return target.getParameterNames();
        }

        @Override
        public String[] getParameterValues(String name) {
            return target.getParameterValues(name);
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            return target.getParameterMap();
        }

        @Override
        public String getProtocol() {
            return target.getProtocol();
        }

        @Override
        public String getScheme() {
            return target.getScheme();
        }

        @Override
        public String getServerName() {
            return target.getServerName();
        }

        @Override
        public int getServerPort() {
            return target.getServerPort();
        }

        @Override
        public BufferedReader getReader() throws IOException {
            return target.getReader();
        }

        @Override
        public String getRemoteAddr() {
            return target.getRemoteAddr();
        }

        @Override
        public String getRemoteHost() {
            return target.getRemoteHost();
        }

        @Override
        public void setAttribute(String name, Object o) {
            target.setAttribute(name, o);
        }

        @Override
        public void removeAttribute(String name) {
            target.removeAttribute(name);
        }

        @Override
        public Locale getLocale() {
            return target.getLocale();
        }

        @Override
        public Enumeration<Locale> getLocales() {
            return target.getLocales();
        }

        @Override
        public boolean isSecure() {
            return target.isSecure();
        }

        @Override
        public javax.servlet.RequestDispatcher getRequestDispatcher(String path) {
            return ServletShim.of(target.getRequestDispatcher(path));
        }

        @Override
        public int getRemotePort() {
            return target.getRemotePort();
        }

        @Override
        public String getLocalName() {
            return target.getLocalName();
        }

        @Override
        public String getLocalAddr() {
            return target.getLocalAddr();
        }

        @Override
        public int getLocalPort() {
            return target.getLocalPort();
        }

        @Override
        public javax.servlet.ServletContext getServletContext() {
            return ServletShim.of(target.getServletContext());
        }

        @Override
        public javax.servlet.AsyncContext startAsync() throws IllegalStateException {
            return ServletShim.of(target.startAsync());
        }

        @Override
        public javax.servlet.AsyncContext startAsync(
            javax.servlet.ServletRequest request,
            javax.servlet.ServletResponse response
        ) throws IllegalStateException {
            return ServletShim.of(target.startAsync(request, response));
        }

        @Override
        public javax.servlet.AsyncContext startAsync(
            jakarta.servlet.ServletRequest request,
            jakarta.servlet.ServletResponse response
        ) throws IllegalStateException {
            return ServletShim.of(target.startAsync(request, response));
        }

        @Override
        public boolean isAsyncStarted() {
            return target.isAsyncStarted();
        }

        @Override
        public boolean isAsyncSupported() {
            return target.isAsyncSupported();
        }

        @Override
        public javax.servlet.AsyncContext getAsyncContext() {
            return ServletShim.of(target.getAsyncContext());
        }

        @Override
        public jakarta.servlet.DispatcherType getDispatcherType() {
            return target.getDispatcherType();
        }

        @Override
        public String getRequestId() {
            return target.getRequestId();
        }

        @Override
        public String getProtocolRequestId() {
            return target.getProtocolRequestId();
        }

        @Override
        public javax.servlet.ServletConnection getServletConnection() {
            return ServletShim.of(target.getServletConnection());
        }
    }

    final class ServletRequestWrapper extends javax.servlet.ServletRequestWrapper {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ServletRequestWrapper(jakarta.servlet.ServletRequest target) {
            super(target);
        }
    }

    final class ServletResponse extends ServletShim.Facade<jakarta.servlet.ServletResponse> implements javax.servlet.ServletResponse {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ServletResponse(jakarta.servlet.ServletResponse target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getCharacterEncoding() {
            return target.getCharacterEncoding();
        }

        @Override
        public String getContentType() {
            return target.getContentType();
        }

        @Override
        public javax.servlet.ServletOutputStream getOutputStream() throws IOException {
            return ServletShim.of(target.getOutputStream());
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            return target.getWriter();
        }

        @Override
        public void setCharacterEncoding(String charset) {
            target.setCharacterEncoding(charset);
        }

        @Override
        public void setContentLength(int len) {
            target.setContentLength(len);
        }

        @Override
        public void setContentLengthLong(long len) {
            target.setContentLengthLong(len);
        }

        @Override
        public void setContentType(String type) {
            target.setContentType(type);
        }

        @Override
        public void setBufferSize(int size) {
            target.setBufferSize(size);
        }

        @Override
        public int getBufferSize() {
            return target.getBufferSize();
        }

        @Override
        public void flushBuffer() throws IOException {
            target.flushBuffer();
        }

        @Override
        public void resetBuffer() {
            target.resetBuffer();
        }

        @Override
        public boolean isCommitted() {
            return target.isCommitted();
        }

        @Override
        public void reset() {
            target.reset();
        }

        @Override
        public void setLocale(Locale loc) {
            target.setLocale(loc);
        }

        @Override
        public Locale getLocale() {
            return target.getLocale();
        }
    }

    final class ServletResponseWrapper extends javax.servlet.ServletResponseWrapper {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ServletResponseWrapper(jakarta.servlet.ServletResponseWrapper target) {
            super(target);
        }
    }

    final class ServletSecurityElement extends javax.servlet.ServletSecurityElement {
        private final jakarta.servlet.ServletSecurityElement target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ServletSecurityElement(jakarta.servlet.ServletSecurityElement target) {
            super(target);
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Collection<javax.servlet.HttpMethodConstraintElement> getHttpMethodConstraints() {
            return ServletShim
                .<javax.servlet.HttpMethodConstraintElement>of(target.getHttpMethodConstraints())
                .collect(Collectors.toList());
        }

        @Override
        public Collection<String> getMethodNames() {
            return target.getMethodNames();
        }

        @Override
        public jakarta.servlet.annotation.ServletSecurity.EmptyRoleSemantic getEmptyRoleSemantic() {
            return target.getEmptyRoleSemantic();
        }

        @Override
        public jakarta.servlet.annotation.ServletSecurity.TransportGuarantee getTransportGuarantee() {
            return target.getTransportGuarantee();
        }

        @Override
        public String[] getRolesAllowed() {
            return target.getRolesAllowed();
        }
    }

    final class SessionCookieConfig extends ServletShim.Facade<jakarta.servlet.SessionCookieConfig> implements javax.servlet.SessionCookieConfig {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        SessionCookieConfig(jakarta.servlet.SessionCookieConfig target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void setName(String name) {
            target.setName(name);
        }

        @Override
        public String getName() {
            return target.getName();
        }

        @Override
        public void setDomain(String domain) {
            target.setDomain(domain);
        }

        @Override
        public String getDomain() {
            return target.getDomain();
        }

        @Override
        public void setPath(String path) {
            target.setPath(path);
        }

        @Override
        public String getPath() {
            return target.getPath();
        }

        @Override
        @SuppressWarnings("removal")
        public void setComment(String comment) {
            target.setComment(comment);
        }

        @Override
        @SuppressWarnings("removal")
        public String getComment() {
            return target.getComment();
        }

        @Override
        public void setHttpOnly(boolean httpOnly) {
            target.setHttpOnly(httpOnly);
        }

        @Override
        public boolean isHttpOnly() {
            return target.isHttpOnly();
        }

        @Override
        public void setSecure(boolean secure) {
            target.setSecure(secure);
        }

        @Override
        public boolean isSecure() {
            return target.isSecure();
        }

        @Override
        public void setMaxAge(int maxAge) {
            target.setMaxAge(maxAge);
        }

        @Override
        public int getMaxAge() {
            return target.getMaxAge();
        }

        @Override
        public void setAttribute(String name, String value) {
            target.setAttribute(name, value);
        }

        @Override
        public String getAttribute(String name) {
            return target.getAttribute(name);
        }

        @Override
        public Map<String, String> getAttributes() {
            return target.getAttributes();
        }
    }

    final class UnavailableException extends javax.servlet.UnavailableException {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        private final jakarta.servlet.UnavailableException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        UnavailableException(jakarta.servlet.UnavailableException target) {
            super(target.getMessage(), target.getUnavailableSeconds());
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public boolean isPermanent() {
            return target.isPermanent();
        }

        @Override
        public int getUnavailableSeconds() {
            return target.getUnavailableSeconds();
        }

        @Override
        public Throwable getRootCause() {
            return target.getRootCause();
        }

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public String getLocalizedMessage() {
            return target.getLocalizedMessage();
        }

        @Override
        public Throwable getCause() {
            return target.getCause();
        }

        @Override
        public Throwable initCause(Throwable cause) {
            return target.initCause(cause);
        }

        @Override
        public String toString() {
            return target.toString();
        }

        @Override
        public void printStackTrace() {
            target.printStackTrace();
        }

        @Override
        public void printStackTrace(PrintStream s) {
            target.printStackTrace(s);
        }

        @Override
        public void printStackTrace(PrintWriter s) {
            target.printStackTrace(s);
        }

        @Override
        public Throwable fillInStackTrace() {
            try {
                return super.fillInStackTrace();
            } finally {
                if (target != null) {
                    target.fillInStackTrace();
                }
            }
        }

        @Override
        public StackTraceElement[] getStackTrace() {
            return target.getStackTrace();
        }

        @Override
        public void setStackTrace(StackTraceElement[] stackTrace) {
            target.setStackTrace(stackTrace);
        }
    }

    final class WebConnection extends ServletShim.Facade<jakarta.servlet.http.WebConnection> implements javax.servlet.http.WebConnection {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        WebConnection(jakarta.servlet.http.WebConnection target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.servlet.ServletInputStream getInputStream() throws IOException {
            return ServletShim.of(target.getInputStream());
        }

        @Override
        public javax.servlet.ServletOutputStream getOutputStream() throws IOException {
            return ServletShim.of(target.getOutputStream());
        }

        @Override
        public void close() throws Exception {
            target.close();
        }
    }

    final class WriteListener extends ServletShim.Facade<jakarta.servlet.WriteListener> implements javax.servlet.WriteListener {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        WriteListener(jakarta.servlet.WriteListener target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void onWritePossible() throws IOException {
            target.onWritePossible();
        }

        @Override
        public void onError(Throwable cause) {
            target.onError(cause);
        }
    }
}
