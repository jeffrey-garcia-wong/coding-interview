package io.jeffrey.hackkerank.dp;

import java.util.Arrays;
import java.util.List;

/**
 * <h1>The Maximum Subarray</h1>
 *
 * We define subsequence as any subset of an array. We define a subarray
 * as a contiguous subsequence in an array.<p/>
 *
 * Given an array, find the maximum possible sum among:
 * <ul>
 *     <li>all nonempty subarrays.</li>
 *     <li>all nonempty subsequences.</li>
 * </ul>
 * Print the two values as space-separated integers on one line.<br/>
 * <b>Note</b> that empty subarrays/subsequences should not be considered.<p/>
 *
 * <b>Example</b>
 * <pre>
 * {@code
 * arr = [-1, 2, 3, -4, 5, 10]
 * }
 * </pre>
 * The maximum subarray sum is comprised of elements at inidices 1 to 5.
 * Their sum is 16. While the maximum subsequence sum is comprised of
 * elements at indices 1,2,4,5 and their sum is 20.<p/>
 *
 * <b>Constraints</b>
 * <ul>
 *     <li>1 < n < 10^5</li>
 *     <li>-10^4 < arr[i] < 10^4 </li>
 * </ul>
 * The subarray and subsequences you consider should have at least one element.<p/>
 *
 * <b>Sample 0</b>
 * <pre>
 * {@code
 * input = 1 2 3 4
 * output = 10 10
 * }
 * </pre>
 *
 * <b>Sample</b>
 * <pre>
 * {@code
 * input = 2 -1 2 3 4 -5
 * output = 10 11
 * }
 * </pre>
 *
 * <b>Sample</b>
 * <pre>
 * {@code
 * input = -2 -3 -1 -4 -6
 * output = -1 -1
 * }
 * </pre>
 */
class MaximumSubArray {

    static List<Integer> execute(List<Integer> arr) {
        return solutionV1(arr);
    }

    private static List<Integer> solutionV1(List<Integer> input) {
        /*
         * Aim for O(N) time complexity and iterate
         * through all the elements in one go.
         *
         * To achieve this at least 3 variables are
         * required,
         * 1) a global maxima which record the largest sum seen so far of the entire array
         * 2) a local maxima which record the largest sum seen so far in the sub-array
         * 3) a total which record the largest sum (without being continuous) seen so far
         *    of the entire array
         *
         * Loop through all the elements, initialise all the variables with the value
         * of the first element. As we progress to the remaining elements, for each
         * element check if adding it with the local maxima may produce a value smaller than
         * the current element, if yes then it means the local maxima must be smaller than
         * the current element and summing it with current element would produce a result
         * even smaller than the current element alone, we don't want that so we can safely
         * discard the value of the local maxima and simply set the new local maxima to the
         * current element. The last step before next iteration is to check whether the local
         * maxima is now greater than the global maxima and replace it.
         *
         * We don't need to consider the scenario where the sum will result in a new
         * local maxima smaller than the previous local maxima, in fact we may even encounter
         * values from the remaining elements which decrease the local maxima, but that's not
         * a problem since the last known maximum value is already remembered in the global
         * maxima. The last step in each iteration which compares the local maxima and global
         * maxima will safeguard that the true maximum value is kept properly.
         *
         * So this is the steps for computing the maximum value for contiguous subarray. Now
         * to find the maximum value for all subsequences, the operation is similar with one
         * crucial difference, due to the fact that the sum doesn't need to happen with
         * continuous elements, whenever we compute the sum of total and current element, if
         * the sum may result in a new total which is smaller than the previous total or the
         * current element alone, we either skip the sum (keep the previous total) or replace
         * the total with the current element, whichever is larger. In this way as when we
         * process remaining elements in the array, the max total is always remembered for
         * the elements which are non-continuous.
         *
         */
        // Design the algorithm here

        // Write the code here
        int max = 0;
        int localMax = 0;
        int total = 0;

        for (int i=0; i<input.size(); i++) {
            int e = input.get(i);
            if (i==0) {
                // initialise
                max = e;
                localMax = e;
                total = e;

            } else {
                if (localMax+e < e) {
                    // local max must be smaller than e,
                    // forget previous local max and set new local max to e
                    localMax = e;
                } else {
                    localMax += e;
                }
                // check if the local max is the biggest we have ever seen
                max = Math.max(localMax, max);

                if (total+e < e || total +e < total) {
                    // the sum of total and e is smaller than
                    // total or e alone, we pick the largest
                    // of them and forget the smaller
                    total = Math.max(total, e);
                } else {
                    total += e;
                }
            }
        }
        return Arrays.asList(max, total);
    }
}
