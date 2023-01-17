package io.jeffrey.core.maths;

import org.junit.jupiter.api.Test;

import static io.jeffrey.core.maths.GreatestCommonDivisor.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreatestCommonDivisorTests {

    @Test
    public void test1() {
        int a = 0;
        int b = 21;
        assertEquals(b, execute(a,b));
    }

    @Test
    public void test2() {
        int a = 17;
        int b = 0;
        assertEquals(a, execute(a,b));
    }

    @Test
    public void test3() {
        int a = 0;
        int b = 0;
        assertEquals(a, execute(a,b));
    }

    @Test
    public void test4() {
        int a = 27;
        int b = 6;
        assertEquals(3, execute(a,b));
    }

    @Test
    public void test5() {
        int a = 99;
        int b = 55;
        assertEquals(11, execute(a,b));
    }

    @Test
    public void test6() {
        int a = 5;
        int b = 7;
        assertEquals(1, execute(a,b));
    }

    @Test
    public void test7() {
        int a = 10;
        int b = 6;
        assertEquals(2, execute(a,b));
    }

    @Test
    public void test8() {
        int a = 11;
        int b = 17;
        assertEquals(1, execute(a,b));
    }

}
