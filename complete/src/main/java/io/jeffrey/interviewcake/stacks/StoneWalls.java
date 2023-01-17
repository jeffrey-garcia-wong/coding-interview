package io.jeffrey.interviewcake.stacks;

import java.util.Stack;

public class StoneWalls {

    public static int execute(int[] H) {
        return solutionV1(H);
    }

    private static int solutionV1(int[] H) {
        Stack<Integer> s = new Stack<>();
        int count = 0;

        for (int i=0; i<H.length; i++) {
            while (s.size()>0 && H[i]<s.peek()) {
                s.pop();
            }

            if (s.empty()) {
                count += 1;
                s.push(H[i]);
                continue;
            }

            if (H[i]<s.peek()) {
                count += 1;
                s.push(H[i]);
            } else if (H[i]>s.peek()) {
                count += 1;
                s.push(H[i]);
            } else {
                // do nothing if H[i] == s.peek()
            }
        }

        return count;
    }

}
