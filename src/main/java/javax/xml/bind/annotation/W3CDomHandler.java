package javax.xml.bind.annotation;

import org.w3c.dom.Element;

import javax.xml.bind.JAXBShim;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMResult;

/**
 * @deprecated Use {@link jakarta.xml.bind.annotation.W3CDomHandler} instead.
 */
@Deprecated(since = "jakarta.xml.bind.annotation.W3CDomHandler")
public class W3CDomHandler extends jakarta.xml.bind.annotation.W3CDomHandler implements DomHandler<Element, DOMResult> {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.annotation.W3CDomHandler#W3CDomHandler()
     */
    public W3CDomHandler() {
        super();
    }

    /**
     * @see jakarta.xml.bind.annotation.W3CDomHandler#W3CDomHandler(DocumentBuilder)
     */
    public W3CDomHandler(DocumentBuilder documentBuilder) {
        super(documentBuilder);
    }

    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    @Override
    public DOMResult createUnmarshaller(ValidationEventHandler errorHandler) {
        return super.createUnmarshaller(errorHandler);
    }

    @Override
    public Source marshal(Element element, ValidationEventHandler errorHandler) {
        return super.marshal(element, errorHandler);
    }

    //==================================================================================================================
    // DomHandler Implementation Methods
    //==================================================================================================================

    @Override
    public DOMResult createUnmarshaller(jakarta.xml.bind.ValidationEventHandler errorHandler) {
        return DomHandler.super.createUnmarshaller(errorHandler);
    }

    @Override
    public Source marshal(Element element, jakarta.xml.bind.ValidationEventHandler errorHandler) {
        return DomHandler.super.marshal(element, errorHandler);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JAXBShim.initialize();
    }
}
