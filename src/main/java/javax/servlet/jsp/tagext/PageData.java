package javax.servlet.jsp.tagext;

import javax.servlet.jsp.JSPShim;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.tagext.PageData} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp.tagext.PageData")
public abstract class PageData extends jakarta.servlet.jsp.tagext.PageData implements JSPShim {
    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JSPShim.initialize();
    }
}
