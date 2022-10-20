package com.jeffrey.facebook.arrays;

import java.util.Arrays;

/**
 * <h1>Passing Yearbooks</h1><p/>
 *
 * There are n students, numbered from 1 to n, each with their own yearbook.
 * They would like to pass their yearbooks around and get them signed by
 * other students.<p/>
 *
 * You're given a list of n integers arr[1..n], which is guaranteed to be
 * a permutation of 1..n (in other words, it includes the integers from 1
 * to n exactly once each, in some order). The meaning of this list is
 * described below.<p/>
 *
 * Initially, each student is holding their own yearbook. The students
 * will then repeat the following two steps each minute: Each student i
 * will first sign the yearbook that they're currently holding (which
 * may either belong to themselves or to another student), and then they'll
 * pass it to student arr[i-1]. It's possible that arr[i-1] = i for any given
 * i, in which case student i will pass their yearbook back to themselves.
 * Once a student has received their own yearbook back, they will hold on to
 * it and no longer participate in the passing process.<p/>
 *
 * It's guaranteed that, for any possible valid input, each student will
 * eventually receive their own yearbook back and will never end up
 * holding more than one yearbook at a time.<p/>
 *
 * You must compute a list of n integers output, whose element at i-1 is
 * equal to the number of signatures that will be present in student i's
 * yearbook once they receive it back.<p/>
 *
 * <b>Signature</b><br/>
 * <pre>
 * {@code
 * int[] findSignatureCounts(int[] arr)
 * }
 * </pre>
 *
 * <b>Input</b><br/>
 * <pre>
 * {@code
 * n is in the range [1, 100,000].
 * }
 * Each value arr[i] is in the range [1, n], and all values in arr[i] are distinct.
 * </pre>
 *
 * <b>Output</b><br/>
 * Return a list of n integers output, as described above.<p/>
 *
 * <b>Example 1</b><br/>
 * <pre>
 * {@code
 * n = 2
 * arr = [2, 1]
 * output = [2, 2]
 * }
 * </pre>

 * Pass 1:
 * <ul>
 *     <li>
 *         Student 1 signs their own yearbook. Then they pass the
 *         book to the student at arr[0], which is Student 2.
 *     </li>
 *     <li>
 *         Student 2 signs their own yearbook. Then they pass the
 *         book to the student at arr[1], which is Student 1.
 *     </li>
 * </ul>
 *
 * Pass 2:
 * <ul>
 *     <li>
 *         Student 1 signs Student 2's yearbook. Then they pass it
 *         to the student at arr[0], which is Student 2.
 *     </li>
 *     <li>
 *         Student 2 signs Student 1's yearbook. Then they pass it
 *         to the student at arr[1], which is Student 1.
 *     </li>
 * </ul>
 *
 * Pass 3:
 * <ul>
 *     <li>
 *         Both students now hold their own yearbook, so the process
 *         is complete.
 *     </li>
 * </ul>
 * Each student received 2 signatures.<p/>
 *
 * <b>Example 2</b><br/>
 * <pre>
 * {@code
 * n = 2
 * arr = [1, 2]
 * output = [1, 1]
 * }
 * </pre>
 *
 * Pass 1:
 * <ul>
 *     <li>
 *         Student 1 signs their own yearbook. Then they
 *         pass the book to the student at arr[0], which
 *         is themself, Student 1.
 *     </li>
 *     <li>
 *         Student 2 signs their own yearbook. Then they
 *         pass the book to the student at arr[1], which
 *         is themself, Student 2.
 *     </li>
 * </ul>
 *
 * Pass 2:
 * <ul>
 *     <li>Both students now hold their own yearbook, so the process is complete.</li>
 * </ul>
 * Each student received 1 signature.<p/>
 *
 */
class PassingYearbooks {

    static int[] execute(int[] student) {
        return solutionV1(student);
    }

    private static int[] solutionV1(int[] student) {
        int[] holder = Arrays.copyOf(student, student.length);

        int[] signature = new int[student.length];
        for (int i=0; i<signature.length; i++) {
            signature[i] = 1;
        }
        int remaining = student.length;

        while (remaining > 0) {
            for (int i=student.length-1; i>=0; i--) {
                int studentNum = student[i];
                if (holder[studentNum-1] != studentNum) {
                    signature[i] ++;
                    holder[studentNum-1] = studentNum;
                } else {
                    remaining --;
                }
            }
        }

        return signature;
    }

}
