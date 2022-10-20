package com.jeffrey.hackkerank.arrays;

import com.jeffrey.hackkerank.arrays.Java1dArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Java1dArrayTests {

    @Test
    public void test_001() {
        assertTrue(Java1dArray.execute(3, new int []{0,0,0,0,0}));
    }

    @Test
    public void test_002() {
        assertTrue(Java1dArray.execute(5, new int []{0,0,0,1,1,1}));
    }

    @Test
    public void test_003() {
        assertFalse(Java1dArray.execute(3, new int []{0,0,1,1,1,0}));
    }

    @Test
    public void test_004() {
        assertFalse(Java1dArray.execute(1, new int []{0,1,0}));
    }
}
