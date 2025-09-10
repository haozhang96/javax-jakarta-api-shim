package javax.activation;

import java.io.File;

/**
 * @deprecated Use {@link jakarta.activation.FileDataSource} instead.
 */
@Deprecated(since = "jakarta.activation.FileDataSource")
public class FileDataSource extends jakarta.activation.FileDataSource implements ActivationShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.activation.FileDataSource#FileDataSource(String)
     */
    public FileDataSource(String fileName) {
        super(fileName);
    }

    /**
     * @see jakarta.activation.FileDataSource#FileDataSource(File)
     */
    public FileDataSource(File file) {
        super(file);
    }

    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see jakarta.activation.FileDataSource#setFileTypeMap(jakarta.activation.FileTypeMap)
     */
    public void setFileTypeMap(FileTypeMap map) {
        super.setFileTypeMap(map);
    }

    //==================================================================================================================
    // FileDataSource Implementation Methods
    //==================================================================================================================

    @Override
    public void setFileTypeMap(jakarta.activation.FileTypeMap map) {
        setFileTypeMap(ActivationShim.of(map));
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ActivationShim.initialize();
    }
}
