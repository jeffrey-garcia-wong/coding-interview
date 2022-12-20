package io.jeffrey.interviewcake;

import java.util.Arrays;

/**
 * <h1>Missing Integer</h1>
 *
 * Find the smallest positive integer that does not occur
 * in a given sequence.<p/>
 *
 * Write a function:
 * <pre>
 * {@code
 * class Solution { public int solution(int[] A); }
 * }
 * </pre>
 * that, given an array A of N integers, returns the smallest
 * positive integer (greater than 0) that does not occur in A.<p/>
 *
 * For example, given A = [1, 3, 6, 4, 1, 2], the function
 * should return 5.
 * <ul>
 *     <li>Given A = [1, 2, 3], the function should return 4.</li>
 *     <li>Given A = [−1, −3], the function should return 1.</li>
 * </ul>
 *
 * Write an efficient algorithm for the following assumptions:
 * <ul>
 *     <li>N is an integer within the range [1..100,000];</li>
 *     <li>each element of array A is an integer within the range
 *     [−1,000,000..1,000,000].</li>
 * </ul>
 *
 */
public class MissingInteger {

    public static int execute(int[] A) {
        return solutionV1(A);
    }

    private static int solutionV1(int[] A) {
        /* Design the algorithm here
         *
         * With a sorted array, when we iterate through the elements
         * it can be certain that the element being seen is always
         * larger than the previous elements. Start with a min value
         * equal to 1 (requirement for min integer is 1), and for each
         * sorted element equals to the current min value, because it
         * is being seen in the array, so we incremented the min value
         * by 1, if its no longer seen after the iteration is finished,
         * we can safely assume this min value is the smallest possible
         * integer to return.
         *
         * Space complexity: O(1)
         * Time complexity: O(N Log(N)) + Log(N)
         */

        // Write the code here
        Arrays.sort(A);
        int min = 1;
        for (int i:A) {
            if (i == min) min += 1;
        }
        return min;
    }

}
