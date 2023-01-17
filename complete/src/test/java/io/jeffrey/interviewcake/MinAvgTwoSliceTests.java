package io.jeffrey.interviewcake;

import org.junit.jupiter.api.Test;

import static io.jeffrey.interviewcake.MinAvgTwoSlice.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinAvgTwoSliceTests {

    @Test
    public void test_001() {
        assertEquals(0, execute(new int[] {1,2,3}));
    }

    @Test
    public void test_002() {
        assertEquals(1, execute(new int[] {-2,1,-10}));
    }

    @Test
    public void test_003() {
        assertEquals(0, execute(new int[] {-2,1,-2}));
    }

    @Test
    public void test_004() {
        assertEquals(1, execute(new int[] {4,2,1,10}));
    }

    @Test
    public void test_005() {
        assertEquals(2, execute(new int[] {-1,1,-1,-2}));
    }

    @Test
    public void test_006() {
        assertEquals(2, execute(new int[] {-1,0,-1,-1}));
    }

    @Test
    public void test_007() {
        assertEquals(1, execute(new int[] {4,2,2,5,1,5,8}));
    }

    @Test
    public void test_008() {
        assertEquals(2, execute(new int[] {-3,-5,-8,-4,-10}));
    }

}
