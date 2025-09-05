package javax.xml.bind;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.nio.charset.StandardCharsets;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class TestModel {
    @XmlElement(name = "A")
    private String a = "a";

    @XmlAttribute(name = "b")
    private long b = 1;

    @XmlJavaTypeAdapter(Adapter.class)
    private byte[] c = a.getBytes(StandardCharsets.UTF_8);

    private static final class Adapter extends XmlAdapter<String, byte[]> {
        @Override
        public byte[] unmarshal(String value) {
            return value.getBytes(StandardCharsets.UTF_8);
        }

        @Override
        public String marshal(byte[] value) {
            return new String(value, StandardCharsets.UTF_8);
        }
    }
}
