package com.jeffrey.facebook;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTests {

    @Test
    public void sum() {
        Main m = new Main();
        assertEquals(3, m.sum(1, 2));
    }

}