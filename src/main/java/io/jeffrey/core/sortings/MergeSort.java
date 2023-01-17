package io.jeffrey.core.sortings;

public class MergeSort {

    public static void execute(int[] input) {
        solutionV1(input, 0, input.length-1, new int[input.length]);
    }

    private static void solutionV1(int[] input, int leftStart, int rightEnd, int[] result) {
        // base case when the sub-array is reduced to 1 element
        if (leftStart >= rightEnd) return;

        // find the mid point to split the source array
        int middlePos = ((rightEnd - leftStart) >> 1) + leftStart;

        // sort the left sub-array
        solutionV1(input, leftStart, middlePos, result);
        // sort the right sub-array
        solutionV1(input, middlePos+1, rightEnd, result);

        // merge the sub-array into the result array
        merge(input, leftStart, rightEnd, result);
    }

    private static void merge(int[] input, final int leftStart, final int rightEnd, int[] result) {
        // identify the end index of left sub-array
        final int leftEnd = ((rightEnd - leftStart) >> 1) + leftStart;
        // identify the right index of right sub-array
        final int rightStart = leftEnd + 1;
        // identify the size of both left and right sub-array
        final int size = rightEnd - leftStart + 1;

        // additional pointers
        int left = leftStart; // for tracking the traversal of left sub-arrays
        int right = rightStart; // for tracking the traversal of right sub-arrays
        int index = leftStart; // for tracking the end position in the original array when traversal finished

        // compare elements in left and right sub-arrays
        while (left <= leftEnd && right <= rightEnd) {
            if (input[left] <= input[right]) {
                result[index] = input[left];
                left++;
            } else {
                result[index] = input[right];
                right++;
            }
            index++;
        }

        // copy remaining elements (if any) from left sub-array to result array
        System.arraycopy(input, left, result, index, leftEnd - (left - 1));

        // copy remaining elements (if any) from right sub-array to result array
        System.arraycopy(input, right, result, index, rightEnd - (right - 1));

        // copy merged elements back to original array
        System.arraycopy(result, leftStart, input, leftStart, size);
    }
}
