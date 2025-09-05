package javax.servlet.http;

import javax.servlet.ServletException;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.ServletShim;
import java.io.IOException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;

/**
 * @deprecated Use {@link jakarta.servlet.http.HttpServletRequestWrapper} instead.
 */
@Deprecated(since = "jakarta.servlet.http.HttpServletRequestWrapper")
public class HttpServletRequestWrapper extends ServletRequestWrapper implements HttpServletRequest {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.servlet.http.HttpServletRequestWrapper#HttpServletRequestWrapper(jakarta.servlet.http.HttpServletRequest)
     */
    public HttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    protected HttpServletRequestWrapper(jakarta.servlet.http.HttpServletRequest request) {
        super(request);
    }

    //==================================================================================================================
    // HttpServletRequestWrapper Implementation Methods
    //==================================================================================================================

    @Override
    public HttpServletRequest getRequest() {
        return ServletShim.of(super.getRequest());
    }

    //==================================================================================================================
    // HttpServletRequest Implementation Methods
    //==================================================================================================================

    @Override
    public String getAuthType() {
        return getRequest().getAuthType();
    }

    @Override
    public Cookie[] getCookies() {
        return getRequest().getCookies();
    }

    @Override
    public long getDateHeader(String name) {
        return getRequest().getDateHeader(name);
    }

    @Override
    public String getHeader(String name) {
        return getRequest().getHeader(name);
    }

    @Override
    public Enumeration<String> getHeaders(String name) {
        return getRequest().getHeaders(name);
    }

    @Override
    public Enumeration<String> getHeaderNames() {
        return getRequest().getHeaderNames();
    }

    @Override
    public int getIntHeader(String name) {
        return getRequest().getIntHeader(name);
    }

    @Override
    public HttpServletMapping getHttpServletMapping() {
        return getRequest().getHttpServletMapping();
    }

    @Override
    public String getMethod() {
        return getRequest().getMethod();
    }

    @Override
    public String getPathInfo() {
        return getRequest().getPathInfo();
    }

    @Override
    public String getPathTranslated() {
        return getRequest().getPathTranslated();
    }

    @Override
    public PushBuilder newPushBuilder() {
        return getRequest().newPushBuilder();
    }

    @Override
    public String getContextPath() {
        return getRequest().getContextPath();
    }

    @Override
    public String getQueryString() {
        return getRequest().getQueryString();
    }

    @Override
    public String getRemoteUser() {
        return getRequest().getRemoteUser();
    }

    @Override
    public boolean isUserInRole(String role) {
        return getRequest().isUserInRole(role);
    }

    @Override
    public Principal getUserPrincipal() {
        return getRequest().getUserPrincipal();
    }

    @Override
    public String getRequestedSessionId() {
        return getRequest().getRequestedSessionId();
    }

    @Override
    public String getRequestURI() {
        return getRequest().getRequestURI();
    }

    @Override
    public StringBuffer getRequestURL() {
        return getRequest().getRequestURL();
    }

    @Override
    public String getServletPath() {
        return getRequest().getServletPath();
    }

    @Override
    public HttpSession getSession(boolean create) {
        return getRequest().getSession(create);
    }

    @Override
    public HttpSession getSession() {
        return getRequest().getSession();
    }

    @Override
    public String changeSessionId() {
        return getRequest().changeSessionId();
    }

    @Override
    public boolean isRequestedSessionIdValid() {
        return getRequest().isRequestedSessionIdValid();
    }

    @Override
    public boolean isRequestedSessionIdFromCookie() {
        return getRequest().isRequestedSessionIdFromCookie();
    }

    @Override
    public boolean isRequestedSessionIdFromURL() {
        return getRequest().isRequestedSessionIdFromURL();
    }

    @Override
    public boolean authenticate(HttpServletResponse response) throws ServletException, IOException {
        return getRequest().authenticate(response);
    }

    @Override
    public boolean authenticate(
        jakarta.servlet.http.HttpServletResponse response
    ) throws ServletException, IOException {
        return getRequest().authenticate(response);
    }

    @Override
    public void login(String username, String password) throws ServletException {
        getRequest().login(username, password);
    }

    @Override
    public void logout() throws ServletException {
        getRequest().logout();
    }

    @Override
    @SuppressWarnings("rawtypes")
    public Collection getParts() throws ServletException, IOException {
        return getRequest().getParts();
    }

    @Override
    public Part getPart(String name) throws ServletException, IOException {
        return getRequest().getPart(name);
    }

    @Override
    public HttpUpgradeHandler upgrade(Class clazz) throws ServletException, IOException {
        return getRequest().upgrade(clazz);
    }

    @Override
    public Map<String, String> getTrailerFields() {
        return getRequest().getTrailerFields();
    }

    @Override
    public boolean isTrailerFieldsReady() {
        return getRequest().isTrailerFieldsReady();
    }
}
