package io.jeffrey.leetcode.recursion;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.fail;

class SubsetsTests {

    private void check(List<List<Integer>> powersets, Set<String> resultSet) {
        if (powersets.size() != resultSet.size())
            fail("power sets un-match");

        for (List<Integer> permutation : powersets) {
            if (!resultSet.contains(permutation.toString())) {
                fail("power sets: " + permutation.toString() + " not found");
                break;
            }
            resultSet.remove(permutation.toString());
        }

        if (resultSet.size() > 0) fail("incomplete power sets");
    }


    @Test
    public void test_001() {
        int[] input = {1};
        Set<String> resultSet = new HashSet<>();
        resultSet.add("[1]");
        resultSet.add("[]");

        List<List<Integer>> powerSets = Subsets.execute(input);
        check(powerSets, resultSet);
    }

    @Test
    public void test_002() {
        int[] input = {1,2};
        Set<String> resultSet = new HashSet<>();
        resultSet.add("[1, 2]");
        resultSet.add("[1]");
        resultSet.add("[2]");
        resultSet.add("[]");

        List<List<Integer>> powerSets = Subsets.execute(input);
        check(powerSets, resultSet);
    }

    @Test
    public void test_003() {
        int[] input = {1,2,3};
        Set<String> resultSet = new HashSet<>();
        resultSet.add("[1, 2, 3]");
        resultSet.add("[1, 2]");
        resultSet.add("[1, 3]");
        resultSet.add("[1]");
        resultSet.add("[2, 3]");
        resultSet.add("[2]");
        resultSet.add("[3]");
        resultSet.add("[]");

        List<List<Integer>> powerSets = Subsets.execute(input);
        check(powerSets, resultSet);
    }

}
