package io.jeffrey.facebook.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MagicalCandyBagsTests {

    @Test
    public void test_001() {
        int[] arr = {1};
        int k = 10;
        assertEquals(1, MagicalCandyBags.execute(arr, k));
    }

    @Test
    public void test_002() {
        int[] arr = {1, 2};
        int k = 10;
        assertEquals(4, MagicalCandyBags.execute(arr, k));
    }

    @Test
    public void test_003() {
        int[] arr = {2, 1, 7, 4, 2};
        int k = 3;
        assertEquals(14, MagicalCandyBags.execute(arr, k));
    }

    @Test
    public void test_004() {
        int[] arr = {19, 78, 76, 72, 48, 8, 24, 74, 29};
        int k = 3;
        assertEquals(228, MagicalCandyBags.execute(arr, k));
    }
}
