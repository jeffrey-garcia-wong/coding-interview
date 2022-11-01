package io.jeffrey.core.lang;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FourBitsIntegerTests {

    private int convert(int input) {
        int size = Double.valueOf(Math.pow(2,4)).intValue();
        int max = Double.valueOf(Math.pow(2,3)).intValue() - 1;
        int min = -Double.valueOf(Math.pow(2,3)).intValue();
        if (input % size > max) {
            return (input % size) - size;
        } else if (input % size < min) {
            return (input % size) + size;
        } else {
            return input % size;
        }
    }

    @Test
    public void getMaxValue() {
        FourBitsInteger max = new FourBitsInteger(FourBitsInteger.MAX_VALUE);
        assertEquals(convert(max.intValue()), max.intValue());
    }

    @Test
    public void getMinValue() {
        FourBitsInteger min = new FourBitsInteger(FourBitsInteger.MIN_VALUE);
        assertEquals(convert(min.intValue()), min.intValue());
    }

    @Test
    public void overflow_001() {
        FourBitsInteger a = new FourBitsInteger(8);
        assertEquals(convert(a.intValue()), a.intValue());
    }

    @Test
    public void overflow_002() {
        FourBitsInteger a = new FourBitsInteger(15);
        assertEquals(convert(a.intValue()), a.intValue());
    }

    @Test
    public void overflow_003() {
        FourBitsInteger a = new FourBitsInteger(23);
        assertEquals(convert(a.intValue()), a.intValue());
    }

    @Test
    public void overflow_004() {
        FourBitsInteger a = new FourBitsInteger(32);
        assertEquals(convert(a.intValue()), a.intValue());
    }

    @Test
    public void underflow_001() {
        FourBitsInteger a = new FourBitsInteger(-9);
        assertEquals(convert(a.intValue()), a.intValue());
    }

    @Test
    public void underflow_002() {
        FourBitsInteger a = new FourBitsInteger(-16);
        assertEquals(convert(a.intValue()), a.intValue());
    }

    @Test
    public void underflow_003() {
        FourBitsInteger a = new FourBitsInteger(-23);
        assertEquals(convert(a.intValue()), a.intValue());
    }

    /**
     * normal addition that doesn't overflow
     */
    @Test
    public void add_001() {
        FourBitsInteger a = new FourBitsInteger(2);
        assertEquals(convert(a.intValue() + 3), a.add(3).intValue());
    }

    /**
     * addition that overflows and triggers the first cycle
     */
    @Test
    public void add_002() {
        FourBitsInteger a = new FourBitsInteger(5);
        assertEquals(convert(a.intValue() + 3), a.add(3).intValue());
    }

    /**
     * addition that overflows and triggers the second cycle
     */
    @Test
    public void add_003() {
        FourBitsInteger a = new FourBitsInteger(7);
        assertEquals(convert(a.intValue() + 10), a.add(10).intValue());
    }

    /**
     * addition that overflows and triggers the third cycle
     */
    @Test
    public void add_004() {
        FourBitsInteger a = new FourBitsInteger(6);
        assertEquals(convert(a.intValue() + 20), a.add(20).intValue());
    }

    /**
     * addition that underflows and triggers the first cycle in reverse direction
     */
    @Test
    public void add_005() {
        FourBitsInteger a = new FourBitsInteger(6);
        assertEquals(convert(a.intValue() + 3), a.add(3).intValue());
    }

    /**
     * normal subtraction the doesn't underflow
     */
    @Test
    public void minus_001() {
        FourBitsInteger a = new FourBitsInteger(7);
        assertEquals(convert(a.intValue() - 3), a.minus(3).intValue());
    }

    /**
     * subtraction that triggers the first cycle
     */
    @Test
    public void minus_002() {
        FourBitsInteger a = new FourBitsInteger(3);
        assertEquals(convert(a.intValue() - 6), a.minus(6).intValue());
    }

    /**
     * subtraction that triggers the second cycle
     */
    @Test
    public void minus_003() {
        FourBitsInteger a = new FourBitsInteger(0);
        assertEquals(convert(a.intValue() - 11), a.minus(11).intValue());
    }

    /**
     * subtraction that overflows and triggers the first cycle in reverse direction
     */
    @Test
    public void minus_004() {
        FourBitsInteger a = new FourBitsInteger(3);
        assertEquals(convert(a.intValue() - -6), a.minus(-6).intValue());
    }

}
