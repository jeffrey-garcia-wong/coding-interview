package com.jeffrey.facebook;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassingYearbooksTests {

    @Test
    public void test_001() {
        int[] student = {2, 1};
        int[] result = PassingYearbooks.execute(student);
        assertEquals(Arrays.toString(new int[]{2,2}), Arrays.toString(result));
    }

    @Test
    public void test_002() {
        int[] student = {1, 2};
        int[] result = PassingYearbooks.execute(student);
        assertEquals(Arrays.toString(new int[]{1,1}), Arrays.toString(result));
    }
}
