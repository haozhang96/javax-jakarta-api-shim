package javax.servlet.jsp.tagext;

import javax.servlet.jsp.JSPShim;
import javax.servlet.jsp.JspException;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.tagext.BodyTag} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp.tagext.BodyTag")
public interface BodyTag extends jakarta.servlet.jsp.tagext.BodyTag, IterationTag {
    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see jakarta.servlet.jsp.tagext.BodyTag#setBodyContent(jakarta.servlet.jsp.tagext.BodyContent)
     */
    void setBodyContent(BodyContent bodyContent);

    //==================================================================================================================
    // BodyTag Implementation Methods
    //==================================================================================================================

    @Override
    default void setBodyContent(jakarta.servlet.jsp.tagext.BodyContent bodyContent) {
        setBodyContent(JSPShim.<BodyContent>of(bodyContent));
    }

    @Override
    void doInitBody() throws JspException;
}
