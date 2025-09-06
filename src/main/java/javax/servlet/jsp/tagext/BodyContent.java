package javax.servlet.jsp.tagext;

import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.tagext.BodyContent} instead.
 * @apiNote This class cannot extend {@link jakarta.servlet.jsp.tagext.BodyContent} due to class hierarchy divergence.
 */
@Deprecated(since = "jakarta.servlet.jsp.tagext.BodyContent")
public abstract class BodyContent extends JspWriter {
    private final JspWriter enclosingWriter;

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.servlet.jsp.tagext.BodyContent#BodyContent(jakarta.servlet.jsp.JspWriter)
     */
    @SuppressWarnings("JavadocReference")
    protected BodyContent(JspWriter enclosingWriter) {
        super(UNBOUNDED_BUFFER, false);
        this.enclosingWriter = enclosingWriter;
    }

    //==================================================================================================================
    // BodyContent Implementation Methods
    //==================================================================================================================

    /**
     * @see jakarta.servlet.jsp.tagext.BodyContent#getReader()
     */
    public abstract Reader getReader();

    /**
     * @see jakarta.servlet.jsp.tagext.BodyContent#getString()
     */
    public abstract String getString();

    /**
     * @see jakarta.servlet.jsp.tagext.BodyContent#getEnclosingWriter()
     */
    public JspWriter getEnclosingWriter() {
        return enclosingWriter;
    }

    /**
     * @see jakarta.servlet.jsp.tagext.BodyContent#writeOut(Writer)
     */
    public abstract void writeOut(Writer out) throws IOException;

    /**
     * @see jakarta.servlet.jsp.tagext.BodyContent#clearBody()
     */
    public void clearBody() {
        try {
            clear();
        } catch (IOException exception) {
            throw new InternalError(exception);
        }
    }

    /**
     * @see jakarta.servlet.jsp.tagext.BodyContent#flush()
     */
    @Override
    public void flush() throws IOException {
        throw new IOException("Illegal to flush within a custom tag");
    }
}
