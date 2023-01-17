package io.jeffrey.interviewcake.arrays;

import org.junit.jupiter.api.Test;

import static io.jeffrey.interviewcake.arrays.OddOccurrenceInArray.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OddOccurrenceInArrayTests {

    @Test
    public void test_001() {
        int[] input = {9, 3, 9, 3, 9, 7, 9};
        assertEquals(7, execute(input));
    }

}
