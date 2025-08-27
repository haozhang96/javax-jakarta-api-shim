package javax.servlet.http;

import javax.servlet.ServletShim;

/**
 * @deprecated Use {@link jakarta.servlet.http.MappingMatch} instead.
 */
@Deprecated(since = "jakarta.servlet.http.MappingMatch")
public enum MappingMatch implements ServletShim.Enum<jakarta.servlet.http.MappingMatch> {
    CONTEXT_ROOT, DEFAULT, EXACT, EXTENSION, PATH;

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ServletShim.initialize();
    }
}
