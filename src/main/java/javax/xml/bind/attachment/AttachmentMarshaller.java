package javax.xml.bind.attachment;

import javax.activation.ActivationShim;
import javax.activation.DataHandler;
import javax.xml.bind.JAXBShim;

/**
 * @deprecated Use {@link jakarta.xml.bind.attachment.AttachmentMarshaller} instead.
 */
@Deprecated(since = "jakarta.xml.bind.attachment.AttachmentMarshaller")
public abstract class AttachmentMarshaller extends jakarta.xml.bind.attachment.AttachmentMarshaller implements JAXBShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.attachment.AttachmentMarshaller#AttachmentMarshaller()
     */
    protected AttachmentMarshaller() {
        super();
    }

    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.attachment.AttachmentMarshaller#addMtomAttachment(jakarta.activation.DataHandler, String, String)
     */
    public abstract String addMtomAttachment(DataHandler dataHandler, String elementNamespace, String elementLocalName);

    /**
     * @see jakarta.xml.bind.attachment.AttachmentMarshaller#addSwaRefAttachment(jakarta.activation.DataHandler)
     */
    public abstract String addSwaRefAttachment(DataHandler dataHandler);

    //==================================================================================================================
    // AttachmentMarshaller Implementation Methods
    //==================================================================================================================

    @Override
    public String addMtomAttachment(
        jakarta.activation.DataHandler dataHandler,
        String elementNamespace,
        String elementLocalName
    ) {
        return addMtomAttachment(ActivationShim.of(dataHandler), elementNamespace, elementLocalName);
    }

    @Override
    public String addSwaRefAttachment(jakarta.activation.DataHandler dataHandler) {
        return addSwaRefAttachment(ActivationShim.of(dataHandler));
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JAXBShim.initialize();
    }
}
