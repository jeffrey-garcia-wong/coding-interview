package com.jeffrey.core.maths;

import java.math.BigInteger;

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
class BigFibonacciSequence {

    static String execute(int n) {
        return solutionV2(n).toString();
    }

    private static BigInteger solutionV2(int n) {
        // Design the algorithm here
        /*
        Use a non-recursive version to calculate fibonacci.
        Simple iterate from i=2 to i=n and store the sum in memory
        as we increment i towards n. This algorithm remains scalable
        regardless of the stack size assigned to JVM
         */

        // Write the code here
        BigInteger prev2 = BigInteger.valueOf(0);
        BigInteger prev1 = BigInteger.valueOf(1);

        if (n == 0) return prev2;
        if (n == 1) return prev1;

        for (int i=2; i<=n; i++) {
            BigInteger tmp = prev1;
            prev1 = prev1.add(prev2);
            prev2 = tmp;
        }

        return prev1;
    }

    private static BigInteger solutionV1(int n) {
        // Design the algorithm here
        /*
         Assumption N is with the range such that the N fibonacci
         number can be stored in a 32-bit integer without overflow.

         Instead of using a general recursive algorithm which runs
         from top-down, dynamic programming technique is used to
         obtain the N fibonacci number by summing N-2 and N-1 from
         bottom-up.

         In JDK 11, with -Xss256k the program is guaranteed to
         encounter stackoverflow when N>=1000
         */
        // Write the code here
        if (n == 0) return BigInteger.valueOf(0);
        if (n == 1) return BigInteger.valueOf(1);
        return fib(BigInteger.valueOf(0), BigInteger.valueOf(1), n, 2);
    }

    private static BigInteger fib(BigInteger prev2, BigInteger prev1, int n, int counter) {
        if (n - counter > 0) {
            BigInteger tmp = prev1;
            prev1 = prev1.add(prev2);
            prev2 = tmp;
            return fib(prev2, prev1, n, counter + 1);
        } else {
            return prev1.add(prev2);
        }
    }
}
