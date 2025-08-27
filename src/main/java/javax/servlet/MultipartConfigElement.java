package javax.servlet;

/**
 * @deprecated Use {@link jakarta.servlet.MultipartConfigElement} instead.
 */
@Deprecated(since = "jakarta.servlet.MultipartConfigElement")
public class MultipartConfigElement extends jakarta.servlet.MultipartConfigElement implements ServletShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.servlet.MultipartConfigElement#MultipartConfigElement(String)
     */
    public MultipartConfigElement(String location) {
        super(location);
    }

    /**
     * @see jakarta.servlet.MultipartConfigElement#MultipartConfigElement(String, long, long, int)
     */
    public MultipartConfigElement(String location, long maxFileSize, long maxRequestSize, int fileSizeThreshold) {
        super(location, maxFileSize, maxRequestSize, fileSizeThreshold);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ServletShim.initialize();
    }
}
