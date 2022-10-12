package com.jeffrey.facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>Minimum Length Substrings</h1><p/>
 *
 * You are given two strings s and t. You can select any substring of
 * string s and rearrange the characters of the selected substring.
 * Determine the minimum length of the substring of s such that string
 * t is a substring of the selected substring.<p/>
 *
 * <b>Signature</b><br/>
 * <pre>
 * {@code
 * int minLengthSubstring(String s, String t)
 * }
 * </pre>
 *
 * <b>Input</b><br/>
 * s and t are non-empty strings that contain less than 1,000,000 characters each.<p/>
 *
 * <b>Output</b><br/>
 * Return the minimum length of the substring of s. If it is not possible, return -1<p/>
 *
 * <b>Example</b><br/>
 * <pre>
 * {@code
 * s = "dcbefebce"
 * t = "fd"
 * output = 5
 * }
 * </pre>

 * <b>Explanation:</b><br/>
 * Substring "dcbef" can be rearranged to "cfdeb", "cefdb", and so on.
 * String t is a substring of "cfdeb". Thus, the minimum length required is 5.<p/>
 */
class MinimumLengthSubstrings {

    static int execute(String s, String t) {
        return solutionV2(s, t);
    }

    private static int solutionV2(String s, String t) {
        // write the algorithm here
        /*
        See the algorithm description in v1.

        This implementation uses the same rolling window strategy as in v1,
        except that we implement the search routine differently with the usage
        of 2 HashMaps.

        The first HashMap stores every unique characters in t and its respective
        counter, while the second HashMap stores the current search result from s.

        For example:
        if t = [x,y,z,z], the first HashMap would be
        key  | value
        =============
        x    | 1
        y    | 1
        z    | 2
        =============

        if current search portion of s = [a,v,x,z,f], the second HashMap would be
        key  | value
        =============
        a    | 1
        v    | 1
        x    | 1
        z    | 1
        f    | 1
        =============

        For each element in s, the search for a match in t is only O(1) thanks
        to the HashMap, therefore the search no longer requires 2 loops, instead
        we compromised space complexity to 2*O(N) while improving the time complexity
        to O(N).

        */

        // write the code here
        int left = 0;
        int right = 0;
        int minLength = -1;
        int allMatchCounter = 0;

        Map<Character, Integer> tMap = new HashMap<>();
        for (int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);
            int count = tMap.getOrDefault(ch, 0);
            tMap.put(ch, count+1);
        }
        final int expectedMatchCounter = tMap.size();

        Map<Character, Integer> sMap = new HashMap<>();

        while (right < s.length()) {
            char ch = s.charAt(right);
            int count = sMap.getOrDefault(ch, 0);
            sMap.put(ch, count + 1);

            if (tMap.containsKey(ch) && tMap.get(ch).intValue()==sMap.get(ch).intValue()) {
                allMatchCounter += 1;
            }

            while (left<=right && allMatchCounter==expectedMatchCounter) {
                int currLength = right - left + 1;
                if (minLength == -1) {
                    minLength = currLength;
                } else {
                    if (currLength < minLength) minLength = currLength;
                }

                char _ch = s.charAt(left);
                int _count = sMap.get(_ch);
                sMap.put(_ch, _count-1);

                if (tMap.containsKey(_ch) && tMap.get(_ch) > sMap.get(_ch)) {
                    allMatchCounter -= 1;
                }
                left ++;
            }

            right ++;
        }

        return minLength;
    }

    private static int solutionV1(String s, String t) {
        // Write the algorithm here
        /*
        Search every element of t in every element of s sequentially,
        there are 2 possibilities:
        a) after the search is exhausted, t is not found
        b) t is found and the search is halted (there maybe remaining elements in s)

        When t is said to be found, the left-most and right-most character in the
        sub-array will be used to determine the length of the sub-array.

        The first problem of this strategy is because even if t is found,
        the result may not be optimal because there maybe a shorter matching
        sub-array that exist in the remaining elements in s.

        To resolve this problem, we need a rolling window strategy, which keeps on
        searching the remaining of s for shorter matching sub-arrays. For example
        if the search of t (x,y) is first found in s (x,a,y,d,e,x,y,f) at index 0
        and 2 respectively which span across 3 elements, but there exist another
        pair of (x,y) at index 5 and 6 which span across only 2 elements, with a
        rolling window strategy, the initial search result at index 0 and 2 is
        rolled progressively by increment the right index by 1 to 3, if t can still
        be found within this range, we increment the left index by 1 to 1, so a new
        sub-array can be examined, then we re-apply the search routine (search
        every element of t in every element of s sequentially, instead of searching
        through entire s, we search a portion of it from index 1 to 3, if t can't
        be found this time within the new range, we increment the right index by 1
        again, and the rest is just repeating the search depends on whether t can
        be found or not, until the right index is finally at the end position of s,
        implying the search is over. Now for each successive search of t, we calculate
        the length of the sub-array and compare with the previous value, replacing the
        previous value only if the new length is shorter.

        The second problem of this strategy is due to the search routine, which searches
        every element of t in every element of s, resulting in a runtime performance of
        O(N*M), although precisely for each rolling window we might only be searching a
        portion of s, if t is never found in s, we still end-up searching through every
        element of s by t times.
        */

        // Write your code here
        if (s.length()==0 || t.length()==0) return -1;

        int left = 0;
        int right = 0;
        int minLength = -1;

        while (right<s.length()) {
            boolean allFound = true;
            char[] sArray = s.toCharArray();
            for (int i=0; i<t.length(); i++) {
                char ch = t.charAt(i);
                boolean found = false;
                for (int j=left; j<=right; j++) {
                    if (sArray[j]!=0 && ch==sArray[j]) {
                        sArray[j] = 0;
                        found = true;
                        break;
                    }
                }
                if (!found) allFound = false;
            }
            if (!allFound) {
                if (right < s.length()-1) {
                    right ++;
                } else {
                    return minLength;
                }
            } else {
                int currLength = right - left + 1;
                if (minLength == -1) {
                    // initial desirable window is found, start the rolling window algorithm
                    minLength = currLength;
                } else {
                    if (currLength < minLength) {
                        minLength = currLength;
                    }
                }
                left ++;
            }
        }

        return minLength;
    }

}
