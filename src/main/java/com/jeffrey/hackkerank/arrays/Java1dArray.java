package com.jeffrey.hackkerank.arrays;

import java.util.Arrays;
import java.util.Stack;

/**
 * Let's play a game on an array! You're standing at index 0 of an n-element array named game.<p/>
 *
 * From some index i ({@code 0<=i<n}), you can perform one of the following moves:
 * <ul>
 *      <li>Move Backward: If cell i-1 exists and contains a zero, you can walk back to cell i-1.</li>
 *      <li>
 *          Move Forward:
 *          <ul>
 *              <li>If cell i+1 contains a zero, you can walk to cell i+1.</li>
 *              <li>If cell i+leap contains a zero, you can jump to cell i+leap.</li>
 *              <li>
 *                  If you're standing in cell n-1 or the value of i+leap>=n, you can walk or
 *                  jump off the end of the array and win the game.
 *              </li>
 *          </ul>
 *      </li>
 * </ul>
 * In other words, you can move from index i to index i+1, i-1, or i+leap as long as the
 * destination index is a cell containing a zero. If the destination index is greater than n-1,
 * you win the game.
 * <p/>
 *
 * <b>Function Description</b><br/>
 * Complete the function in the editor below.
 * The function has the following parameters:
 * <ul>
 *     <li>{@code int leap}: the size of the leap</li>
 *     <li>{@code int game[n]}: the array to traverse</li>
 * </ul>
 *
 * <b>Returns</b><br/>
 * <ul><li>boolean: true if the game can be won, otherwise false</li></ul>
 *
 * <b>Constrains</b><br/>
 * <ul>
 *      <li>{@code 1<=q<=5000}</li>
 *      <li>{@code 2<=n<=100}</li>
 *      <li>{@code 0<=leap<=100}</li>
 * </ul>
 *
 * <b>Example</b>
 * <pre>
 * Function                                   | can win?
 * -------------------------------------------|----------
 * game = [0,0,0,0,0], size n = 5, leap = 3   | True
 * game = [0,0,0,1,1,1], size n = 6, leap = 5 | True
 * game = [0,0,1,1,1,0], size n = 6, leap = 3 | False
 * game = [0,1,0], size n = 3, leap = 1       | False
 * </pre>
 */
class Java1dArray {

    static boolean execute(int leap, int[] game) {
        return solutionV1(leap, game);
    }

    private static boolean solutionV1(int leap, int[] game) {
        // write your code here

        // Return true if you can win the game; otherwise, return false.
        int i = 0;
        boolean[] visited = new boolean[game.length];
        Arrays.fill(visited, false);

        // only 1 element and not zero, can't win
        if (game.length==1 && game[0]==1) return false;

        Stack<Integer> moves = new Stack<>();
        moves.push(i);

        while (!moves.isEmpty()) {
            i = moves.pop();

            // at the last element, win
            if (i==game.length-1) return true;

            // jump over the last element, win
            if ((i+leap)>=game.length) return true;

            if (game[i+1]==0 && !visited[i + 1]) {
                moves.push(i+1);
                visited[i+1] = true;
            }

            if (leap>0 && game[i+leap]==0 && !visited[i + leap]) {
                moves.push(i+leap);
                visited[i+leap] = true;
            }

            if (i>0 && game[i-1]==0 && !visited[i - 1]) {
                moves.push(i-1);
                visited[i-1] = true;
            }
        }
        return false;
    }
}
