package javax.xml.bind.annotation;

import javax.xml.bind.JAXBShim;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.transform.Result;
import javax.xml.transform.Source;

/**
 * @deprecated Use {@link jakarta.xml.bind.annotation.DomHandler} instead.
 */
@Deprecated(since = "jakarta.xml.bind.annotation.DomHandler")
public interface DomHandler<ElementT, ResultT extends Result> extends jakarta.xml.bind.annotation.DomHandler<ElementT, ResultT>, JAXBShim {
    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.annotation.DomHandler#createUnmarshaller(jakarta.xml.bind.ValidationEventHandler)
     */
    ResultT createUnmarshaller(ValidationEventHandler errorHandler);

    /**
     * @see jakarta.xml.bind.annotation.DomHandler#marshal(ElementT, jakarta.xml.bind.ValidationEventHandler)
     */
    Source marshal(ElementT element, ValidationEventHandler errorHandler);

    //==================================================================================================================
    // DomHandler Implementation Methods
    //==================================================================================================================

    @Override
    default ResultT createUnmarshaller(jakarta.xml.bind.ValidationEventHandler errorHandler) {
        return createUnmarshaller(JAXBShim.of(errorHandler));
    }

    @Override
    default Source marshal(ElementT element, jakarta.xml.bind.ValidationEventHandler errorHandler) {
        return marshal(element, JAXBShim.of(errorHandler));
    }
}
