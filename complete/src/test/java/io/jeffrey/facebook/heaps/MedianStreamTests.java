package io.jeffrey.facebook.heaps;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static io.jeffrey.facebook.heaps.MedianStream.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianStreamTests {

    @Test
    public void test_001() {
        int[] arr = {5, 15, 1, 3};
        int[] output = {5, 10, 5, 4};
        assertEquals(Arrays.toString(output), Arrays.toString(execute(arr)));
    }

    @Test
    public void test_002() {
        int[] arr = {2, 4, 7, 1, 5, 3};
        int[] output = {2, 3, 4, 3, 4, 3};
        assertEquals(Arrays.toString(output), Arrays.toString(execute(arr)));
    }

}
