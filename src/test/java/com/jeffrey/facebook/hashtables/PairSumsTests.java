package com.jeffrey.facebook.hashtables;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PairSumsTests {

    @Test
    public void test_001() {
        assertEquals(2, PairSums.execute(new int[] {1,2,3,4,3}, 6));
    }

    @Test
    public void test_002() {
        assertEquals(4, PairSums.execute(new int[] {1,5,3,3,3}, 6));
    }

    @Test
    public void test_003() {
        assertEquals(5, PairSums.execute(new int[] {1,2,2,3,4,4,3}, 6));
    }
}
