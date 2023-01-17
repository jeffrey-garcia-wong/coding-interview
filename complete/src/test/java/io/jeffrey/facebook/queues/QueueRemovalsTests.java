package io.jeffrey.facebook.queues;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueRemovalsTests {

    @Test
    public void test_001() {
        int[] arr = {};
        int x = 10;
        assertEquals(Arrays.toString(new int [] {}), Arrays.toString(QueueRemovals.execute(arr, x)));
    }

    @Test
    public void test_002() {
        int[] arr = {2, 9, 6};
        int x = 5;
        int[] expected = {2, 3, 1};
        assertEquals(Arrays.toString(expected), Arrays.toString(QueueRemovals.execute(arr, x)));
    }

    @Test
    public void test_003() {
        int[] arr = {1, 2, 2, 3, 4, 5};
        int x = 5;
        int[] expected = {5, 6, 4, 1, 2};
        assertEquals(Arrays.toString(expected), Arrays.toString(QueueRemovals.execute(arr, x)));
    }

    @Test
    public void test_004() {
        int[] arr = {2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4};
        int x = 4;
        int[] expected = {2, 5, 10, 13};
        assertEquals(Arrays.toString(expected), Arrays.toString(QueueRemovals.execute(arr, x)));
    }
}
