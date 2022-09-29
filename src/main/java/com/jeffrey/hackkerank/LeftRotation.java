package com.jeffrey.hackkerank;

import java.util.ArrayList;
import java.util.List;

class LeftRotation {

    static List<Integer> solution(List<Integer> list, int shift) {
        return solutionV1(list, shift);
    }

    /**
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d
     */
    private static List<Integer> solutionV1(List<Integer> list, int shift) {
        // Write your code here
        List<Integer> output = new ArrayList<>(list);
        for (int i=list.size()-1; i>=0; i--) {
            int tmp = list.get(i);
            int pos = (i-shift)>=0 ? (i-shift) : (i-shift) + list.size();
            output.set(pos, tmp);
        }
        return output;
    }

}
