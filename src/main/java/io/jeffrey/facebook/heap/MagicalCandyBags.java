package io.jeffrey.facebook.heap;

import java.util.Collections;
import java.util.PriorityQueue;

class MagicalCandyBags {

    static int execute(int[] arr, int k) {
        return solutionV1(arr, k);
    }

    private static int solutionV1(int[] arr, int k) {
        // Design the algorithm here
        /*
         * The strategy is to take use of a max heap, initialise
         * the heap with all the values in array, such that the max
         * element can always be retrieved quickly.
         *
         * Then for each minute in K, we keep on polling the max
         * element from the heap (so each minute we are aiming for
         * the maximum number of candies), then add back the half
         * of the max element into the heap.
         *
         * Since the add and poll operations requires Log(N) time
         * complexity, the total time is O(N Log(N) + 2K Log(N)),
         * by ignoring the constant term, the overall time complexity
         * is O(N Log(N), while the max heap size is equivalent to N,
         * the space complexity is O(N).
         */

        // Write your code here
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int j:arr) {
            maxHeap.offer(j);
        }

        int output = 0;
        for (int i=1; i<=k; i++) {
            int max = maxHeap.poll();
            output += max;
            int half = (int)Math.floor((double)max/2);
            maxHeap.offer(half);
        }

        return output;
    }
}
