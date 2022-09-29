package com.jeffrey.hackkerank;

import java.util.Arrays;
import java.util.List;

class SparseArrays {

    public static List<Integer> execute(List<String> stringList, List<String> queries) {
        return solutionV1(stringList, queries);
    }


    /**
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY stringList
     *  2. STRING_ARRAY queries
     */
    private static List<Integer> solutionV1(List<String> stringList, List<String> queries) {
        // Write your code here
        String[] input = new String[stringList.size()];
        stringList.toArray(input);
        Arrays.sort(input);

        String[] query = new String[queries.size()];
        queries.toArray(query);

        Integer[] result = new Integer[query.length];
        for (int i=0; i<result.length; i++) {
            result[i] = 0;
        }

        for (int i=0; i<query.length; i++) {
            String q = query[i];
            for (int j=0; j<input.length; j++) {
                if (q.compareTo(input[j])==0) {
                    result[i] += 1;
                }
            }
        }

        return Arrays.asList(result);
    }
}
