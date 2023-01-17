package io.jeffrey.facebook.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChangeForeignCurrencyTests {

    @Test
    public void test_001() {
        assertFalse(ChangeForeignCurrency.execute(94, new int [] {5, 10, 25, 100, 200}));
    }

    @Test
    public void test_002() {
        assertTrue(ChangeForeignCurrency.execute(75, new int [] {4, 17, 29}));
    }
}
