package com.jeffrey.facebook;

import java.util.Arrays;

/**
 * <h1>Reverse to Make Equal</h1><p/>
 *
 * Given two arrays A and B of length N, determine if there is
 * a way to make A equal to B by reversing any sub-arrays from
 * array B any number of times.<p/>
 *
 * <b>Signature</b><br/>
 * <pre>
 * {@code
 * bool areTheyEqual(int[] arr_a, int[] arr_b)
 * }
 * </pre>
 * <p/>
 *
 * <b>Input</b><br/>
 * All integers in array are in the range [0, 1,000,000,000].<p/>
 *
 * <b>Output</b><br/>
 * Return true if B can be made equal to A, return false otherwise.<p/>
 *
 * <b>Example</b><br/>
 * <pre>
 * {@code
 * A = [1, 2, 3, 4]
 * B = [1, 4, 3, 2]
 * output = true
 * }
 * </pre>
 * After reversing the sub-array of B from indices 1 to 3,
 * array B will equal array A.<p/>
 */
class ReverseMakesEqual {

    public static boolean execute(int[] array_a, int[] array_b) {
        return solutionV1(array_a,array_b);
    }

    private static boolean solutionV1(int[] array_a, int[] array_b) {
        // Write your code here
        Arrays.sort(array_a);
        Arrays.sort(array_b);

        for (int i=0; i<array_a.length; i++) {
            if (array_a[i] != array_b[i]) return false;
        }
        return true;
    }
}
