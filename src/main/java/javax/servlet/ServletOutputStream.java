package javax.servlet;

/**
 * @deprecated Use {@link jakarta.servlet.ServletOutputStream} instead.
 */
@Deprecated(since = "jakarta.servlet.ServletOutputStream")
public abstract class ServletOutputStream extends jakarta.servlet.ServletOutputStream implements ServletShim {
    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see #setWriteListener(jakarta.servlet.WriteListener)
     */
    public abstract void setWriteListener(WriteListener writeListener);

    //==================================================================================================================
    // ServletOutputStream Implementation Methods
    //==================================================================================================================

    @Override
    public void setWriteListener(jakarta.servlet.WriteListener writeListener) {
        setWriteListener(ServletShim.of(writeListener));
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ServletShim.initialize();
    }
}
