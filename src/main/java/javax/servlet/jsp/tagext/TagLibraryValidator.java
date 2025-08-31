package javax.servlet.jsp.tagext;

import javax.servlet.jsp.JSPShim;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.tagext.TagLibraryValidator} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp.tagext.TagLibraryValidator")
public abstract class TagLibraryValidator extends jakarta.servlet.jsp.tagext.TagLibraryValidator implements JSPShim {
    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    public ValidationMessage[] validate(String prefix, String uri, PageData page) {
        return JSPShim
            .<ValidationMessage>of(super.validate(prefix, uri, page))
            .toArray(ValidationMessage[]::new);
    }

    //==================================================================================================================
    // TagLibraryValidator Implementation Methods
    //==================================================================================================================

    @Override
    public ValidationMessage[] validate(String prefix, String uri, jakarta.servlet.jsp.tagext.PageData page) {
        return validate(prefix, uri, JSPShim.of(page));
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JSPShim.initialize();
    }
}
