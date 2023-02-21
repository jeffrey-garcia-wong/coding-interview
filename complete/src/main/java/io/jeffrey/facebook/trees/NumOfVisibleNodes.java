package io.jeffrey.facebook.trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * <h1>Number of Visible Nodes</h1>
 *
 * There is a binary tree with N nodes. You are viewing the tree from
 * its left side and can see only the leftmost nodes at each level.
 * Return the number of visible nodes.<p/>
 *
 * Note: You can see only the leftmost nodes, but that doesn't mean
 * they have to be left nodes. The leftmost node at a level could be
 * a right node.<p/>
 *
 * <b>Signature</b><br/>
 * <pre>
 * {@code
 * int visibleNodes(Node root) { }
 * }
 * </pre>
 *
 * <b>Input</b><br/>
 * <pre>
 * {@code
 * The root node of a tree, where the number of nodes is between 1 and
 * 1000, and the value of each node is between 0 and 1,000,000,000
 * }
 * </pre>
 *
 * <b>Output</b><br/>
 * <pre>
 * {@code
 * An int representing the number of visible nodes.
 * }
 * </pre>
 *
 * <b>Example</b><br/>
 * <pre>
 * {@code
 *             8  <------ root
 *            / \
 *          3    10
 *         / \     \
 *        1   6     14
 *           / \    /
 *          4   7  13
 *
 * output = 4
 * }
 * </pre>
 */
public class NumOfVisibleNodes {

    static class Node {
        int data;
        Node left;
        Node right;
        Node() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int execute(Node root) {
        return solutionV1(root);
    }

    private static int solutionV1(Node root) {
        /* Design the algorithm here
         *
         * Do a breadth-first-search to process the nodes
         * in each level, and only add the first node (left-most)
         * node of each level into the visited history.
         * When all the nodes have been processed, the size of
         * the visited history will represent the visible nodes
         * from the left of the tree.
         *
         * Time complexity:
         * O(N) since all the nodes must be visited at least once
         *
         * Space complexity:
         * O(N)
         */

        // Write the code here
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null); // mark the end of the current level

        Map<Integer, Node> visited = new HashMap<>();
        int level = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node == null) { // end of the current level
                level += 1;
                if (!queue.isEmpty()) queue.offer(null);
                continue;
            }

            if (!visited.containsKey(level)) {
                visited.put(level, node);
            }

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return visited.size();
     }
}