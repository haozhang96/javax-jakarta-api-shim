package javax.servlet.jsp.tagext;

import javax.servlet.jsp.JSPShim;
import javax.servlet.jsp.JspException;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.tagext.DynamicAttributes} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp.tagext.DynamicAttributes")
public interface DynamicAttributes extends jakarta.servlet.jsp.tagext.DynamicAttributes, JSPShim {
    //==================================================================================================================
    // DynamicAttributes Implementation Methods
    //==================================================================================================================

    @Override
    void setDynamicAttribute(String uri, String localName, Object value) throws JspException;
}
