package io.jeffrey.interviewcake.stacks;

import org.junit.jupiter.api.Test;

import static io.jeffrey.interviewcake.stacks.StoneWalls.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoneWallsTests {

    @Test
    public void test_001() {
        assertEquals(7, execute(new int[] {8,8,5,7,9,8,7,4,8}));
    }

    @Test
    public void test_002() {
        assertEquals(2, execute(new int[] {5,6,5}));
    }

    @Test
    public void test_003() {
        assertEquals(9, execute(new int[] {2,3,4,5,6,7,8,9,1}));
    }

}
