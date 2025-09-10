package javax.activation;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @deprecated Use {@link jakarta.activation.MimetypesFileTypeMap} instead.
 * @apiNote This class cannot extend {@link jakarta.activation.MimetypesFileTypeMap} due to class hierarchy divergence.
 */
@Deprecated(since = "jakarta.activation.MimetypesFileTypeMap")
public class MimetypesFileTypeMap extends FileTypeMap {
    private final jakarta.activation.MimetypesFileTypeMap target;

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.activation.MimetypesFileTypeMap#MimetypesFileTypeMap()
     */
    public MimetypesFileTypeMap() {
        target = new jakarta.activation.MimetypesFileTypeMap();
    }

    /**
     * @see jakarta.activation.MimetypesFileTypeMap#MimetypesFileTypeMap(String)
     */
    public MimetypesFileTypeMap(String fileName) throws IOException {
        target = new jakarta.activation.MimetypesFileTypeMap(fileName);
    }

    /**
     * @see jakarta.activation.MimetypesFileTypeMap#MimetypesFileTypeMap(InputStream)
     */
    public MimetypesFileTypeMap(InputStream inputStream) {
        target = new jakarta.activation.MimetypesFileTypeMap(inputStream);
    }

    //==================================================================================================================
    // Delegated Methods
    //==================================================================================================================

    @Override
    public String getContentType(File file) {
        return target.getContentType(file);
    }

    @Override
    public String getContentType(String fileName) {
        return target.getContentType(fileName);
    }
}
