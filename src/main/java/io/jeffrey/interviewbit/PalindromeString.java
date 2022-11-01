package io.jeffrey.interviewbit;

/**
 * <h1>Palindrome String</h1><p/>
 *
 * Given a string, determine if it is a palindrome. While checking
 * for a palindrome, you have to ignore spaces, case, and all special
 * characters; i.e. consider only alphanumeric characters.<p/>
 *
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem.<p/>
 *
 * Check the sample test case for reference.<p/>
 *
 * <b>Example 1</b><br/>
 * <u>Input:</u>
 * <pre>
 * {@code
 * "A man, a plan, a canal: Panama"
 * }
 * </pre>
 * <u>Output:</u><br/>
 * <pre>
 * {@code
 * 1
 * }
 * </pre>
 * <u>Explanation:</u><br/>
 * The input string after ignoring spaces, and all special characters
 * is "AmanaplanacanalPanama" which is a palindrome after ignoring the case.<p/>
 *
 * <b>Example 2</b><br/>
 * <u>Input:</u>
 * <pre>
 * {@code
 * "race a car"
 * }
 * </pre>
 * <u>Output:</u><br/>
 * <pre>
 * {@code
 * 0
 * }
 * </pre>
 * <u>Explanation:</u><br/>
 * The input string after ignoring spaces, and all special characters
 * is "raceacar" which is not a palindrome.
 */
class PalindromeString {

    static int execute(String A) {
        return solutionV1(A);
    }

    private static int solutionV1(String A) {
        // Design the algorithm here
        /*
        Questions to ask:
        - what is the expected length of the string?
        - what is considered to be special characters?
        - what about empty string?

        The strategy is to use a character array to represent the string,
        keep a left and right pointer at both end of the array then start
        comparison to see if their ascii value is equal, if the character
        addressed by the left pointer is a special character that should
        be ignored then we just increment the counter by 1 to skip it, or
        else if the character addressed by the right pointer should be
        ignored then we decrement the counter by 1.

        For each comparison if it's an un-match then we simply return 0,
        the process stops when the left counter exceed the right counter.

        The special case is to handle is when the string contains of odd
        number of characters where no palindrome exists and only the middle
        characters is a valid character to consider (i.e. "~b<"), in this
        case since the left (0) and right (2) are both invalid characters
        which will be ignored, the next comparison will consider left (1)
        and right (1) is a match and conclude the string is a palindrome
        when it isn't.
         */

        // write the code here
        if (A.length() == 1) return 1;

        int left = 0;
        int right = A.length() - 1;

        char [] arr = A.toCharArray();

        int matchingCharCount = 0;
        boolean unmatch = false;

        while (left <= right) {
            int leftAscii = (int)arr[left];
            int rightAscii = (int)arr[right];

            if (leftAscii<48 ||
                (leftAscii>57 && leftAscii<65) ||
                (leftAscii>90 && leftAscii<97) ||
                leftAscii>122
            ) {
                left++;
                continue;
            }

            if (rightAscii<48 ||
                (rightAscii>57 && rightAscii<65) ||
                (rightAscii>90 && rightAscii<97) ||
                rightAscii>122
            ) {
                right--;
                continue;
            }
//            System.out.println("comparing " + (char)leftAscii + " and " + (char)rightAscii);

            if (leftAscii>=97) {
                leftAscii = leftAscii - 97;
            } else {
                leftAscii = leftAscii - 65;
            }

            if (rightAscii>=97) {
                rightAscii = rightAscii - 97;
            } else {
                rightAscii = rightAscii - 65;
            }

            if (leftAscii == rightAscii) {
                matchingCharCount++;
//                System.out.println("offset " + leftAscii + " and " + rightAscii);
                left++;
                right--;
            } else {
                unmatch = true;
                break;
            }
        }

        if (!unmatch && matchingCharCount<=1) unmatch = true;
        return !unmatch ? 1:0;
    }
}
