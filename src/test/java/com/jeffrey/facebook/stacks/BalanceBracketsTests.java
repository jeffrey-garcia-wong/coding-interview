package com.jeffrey.facebook.stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BalanceBracketsTests {

    @Test
    public void test_001() {
        assertTrue(BalanceBrackets.execute("{[()]}"));
    }

    @Test
    public void test_002() {
        assertTrue(BalanceBrackets.execute("{}()"));
    }

    @Test
    public void test_003() {
        assertFalse(BalanceBrackets.execute("{(})"));
    }

    @Test
    public void test_004() {
        assertFalse(BalanceBrackets.execute(")"));
    }
}
