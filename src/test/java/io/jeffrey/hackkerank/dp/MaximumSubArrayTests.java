package io.jeffrey.hackkerank.dp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static io.jeffrey.hackkerank.dp.MaximumSubArray.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumSubArrayTests {

    @Test
    public void test_001() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4);
        List<Integer> output = execute(input);
        assertEquals(Arrays.asList(10, 10).toString(), output.toString());
    }

    @Test
    public void test_002() {
        List<Integer> input = Arrays.asList(-1, 2, 3, -4, 5, 10);
        List<Integer> output = execute(input);
        assertEquals(Arrays.asList(16, 20).toString(), output.toString());
    }

    @Test
    public void test_003() {
        List<Integer> input = Arrays.asList(2, -1, 2, 3, 4, -5);
        List<Integer> output = execute(input);
        assertEquals(Arrays.asList(10, 11).toString(), output.toString());
    }

    @Test
    public void test_004() {
        List<Integer> input = Arrays.asList(-2, -3, -1, -4, -6);
        List<Integer> output = execute(input);
        assertEquals(Arrays.asList(-1, -1).toString(), output.toString());
    }

    @Test
    public void test_005() {
        List<Integer> input = Arrays.asList(-1, -99, 0, 100);
        List<Integer> output = execute(input);
        assertEquals(Arrays.asList(100, 100).toString(), output.toString());
    }
}
