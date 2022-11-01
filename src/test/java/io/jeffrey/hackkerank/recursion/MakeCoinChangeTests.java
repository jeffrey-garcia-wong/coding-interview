package io.jeffrey.hackkerank.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MakeCoinChangeTests {

    @Test
    public void test_001() {
        int amount = 5;
        int[] coinDenoms = {5};
        assertEquals(1, MakeCoinChange.execute(amount, coinDenoms));
    }

    @Test
    public void test_002() {
        int amount = 3;
        int[] coinDenoms = {2,1};
        assertEquals(2, MakeCoinChange.execute(amount, coinDenoms));
    }

    @Test
    public void test_003() {
        int amount = 5;
        int[] coinDenoms = {5,2,1};
        assertEquals(4, MakeCoinChange.execute(amount, coinDenoms));
    }

    @Test
    public void test_004() {
        int amount = 10;
        int[] coinDenoms = {5,2,1};
        assertEquals(10, MakeCoinChange.execute(amount, coinDenoms));
    }

    @Test
    public void test_005() {
        int amount = 3;
        int[] coinDenoms = {8,3,1,2};
        assertEquals(3, MakeCoinChange.execute(amount, coinDenoms));
    }

    @Test
    public void test_006() {
        int amount = 4;
        int[] coinDenoms = {1,2,3};
        assertEquals(4, MakeCoinChange.execute(amount, coinDenoms));
    }

    @Test
    public void test_007() {
        int amount = 10;
        int[] coinDenoms = {2,5,3,6};
        assertEquals(5, MakeCoinChange.execute(amount, coinDenoms));
    }
}
