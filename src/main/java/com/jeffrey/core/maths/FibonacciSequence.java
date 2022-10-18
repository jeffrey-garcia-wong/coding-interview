package com.jeffrey.core.maths;

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
class FibonacciSequence {

    static int execute(int n) {
        return solutionV1(n);
    }

    private static int solutionV1(int n) {
        // Design the algorithm here
        /*
         Assumption N is with the range such that the N fibonacci
         number can be stored in a 32-bit integer without overflow.

         Instead of using a general recursive algorithm which runs
         from top-down, dynamic programming technique is used to
         obtain the N fibonacci number by summing N-2 and N-1 from
         bottom-up.
         */

        // Write the code here
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(0, 1, n, 2);
    }

    private static int fib(int prev2, int prev1, int n, int counter) {
        if (n - counter > 0) {
            int tmp = prev1;
            prev1 = prev1 + prev2;
            prev2 = tmp;
            return fib(prev2, prev1, n, counter + 1);
        } else {
            return prev1 + prev2;
        }
    }
}
