package io.jeffrey.core.maths;

import org.junit.jupiter.api.Test;

import java.util.List;

import static io.jeffrey.core.maths.Factors.execute;
import static org.junit.jupiter.api.Assertions.*;

public class FactorsTests {

    private void check(int n, List<Integer> factors, int expectedSize) {
        assertEquals(expectedSize, factors.size());

        for (Integer factor : factors) {
            if (n % factor != 0) {
                fail(factor + " not a valid factor of " + n);
            }
        }
    }

    @Test
    public void test_001() {
        assertThrows(IllegalArgumentException.class, () -> execute(0) );
    }

    @Test
    public void test_002() {
        List<Integer> factors = execute(1);
        check(1, factors, 1);
    }

    @Test
    public void test_003() {
        List<Integer> factors = execute(36);
        check(36, factors, 9);
    }

    @Test
    public void test_004() {
        List<Integer> factors = execute(256);
        check(256, factors, 9);
    }
}
