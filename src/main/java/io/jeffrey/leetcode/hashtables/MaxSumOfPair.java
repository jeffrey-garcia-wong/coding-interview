package io.jeffrey.leetcode.hashtables;

import java.util.*;

/**
 * <h1>Max Sum of a Pair With Equal Sum of Digits</h1>
 *
 * You are given a 0-indexed array nums consisting of positive integers.
 * You can choose two indices i and j, such that i != j, and the sum of
 * digits of the number nums[i] is equal to that of nums[j].<p/>
 *
 * Return the maximum value of nums[i] + nums[j] that you can obtain over
 * all possible indices i and j that satisfy the conditions.<p/>
 *
 * <b>Example 1:</b>
 * <pre>
 * {@code
 * Input: nums = [18,43,36,13,7]
 * Output: 54
 * Explanation: The pairs (i, j) that satisfy the conditions are:
 * - (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
 * - (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
 * So the maximum sum that we can obtain is 54.
 * }
 * </pre>
 *
 * <b>Example 2:</b>
 * <pre>
 * {@code
 * Input: nums = [10,12,19,14]
 * Output: -1
 * Explanation: There are no two numbers that satisfy the conditions, so we return -1.
 * }
 * </pre>
 *
 * <b>Constraints:</b>
 * <ul>
 *     <li>1 <= nums.length <= 10^5</li>
 *     <li>1 <= nums[i] <= 10^9</li>
 * </ul>
 */
public class MaxSumOfPair {

    public static int execute(int[] nums) {
        return solutionV2(nums);
    }

    private static int solutionV2(int[] nums) {
        // Design the algorithm here
        /*
         * This is an optimized version of v1.
         *
         * Instead of maintaining a linked list of elements
         * (with same sum) in the map, this algorithm will
         * only store the largest element (of each sum) in
         * the map.
         *
         * Consider an example for the following
         * sub-array in the integer sequence:
         * [... 13 22 4 ...], the 3 integers in
         * the sub-array all possesses same digit
         * sum=4.
         * - when 13 is encountered, the map returns
         *   null for key=4, so 13 is inserted into the
         *   map
         * - when 22 is encountered, the map returns
         *   13 for key=4, and 13+22=35 becomes the new
         *   maximum value. Since 22 is larger than 13,
         *   22 replaced 13 as the value in the map when
         *   key=4
         * - when 4 is encountered, the map returns
         *   22 for key=4, and 4+22=26 which is less than
         *   current max value (35) therefore it doesn't
         *   replace the maximum value. 22 remains as the
         *   value to be returned by the map for key=4
         *
         * The Nlog(N) sort is avoided, and the additional
         * for-loop which iterates through the "map of linked
         * list" is also removed.
         *
         * Space complexity: O(N)
         * Time complexity: O(N)
         */

        // Write the code here
        Map<Integer, Integer> map = new HashMap<>();
        int max = -1;
        for (int i=0; i<nums.length; i++) {
            int key = getSumOfDigits(nums[i]);
            if (map.containsKey(key)) {
                int value = map.get(key);
                int newValue = value + nums[i];
                max = Math.max(max, newValue);
                map.put(key, Math.max(value, nums[i]));
            } else {
                map.put(key, nums[i]);
            }
        }
        return max;
    }

    private static int getSumOfDigits(int num) {
        if (num < 10) return num;
        int sum = 0;
        while (num >= 10) {
            sum += num % 10;
            num = num / 10;
        }
        return sum + num;
    }

    private static int solutionV1(int[] nums) {
        // Design the algorithm here
        /*
         * Sort the array in ascending order, and then
         * iterate through each element in the array,
         * compute the sum of digits and insert the value
         * into a map of double-ended queue (stack), where
         * the sum of digits is the key, and the element
         * itself inserted into the last position of the
         * double-ended queue.
         *
         * Since the elements are already sorted, the next
         * element (with same sum of digits) encountered
         * must be larger than the previous element(s) seen,
         * and is always appended into the last position of
         * the double-ended queue.
         *
         * Once the iteration is finished, all the elements
         * with the same sum of digits should be allocated
         * into the map. Another loop is required to iterate
         * through each key in the map, compute the last 2
         * elements in the double-ended queue, and evaluate
         * of maximality.
         *
         * Time complexity: O(Nlog(N)) + O(2N)
         * Space complexity: O(N)
         */

        // Write the code here
        Map<Integer, Deque<Integer>> map = new HashMap<>();
        Arrays.sort(nums);
        int max = -1;
        for (int i=0; i<nums.length; i++) {
            int sum = getSumOfDigits(nums[i]);
            Deque<Integer> queue = map.getOrDefault(sum, new LinkedList<Integer>());
            queue.addLast(nums[i]);
            map.put(sum, queue);
            // System.out.println("sum:" + sum + " " + queue.toString());
        }

        Set<Integer> keys = map.keySet();
        Iterator<Integer> iterator = keys.iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            Deque<Integer> queue = map.get(key);
            if (queue.size()>=2) {
                int last = queue.removeLast();
                int beforeLast = queue.removeLast();
                max = Math.max(max, (last + beforeLast));
            }
        }

        return max;
    }

}
