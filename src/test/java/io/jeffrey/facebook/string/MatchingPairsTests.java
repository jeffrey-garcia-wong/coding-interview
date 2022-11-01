package io.jeffrey.facebook.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatchingPairsTests {

    @Test
    public void test_001() {
        String s = "abcd";
        String t = "adcb";
        assertEquals(4, MatchingPairs.execute(s, t));
    }

    @Test
    public void test_002() {
        String s = "mno";
        String t = "mno";
        assertEquals(1, MatchingPairs.execute(s, t));
    }

    @Test
    public void test_003() {
        String s = "a";
        String t = "a";
        assertEquals(1, MatchingPairs.execute(s, t));
    }

    @Test
    public void test_004() {
        String s = "a";
        String t = "b";
        assertEquals(0, MatchingPairs.execute(s, t));
    }

    @Test
    public void test_005() {
        String s = "";
        String t = "";
        assertEquals(0, MatchingPairs.execute(s, t));
    }

    @Test
    public void test_006() {
        String s = "ab";
        String t = "ac";
        assertEquals(0, MatchingPairs.execute(s, t));
    }

    @Test
    public void test_007() {
        String s = "abcde";
        String t = "adcbe";
        assertEquals(5, MatchingPairs.execute(s, t));
    }

    @Test
    public void test_008() {
        String s = "abcd";
        String t = "abcd";
        assertEquals(2, MatchingPairs.execute(s, t));
    }

}
