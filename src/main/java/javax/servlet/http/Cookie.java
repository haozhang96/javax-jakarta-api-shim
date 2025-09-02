package javax.servlet.http;

import javax.servlet.ServletShim;
import javax.shim.ShimSupport;

/**
 * @deprecated Use {@link jakarta.servlet.http.Cookie} instead.
 */
@Deprecated(since = "jakarta.servlet.http.Cookie")
public class Cookie extends jakarta.servlet.http.Cookie implements ServletShim {
    private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    public Cookie(String name, String value) {
        super(name, value);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ServletShim.initialize();
    }
}
