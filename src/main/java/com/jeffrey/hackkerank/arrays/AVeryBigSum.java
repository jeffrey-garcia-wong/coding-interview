package com.jeffrey.hackkerank.arrays;

import java.util.List;

class AVeryBigSum {

    static Long execute(List<Long> ar) {
        return solutionV1(ar);
    }

    /**
     * Complete the 'aVeryBigSum' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER_ARRAY ar as parameter.
     */
    private static Long solutionV1(List<Long> ar) {
        Long total = 0L;
        for (int i=0;i<ar.size(); i++) {
            System.out.println(ar.get(i));
            total += ar.get(i);
        }
        return total;
    }

}
