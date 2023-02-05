package io.jeffrey.codewars.common;

import org.junit.jupiter.api.Test;

import static io.jeffrey.codewars.common.SimpleReversedParenthesis.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleReversedParenthesisTests {

    @Test
    public void basicTests(){
        assertEquals(2, execute(")()("));
        assertEquals(1, execute("((()"));
        assertEquals(-1, execute("((("));
        assertEquals(3, execute("())((("));
        assertEquals(4, execute(")()()))))()()("));
    }

}
