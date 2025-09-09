package javax.servlet.jsp.tagext;

import javax.servlet.jsp.JSPShim;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.shim.ShimSupport;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.tagext.TagSupport} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp.tagext.TagSupport")
public class TagSupport extends jakarta.servlet.jsp.tagext.TagSupport implements IterationTag {
    private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Helper Methods
    //==================================================================================================================

    /**
     * @see jakarta.servlet.jsp.tagext.TagSupport#findAncestorWithClass(jakarta.servlet.jsp.tagext.Tag, Class)
     */
    public static Tag findAncestorWithClass(Tag from, Class<?> clazz) {
        return JSPShim.of(jakarta.servlet.jsp.tagext.TagSupport.findAncestorWithClass(from, clazz));
    }

    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    @Override
    public void setPageContext(PageContext pageContext) {
        super.setPageContext(new PageContext.Retrofit(pageContext));
    }

    @Override
    public void setParent(Tag parent) {
        super.setParent(parent);
    }

    //==================================================================================================================
    // Tag Implementation Methods
    //==================================================================================================================

    @Override
    public Tag getParent() {
        return JSPShim.of(super.getParent());
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            return super.doStartTag();
        } catch (jakarta.servlet.jsp.JspException exception) {
            throw JSPShim.of(exception);
        }
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            return super.doEndTag();
        } catch (jakarta.servlet.jsp.JspException exception) {
            throw JSPShim.of(exception);
        }
    }

    //==================================================================================================================
    // IterationTag Implementation Methods
    //==================================================================================================================

    @Override
    public int doAfterBody() throws JspException {
        try {
            return super.doAfterBody();
        } catch (jakarta.servlet.jsp.JspException exception) {
            throw JSPShim.of(exception);
        }
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JSPShim.initialize();
    }
}
