package io.jeffrey.interviewcake;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static io.jeffrey.interviewcake.MaxCounters.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxCountersTests {

    @Test
    public void test_001() {
        assertEquals(
                Arrays.toString(new int[] {3,2,2,4,2}),
                Arrays.toString(execute(5, new int[] {3,4,4,6,1,4,4}))
        );
    }

}
