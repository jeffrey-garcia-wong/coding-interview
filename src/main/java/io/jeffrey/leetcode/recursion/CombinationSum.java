package io.jeffrey.leetcode.recursion;

import java.util.LinkedList;
import java.util.List;

/**
 * <h1>Combination Sum</h1><p/>
 *
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen
 * numbers sum to target. You may return the combinations in any order.<p/>
 *
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen
 * numbers is different.<p/>
 *
 * The test cases are generated such that the number of unique combinations
 * that sum up to target is less than 150 combinations for the given input.<p/>
 *
 * <b>Example 1:</b><br/>
 * <pre>
 * {@code
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * }
 * </pre>
 *
 * <b>Example 2:</b><br/>
 * <pre>
 * {@code
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * }
 * </pre>
 *
 * <b>Example 3:</b><br/>
 * <pre>
 * {@code
 * Input: candidates = [2], target = 1
 * Output: []
 * }
 * </pre>
 *
 * <b>Constraints:</b><br/>
 * <pre>
 * {@code
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * All elements of candidates are distinct.
 * 1 <= target <= 40
 * }
 * </pre>
 */
class CombinationSum {

    static List<List<Integer>> execute(int[] candidates, int target) {
        List<List<Integer>> output = new LinkedList<>();
        solutionV1(candidates, target, 0, new LinkedList<Integer>(), output);
        return output;
    }

    private static void solutionV1(int[] candidates, int target, int candidateIdx, List<Integer> list, List<List<Integer>> output) {
        // Design the algorithm here
        /*
        * This problem is basically the coin matching problem in Hackkerank.
        *
        * The only difference is instead of returning the match count, it
        * requires to return all the possible combinations, the easiest
        * way to implement it is to clone the current result then pass
        * it to the next level, this provides the convenience without
        * the dealing with reversing a previously added element which
        * results in exceeding the target value, since exiting the current
        * level and backtracking to the upper level will simply mean every
        * variable in the current scope being discarded, with no impact to
        * the variables at the upper level.
        */

        // Write the code here
        for (int i=candidateIdx; i<candidates.length; i++) {
            int remaining = target - candidates[i];

            if (remaining == 0) {
                List<Integer> newList = new LinkedList<>(list);
                newList.add(candidates[i]);
                output.add(newList);
            }
            if (remaining > 0) {
                List<Integer> newList = new LinkedList<>(list);
                newList.add(candidates[i]);
                solutionV1(candidates, remaining, i, newList, output);
            }
        }
    }

}
