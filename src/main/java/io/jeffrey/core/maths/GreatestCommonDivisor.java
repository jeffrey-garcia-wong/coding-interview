package io.jeffrey.core.maths;

/**
 * <h1>Greatest Common Divisor</h1><p/>
 *
 * Given 2 non negative integers m and n, find gcd(a, b).<p/>
 *
 * GCD of 2 integers a and b is defined as the greatest
 * integer g such that g is a divisor of both a and b.<p/>
 *
 * Both a and b fit in a 32 bit signed integer.<p/>
 *
 * <b>Example</b><br/>
 * <pre>
 * {@code
 * a = 6
 * b = 9
 * GCD(a, b) = 3
 * }
 * </pre>
 */
public class GreatestCommonDivisor {

    public static int execute(int a, int b) {
        return solutionV1(a, b);
    }

    static int solutionV1(int a, int b) {
        // Design the algorithm here
        /*
         * Use of Euclid's algorithm.
         *
         * Keep dividing a with b until b reaches 0.
         * - if a can be fully divided by b, return a as the GCD.
         * - if a cannot be fully divided, assign b to a, and the
         *   remainder to b, then repeat the division process again
         * - eventually b is reduced to 1 and fully divide a, so 1
         *   become the GCD of both a and b.
         *
         * Number 0 is a factor of all numbers including 0, then
         * the GCD of 0 and X is X because X is the only factor
         * that can divide X and 0.
         *
         */

        // Write the code here
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
