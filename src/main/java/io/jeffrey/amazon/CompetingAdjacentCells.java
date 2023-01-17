package io.jeffrey.amazon;

import java.util.LinkedList;
import java.util.List;

/**
 * <h1>Competing Adjacent Cells</h1>
 * Eight houses, represented as cells, are arranged in straight line.
 * Each day every cell competes with its adjacent cells (neighbors).<p/>
 *
 * An integer value of 1 represents an active cell and a value of 0
 * represents an inactive cell. If the neighbors on both the sides
 * of a cell are either active or inactive, the cell becomes inactive
 * on the next day; otherwise the cell become active.<p/>
 *
 * The two cells on each end have a single adjacent cell, so assume
 * that the unoccupied space on the opposite side is an inactive cell.
 * Even after updating the cell state, consider its previous state
 * when updating the state of other cells. The state information of
 * all cells should be updated simultaneously.<p/>
 *
 * Write an algorithm to output the state of the cells after the
 * given number of days.<p/>
 *
 * <b>Input</b>
 * The input to the function/method consists of two arguments:
 * <pre>
 * {@code
 * states, a list of integers representing the current state of cells;
 * days, an integer representing the number of days.
 * }
 * </pre>
 *
 * <b>Output</b>
 * <pre>
 * {@code
 * Return a list of integers representing the state of the cells after the given number of days.
 * }
 * </pre>
 *
 * <b>Note</b>
 * The elements of the list states contains 0s and 1s only.
 */
public class CompetingAdjacentCells {

    public static List<Integer> execute(int[] input, int days) {
        return solutionV1(input, days);
    }

    public static List<Integer> solutionV1(int[] input, int days) {
        /* Design the algorithm here
         *
         * Bitwise Operations for XOR
         * (1,0) -> 1
         * (0,1) -> 1
         * (1,1) -> 0
         * (0,0) -> 0
         *
         * 1. loop through every element in the input array
         * 2. for each element at position i, use bitwise
         *    operator XOR to compute the result for adjacent
         *    cells, store the result in the same position of
         *    the output array
         * 3. if there are more than 1 days, repeat from step 1
         * 4. swap the input reference to the output, and create
         *    a new output array
         * 5. when computation of all the days are finished
         *    convert the output array into list
         *
         * Performance:
         * Time complexity = O(N * M) + O(N), where N is the number
         * of elements and M is the number of days
         * Space complexity = O(N) for additional storage of the output
         */

        // Write the code here
        if (input.length == 1) return List.of(0);

        int[] output = new int[input.length];
        for (int i=0; i<days; i++) {
            if (i > 0) {
                input = output;
                output = new int[output.length];
            }
            for (int j=0; j<input.length; j++) {
                if (j == 0) {
                    output[j] = input[j+1];
                } else if (j == input.length - 1) {
                    output[j] = input[j-1];
                } else {
                    output[j] = input[j-1] ^ input[j+1];
                }
            }
        }

        List<Integer> result = new LinkedList<>();
        for (int e : output) {
            result.add(e);
        }
        return result;
    }

}
