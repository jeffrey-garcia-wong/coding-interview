package io.jeffrey.hackajob;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnglishClassroomTests {

    @Test
    public void test_001() {
        String input = "I";
        String output = EnglishClassroom.execute(false, input);
        assertEquals(input.toLowerCase(), EnglishClassroom.execute(true, output));
    }

    @Test
    public void test_002() {
        String input = "";
        String output = EnglishClassroom.execute(false, input);
        assertEquals(input, output);
    }

    @Test
    public void test_003() {
        String input = "  ";
        String output = EnglishClassroom.execute(false, input);
        assertEquals("      ", output);
    }

    @Test
    public void test_004() {
        String input = "  ";
        String output = EnglishClassroom.execute(true, input);
        assertEquals(EnglishClassroom.INVALID, output);
    }

    @Test
    public void test_005() {
        String input = ",";
        String output = EnglishClassroom.execute(false, input);
        assertEquals(EnglishClassroom.INVALID, output);
    }

    @Test
    public void test_006() {
        String input = "et ligula ullamcorper malesuada proin";
        String output = EnglishClassroom.execute(false, input);
        assertEquals(input, EnglishClassroom.execute(true, output));
    }

    @Test
    public void test_007() {
        String input = "nisl .tincidunt eget. nullam non nisi est";
        String output = EnglishClassroom.execute(false, input);
        assertEquals(input, EnglishClassroom.execute(true, output));
    }

    @Test
    public void test_008() {
        String input = " sit amet mauris commodo quis imperdiet massa tincidunt";
        String output = EnglishClassroom.execute(false, input);
        assertEquals(input, EnglishClassroom.execute(true, output));
    }

    @Test
    public void test_009() {
        String input = "pretium viverra suspendisse potenti nullam ac tortor vitae purus. ";
        String output = EnglishClassroom.execute(false, input);
        assertEquals(input, EnglishClassroom.execute(true, output));
    }

    @Test
    public void test_010() {
        String input = "enim nulla aliquet porttitor lacus. luctus accumsan tortor posuere ac.";
        String output = EnglishClassroom.execute(false, input);
        assertEquals(input, EnglishClassroom.execute(true, output));
    }

}
