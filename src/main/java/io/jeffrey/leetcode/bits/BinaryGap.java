package io.jeffrey.leetcode.bits;

/**
 * <h1>Binary Gap</h1>
 *
 * Given a positive integer n, find and return the longest distance
 * between any two adjacent 1's in the binary representation of n.
 * If there are no two adjacent 1's, return 0.<p/>
 *
 * Two 1's are adjacent if there are only 0's separating them (possibly
 * no 0's). The distance between two 1's is the absolute difference
 * between their bit positions. For example, the two 1's in "1001" have
 * a distance of 3.<p/>
 *
 * <b>Example 1:</b>
 * <pre>
 * {@code
 * Input: n = 22
 * Output: 2
 * Explanation: 22 in binary is "10110".
 * The first adjacent pair of 1's is "10110" with a distance of 2.
 * The second adjacent pair of 1's is "10110" with a distance of 1.
 * The answer is the largest of these two distances, which is 2.
 * Note that "10110" is not a valid pair since there is a 1 separating the two 1's underlined.
 * }
 * </pre>
 *
 * <b>Example 2:</b>
 * <pre>
 * {@code
 * Input: n = 8
 * Output: 0
 * Explanation: 8 in binary is "1000".
 * There are not any adjacent pairs of 1's in the binary representation of 8, so we return 0.
 * }
 * </pre>
 *
 * <b>Example 3:</b>
 * <pre>
 * {@code
 * Input: n = 5
 * Output: 2
 * Explanation: 5 in binary is "101".
 * }
 * </pre>
 *
 * <b>Constraints:</b>
 * <pre>
 * {@code
 * 1 <= n <= 10^9
 * }
 * </pre>
 */
public class BinaryGap {

    static int execute(int n) {
        return solutionV2(n);
    }

    private static int solutionV2(int n) {
        // Optimized of v1 with only one loop
        int max = 0;
        int prev = -1, curr = 0;

        for (int i=0; i<32; i++) {
            int mask = 1 << i;
            curr = i;
            if ((n & mask) != 0) {
                if (prev != -1) {
                    max = Math.max(max, curr - prev);
                }
                prev = curr;
            }
        }

        return max;
    }

    private static int solutionV1(int n) {
        /* Design the algorithm here
         *
         * The requirement here is to aim for O(1)
         * time and space complexity, thus cannot
         * use the binary string method which store
         * the binary value in a string.
         *
         * The idea is to apply bit manipulation,
         * test every bit of the integer against a
         * mask to validate if that bits is 1 or 0
         *
         * For example:
         * integer 5 (binary 101), to test the
         * rightmost bit, apply a mask of 1
         * (101 & 001) which returns 1, so we
         * know the rightmost bit must be 1.
         *
         * As soon as the first bit is found, remember
         * its position and keep iterating towards left
         * to identify the next bit equals to 1, if its
         * found compare the distance with the position
         * of previous bit 1, set it to max if max is 0,
         * or if it is larger than max.
         *
         * The iteration stop until the capacity of integer
         * is reached (32).
         *
         * Finally, apply optimization by returning zero
         * immediately if n is 0 or n is a power of 2.
         *
         * This algorithm is tricky to code.
         */
        // Write the code here
        if (n == 0 || (n & (n-1)) == 0) {
            return 0;
        }

        int max = 0;

        int mask = 1 << 0;
        int i;
        for (i=0; i<32; ++i) {
            if ((n & mask) != 0) {
                break;
            }
            mask = 1 << i + 1;
        }

        int prev = i;
        int curr = i + 1;
        for (int j=curr; j<32; j++) {
            mask = 1 << j;
            if ((n & mask) != 0) {
                max = Math.max(max, curr-prev);
                prev = curr;
            }
            curr += 1;
        }

        return max;
    }
}
