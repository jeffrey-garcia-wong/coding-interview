package io.jeffrey.core.maths;

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
class Prime {

    static List<Integer> execute(int n) {
        return solutionV1(n);
    }

    private static List solutionV1(int n) {
        // Design the algorithm
        /*
         * Use the sieve of eratosthenes algorithm
         *
         * The strategy is to iterate all the N numbers, then for
         * each number compute its multiples and mark them as non-
         * prime numbers, at the end of the process only numbers
         * that are not multiples of any other numbers will be
         * prime numbers.
         *
         * To implement this we need to create an array of N+1
         * size to record the primality of the particular number
         * in that position, including number 0 as well with 1...N,
         * this accounts of O(N) space complexity.
         *
         * The iteration can be further tightened to reduce time
         * complexity:
         * - exclude 0 and 1 since they are not prime numbers
         *   (they can be marked as not prime right away without
         *   going into iteration)
         * - the iteration only needs to go as far as the square
         *   root of N (as explained below)
         *
         *   For example if N=36, by division the factors found are:
         *   - 2, 18
         *   - 3, 12
         *   - 4, 9
         *   - 6, 6
         *   - 9, 4
         *   - 12, 3
         *   - 18, 2
         *
         *   Clearly processing from 2 till 6 (square root of 36) should
         *   be sufficient to identify the factors and their corresponding
         *   co-factors. Processing beyond 6 will simply work out the same
         *   pair of factors which is redundant, as a result it is sufficient
         *   to conclude the primality of N by computing all the factors up
         *   till the square root of N.
         *
         *   The factors can also be found in another fashion using multiplication,
         *   by identifying the multiples of number starting from 2 till N (N=36).
         *   2 [4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36]
         *   3 [6,9,12,15,18,21,24,27,30,33,36]
         *   4 [8,12,16,20,24,28,32,36]
         *   5 [10,15,20,25,30,35]
         *   6 [12,18,24,30,32,36]
         *   7 [14,21,28]
         *   8 [16,24,32]
         *   9 [18,36]
         *  10 [20]
         *  11 [22]
         *  12 [24]
         *  13 [26]
         *  14 [28]
         *  15 [30]
         *  16 [32]
         *  17 [34]
         *  18 [36]
         *
         *  In each iteration, multiples of the current number are computed
         *  which concludes into 2 findings:
         *  - the current number is a factor of all the multiples computed,
         *  - the multiples are not prime numbers (because they can be factored)
         *
         *  Base on the fact that processing up to the square root of N is
         *  sufficient to conclude the primality of N, similarly processing
         *  from 2 till 6 (square root of 36) should also be sufficient to
         *  conclude the primality of N.
         *
         *  Since all the numbers before N (N=36) are less than N, the
         *  primality of all numbers before N have a square root less than
         *  6, therefore processing till square root of N is also sufficient
         *  to identify the primality of all numbers before N.
         */


        // Write the code here
        if (n == 0) throw new IllegalArgumentException("n must be greater than 0");

        boolean prime[] = new boolean[n+1];
        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;

        int sqrt = (int)Math.sqrt(n);
        for (int i=2; i<=sqrt; i++) {
            if (prime[i]) {
                /**
                 * possible overflow if both i and j are sufficiently large,
                 * but you would likely to encounter OutOfMemoryError first
                 * due to the large array
                 */
                int j = 2;
                int product = j * i;
                while (product <= n) {
                    prime[product] = false;
                    product = ++j * i;
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
