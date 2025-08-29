package javax.el;

/**
 * @deprecated Use {@link jakarta.el.ELContextListener} instead.
 */
@Deprecated(since = "jakarta.el.ELContextListener")
public interface ELContextListener extends jakarta.el.ELContextListener, ELShim {
    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see #contextCreated(jakarta.el.ELContextEvent)
     */
    void contextCreated(ELContextEvent event);

    //==================================================================================================================
    // ELContextListener Implementation Methods
    //==================================================================================================================

    @Override
    default void contextCreated(jakarta.el.ELContextEvent event) {
        contextCreated(ELShim.of(event));
    }
}
