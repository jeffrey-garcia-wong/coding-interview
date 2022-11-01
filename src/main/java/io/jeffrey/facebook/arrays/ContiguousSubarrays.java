package io.jeffrey.facebook.arrays;

import java.util.Arrays;
import java.util.Stack;

/**
 * <h1>Contiguous Subarrays</h1><p/>
 *
 * You are given an array <b>arr</b> of <b>N</b> integers.
 * For each index <b>i</b>, you are required to determine
 * the number of contiguous subarrays that fulfill the
 * following conditions:
 * <ul>
 *     <li>The value at index i must be the maximum element in the contiguous subarrays, and</li>
 *     <li>These contiguous subarrays must either start from or end on index i.</li>
 * </ul>
 *
 * <b>Signature</b><br/>
 * <pre>
 * {@code
 * int[] countSubarrays(int[] arr)
 * }
 * </pre>
 *
 * <b>Input</b>
 * <ul>
 *     <li>Array <b>arr</b> is a non-empty list of unique
 *     integers that range between 1 to 1,000,000,000</li>
 *     <li>Size <b>N</b> is between 1 and 1,000,000</li>
 * </ul>
 *
 * <b>Output</b><br/>
 * An array where each index i contains an integer denoting
 * the maximum number of contiguous subarrays of <b>arr[i]</b>
 *
 * <b>Example</b>
 * <pre>
 * {@code
 * arr = [3, 4, 1, 6, 2]
 * output = [1, 3, 1, 5, 1]
 * }
 * </pre>
 *
 * <b>Explanation</b><br/>
 * <ul>
 *     <li>For index 0 - [3] is the only contiguous subarray that
 *     starts (or ends) with 3, and the maximum value in this
 *     subarray is 3.</li>
 *     <li>For index 1 - [4], [3, 4], [4, 1]</li>
 *     <li>For index 2 - [1]</li>
 *     <li>For index 3 - [6], [6, 2], [1, 6], [4, 1, 6], [3, 4, 1, 6]</li>
 *     <li>For index 4 - [2]</li>
 * </ul>
 * So, the answer for the above input is [1, 3, 1, 5, 1]
 *
 */
class ContiguousSubarrays {

    static int[] execute(int [] arr) {
        return solutionV1(arr);
    }

    private static int[] solutionV1(int [] arr) {
        // Design the algorithm here
        /*
        To solve this problem we need to go through each element
        in the array sequentially, but whenever we iterate to
        the next element, we only get to know about the elements
        that have been visited, and we won't be able to compare
        the elements that have not been visited until we visit
        them.

        This limitation can be simply resolved by comparing
        all the other elements for each element we iterated,
        which would results in 2 for-loops with an inner loop
        nested into an outer loop, the downside is this would
        yield an O(N^2) runtime performance.

        To reduce the time complexity to O(N), a better strategy
        is to scan the array 2 times, the first time from left
        to right (so for each element we can compare it against
        all the other visited elements on its left), the second
        time is from right to left (so for each element we can
        compare it against all the other visited elements on its
        right), by the time when both scan operations are finished,
        we should know for each element, its comparison with all
        the other elements on its left side and right side.

        Create an array with the same size as the input array, it
        will be used to store the result (number of subarrays that
        could found for each element in the input array at the same
        index position), initialize each value of the result array
        with a value of 1, since each element is considered as a
        subarray of itself.
        result array = [1,1,1,1,1]

        We would also need an additional storage to remember previous
        visited elements, this is important because during the scan
        operation for each element we have to compare it with elements
        visited before.

        For each comparison, we only need to know 2 facts:
        - if the current element is the biggest
        - if the current element is not the biggest, then how
        many elements before it is smaller than it

        This means instead of storing all the previously visited
        elements, we only need to store the elements that are
        bigger than the current elements, and we store the index
        of the element as they appear in the array rather than its
        value. This make sense because:
        - if element at N+1 is bigger than element at N, it must also
        be bigger than all the elements before N which are smaller than
        N
        - if element at N+1 is smaller than element at N, the compare
        stop immediately because it's impossible to have a subarray
        with N or any elements before N

        The storage can be implemented using a stack or a LIFO queue,
        at the beginning of the left side scan, the index of the first
        element is stored (since it's the biggest element known at
        that time), for each iteration we compare the current element
        with the top/last element (it's the index of the previous
        element instead of its value) in the collection, if current
        element is bigger than we can safely discard the top/last
        element in the storage, this process repeats until the
        storage is emptied (which means the current element is the
        biggest value seen so far) or the current element is smaller
        than the top/last element in the storage (which means an
        element previous visited is larger than it so the comparison
        stop). Next we compute the distance between the index of
        current element and all the elements smaller than it, this
        would give us the number of subarrays on its left side. We
        store the number in the result array.

        Take the example of input array [7,4,6,5]:
        Element at index 2(6) is bigger than element at index 1(4),
        by the time we reach element at index 3(5), we compare it
        with element at index 2(6) and know that it's smaller, so
        it won't be possible to have a subarray and there is no
        need to look at element at index 1(4).

        The storage (if a stack) should look like this when we
        arrive the element at index 3(5):
        |2|
        |0|
        ===
        and the result array:
        [1,1,2,1]

        And after visiting element at index 3(5), it becomes:
        |3|
        |2|
        |0|
        ===
        and the result array:
        [1,1,2,1]

        Once the left side scan operation finish, repeat the operation
        from the right side of the input array.
         */

        // write the code here
        int[] result = new int[arr.length];
        Arrays.fill(result, 1);

        // getting ready to scan the array from right to left
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        // scan the entire array from left to right
        for (int i=1; i<arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] += i - 0;
            } else {
                result[i] += i - (stack.peek() + 1);
            }
            stack.push(i);
        }

        // getting ready to scan the array from right to left
        stack.clear();
        stack.push(arr.length-1);

        // scan the entire array from right to left
        for (int i=arr.length-2; i>=0; i--) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] += (arr.length - 1) - i;
            } else {
                result[i] += (stack.peek() -1) - i;
            }
            stack.push(i);
        }

        return result;
    }
}
