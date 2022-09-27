package com.jeffrey.core.lang;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class FourBitsIntegerTests {

    @Test
    public void getMaxValue() {
        FourBitsInteger max = new FourBitsInteger(FourBitsInteger.MAX_VALUE);
        assertEquals(7, max.intValue());
    }

    @Test
    public void getMinValue() {
        FourBitsInteger min = new FourBitsInteger(FourBitsInteger.MIN_VALUE);
        assertEquals(-8, min.intValue());
    }

    @Test
    public void overflow_001() {
        FourBitsInteger a = new FourBitsInteger(8);
        assertEquals(-8, a.intValue());
    }

    @Test
    public void overflow_002() {
        FourBitsInteger a = new FourBitsInteger(15);
        assertEquals(-1, a.intValue());
    }

    @Test
    public void overflow_003() {
        FourBitsInteger a = new FourBitsInteger(23);
        assertEquals(7, a.intValue());
    }

    @Test
    public void overflow_004() {
        FourBitsInteger a = new FourBitsInteger(32);
        assertEquals(0, a.intValue());
    }

    @Test
    public void underflow_001() {
        FourBitsInteger a = new FourBitsInteger(-9);
        assertEquals(7, a.intValue());
    }

    @Test
    public void underflow_002() {
        FourBitsInteger a = new FourBitsInteger(-16);
        assertEquals(0, a.intValue());
    }

    @Test
    public void underflow_003() {
        FourBitsInteger a = new FourBitsInteger(-23);
        assertEquals(-7, a.intValue());
    }

    /**
     * normal addition that doesn't overflow
     */
    @Test
    public void add_001() {
        FourBitsInteger a = new FourBitsInteger(2);
        assertEquals(5, a.add(3).intValue());
    }

    /**
     * addition that overflows and triggers the first cycle
     */
    @Test
    public void add_002() {
        FourBitsInteger a = new FourBitsInteger(5);
        assertEquals(FourBitsInteger.MIN_VALUE, a.add(3).intValue());
    }

    /**
     * addition that overflows and triggers the second cycle
     */
    @Test
    public void add_003() {
        FourBitsInteger a = new FourBitsInteger(7);
        assertEquals(1, a.add(10).intValue());
    }

    /**
     * addition that overflows and triggers the third cycle
     */
    @Test
    public void add_004() {
        FourBitsInteger a = new FourBitsInteger(6);
        assertEquals(-6, a.add(20).intValue());
    }

    /**
     * addition that underflows and triggers the first cycle in reverse direction
     */
    @Test
    public void add_005() {
        FourBitsInteger a = new FourBitsInteger(6);
        assertEquals(-7, a.add(3).intValue());
    }

    /**
     * normal subtraction the doesn't underflow
     */
    @Test
    public void minus_001() {
        FourBitsInteger a = new FourBitsInteger(7);
        assertEquals(4, a.minus(3).intValue());
    }

    /**
     * subtraction that triggers the first cycle
     */
    @Test
    public void minus_002() {
        FourBitsInteger a = new FourBitsInteger(3);
        assertEquals(-3, a.minus(6).intValue());
    }

    /**
     * subtraction that triggers the second cycle
     */
    @Test
    public void minus_003() {
        FourBitsInteger a = new FourBitsInteger(0);
        assertEquals(5, a.minus(11).intValue());
    }

    /**
     * subtraction that overflows and triggers the first cycle in reverse direction
     */
    @Test
    public void minus_004() {
        FourBitsInteger a = new FourBitsInteger(3);
        assertEquals(-7, a.minus(-6).intValue());
    }

}
