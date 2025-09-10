package javax.xml.bind;

import javassist.CannotCompileException;
import javassist.expr.NewExpr;

import javax.shim.ShimPatcher;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import java.io.*;
import java.net.URI;
import java.net.URL;

/**
 * @deprecated Use {@link jakarta.xml.bind.JAXB} instead.
 * @apiNote This class cannot extend {@link jakarta.xml.bind.JAXB} due to it being a final class.
 */
@Deprecated(since = "jakarta.xml.bind.JAXB")
public final class JAXB implements JAXBShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    private JAXB() {
        throw new UnsupportedOperationException();
    }

    //==================================================================================================================
    // Factory Methods
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.JAXB#unmarshal(Source, Class)
     */
    public static <T> T unmarshal(Source source, Class<T> type) {
        try {
            return jakarta.xml.bind.JAXB.unmarshal(source, type);
        } catch (jakarta.xml.bind.DataBindingException exception) {
            throw JAXBShim.<DataBindingException>of(exception);
        }
    }

    /**
     * @see jakarta.xml.bind.JAXB#unmarshal(URI, Class)
     */
    public static <T> T unmarshal(URI uri, Class<T> type) {
        try {
            return jakarta.xml.bind.JAXB.unmarshal(uri, type);
        } catch (jakarta.xml.bind.DataBindingException exception) {
            throw JAXBShim.<DataBindingException>of(exception);
        }
    }

    /**
     * @see jakarta.xml.bind.JAXB#unmarshal(URL, Class)
     */
    public static <T> T unmarshal(URL url, Class<T> type) {
        try {
            return jakarta.xml.bind.JAXB.unmarshal(url, type);
        } catch (jakarta.xml.bind.DataBindingException exception) {
            throw JAXBShim.<DataBindingException>of(exception);
        }
    }

    /**
     * @see jakarta.xml.bind.JAXB#unmarshal(File, Class)
     */
    public static <T> T unmarshal(File file, Class<T> type) {
        try {
            return jakarta.xml.bind.JAXB.unmarshal(file, type);
        } catch (jakarta.xml.bind.DataBindingException exception) {
            throw JAXBShim.<DataBindingException>of(exception);
        }
    }

    /**
     * @see jakarta.xml.bind.JAXB#unmarshal(InputStream, Class)
     */
    public static <T> T unmarshal(InputStream inputStream, Class<T> type) {
        try {
            return jakarta.xml.bind.JAXB.unmarshal(inputStream, type);
        } catch (jakarta.xml.bind.DataBindingException exception) {
            throw JAXBShim.<DataBindingException>of(exception);
        }
    }

    /**
     * @see jakarta.xml.bind.JAXB#unmarshal(Reader, Class)
     */
    public static <T> T unmarshal(Reader reader, Class<T> type) {
        try {
            return jakarta.xml.bind.JAXB.unmarshal(reader, type);
        } catch (jakarta.xml.bind.DataBindingException exception) {
            throw JAXBShim.<DataBindingException>of(exception);
        }
    }

    /**
     * @see jakarta.xml.bind.JAXB#marshal(Object, Result)
     */
    public static void marshal(Object jaxbElement, Result result) {
        try {
            jakarta.xml.bind.JAXB.marshal(JAXBElement.wrap(jaxbElement), result);
        } catch (jakarta.xml.bind.DataBindingException exception) {
            throw JAXBShim.<DataBindingException>of(exception);
        }
    }

    /**
     * @see jakarta.xml.bind.JAXB#marshal(Object, URI)
     */
    public static void marshal(Object jaxbElement, URI uri) {
        try {
            jakarta.xml.bind.JAXB.marshal(JAXBElement.wrap(jaxbElement), uri);
        } catch (jakarta.xml.bind.DataBindingException exception) {
            throw JAXBShim.<DataBindingException>of(exception);
        }
    }

    /**
     * @see jakarta.xml.bind.JAXB#marshal(Object, URL)
     */
    public static void marshal(Object jaxbElement, URL url) {
        try {
            jakarta.xml.bind.JAXB.marshal(JAXBElement.wrap(jaxbElement), url);
        } catch (jakarta.xml.bind.DataBindingException exception) {
            throw JAXBShim.<DataBindingException>of(exception);
        }
    }

    /**
     * @see jakarta.xml.bind.JAXB#marshal(Object, File)
     */
    public static void marshal(Object jaxbElement, File file) {
        try {
            jakarta.xml.bind.JAXB.marshal(JAXBElement.wrap(jaxbElement), file);
        } catch (jakarta.xml.bind.DataBindingException exception) {
            throw JAXBShim.<DataBindingException>of(exception);
        }
    }

    /**
     * @see jakarta.xml.bind.JAXB#marshal(Object, OutputStream)
     */
    public static void marshal(Object jaxbElement, OutputStream outputStream) {
        try {
            jakarta.xml.bind.JAXB.marshal(JAXBElement.wrap(jaxbElement), outputStream);
        } catch (jakarta.xml.bind.DataBindingException exception) {
            throw JAXBShim.<DataBindingException>of(exception);
        }
    }

    /**
     * @see jakarta.xml.bind.JAXB#marshal(Object, Writer)
     */
    public static void marshal(Object jaxbElement, Writer writer) {
        try {
            jakarta.xml.bind.JAXB.marshal(JAXBElement.wrap(jaxbElement), writer);
        } catch (jakarta.xml.bind.DataBindingException exception) {
            throw JAXBShim.<DataBindingException>of(exception);
        }
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        try {
            ShimPatcher.STRICT.patch(clazz -> clazz.instrument(new ShimPatcher() {
                @Override
                public void edit(NewExpr expression) throws CannotCompileException {
                    final var className = expression.getClassName();
                    if (className.equals(jakarta.xml.bind.JAXBElement.class.getName())) {
                        expression.replace(String.format("$_ = new %s($$);", swapType(className)));
                    }
                }
            }));
        } finally {
            JAXBShim.initialize();
        }
    }
}
