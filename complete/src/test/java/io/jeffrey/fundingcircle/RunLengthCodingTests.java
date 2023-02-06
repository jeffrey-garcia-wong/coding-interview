package io.jeffrey.fundingcircle;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.concurrent.TimeUnit;

import static io.jeffrey.fundingcircle.RunLengthCoding.decode;
import static io.jeffrey.fundingcircle.RunLengthCoding.encode;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RunLengthCodingTests {

    @Test
    public void encodeEmpty() {
        assertEquals("", encode(""));
    }

    @Test
    public void encodeWithOnlySingleValues() {
        assertEquals("XYZ", encode("XYZ"));
    }

    @Test
    public void encodeWithNoSingleValues() {
        assertEquals(
                "2A3B4C",
                encode("AABBBCCCC"));
    }

    @Test
    public void encodeWithMixedValues() {
        assertEquals(
                "12WB12W3B24WB",
                encode("WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB"));
    }

    @Test
    public void encodeWithWhitespaceValues() {
        assertEquals(
                "2 hs2q q2w2 ",
                encode("  hsqq qww  "));
    }

    @Test
    public void encodeWithLowercaseValues() {
        assertEquals(
                "2a3b4c",
                encode("aabbbcccc"));
    }

    @Test
    public void decodeEmpty() {
        assertEquals("", decode(""));
    }

    @Test
    public void decodeWithOnlySingleValues() {
        assertEquals(
                "XYZ",
                decode("XYZ"));
    }

    @Test
    public void decodeWithNoSingleValues() {
        assertEquals(
                "AABBBCCCC",
                decode("2A3B4C"));
    }

    @Test
    public void decodeWithMixedValues() {
        assertEquals(
                "WWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB",
                decode("10WB12W3B24WB"));
    }

    @Test
    public void decodeWithWhitespaceValues() {
        assertEquals(
                "  hsqq qww  ",
                decode("2 hs2q q2w2 "));
    }

    @Test
    public void decodeWithLowercaseValues() {
        assertEquals(
                "aabbbcccc",
                decode("2a3b4c"));
    }

    @Execution(ExecutionMode.CONCURRENT)
    @RepeatedTest(100)
    @Timeout(unit = TimeUnit.MILLISECONDS, value = 10)
    public void encodeThenDecode() {
        String inOut = "zzz ZZ  zZ";
        String encoded = encode(inOut);
        assertEquals(inOut, decode(encoded));
    }
}
