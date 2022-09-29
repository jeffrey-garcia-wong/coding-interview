package com.jeffrey.hackkerank;

import java.util.List;

class PdfViewer {

    static int execute(List<Integer> h, String word) {
        return solutionV1(h, word);
    }

    /**
     * Complete the 'designerPdfViewer' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h
     *  2. STRING word
     */
    private static int solutionV1(List<Integer> list, String word) {
        // Write your code here
        int max = 1;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            int tmp = (int)c - (int)'a';
            if (list.get(tmp) > max) max = list.get(tmp);
            if (max >= 7) break;
        }
        return max * word.length();
    }

}
