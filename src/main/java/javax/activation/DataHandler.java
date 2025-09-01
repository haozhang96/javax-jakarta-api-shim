package javax.activation;

import java.io.IOException;
import java.net.URL;

/**
 * @deprecated Use {@link jakarta.activation.DataHandler} instead.
 */
@Deprecated(since = "jakarta.activation.DataHandler")
public class DataHandler extends jakarta.activation.DataHandler implements ActivationShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.activation.DataHandler#DataHandler(jakarta.activation.DataSource)
     */
    public DataHandler(DataSource dataSource) {
        super(dataSource);
    }

    /**
     * @see jakarta.activation.DataHandler#DataHandler(Object, String)
     */
    public DataHandler(Object object, String mimeType) {
        super(object, mimeType);
    }

    /**
     * @see jakarta.activation.DataHandler#DataHandler(URL)
     */
    public DataHandler(URL url) {
        super(url);
    }

    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see jakarta.activation.DataHandler#isDataFlavorSupported(jakarta.activation.ActivationDataFlavor)
     */
    public boolean isDataFlavorSupported(ActivationDataFlavor dataFlavor) {
        return super.isDataFlavorSupported(dataFlavor);
    }

    /**
     * @see jakarta.activation.DataHandler#getTransferData(jakarta.activation.ActivationDataFlavor)
     */
    public Object getTransferData(ActivationDataFlavor dataFlavor) throws IOException {
        return super.getTransferData(dataFlavor);
    }

    /**
     * @see jakarta.activation.DataHandler#setCommandMap(jakarta.activation.CommandMap)
     */
    public synchronized void setCommandMap(CommandMap commandMap) {
        super.setCommandMap(commandMap);
    }

    /**
     * @see jakarta.activation.DataHandler#getBean(jakarta.activation.CommandInfo)
     */
    public Object getBean(CommandInfo commandInfo) {
        return super.getBean(commandInfo);
    }

    //==================================================================================================================
    // DataHandler Implementation Methods
    //==================================================================================================================

    @Override
    public DataSource getDataSource() {
        return ActivationShim.of(super.getDataSource());
    }

    @Override
    public synchronized ActivationDataFlavor[] getTransferDataFlavors() {
        return ActivationShim
            .<ActivationDataFlavor>of(super.getTransferDataFlavors())
            .toArray(ActivationDataFlavor[]::new);
    }

    @Override
    public boolean isDataFlavorSupported(jakarta.activation.ActivationDataFlavor dataFlavor) {
        return isDataFlavorSupported(ActivationShim.of(dataFlavor));
    }

    @Override
    public Object getTransferData(jakarta.activation.ActivationDataFlavor dataFlavor) throws IOException {
        return getTransferData(ActivationShim.of(dataFlavor));
    }

    @Override
    public synchronized void setCommandMap(jakarta.activation.CommandMap commandMap) {
        setCommandMap(ActivationShim.of(commandMap));
    }

    @Override
    public CommandInfo[] getPreferredCommands() {
        return ActivationShim
            .<CommandInfo>of(super.getPreferredCommands())
            .toArray(CommandInfo[]::new);
    }

    @Override
    public CommandInfo[] getAllCommands() {
        return ActivationShim
            .<CommandInfo>of(super.getAllCommands())
            .toArray(CommandInfo[]::new);
    }

    @Override
    public CommandInfo getCommand(String commandName) {
        return ActivationShim.of(super.getCommand(commandName));
    }

    @Override
    public Object getBean(jakarta.activation.CommandInfo commandInfo) {
        return getBean(ActivationShim.of(commandInfo));
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ActivationShim.initialize();
    }
}
