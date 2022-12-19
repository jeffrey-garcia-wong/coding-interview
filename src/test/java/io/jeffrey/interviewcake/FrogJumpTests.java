package io.jeffrey.interviewcake;

import org.junit.jupiter.api.Test;

import static io.jeffrey.interviewcake.FrogJump.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrogJumpTests {

    @Test
    public void test_001() {
        assertEquals(3, execute(10, 85, 30));
    }

}
