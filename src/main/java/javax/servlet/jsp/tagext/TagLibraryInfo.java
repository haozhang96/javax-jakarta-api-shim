package javax.servlet.jsp.tagext;

import jakarta.servlet.jsp.tagext.FunctionInfo;
import jakarta.servlet.jsp.tagext.TagFileInfo;
import jakarta.servlet.jsp.tagext.TagInfo;

import javax.servlet.jsp.JSPShim;

/**
 * @deprecated Use {@link jakarta.servlet.jsp.tagext.TagLibraryInfo} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp.tagext.TagLibraryInfo")
public abstract class TagLibraryInfo extends jakarta.servlet.jsp.tagext.TagLibraryInfo implements JSPShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.servlet.jsp.tagext.TagLibraryInfo#TagLibraryInfo(String, String)
     */
    protected TagLibraryInfo(String prefix, String uri) {
        super(prefix, uri);
    }

    //==================================================================================================================
    // TagLibraryInfo Implementation Methods
    //==================================================================================================================

    @Override // TODO
    public TagInfo[] getTags() {
        return super.getTags();
    }

    @Override
    public TagFileInfo[] getTagFiles() {
        return super.getTagFiles();
    }

    @Override
    public TagInfo getTag(String shortname) {
        return super.getTag(shortname);
    }

    @Override
    public TagFileInfo getTagFile(String shortname) {
        return super.getTagFile(shortname);
    }

    @Override
    public FunctionInfo[] getFunctions() {
        return super.getFunctions();
    }

    @Override
    public FunctionInfo getFunction(String name) {
        return super.getFunction(name);
    }

    @Override
    public abstract TagLibraryInfo[] getTagLibraryInfos();

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JSPShim.initialize();
    }
}
