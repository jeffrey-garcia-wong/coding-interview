package io.jeffrey.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>Two Sums</h1><p/>
 *
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add
 * up to target.<p/>
 *
 * You may assume that each input would have exactly one
 * solution, and you may not use the same element twice.<p/>
 *
 * You can return the answer in any order.<p/>
 *
 * <b>Example 1</b><br/>
 * <pre>
 * {@code
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * }
 * </pre>
 *
 * <b>Example 2:</b><br/>
 * <pre>
 * {@code
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * }
 * </pre>
 *
 * <b>Example 3:</b><br/>
 * <pre>
 * {@code
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * }
 * </pre>
 *
 * <b>Constraints:</b><br/>
 * <ul>
 *      <li>2 <= nums.length <= 104</li>
 *      <li>109 <= nums[i] <= 109</li>
 *      <li>109 <= target <= 109</li>
 *      <li>Only one valid answer exists.</li>
 * </ul>
 *
 */
class TwoSums {

    static int[] execute(int[] nums, int target) {
        return solutionV1(nums, target);
    }

    private static int[] solutionV1(int[] nums, int target) {
        // Design the algorithm
        /*
         * Run through the entire array and store every
         * element with its position index into a map. For
         * each iteration, search for the compliments value
         * from the map, if it exists return the positions
         * of both the current element position and the
         * compliment position.
         */

        // Write the code here
        int[] result = {0,0};

        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int comp = target - nums[i];

            if (map.containsKey(comp)) {
                int j = map.get(comp);
                result[0] = i;
                result[1] = j;
                break;
            }

            map.put(nums[i], i);
        }

        return result;
    }
}
