package javax.activation;

/**
 * @deprecated Use {@link jakarta.activation.MimeTypeParameterList} instead.
 */
@Deprecated(since = "jakarta.activation.MimeTypeParameterList")
public class MimeTypeParameterList extends jakarta.activation.MimeTypeParameterList implements ActivationShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.activation.MimeTypeParameterList#MimeTypeParameterList()
     */
    public MimeTypeParameterList() {
        super();
    }

    /**
     * @see jakarta.activation.MimeTypeParameterList#MimeTypeParameterList(String)
     */
    public MimeTypeParameterList(String parameters) throws MimeTypeParseException {
        parse(parameters);
    }

    //==================================================================================================================
    // MimeTypeParameterList Implementation Methods
    //==================================================================================================================

    @Override
    protected void parse(String parameterList) throws MimeTypeParseException {
        try {
            super.parse(parameterList);
        } catch (jakarta.activation.MimeTypeParseException exception) {
            throw ActivationShim.<MimeTypeParseException>of(exception);
        }
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ActivationShim.initialize();
    }
}
