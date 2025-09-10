package javax.activation;

/**
 * @deprecated Use {@link jakarta.activation.ActivationDataFlavor} instead.
 */
@Deprecated(since = "jakarta.activation.ActivationDataFlavor")
public class ActivationDataFlavor extends jakarta.activation.ActivationDataFlavor implements ActivationShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.activation.ActivationDataFlavor#ActivationDataFlavor(String, String)
     */
    public ActivationDataFlavor(String mimeType, String humanPresentableName) {
        super(mimeType, humanPresentableName);
    }

    /**
     * @see jakarta.activation.ActivationDataFlavor#ActivationDataFlavor(Class, String)
     */
    public ActivationDataFlavor(Class<?> representationClass, String humanPresentableName) {
        super(representationClass, humanPresentableName);
    }

    /**
     * @see jakarta.activation.ActivationDataFlavor#ActivationDataFlavor(Class, String, String)
     */
    public ActivationDataFlavor(Class<?> representationClass, String mimeType, String humanPresentableName) {
        super(representationClass, mimeType, humanPresentableName);
    }

    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see jakarta.activation.ActivationDataFlavor#equals(jakarta.activation.ActivationDataFlavor)
     */
    public boolean equals(ActivationDataFlavor dataFlavor) {
        return super.equals(dataFlavor);
    }

    //==================================================================================================================
    // ActivationDataFlavor Implementation Methods
    //==================================================================================================================

    @Override
    public boolean equals(jakarta.activation.ActivationDataFlavor dataFlavor) {
        return equals(ActivationShim.<ActivationDataFlavor>of(dataFlavor));
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ActivationShim.initialize();
    }
}
