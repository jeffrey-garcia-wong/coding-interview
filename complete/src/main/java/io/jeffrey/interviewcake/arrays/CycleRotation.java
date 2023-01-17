package io.jeffrey.interviewcake.arrays;

import io.jeffrey.core.maths.GreatestCommonDivisor;

/**
 * <h1>Cycle Rotation</h1>
 *
 * An array A consisting of N integers is given.
 * Rotation of the array means that each element
 * is shifted right by one index, and the last
 * element of the array is moved to the first
 * place. For example, the rotation of array
 * A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7]
 * (elements are shifted right by one index and 6
 * is moved to the first place).<p/>
 *
 * The goal is to rotate array A K times; that is,
 * each element of A will be shifted to the right
 * K times.<p/>
 *
 * Write a function:
 * <pre>
 * {@code
 * class Solution { public int[] solution(int[] A, int K); }
 * }
 * </pre>
 * that, given an array A consisting of N integers and
 * an integer K, returns the array A rotated K times.<p/>
 *
 * For example, given
 * <pre>
 * {@code
 * A = [3, 8, 9, 7, 6]
 * K = 3
 * }
 * </pre>
 * the function should return [9, 7, 6, 3, 8]. Three rotations were made:
 * <pre>
 * {@code
 * [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
 * [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
 * [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
 * }
 * </pre>
 *
 * For another example, given
 * <pre>
 * {@code
 * A = [0, 0, 0]
 * K = 1
 * }
 * </pre>
 * the function should return [0, 0, 0]<p/>
 *
 * Given
 * <pre>
 * {@code
 * A = [1, 2, 3, 4]
 * K = 4
 * }
 * </pre>
 * the function should return [1, 2, 3, 4]<p/>
 *
 * Assume that:
 * <ul>
 *     <li>
 *          N and K are integers within the range [0..100];
 *     </li>
 *     <li>
 *          each element of array A is an integer within the range [−1,000..1,000].
 *     </li>
 * </ul>
 */
class CycleRotation {
    static int[] execute(int[] A, int K) {
        return solutionV2(A, K);
    }

    static int[] solutionV2(int[] A, int K) {
        /*
         * An optimised version of v1 to swap elements in-place without
         * introducing a new array.
         *
         * Space complexity = O(1)
         * Time complexity = O(N)
         *
         * The idea is start shifting element at position 0 to its target
         * position, while the element in the original position is then
         * popped (saved) as well with its index in the array.
         *
         * Now instead of iterating all the elements sequentially in the
         * array, the algorithm continues to compute the target position
         * of the popped element (based on its index). Then repeat the
         * process to pop that element in the target position before
         * shifting the current element into there. Eventually after doing
         * this for every element in the array, the shifting operation is
         * fully completed and the process terminates.
         *
         * The trickiest part is to deal with scenario where the number of
         * moves is a factor of the array's length, for example: if each
         * element is to be shifted by 2 positions while the length of the
         * array is 6. It's easy to see that after making the 3rd shift of
         * elements (0->2, 2->4, 4->0) the target position cycled back to
         * 0 which is where we started and the original element there was
         * indeed shifted to position 2 (but its value remains in that
         * position in the array), so the algorithm should stop when the
         * target position cycle back to where it initially started (avoid
         * re-shifting the original elements in index 0). But the shifting
         * operation is not fully completed because there are 3 elements
         * remains to be shifted at position (1, 3, 5). So instead of
         * terminating the process, the algorithm moves the start position
         * from 0 to 1 and begin popping off the elements from there (with
         * its index saved), compute the target position and repeat the
         * same popping mechanism until eventually the target position
         * cycles back to where it started (position 1). The 4th, 5th and
         * 6th shift operation involved are (1->3, 3->5, 5->1).
         *
         * The algorithm should repeat the process itself until all the
         * elements are swapped, and this is easily achieved by keeping a
         * counter which increments whenever an element is shifted.
         *
         * We need to access every element in the array with its index
         * position, which is an O(1) operation, but we have to do this
         * for all the elements in the array so the overall time complexity
         * is O(N). But the upside is this algorithm does not incur extra
         * consumption of memory for a separate array and thus keeps the
         * space complexity in O(1).
         *
         * This algorithm primarily works for right rotation, but since
         * left rotation is simply going right by (N - K) positions, the
         * algorithm can be easily tweaked to produce the result of left
         * rotation.
         */
        // Design the algorithm here

        // write your code here
        if (A.length < 2) return A;

        int moves = K % A.length; // right rotate
//        int moves = A.length - (K % A.length); // left rotate
        if (moves == 0) return A;

        int startPos = 0;
        int oldPos = startPos;
        int oldVal = A[oldPos];

        int count = 0;
        while (count < A.length) {
            int newPos = oldPos + moves;
            if (newPos >= A.length) newPos -= A.length;

            int tmp = A[newPos];
            A[newPos] = oldVal;
            oldPos = newPos;
            oldVal = tmp;

            // if the swap goes back to the starting element,
            // restart the shifting process on the next adjacent element
            if (newPos == startPos) {
                if (startPos < A.length - 1)
                    startPos += 1;
                else
                    startPos = 0;

                oldPos = startPos;
                oldVal = A[oldPos];
            }

            count += 1;
        }

        return A;
    }

    static int[] solutionV1(int[] A, int K) {
        // Design the algorithm here
        /*
         * The actual number of moves can be simplified
         * by computing the modulo of array length
         * and the move steps. This reduces the steps
         * count to be within the size of the array.
         *
         * Next create an empty array of the same
         * size for storing the shifted numbers in
         * their new position, this increases the
         * space complexity from O(1) to O(N).
         *
         * Iterate through the input array and
         * compute the new position of the current
         * element, then place the value into the
         * new array. Return the new array when
         * the iteration finishes.
         *
         * The minimal time complexity is O(N) since
         * shifting the elements requires traversing
         * all the elements.
         */

        // write your code here
        if (A.length < 2) return A;

        int moves = K % A.length;
        int[] B = new int [A.length];
        for (int i=0; i<A.length; i++) {
            if (i + moves < A.length) {
                B[i+moves] = A[i];
            } else {
                B[i+moves-A.length] = A[i];
            }
        }
        return B;
    }

}
