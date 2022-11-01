package io.jeffrey.hackkerank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SparseArraysTests {

    @Test
    public void test_001() {
        List<String> input = Arrays.asList("aba", "baba", "aba", "xzxb");
        List<String> queries = Arrays.asList("aba", "xzxb", "ab");

        List<Integer> result = SparseArrays.execute(input, queries);
        assertEquals("[2, 1, 0]", result.toString());
    }

}
