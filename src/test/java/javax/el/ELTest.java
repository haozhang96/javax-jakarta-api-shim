package javax.el;

import org.junit.jupiter.api.Test;

public class ELTest {
    public void bean() {
        System.out.println("bean");
    }

    @Test
    void test() {
        final var processor = new ELProcessor();
        processor.defineBean("test", this);
        processor.eval("test.bean()");
    }
}
