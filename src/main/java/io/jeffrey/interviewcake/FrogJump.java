package io.jeffrey.interviewcake;

public class FrogJump {

    public static int execute(int X, int Y, int D) {
        return solutionV2(X, Y, D);
    }

    private static int solutionV2(int X, int Y, int D) {
        /* Design the algorithm here
         * Improve v1 running time to O(1), use basic
         * division and modulus operation.
         */

        // Write the code here
        int gap = Y - X;
        return gap % D == 0 ? gap/D : (gap/D) + 1;
    }

    private static int solutionV1(int X, int Y, int D) {
        /* Design the algorithm here
         * Keep subtracting D from the gap and increment the
         * step count until gap is reduced to <= 0
         * Problem with this algorithm is that the running
         * time will be O(Y-X)
         */

        // Write the code here
        int gap = Y - X;
        int step = 0;
        while (gap > 0) {
            gap -= D;
            step += 1;
        }
        return step;
    }
}
