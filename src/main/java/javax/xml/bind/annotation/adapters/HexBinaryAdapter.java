package javax.xml.bind.annotation.adapters;

/**
 * @deprecated Use {@link jakarta.xml.bind.annotation.adapters.HexBinaryAdapter} instead.
 * @apiNote This class cannot extend {@link jakarta.xml.bind.annotation.adapters.HexBinaryAdapter} due to class
 *          hierarchy divergence.
 */
@Deprecated(since = "jakarta.xml.bind.annotation.adapters.HexBinaryAdapter")
public class HexBinaryAdapter extends XmlAdapter<String, byte[]> {
    private final jakarta.xml.bind.annotation.adapters.HexBinaryAdapter target =
        new jakarta.xml.bind.annotation.adapters.HexBinaryAdapter();

    //==================================================================================================================
    // XmlAdapter Implementation Methods
    //==================================================================================================================

    @Override
    public byte[] unmarshal(String string) {
        return target.unmarshal(string);
    }

    @Override
    public String marshal(byte[] bytes) {
        return target.marshal(bytes);
    }
}
