package javax.servlet.jsp;

import javax.el.ELShim;
import javax.servlet.ServletShim;
import javax.shim.ShimSupport;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Enumeration;

/**
 * This interface contains {@link jakarta.servlet.jsp}-to-{@link javax.servlet.jsp} facades used for wrapping Jakarta
 *   Server Pages objects into their Java Server Pages counterparts.
 *
 * @deprecated Use {@link jakarta.servlet.jsp} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp")
@SuppressWarnings("all")
interface Facades {
    //==================================================================================================================
    // Classes
    //==================================================================================================================

    final class ErrorData extends javax.servlet.jsp.ErrorData {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ErrorData(jakarta.servlet.jsp.ErrorData target) {
            super(target);
        }
    }

    final class JspContext extends javax.servlet.jsp.JspContext {
        private final jakarta.servlet.jsp.JspContext target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        protected JspContext(jakarta.servlet.jsp.JspContext target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Object findAttribute(String name) {
            return target.findAttribute(name);
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
        public void setAttribute(String name, Object value) {
            target.setAttribute(name, value);
        }

        @Override
        public void setAttribute(String name, Object value, int scope) {
            target.setAttribute(name, value, scope);
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

        @Deprecated
        @Override
        public javax.servlet.jsp.el.ExpressionEvaluator getExpressionEvaluator() {
            return JSPShim.of(target.getExpressionEvaluator());
        }

        @Deprecated
        @Override
        public javax.servlet.jsp.el.VariableResolver getVariableResolver() {
            return JSPShim.of(target.getVariableResolver());
        }

        @Override
        public javax.el.ELContext getELContext() {
            return ELShim.of(target.getELContext());
        }

        @Override
        public javax.servlet.jsp.JspWriter getOut() {
            return JSPShim.of(target.getOut());
        }

        @Override
        public javax.servlet.jsp.JspWriter pushBody(Writer writer) {
            return JSPShim.of(target.pushBody(writer));
        }

        @Override
        public javax.servlet.jsp.JspWriter popBody() {
            return JSPShim.of(target.popBody());
        }
    }

    final class JspException extends javax.servlet.jsp.JspException {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        private final jakarta.servlet.jsp.JspException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        JspException(jakarta.servlet.jsp.JspException target) {
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

    final class PageContext extends javax.servlet.jsp.PageContext {
        private final jakarta.servlet.jsp.PageContext target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        PageContext(jakarta.servlet.jsp.PageContext target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void initialize(
            javax.servlet.Servlet servlet,
            javax.servlet.ServletRequest request,
            javax.servlet.ServletResponse response,
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
        public javax.servlet.http.HttpSession getSession() {
            return ServletShim.of(target.getSession());
        }

        @Override
        public Object getPage() {
            return target.getPage();
        }

        @Override
        public javax.servlet.ServletRequest getRequest() {
            return ServletShim.of(target.getRequest());
        }

        @Override
        public javax.servlet.ServletResponse getResponse() {
            return ServletShim.of(target.getResponse());
        }

        @Override
        public Exception getException() {
            return target.getException();
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
        public void forward(String relativeURLPath) throws javax.servlet.ServletException, IOException {
            try {
                target.forward(relativeURLPath);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void include(String relativeURLPath) throws javax.servlet.ServletException, IOException {
            try {
                target.include(relativeURLPath);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void include(String relativeURLPath, boolean flush) throws javax.servlet.ServletException, IOException {
            try {
                target.include(relativeURLPath, flush);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public void handlePageException(Exception exception) throws javax.servlet.ServletException, IOException {
            try {
                target.handlePageException(exception);
            } catch (jakarta.servlet.ServletException exception$) {
                throw ServletShim.of(exception$);
            }
        }

        @Override
        public void handlePageException(Throwable cause) throws javax.servlet.ServletException, IOException {
            try {
                target.handlePageException(cause);
            } catch (jakarta.servlet.ServletException exception) {
                throw ServletShim.of(exception);
            }
        }

        @Override
        public Object findAttribute(String name) {
            return target.findAttribute(name);
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
        public void setAttribute(String name, Object value) {
            target.setAttribute(name, value);
        }

        @Override
        public void setAttribute(String name, Object value, int scope) {
            target.setAttribute(name, value, scope);
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

        @Deprecated
        @Override
        public javax.servlet.jsp.el.ExpressionEvaluator getExpressionEvaluator() {
            return JSPShim.of(target.getExpressionEvaluator());
        }

        @Deprecated
        @Override
        public javax.servlet.jsp.el.VariableResolver getVariableResolver() {
            return JSPShim.of(target.getVariableResolver());
        }

        @Override
        public javax.el.ELContext getELContext() {
            return ELShim.of(target.getELContext());
        }

        @Override
        public javax.servlet.jsp.JspWriter getOut() {
            return JSPShim.of(target.getOut());
        }

        @Override
        public javax.servlet.jsp.tagext.BodyContent pushBody() {
            return JSPShim.of(target.pushBody());
        }

        @Override
        public javax.servlet.jsp.JspWriter pushBody(Writer writer) {
            return JSPShim.of(target.pushBody(writer));
        }

        @Override
        public javax.servlet.jsp.JspWriter popBody() {
            return JSPShim.of(target.popBody());
        }

        @Override
        public javax.servlet.jsp.ErrorData getErrorData() {
            return JSPShim.of(target.getErrorData());
        }
    }
}
