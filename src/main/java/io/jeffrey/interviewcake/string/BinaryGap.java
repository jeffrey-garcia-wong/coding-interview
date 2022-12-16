package io.jeffrey.interviewcake.string;

/**
 * <h1>Binary Gap</h1>
 *
 * A binary gap within a positive integer N is any maximal
 * sequence of consecutive zeros that is surrounded by ones
 * at both ends in the binary representation of N.<p/>
 *
 * For example, number 9 has binary representation 1001 and
 * contains a binary gap of length 2. The number 529 has
 * binary representation 1000010001 and contains two binary
 * gaps: one of length 4 and one of length 3. The number 20
 * has binary representation 10100 and contains one binary
 * gap of length 1. The number 15 has binary representation
 * 1111 and has no binary gaps. The number 32 has binary
 * representation 100000 and has no binary gaps.<p/>
 *
 * Write a function:
 * <pre>
 * {@code
 * class Solution { public int solution(int N); }
 * }
 * </pre>
 * that, given a positive integer N, returns the length of
 * its longest binary gap. The function should return 0 if
 * N doesn't contain a binary gap.
 *
 * For example, given N = 1041 the function should return 5,
 * because N has binary representation 10000010001 and so its
 * longest binary gap is of length 5. Given N = 32 the function
 * should return 0, because N has binary representation '100000'
 * and thus no binary gaps.<p/>
 *
 * Write an efficient algorithm for the following assumptions:
 * <ul>
 *     <li>
 *         N is an integer within the range [1..2,147,483,647].
 *     </li>
 * </ul>
 *
 */
class BinaryGap {
    static int execute(int N) {
        return solutionV1(N);
    }

    static int solutionV1(int N) {
        // Design the algorithm here
        /*
         * Convert the integer into a binary string,
         * then iterate every digit in the binary string,
         * if its '0' then increment the counter by 1, if
         * its '1' then evaluate whether counter is larger
         * than max, if yes then update the max value as
         * counter and then reset counter to 0
         */

        // Write the code here
        int counter = 0;
        int max = 0;
        String binaryString = Integer.toBinaryString(N);
        for (int i=0; i<binaryString.length(); i++) {
            char digit = binaryString.charAt(i);
            if (digit == '0') {
                counter += 1;
            } else {
                max = Math.max(max, counter);
                counter = 0;
            }
        }
        return max;
    }
}
