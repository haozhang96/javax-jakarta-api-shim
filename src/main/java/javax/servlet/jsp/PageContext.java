package javax.servlet.jsp;

import jakarta.servlet.jsp.tagext.BodyContent;

import javax.servlet.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.PageContext} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp.PageContext")
public abstract class PageContext extends JspContext {
    public static final int PAGE_SCOPE = jakarta.servlet.jsp.PageContext.PAGE_SCOPE;
    public static final int REQUEST_SCOPE = jakarta.servlet.jsp.PageContext.REQUEST_SCOPE;
    public static final int SESSION_SCOPE = jakarta.servlet.jsp.PageContext.SESSION_SCOPE;
    public static final int APPLICATION_SCOPE = jakarta.servlet.jsp.PageContext.APPLICATION_SCOPE;
    public static final String PAGE = jakarta.servlet.jsp.PageContext.PAGE;
    public static final String PAGECONTEXT = jakarta.servlet.jsp.PageContext.PAGECONTEXT;
    public static final String REQUEST = jakarta.servlet.jsp.PageContext.REQUEST;
    public static final String RESPONSE = jakarta.servlet.jsp.PageContext.RESPONSE;
    public static final String CONFIG = jakarta.servlet.jsp.PageContext.CONFIG;
    public static final String SESSION = jakarta.servlet.jsp.PageContext.SESSION;
    public static final String OUT = jakarta.servlet.jsp.PageContext.OUT;
    public static final String APPLICATION = jakarta.servlet.jsp.PageContext.APPLICATION;
    public static final String EXCEPTION = jakarta.servlet.jsp.PageContext.EXCEPTION;

    //==================================================================================================================
    // PageContext Implementation Methods
    //==================================================================================================================

    public abstract void initialize(
        Servlet servlet,
        ServletRequest request,
        ServletResponse response,
        String errorPageURL,
        boolean needsSession,
        int bufferSize,
        boolean autoFlush
    ) throws IOException, IllegalStateException, IllegalArgumentException;

    public abstract void release();

    public abstract HttpSession getSession();

    public abstract Object getPage();

    public abstract ServletRequest getRequest();

    public abstract ServletResponse getResponse();

    public abstract Exception getException();

    public abstract ServletConfig getServletConfig();

    public abstract ServletContext getServletContext();

    public abstract void forward(String relativeURLPath) throws ServletException, IOException;

    public abstract void include(String relativeURLPath) throws ServletException, IOException;

    public abstract void include(String relativeURLPath, boolean flush) throws ServletException, IOException;

    public abstract void handlePageException(Exception exception) throws ServletException, IOException;

    public abstract void handlePageException(Throwable cause) throws ServletException, IOException;

    public BodyContent pushBody() {
        return null;
    }

    public ErrorData getErrorData() {
        return new ErrorData(
            (Throwable) getRequest().getAttribute("jakarta.servlet.error.exception"),
            (int) getRequest().getAttribute("jakarta.servlet.error.status_code"),
            (String) getRequest().getAttribute("jakarta.servlet.error.request_uri"),
            (String) getRequest().getAttribute("jakarta.servlet.error.servlet_name")
        );
    }
}
