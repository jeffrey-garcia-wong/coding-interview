package com.jeffrey.facebook;

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
        return solutionV1(s, t);
    }

    private static int solutionV1(String s, String t) {
        if (s.length()==0 || t.length()==0) return -1;

        int left = 0;
        int right = 0;
        int minLength = -1;

        while (left<s.length() && right<s.length()) {
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
