package io.jeffrey.core.sortings;

public class Quicksort {

    public static void execute(int [] input) {
        solutionV1(input, 0, input.length-1);
    }

    private static void solutionV1(int[] input, int start, int end) {
        // base case of recursion, stop when the sub-array has
        // only 1 element and we have nothing to sort
        if (start >= end) return;

        // pick the mid as pivot
        int pivotVal = input[((end - start) >> 1) + start];

        // move everything smaller than pivot to left, and
        // everything bigger than pivot to right
        // return the position of split
        int splitIndex = partition(input, pivotVal, start, end);

        // split the input array into 2 sub-arrays and continue sorting
        solutionV1(input, start, splitIndex-1);
        solutionV1(input, splitIndex, end);
    }

    private static int partition(int[] input, int pivotVal, int start, int end) {
        while (start <= end) {
            // shift the left pointer (towards right) until it finds an element NOT smaller than the pivot value
            while (input[start] < pivotVal) start++;
            // shift the right pointer (towards left) until it finds an element NOT bigger than the pivot value
            while (input[end] > pivotVal) end--;

            // swap the elements referenced by left and right pointers
            if (start <= end) {
                int tmp = input[start];
                input[start] = input[end];
                input[end] = tmp;
                start ++;
                end --;
            }
        }

        return start;
    }
}
