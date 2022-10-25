package com.jeffrey.leetcode.recursion;

import java.util.LinkedList;
import java.util.List;

/**
 * <h1>Subsets</h1><p/>
 *
 * Given an integer array nums of unique elements, return all
 * possible subsets (the power set).<p/>
 *
 * The solution set must not contain duplicate subsets. Return
 * the solution in any order.<p/>
 *
 * <b>Example 1:</b><br/>
 * <pre>
 * {@code
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * }
 * </pre>
 *
 * <b>Example 2:</b><br/>
 * <pre>
 * {@code
 * Input: nums = [0]
 * Output: [[],[0]]
 * }
 * </pre>
 *
 * <b>Constraints:</b><br/>
 * <ul>
 *     <li>1 <= nums.length <= 10</li>
 *     <li>-10 <= nums[i] <= 10</li>
 *     <li>All the numbers of nums are unique.</li>
 * </ul>
 */
class Subsets {

    static List<List<Integer>> execute(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        solutionV1(nums, list, 0, new Integer[nums.length]);
        return list;
    }

    static void solutionV1(int[] input, List<List<Integer>> list, int count, Integer[] output) {
        // Design the algorithm here
        /*
         * The input array [1,2,3] will possess the following
         * power sets:
         * [1,2,3]
         * [1,2]
         * [1,3]
         * [1]
         * [2,3]
         * [2]
         * [3]
         * []
         *
         * Number of power sets always equals to 2^N. This
         * means we need a minimal of 2^N seeks in order to
         * generate all power sets.
         *
         * The seek of power sets for [1,2,3] is illustrated below:
         *
         *         |---3
         *     |---2
         *     |   |---*
         * |---1
         * |   |   |---3
         * |   |---*
         * |       |---*
         * |
         * |       |---3
         * |   |---2
         * |   |   |---*
         * |---*
         *     |   |---3
         *     |---*
         *         |---*
         *
         * The idea is to visit each element in the array, and after
         * scanning the element, we also scan [] since "empty" is
         * also considered as a set. Which means whenever we scan an
         * element, the scan path will further diverge into 2 paths:
         * N+1 and [], this process repeats until all the elements in
         * the array has been visited.
         *
         * As soon as all elements are scanned, we go back to 1-level
         * up where the
         *
         * For example if input array contains only 1, the search path
         * will diverge to 1 and [], and since there is no more element
         * after the scan of 1, the search will stop and go back to
         * 1-level up where the scan diverge, and proceed to scan []
         * along with any element remaining in the array. This process
         * will be exhausted when we return to the top layer where all
         * the elements in the input array has been visited.
         *
         * By the time we finish, all the power sets of the input array
         * should have been generated.
         */

        // Write the code here
        if (input.length - count == 0) {
            List<Integer> powerSet = new LinkedList<>();
            for (int i=0; i<output.length; i++) {
                if (output[i] != null) {
                    powerSet.add(output[i]);
                }
            }
            list.add(powerSet);
            return;
        }
        output[count] = input[count];
        solutionV1(input, list, count+1, output);
        output[count] = null;
        solutionV1(input, list, count+1, output);
    }
}
