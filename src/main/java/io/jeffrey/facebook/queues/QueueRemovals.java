package io.jeffrey.facebook.queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <b>Queue Removals</b><p/>
 *
 * You're given a list of n integers arr, which represent elements
 * in a queue (in order from front to back). You're also given an
 * integer x, and must perform x iterations of the following 3-step
 * process:
 * <ul>
 *     <li>Pop x elements from the front of queue (or, if it
 *     contains fewer than x elements, pop all of them)</li>
 *     <li>Of the elements that were popped, find the one with
 *     the largest value (if there are multiple such elements,
 *     take the one which had been popped the earliest),
 *     and remove it</li>
 *     <li>For each one of the remaining elements that were popped
 *     (in the order they had been popped), decrement its value by 1
 *     if it's positive (otherwise, if its value is 0, then it's
 *     left unchanged), and then add it back to the queue</li>
 * </ul>
 *
 * Compute a list of x integers output, the ith of which is the
 * 1-based index in the original array of the element which had
 * been removed in step 2 during the ith iteration.<p/>
 *
 * <b>Input</b><br/>
 * <pre>
 * {@code
 * x is in the range [1, 316].
 * n is in the range [x, x*x].
 * Each value arr[i] is in the range [1, x].
 * }
 * </pre>
 *
 * <b>Output</b><br/>
 * <pre>
 * {@code
 * Return a list of x integers output, as described above.
 * }
 * </pre>
 *
 * <b>Example</b><br/>
 * <pre>
 * {@code
 * n = 6
 * arr = [1, 2, 2, 3, 4, 5]
 * x = 5
 * output = [5, 6, 4, 1, 2]
 * }
 * </pre>
 *
 * The initial queue is [1, 2, 2, 3, 4, 5] (from front to back).<p/>
 *
 * In the first iteration, the first 5 elements are popped off the queue,
 * leaving just [5]. Of the popped elements, the largest one is the 4,
 * which was at index 5 in the original array. The remaining elements
 * are then decremented and added back onto the queue, whose contents
 * are then [5, 0, 1, 1, 2].<p/>
 *
 * In the second iteration, all 5 elements are popped off the queue.
 * The largest one is the 5, which was at index 6 in the original array.
 * The remaining elements are then decremented (aside from the 0) and
 * added back onto the queue, whose contents are then [0, 0, 0, 1].<p/>
 *
 * In the third iteration, all 4 elements are popped off the queue.
 * The largest one is the 1, which had the initial value of 3 at index
 * 4 in the original array. The remaining elements are added back onto
 * the queue, whose contents are then [0, 0, 0].<p/>
 *
 * In the fourth iteration, all 3 elements are popped off the queue.
 * Since they all have an equal value, we remove the one that was
 * popped first, which had the initial value of 1 at index 1 in
 * the original array. The remaining elements are added back onto
 * the queue, whose contents are then [0, 0].<p/>
 *
 * In the final iteration, both elements are popped off the queue.
 * We remove the one that was popped first, which had the initial
 * value of 2 at index 2 in the original array.<p/>
 *
 */
class QueueRemovals {

    public static int[] execute(int[] arr, int x) {
        return solutionV1(arr, x);
    }

    private static int[] solutionV1(int[] arr, int x) {
        // Design the algorithm here
        /*
         * The idea is to covert the input array into a queue,
         * such that we can efficiently pop the desired number of
         * elements from the front and find the maximum element,
         * remove it, then decrement all the remaining elements.
         * The popped elements are also stored in a queue and
         * added to the back of the main queue for further next
         * iteration, the process finished until the number of
         * iterations reached x, or the main queue becomes empty.
         *
         * This solution requires 2 queues, and size of both
         * queues will be bounded by the total number of elements
         * and will shrink over time as more nodes are popped, thus
         * the space complexity is O(N).
         *
         * A Node class is created for storing the element's value
         * as well as its original position, accounting for an
         * additional expenditure in terms of space.
         *
         * Since the number of iterations is expected to be x, and
         * for each iteration we need to examine x elements, the
         * time complexity should be O(x*x).
         */

        // Write the code here

        // special handling when input array size is less than x
        int[] result = new int[Math.min(arr.length, x)];

        Queue<Node> main = new LinkedList<>();
        Queue<Node> popped = new LinkedList<>();

        // insert all the popped elements into the respective queue
        for (int i=0; i<arr.length; i++) {
            Node node = new Node(arr[i], i+1);
            if (i < x) {
                popped.offer(node);
            } else {
                main.offer(node);
            }
        }

        for (int i=0; i<x; i++) {
            // find the maximum elements and its position
            int max = -1;
            int maxId = -1;
            Queue<Node> tmp = new LinkedList<>();
            while (popped.peek() != null) {
                Node node = popped.poll();
                if (node.val > max) {
                    max = node.val;
                    maxId = node.pos;
                }
                tmp.offer(node);
            }

            // add all non-nodes back to the main queue and
            // decrement their value
            while (tmp.peek() != null) {
                Node node = tmp.poll();
                if (node.pos != maxId) {
                    node.val = node.val==0 ? 0 : node.val-1;
                    main.offer(node);
                } else {
                    result[i] = node.pos;
                }
            }

            // pop the first x elements from the head of main queue
            // for next iteration
            int counter = 1;
            while (main.peek() != null && counter <= x) {
                popped.offer(main.poll());
                counter += 1;
            }
        }

        return result;
    }

    static class Node {
        int val;
        int pos;
        Node (int val, int pos) {
            this.val = val;
            this.pos = pos;
        }
    }
}
