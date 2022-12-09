package io.jeffrey.core.maths;

/**
 * <h1>Least Common Multiple</h1><p/>
 *
 * Find Lowest Common Multiple of given two integers.<p/>
 *
 * <b>Example 1:</b>
 * <pre>
 * {@code
 * Input 1:
 * A = 6
 * B = 4
 * Output 1:
 * 12
 * }
 * </pre>
 *
 * <b>Example 2:</b>
 * <pre>
 * {@code
 * Input 2:
 * A = 1
 * B = 11
 * Output 2:
 * 11
 * }
 * </pre>
 */
class LeastCommonMultiple {

    static long execute(int a, int b) {
        return solutionV1(a, b);
    }

    private static long solutionV1(int a, int b) {
        // Design the algorithm here
        /*
         * Based on the below formula for LCM of two
         * numbers a and b.
         * a x b = LCM(a, b) * GCD (a, b)
         * LCM(a, b) = (a x b) / GCD(a, b)
         */

        // Write the code here
        if (a==0 || b==0) return 0;
        long ab = (long) a * (long) b;
        return ab / GreatestCommonDivisor.execute(a,b);
    }
}
