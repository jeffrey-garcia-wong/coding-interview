package io.jeffrey.facebook.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EncryptedWordsTests {

    @Test
    public void test_001() {
        String input = "abc";
        Assertions.assertEquals("bac", EncryptedWords.execute(input));
    }

    @Test
    public void test_002() {
        String input = "abcd";
        assertEquals("bacd", EncryptedWords.execute(input));
    }

    @Test
    public void test_003() {
        String input = "abcxcba";
        assertEquals("xbacbca", EncryptedWords.execute(input));
    }

    @Test
    public void test_004() {
        String input = "facebook";
        assertEquals("eafcobok", EncryptedWords.execute(input));
    }

    @Test
    public void test_005() {
        String input = "";
        EncryptedWords.execute(input);
    }

}
