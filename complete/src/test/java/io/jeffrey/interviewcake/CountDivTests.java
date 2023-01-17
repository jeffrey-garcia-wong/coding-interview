package io.jeffrey.interviewcake;

import org.junit.jupiter.api.Test;

import static io.jeffrey.interviewcake.CountDiv.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountDivTests {

    @Test
    public void test_000() {
        assertEquals(4, execute(6,12,2));
    }

    @Test
    public void test_001() {
        assertEquals(3, execute(7,12,2));
    }

    @Test
    public void test_002() {
        assertEquals(20, execute(11,345,17));
    }

    @Test
    public void test_003() {
        assertEquals(1, execute(0,1,11));
    }

    @Test
    public void test_004() {
        assertEquals(0, execute(10,10,20));
    }

    @Test
    public void test_005() {
        assertEquals(2, execute(0,10,7));
    }

    @Test
    public void test_006() {
        assertEquals(12345, execute(101,123456000,10000));
    }
}
