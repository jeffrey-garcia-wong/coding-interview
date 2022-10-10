package com.jeffrey.facebook;

/**
 * <h1>Rotational Cipher</h1><p/>
 *
 * One simple way to encrypt a string is to "rotate" every alphanumeric
 * character by a certain amount. Rotating a character means replacing
 * it with another character that is a certain number of steps away in
 * normal alphabetic or numerical order.<p/>
 *
 * For example, if the string {@code "Zebra-493?"} is rotated 3 places,
 * the resulting string is {@code "Cheud-726?"}. Every alphabetic character
 * is replaced with the character 3 letters higher (wrapping around from Z
 * to A), and every numeric character replaced with the character 3 digits
 * higher (wrapping around from 9 to 0). Note that the non-alphanumeric
 * characters remain unchanged.<p/>
 *
 * Given a string and a rotation factor, return an encrypted string.<p/>
 *
 * <b>Signature</b><br/>
 * <pre>
 * {@code
 * string rotationalCipher(string input, int rotationFactor)
 * }
 * </pre>
 *
 * <b>Input</b><br/>
 * <pre>
 * {@code
 * 1 <= |input| <= 1,000,000
 * 0 <= rotationFactor <= 1,000,000
 * }
 * </pre>
 *
 * <b>Output</b><br/>
 * Return the result of rotating input a number of times equal to
 * <pre>
 * {@code
 * rotationFactor
 * }
 * </pre>.
 *
 * <b>Example 1</b><br/>
 * <pre>
 * {@code
 * input = Zebra-493?
 * rotationFactor = 3
 * output = Cheud-726?
 * }
 * </pre>
 *
 * <b>Example 2</b><br/>
 * <pre>
 * {@code
 * input = abcdefghijklmNOPQRSTUVWXYZ0123456789
 * rotationFactor = 39
 * output = nopqrstuvwxyzABCDEFGHIJKLM9012345678
 * }
 * </pre>
 */
class RotationalCipher {

    static String execute(String input, int rotationalFactor) {
        return solutionV1(input, rotationalFactor);
    }

    private static String solutionV1(String input, int rotationFactor) {
        // Write your code here
        char [] ch = input.toCharArray();

        for (int i=0; i<ch.length; i++) {
            // 0-9 ASCII 48 - 57
            // A-Z ASCII 65 - 90
            // a-z ASCII 97 - 122
            int asciiVal = (int)ch[i];

            if (asciiVal>=48 && asciiVal<=57) {
                int newAsciiVal = ((asciiVal-48) + rotationFactor) % 10;
                ch[i] = (char)(48 + newAsciiVal);
            }

            if (asciiVal>=65 && asciiVal<=90) {
                int newAsciiVal = ((asciiVal-65) + rotationFactor) % 26;
                ch[i] = (char)(65 + newAsciiVal);
            }

            if (asciiVal>=97 && asciiVal<=122) {
                int newAsciiVal = ((asciiVal-97) + rotationFactor) % 26;
                ch[i] = (char)(97 + newAsciiVal);
            }
        }

        return String.valueOf(ch);
    }
}
