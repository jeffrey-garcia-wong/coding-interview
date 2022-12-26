package io.jeffrey.interviewcake;

/**
 * <h1>MinAvgTwoSlice</h1>
 *
 * Find the minimal average of any slice containing at least two elements.<p/>
 *
 * A non-empty array A consisting of N integers is given. A pair of integers
 * (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that
 * the slice contains at least two elements). The average of a slice (P, Q)
 * is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the
 * slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) /
 * (Q − P + 1).<p/>
 *
 * For example, array A such that:
 * <pre>
 * {@code
 *     A[0] = 4
 *     A[1] = 2
 *     A[2] = 2
 *     A[3] = 5
 *     A[4] = 1
 *     A[5] = 5
 *     A[6] = 8
 * }
 * </pre>
 * contains the following example slices:
 * <ul>
 *     <li>slice (1, 2), whose average is (2 + 2) / 2 = 2;</li>
 *     <li>slice (3, 4), whose average is (5 + 1) / 2 = 3;</li>
 *     <li>slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.</li>
 * </ul>
 *
 * The goal is to find the starting position of a slice whose average is minimal.
 * Write a function:
 * <pre>
 * {@code
 *      class Solution { public int solution(int[] A); }
 * }
 * </pre>
 * that, given a non-empty array A consisting of N integers, returns
 * the starting position of the slice with the minimal average. If
 * there is more than one slice with a minimal average, you should
 * return the smallest starting position of such a slice.<p/>
 *
 * For example, given array A such that:
 * <pre>
 * {@code
 *     A[0] = 4
 *     A[1] = 2
 *     A[2] = 2
 *     A[3] = 5
 *     A[4] = 1
 *     A[5] = 5
 *     A[6] = 8
 * }
 * </pre>
 * the function should return 1, as explained above.<p/>
 *
 * Write an efficient algorithm for the following assumptions:
 * <ul>
 *     <li>N is an integer within the range [2..100,000];</li>
 *     <li>each element of array A is an integer within the range [−10,000..10,000].</li>
 * </ul>
 */
public class MinAvgTwoSlice {

    public static int execute(int[] A) {
        /*
         * Loop through the array from index-1 position till the end,
         * compute the average for each element encountered and find
         * the minimal average value for any sub-array.
         *
         * Requirements:
         * - sub-array size must be at least 2
         * - if multiple sub-arrays exist with the same minimal average,
         *   return position of the first sub-array encountered
         *
         * The algorithm is best illustrated by going through
         * the examples below.
         *
         * Example 1, if the input array is [1,2,3]:
         * =============================================
         * - at index 0:
         *   - skip because there is only 1 element insufficient
         *     to make a sub-array of size 2 for computing the min average
         * - at index 1:
         *   - the first sub-array is [1,2] average to 1.5,
         *     this is the minimal average seen so far
         *   - the starting position of the minimal sub-array
         *     is updated to 0
         * - at index 2:
         *   - the sub-array [2,3] average to 2.5, the value is
         *     larger than the last seen minimal average
         *   - the sub-array [1,2,3] average to 2, the value is
         *     larger than the last seen minimal average
         *   - the sub-array [1,2] constitutes the minimal average,
         *     and the position of its first element (0) is returned
         *
         * Example 2, if the input array is [-2,1,-10]:
         * =============================================
         * - at index 0:
         *   - skip because there is only 1 element insufficient
         *     to make a sub-array of size 2 for computing the min average
         * - at index 1:
         *   - the first sub-array is [-2,1] average to -0.5,
         *     this is the minimal average seen so far
         *   - the starting position of the minimal sub-array
         *     is updated to 0
         * - at index 2:
         *   - the sub-array [1,-10] average to -4.5,
         *     this is the minimal average seen so far
         *   - the starting position of the minimal sub-array
         *     is updated to 1
         *   - the sub-array [-2,1,-10] average to -3.66, the value
         *     is larger than the last seen minimal average
         *   - the sub-array [1,-10] constitutes the minimal average,
         *     and the position of its first element (1) is returned
         *
         * Example 3, if the input array is [-2,1,-2]:
         * =============================================
         * - at index 0:
         *   - skip because there is only 1 element insufficient
         *     to make a sub-array of size 2 for computing the min average
         * - at index 1:
         *   - the first sub-array is [-2,1] average to -0.5,
         *     this is the minimal average seen so far
         *   - the starting position of the minimal sub-array
         *     is updated to 0
         * - at index 2:
         *   - the sub-array [1,-2] average to -0.5, the value
         *     is equal to the last seen minimal average
         *   - the sub-array [-2,1,-2] average to -1,
         *     this is the minimal average seen so far
         *   - the sub-array [-2,1,-2] constitutes the minimal average,
         *     and the position of its first element (0) is returned
         *
         * Example 4: if the input array is [4,2,1,10]
         * =============================================
         * - at index 0:
         *   skip because there is only 1 element insufficient
         *   to make a sub-array of size 2 for computing the min average
         * - at index 1:
         *   - the first sub-array is [4,2] average to 3,
         *     this is the minimal average seen so far
         *   - the starting position of the minimal sub-array
         *     is updated to 0
         * -at index 2:
         *   - the sub-array [2,1] average to 0.5,
         *     this is the minimal average seen so far
         *   - the starting position of the minimal sub-array
         *     is updated to 1
         *   - the sub-array [4,2,1] average to 2.33, the value
         *     is larger than the last seen minimal average
         * - at index 3:
         *   - the sub-array [1,10] average to 5.5, the value
         *     is larger than the last seen minimal average
         *   - the sub-array [2,1,10] average to 4.33, the value
         *     is larger than the last seen minimal average
         *   - the sub-array [2,1] constitutes the minimal average,
         *     and the position of its first element (1) is returned
         *
         * Example 5: if the input array is [-1,1,-1,-2]
         * =============================================
         * - at index 0:
         *   skip because there is only 1 element insufficient
         *   to make a sub-array of size 2 for computing the min average
         * - at index 1:
         *   - the first sub-array is [-1,1] average to 0,
         *     this is the minimal average seen so far
         *   - the starting position of the minimal sub-array
         *     is updated to 0
         * - at index 2:
         *   - the sub-array [1,-1] average to 0, the value
         *     is equal to the last seen minimal average
         *   - the sub-array [-1,1,-1] average to -0.33,
         *     this is the minimal average seen so far
         *   - the starting position of the minimal sub-array
         *     is updated to 0
         * - at index 3:
         *   - the sub-array [-1,-2] average to -1.5,
         *     this is the minimal average seen so far
         *   - the starting position of the minimal sub-array
         *     is updated to 2
         *   - the sub-array [1,-1,-2] average to -0.66, the value
         *     is larger than the last seen minimal average
         *   - the sub-array [-1,-2] constitutes the minimal average,
         *     and the position of its first element (2) is returned
         *
         * Example 6: if the input array is [-1,0,-1,-1]
         * =============================================
         * - at index 0:
         *   skip because there is only 1 element insufficient
         *   to make a sub-array of size 2 for computing the min average
         * - at index 1:
         *   - the first sub-array is [-1,0] average to -0.5,
         *     this is the minimal average seen so far
         *   - the starting position of the minimal sub-array
         *     is updated to 0
         * - at index 2:
         *   - the sub-array [0,-1] average to -0.5, the value
         *     is equal to the last seen minimal average
         *   - the sub-array [-1,0,-1] average to -0.66,
         *     this is the minimal average seen so far
         *   - the starting position of the minimal sub-array
         *     is updated to 0
         * - at index 3:
         *   - the sub-array [-1,-1] average to -1.0,
         *     this is the minimal average seen so far
         *   - the starting position of the minimal sub-array
         *     is updated to 2
         *   - the sub-array [-1,0,-1,-1] average -0.75, the value
         *     is larger than the last seen minimal average
         *   - the sub-array [-1,-1] constitutes the minimal average,
         *     and the position of its first element (2) is returned
         *
         * Time complexity: O(N)
         * Space complexity: O(1)
         */
        // Design the algorithm here

        // write the code here
        int globalMinAvgStartIdx = 0;
        int localMinAvgStartIdx = 0;
        double globalMinAvg = 0;
        int localMin = A[0];

        // start at index-1 since element at index-0 alone
        // doesn't make a pair
        for (int i=1; i<A.length; i++) {
            int currMin = A[i] + A[i-1];
            double currMinAvg = (double) currMin / 2;
            double localMinAvg = (double) (localMin + A[i]) / (i - localMinAvgStartIdx + 1);

            if (currMinAvg < localMinAvg) {
                // reset local min if current min is even smaller
                localMin = currMin;
                localMinAvg = currMinAvg;
                localMinAvgStartIdx = i-1;
            } else {
                // increment local min with current element
                // if the local min avg still holds
                localMin += A[i];
            }

            // initialise global min avg to local min avg
            // only when first pair comes up
            if (i==1) globalMinAvg = localMinAvg;

            // reset global min avg and start index with the
            // local min avg and start index if its smaller
            if (localMinAvg < globalMinAvg) {
                globalMinAvg = localMinAvg;
                globalMinAvgStartIdx = localMinAvgStartIdx;
            }
        }

        return globalMinAvgStartIdx;
    }

}
