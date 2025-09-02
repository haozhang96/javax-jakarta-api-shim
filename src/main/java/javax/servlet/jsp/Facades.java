package javax.servlet.jsp;

import javax.shim.ShimSupport;
import java.io.PrintStream;
import java.io.PrintWriter;

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
}
