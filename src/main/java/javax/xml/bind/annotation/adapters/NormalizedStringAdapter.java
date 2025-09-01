package javax.xml.bind.annotation.adapters;

/**
 * @deprecated Use {@link jakarta.xml.bind.annotation.adapters.NormalizedStringAdapter} instead.
 * @apiNote This class cannot extend {@link jakarta.xml.bind.annotation.adapters.NormalizedStringAdapter} due to class
 *          hierarchy divergence.
 */
@Deprecated(since = "jakarta.xml.bind.annotation.adapters.NormalizedStringAdapter")
public class NormalizedStringAdapter extends XmlAdapter<String, String> {
    private final jakarta.xml.bind.annotation.adapters.NormalizedStringAdapter target =
        new jakarta.xml.bind.annotation.adapters.NormalizedStringAdapter();

    //==================================================================================================================
    // XmlAdapter Implementation Methods
    //==================================================================================================================

    @Override
    public String unmarshal(String string) {
        return target.unmarshal(string);
    }

    @Override
    public String marshal(String string) {
        return target.marshal(string);
    }
}
