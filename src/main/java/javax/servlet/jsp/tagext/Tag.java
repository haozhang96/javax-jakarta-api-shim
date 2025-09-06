package javax.servlet.jsp.tagext;

import javax.servlet.jsp.JSPShim;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.tagext.Tag} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp.tagext.Tag")
public interface Tag extends jakarta.servlet.jsp.tagext.Tag, JspTag {
    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see jakarta.servlet.jsp.tagext.Tag#setPageContext(jakarta.servlet.jsp.PageContext)
     */
    void setPageContext(PageContext pageContext);

    /**
     * @see jakarta.servlet.jsp.tagext.Tag#setParent(jakarta.servlet.jsp.tagext.Tag)
     */
    void setParent(Tag parent);

    //==================================================================================================================
    // Tag Implementation Methods
    //==================================================================================================================

    @Override
    default void setPageContext(jakarta.servlet.jsp.PageContext pageContext) {
        setPageContext(JSPShim.<PageContext>of(pageContext));
    }

    @Override
    Tag getParent();

    @Override
    default void setParent(jakarta.servlet.jsp.tagext.Tag parent) {
        setParent(JSPShim.of(parent));
    }

    @Override
    int doStartTag() throws JspException;

    @Override
    int doEndTag() throws JspException;
}
