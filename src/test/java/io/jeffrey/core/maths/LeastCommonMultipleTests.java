package io.jeffrey.core.maths;

import org.junit.jupiter.api.Test;

import static io.jeffrey.core.maths.LeastCommonMultiple.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeastCommonMultipleTests {

    @Test
    public void test_001() {
        int a = 8404;
        int b = 141237625;
        assertEquals(1186961000500l, execute(a,b));
    }

}
