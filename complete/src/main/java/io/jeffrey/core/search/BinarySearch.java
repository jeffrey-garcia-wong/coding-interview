package io.jeffrey.core.search;

public class BinarySearch {

    public static int execute(int[] input, int target) {
        return solutionV1(input, target);
    }

    private static int solutionV1(int[] input, int target) {
        int start = 0;
        int end = input.length - 1;

        while (start <= end) {
            // NOTE safe to use and won't introduce overflow
            int middle = start + ((end - start) >> 1);

            // NOTE safe to use and resolve overflow using unsigned right shift
            //int middle = (start + end) >>> 1;

            // NOTE unsafe and may introduce overflow
            //int middle = (start + end) >> 1;

            if (target < input[middle]) {
                end = middle - 1;
            } else if (target > input[middle]) {
                start = middle + 1;
            } else {
                return middle;
            }
        }

        return -start - 1;
    }

}
