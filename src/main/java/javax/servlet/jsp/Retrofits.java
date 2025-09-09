package javax.servlet.jsp;

import javax.servlet.ServletShim;
import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;

/**
 * This interface contains {@link javax.servlet.jsp}-to-{@link jakarta.servlet.jsp} retrofits used for wrapping Java
 *   Server Pages objects into their Jakarta Server Pages counterparts.
 *
 * @deprecated Use {@link jakarta.servlet.jsp} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp")
@SuppressWarnings("all")
interface Retrofits {
    //==================================================================================================================
    // Classes
    //==================================================================================================================

    class PageContext extends jakarta.servlet.jsp.PageContext implements JSPShim.Retrofit {
        private final javax.servlet.jsp.PageContext target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        PageContext(javax.servlet.jsp.PageContext target) {
            this.target = target;
        }

        //==============================================================================================================
        // PageContext Implementation Methods
        //==============================================================================================================

        @Override
        public void initialize(
            jakarta.servlet.Servlet servlet,
            jakarta.servlet.ServletRequest request,
            jakarta.servlet.ServletResponse response,
            String errorPageURL,
            boolean needsSession,
            int bufferSize,
            boolean autoFlush
        ) throws IOException, IllegalStateException, IllegalArgumentException {
            target.initialize(
                ServletShim.of(servlet),
                ServletShim.of(request),
                ServletShim.of(response),
                errorPageURL,
                needsSession,
                bufferSize,
                autoFlush
            );
        }

        @Override
        public void release() {
            target.release();
        }

        @Override
        public jakarta.servlet.http.HttpSession getSession() {
            return target.getSession();
        }

        @Override
        public Object getPage() {
            return target.getPage();
        }

        @Override
        public jakarta.servlet.ServletRequest getRequest() {
            return target.getRequest();
        }

        @Override
        public jakarta.servlet.ServletResponse getResponse() {
            return target.getResponse();
        }

        @Override
        public Exception getException() {
            return target.getException();
        }

        @Override
        public jakarta.servlet.ServletConfig getServletConfig() {
            return target.getServletConfig();
        }

        @Override
        public jakarta.servlet.ServletContext getServletContext() {
            return target.getServletContext();
        }

        @Override
        public void forward(String relativeURLPath) throws jakarta.servlet.ServletException, IOException {
            target.forward(relativeURLPath);
        }

        @Override
        public void include(String relativeURLPath) throws jakarta.servlet.ServletException, IOException {
            target.include(relativeURLPath);
        }

        @Override
        public void include(String relativeURLPath, boolean flush) throws jakarta.servlet.ServletException, IOException {
            target.include(relativeURLPath, flush);
        }

        @Override
        public void handlePageException(Exception exception) throws jakarta.servlet.ServletException, IOException {
            target.handlePageException(exception);
        }

        @Override
        public void handlePageException(Throwable cause) throws jakarta.servlet.ServletException, IOException {
            target.handlePageException(cause);
        }

        @Override
        public void setAttribute(String name, Object value) {
            target.setAttribute(name, value);
        }

        @Override
        public void setAttribute(String name, Object value, int scope) {
            target.setAttribute(name, value, scope);
        }

        @Override
        public Object getAttribute(String name) {
            return target.getAttribute(name);
        }

        @Override
        public Object getAttribute(String name, int scope) {
            return target.getAttribute(name, scope);
        }

        @Override
        public Object findAttribute(String name) {
            return target.findAttribute(name);
        }

        @Override
        public void removeAttribute(String name) {
            target.removeAttribute(name);
        }

        @Override
        public void removeAttribute(String name, int scope) {
            target.removeAttribute(name, scope);
        }

        @Override
        public int getAttributesScope(String name) {
            return target.getAttributesScope(name);
        }

        @Override
        public Enumeration<String> getAttributeNamesInScope(int scope) {
            return target.getAttributeNamesInScope(scope);
        }

        @Override
        public jakarta.servlet.jsp.JspWriter getOut() {
            return target.getOut();
        }

        @Override
        public jakarta.servlet.jsp.el.ExpressionEvaluator getExpressionEvaluator() {
            return target.getExpressionEvaluator();
        }

        @Override
        public jakarta.servlet.jsp.el.VariableResolver getVariableResolver() {
            return target.getVariableResolver();
        }

        @Override
        public jakarta.el.ELContext getELContext() {
            return target.getELContext();
        }

        @Override
        public jakarta.servlet.jsp.tagext.BodyContent pushBody() {
            return JSPShim.of(target.pushBody());
        }

        @Override
        public jakarta.servlet.jsp.JspWriter pushBody(Writer writer) {
            return target.pushBody(writer);
        }

        @Override
        public jakarta.servlet.jsp.JspWriter popBody() {
            return target.popBody();
        }

        @Override
        public jakarta.servlet.jsp.ErrorData getErrorData() {
            return JSPShim.of(target.getErrorData());
        }
    }
}
