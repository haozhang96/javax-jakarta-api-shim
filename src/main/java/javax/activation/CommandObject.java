package javax.activation;

import java.io.IOException;

/**
 * @deprecated Use {@link jakarta.activation.CommandObject} instead.
 */
@Deprecated(since = "jakarta.activation.CommandObject")
public interface CommandObject extends jakarta.activation.CommandObject, ActivationShim {
    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see jakarta.activation.CommandObject#setCommandContext(String, jakarta.activation.DataHandler)
     */
    void setCommandContext(String verb, DataHandler dataHandler) throws IOException;

    //==================================================================================================================
    // DataContentHandler Implementation Methods
    //==================================================================================================================

    @Override
    default void setCommandContext(String verb, jakarta.activation.DataHandler dataHandler) throws IOException {
        setCommandContext(verb, ActivationShim.of(dataHandler));
    }
}
