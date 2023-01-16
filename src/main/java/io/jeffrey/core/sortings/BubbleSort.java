package io.jeffrey.core.sortings;

public class BubbleSort {

    public static int[] execute(int[] input) {
        return solutionV1(input);
    }

    private static int[] solutionV1(int[] input) {
        /*
         * Design the algorithm here
         */

        // Write the code here
        boolean hasSwapped;
        do {
            hasSwapped = false;
            for (int i=0; i<input.length-1; i++) {
                if (input[i+1] < input[i]) {
                    hasSwapped = true;
                    int tmp = input[i];
                    input[i] = input[i+1];
                    input[i+1] = tmp;
                }
            }
        } while (hasSwapped);

        return input;
    }

}
