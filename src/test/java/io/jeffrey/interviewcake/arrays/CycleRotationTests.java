package io.jeffrey.interviewcake.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static io.jeffrey.interviewcake.arrays.CycleRotation.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CycleRotationTests {

    @Test
    public void test_001() {
        int[] input = new int[] {3, 8, 9, 7, 6};
        assertEquals(
            Arrays.toString(new int[] {9, 7, 6, 3, 8}),
            Arrays.toString(execute(input, 3))
        );
    }

    @Test
    public void test_002() {
        int[] input = new int[] {0, 0, 0};
        assertEquals(
                Arrays.toString(new int[] {0, 0, 0}),
                Arrays.toString(execute(input, 1))
        );
    }

    @Test
    public void test_003() {
        int[] input = new int[] {1, 2, 3, 4};
        assertEquals(
                Arrays.toString(new int[] {1, 2, 3, 4}),
                Arrays.toString(execute(input, 4))
        );
    }

    @Test
    public void test_004() {
        int[] input = new int[] {1, 2, 3, 4};
        assertEquals(
                Arrays.toString(new int[] {2, 3, 4, 1}),
                Arrays.toString(execute(input, 11))
        );
    }

    @Test
    public void test_005() {
        int[] input = new int[] {1, 2, 3, 4};
        assertEquals(
                Arrays.toString(new int[] {3, 4, 1, 2}),
                Arrays.toString(execute(input, 10))
        );
    }

    @Test
    public void test_006() {
        int[] input = new int[] {-1, -2, -3, -4, -5, -6};
        assertEquals(
                Arrays.toString(new int[] {-3, -4, -5, -6, -1, -2}),
                Arrays.toString(execute(input, 10))
        );
    }

}
