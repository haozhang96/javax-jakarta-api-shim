package javax.xml.bind.attachment;

import javax.activation.DataHandler;
import javax.xml.bind.JAXBShim;

/**
 * @deprecated Use {@link jakarta.xml.bind.attachment.AttachmentUnmarshaller} instead.
 */
@Deprecated(since = "jakarta.xml.bind.attachment.AttachmentUnmarshaller")
public abstract class AttachmentUnmarshaller extends jakarta.xml.bind.attachment.AttachmentUnmarshaller implements JAXBShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.attachment.AttachmentUnmarshaller#AttachmentUnmarshaller()
     */
    protected AttachmentUnmarshaller() {
        super();
    }

    //==================================================================================================================
    // AttachmentUnmarshaller Implementation Methods
    //==================================================================================================================

    @Override
    public abstract DataHandler getAttachmentAsDataHandler(String cid);

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JAXBShim.initialize();
    }
}
