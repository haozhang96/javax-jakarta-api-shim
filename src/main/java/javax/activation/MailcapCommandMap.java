package javax.activation;

import java.io.IOException;
import java.io.InputStream;

/**
 * @deprecated Use {@link jakarta.activation.MailcapCommandMap} instead.
 * @apiNote This class cannot extend {@link jakarta.activation.MailcapCommandMap} due to class hierarchy divergence.
 */
@Deprecated(since = "jakarta.activation.MailcapCommandMap")
public class MailcapCommandMap extends CommandMap {
    private final jakarta.activation.MailcapCommandMap target;

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.activation.MailcapCommandMap#MailcapCommandMap()
     */
    public MailcapCommandMap() {
        target = new jakarta.activation.MailcapCommandMap();
    }

    /**
     * @see jakarta.activation.MailcapCommandMap#MailcapCommandMap(String)
     */
    public MailcapCommandMap(String fileName) throws IOException {
        target = new jakarta.activation.MailcapCommandMap(fileName);
    }

    /**
     * @see jakarta.activation.MailcapCommandMap#MailcapCommandMap(InputStream)
     */
    public MailcapCommandMap(InputStream inputStream) {
        target = new jakarta.activation.MailcapCommandMap(inputStream);
    }

    //==================================================================================================================
    // Delegated Methods
    //==================================================================================================================

    @Override
    public CommandInfo[] getPreferredCommands(String mimeType) {
        return ActivationShim
            .<CommandInfo>of(target.getPreferredCommands(mimeType))
            .toArray(CommandInfo[]::new);
    }

    @Override
    public CommandInfo[] getPreferredCommands(String mimeType, DataSource dataSource) {
        return ActivationShim
            .<CommandInfo>of(target.getPreferredCommands(mimeType, dataSource))
            .toArray(CommandInfo[]::new);
    }

    @Override
    public CommandInfo[] getPreferredCommands(String mimeType, jakarta.activation.DataSource dataSource) {
        return ActivationShim
            .<CommandInfo>of(target.getPreferredCommands(mimeType, dataSource))
            .toArray(CommandInfo[]::new);
    }

    @Override
    public CommandInfo[] getAllCommands(String mimeType) {
        return ActivationShim
            .<CommandInfo>of(target.getAllCommands(mimeType))
            .toArray(CommandInfo[]::new);
    }

    @Override
    public CommandInfo[] getAllCommands(String mimeType, DataSource dataSource) {
        return ActivationShim
            .<CommandInfo>of(target.getAllCommands(mimeType, dataSource))
            .toArray(CommandInfo[]::new);
    }

    @Override
    public CommandInfo[] getAllCommands(String mimeType, jakarta.activation.DataSource dataSource) {
        return ActivationShim
            .<CommandInfo>of(target.getAllCommands(mimeType, dataSource))
            .toArray(CommandInfo[]::new);
    }

    @Override
    public CommandInfo getCommand(String mimeType, String commandName) {
        return ActivationShim.of(target.getCommand(mimeType, commandName));
    }

    @Override
    public CommandInfo getCommand(String mimeType, String commandName, DataSource dataSource) {
        return ActivationShim.of(target.getCommand(mimeType, commandName, dataSource));
    }

    @Override
    public CommandInfo getCommand(String mimeType, String commandName, jakarta.activation.DataSource dataSource) {
        return ActivationShim.of(target.getCommand(mimeType, commandName, dataSource));
    }

    @Override
    public DataContentHandler createDataContentHandler(String mimeType) {
        return ActivationShim.of(target.createDataContentHandler(mimeType));
    }

    @Override
    public DataContentHandler createDataContentHandler(String mimeType, DataSource dataSource) {
        return ActivationShim.of(target.createDataContentHandler(mimeType, dataSource));
    }

    @Override
    public DataContentHandler createDataContentHandler(String mimeType, jakarta.activation.DataSource dataSource) {
        return ActivationShim.of(target.createDataContentHandler(mimeType, dataSource));
    }
}
