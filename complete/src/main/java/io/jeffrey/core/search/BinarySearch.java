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

        /* Return the insertion point when target not found
         *
         * At the last element to compare before the while-loop
         * exhausted, start must be equal to middle. There are
         * 2 possible outcomes:
         * a) if the target is smaller, the insertion point is
         *    simply before the element at position middle (middle - 1)
         * b) if the target is larger, the insertion point is
         *    simply after the element at position middle (middle + 1)
         *
         * For case (a), if middle = 0, the insertion slot should happen
         * at position 0, but any non-negative return value would imply
         * the target can be found, so instead of returning 0, we return
         * 0-1=-1 instead.
         *
         * For case (b), if middle = 1, the insertion slot should happen at
         * position 2 (after the elements at position 0 and 1), however returning
         * -2 is wrong since -2 actually imply the insertion slot before the
         * element at position 1, see case (a). Imagine there is a 3rd element
         * exist at position 2 of the input array, the insertion slot of the
         * target should be before the element at position 2, we return -3
         * instead.
         *
         * For example, the sorted input array is [5, 7, 9]
         * 5 -> 7 -> 9
         * when target = 4, search result return -1
         * when target = 6, search result return -2
         * when target = 8, search result return -3
         * when target = 10, search result return -4
         *
         * For case (a), start = middle, therefore if middle is 0, start = 0, simply return
         * -start - 1
         * For case (b), start = middle + 1, therefore if middle is 2, start = 3, simply return
         * -start - 1
         */
        return -start - 1; //
    }

}
