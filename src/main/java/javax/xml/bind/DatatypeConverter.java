package javax.xml.bind;

import javax.shim.ShimReflector;
import javax.shim.ShimSupport;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

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

    /**
     * @see jakarta.xml.bind.DatatypeConverter#parseBase64Binary(String)
     */
    public static byte[] parseBase64Binary(String lexicalXSDBase64Binary) {
        return jakarta.xml.bind.DatatypeConverter.parseBase64Binary(lexicalXSDBase64Binary);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#printBase64Binary(byte[])
     */
    public static String printBase64Binary(byte[] value) {
        return jakarta.xml.bind.DatatypeConverter.printBase64Binary(value);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#parseHexBinary(String)
     */
    public static byte[] parseHexBinary(String lexicalXSDHexBinary) {
        return jakarta.xml.bind.DatatypeConverter.parseHexBinary(lexicalXSDHexBinary);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#printHexBinary(byte[])
     */
    public static String printHexBinary(byte[] value) {
        return jakarta.xml.bind.DatatypeConverter.printHexBinary(value);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#parseBoolean(String)
     */
    public static boolean parseBoolean(String lexicalXSDBoolean) {
        return jakarta.xml.bind.DatatypeConverter.parseBoolean(lexicalXSDBoolean);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#printBoolean(boolean)
     */
    public static String printBoolean(boolean value) {
        return jakarta.xml.bind.DatatypeConverter.printBoolean(value);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#parseByte(String)
     */
    public static byte parseByte(String lexicalXSDByte) {
        return jakarta.xml.bind.DatatypeConverter.parseByte(lexicalXSDByte);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#printByte(byte)
     */
    public static String printByte(byte value) {
        return jakarta.xml.bind.DatatypeConverter.printByte(value);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#parseShort(String)
     */
    public static short parseShort(String lexicalXSDShort) {
        return jakarta.xml.bind.DatatypeConverter.parseShort(lexicalXSDShort);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#printShort(short)
     */
    public static String printShort(short value) {
        return jakarta.xml.bind.DatatypeConverter.printShort(value);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#parseUnsignedShort(String)
     */
    public static int parseUnsignedShort(String lexicalXSDUnsignedShort) {
        return jakarta.xml.bind.DatatypeConverter.parseUnsignedShort(lexicalXSDUnsignedShort);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#printUnsignedShort(int)
     */
    public static String printUnsignedShort(int value) {
        return jakarta.xml.bind.DatatypeConverter.printUnsignedShort(value);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#parseInt(String)
     */
    public static int parseInt(String lexicalXSDInt) {
        return jakarta.xml.bind.DatatypeConverter.parseInt(lexicalXSDInt);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#printInt(int)
     */
    public static String printInt(int value) {
        return jakarta.xml.bind.DatatypeConverter.printInt(value);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#parseUnsignedInt(String)
     */
    public static long parseUnsignedInt(String lexicalXSDUnsignedInt) {
        return jakarta.xml.bind.DatatypeConverter.parseUnsignedInt(lexicalXSDUnsignedInt);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#printUnsignedInt(long)
     */
    public static String printUnsignedInt(long value) {
        return jakarta.xml.bind.DatatypeConverter.printUnsignedInt(value);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#parseLong(String)
     */
    public static long parseLong(String lexicalXSDLong) {
        return jakarta.xml.bind.DatatypeConverter.parseLong(lexicalXSDLong);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#printLong(long)
     */
    public static String printLong(long value) {
        return jakarta.xml.bind.DatatypeConverter.printLong(value);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#parseFloat(String)
     */
    public static float parseFloat(String lexicalXSDFloat) {
        return jakarta.xml.bind.DatatypeConverter.parseFloat(lexicalXSDFloat);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#printFloat(float)
     */
    public static String printFloat(float value) {
        return jakarta.xml.bind.DatatypeConverter.printFloat(value);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#parseDouble(String)
     */
    public static double parseDouble(String lexicalXSDDouble) {
        return jakarta.xml.bind.DatatypeConverter.parseDouble(lexicalXSDDouble);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#printDouble(double)
     */
    public static String printDouble(double value) {
        return jakarta.xml.bind.DatatypeConverter.printDouble(value);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#parseInteger(String)
     */
    public static BigInteger parseInteger(String lexicalXSDInteger) {
        return jakarta.xml.bind.DatatypeConverter.parseInteger(lexicalXSDInteger);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#printInteger(BigInteger)
     */
    public static String printInteger(BigInteger value) {
        return jakarta.xml.bind.DatatypeConverter.printInteger(value);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#parseDecimal(String)
     */
    public static BigDecimal parseDecimal(String lexicalXSDDecimal) {
        return jakarta.xml.bind.DatatypeConverter.parseDecimal(lexicalXSDDecimal);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#printDecimal(BigDecimal)
     */
    public static String printDecimal(BigDecimal value) {
        return jakarta.xml.bind.DatatypeConverter.printDecimal(value);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#parseDate(String)
     */
    public static Calendar parseDate(String lexicalXSDDate) {
        return jakarta.xml.bind.DatatypeConverter.parseDate(lexicalXSDDate);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#printDate(Calendar)
     */
    public static String printDate(Calendar value) {
        return jakarta.xml.bind.DatatypeConverter.printDate(value);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#parseTime(String)
     */
    public static Calendar parseTime(String lexicalXSDTime) {
        return jakarta.xml.bind.DatatypeConverter.parseTime(lexicalXSDTime);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#printTime(Calendar)
     */
    public static String printTime(Calendar value) {
        return jakarta.xml.bind.DatatypeConverter.printTime(value);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#parseDateTime(String)
     */
    public static Calendar parseDateTime(String lexicalXSDDateTime) {
        return jakarta.xml.bind.DatatypeConverter.parseDateTime(lexicalXSDDateTime);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#printDateTime(Calendar)
     */
    public static String printDateTime(Calendar value) {
        return jakarta.xml.bind.DatatypeConverter.printDateTime(value);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#parseQName(String, NamespaceContext)
     */
    public static QName parseQName(String lexicalXSDQName, NamespaceContext namespaceContext) {
        return jakarta.xml.bind.DatatypeConverter.parseQName(lexicalXSDQName, namespaceContext);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#printQName(QName, NamespaceContext)
     */
    public static String printQName(QName value, NamespaceContext namespaceContext) {
        return jakarta.xml.bind.DatatypeConverter.printQName(value, namespaceContext);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#parseAnySimpleType(String)
     */
    public static String parseAnySimpleType(String lexicalXSDAnySimpleType) {
        return jakarta.xml.bind.DatatypeConverter.parseAnySimpleType(lexicalXSDAnySimpleType);
    }

    /**
     * @see jakarta.xml.bind.DatatypeConverter#printAnySimpleType(String)
     */
    public static String printAnySimpleType(String value) {
        return jakarta.xml.bind.DatatypeConverter.printAnySimpleType(value);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        try {
            ShimReflector.call(ShimSupport.toJakarta(), (lookup, clazz) -> {
                printString(null); // Initialize the default implementation.

                final var converter =
                    lookup
                        .findStaticVarHandle(clazz, "theConverter", jakarta.xml.bind.DatatypeConverterInterface.class)
                        .get();
                setDatatypeConverter(JAXBShim.of(converter));
                return null;
            });
        } finally {
            JAXBShim.initialize();
        }
    }
}
