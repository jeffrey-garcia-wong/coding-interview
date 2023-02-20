package io.jeffrey.leetcode.graphs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static io.jeffrey.leetcode.graphs.WordLadder.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordLadderTests {

    @Test
    public void test_001() {
        List<String> words = Arrays.asList("hot","dot","dog","lot","log","cog");
        String beginWord = "hit";
        String endWord = "cog";
        assertEquals(5, execute(beginWord, endWord, words));
    }

    @Test
    public void test_002() {
        List<String> words = Arrays.asList("hot","dot","dog","lot","log");
        String beginWord = "hit";
        String endWord = "cog";
        assertEquals(0, execute(beginWord, endWord, words));
    }

    @Test
    public void test_003() {
        List<String> words = Arrays.asList("hot","dog","dot");
        String beginWord = "hot";
        String endWord = "dog";
        assertEquals(3, execute(beginWord, endWord, words));
    }

}
