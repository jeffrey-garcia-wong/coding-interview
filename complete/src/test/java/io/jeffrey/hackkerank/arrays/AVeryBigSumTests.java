package io.jeffrey.hackkerank.arrays;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AVeryBigSumTests {

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
