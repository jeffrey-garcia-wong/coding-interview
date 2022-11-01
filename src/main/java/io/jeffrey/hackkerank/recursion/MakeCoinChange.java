package io.jeffrey.hackkerank.recursion;

import java.util.*;

/**
 * <h1>The Coin Change Problem</h1><p/>
 *
 * Given an amount and the denominations of coins available, determine
 * how many ways change can be made for amount. There is a limitless
 * supply of each coin type.<p/>
 *
 * <b>Example</b><br/>
 * <pre>
 * {@code
 * n = 3
 * c = [8,3,1,2]
 * }
 * </pre>
 * There are 3 ways to make change for n = 3:
 * {1,1,1}, {1,2} and {3}<p/>
 *
 * <b>Function Description</b><p/>
 * The function has the following parameter(s):
 * <ul>
 *     <li>int n: the amount to make change for</li>
 *     <li>int c[m]: the available coin denominations</li>
 * </ul>
 *
 * <b>Returns</b><br/>
 * <ul>
 *     <li>int: the number of ways to make change</li>
 * </ul>
 *
 * <b>Constraints</b><br/>
 * <ul>
 *     <li>1 <= c[i]</li>
 *     <li>1 <= n <= 250</li>
 *     <li>1 <= m <= 50</li>
 *     <li>each c[i] is guaranteed to be distinct</li>
 * </ul>
 *
 * <b>Hints</b><br/>
 * Solve overlapping subproblems using Dynamic Programming (DP).
 * You can solve this problem recursively but will not pass all
 * the test cases without optimizing to eliminate the overlapping
 * subproblems. Think of a way to store and reference previously
 * computed solutions to avoid solving the same subproblem multiple
 * times.<p/>
 *
 */
class MakeCoinChange {

    static int execute(int totalAmount, int[]coinDenom) {
        return solutionV1(totalAmount, coinDenom, 0, new HashMap<>());
    }

    private static int solutionV1(
            int targetAmount,
            int[] coinDenom,
            int coinDenomIdx,
            Map<String,Integer> patterns
    ) {
        // Design the algorithm here
        /*
        Assumption:
        The denominations are sorted in descending order based on the face value.

        Subtract each of the denominations from the target amount individually,
        - if the remaining amount == 0, increment the match counter by 1
        - if the remaining amount > 0, repeat the subtraction process but only with
        the denomination equal and smaller than the current denomination

        The strategy can be illustrated with below example:
        target amount = 5
        coins denomination = {5,2,1}

        5-5=0 (match)
        5-2=3
            |--> 3-2=1
            |        |--> 1-2=-1
            |        |--> 1-1=0 (match)
            |
            |--> 3-1=2
                     |--> 2-1=1
                              |--> 1-1=0 (match)
        5-1=4
            |--> 4-1=3
                     |--> 3-1=2
                              |--> 2-1=1
                                       |--> 1-1=0 (match)

        Follows the path from left to right till destination is 0, we can observe the
        following denomination pattern that produce the target value 5
        5 -> 5
        5 -> 2,2,1
        5 -> 2,1,1,1
        5 -> 1,1,1,1,1

        Clearly this can be programmed recursively, the example above however is too
        small due to its target amount, no repeated patterns are seen from the paths,
        but with large enough amount, we are expected to encounter repeated patterns
        and to avoid repeated processing to save time, we can use additional memory
        to store for any previous patterns that has been seen for a particular amount
        and denominations. This optimization can drastically improve performance.
         */
        int matchCounter = 0;

        // performance optimization
        String key = targetAmount + "-" + coinDenomIdx;
        if (patterns.containsKey(key)) return patterns.get(key);

        for (int i=coinDenomIdx; i<coinDenom.length; i++) {
            int remainingAmount = targetAmount - coinDenom[i];
            if (remainingAmount == 0) matchCounter += 1;
            if (remainingAmount > 0) matchCounter += solutionV1(remainingAmount, coinDenom, i, patterns);
        }

        patterns.put(key, matchCounter);
        return matchCounter;
    }

}
