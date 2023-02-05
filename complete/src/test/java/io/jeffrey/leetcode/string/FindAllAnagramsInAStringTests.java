package io.jeffrey.leetcode.string;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static io.jeffrey.leetcode.string.FindAllAnagramsInAString.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindAllAnagramsInAStringTests {

    @Test
    public void simple_input() {
        String s = "abab";
        String p = "ab";
        List<Integer> expected = Arrays.asList(0, 1, 2);
        assertEquals(expected, execute(s, p));
    }

    @Test
    public void short_input() {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> expected = Arrays.asList(0, 6);
        assertEquals(expected, execute(s, p));
    }

}
