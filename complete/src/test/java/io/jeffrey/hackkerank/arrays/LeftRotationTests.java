package io.jeffrey.hackkerank.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LeftRotationTests {

    @Test
    public void test_001() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        Assertions.assertEquals(Arrays.asList(5, 1, 2, 3, 4).toString(), LeftRotation.solution(input, 4).toString());
    }

}
