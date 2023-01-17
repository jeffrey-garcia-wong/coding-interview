package io.jeffrey.core.maths;

import org.junit.jupiter.api.Test;

import static io.jeffrey.core.maths.Factorial.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTests {

    @Test
    public void test1() {
        assertEquals(1, execute(0));
    }

    @Test
    public void test2() {
        assertEquals(1, execute(1));
    }

    @Test
    public void test3() {
        assertEquals(2, execute(2));
    }

    @Test
    public void test4() {
        assertEquals(24, execute(4));
    }

    @Test
    public void test5() {
        assertEquals(1409286144, execute(30));
    }
}
