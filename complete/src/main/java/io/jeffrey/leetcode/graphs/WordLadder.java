package io.jeffrey.leetcode.graphs;

import java.util.*;

/**
 * <h1>Word Ladder</h1>
 *
 * A transformation sequence from word beginWord to word endWord using a
 * dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk
 * such that:<p/>
 *
 * <ul>
 *     <li>Every adjacent pair of words differs by a single letter.</li>
 *     <li>Every si for 1 <= i <= k is in wordList. Note that beginWord
 *     does not need to be in wordList.</li>
 *     <li>sk == endWord</li>
 * </ul>
 *
 * Given two words, beginWord and endWord, and a dictionary wordList,
 * return the number of words in the shortest transformation sequence
 * from beginWord to endWord, or 0 if no such sequence exists.<p/>
 *
 * <b>Example 1:</b>
 * <pre>
 * {@code
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * which is 5 words long.
 * }
 * </pre>
 *
 * <b>Example 2:</b>
 * <pre>
 * {@code
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid
 * transformation sequence.
 * }
 * </pre>
 *
 * <b>Constraints</b>
 * <ul>
 *     <li>1 <= beginWord.length <= 10</li>
 *     <li>endWord.length == beginWord.length</li>
 *     <li>1 <= wordList.length <= 5000</li>
 *     <li>wordList[i].length == beginWord.length</li>
 *     <li>beginWord, endWord, and wordList[i] consist of lowercase English letters.</li>
 *     <li>beginWord != endWord</li>
 *     <li>All the words in wordList are unique.</li>
 * </ul>
 */
public class WordLadder {

    public static int execute(String beginWord, String endWord, List<String> wordList) {
        return solutionV1(beginWord, endWord, wordList);
    }

    public static int solutionV1(String beginWord, String endWord, List<String> wordList) {
        /* Design the algorithm here
         * ===========================
         * This problem is best modelled as a graph, where each word is
         * a vertex, and any word with only one character different from
         * it will be its neighbour.
         *
         * The graph is manipulated using an adjacency list backed by a
         * map, with the vertex being a word with one character masked
         * as '*'
         *
         * For example:
         * with a word list ["hot","dot","dog","lot","log"]
         * the adjacency list will look like:
         * {
         *  "*ot": ["hot","dot","lot"],
         *  "h*t": ["hot"],
         *  "ho*": [],
         *  "d*t": ["dot"],
         *  "do*": ["dot","dog"],
         *  "l*t": ["lot"],
         *  "lo*": ["lot","log"]
         * }
         *
         * To find the shortest path to the end node, apply a BFS search algorithm,
         * using a queue for all the vertices to be visited sorted by the order of
         * level, and use a set for all the visited vertices.
         *
         * The search start with the "beginWord" and terminate when either one of
         * the following condition is true:
         * 1) the "endWord" is found
         * 2) the queue is emptied
         *
         * The shortest distance is found by measuring the number of level(s) from the
         * origin to reach the destination. This can be implemented by storing the
         * current level together with the word into the queue, subsequently when
         * the word is removed from the queue, its current level retrieved will be the
         * distance from the "beginWord".
         *
         */

        // Write the algorithm here
        Map<String, List<String>> adjacencyList = generateGraph(wordList);

        Set<String> visited = new HashSet<>();
        Queue<Object[]> queue = new LinkedList<>();
        queue.add(new Object[] {beginWord, 1});

        while (!queue.isEmpty()) {
            Object[] object = queue.poll();
            String currWord = (String) object[0];
            int level = (int) object[1];

            if (visited.contains(currWord))
                continue;
            else
                visited.add(currWord);

            if (currWord.equals(endWord)) {
                return level;
            }

            // search for neighbours
            char [] chars = currWord.toCharArray();
            for (int i=0; i<chars.length; i++) {
                char backup = chars[i];
                chars[i] = '*';
                String key = String.valueOf(chars);
                List<String> value = adjacencyList.getOrDefault(key, new LinkedList<>());
                for (String neighborWord : value) {
                    if (!currWord.equals(neighborWord)) {
                        queue.offer(new Object[] {neighborWord, level + 1});
                    }
                }
                chars[i] = backup;
            }
        }

        return 0;
    }

    private static Map<String, List<String>> generateGraph(List<String> wordList) {
        Map<String, List<String>> adjacencyList = new HashMap<>();
        for (String word : wordList) {
            char [] chars = word.toCharArray();
            for (int i=0; i<chars.length; i++) {
                char backup = chars[i];
                chars[i] = '*';
                String key = String.valueOf(chars);
                List<String> value = adjacencyList.getOrDefault(key, new LinkedList<>());
                value.add(word);
                adjacencyList.put(key, value);
                chars[i] = backup;
            }
        }
        return adjacencyList;
    }
}
