package com.jeffrey.facebook.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>Matching Pairs</h1><p/>
 *
 * Given two strings s and t of length N, find the maximum number
 * of possible matching pairs in strings s and t after swapping
 * exactly two characters within s.<p/>
 *
 * A swap is switching s[i] and s[j], where s[i] and s[j] denotes
 * the character that is present at the ith and jth index of s,
 * respectively. The matching pairs of the two strings are defined
 * as the number of indices for which s[i] and t[i] are equal.<p/>
 *
 * <b>Note:</b>
 * This means you must swap two characters at different indices.<p/>
 *
 * <b>Signature</b>
 * <pre>
 * {@code
 * int matchingPairs(String s, String t)
 * }
 * </pre>
 *
 * <b>Input</b><br/>
 * <ul>
 *     <li>s and t are strings of length N</li>
 *     <li>N is between 2 and 1,000,000</li>
 * </ul>
 *
 * <b>Output</b><br/>
 * Return an integer denoting the maximum number of matching pairs.<p/>
 *
 * <b>Example 1</b>
 * <pre>
 * {@code
 * s = "abcd"
 * t = "adcb"
 * output = 4
 * }
 * </pre>
 *
 * <u>Explanation:</u><br/>
 * Using 0-based indexing, and with i = 1 and j = 3,
 * s[1] and s[3] can be swapped, making it "adcb".<p/>
 *
 * <b>Example 2</b><br/>
 * <pre>
 * {@code
 * s = "mno"
 * t = "mno"
 * output = 1
 * }
 * </pre>
 *
 * <u>Explanation:</u><br/>
 * Two indices have to be swapped, regardless of which two it is,
 * only one letter will remain the same. If i = 0 and j=1, s[0]
 * and s[1] are swapped, making s = "nmo", which shares only "o"
 * with t.
 */
class MatchingPairs {

    static int execute(String s, String t) {
        return solutionV1(s, t);
    }

    private static int solutionV1(String s, String t) {
        // Work out the strategy (algorithm)
        /*
        Questions to clarify,
        - can i = j?
        - can the same character in different position of s and t consider a match?
        - is s and t are with equal length?
        - what is the minimal size of s and t?
        Obviously the answer is zero.

        1st loop to identify max no. of matched pairs before swap, say X
        extract the un-matched pairs into sub-arrays.

        2nd loop to identify any possible match in the un-matched pairs sub-arrays, say Y,
        if Y==0, then result is X-2
        if Y>=1, then result is X+2
        */

        // Write your code here
        int matchesBeforeSwap = 0;

        List<Character> sList = new ArrayList<>();
        List<Character> tList = new ArrayList<>();

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) {
                matchesBeforeSwap++;
            } else {
                sList.add(s.charAt(i));
                tList.add(t.charAt(i));
            }
        }

        if (s.length()==1) return matchesBeforeSwap;

        Character[] sArray = new Character[sList.size()];
        sList.toArray(sArray);
        Arrays.sort(sArray);
        Character[] tArray = new Character[tList.size()];
        tList.toArray(tArray);
        Arrays.sort(tArray);

        int matchesFromSubArray = 0;
        for (int i=0; i<sArray.length; i++) {
            if (sArray[i] == tArray[i]) {
                matchesFromSubArray += 1;
            }
        }

        int maxMatchesAfterSwap = 0;
        if (matchesFromSubArray>0) {
            maxMatchesAfterSwap = matchesBeforeSwap + 2;
        } else {
            maxMatchesAfterSwap = matchesBeforeSwap - 2;
        }

        return Math.max(maxMatchesAfterSwap, 0);
    }
}
