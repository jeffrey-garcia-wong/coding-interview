package com.jeffrey.core.maths;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigFibonacciSequenceTests {

    @Test
    public void test_001() {
        assertEquals("0", BigFibonacciSequence.execute(0));
    }

    @Test
    public void test_002() {
        assertEquals("1", BigFibonacciSequence.execute(1));
    }

    @Test
    public void test_003() {
        assertEquals("1", BigFibonacciSequence.execute(2));
    }

    @Test
    public void test_004() {
        assertEquals("2", BigFibonacciSequence.execute(3));
    }

    @Test
    public void test_005() {
        assertEquals("3", BigFibonacciSequence.execute(4));
    }

    @Test
    public void test_006() {
        assertEquals("5", BigFibonacciSequence.execute(5));
    }

    @Test
    public void test_007() {
        assertEquals("55", BigFibonacciSequence.execute(10));
    }

    @Test
    public void test_009() {
        assertEquals("1134903170", BigFibonacciSequence.execute(45));
    }

    @Test
    public void test_010() {
        System.out.println(BigFibonacciSequence.execute(1000));
    }

}
