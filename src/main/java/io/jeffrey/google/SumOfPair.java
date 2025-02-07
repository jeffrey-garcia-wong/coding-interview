package io.jeffrey.google;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <h1>Sum of Pairs</h1>
 * <p>
 * Given an integer array and a target integer, find whether a pair of number exist that
 * will add up to the value of the target integer.
 * </p>
 *
 * <br/>
 *
 * <b>Example 1</b>
 * <pre>
 * {@code
 * int [] array = new int[] {3, 4, 1, 6, 2};
 * int target = 10;
 * assertTrue(array, target);
 * }
 * </pre>
 *
 * <b>Example 2</b>
 * <pre>
 * {@code
 * int [] array = new int[] {3, 4, 1, 6, 2};
 * int target = 8;
 * assertFalse(array, target);
 * }
 * </pre>
 */
public class SumOfPair {

    public static boolean execute(int[] input, int target) {
        return solutionV2(input, target);
    }

    /**
     * @implSpec
     * This solution aim to use a {@link Set} which store all the number that
     * has been visited, subsequently upon visiting the next value in the input
     * array, it first computes the offset needed by the current value in order
     * to match the target, then lookup the offset from the {@link Set}.
     * If the offset can be found, we know there is a pair that could match the
     * target.
     *
     * @implNote
     * Time complexity, worst case O(N) because it needs to visit every value
     * if there is no matching pair.
     * Space complexity, worst case O(N) because if all the values are unique
     * and there is no matching pair then every visited value will have to be
     * stored.
     *
     * @param input
     * @param target
     * @return
     */
    private static boolean solutionV1(int [] input, int target) {
        boolean found = false;

        final Set<Integer> visitedInt = new HashSet<>();
        for (int i=0; i<input.length; i++) {
            int current = input[i];

            if (current < target) {
                int offset = target - current;
                if (visitedInt.contains(offset)) {
                    found = true;
                    break;
                } else {
                    visitedInt.add(current);
                }
            }
        }

        return found;
    }

    /**
     * @implSpec
     * First sort the array in ascending order, then use 2 pointers (head and tail) to
     * traverse the array from both end, because the values are sorted, we can be sure
     * that if head + tail is smaller than the target, then we try to advance the head to
     * its next element, similarly if head + tail is greater than the target, we try to
     * advance the tail to its previous element, we keep repeating this process until
     * head and tail overlap or a matching sum has been found.
     *
     * @implNote
     * Time Complexity, worst case O(N) because if no matching pair then we ended up
     * visiting every element in the array.
     * Space Complexity, O(1) because we don't need to store of the visited values
     *
     * @param input
     * @param target
     * @return
     */
    private static boolean solutionV2(int [] input, int target) {
        boolean found = false;

        Arrays.sort(input);
        for (int i=0, j=input.length-1; i<j;) {
            int head = input[i];
            int tail = input[j];

            if (head + tail < target) {
                i += 1;
            } else if (head + tail > target) {
                j -= 1;
            } else {
                found = true;
                break;
            }
        }

        return found;
    }
}
