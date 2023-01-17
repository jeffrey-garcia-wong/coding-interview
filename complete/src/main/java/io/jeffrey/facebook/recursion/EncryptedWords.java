package io.jeffrey.facebook.recursion;

/**
 * <h1>Encrypted Words</h1><p/>
 *
 * You've devised a simple encryption method for alphabetic strings that shuffles
 * the characters in such a way that the resulting string is hard to quickly read,
 * but is easy to convert back into the original string.<p/>
 *
 * When you encrypt a string S, you start with an initially-empty resulting string
 * R and append characters to it as follows:
 * <ul>
 *     <li>Append the middle character of S (if S has even length, then we define the
 *     middle character as the left-most of the two central characters)</li>
 *     <li>Append the encrypted version of the substring of S that's to the left of
 *     the middle character (if non-empty)</li>
 *     <li>Append the encrypted version of the substring of S that's to the right of
 *     the middle character (if non-empty)</li>
 * </ul>
 *
 * For example, to encrypt the string "abc", we first take "b", and then append the
 * encrypted version of "a" (which is just "a") and the encrypted version of "c"
 * (which is just "c") to get "bac".<p/>
 *
 * If we encrypt "abcxcba" we'll get "xbacbca". That is, we take "x" and then append
 * the encrypted version "abc" and then append the encrypted version of "cba".<p/>
 *
 * <b>Input</b><br/>
 * S contains only lower-case alphabetic characters
 * <pre>
 * {@code 1 <= |S| <= 10,000}
 * </pre>
 *
 * <b>Output</b><br/>
 * Return string R, the encrypted version of S.
 *
 * <b>Example 1</b><br/>
 * <pre>
 * {@code
 * S = "abc"
 * R = "bac"
 * }
 * </pre>
 *
 * <b>Example 2</b><br/>
 * <pre>
 * {@code
 * S = "abcd"
 * R = "bacd"
 * }
 * </pre>
 *
 * <b>Example 3</b><br/>
 * <pre>
 * {@code
 * S = "abcxcba"
 * R = "xbacbca"
 * }
 * </pre>
 *
 * <b>Example 4</b><br/>
 * <pre>
 * {@code
 * S = "facebook"
 * R = "eafcobok"
 * }
 * </pre>
 */
class EncryptedWords {

    static String execute(String input) {
        return solutionV1(input);
    }

    static String solutionV1(String input) {
        // Design the algorithm here
        /*
        The solution starts with finding the middle character
        and split the string into 2 substrings: left and right.
        This process repeats on the left substring then to the
        right substring. Eventually when the substring is reduced
        to either empty or one character only, the split exhausted.

        The encrypted (scrambled) result string is initially emptied.
        The middle character of the input string is first extracted and
        appended to the result string, this happens as the split process
        repeats on both left and right substrings until the length of the
        substring is reduced to 1, the last character that remains will
        then be appended to the result string.

        Since this solution is guaranteed to split the input into 2
        equals half, for a problem of size 8 it will only take 3 split
        operations to reduce the problem size to 1 (split exhausted),
        therefore accounting a time complexity of O(Log N), and the same
        space complexity for the maximum call stack in recursion.
         */

        // Write your code here
        if (input.length() == 0) return "";
        if (input.length() == 1) return input;

        int split = 0;
        int l = 0;
        int r = 0;
        if ((input.length() & 1) == 0) {
            split = input.length()/2;
            l = split-1;
            r = split;
        } else {
            split = input.length()/2;
            l = split;
            r = split+1;
        }

        String output = input.substring(l, r);
        output += solutionV1(input.substring(0, l));
        output += solutionV1(input.substring(r, input.length()));
        return output;
    }
}
