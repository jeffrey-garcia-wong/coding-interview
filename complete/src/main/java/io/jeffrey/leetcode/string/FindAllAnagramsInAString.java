package io.jeffrey.leetcode.string;

import java.util.*;

/**
 * <h1>Find All Anagrams in a String</h1>
 *
 * Given two strings s and p, return an array of all the start indices
 * of p's anagrams in s. You may return the answer in any order.<p/>
 *
 * An Anagram is a word or phrase formed by rearranging the letters
 * of a different word or phrase, typically using all the original
 * letters exactly once.<p/>
 *
 * <b>Example 1:</b><br/>
 * <pre>
 * {@code
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * // Explanation:
 * // The substring with start index = 0 is "cba", which is an anagram of "abc".
 * // The substring with start index = 6 is "bac", which is an anagram of "abc".
 * }
 * </pre>
 *
 * <b>Example 2:</b><br/>
 * <pre>
 * {@code
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * // Explanation:
 * // The substring with start index = 0 is "ab", which is an anagram of "ab".
 * // The substring with start index = 1 is "ba", which is an anagram of "ab".
 * // The substring with start index = 2 is "ab", which is an anagram of "ab".
 * }
 * </pre>
 *
 * <b>Constraints:</b>
 * <ul>
 *     <li>1 <= s.length, p.length <= 3 * 104</li>
 *     <li>s and p consist of lowercase English letters.</li>
 * </ul>
 *
 */
public class FindAllAnagramsInAString {
    public static List<Integer> execute(String s, String p) {
        return solutionV1(s, p);
    }

    private static List<Integer> solutionV1(String s, String p) {
        String pSignature = getSignature(p);
        List<Integer> result = new LinkedList<>();
        Set<String> cache = new HashSet<>();

        int start = 0;
        while (start + p.length() <= s.length()) {
            String temp = s.substring(start, start+p.length());
            if (cache.contains(temp)) {
                result.add(start);
            } else {
                if (getSignature(temp).equals(pSignature)) {
                    cache.add(temp);
                    result.add(start);
                }
            }
            start += 1;
        }
        return result;
    }

    private static String getSignature(String input) {
        byte[] bytes = input.getBytes();
        Arrays.sort(bytes);
        return new String(bytes);
    }

}
