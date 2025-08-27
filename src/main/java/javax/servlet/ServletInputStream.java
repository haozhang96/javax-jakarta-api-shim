package javax.servlet;

/**
 * @deprecated Use {@link jakarta.servlet.ServletInputStream} instead.
 */
@Deprecated(since = "jakarta.servlet.ServletInputStream")
public abstract class ServletInputStream extends jakarta.servlet.ServletInputStream implements ServletShim {
    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see #setReadListener(jakarta.servlet.ReadListener)
     */
    public abstract void setReadListener(ReadListener readListener);

    //==================================================================================================================
    // ServletInputStream Implementation Methods
    //==================================================================================================================

    @Override
    public void setReadListener(jakarta.servlet.ReadListener readListener) {
        setReadListener(ServletShim.of(readListener));
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ServletShim.initialize();
    }
}
