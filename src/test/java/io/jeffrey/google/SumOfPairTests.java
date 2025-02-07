package io.jeffrey.google;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.jeffrey.google.SumOfPair.execute;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SumOfPairTests {

    @DisplayName("Positive Test - One pair found")
    @Test
    public void test001() {
        final int target = 9;
        final int[] input = new int[] {10, 5, 6, 7, 4, 1, 8};
        assertTrue(execute(input, target));
    }

    @DisplayName("Negative Test - No pair found")
    @Test
    public void test002() {
        final int target = 5;
        final int[] input = new int[] {-8, 56, 6, 7, 4, 99, 8};
        assertFalse(execute(input, target));
    }

    @DisplayName("Negative Test - Empty Input Array")
    @Test
    public void test003() {
        final int target = 10;
        final int[] input = new int[] {};
        assertFalse(execute(input, target));
    }

    @DisplayName("Positive Test - More than 1 pair found")
    @Test
    public void test004() {
        final int target = 10;
        final int[] input = new int[] {5, 9, 6, 5, 2, 9, 1};
        assertTrue(execute(input, target));
    }

    @DisplayName("Positive Test - Duplicated values in input array")
    @Test
    public void test005() {
        final int target = 10;
        final int[] input = new int[] {5, 5, 5, 5, 5, 5, 5, 5, 5};
        assertTrue(execute(input, target));
    }

    @DisplayName("Negative Test - Odd number of elements in input array")
    @Test
    public void test006() {
        final int target = 10;
        final int[] input = new int[] {9, 9, 7, 7, 5, 4, 4, 2, 2};
        assertFalse(execute(input, target));
    }

    @DisplayName("Negative Test - Even number of elements in input array")
    @Test
    public void test007() {
        final int target = 10;
        final int[] input = new int[] {9, 9, 7, 7, 5, 5, 4, 4, 2, 2};
        assertTrue(execute(input, target));
    }
}
