package io.jeffrey.leetcode.hashtables;

import org.junit.jupiter.api.Test;

import static io.jeffrey.leetcode.hashtables.MaxSumOfPair.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxSumOfPairTests {

    @Test
    public void test_001() {
        assertEquals(54, execute(new int[] {18,43,36,13,7}));
    }

    @Test
    public void test_002() {
        assertEquals(-1, execute(new int[] {10,12,19,14}));
    }

}
