package com.jeffrey.leetcode.recursion;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.fail;

public class CombinationSumTests {

    private void check(List<List<Integer>> combinations, Set<String> resultSet) {
        if (combinations.size() != resultSet.size())
            fail("combinations un-match");

        for (List<Integer> combination : combinations) {
            if (!resultSet.contains(combination.toString())) {
                fail("power sets: " + combination.toString() + " not found");
                break;
            }
            resultSet.remove(combination.toString());
        }

        if (resultSet.size() > 0) fail("incomplete power sets");
    }

    @Test
    public void test_001() {
        int[] input = {2, 3, 6, 7};
        Set<String> resultSet = new HashSet<>();
        resultSet.add("[7]");
        resultSet.add("[2, 2, 3]");

        List<List<Integer>> combinations = CombinationSum.execute(input, 7);
        check(combinations, resultSet);
    }

    @Test
    public void test_002() {
        int[] input = {2, 3, 5};
        Set<String> resultSet = new HashSet<>();
        resultSet.add("[2, 3, 3]");
        resultSet.add("[2, 2, 2, 2]");
        resultSet.add("[3, 5]");

        List<List<Integer>> combinations = CombinationSum.execute(input, 8);
        check(combinations, resultSet);
    }
}
