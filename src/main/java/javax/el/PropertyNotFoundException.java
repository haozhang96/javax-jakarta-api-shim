package javax.el;

import javax.shim.ShimSupport;

/**
 * @deprecated Use {@link jakarta.el.PropertyNotFoundException} instead.
 * @apiNote This class cannot extend {@link jakarta.el.PropertyNotFoundException} due to class hierarchy divergence.
 */
@Deprecated(since = "jakarta.el.PropertyNotFoundException")
public class PropertyNotFoundException extends ELException {
    private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.el.PropertyNotFoundException#PropertyNotFoundException()
     */
    public PropertyNotFoundException() {
        super();
    }

    /**
     * @see jakarta.el.PropertyNotFoundException#PropertyNotFoundException(String)
     */
    public PropertyNotFoundException(String message) {
        super(message);
    }

    /**
     * @see jakarta.el.PropertyNotFoundException#PropertyNotFoundException(String, Throwable)
     */
    public PropertyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @see jakarta.el.PropertyNotFoundException#PropertyNotFoundException(Throwable)
     */
    public PropertyNotFoundException(Throwable cause) {
        super(cause);
    }

    //==================================================================================================================
    // Retrofit
    //==================================================================================================================

    /**
     * @deprecated Use {@link jakarta.el.PropertyNotFoundException} instead.
     */
    @Deprecated(since = "jakarta.el.PropertyNotFoundException")
    public static class Retrofit extends Retrofits.PropertyNotFoundException {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        public Retrofit(PropertyNotFoundException target) {
            super(target);
        }
    }
}
