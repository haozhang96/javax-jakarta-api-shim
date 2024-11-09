package javax.servlet.jsp;

import javax.Shim;
import javax.servlet.ServletShim;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.ErrorData} instead.
 * @apiNote This class cannot extend {@link jakarta.servlet.jsp.ErrorData} due to it being a final class.
 */
@Deprecated(since = "jakarta.servlet.jsp.ErrorData")
public class ErrorData extends Shim.Facade<jakarta.servlet.jsp.ErrorData> implements ServletShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.servlet.jsp.ErrorData#ErrorData(Throwable, int, String, String)
     */
    public ErrorData(Throwable cause, int statusCode, String uri, String servletName) {
        this(new jakarta.servlet.jsp.ErrorData(cause, statusCode, uri, servletName));
    }

    protected ErrorData(jakarta.servlet.jsp.ErrorData target) {
        super(target);
    }

    //==================================================================================================================
    // ErrorData Implementation Methods
    //==================================================================================================================

    /**
     * @see jakarta.servlet.jsp.ErrorData#getThrowable()
     */
    public Throwable getThrowable() {
        return target.getThrowable();
    }

    /**
     * @see jakarta.servlet.jsp.ErrorData#getStatusCode()
     */
    public int getStatusCode() {
        return target.getStatusCode();
    }

    /**
     * @see jakarta.servlet.jsp.ErrorData#getRequestURI()
     */
    public String getRequestURI() {
        return target.getRequestURI();
    }

    /**
     * @see jakarta.servlet.jsp.ErrorData#getServletName()
     */
    public String getServletName() {
        return target.getServletName();
    }

    //==================================================================================================================
    // Accessor Methods
    //==================================================================================================================

    jakarta.servlet.jsp.ErrorData getTarget() {
        return target;
    }
}
