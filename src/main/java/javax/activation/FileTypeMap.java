package javax.activation;

/**
 * @deprecated Use {@link jakarta.activation.FileTypeMap} instead.
 */
@Deprecated(since = "jakarta.activation.FileTypeMap")
public abstract class FileTypeMap extends jakarta.activation.FileTypeMap implements ActivationShim {
    //==================================================================================================================
    // Factory Methods
    //==================================================================================================================

    /**
     * @see jakarta.activation.FileTypeMap#getDefaultFileTypeMap()
     */
    public static FileTypeMap getDefaultFileTypeMap() {
        return ActivationShim.of(jakarta.activation.FileTypeMap.getDefaultFileTypeMap());
    }

    /**
     * @see jakarta.activation.FileTypeMap#setDefaultFileTypeMap(jakarta.activation.FileTypeMap)
     */
    public static void setDefaultFileTypeMap(FileTypeMap fileTypeMap) {
        jakarta.activation.FileTypeMap.setDefaultFileTypeMap(fileTypeMap);
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ActivationShim.initialize();
    }
}
