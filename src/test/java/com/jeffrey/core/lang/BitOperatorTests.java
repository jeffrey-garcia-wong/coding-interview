package com.jeffrey.core.lang;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitOperatorTests {

    @Test
    public void test() {
        int i = 7 << 1; // left-shift the bit pattern of 7 by 1 position
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));
    }

    @Test
    public void flipBits_001() {
        int a = 6; // 110 in binary, after flip should expect 001 = 1
        assertEquals(1, BitOperator.flipBits(a));
    }

}
