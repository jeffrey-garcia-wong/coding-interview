package io.jeffrey.core.util.trees;

import java.util.*;

public class BinaryTree {
    private TreeNode root;

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public void insert(Integer [] input) {
        if (input.length == 0) return;
        root = new TreeNode(input[0]);

        // since the input array container elements in
        // level-order
        // Use BFS algorithm to insert new nodes into tree
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (input.length > ++count) curr.left = input[count] == null ? null:new TreeNode(input[count]);
            if (input.length > ++count) curr.right = input[count] == null ? null:new TreeNode(input[count]);
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
    }

    public List<Integer> printInOrder() {
        List<Integer> traversal = new LinkedList<>();
        printInOrder(this.root, traversal);
        return traversal;
     }

    private void printInOrder(TreeNode curr, List<Integer> traversal) {
        if (curr.left != null) printInOrder(curr.left, traversal);
        traversal.add(curr.data);
        if (curr.right != null) printInOrder(curr.right, traversal);
    }

    public TreeNode dfsSearch_recursive(int data) {
        return dfsSearch_recursive(this.root, data);
    }

    private TreeNode dfsSearch_recursive(TreeNode curr, int data) {
        if (curr.data == data) return curr;

        TreeNode target;
        target = curr.left!=null? dfsSearch_recursive(curr.left, data):null;
        if (target != null) return target;
        target = curr.right!=null ? dfsSearch_recursive(curr.right, data):null;
        if (target != null) return target;

        return null;
    }

    public TreeNode bfsSearch_nonRecursive(int data) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this.root);

        TreeNode target = null;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.data == data) {
                target = curr;
                break;
            }
            if (curr.left != null) queue.offer(curr.left);
            if (curr.right != null) queue.offer(curr.right);
        }
        return target;
    }

    /*
     * A non-recursive version of DFS search which uses a stack to store
     * the child elements,
     */
    public TreeNode dfsSearch_nonRecursive(int data) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(this.root);

        TreeNode target = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.data == data) {
                target = curr;
                break;
            }
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
        return target;
    }

    private static class TreeNodeWithHistory {
        TreeNode node;
        boolean isVisited = false;
        public TreeNodeWithHistory(TreeNode node) {
            this.node = node;
        }
    }

    /*
     * A non-recursive version of DFS search which can keep
     * records the path to the target node, the algorithm
     * is based on the non-recursive version of DFS search.
     *
     * One key difference is we want to keep the traversal
     * history of the current node if it's the target node,
     * to achieve that instead of popping top node from stack,
     * the top node is peeked first for comparison with the
     * target node/value, the idea is to keep it in the stack
     * such that when the target node is later found as we
     * traversed down the tree, all the nodes in the path to
     * the target node is kept in the stack.
     *
     * Now because of this change, a node in the stack can
     * possibly be re-visited if the target node does not
     * exist as its descendants, to avoid dead-loop for
     * each node that has already been visited, we need an
     * additional flag to identify the node has been visited
     * before, a wrapper class for TreeNode is created
     * with a boolean flag which default to false and set
     * to true once the node is visited.
     *
     * As soon as the target node is found, the loop will break
     * immediately even if the stack has remaining nodes to be
     * visited, conversely if all the nodes are visited and the
     * target node is not found (does not exist), an empty stack
     * will remain.
     *
     * Subsequently, assume the target node is found, the stack
     * contains all the nodes on the path to the target node, and
     * because as well as the nodes on the other branch which share
     * the same parent node at each level, we need to prune the nodes
     * in the stack to remove any un-related nodes.
     *
     * This pruning process will require to examine all the nodes
     * in the stack, for each node popped from the stack we check
     * it with the previous popped node (which must be its child),
     * if the previous popped node is either the left or right of
     * current popped node then we can be sure it must be in the
     * path to the target node, and we can safely add this node
     * into a LIFO queue (or another stack) which keeps node at
     * higher level on top.
     *
     * At the end we have a result queue/stack which only contains
     * the nodes in the exact same order they can be traversed to
     * reach the target node.
     */
    public Deque<TreeNode> dfsSearchWithPath_nonRecursive(int data) {
        Stack<TreeNodeWithHistory> stack = new Stack<>();
        stack.push(new TreeNodeWithHistory(this.root));

        while (!stack.isEmpty()) {
            TreeNodeWithHistory curr = stack.peek();
            if (curr.isVisited) {
                stack.pop();
            } else {
                curr.isVisited = true;
                if (curr.node.data == data) break;
                if (curr.node.right != null)
                    stack.push(new TreeNodeWithHistory(curr.node.right));
                if (curr.node.left != null)
                    stack.push(new TreeNodeWithHistory(curr.node.left));
            }
        }

        Deque<TreeNode> traversal = new LinkedList<>();

        TreeNode child = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop().node;
            if (child == null || curr.left == child || curr.right == child) {
                traversal.addFirst(curr);
                child = curr;
            }
        }

        return traversal;
    }

    /*
     * This algorithm is based on the non-recursive DFS search algorithm
     * which also returns the traversal history to the target node.
     *
     * The idea is to run the search of the 2 nodes individually, which
     * produces 2 traversal results (LIFO queue or stack).
     *
     * Since the traversal results must be starting with the root node
     * and all the nodes in the traversal path are ordered properly,
     * we can simply iterate through the nodes in both results, whenever
     * the nodes are equal we reset the common ancestor, until either of
     * the queue or stack are emptied.
     */
    public TreeNode findLowestCommonAncestor_nonRecursive(int p, int q) {
        Deque<TreeNode> pPath = dfsSearchWithPath_nonRecursive(p);
        Deque<TreeNode> qPath = dfsSearchWithPath_nonRecursive(q);

        TreeNode ancestor = null;
        while (!pPath.isEmpty() && !qPath.isEmpty()) {
            TreeNode _p = pPath.removeFirst();
            TreeNode _q = qPath.removeFirst();
            if (_p == _q) ancestor = _p;
        }

        return ancestor;
    }

    public TreeNode findLowestCommonAncestor_recursive(int p, int q) {
        return findLowestCommonAncestor_recursive(this.root, p, q);
    }

    /*
     * This algorithm is primarily based on DFS search (recursive version)
     * and designed to work with binary tree (un-ordered binary tree).
     *
     * The algorithm rely on the following constraint which must be HELD:
     * - p and q BOTH exist in the tree
     * - all the nodes in the tree are unique
     *
     * - if the root node is either p and q, search is finished because
     *   root node must be the least common ancestor of both nodes
     * - if p and q are not the root node, perform an exhaustive search
     *   on every node, and the possible outcomes could be:
     *   - p is found on the left while q is found on the right, the
     *     parent node is the least common ancestor
     *   - either p or q is found on the left and nothing could be
     *     found from the right, return the left node since we can
     *     safely assume the other node must also reside on the left
     *   - either p or q is found on the right and nothing could be
     *     found from the left, return the right node since we can
     *     safely assume the other node must also reside on the right
     */
    private TreeNode findLowestCommonAncestor_recursive(TreeNode curr, int p, int q) {
        if (curr == null) return null;
        if (curr.data == p || curr.data == q) return curr;
        TreeNode left = findLowestCommonAncestor_recursive(curr.left, p, q);
        TreeNode right = findLowestCommonAncestor_recursive(curr.right, p, q);
        if (left != null && right != null) return curr;
        if (left != null && right == null) return left;
        if (left == null && right != null) return right;
        return null;
    }

}
