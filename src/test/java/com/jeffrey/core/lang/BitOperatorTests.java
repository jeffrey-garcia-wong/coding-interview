package com.jeffrey.core.lang;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BitOperatorTests {

    @Test
    public void setBit_001() {
        // 10(2) set bit 0 = 11(3)
        assertEquals(3, BitOperator.setBit(2, 0));
    }

    @Test
    public void setBit_002() {
        // 100(4) set bit 1 = 110(6)
        assertEquals(6, BitOperator.setBit(4, 1));
    }

    @Test
    public void clearBit_001() {
        // 11(3) clear bit 0 = 10(2)
        assertEquals(2, BitOperator.clearBit(3, 0));
    }

    @Test
    public void clearBit_002() {
        // 110(6) clear bit 1 = 100(4)
        assertEquals(4, BitOperator.clearBit(6, 1));
    }

    @Test
    public void testBit_001() {
        // 1000(8) set bit 2 = 1100(12)
        assertEquals(12, BitOperator.setBit(8,2));

        // 1100(12) bit 3 is set
        assertTrue(BitOperator.testBit(12, 3));

        // 1100(12) bit 2 is set
        assertTrue(BitOperator.testBit(12, 2));

        // 1100(12) bit 1 is not set
        assertFalse(BitOperator.testBit(12, 1));

        // 1100(12) bit 0 is not set
        assertFalse(BitOperator.testBit(12, 0));
    }

    @Test
    public void testBit_002() {
        // 1100(12) clear bit 2 = 1000(8)
        assertEquals(8, BitOperator.clearBit(12,2));

        // 1000(8) bit 3 is set
        assertTrue(BitOperator.testBit(8, 3));

        // 1000(8) bit 2 is not set
        assertFalse(BitOperator.testBit(8, 2));

        // 1000(8) bit 1 is not set
        assertFalse(BitOperator.testBit(8, 1));

        // 1000(8) bit 0 is not set
        assertFalse(BitOperator.testBit(8, 0));
    }

    @Test
    public void testBit_003() {
        // 1010(10) set bit 1 = 1010(10)
        assertEquals(10, BitOperator.setBit(10,1));

        // 1010(10) bit 3 is set
        assertTrue(BitOperator.testBit(10, 3));

        // 1010(10) bit 2 is not set
        assertFalse(BitOperator.testBit(10, 2));

        // 1010(10) bit 1 is set
        assertTrue(BitOperator.testBit(10, 1));

        // 1010(10) bit 0 is not set
        assertFalse(BitOperator.testBit(10, 0));
    }

    @Test
    public void isDivisibleBy2_001() {
        for (int i=1000000; i>0; i-=2) {
            assertTrue(BitOperator.isDivisibleBy2(i));
        }
    }

    @Test
    public void flipBits_001() {
        int a = 6; // 110 in binary, after flip should expect 001 = 1
        assertEquals(1, BitOperator.flipBits(a));
    }

}
