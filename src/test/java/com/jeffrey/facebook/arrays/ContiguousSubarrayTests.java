package com.jeffrey.facebook.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContiguousSubarrayTests {

    @Test
    public void test_001() {
        assertEquals(
            Arrays.toString(new int[] {1,3,1,5,1}),
            Arrays.toString(ContiguousSubarrays.execute(new int[] {3,4,1,6,2}))
        );
    }

    @Test
    public void test_002() {
        assertEquals(
            Arrays.toString(new int[] {1,2,6,1,3,1}),
            Arrays.toString(ContiguousSubarrays.execute(new int[] {2,4,7,1,5,3}))
        );
    }

    @Test
    public void test_003() {
        assertEquals(
            Arrays.toString(new int[] {1,4,2,1,5}),
            Arrays.toString(ContiguousSubarrays.execute(new int[] {2,5,4,3,9}))
        );
    }
}
