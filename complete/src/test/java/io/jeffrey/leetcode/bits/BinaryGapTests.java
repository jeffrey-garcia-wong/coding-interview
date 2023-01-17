package io.jeffrey.leetcode.bits;

import org.junit.jupiter.api.Test;

import static io.jeffrey.leetcode.bits.BinaryGap.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryGapTests {

    @Test
    public void test_001() {
        assertEquals(0, execute(0));
    }

    @Test
    public void test_002() {
        assertEquals(0, execute(2));
    }

    @Test
    public void test_003() {
        assertEquals(0, execute(4));
    }

    @Test
    public void test_004() {
        assertEquals(0, execute(8)); // 1000
    }

    @Test
    public void test_005() {
        assertEquals(1, execute(7)); // 111
    }

    @Test
    public void test_006() {
        assertEquals(1, execute(6)); // 110
    }

    @Test
    public void test_007() {
        assertEquals(2, execute(5));
    }

    @Test
    public void test_008() {
        assertEquals(2, execute(22));
    }

    @Test
    public void test_009() {
        assertEquals(2, execute(5)); // 101
    }

    @Test
    public void test_010() {
        assertEquals(3, execute(72)); // 1001000
    }
}
