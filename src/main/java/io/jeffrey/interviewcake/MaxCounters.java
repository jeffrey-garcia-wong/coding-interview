package io.jeffrey.interviewcake;

import java.util.Arrays;

public class MaxCounters {

    public static int[] execute(int N, int[] A) {
        return solutionV2(N, A);
    }

    public static int[] solutionV2(int N, int [] A) {
        /* Design the algorithm here
         *
         * Optimize v1 to reduce the time complexity to O(N)
         *
         * The key difference is to eliminate redundant operation
         * which sets all elements in the output array to the
         * max counter value.
         *
         * To achieve this we need 2 counters:
         * - cumulative max counter, which increments whenever a
         *   new maximum counter value is discovered
         * - effective max counter, which is set to the cumulative
         *   max counter value whenever an element >= N+1 is seen
         *
         * For example if input is [3,4,4,6,1,4,4] and N=5:
         * ----------------------------------------------------------------------------
         * After iterating the 0 element (3<=N) in the input:
         * output = [0,0,1,0,0], effective max counter = 0, cumulative max counter = 1
         *
         * After iterating the 1st element (4<=N) in the input:
         * output = [0,0,1,1,0], effective max counter = 0, cumulative max counter = 1
         *
         * After iterating the 2nd element (4<=N) in the input:
         * output = [0,0,1,2,0], effective max counter = 0, cumulative max counter = 2
         *
         * After iterating the 3rd element (6>=N+1) in the input:
         * output = [0,0,1,2,0], effective max counter = 2, cumulative max counter = 2
         *
         * After iterating the 4th element (1<=N) in the input:
         * output = [3,0,1,2,0], effective max counter = 2, cumulative max counter = 3
         *
         * After iterating the 5th element (4<=N) in the input:
         * output = [3,0,1,3,0], effective max counter = 2, cumulative max counter = 3
         *
         * After iterating the 6th element (4<=N) in the input:
         * output = [3,0,1,4,0], effective max counter = 2, cumulative max counter = 4
         * ----------------------------------------------------------------------------
         *
         * Once the iteration of the input array has finished, iterate
         * the output array, if any of the counter value is less than
         * the effective max counter, simply reset it to the effective
         * max counter.
         * ----------------------------------------------------------------------------
         * output = [3,2,2,4,2], effective max counter = 2, cumulative max counter = 4
         * ----------------------------------------------------------------------------
         *
         * Space complexity remains unchanged: O(N)
         * Time complexity improved: O(M) + O(N)
         */

        // Write the code here
        int effectiveMaxCounter = 0;
        int cumulativeMaxCounter = 0;
        int [] output = new int[N];

        for (int i=0; i<A.length; i++) {
            if (A[i] <= N) {
                if (output[A[i]-1] < effectiveMaxCounter) output[A[i]-1] = effectiveMaxCounter;
                output[A[i]-1] += 1;
                cumulativeMaxCounter = Math.max(output[A[i]-1], cumulativeMaxCounter);
            } else if (A[i] == N + 1) {
                effectiveMaxCounter = cumulativeMaxCounter;
            }
        }

        for (int j=0; j<output.length; j++) {
            if (output[j] < effectiveMaxCounter) {
                output[j] = effectiveMaxCounter;
            }
        }

        return output;
    }

    public static int[] solutionV1(int N, int [] A) {
        /* Design the algorithm here
         *
         * First initialize the output counter's array of size N
         * with all elements initialized to 0.
         *
         * Then iterate through all the elements in the input array,
         * whenever the element is <= N, increment the corresponding
         * counter's value in the output array by 1, we also need to
         * keep track of the current maximum's counter value, such
         * than when element == N+1 is encountered from the input
         * array, all the counters in the output array can be set
         * to the maximum's counter value.
         *
         * Resetting all counters in the output array is an O(N)
         * operation.
         *
         * Space complexity: O(N)
         * Time complexity: O(M) * O(N)
         */

        // Write the code here
        int currMax = 0;
        int [] output = new int[N];

        for (int i=0; i<A.length; i++) {
            if (A[i] <= N) {
                output[A[i]-1] += 1;
                currMax = Math.max(currMax, output[A[i]-1]);
            } else if (A[i] == N+1) {
                // this incurs performance penalty of O(N)
                Arrays.fill(output, currMax);
            }
        }

        return output;
    }

}
