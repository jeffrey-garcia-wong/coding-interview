package io.jeffrey.core.sortings;

import java.util.concurrent.Callable;

public class MergeSort {

    public static int[] execute(int[] input) {
        solutionV1(input, 0, input.length - 1, new int[input.length]);
        return input;
    }

    private static void solutionV1(int[] input, int start, int end, int[] output) {
        // base case when the sub-array is reduced to 1 element
        if ((end - start) < 1) return;

        // find the mid-point to partition the source array
        int splitIndex = start + (end - start)/2;

        Callable<Void> merge = (() -> {
            int leftStart = start;
            int leftEnd = splitIndex;
            int rightStart = splitIndex + 1;
            int rightEnd = end;

            // compare elements in left and right sub-arrays and
            // copy the sorted element into the temp output array
            int current = leftStart;
            while (leftStart <= leftEnd && rightStart <= rightEnd) {
                if (input[leftStart] < input[rightStart]) {
                    output[current] = input[leftStart];
                    leftStart += 1;
                } else {
                    output[current] = input[rightStart];
                    rightStart += 1;
                }
                current += 1;
            }

            // copy remaining elements (if any) from left sub-array to temp output array
            while (leftStart <= leftEnd) {
                output[current] = input[leftStart];
                leftStart += 1;
                current += 1;
            }

            // copy remaining elements (if any) from right sub-array to temp output array
            while (rightStart <= rightEnd) {
                output[current] = input[rightStart];
                rightStart += 1;
                current += 1;
            }

            // copy merge & sorted elements from temp output array back to input array
            for (int i=start; i<=end; i++) {
                input[i] = output[i];
            }

            return null;
        });

        // further partition the left sub-array
        solutionV1(input, start, splitIndex, output);
        // further partition the right sub-array
        solutionV1(input, splitIndex+1, end, output);
        try {
            // merge and sort the sub-arrays
            merge.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
