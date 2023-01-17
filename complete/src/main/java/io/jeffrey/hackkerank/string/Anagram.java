package io.jeffrey.hackkerank.string;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>Anagram</h1><p/>
 *
 * Two words are anagrams of one another if their letters can be
 * rearranged to form the other word.<p/>
 *
 * Given a string, split it into two contiguous substrings of equal
 * length. Determine the minimum number of characters to change to
 * make the two substrings into anagrams of one another.<p/>
 *
 * <b>Example</b><br/>
 * s = abccde
 *
 * Break  into two parts: 'abc' and 'cde'. Note that all letters
 * have been used, the substrings are contiguous and their lengths
 * are equal. Now you can change 'a' and 'b' in the first substring
 * to 'd' and 'e' to have 'dec' and 'cde' which are anagrams. Two
 * changes were necessary.<p/>
 *
 * <b>Function Description</b><br/>
 * Complete the anagram function.
 * anagram has the following parameter(s):
 * <pre>
 * {@code string s: a string}
 * </pre>
 *
 * <b>Returns</b><br/>
 * <pre>
 * {@code
 * int: the minimum number of characters to change or -1.
 * }
 * </pre>
 *
 * <b>Constraints</b><br/>
 *
 *
 *  consists only of characters in the range ascii[a-z].
 */
class Anagram {

    static int execute(String s) {
        return solutionV1(s);
    }

    private static int solutionV1(String s) {
        // Design the algorithm here
        /*
         * If the length of string is odd number return -1.
         * Split the string into 2 character sub-arrays a and b. Iterate both
         * sub-arrays sequentially to count the occurrence of each character.
         * then use 2 hashmap (map a and b) to store the frequency count of each
         * character in the separated arrays.
         *
         * Since we only want to know the common characters found in both maps,
         * we simply compare map a with map b, for any character that exist in
         * both sub-array, it must also exist in both map a and map b, and the
         * smaller value of the 2 returned frequency counts is the common
         * characters count.
         *
         * The number of characters that need to be replaced is therefore the
         * length of the sub-array minus the total common characters count.
         *
         * For example:
         * x,a,x,b,b,b,x,x
         *
         * After split:
         * [x,a,x,b]
         * [b,b,x,x]
         *
         * Map a:
         * x...2
         * a...1
         * b...1
         *
         * Map b:
         * b...2
         * x...2
         *
         * After comparison, the common characters and their respective match count:
         * x = 2
         * b = 1
         *
         * The total number of matching characters in both sub-arrays = 2 + 1 = 3
         * The total number of characters that need to be replaced in both sub-arrays:
         * = 4 - 3 = 1
         *
         * Runtime complexity = O(N)
         * Space complexity = O(N)
         */
        // Write your code here
        if (s.length() % 2 != 0) return -1;

        char[] ch_a = s.substring(0, s.length()/2).toCharArray();
        char[] ch_b = s.substring(s.length()/2, s.length()).toCharArray();

        Map<Character, Integer> map_a = new HashMap<>();
        for (char c:ch_a) {
            int count = map_a.getOrDefault(c, 0);
            map_a.put(c, count+1);
        }

        Map<Character, Integer> map_b = new HashMap<>();
        for (char c:ch_b) {
            int count = map_b.getOrDefault(c, 0);
            map_b.put(c, count+1);
        }

        int matchCount = 0;

        for (char c:map_a.keySet()) {
            int count_a = map_a.getOrDefault(c, 0);
            int count_b = map_b.getOrDefault(c, 0);
            if (count_a > 0 && count_b > 0) {
                matchCount += Math.min(count_a, count_b);
                map_b.put(c, 0);
            }
        }

        for (char c:map_b.keySet()) {
            int count_a = map_a.getOrDefault(c, 0);
            int count_b = map_b.getOrDefault(c, 0);
            if (count_a > 0 && count_b > 0) {
                matchCount += Math.min(count_a, count_b);
                map_a.put(c, 0);
            }
        }

        return s.length()/2 - matchCount;
    }
}
