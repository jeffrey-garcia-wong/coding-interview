package io.jeffrey.core.sortings;

import java.util.concurrent.Callable;

public class QuickSort {

    public static void execute(int [] input) {
        solutionV2(input, 0, input.length-1);
    }

    private static void solutionV2(int[] input, int start, int end) {
        if (start >= end) return;

        // improved partition algorithm to reason
        Callable<Integer> partition = (() -> {
            int pivot = input[end];
            int low = start - 1;
            for (int high=start; high<=end-1; high++) {
                if (input[high] < pivot) {
                    low++;
                    // if element is smaller than pivot, swap it into the low range
                    int backup = input[low];
                    input[low] = input[high];
                    input[high] = backup;
                }
            }

            // everything smaller than pivot will be within start to low
            // everything greater than pivot will be within low + 1 to end

            // low must be referencing the last element in the low range sub-array
            // move the pivot to the border between low and high
            int backup = input[end];
            input[end] = input[low+1];
            input[low+1] = backup;

            // return the location of the pivot
            return low+1;
        });

        try {
            Integer splitIndex = partition.call();
            // repeat the process for the element in the lower range and higher range but excluding pivot
            // avoid sorting sub-array with the pivot because pivot is already at its rightful place
            solutionV2(input, start, splitIndex - 1);
            solutionV2(input, splitIndex + 1, end);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void solutionV1(int[] input, int start, int end) {
        // base case of recursion, stop when the sub-array has
        // only 1 element and we have nothing to sort
        if (start >= end) return;

        Callable<Integer> partition = (() -> {
            int left = start;
            int right = end;

            // pick the mid as pivot
            int pivotVal = input[((right - left) >> 1) + left];

            while (left <= right) {
                // shift the left pointer (towards right) until it finds an element NOT smaller than the pivot value
                while (input[left] < pivotVal) left++;
                // shift the right pointer (towards left) until it finds an element NOT bigger than the pivot value
                while (input[right] > pivotVal) right--;

                // swap the elements referenced by left and right pointers
                if (left <= right) {
                    int tmp = input[left];
                    input[left] = input[right];
                    input[right] = tmp;
                    left ++;
                    right --;
                }
            }

            // TODO: why return left instead of right?
            return left;
        });

        try {
            // move everything smaller than pivot to left, and
            // everything bigger than pivot to right
            // return the position of split
            int splitIndex = partition.call();

            // split the input array into 2 sub-arrays and continue sorting
            solutionV1(input, start, splitIndex-1);
            solutionV1(input, splitIndex, end);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
