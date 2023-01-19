package io.jeffrey.core.sortings;

public class SelectionSort {

    public static int[] execute(int[] input) {
        return solutionV1(input);
    }

    private static int[] solutionV1(int[] input) {
        /* Design the algorithm here
         * [Strategy]
         * Scan the minimal element from the input
         * array and swap it with the element in
         * the left-most position. Repeat this process
         * and swap the element with the next element
         * from the last sorted position. The sort
         * will be finished when all the elements
         * are sorted.
         *
         * [Implementation]
         * 1) iterate the input array in an outer loop, for each
         *    element at position i
         * 2) iterate the input array in an inner loop starting
         *    from position i+1, and for each element at position
         *    j
         * 3) compare the element at i and j and if the element
         *    at j is smaller, update the current minimal value
         *    and index
         * 4) the minimal value is finalised whenever the inner
         *    loop is fully iterated, swap the minimal value
         *    with the value at position i
         * 5) back to the outer loop and continue the iteration
         */

        // write the code here
        int[] output = input;
        for (int i=0; i<output.length; i++) {
            int minPos = i;
            int minVal = output[minPos];
            for (int j=i+1; j<output.length; j++) {
                if (output[j] < minVal) {
                    minPos = j;
                    minVal = output[minPos];
                }
            }
            // swap
            int backupVal = output[i];
            output[i] = minVal;
            output[minPos] = backupVal;
        }
        return output;
    }

}
