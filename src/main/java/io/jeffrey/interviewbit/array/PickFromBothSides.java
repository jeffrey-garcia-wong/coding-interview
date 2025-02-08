package io.jeffrey.interviewbit.array;

import java.util.List;

/**
 * <h1>Pick from both sides!</h1>
 *
 * <b>Problem Description</b> <br/>
 * <pre>
 *      Given an integer array A of size N. You have to pick exactly B
 *      elements from either left or right end of the array A to get the
 *      maximum sum. Find and return this maximum possible sum. <p/>
 * </pre>
 *
 * <b>Notes:</b> Suppose B = 4 and array A contains 10 elements then
 * <pre>
 *      You can pick the first four elements or can pick the last four
 *      elements or can pick 1 from the front and 3 from the back etc.
 *      you need to return the maximum possible sum of elements you can pick.
 * </pre>
 *
 * <b>Problem Constraints</b>
 * <pre>
 *     1 <= N <= 105
 *     1 <= B <= N
 *     -103 <= A[i] <= 103
 * </pre>
 *
 * <b>Input Format</b>
 * <pre>
 *     First argument is an integer array A.
 *     Second argument is an integer B.
 * </pre>
 *
 * <b>Output Format</b>
 * <pre>
 *      Return an integer denoting the maximum possible sum of elements you picked.
 * </pre>
 *
 * <b>Example Input</b>
 * <pre>
 *     {@code
 *      Input 1:
 *      A = [5, -2, 3 , 1, 2]
 *      B = 3
 *
 *      Input 2:
 *      A = [1, 2]
 *      B = 1
 *     }
 * </pre>
 *
 * <b>Example Output</b>
 * <pre>
 *     {@code
 *     Output 1:
 *      8
 *      Output 2:
 *      2
 *     }
 * </pre>
 *
 * <b>Example Explanation</b>
 * <pre>
 *     Explanation 1:
 *     Pick element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
 *
 *     Explanation 2:
 *     Pick element 2 from end as this is the maximum we can get
 * </pre>
 */
public class PickFromBothSides {

    public static int execute(List<Integer> A, int B) {
        return solutionV1(A, B);
    }

    private static int solutionV1(List<Integer> A, int B) {
        int maxLeft = 0;

        for (int i=0; i<B; i++) {
            maxLeft += A.get(i);
        }

        int max = maxLeft;
        int sum = max;
        int i = 1;
        while (i <= B) {
            sum = sum - A.get(B-i) + A.get(A.size()-i);
            if (sum > max) {
                max = sum;
            }
            i += 1;
        }
        return max;
    }
}
