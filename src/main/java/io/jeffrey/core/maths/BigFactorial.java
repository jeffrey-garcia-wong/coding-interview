package io.jeffrey.core.maths;

import java.math.BigInteger;

class BigFactorial {

    static String execute(int n) {
        return solutionV2(n).toString();
    }

    private static BigInteger solutionV2(int n) {
        // Design the algorithm here
        /*
        Use a non-recursive version to calculate factorial.
        Simple iterate from i=2 to i=n and store the multiplication
        result in memory as we increment i towards n. This algorithm
        remains scalable regardless of the stack size assigned to JVM
         */

        // Write the code here
        BigInteger result = BigInteger.valueOf(1);

        if (n <= 1) return result;

        for (int i=2; i<=n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    private static BigInteger solutionV1(int n, int counter, BigInteger prev) {
        // Design the algorithm here
        /*
         Assumption N is with the range such that the N factorial
         number cannot be stored even in a 64-bit long data type.

         Instead of using a general recursive algorithm which runs
         from top-down, dynamic programming technique is used to
         obtain the N factorial number by multiplying N and N-1 from
         bottom-up.

         In JDK 11, with -Xss256k the program is guaranteed to
         encounter stackoverflow when N>=1200
         */

        // Write the code here
        if (n <= 1) return BigInteger.valueOf(1);
        if (n == counter) return prev;
        return solutionV1(n, counter+1, BigInteger.valueOf((counter+1)).multiply(prev));
    }

}
