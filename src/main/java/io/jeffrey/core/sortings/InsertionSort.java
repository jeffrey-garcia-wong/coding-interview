package io.jeffrey.core.sortings;

public class InsertionSort {

    public static int[] execute(int[] input) {
        return solutionV1(input);
    }

    private static int[] solutionV1(int[] input) {
        int sortedSize = 0;
        // Write the code here
        for (int i=0; i<input.length; i++) {
            int tmp = input[i];
            int j = i - 1;
            while (j>=0 && tmp < input[j]) {
                input[j+1] = input[j];
                j -= 1;
            }
            input[j+1] = tmp;
        }
        return input;
    }

}
