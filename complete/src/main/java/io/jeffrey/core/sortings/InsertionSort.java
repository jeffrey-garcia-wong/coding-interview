package io.jeffrey.core.sortings;

public class InsertionSort {

    public static int[] execute(int[] input) {
        return solutionV1(input);
    }

    private static int[] solutionV1(int[] input) {
        /*
         * Design the algorithm here:
         *
         * [Strategy]
         * For each element in the input array, compare it
         * with the elements before it, keep swapping it
         * with bigger elements until it is pushed towards
         * its leftmost position where the element before
         * it is less than or equal to it.
         * Keep doing this until the iteration is over and
         * all the elements in the array should be sorted in
         * ascending order.
         *
         * [Implementation]
         * 1) iterate through all the elements in an outer loop,
         *    and for each element at position i
         * 2) iterate through all the elements from position i to 0
         *    in the inner loop
         * 3) compare each element at j with element at j+1
         * 4) if the element at j+1 is smaller, swap it with the element at j
         * 5) otherwise, break the inner loop and continue the next iteration
         *    in step 1
         * 6) the process is exhausted when the iteration of the outer loop
         *    finish
         */

        // Write the code here
        int[] output = input;
        for (int i=0; i<output.length; i++) {
            for (int j=i-1; j>=0; j--) {
                if (output[j] > output[j+1]) {
                    int backupVal = output[j+1];
                    output[j+1] = output[j];
                    output[j] = backupVal;
                } else
                    break;
            }
        }
        return output;
    }

}
