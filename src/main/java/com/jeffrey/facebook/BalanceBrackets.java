package com.jeffrey.facebook;

import java.util.Stack;

/**
 * <h1>Balance Brackets</h1><p/>
 *
 * A bracket is any of the following characters: (, ), {, }, [, or ].<p/>
 *
 * We consider two brackets to be matching if the first bracket is an open-bracket,
 * e.g., (, {, or [, and the second bracket is a close-bracket of the same type.
 * That means ( and ), [ and ], and { and } are the only pairs of matching brackets.<p/>
 *
 * Furthermore, a sequence of brackets is said to be balanced
 * if the following conditions are met:
 * <ul>
 *     <li>The sequence is empty, or</li>
 *     <li>The sequence is composed of two or more non-empty sequences,
 *     all of which are balanced, or</li>
 *     <li>The first and last brackets of the sequence are matching,
 *     and the portion of the sequence without the first and last elements
 *     is balanced.</li>
 * </ul>
 * You are given a string of brackets. Your task is to determine whether
 * each sequence of brackets is balanced. If a string is balanced, return
 * true, otherwise, return false.<p/>
 *
 * <b>Signature</b>
 * <pre>
 * {@code
 * bool isBalanced(String s)
 * }
 * </pre>
 *
 * <b>Input</b><br/>
 * String s with length between 1 and 1000<p/>
 *
 * <b>Output</b><br/>
 * A boolean representing if the string is balanced or not<p/>
 *
 * <b>Example 1</b><br/>
 * <pre>
 * {@code
 * s = {[()]}
 * output: true
 * }
 * </pre>
 *
 * <b>Example 2</b><br/>
 * <pre>
 * {@code
 * s = {}()
 * output: true
 * }
 * </pre>
 *
 * <b>Example 3</b><br/>
 * <pre>
 * {@code
 * s = {(})
 * output: false
 * }
 * </pre>
 *
 * <b>Example 4</b><br/>
 * <pre>
 * {@code
 * s = )
 * output: false
 * }
 * </pre>
 */
class BalanceBrackets {

    static boolean execute(String s) {
        return solutionV1(s);
    }

    private static boolean solutionV1(String s) {
        Stack<String> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            String tmp = s.substring(i,i+1);

            if (tmp.equals("(") || tmp.equals("{") || tmp.equals("[")) {
                stack.push(tmp);
            } else {
                switch (tmp) {
                    case ")":
                        if (!stack.isEmpty() && stack.peek().equals("(")) {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                    case "}":
                        if (!stack.isEmpty() && stack.peek().equals("{")) {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                    case "]":
                        if (!stack.isEmpty() && stack.peek().equals("[")) {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                    default:
                        break;
                }
            }
        }

        return stack.isEmpty();
    }
}
