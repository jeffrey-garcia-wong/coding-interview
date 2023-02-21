package io.jeffrey.facebook.heaps;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <h1>Largest Triple Products</h1><p/>
 *
 * You're given a list of n integers arr[0..(n-1)]. You must compute a list
 * output[0..(n-1)] such that, for each index i (between 0 and n-1, inclusive),
 * output[i] is equal to the product of the three largest elements out of
 * arr[0..i] (or equal to -1 if i < 2, as arr[0..i] then includes fewer than
 * three elements).<br/>
 *
 * Note that the three largest elements used to form any product may have the
 * same values as one another, but they must be at different indices in arr.<br/>
 *
 * <b>Input</b><br/>
 * <pre>
 * {@code
 * n is in the range [1, 100,000].
 * Each value arr[i] is in the range [1, 1,000].
 * }
 * </pre>
 *
 * <b>Output</b><br/>
 * <pre>
 * {@code
 * Return a list of n integers output[0..(n-1)], as described above.
 * }
 * </pre>
 *
 * <b>Example 1</b><br/>
 * <pre>
 * {@code
 * n = 5
 * arr = [1, 2, 3, 4, 5]
 * output = [-1, -1, 6, 24, 60]
 * The 3rd element of output is 3*2*1 = 6, the 4th is 4*3*2 = 24, and the 5th is 5*4*3 = 60.
 * }
 * </pre>
 *
 * <b>Example 2</b><br/>
 * <pre>
 * {@code
 * n = 5
 * arr = [2, 1, 2, 1, 2]
 * output = [-1, -1, 4, 4, 8]
 * The 3rd element of output is 2*2*1 = 4, the 4th is 2*2*1 = 4, and the 5th is 2*2*2 = 8.
 * }
 * </pre>
 */
class LargestTripleProducts {

    static int[] execute(int[] arr) {
        return solutionV1(arr);
    }

    private static int[] solutionV1(int [] arr) {
        // Design the algorithm here
        /*
         * Use a heap to keep the 3 biggest elements recently seen
         * in the array, as we iterate through the array, compare
         * current element with the first item polled from the heap,
         * if current element is bigger, pop the first time from the
         * heap and add the current element into the heap, this way
         * the items stored in the heap is guaranteed to be 3 since
         * the first 2 elements in the array are always added into
         * the heap, and we can also ensure the 3 items stored in
         * are the biggest being seen in the array.
         *
         * To calculate the product for the current element, we don't
         * need to pop the 3 elements from heap and re-calculate each
         * time, instead we simply store the previous product (P), and if
         * the current element (Y) should replace the least item in the
         * heap (X), we re-compute the P by (P / X * Y).
         *
         * In this way the space complexity is kept as O(1) since the
         * heap would only store at most 3 items in any time, while
         * we iterate the through the array and re-compute product
         * with the current item only, and each iteration involves
         * peek, poll, offer operations which cost 3Log(N) time
         * complexity, the total time cost is N * 3 Log(N), ignoring
         * the constant term the overall time complexity is O(N Log(N)).
         */

        // Write the code here
        int[] output = new int[arr.length];
        Queue<Integer> minHeap = new PriorityQueue<>();
        int product = 1;

        for (int i=0; i<arr.length; i++) {
            if (i<=2) {
                minHeap.offer(arr[i]);
                product *= arr[i];
                output[i] = i<=1? -1 : product;
            } else {
                int min = minHeap.peek();
                if (arr[i] > min) {
                    minHeap.poll();
                    minHeap.offer(arr[i]);
                    product = product / min * arr[i];
                    output[i] = product;
                } else {
                    output[i] = product;
                }
            }
        }

        return output;
    }
}
