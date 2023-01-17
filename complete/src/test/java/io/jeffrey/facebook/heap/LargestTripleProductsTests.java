package io.jeffrey.facebook.heap;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static io.jeffrey.facebook.heap.LargestTripleProducts.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargestTripleProductsTests {

    @Test
    public void test_001() {
        int[] arr = {};
        int[] expectedOutput = {};
        assertEquals(
                Arrays.toString(expectedOutput),
                Arrays.toString(execute(arr))
        );
    }

    @Test
    public void test_002() {
        int[] arr = {1, 2};
        int[] expectedOutput = {-1, -1};
        assertEquals(
                Arrays.toString(expectedOutput),
                Arrays.toString(execute(arr))
        );
    }

    @Test
    public void test_003() {
        int[] arr = {0, 0, 0};
        int[] expectedOutput = {-1, -1, 0};
        assertEquals(
                Arrays.toString(expectedOutput),
                Arrays.toString(execute(arr))
        );
    }

    @Test
    public void test_004() {
        int[] arr = {1, 1, 1, 1, 1};
        int[] expectedOutput = {-1, -1, 1, 1, 1};
        assertEquals(
                Arrays.toString(expectedOutput),
                Arrays.toString(execute(arr))
        );
    }

    @Test
    public void test_005() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expectedOutput = {-1, -1, 6, 24, 60};
        assertEquals(
                Arrays.toString(expectedOutput),
                Arrays.toString(execute(arr))
        );
    }

    @Test
    public void test_006() {
        int[] arr = {2, 1, 2, 1, 2};
        int[] expectedOutput = {-1, -1, 4, 4, 8};
        assertEquals(
                Arrays.toString(expectedOutput),
                Arrays.toString(execute(arr))
        );
    }
}
