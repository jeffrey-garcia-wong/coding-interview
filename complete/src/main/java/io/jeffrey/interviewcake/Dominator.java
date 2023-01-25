package io.jeffrey.interviewcake;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <h1>Dominator</h1>
 *
 * An array A consisting of N integers is given. The dominator of array A
 * is the value that occurs in more than half of the elements of A.<p/>
 *
 * For example, consider array A such that:
 * <pre>
 * {@code
 *  A[0] = 3    A[1] = 4    A[2] =  3
 *  A[3] = 2    A[4] = 3    A[5] = -1
 *  A[6] = 3    A[7] = 3
 * }
 * </pre>
 *
 * The dominator of A is 3 because it occurs in 5 out of 8 elements of A
 * (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half
 * of 8.<p/>
 *
 * Write a function:
 * <pre>
 * {@code
 * class Solution { public int solution(int[] A); }
 * }
 * </pre>
 * that, given an array A consisting of N integers, returns index of any
 * element of array A in which the dominator of A occurs. The function
 * should return −1 if array A does not have a dominator.<p/>
 *
 * For example, given array A such that:
 * <pre>
 * {@code
 *  A[0] = 3    A[1] = 4    A[2] =  3
 *  A[3] = 2    A[4] = 3    A[5] = -1
 *  A[6] = 3    A[7] = 3
 * }
 * </pre>
 * the function may return 0, 2, 4, 6 or 7, as explained above.<p/>
 *
 * Write an efficient algorithm for the following assumptions:
 * <ul>
 *     <li>N is an integer within the range [0..100,000];</li>
 *     <li>each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].</li>
 * </ul>
 *
 */
public class Dominator {

    public static int execute(int[] A) {
        return solutionV1(A);
    }

    private static class Result {
        int pos;
        int total;
        Result(int pos, int total) {
            this.pos = pos;
            this.total = total;
        }
    }
    public static int solutionV1(int[] A) {
        // Design the algorithm here
        /* 1. iterate through every element in the array
         * 2. for each element, keep a custom object which remember
         * the number of counts and its first seen position and
         * store the element (as key) and the custom object (as value)
         * into a hashtable
         * 3. loop through the keys of the hashtables and identify
         *    the key with the maximal count and from its associated
         *    value, retrieve the position and return it if the count
         *    exceed N/2, otherwise return -1
         *
         * Time complexity: O(N) where N is the total number of elements
         * Space complexity: O(M) where M is the number of distinct element
         * worst case space complexity M = N where all elements are distinct
         */

        // Implement your solution here
        Map<Integer, Result> map = new HashMap<>();
        for (int i=0; i<A.length; i++) {
            Result r = map.getOrDefault(A[i], new Result(i, 0));
            r.total += 1;
            map.put(A[i], r);
        }

        final int maxExpected = A.length >> 1;
        int maxTotal = 0;
        int maxPos = 0;
        Set<Integer> keyset = map.keySet();
        for (int i : keyset) {
            Result r = map.get(i);
            if (r.total > maxTotal) {
                maxTotal = r.total;
                maxPos = r.pos;
            }
        }

        return maxTotal>maxExpected ? maxPos : -1;
    }
}
