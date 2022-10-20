package com.jeffrey.facebook.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>Change in a Foreign Currency</h1><p/>
 *
 * You likely know that different currencies have coins and bills of
 * different denominations. In some currencies, it's actually impossible
 * to receive change for a given amount of money. For example, Canada
 * has given up the 1-cent penny. If you're owed 94 cents in Canada,
 * a shopkeeper will graciously supply you with 95 cents instead since
 * there exists a 5-cent coin.<p/>
 *
 * Given a list of the available denominations, determine if it's possible
 * to receive exact change for an amount of money targetMoney. Both the
 * denominations and target amount will be given in generic units of that
 * currency.<p/>
 *
 * <b>Signature</b><br/>
 * <pre>
 * {@code
 * boolean canGetExactChange(int targetMoney, int[] denominations)
 * }
 * </pre>
 *
 * <b>Input</b><br/>
 * <pre>
 * {@code
 * 1 ≤ |denominations| ≤ 100
 * 1 ≤ denominations[i] ≤ 10,000
 * 1 ≤ targetMoney ≤ 1,000,000
 * }
 * </pre>
 *
 * <b>Output</b><br/>
 * Return true if it's possible to receive exactly targetMoney given
 * the available denominations, and false if not.<p/>
 *
 * <b>Example 1</b>
 * <pre>
 * {@code
 * denominations = [5, 10, 25, 100, 200]
 * targetMoney = 94
 * output = false
 * }
 * </pre>
 * Every denomination is a multiple of 5, so you can't
 * receive exactly 94 units of money in this currency.<p/>
 *
 * <b>Example 2</b>
 * <pre>
 * {@code
 * denominations = [4, 17, 29]
 * targetMoney = 75
 * output = true
 * }
 * </pre>
 * You can make 75 units with the denominations [17, 29, 29].<p/>
 */
class ChangeForeignCurrency {

    static boolean execute(int targetMoney, int[] denominations) {
        return canGetExactChange(targetMoney, denominations);
    }

    private static boolean canGetExactChange(int targetMoney, int[] denominations) {
        // Write your code here
        int matchCount = makeChange(targetMoney, denominations, 0, new HashMap<>());
        return matchCount>0 ? true:false;
    }

    // Add any helper functions you may need here
    private static int makeChange(int targetMoney, int[] denominations, int denomIdx, Map<String,Integer> patterns) {
        int matchCounter = 0;

        // performance optimization
        String key = targetMoney + "-" + denomIdx;
        if (patterns.containsKey(key)) return patterns.get(key);

        for (int i=denomIdx; i<denominations.length; i++) {
            int remaining = targetMoney - denominations[i];
            if (remaining == 0) matchCounter += 1;
            if (remaining > 0) matchCounter += makeChange(remaining, denominations, i, patterns);
        }

        patterns.put(key, matchCounter);

        return matchCounter;
    }
}
