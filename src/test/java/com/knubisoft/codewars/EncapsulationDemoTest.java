package com.knubisoft.codewars;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class EncapsulationDemoTest {
    @Test
    public void testSample() {
        EncapsulationDemo ed = new EncapsulationDemo();
        assertEquals(
                0,
                ed.getNumber()
        );
    }
}