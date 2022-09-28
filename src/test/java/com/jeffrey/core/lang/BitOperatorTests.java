package com.jeffrey.core.lang;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitOperatorTests {

    @Test
    public void test() {
        int i = 32768;
        short actual = Integer.valueOf(i).shortValue();

        int expected = (i % 65536)>Short.MAX_VALUE? (i % 65536) - 65536 : (i % 65536);

        assertEquals(expected, actual);
    }

    @Test
    public void flipBits_001() {
        int a = 6; // 110 in binary, after flip should expect 001 = 1
        assertEquals(1, BitOperator.flipBits(a));
    }

}
