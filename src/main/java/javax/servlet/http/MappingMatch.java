package javax.servlet.http;

import javax.servlet.ServletShim;

/**
 * @deprecated Use {@link jakarta.servlet.http.MappingMatch} instead.
 */
@Deprecated(since = "jakarta.servlet.http.MappingMatch")
public enum MappingMatch implements ServletShim.Enum<jakarta.servlet.http.MappingMatch> {
    /**
     * @see jakarta.servlet.http.MappingMatch#CONTEXT_ROOT
     */
    CONTEXT_ROOT,

    /**
     * @see jakarta.servlet.http.MappingMatch#DEFAULT
     */
    DEFAULT,

    /**
     * @see jakarta.servlet.http.MappingMatch#EXACT
     */
    EXACT,

    /**
     * @see jakarta.servlet.http.MappingMatch#EXTENSION
     */
    EXTENSION,

    /**
     * @see jakarta.servlet.http.MappingMatch#PATH
     */
    PATH;

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ServletShim.initialize();
    }
}
