package javax.xml.bind;

import javax.shim.ShimSupport;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

/**
 * This interface contains {@link jakarta.xml.bind}-to-{@link javax.xml.bind} facades used for wrapping Jakarta XML
 *   Binding objects into their Java XML Binding counterparts.
 *
 * @deprecated Use {@link jakarta.xml.bind} instead.
 */
@Deprecated(since = "jakarta.xml.bind")
@SuppressWarnings("all")
interface Facades {
    //==================================================================================================================
    // Annotations
    //==================================================================================================================

    final class XmlValue extends JAXBShim.Facade.Annotation<jakarta.xml.bind.annotation.XmlValue> implements javax.xml.bind.annotation.XmlValue, JAXBShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        XmlValue(jakarta.xml.bind.annotation.XmlValue target) {
            super(target);
        }
    }

    //==================================================================================================================
    // Classes
    //==================================================================================================================

    final class DatatypeConverterInterface extends JAXBShim.Facade<jakarta.xml.bind.DatatypeConverterInterface> implements javax.xml.bind.DatatypeConverterInterface {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        DatatypeConverterInterface(jakarta.xml.bind.DatatypeConverterInterface target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String parseString(String lexicalXSDString) {
            return target.parseString(lexicalXSDString);
        }

        @Override
        public BigInteger parseInteger(String lexicalXSDInteger) {
            return target.parseInteger(lexicalXSDInteger);
        }

        @Override
        public int parseInt(String lexicalXSDInt) {
            return target.parseInt(lexicalXSDInt);
        }

        @Override
        public long parseLong(String lexicalXSDLong) {
            return target.parseLong(lexicalXSDLong);
        }

        @Override
        public short parseShort(String lexicalXSDShort) {
            return target.parseShort(lexicalXSDShort);
        }

        @Override
        public BigDecimal parseDecimal(String lexicalXSDDecimal) {
            return target.parseDecimal(lexicalXSDDecimal);
        }

        @Override
        public float parseFloat(String lexicalXSDFloat) {
            return target.parseFloat(lexicalXSDFloat);
        }

        @Override
        public double parseDouble(String lexicalXSDDouble) {
            return target.parseDouble(lexicalXSDDouble);
        }

        @Override
        public boolean parseBoolean(String lexicalXSDBoolean) {
            return target.parseBoolean(lexicalXSDBoolean);
        }

        @Override
        public byte parseByte(String lexicalXSDByte) {
            return target.parseByte(lexicalXSDByte);
        }

        @Override
        public QName parseQName(String lexicalXSDQName, NamespaceContext nsc) {
            return target.parseQName(lexicalXSDQName, nsc);
        }

        @Override
        public Calendar parseDateTime(String lexicalXSDDateTime) {
            return target.parseDateTime(lexicalXSDDateTime);
        }

        @Override
        public byte[] parseBase64Binary(String lexicalXSDBase64Binary) {
            return target.parseBase64Binary(lexicalXSDBase64Binary);
        }

        @Override
        public byte[] parseHexBinary(String lexicalXSDHexBinary) {
            return target.parseHexBinary(lexicalXSDHexBinary);
        }

        @Override
        public long parseUnsignedInt(String lexicalXSDUnsignedInt) {
            return target.parseUnsignedInt(lexicalXSDUnsignedInt);
        }

        @Override
        public int parseUnsignedShort(String lexicalXSDUnsignedShort) {
            return target.parseUnsignedShort(lexicalXSDUnsignedShort);
        }

        @Override
        public Calendar parseTime(String lexicalXSDTime) {
            return target.parseTime(lexicalXSDTime);
        }

        @Override
        public Calendar parseDate(String lexicalXSDDate) {
            return target.parseDate(lexicalXSDDate);
        }

        @Override
        public String parseAnySimpleType(String lexicalXSDAnySimpleType) {
            return target.parseAnySimpleType(lexicalXSDAnySimpleType);
        }

        @Override
        public String printString(String val) {
            return target.printString(val);
        }

        @Override
        public String printInteger(BigInteger val) {
            return target.printInteger(val);
        }

        @Override
        public String printInt(int val) {
            return target.printInt(val);
        }

        @Override
        public String printLong(long val) {
            return target.printLong(val);
        }

        @Override
        public String printShort(short val) {
            return target.printShort(val);
        }

        @Override
        public String printDecimal(BigDecimal val) {
            return target.printDecimal(val);
        }

        @Override
        public String printFloat(float val) {
            return target.printFloat(val);
        }

        @Override
        public String printDouble(double val) {
            return target.printDouble(val);
        }

        @Override
        public String printBoolean(boolean val) {
            return target.printBoolean(val);
        }

        @Override
        public String printByte(byte val) {
            return target.printByte(val);
        }

        @Override
        public String printQName(QName val, NamespaceContext nsc) {
            return target.printQName(val, nsc);
        }

        @Override
        public String printDateTime(Calendar val) {
            return target.printDateTime(val);
        }

        @Override
        public String printBase64Binary(byte[] val) {
            return target.printBase64Binary(val);
        }

        @Override
        public String printHexBinary(byte[] val) {
            return target.printHexBinary(val);
        }

        @Override
        public String printUnsignedInt(long val) {
            return target.printUnsignedInt(val);
        }

        @Override
        public String printUnsignedShort(int val) {
            return target.printUnsignedShort(val);
        }

        @Override
        public String printTime(Calendar val) {
            return target.printTime(val);
        }

        @Override
        public String printDate(Calendar val) {
            return target.printDate(val);
        }

        @Override
        public String printAnySimpleType(String val) {
            return target.printAnySimpleType(val);
        }
    }

    final class JAXBException extends javax.xml.bind.JAXBException {
        private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

        private final javax.xml.bind.JAXBException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        JAXBException(javax.xml.bind.JAXBException target) {
            super(target.getMessage(), target.getErrorCode(), target.getCause());
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getErrorCode() {
            return target.getErrorCode();
        }

        @Override
        public Throwable getLinkedException() {
            return target.getLinkedException();
        }

        @Override
        public void setLinkedException(Throwable exception) {
            target.setLinkedException(exception);
        }

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public String getLocalizedMessage() {
            return target.getLocalizedMessage();
        }

        @Override
        public Throwable getCause() {
            return target.getCause();
        }

        @Override
        public Throwable initCause(Throwable cause) {
            return target.initCause(cause);
        }

        @Override
        public String toString() {
            return target.toString();
        }

        @Override
        public void printStackTrace() {
            target.printStackTrace();
        }

        @Override
        public void printStackTrace(PrintStream s) {
            target.printStackTrace(s);
        }

        @Override
        public void printStackTrace(PrintWriter s) {
            target.printStackTrace(s);
        }

        @Override
        public Throwable fillInStackTrace() {
            try {
                return super.fillInStackTrace();
            } finally {
                if (target != null) {
                    target.fillInStackTrace();
                }
            }
        }

        @Override
        public StackTraceElement[] getStackTrace() {
            return target.getStackTrace();
        }

        @Override
        public void setStackTrace(StackTraceElement[] stackTrace) {
            target.setStackTrace(stackTrace);
        }
    }
}
