package io.jeffrey.facebook.hashtables;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>Pair Sums</h1><p/>
 *
 * Given a list of n integers arr[0..(n-1)], determine the
 * number of different pairs of elements within it which sum to k.<p/>
 *
 * If an integer appears in the list multiple times, each copy is considered
 * to be different; that is, two pairs are considered different if one pair
 * includes at least one array index which the other doesn't, even if they
 * include the same values.<p/>
 *
 * <b>Signature</b><br/>
 * <pre>
 * {@code
 * int numberOfWays(int[] arr, int k)
 * }
 * </pre>
 *
 * <b>Input</b><br/>
 * n is in the range [1, 100,000].<br/>
 * Each value arr[i] is in the range [1, 1,000,000,000].<br/>
 * k is in the range [1, 1,000,000,000].<p/>
 *
 * <b>Output</b><br/>
 * Return the number of different pairs of elements which
 * sum to k.<p/>
 *
 * <b>Example 1</b><br/>
 * <pre>
 * {@code
 * n = 5
 * k = 6
 * arr = [1, 2, 3, 4, 3]
 * output = 2
 * }
 * </pre>
 * The valid pairs are 2+4 and 3+3.<p/>
 *
 * <b>Example 2</b><br/>
 * <pre>
 * {@code
 * n = 5
 * k = 6
 * arr = [1, 5, 3, 3, 3]
 * output = 4
 * }
 * </pre>
 *
 * There's one valid pair 1+5, and three different valid pairs 3+3
 * (the 3rd and 4th elements, 3rd and 5th elements, and 4th and 5th
 * elements).<br/>
 */
class PairSums {

    public static int execute(int[] arr, int k) {
        return solutionV1(arr, k);
    }

    private static int solutionV1(int[] arr, int k) {
        // Design the algorithm here
        /*
         * Loop through the input array, for each element
         * compute its compliment to k, if the compliment
         * is found in the map, increment the match count
         * with the number of compliments found from the
         * map. Then put the element into the map with
         * the value associated to its count in the map.
         */

        // Write the code here
        Map<Integer,Integer> map = new HashMap<>();
        int match = 0;

        for (int i=0; i<arr.length; i++) {
            int compliment = k - arr[i];
            int compliment_count = map.getOrDefault(compliment, 0);
            if (compliment_count>0) {
                match += compliment_count;
            }
            int count = map.getOrDefault(arr[i], 0);
            map.put(arr[i], count+1);
        }

        return match;
    }
}
