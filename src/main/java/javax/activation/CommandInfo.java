package javax.activation;

import java.io.IOException;

/**
 * @deprecated Use {@link jakarta.activation.CommandInfo} instead.
 */
@Deprecated(since = "jakarta.activation.CommandInfo")
public class CommandInfo extends jakarta.activation.CommandInfo implements ActivationShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.activation.CommandInfo#CommandInfo(String, String)
     */
    public CommandInfo(String verb, String className) {
        super(verb, className);
    }

    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see jakarta.activation.CommandInfo#getCommandObject(jakarta.activation.DataHandler, ClassLoader)
     */
    public Object getCommandObject(
        DataHandler dataHandler,
        ClassLoader classLoader
    ) throws IOException, ClassNotFoundException {
        return super.getCommandObject(dataHandler, classLoader);
    }

    //==================================================================================================================
    // CommandInfo Implementation Methods
    //==================================================================================================================

    @Override
    public Object getCommandObject(
        jakarta.activation.DataHandler dataHandler,
        ClassLoader classLoader
    ) throws IOException, ClassNotFoundException {
        return getCommandObject(ActivationShim.of(dataHandler), classLoader);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ActivationShim.initialize();
    }
}
