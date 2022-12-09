package io.jeffrey.interviewcake;

import org.junit.jupiter.api.Test;

import static io.jeffrey.interviewcake.BinaryGap.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryGapTests {

    @Test
    public void test_001() {
        assertEquals(5, execute(1041));
    }

    @Test
    public void test_002() {
        assertEquals(0, execute(15));
    }

    @Test
    public void test_003() {
        assertEquals(0, execute(1));
    }

    @Test
    public void test_004() {
        assertEquals(0, execute(Integer.MAX_VALUE));
    }

    @Test
    public void test_005() {
        assertEquals(2, execute(328));
    }

}
