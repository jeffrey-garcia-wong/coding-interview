package com.jeffrey.core.maths;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciSequenceTests {

    @Test
    public void test_001() {
        assertEquals(0, FibonacciSequence.execute(0));
    }

    @Test
    public void test_002() {
        assertEquals(1, FibonacciSequence.execute(1));
    }

    @Test
    public void test_003() {
        assertEquals(1, FibonacciSequence.execute(2));
    }

    @Test
    public void test_004() {
        assertEquals(2, FibonacciSequence.execute(3));
    }

    @Test
    public void test_005() {
        assertEquals(3, FibonacciSequence.execute(4));
    }

    @Test
    public void test_006() {
        assertEquals(5, FibonacciSequence.execute(5));
    }

    @Test
    public void test_007() {
        assertEquals(55, FibonacciSequence.execute(10));
    }

    @Test
    public void test_009() {
        assertEquals(1134903170, FibonacciSequence.execute(45));
    }

}
