package com.jeffrey.leetcode.lists;

import java.util.LinkedList;
import java.util.List;

/**
 * <h1>Permutations</h1><p/>
 *
 * Given an array nums of distinct integers, return all the possible
 * permutations. You can return the answer in any order.<p/>
 *
 * <b>Example 1:</b><br/>
 * <pre>
 * {@code
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * }
 * </pre>
 *
 * <b>Example 2:</b><br/>
 * <pre>
 * {@code
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * }
 * </pre>
 *
 * <b>Example 3:</b><br/>
 * <pre>
 * {@code
 * Input: nums = [1]
 * Output: [[1]]
 * }
 * </pre>
 *
 * <b>Constraints:</b>
 * <ul>
 *     <li>1 <= nums.length <= 6</li>
 *     <li>-10 <= nums[i] <= 10</li>
 *     <li>All the integers of nums are unique.</li>
 * </ul>
 */
class Permutations {

    static List<List<Integer>> execute(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        solutionV1(nums, nums.length, list, new int[nums.length]);
        return list;
    }

    private static void solutionV1(int[] input, int SIZE, List<List<Integer>> list, int[] output) {
        // Design the algorithm here
        /*
         * The input array [1,2,3] will possess the following
         * permutations:
         * [1,2,3]
         * [1,3,2]
         * [2,1,3]
         * [2,3,1]
         * [3,1,2]
         * [3,2,1]
         *
         * Number of permutations always equals to the Factorial
         * of N. This means we need a minimal of N! seeks in order
         * to generate all possible permutations.
         *
         * The seek of all permutations for [1,2,3] is illustrated below:
         * |---1             sub-array [2,3]
         * |   |---2         sub-array [3]
         * |   |   |---3     sub-array []
         * |   |
         * |   |---3         sub-array [2]
         * |       |---2     sub-array []
         * |
         * |---2             sub-array [1,3]
         * |   |---1         sub-array [3]
         * |   |   |---3     sub-array []
         * |   |
         * |   |---3         sub-array [1]
         * |   |   |---1     sub-array []
         * |
         * |---3             sub-array [1,2]
         *     |---1         sub-array [2]
         *     |   |---2     sub-array []
         *     |
         *     |---2         sub-array [1]
         *         |---1     sub-array []
         *
         * The idea is to loop through every element of the input array,
         * for each iteration, we extract the first element in the array,
         * then construct a sub-array with all the elements except the
         * current element, this reduces the sub-array to size N-1. We
         * then repeat the same process against the current element and
         * the sub-array, until the sub-array size is reduced to zero.
         * Note that every first element extracted during the sub-array
         * reduction process will constitute to a permutation.
         *
         * As soon as the sub-array size is reduced to zero, we go back
         * to 1-level up where the iteration of the sub-array was interrupted
         * and continue with the next element of the sub-array. This process
         * will be exhausted when we return to the top layer where all the
         * elements in the input array has been iterated.
         *
         * By the time we finish, all the permutations of the input array
         * should have been generated.
         */

        // Write the code here
        if (input.length == 0) {
            List<Integer> permutation = new LinkedList<>();
            for (int i:output) {
                permutation.add(i);
            }
            list.add(permutation);
            return;
        }
        for (int i=0; i<input.length; i++) {
            /* This shrinking of the sub-array is most important
             * because it applies an even tighter boundary to
             * reduce the search space for each level down
             * in the recursive calls
             */
            int[] subarray = new int[input.length-1];
            for (int j=0; j<subarray.length; j++) {
                int pos = ((i+1)+j) % input.length;
                int curr = input[pos];
                subarray[j] = curr;
            }
            if (input.length == SIZE) {
                output = new int[input.length];
                output[SIZE-input.length] = input[i];
                solutionV1(subarray, SIZE, list, output);
            } else {
                output[SIZE-input.length] = input[i];
                solutionV1(subarray, SIZE, list, output);
            }
        }
    }
}
