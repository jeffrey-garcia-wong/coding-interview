package io.jeffrey.facebook.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotationalCipherTests {

    @Test
    public void test_001() {
        String s = "abcdefghijklmNOPQRSTUVWXYZ0123456789";
        Assertions.assertEquals("nopqrstuvwxyzABCDEFGHIJKLM9012345678",
                RotationalCipher.execute(s, 39));
    }

    @Test
    public void test_002() {
        String s = "All-convoYs-9-be:Alert1.";
        assertEquals("Epp-gsrzsCw-3-fi:Epivx5.",
                RotationalCipher.execute(s, 4));
    }

    @Test
    public void test_003() {
        String s = "abcdZXYzxy-999.@";
        assertEquals("stuvRPQrpq-999.@",
                RotationalCipher.execute(s, 200));
    }

}
