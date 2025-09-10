package javax.activation;

import java.net.URL;

/**
 * @deprecated Use {@link jakarta.activation.URLDataSource} instead.
 */
@Deprecated(since = "jakarta.activation.URLDataSource")
public class URLDataSource extends jakarta.activation.URLDataSource implements ActivationShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.activation.URLDataSource#URLDataSource(URL)
     */
    public URLDataSource(URL url) {
        super(url);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ActivationShim.initialize();
    }
}
