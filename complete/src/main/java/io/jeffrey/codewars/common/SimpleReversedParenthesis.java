package io.jeffrey.codewars.common;

import java.util.Stack;

/**
 * <h1>Simple reversed parenthesis</h1>
 *
 * Given a string, return the minimal number of parenthesis
 * reversals needed to make balanced parenthesis.<p/>
 *
 * For example:<br/>
 * <pre>
 * {@code
 * solve(")(") = 2 Because we need to reverse ")" to "(" and "(" to ")". These are 2 reversals.
 * solve("(((())") = 1 We need to reverse just one "(" parenthesis to make it balanced.
 * solve("(((") = -1 Not possible to form balanced parenthesis. Return -1.
 * }
 * </pre>
 *
 * Parenthesis will be either "(" or ")".<p/>
 */
public class SimpleReversedParenthesis {

    public static int execute(String s) {
        return solutionV1(s);
    }

    public static int solutionV1(String s) {
        if (s.length() % 2 != 0) return -1;
        char[] input = s.toCharArray();

        // first scan, remove of paired brackets ( and )
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<input.length; i++) {
            char c = input[i];
            switch (c) {
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.size()>0 && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                    break;
            }
        }

        // extract all the unbalanced brackets
        char[] unbalanced = new char[stack.size()];
        for (int i=unbalanced.length-1; i>=0; i--) {
            unbalanced[i] = stack.pop();
        }

        // second scan, find the minimal swap to form balanced brackets
        int left = 0;
        int right = unbalanced.length - 1;
        int swapCount = 0;
        while (left <= right) {
            if (unbalanced[left] != '(' && unbalanced[right] != ')') {
                swapCount += 2;
            } else {
                swapCount += 1;
            }
            left ++;
            right --;
        }
        return swapCount;
    }

}
