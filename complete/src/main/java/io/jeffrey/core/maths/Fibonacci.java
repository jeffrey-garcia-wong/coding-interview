package io.jeffrey.core.maths;

/**
 * <h1>The Fibonacci Sequence</h1><p/>
 *
 * The Fibonacci sequence begins with fibonacci(0)=0 and fibonacci(1)=1
 * as its first and second terms. After these first two elements, each
 * subsequent element is equal to the sum of the previous two elements.<p/>
 *
 * Programmatically:
 * <pre>
 * {@code
 * fibonacci(0) = 0
 * fibonacci(1) = 1
 * fibonacci(n) = fibonacci(n-2) + fibonacci(n-1)
 * }
 * </pre>
 * Given n, return the n number in the sequence.<p/>
 *
 * <b>Example</b><br/>
 * n = 5<br/>
 * The Fibonacci sequence to 6 is [0,1,1,2,3,5,8]. With zero-based indexing, fibonacci(5)=5 <p/>
 *
 */
public class Fibonacci {

    public static int execute(int n) {
        return solutionV2(n);
    }

    private static int solutionV2(int n) {
        // Design the algorithm here
        /*
         * Use a non-recursive version to calculate fibonacci.
         * Simply iterate from i=2 to i=n and store the sum in
         * memory as we increment i towards n. The space
         * complexity remains O(1), the limitation is that
         * sum will overflow once it exceeds the storage
         * capacity of integer.
         *
         * fibonacci of 0 is 0
         * fibonacci of 1 is 1
         */

        // Write the code here
        int prev2 = 0;
        int prev1 = 1;

        if (n == 0) return prev2;
        if (n == 1) return prev1;

        for (int i=2; i<=n; i++) {
            int tmp = prev1;
            prev1 = prev1 + prev2;
            prev2 = tmp;
        }

        return prev1;
    }
}
