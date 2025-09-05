package javax.servlet.http;

import javax.servlet.ServletResponseWrapper;
import javax.servlet.ServletShim;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @deprecated Use {@link jakarta.servlet.http.HttpServletResponseWrapper} instead.
 */
@Deprecated(since = "jakarta.servlet.http.HttpServletResponseWrapper")
public class HttpServletResponseWrapper extends ServletResponseWrapper implements HttpServletResponse {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.servlet.http.HttpServletResponseWrapper#HttpServletResponseWrapper(jakarta.servlet.http.HttpServletResponse)
     */
    public HttpServletResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    protected HttpServletResponseWrapper(jakarta.servlet.http.HttpServletResponse response) {
        super(response);
    }

    //==================================================================================================================
    // HttpServletResponseWrapper Implementation Methods
    //==================================================================================================================

    @Override
    public HttpServletResponse getResponse() {
        return ServletShim.of(super.getResponse());
    }

    //==================================================================================================================
    // HttpServletResponse Implementation Methods
    //==================================================================================================================

    @Override
    public void addCookie(Cookie cookie) {
        getResponse().addCookie(cookie);
    }

    @Override
    public void addCookie(jakarta.servlet.http.Cookie cookie) {
        getResponse().addCookie(cookie);
    }

    @Override
    public boolean containsHeader(String name) {
        return getResponse().containsHeader(name);
    }

    @Override
    public String encodeURL(String url) {
        return getResponse().encodeURL(url);
    }

    @Override
    public String encodeRedirectURL(String url) {
        return getResponse().encodeRedirectURL(url);
    }

    @Override
    public void sendError(int statusCode, String message) throws IOException {
        getResponse().sendError(statusCode, message);
    }

    @Override
    public void sendError(int statusCode) throws IOException {
        getResponse().sendError(statusCode);
    }

    @Override
    public void sendRedirect(String location) throws IOException {
        getResponse().sendRedirect(location);
    }

    @Override
    public void setDateHeader(String name, long date) {
        getResponse().setDateHeader(name, date);
    }

    @Override
    public void addDateHeader(String name, long date) {
        getResponse().addDateHeader(name, date);
    }

    @Override
    public void setHeader(String name, String value) {
        getResponse().setHeader(name, value);
    }

    @Override
    public void addHeader(String name, String value) {
        getResponse().addHeader(name, value);
    }

    @Override
    public void setIntHeader(String name, int value) {
        getResponse().setIntHeader(name, value);
    }

    @Override
    public void addIntHeader(String name, int value) {
        getResponse().addIntHeader(name, value);
    }

    @Override
    public void setStatus(int statusCode) {
        getResponse().setStatus(statusCode);
    }

    @Override
    public int getStatus() {
        return getResponse().getStatus();
    }

    @Override
    public String getHeader(String name) {
        return getResponse().getHeader(name);
    }

    @Override
    public Collection<String> getHeaders(String name) {
        return getResponse().getHeaders(name);
    }

    @Override
    public Collection<String> getHeaderNames() {
        return getResponse().getHeaderNames();
    }

    @Override
    public void setTrailerFields(Supplier<Map<String, String>> supplier) {
        getResponse().setTrailerFields(supplier);
    }

    @Override
    public Supplier<Map<String, String>> getTrailerFields() {
        return getResponse().getTrailerFields();
    }
}
