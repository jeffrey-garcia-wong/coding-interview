package io.jeffrey.hackkerank.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PdfViewerTests {

    @Test
    public void test_001() {
        List<Integer> list = Arrays.asList(1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5);
        String word = "abc";
        Assertions.assertEquals(9, PdfViewer.execute(list, word));
    }

}
