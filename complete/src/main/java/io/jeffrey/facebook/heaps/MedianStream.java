package io.jeffrey.facebook.heaps;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <b>Median Stream</b><p/>
 *
 * You're given a list of n integers arr[0..(n-1)]. You must compute a
 * list output[0..(n-1)] such that, for each index i (between 0 and n-1,
 * inclusive), output[i] is equal to the median of the elements arr[0..i]
 * (rounded down to the nearest integer).<p/>
 *
 * The median of a list of integers is defined as follows. If the integers
 * were to be sorted, then:
 * <ul>
 *     <li>If there are an odd number of integers, then the median is
 *     equal to the middle integer in the sorted order.</li>
 *     <li>Otherwise, if there are an even number of integers, then
 *     the median is equal to the average of the two middle-most integers
 *     in the sorted order.</li>
 * </ul>
 *
 * <b>Input</b><br/>
 * <pre>
 * {@code
 * n is in the range [1, 1,000,000].
 * Each value arr[i] is in the range [1, 1,000,000].
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
 * n = 4
 * arr = [5, 15, 1, 3]
 * output = [5, 10, 5, 4]
 * The median of [5] is 5,
 * the median of [5, 15] is (5 + 15) / 2 = 10,
 * the median of [5, 15, 1] is 5,
 * and the median of [5, 15, 1, 3] is (3 + 5) / 2 = 4.
 * }
 * </pre>
 *
 * <b>Example 2</b><br/>
 * <pre>
 * {@code
 * n = 2
 * arr = [1, 2]
 * output = [1, 1]
 * The median of [1] is 1,
 * the median of [1, 2] is (1 + 2) / 2 = 1.5 (which should be rounded down to 1).
 * }
 * </pre>
 */
class MedianStream {

    static int[] execute(int[] arr) {
        return solutionV2(arr);
    }

    private static int[] solutionV2(int [] arr) {
        // Design the algorithm here
        /*
         * To solve this problem we need to re-generate
         * a sorted array with the i-th element added
         * in every iteration, then use the index position
         * to retrieve the median, but clearly this would
         * incur N^2 running time which is not ideal.
         *
         * To optimize the time complexity, the sorting
         * in every iteration must be eliminated, with
         * the use of a min heap, the i-th element is
         * added to the heap in every iteration, polling
         * the elements from the heap will then produce
         * a sorted order which can be used to retrieve
         * the medians in each iteration, the challenge
         * is when the heap is big enough, we need to
         * keep polling at least half-size of the heap
         * before arriving at the medians, which still
         * consumes O(N^2) running time.
         *
         * To further optimize the time complexity, the
         * search for medians must be efficient enough,
         * the strategy is to use 2 heaps, one heap in
         * ascending and the other in descending order,
         * each of the heap will store half the elements
         * of input array, for example if the input is
         * [2, 4, 7, 1, 5, 3], then one of the heap
         * will store the lower half [1, 2, 3], while
         * the other will store higher half [4, 5, 7].
         *
         * Clearly to retrieve the median, with a heap
         * polling element is an O(1) operation, this
         * works fine for getting median in the heap
         * with higher half elements, but to retrieve
         * the median in the heap with lower half, the
         * heap must be in a reverse order [3, 2, 1]
         * such that the median can be retrieved in
         * a single poll operation.
         *
         * To evenly distribute the elements from input
         * array into 2 halfs, each element is added
         * into the heap according to its index, if
         * index is even number it goes to one heap
         * and vice versa. But this merely split the
         * input array evenly into 2 heaps, to keep
         * the elements sorted in both heaps, whenever
         * an element is added into either heap, the
         * heap poll an element which will be added
         * into the other heap. The reason why this
         * is important is so that when an element
         * is added to the lower half heap, the lower
         * half heap (which is actually a heap with
         * reverse order) will then lose its biggest
         * element to the higher half heap, and if
         * an element is added to the higher half heap,
         * the higher heap will as well lose its smallest
         * element to the lower half heap.
         *
         * For example:
         * lower-half-heap: [5]
         * higher-half-heap: [9]
         *
         * If an element 10 is added to the lower-half-heap,
         * the lower-half will become [5, 10] while the upper-
         * half will become [9] which is not properly splitting
         * the input array in a sorted manner, but with the
         * mechanism describe above, the lower-half poll (loses)
         * its biggest element 10 to the higher-half, resulting
         * in lower-half: [5] and higher-half: [9, 10], maintaining
         * the sorted order properly.
         *
         * Combining this split mechanism to add elements into heap
         * O(Log(N)) and the lookup of median O(1) for every elements
         * in the input array, the overall time complexity is O(N Log(N)),
         * and space complexity is O(N) for the heaps, and O(N) for the
         * output array.
         */

        // Write the code here
        Queue<Integer> lowerHalfHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> higherHalfHeap = new PriorityQueue<>();

        int[] output = new int[arr.length];

        for (int i=0; i<arr.length; i++) {
            if (i%2 == 0) {
                lowerHalfHeap.offer(arr[i]);
                higherHalfHeap.offer(lowerHalfHeap.poll());

                int median = higherHalfHeap.peek();
                output[i] = median;

            } else {
                higherHalfHeap.offer(arr[i]);
                lowerHalfHeap.offer(higherHalfHeap.poll());

                int left = lowerHalfHeap.peek();
                int right = higherHalfHeap.peek();
                int median = (left + right) / 2;
                output[i] = median;
            }
        }

        return output;
    }

    private static int[] solutionV1(int [] arr) {
        // Write your code here
        Queue<Integer> minHeap = new PriorityQueue<>();
        int[] output = new int[arr.length];

        for (int i=0; i<arr.length; i++) {
            minHeap.offer(arr[i]);

            int[] tmp = new int[minHeap.size()];
            for (int j=0; j<tmp.length; j++) {
                tmp[j] = minHeap.poll();
            }

            if (i%2==0) {
                output[i] = (Integer)tmp[i/2];
            } else {
                Integer left = (Integer)tmp[i/2];
                Integer right = (Integer)tmp[i/2 + 1];
                output[i] = (left + right) / 2;
            }

            for (int j=0; j<tmp.length; j++) {
                minHeap.offer(tmp[j]);
            }
        }

        return output;
    }
}
