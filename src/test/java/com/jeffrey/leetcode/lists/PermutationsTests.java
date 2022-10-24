package com.jeffrey.leetcode.lists;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.fail;

public class PermutationsTests {

    private void check(List<List<Integer>> permutations, Set<String> resultSet) {
        if (permutations.size() != resultSet.size())
            fail("permutations un-match");

        for (List<Integer> permutation : permutations) {
            if (!resultSet.contains(permutation.toString())) {
                fail("permutation: " + permutation.toString() + " not found");
                break;
            }
            resultSet.remove(permutation.toString());
        }

        if (resultSet.size() > 0) fail("incomplete permutations");
    }

    @Test
    public void test_001() {
        int[] input = {};
        Set<String> resultSet = new HashSet<>();
        resultSet.add("[]");

        List<List<Integer>> permutations = Permutations.execute(input);
        check(permutations, resultSet);
    }

    @Test
    public void test_002() {
        int[] input = {1};
        Set<String> resultSet = new HashSet<>();
        resultSet.add("[1]");

        List<List<Integer>> permutations = Permutations.execute(input);
        check(permutations, resultSet);
    }

    @Test
    public void test_003() {
        int[] input = {1,2};
        Set<String> resultSet = new HashSet<>();
        resultSet.add("[1, 2]");
        resultSet.add("[2, 1]");

        List<List<Integer>> permutations = Permutations.execute(input);
        check(permutations, resultSet);
    }

    @Test
    public void test_004() {
        int[] input = {1,2,3};
        Set<String> resultSet = new HashSet<>();
        resultSet.add("[1, 2, 3]");
        resultSet.add("[1, 3, 2]");
        resultSet.add("[2, 1, 3]");
        resultSet.add("[2, 3, 1]");
        resultSet.add("[3, 1, 2]");
        resultSet.add("[3, 2, 1]");

        List<List<Integer>> permutations = Permutations.execute(input);
        check(permutations, resultSet);
    }

    @Test
    public void test_005() {
        int[] input = {1,2,3,4};
        Set<String> resultSet = new HashSet<>();
        resultSet.add("[1, 2, 3, 4]");
        resultSet.add("[1, 2, 4, 3]");
        resultSet.add("[1, 3, 2, 4]");
        resultSet.add("[1, 3, 4, 2]");
        resultSet.add("[1, 4, 2, 3]");
        resultSet.add("[1, 4, 3, 2]");
        resultSet.add("[2, 1, 3, 4]");
        resultSet.add("[2, 1, 4, 3]");
        resultSet.add("[2, 3, 1, 4]");
        resultSet.add("[2, 3, 4, 1]");
        resultSet.add("[2, 4, 1, 3]");
        resultSet.add("[2, 4, 3, 1]");
        resultSet.add("[3, 1, 2, 4]");
        resultSet.add("[3, 1, 4, 2]");
        resultSet.add("[3, 2, 1, 4]");
        resultSet.add("[3, 2, 4, 1]");
        resultSet.add("[3, 4, 1, 2]");
        resultSet.add("[3, 4, 2, 1]");
        resultSet.add("[4, 1, 2, 3]");
        resultSet.add("[4, 1, 3, 2]");
        resultSet.add("[4, 2, 1, 3]");
        resultSet.add("[4, 2, 3, 1]");
        resultSet.add("[4, 3, 1, 2]");
        resultSet.add("[4, 3, 2, 1]");

        List<List<Integer>> permutations = Permutations.execute(input);
        check(permutations, resultSet);
    }
}
