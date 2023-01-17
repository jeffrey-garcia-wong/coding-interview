package io.jeffrey.core.maths;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * <h1>All Factors</h1><p/>
 *
 * Given a number N, find all factors of N.<p/>
 *
 * <b>Example:</b><br/>
 * <pre>
 * {@code
 * N = 6
 * factors = {1, 2, 3, 6}
 * Make sure the returned list is sorted.
 * }
 * </pre>
 */
public class Factors {

    public static List<Integer> execute(int n) {
        return solutionV1(n);
    }

    private static List<Integer> solutionV1(int n) {
        // Design the algorithm here
        /*
         * Number 0 has infinity factors.
         */

        // Write the code here
        if (n < 1) throw new IllegalArgumentException("value must be >= 1");

        List<Integer> list = new LinkedList<>();
        int sqrt = (int)Math.sqrt(n);

        for (int i=1; i<=sqrt; i++) {
            if (n % i == 0) {
                list.add(i);
                if (i!=sqrt) {
                    list.add(n/i);
                }
            }
        }

        Collections.sort(list);
        return list;
    }

}
