package com.jeffrey.leetcode.recursion;

import java.util.*;

/**
 * <h1>Subsets II</h1><p/>
 *
 * Given an integer array nums that may contain duplicates,
 * return all possible subsets (the power set).<p/>
 *
 * The solution set must not contain duplicate subsets.
 * Return the solution in any order.<p/>
 *
 * <b>Example 1:</b><br/>
 * <pre>
 * {@code
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * }
 * </pre>
 *
 * <b>Example 2:</b>
 * <pre>
 * {@code
 * Input: nums = [0]
 * Output: [[],[0]]
 * }
 * </pre>
 *
 * <b>Constraints:</b><br/>
 * <pre>
 * {@code
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * }
 * </pre>
 */
class SubsetsII {

    static List<List<Integer>> execute(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        solutionV1(nums, nums.length, 0, new int[nums.length], map);

        Set<String> keySet = map.keySet();
        for (String key:keySet) {
            List<Integer>value = map.get(key);
            // System.out.print(key + " -> ");
            // System.out.println(value);
            list.add(value);
        }
        return list;
    }

    static void solutionV1(int[] input, int SIZE, int count, int[] output, Map<String, List<Integer>> map) {
        if (SIZE-count == 0) {
            int[] sortedOutput = Arrays.copyOf(output, output.length);
            Arrays.sort(sortedOutput);
            String key = Arrays.toString(sortedOutput);

            if (!map.containsKey(key)) {
                List<Integer> value = new LinkedList<>();
                for (int i=0; i<output.length; i++) {
                    if (output[i] != 99) {
                        value.add(output[i]);
                    }
                }

                // System.out.print(key);
                // System.out.print(" -> ");
                // System.out.println(value);

                map.put(key, value);
            }
            return;
        }
        output[count] = input[count];
        solutionV1(input, SIZE, count+1, output, map);
        output[count] = 99;
        solutionV1(input, SIZE, count+1, output, map);
    }

}
