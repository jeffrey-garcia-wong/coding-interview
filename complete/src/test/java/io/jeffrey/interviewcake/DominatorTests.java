package io.jeffrey.interviewcake;

import org.junit.jupiter.api.Test;

import static io.jeffrey.interviewcake.Dominator.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DominatorTests {

    @Test
    public void test_001() {
        int[] input = new int[] {0,1};
        assertEquals(-1, execute(input));
    }

    @Test
    public void test_002() {
        int[] input = new int[] {0,0,1,1};
        assertEquals(-1, execute(input));
    }

    @Test
    public void test_003() {
        int[] input = new int[] {0,0,1};
        assertEquals(0, execute(input));
    }

    @Test
    public void test_004() {
        int[] input = new int[] {0,1,1};
        assertEquals(1, execute(input));
    }

    @Test
    public void test_005() {
        int[] input = new int[] {3,4,3,2,3,1,3,3};
        assertEquals(0, execute(input));
    }
}
