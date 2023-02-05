package io.jeffrey.leetcode.string;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindAllAnagramsInAString {

    public static List<Integer> execute(String s, String p) {
        String pSignature = getSignature(p);
        List<Integer> result = new LinkedList<>();

        int start = 0;
        while (start + p.length() <= s.length()) {
            String temp = s.substring(start, start+p.length());
            if (getSignature(temp).equals(pSignature)) {
                result.add(start);
            }
            start += 1;
        }
        return result;
    }

    private static String getSignature(String input) {
        byte[] bytes = input.getBytes();
        Arrays.sort(bytes);
        return new String(bytes);
    }

}
