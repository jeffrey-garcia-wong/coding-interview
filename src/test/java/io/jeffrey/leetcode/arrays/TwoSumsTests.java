package io.jeffrey.leetcode.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoSumsTests {

    @Test
    public void test_001() {
        int[] expected = new int[]{0,1};
        int[] result = TwoSums.execute(new int[] {2,7,11,15}, 9);
        Arrays.sort(result);
        assertEquals(
            Arrays.toString(expected),
            Arrays.toString(result)
        );
    }

    @Test
    public void test_002() {
        int[] expected = new int[]{1,2};
        int[] result = TwoSums.execute(new int[] {3,2,4}, 6);
        Arrays.sort(result);
        assertEquals(
                Arrays.toString(expected),
                Arrays.toString(result)
        );
    }

    @Test
    public void test_003() {
        int[] expected = new int[]{0,1};
        int[] result = TwoSums.execute(new int[] {3,3}, 6);
        Arrays.sort(result);
        assertEquals(
                Arrays.toString(expected),
                Arrays.toString(result)
        );
    }
}
