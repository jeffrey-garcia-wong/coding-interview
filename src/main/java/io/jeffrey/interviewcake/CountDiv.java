package io.jeffrey.interviewcake;

/**
 * <h1>Count Div</h1>
 *
 * Compute number of integers divisible by k in range [a..b].<p/>
 *
 * Write a function:
 * <pre>
 * {@code
 * class Solution { public int solution(int A, int B, int K); }
 * }
 * </pre>
 * that, given three integers A, B and K, returns the number of
 * integers within the range [A..B] that are divisible by K, i.e.:
 * <pre>
 * {@code
 * { i : A ≤ i ≤ B, i mod K = 0 }
 * }
 * </pre>
 *
 * For example, for A = 6, B = 11 and K = 2, your function should
 * return 3, because there are three numbers divisible by 2 within
 * the range [6..11], namely 6, 8 and 10.<p/>
 *
 * Write an efficient algorithm for the following assumptions:
 * <ul>
 *     <li>A and B are integers within the range [0..2,000,000,000];</li>
 *     <li>K is an integer within the range [1..2,000,000,000];</li>
 *     <li>A ≤ B.</li>
 * </ul>
 *
 */
public class CountDiv {

    public static int execute(int A, int B, int K) {
        return solutionV1(A, B, K);
    }

    private static int solutionV1(int A, int B, int K) {
        /* Design the algorithm here
         *
         * Since B>=A, evaluate the first integer from A
         * which is divisible by K, once it is identified
         * simply compute the gap between B and it, then
         * divide it by K.
         */

        // Write the code here
        int count = 0;
        int curr = (A % K == 0) ? A : A + (K - (A % K));

        if (curr <= B) {
            count += 1;
            count += ((B-curr) / K);
        }

        return count;
    }

}
