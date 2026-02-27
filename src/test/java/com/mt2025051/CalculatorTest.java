package com.mt2025051;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testSquareRoot() {
        assertEquals(4.0, App.squareRoot(16));
    }

    @Test
    void testFactorial() {
        assertEquals(120, App.factorial(5));
    }

    @Test
    void testNaturalLog() {
        assertEquals(0.0, App.naturalLog(1), 0.0001);
    }

    @Test
    void testPower() {
        assertEquals(8.0, App.power(2, 3));
    }

    @Test
    void testNegativeFactorial() {
        assertThrows(IllegalArgumentException.class, () -> {
            App.factorial(-5);
        });
    }
}
