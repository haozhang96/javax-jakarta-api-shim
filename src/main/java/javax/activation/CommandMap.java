package javax.activation;

/**
 * @deprecated Use {@link jakarta.activation.CommandMap} instead.
 */
@Deprecated(since = "jakarta.activation.CommandMap")
public abstract class CommandMap extends jakarta.activation.CommandMap implements ActivationShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.activation.CommandMap#CommandMap()
     */
    protected CommandMap() {
        super();
    }

    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see jakarta.activation.CommandMap#getPreferredCommands(String, jakarta.activation.DataSource)
     */
    public CommandInfo[] getPreferredCommands(String mimeType, DataSource dataSource) {
        return ActivationShim
            .<CommandInfo>of(super.getPreferredCommands(mimeType, dataSource))
            .toArray(CommandInfo[]::new);
    }

    /**
     * @see jakarta.activation.CommandMap#getAllCommands(String, jakarta.activation.DataSource)
     */
    public CommandInfo[] getAllCommands(String mimeType, DataSource dataSource) {
        return ActivationShim
            .<CommandInfo>of(super.getAllCommands(mimeType, dataSource))
            .toArray(CommandInfo[]::new);
    }

    /**
     * @see jakarta.activation.CommandMap#getCommand(String, String, jakarta.activation.DataSource)
     */
    public CommandInfo getCommand(String mimeType, String commandName, DataSource dataSource) {
        return ActivationShim.of(super.getCommand(mimeType, commandName, dataSource));
    }

    /**
     * @see jakarta.activation.CommandMap#createDataContentHandler(String, jakarta.activation.DataSource)
     */
    public DataContentHandler createDataContentHandler(String mimeType, DataSource dataSource) {
        return ActivationShim.of(super.createDataContentHandler(mimeType, dataSource));
    }

    //==================================================================================================================
    // CommandMap Implementation Methods
    //==================================================================================================================

    @Override
    public abstract CommandInfo[] getPreferredCommands(String mimeType);

    @Override
    public CommandInfo[] getPreferredCommands(String mimeType, jakarta.activation.DataSource dataSource) {
        return getPreferredCommands(mimeType, ActivationShim.of(dataSource));
    }

    @Override
    public abstract CommandInfo[] getAllCommands(String mimeType);

    @Override
    public CommandInfo[] getAllCommands(String mimeType, jakarta.activation.DataSource dataSource) {
        return getAllCommands(mimeType, ActivationShim.of(dataSource));
    }

    @Override
    public abstract CommandInfo getCommand(String mimeType, String commandName);

    @Override
    public CommandInfo getCommand(String mimeType, String commandName, jakarta.activation.DataSource dataSource) {
        return getCommand(mimeType, commandName, ActivationShim.of(dataSource));
    }

    @Override
    public abstract DataContentHandler createDataContentHandler(String mimeType);

    @Override
    public DataContentHandler createDataContentHandler(String mimeType, jakarta.activation.DataSource dataSource) {
        return createDataContentHandler(mimeType, ActivationShim.of(dataSource));
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ActivationShim.initialize();
    }
}
