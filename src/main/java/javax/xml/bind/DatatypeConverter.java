package javax.xml.bind;

import javax.shim.ShimSupport;

/**
 * @deprecated Use {@link jakarta.xml.bind.DatatypeConverter} instead.
 * @apiNote This class cannot extend {@link jakarta.xml.bind.DatatypeConverter} due to it being a final class.
 */
@Deprecated(since = "jakarta.xml.bind.DatatypeConverter")
public final class DatatypeConverter implements JAXBShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    private DatatypeConverter() {
        throw new UnsupportedOperationException();
    }

    //==================================================================================================================
    // Delegated Methods
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.DatatypeConverter#setDatatypeConverter(jakarta.xml.bind.DatatypeConverterInterface)
     */
    public static void setDatatypeConverter(DatatypeConverterInterface converter) {
        jakarta.xml.bind.DatatypeConverter.setDatatypeConverter(converter);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#parseString(String)
     */
    public static String parseString(String lexicalXSDString) {
        return jakarta.xml.bind.DatatypeConverter.parseString(lexicalXSDString);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#printString(String)
     */
    public static String printString(String value) {
        return jakarta.xml.bind.DatatypeConverter.printString(value);
    }

    // TODO

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        try {
            printString(null); // Initialize the default implementation.

            ShimSupport.reflect(ShimSupport.toJakarta(), (lookup, clazz) -> {
                final var converter =
                    lookup.findStaticVarHandle(clazz, "theConverter", jakarta.xml.bind.DatatypeConverterInterface.class);
                setDatatypeConverter(JAXBShim.of(converter.get()));
                return null;
            });
        } finally {
            JAXBShim.initialize();
        }
    }
}
