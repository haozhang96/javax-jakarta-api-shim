package javax.xml.bind;

import javax.shim.ShimSupport;
import javax.xml.namespace.QName;

/**
 * @deprecated Use {@link jakarta.xml.bind.JAXBElement} instead.
 */
@Deprecated(since = "jakarta.xml.bind.JAXBElement")
public class JAXBElement<T> extends jakarta.xml.bind.JAXBElement<T> implements JAXBShim {
    private static final long serialVersionUID = ShimSupport.getSerialVersionUID();

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.JAXBElement#JAXBElement(QName, Class, Class, T)
     */
    public JAXBElement(QName name, Class<T> declaredType, Class<?> scope, T value) {
        super(name, declaredType, scope, value);
    }

    /**
     * @see jakarta.xml.bind.JAXBElement#JAXBElement(QName, Class, T)
     */
    public JAXBElement(QName name, Class<T> declaredType, T value) {
        super(name, declaredType, value);
    }

    //==================================================================================================================
    // Helper Methods
    //==================================================================================================================

    @SuppressWarnings("unchecked")
    public static <T> T wrap(T object) {
        if (object instanceof JAXBElement<?>) {
            return object;
        } else if (object instanceof jakarta.xml.bind.JAXBElement<?>) {
            return (T) new Facades.JAXBElement<>((jakarta.xml.bind.JAXBElement<?>) object);
        } else {
            return object;
        }
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JAXBShim.initialize();
    }
}
