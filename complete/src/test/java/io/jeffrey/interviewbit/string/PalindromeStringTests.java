package io.jeffrey.interviewbit.string;

import io.jeffrey.interviewbit.string.PalindromeString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromeStringTests {

    @Test
    public void test_001() {
        String s = "A man, a plan, a canal: Panama";
        assertEquals(1, PalindromeString.execute(s));
    }

    @Test
    public void test_002() {
        String s = "race a car";
        assertEquals(0, PalindromeString.execute(s));
    }

    @Test
    public void test_003() {
        String s = "1a2";
        assertEquals(0, PalindromeString.execute(s));
    }

    @Test
    public void test_004() {
        String s = "\"\"\"";
        assertEquals(0, PalindromeString.execute(s));
    }

    @Test
    public void test_005() {
        String s = "A man, a plan, a canal: Panama\"";
        assertEquals(1, PalindromeString.execute(s));
    }

    @Test
    public void test_006() {
        String s = "A";
        assertEquals(1, PalindromeString.execute(s));
    }

    @Test
    public void test_007() {
        String s = "1abba2";
        assertEquals(0, PalindromeString.execute(s));
    }
}
