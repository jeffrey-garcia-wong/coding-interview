package io.jeffrey.facebook.heap;

import java.util.PriorityQueue;
import java.util.Queue;

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
         * with the current item only, the time complexity is O(N).
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
