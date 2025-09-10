package javax.activation;

import javax.shim.ShimSupport;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Locale;

/**
 * @deprecated Use {@link jakarta.activation.MimeType} instead.
 */
@Deprecated(since = "jakarta.activation.MimeType")
public class MimeType extends jakarta.activation.MimeType implements ActivationShim {
    private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.activation.MimeType#MimeType()
     */
    public MimeType() {
        super();
    }

    /**
     * @see jakarta.activation.MimeType#MimeType(String)
     */
    public MimeType(String mimeType) throws MimeTypeParseException {
        parse((lookup, clazz) ->
            lookup
                .bind(this, "parse", MethodType.methodType(void.class, String.class))
                .invoke(mimeType)
        );
    }

    /**
     * @see jakarta.activation.MimeType#MimeType(String, String)
     */
    public MimeType(String primaryType, String subType) throws MimeTypeParseException {
        parse((lookup, clazz) -> {
            final var validator = lookup.bind(this, "isValidToken", MethodType.methodType(boolean.class, String.class));
            if (!((boolean) validator.invoke(primaryType))) {
                throw new MimeTypeParseException("Primary type is invalid.");
            } else if (!((boolean) validator.invoke(subType))) {
                throw new MimeTypeParseException("Sub type is invalid.");
            }

            setPrimaryType(primaryType.toLowerCase(Locale.ENGLISH));
            setSubType(subType.toLowerCase(Locale.ENGLISH));
            return null;
        });
    }

    //==================================================================================================================
    // MimeType Implementation Methods
    //==================================================================================================================

    @Override
    public MimeTypeParameterList getParameters() {
        return ActivationShim.of(super.getParameters());
    }

    //==================================================================================================================
    // Private Helper Methods
    //==================================================================================================================

    private void parse(ShimSupport.ReflectiveAction parser) throws MimeTypeParseException {
        try {
            ShimSupport.<Void, jakarta.activation.MimeTypeParseException>reflect(
                MethodHandles.lookup(),
                jakarta.activation.MimeType.class,
                parser
            );
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
