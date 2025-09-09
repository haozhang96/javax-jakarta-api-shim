package javax.servlet.jsp;

import javax.servlet.*;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.BodyContent;
import java.io.IOException;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.PageContext} instead.
 * @apiNote This class cannot extend {@link jakarta.servlet.jsp.PageContext} due to class hierarchy divergence.
 */
@Deprecated(since = "jakarta.servlet.jsp.PageContext")
public abstract class PageContext extends JspContext {
    /**
     * @see jakarta.servlet.jsp.PageContext#PAGE_SCOPE
     */
    public static final int PAGE_SCOPE = jakarta.servlet.jsp.PageContext.PAGE_SCOPE;

    /**
     * @see jakarta.servlet.jsp.PageContext#REQUEST_SCOPE
     */
    public static final int REQUEST_SCOPE = jakarta.servlet.jsp.PageContext.REQUEST_SCOPE;

    /**
     * @see jakarta.servlet.jsp.PageContext#SESSION_SCOPE
     */
    public static final int SESSION_SCOPE = jakarta.servlet.jsp.PageContext.SESSION_SCOPE;

    /**
     * @see jakarta.servlet.jsp.PageContext#APPLICATION_SCOPE
     */
    public static final int APPLICATION_SCOPE = jakarta.servlet.jsp.PageContext.APPLICATION_SCOPE;

    /**
     * @see jakarta.servlet.jsp.PageContext#PAGE
     */
    public static final String PAGE = jakarta.servlet.jsp.PageContext.PAGE;

    /**
     * @see jakarta.servlet.jsp.PageContext#PAGECONTEXT
     */
    public static final String PAGECONTEXT = jakarta.servlet.jsp.PageContext.PAGECONTEXT;

    /**
     * @see jakarta.servlet.jsp.PageContext#REQUEST
     */
    public static final String REQUEST = jakarta.servlet.jsp.PageContext.REQUEST;

    /**
     * @see jakarta.servlet.jsp.PageContext#RESPONSE
     */
    public static final String RESPONSE = jakarta.servlet.jsp.PageContext.RESPONSE;

    /**
     * @see jakarta.servlet.jsp.PageContext#CONFIG
     */
    public static final String CONFIG = jakarta.servlet.jsp.PageContext.CONFIG;

    /**
     * @see jakarta.servlet.jsp.PageContext#SESSION
     */
    public static final String SESSION = jakarta.servlet.jsp.PageContext.SESSION;

    /**
     * @see jakarta.servlet.jsp.PageContext#OUT
     */
    public static final String OUT = jakarta.servlet.jsp.PageContext.OUT;

    /**
     * @see jakarta.servlet.jsp.PageContext#APPLICATION
     */
    public static final String APPLICATION = jakarta.servlet.jsp.PageContext.APPLICATION;

    /**
     * @see jakarta.servlet.jsp.PageContext#EXCEPTION
     */
    public static final String EXCEPTION = jakarta.servlet.jsp.PageContext.EXCEPTION;

    //==================================================================================================================
    // PageContext Implementation Methods
    //==================================================================================================================

    /**
     * @see jakarta.servlet.jsp.PageContext#initialize(jakarta.servlet.Servlet, jakarta.servlet.ServletRequest, jakarta.servlet.ServletResponse, String, boolean, int, boolean)
     */
    public abstract void initialize(
        Servlet servlet,
        ServletRequest request,
        ServletResponse response,
        String errorPageURL,
        boolean needsSession,
        int bufferSize,
        boolean autoFlush
    ) throws IOException, IllegalStateException, IllegalArgumentException;

    /**
     * @see jakarta.servlet.jsp.PageContext#release()
     */
    public abstract void release();

    /**
     * @see jakarta.servlet.jsp.PageContext#getSession()
     */
    public abstract HttpSession getSession();

    /**
     * @see jakarta.servlet.jsp.PageContext#getPage()
     */
    public abstract Object getPage();

    /**
     * @see jakarta.servlet.jsp.PageContext#getRequest()
     */
    public abstract ServletRequest getRequest();

    /**
     * @see jakarta.servlet.jsp.PageContext#getResponse()
     */
    public abstract ServletResponse getResponse();

    /**
     * @see jakarta.servlet.jsp.PageContext#getException()
     */
    public abstract Exception getException();

    /**
     * @see jakarta.servlet.jsp.PageContext#getServletConfig()
     */
    public abstract ServletConfig getServletConfig();

    /**
     * @see jakarta.servlet.jsp.PageContext#getServletContext()
     */
    public abstract ServletContext getServletContext();

    /**
     * @see jakarta.servlet.jsp.PageContext#forward(String)
     */
    public abstract void forward(String relativeURLPath) throws ServletException, IOException;

    /**
     * @see jakarta.servlet.jsp.PageContext#include(String)
     */
    public abstract void include(String relativeURLPath) throws ServletException, IOException;

    /**
     * @see jakarta.servlet.jsp.PageContext#include(String, boolean)
     */
    public abstract void include(String relativeURLPath, boolean flush) throws ServletException, IOException;

    /**
     * @see jakarta.servlet.jsp.PageContext#handlePageException(Exception)
     */
    public abstract void handlePageException(Exception exception) throws ServletException, IOException;

    /**
     * @see jakarta.servlet.jsp.PageContext#handlePageException(Throwable)
     */
    public abstract void handlePageException(Throwable cause) throws ServletException, IOException;

    /**
     * @see jakarta.servlet.jsp.PageContext#pushBody()
     */
    public BodyContent pushBody() {
        return null;
    }

    /**
     * @see jakarta.servlet.jsp.PageContext#getErrorData()
     */
    public ErrorData getErrorData() {
        return new ErrorData(
            (Throwable) getRequest().getAttribute("javax.servlet.error.exception"),
            (int) getRequest().getAttribute("javax.servlet.error.status_code"),
            (String) getRequest().getAttribute("javax.servlet.error.request_uri"),
            (String) getRequest().getAttribute("javax.servlet.error.servlet_name")
        );
    }

    //==================================================================================================================
    // Retrofit
    //==================================================================================================================

    /**
     * @deprecated Use {@link jakarta.servlet.jsp.PageContext} instead.
     */
    @Deprecated(since = "jakarta.servlet.jsp.PageContext")
    public static class Retrofit extends Retrofits.PageContext {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        public Retrofit(PageContext target) {
            super(target);
        }
    }
}
