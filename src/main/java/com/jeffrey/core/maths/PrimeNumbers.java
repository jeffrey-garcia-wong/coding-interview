package com.jeffrey.core.maths;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <h1>Prime Numbers</h1><p/>
 *
 * <b>Example:</b><p/>
 * <pre>
 * {@code
 * if N = 7, all primes till 7 = {2, 3, 5, 7}
 * }
 * </pre>
 * Make sure the returned array is sorted.<p/>
 *
 */
class PrimeNumbers {

    static List<Integer> execute(int n) {
        return solutionV1(n);
    }

    private static List solutionV1(int n) {
        // Design the algorithm
        /*
         * Use the sieve of eratosthenes algorithm
         */

        // Write the code here
        if (n == 0) throw new IllegalArgumentException("n must be greater than 0");

        boolean prime[] = new boolean[n+1];
        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;

        for (int i=2; i<=Math.sqrt(n); i++) {
            if (prime[i]) {
                /**
                 * possible overflow if both i and j are sufficiently large
                 * but you would likely to encounter OutOfMemoryError first
                 * due to the large array
                 */
                for (int j=2; i*j<=n; j++) {
                    prime[i*j] = false;
                }
            }
        }

        /**
         * filter the non-prime list and scratch them off then we have
         * a list with only primes, this filter operation requires
         * addition space complexity and time complexity
         */
        List<Integer> list = new LinkedList<>();
        for (int i=0; i<prime.length; i++) {
            if (prime[i]) {
                list.add(i);
            }
        }
        return list;
    }

}
