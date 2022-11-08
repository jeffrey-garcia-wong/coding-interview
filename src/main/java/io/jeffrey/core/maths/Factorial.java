package io.jeffrey.core.maths;

class Factorial {

    static int execute(int n) {
        return solutionV1(n);
    }

    private static int solutionV1(int n) {
        // Design the algorithm here
        /*
         * Use a non-recursive version to calculate factorial.
         * Simple iterate from i=2 to i=n and store the product
         * in memory as we increment i towards n. The space
         * complexity remains O(1), the limitation is that
         * product will overflow once it exceeds the storage
         * capacity of integer.
         *
         * Factorial of 0 is 1.
         */

        // Write the code here
        int result = 1;

        if (n <= 1) return result;

        for (int i=2; i<=n; i++) {
            result = result * i;
        }
        return result;
    }
}
