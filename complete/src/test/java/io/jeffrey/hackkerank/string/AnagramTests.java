package io.jeffrey.hackkerank.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnagramTests {

    @Test
    public void test_001() {
        Assertions.assertEquals(3, Anagram.execute("aaabbb"));
    }

    @Test
    public void test_002() {
        assertEquals(1, Anagram.execute("ab"));
    }

    @Test
    public void test_003() {
        assertEquals(-1, Anagram.execute("abc"));
    }

    @Test
    public void test_004() {
        assertEquals(2, Anagram.execute("mnop"));
    }

    @Test
    public void test_005() {
        assertEquals(0, Anagram.execute("xyyx"));
    }

    @Test
    public void test_006() {
        assertEquals(1, Anagram.execute("xaxbbbxx"));
    }
}
