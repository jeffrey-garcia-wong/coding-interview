package com.jeffrey.facebook;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountAndSayTests {

    @Test
    public void test_001() {
        String output = CountAndSay.execute(1);
        assertEquals("1", output);
    }

    @Test
    public void test_002() {
        String output = CountAndSay.execute(2);
        assertEquals("11", output);
    }

    @Test
    public void test_003() {
        String output = CountAndSay.execute(3);
        assertEquals("21", output);
    }

    @Test
    public void test_004() {
        String output = CountAndSay.execute(4);
        assertEquals("1211", output);
    }

    @Test
    public void test_005() {
        String output = CountAndSay.execute(5);
        assertEquals("111221", output);
    }

    @Test
    public void test_006() {
        String output = CountAndSay.execute(6);
        assertEquals("312211", output);
    }

    @Test
    public void test_007() {
        String output = CountAndSay.execute(7);
        assertEquals("13112221", output);
    }

    @Test
    public void test_008() {
        String output = CountAndSay.execute(8);
        assertEquals("1113213211", output);
    }
}
