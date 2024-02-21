package org.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SimpleControllerTest {

    @Test
    public void testDummyMethod() {
        SimpleController controller = new SimpleController();
        String result = controller.dummyMethod();
        assertEquals("Hello from dummy method!", result);
    }
}
