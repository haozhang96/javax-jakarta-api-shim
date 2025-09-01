package javax.xml.bind.annotation.adapters;

/**
 * @deprecated Use {@link jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter} instead.
 * @apiNote This class cannot extend {@link jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter} due to class
 *          hierarchy divergence.
 */
@Deprecated(since = "jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter")
public class CollapsedStringAdapter extends XmlAdapter<String, String> {
    private final jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter target =
        new jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter();

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
