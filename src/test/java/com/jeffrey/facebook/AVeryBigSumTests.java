package com.jeffrey.facebook;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AVeryBigSumTests {

    @Test
    public void test() {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int c = a + b;
        System.out.println(c);
    }

    @Test
    public void test001() {
        List<Long> longList = new ArrayList<>();
        longList.add((long) Integer.MAX_VALUE);
        longList.add((long) Integer.MAX_VALUE);
        longList.add((long) Integer.MAX_VALUE);
        Long result = AVeryBigSum.execute(longList);
        assertEquals(6442450941L, result);
    }

}
