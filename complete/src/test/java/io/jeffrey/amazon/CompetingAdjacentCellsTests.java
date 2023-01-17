package io.jeffrey.amazon;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.jeffrey.amazon.CompetingAdjacentCells.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompetingAdjacentCellsTests {

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void test_001() {
        int[] input = new int[] {0};
        assertEquals(
                List.of(0).toString(),
                execute(input, 1).toString()
        );
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void test_002() {
        int[] input = new int[] {1};
        assertEquals(
                List.of(0).toString(),
                execute(input, 1).toString()
        );
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void test_003() {
        int[] input = new int[] {0,0,0};
        assertEquals(
                List.of(0,0,0).toString(),
                execute(input, 5).toString()
        );
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void test_004() {
        int[] input = new int[] {1,1,1};
        assertEquals(
                List.of(0,0,0).toString(),
                execute(input, 3).toString()
        );
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void test_005() {
        int[] input = new int[] {1,0,0,0,0,1,0,0};
        assertEquals(
                List.of(0,1,0,0,1,0,1,0).toString(),
                execute(input, 1).toString()
        );
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void test_006() {
        int[] input = new int[] {1,1,1,0,1,1,1,1};
        assertEquals(
                List.of(0,0,0,0,0,1,1,0).toString(),
                execute(input, 2).toString()
        );
    }

}
