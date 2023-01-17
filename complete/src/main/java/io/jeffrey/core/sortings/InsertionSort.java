package io.jeffrey.core.sortings;

public class InsertionSort {

    public static int[] execute(int[] input) {
        return solutionV1(input);
    }

    private static int[] solutionV1(int[] input) {
        /*
         * Design the algorithm here
         * 1) iterate through all the elements in the outer loop,
         *    and for each element at position i
         * 2) iterate through all the elements before position i to 0
         *    in the inner loop
         * 3) compare each element at j with element at j+1
         * 4) if the element at j+1 is smaller, swap it with the element at j
         * 5) otherwise, break the inner loop and continue the next iteration
         *    in step 1
         * 6) the process is exhausted when the iteration of the outer loop
         *    finish
         */

        // Write the code here
        for (int i=0; i<input.length; i++) {
            for (int j=i-1; j>=0; j--) {
                if (input[j] > input[j+1]) {
                    int backupVal = input[j+1];
                    input[j+1] = input[j];
                    input[j] = backupVal;
                } else
                    break;
            }
        }
        return input;
    }

}
