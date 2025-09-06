package javax.servlet.jsp.tagext;

import javax.servlet.jsp.JspException;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.tagext.IterationTag} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp.tagext.IterationTag")
public interface IterationTag extends jakarta.servlet.jsp.tagext.IterationTag, Tag {
    //==================================================================================================================
    // IterationTag Implementation Methods
    //==================================================================================================================

    @Override
    int doAfterBody() throws JspException;
}
