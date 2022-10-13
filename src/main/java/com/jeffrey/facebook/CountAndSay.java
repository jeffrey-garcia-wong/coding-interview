package com.jeffrey.facebook;

/**
 * <h1>Problem Description</h1><p/>
 *
 * The count-and-say sequence is the sequence of integers beginning as follows:<br/>
 * <pre>
 * {@code
 * 1, 11, 21, 1211, 111221, ...
 * }
 * </pre>
 * 1 is read off as one 1 or 11. 11 is read off as two 1s or 21.<br/>
 * 21 is read off as one 2, then one 1 or 1211.<p/>
 *
 * Given an integer n, generate the nth sequence.<br/>
 * <i>Note: The sequence of integers will be represented as a string.</i><p/>
 *
 * <b>Example:</b><br/>
 * if n = 2, the sequence is 11.
 */
class CountAndSay {

    static String execute(int A) {
        return solutionV1(A);
    }

    private static String solutionV1(int A) {
        // Design the algorithm here
        /*
        Questions to ask:
        - what is the maximum sequence? will it be 0?

        For each sequence, scan every element of the input,
        compare the next element with the last element, if
        they are the same increment a local counter, if
        they are not the same write the previous element
        with its counter and append to the sequence output.

        Once the input elements are fully scanned, increment
        the sequence number, if the sequence number is smaller
        than the required sequence, assign the last output to
        become the input then repeat the process again until
        the sequence number reached the required sequence.
         */

        // Write the code here
        int sequence = 1;
        String input = "1";

        while (sequence < A) {
            char c = (int)0;
            int cCount = 0;
            StringBuilder output = new StringBuilder();

            for (int i=0; i<input.length(); i++) {
                if (c == input.charAt(i)) {
                    cCount += 1;
                } else {
                    if (c != (int)0) {
                        output.append(cCount).append(c);
                    }
                    c = input.charAt(i);
                    cCount = 1;
                }
            }

            output.append(cCount).append(c);
            input = output.toString();
            sequence += 1;
        }

        return input;
    }
}
