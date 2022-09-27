package com.jeffrey.facebook;

import java.util.List;

public class AVeryBigSum {

    public static Long execute(List<Long> ar) {
        return solutionV1(ar);
    }

    private static Long solutionV1(List<Long> ar) {
        Long total = 0L;
        for (int i=0;i<ar.size(); i++) {
            System.out.println(ar.get(i));
            total += ar.get(i);
        }
        return total;
    }

}
