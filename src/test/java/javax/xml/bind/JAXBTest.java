package javax.xml.bind;

import org.junit.jupiter.api.Test;

import javax.xml.namespace.QName;

class JAXBTest {
    @Test
    void test() {
        JAXB.marshal(this, System.out);
        JAXB.marshal(new JAXBElement(QName.valueOf("hi"), getClass(), this), System.out);
        JAXB.marshal(new TestModel(), System.out);
        JAXB.marshal(new JAXBElement<>(QName.valueOf("model"), TestModel.class, new TestModel()), System.out);
    }
}
