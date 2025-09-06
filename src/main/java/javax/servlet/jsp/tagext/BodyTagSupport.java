package javax.servlet.jsp.tagext;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.shim.ShimSupport;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.tagext.BodyTagSupport} instead.
 * @apiNote This class cannot extend {@link jakarta.servlet.jsp.tagext.BodyTagSupport} due to class hierarchy
 *          divergence.
 */
@Deprecated(since = "jakarta.servlet.jsp.tagext.BodyTagSupport")
public class BodyTagSupport extends TagSupport implements BodyTag {
    private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

    protected BodyContent bodyContent;

    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    @Override
    public void setBodyContent(BodyContent bodyContent) {
        this.bodyContent = bodyContent;
    }

    @Override
    public void doInitBody() throws JspException {
        // Do nothing.
    }

    //==================================================================================================================
    // BodyTagSupport Implementation Methods
    //==================================================================================================================

    /**
     * @see jakarta.servlet.jsp.tagext.BodyTagSupport#getBodyContent()
     */
    public BodyContent getBodyContent() {
        return bodyContent;
    }

    /**
     * @see jakarta.servlet.jsp.tagext.BodyTagSupport#getPreviousOut()
     */
    public JspWriter getPreviousOut() {
        return getBodyContent().getEnclosingWriter();
    }

    //==================================================================================================================
    // Tag Implementation Methods
    //==================================================================================================================

    @Override
    public int doStartTag() throws JspException {
        return EVAL_BODY_BUFFERED;
    }

    @Override
    public int doAfterBody() throws JspException {
        return SKIP_BODY;
    }

    @Override
    public void release() {
        bodyContent = null;

        super.release();
    }
}
