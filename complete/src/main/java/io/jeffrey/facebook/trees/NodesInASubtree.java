package io.jeffrey.facebook.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <h1>Nodes in a Subtree</h1>
 *
 * You are given a tree that contains N nodes, each containing an integer
 * u which corresponds to a lowercase character c in the string s using
 * 1-based indexing.<p/>
 *
 * You are required to answer Q queries of type [u, c], where u is an
 * integer and c is a lowercase letter. The query result is the number
 * of nodes in the subtree of node u containing c.<p/>
 *
 * <b>Signature</b><br/>
 * <pre>
 * {@code
 * int[] countOfNodes(Node root, ArrayList<Query> queries, String s)
 * }
 * </pre>
 *
 * <b>Input</b><br/>
 * A pointer to the root node, an array list containing Q queries of
 * type [u, c], and a string s <p/>
 *
 * <b>Constraints</b><br/>
 * N and Q are the integers between 1 and 1,000,000 <br/>
 * u is a unique integer between 1 and N <br/>
 * s is of the length of N, containing only lowercase letters <br/>
 * c is a lowercase letter contained in string s <br/>
 * Node 1 is the root of the tree <p/>
 *
 * <b>Output</b><br/>
 * An integer array containing the response to each query
 *
 * <b>Example</b><br/>
 * <pre>
 * {@code
 *         1(a)
 *         /   \
 *       2(b)  3(a)
 * }
 * s = "aba"
 * RootNode = 1
 * queries = [[1, 'a']]
 * </pre>
 *
 * <b>Notes</b><br/>
 * Node 1 corresponds to first letter 'a', Node 2 corresponds to second
 * letter of the string 'b', Node 3 corresponds to third letter of the
 * string 'a'.
 * <pre>
 * {@code
 * output = [2]
 * }
 * </pre>
 *
 * Both Node 1 and Node 3 contain 'a', so the number of nodes within
 * the subtree of Node 1 containing 'a' is 2.<p/>
 */
public class NodesInASubtree {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
            val = 0;
            children = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    static class Query {
        int u;
        char c;
        Query(int u, char c) {
            this.u = u;
            this.c = c;
        }
    }

    public static int[] execute(Node root, ArrayList<Query> queries, String s) {
        return solutionV1(root, queries, s);
    }

    private static int[] solutionV1(Node root, ArrayList<Query> queries, String s) {
        /* Design the algorithm here
         *
         * Perform a level-order-search (breadth-first-search) and examine the nodes
         * per level until the target node is found. Once the target node is found,
         * stop the BFS search, then do a recursive traversal to examine all the
         * descendant nodes and increment a counter to keep track of the total
         * number of target characters found matching with the node's value.
         */
        // Write the code here
        char[] chars = s.toCharArray();

        int[] result = new int[queries.size()];

        for (int i=0; i<queries.size(); i++) {
            int targetVal = queries.get(i).u;
            char targetChar = queries.get(i).c;

            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                if (node.val == targetVal) {
                    result[i] = traverse(node, 0, chars, targetChar);
                }
                for (Node childNode : node.children) {
                    queue.offer(childNode);
                }
            }
        }

        return result;
    }

    private static int traverse(Node root, int count, char[] chars, char targetChar) {
        if (chars[root.val - 1] == targetChar) count += 1;
        for (Node node : root.children) {
            count = traverse(node, count, chars, targetChar);
        }
        return count;
    }
}
