package io.jeffrey.core.sortings;

public class SelectionSort {

    public static int[] execute(int[] input) {
        return solutonV1(input);
    }

    private static int[] solutonV1(int[] input) {
        for (int i=0; i<input.length; i++) {
            int minPos = i;
            int minVal = input[minPos];
            for (int j=i+1; j<input.length; j++) {
                if (input[j] < minVal) {
                    minPos = j;
                    minVal = input[minPos];
                }
            }
            // swap
            int backupVal = input[i];
            input[i] = input[minPos];
            input[minPos] = backupVal;
        }
        return input;
    }

}
