package io.jeffrey.interviewcake.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * <h1>Odd Occurrence in Array</h1>
 *
 * A non-empty array A consisting of N integers is given. The array contains
 * an odd number of elements, and each element of the array can be paired
 * with another element that has the same value, except for one element
 * that is left unpaired.<p/>
 *
 * For example, in array A such that:
 * <pre>
 * {@code
 *   A[0] = 9  A[1] = 3  A[2] = 9
 *   A[3] = 3  A[4] = 9  A[5] = 7
 *   A[6] = 9
 * }
 * </pre>
 * the elements at indexes 0 and 2 have value 9,<br/>
 * the elements at indexes 1 and 3 have value 3,<br/>
 * the elements at indexes 4 and 6 have value 9,<br/>
 * the element at index 5 has value 7 and is unpaired.<p/>
 *
 * Write a function:
 * <pre>
 * {@code
 * class Solution { public int solution(int[] A); }
 * }
 * </pre>
 * that, given an array A consisting of N integers fulfilling the above conditions,
 * returns the value of the unpaired element.<p/>
 *
 * For example, given array A such that:
 * <pre>
 * {@code
 *   A[0] = 9  A[1] = 3  A[2] = 9
 *   A[3] = 3  A[4] = 9  A[5] = 7
 *   A[6] = 9
 * }
 * </pre>
 * the function should return 7, as explained in the example above.<p/>
 *
 * Write an efficient algorithm for the following assumptions:
 * <ul>
 *     <li>N is an odd integer within the range [1..1,000,000];</li>
 *     <li>each element of array A is an integer within the range [1..1,000,000,000];</li>
 *     <li>all but one of the values in A occur an even number of times.</li>
 * </ul>
 */
public class OddOccurrenceInArray {

    public static int execute(int[] A) {
        return solutionV1(A);
    }

    private static int solutionV1(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<A.length; i++) {
            if (set.contains(A[i])) {
                set.remove(A[i]);
            } else {
                set.add(A[i]);
            }
        }
        int result = set.iterator().next();
        return result;
    }
}
