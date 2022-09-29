package com.jeffrey.hackkerank;

import com.jeffrey.hackkerank.LeftRotation;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeftRotationTests {

    @Test
    public void test_001() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(Arrays.asList(5, 1, 2, 3, 4).toString(), LeftRotation.solution(input, 4).toString());
    }

}
