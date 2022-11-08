package io.jeffrey.core.maths;

import org.junit.jupiter.api.Test;

import static io.jeffrey.core.maths.Fibonacci.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciTests {

    @Test
    public void test_001() {
        assertEquals(0, execute(0));
    }

    @Test
    public void test_002() {
        assertEquals(1, execute(1));
    }

    @Test
    public void test_003() {
        assertEquals(1, execute(2));
    }

    @Test
    public void test_004() {
        assertEquals(2, execute(3));
    }

    @Test
    public void test_005() {
        assertEquals(3, execute(4));
    }

    @Test
    public void test_006() {
        assertEquals(5, execute(5));
    }

    @Test
    public void test_007() {
        assertEquals(55, execute(10));
    }

    @Test
    public void test_009() {
        assertEquals(1134903170, execute(45));
    }
}
