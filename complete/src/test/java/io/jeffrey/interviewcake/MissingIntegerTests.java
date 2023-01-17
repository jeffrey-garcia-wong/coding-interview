package io.jeffrey.interviewcake;

import org.junit.jupiter.api.Test;

import static io.jeffrey.interviewcake.MissingInteger.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MissingIntegerTests {

    @Test
    public void test_001() {
        assertEquals(5, execute(new int[] {1,3,6,4,1,2}));
    }

    @Test
    public void test_002() {
        assertEquals(4, execute(new int[] {1,2,3}));
    }

    @Test
    public void test_003() {
        assertEquals(1, execute(new int[] {-1,-3}));
    }

}
