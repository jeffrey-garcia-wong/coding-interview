package io.jeffrey.core.util.trees;

import org.junit.jupiter.api.Test;

import java.util.*;

import static io.jeffrey.core.util.trees.BinaryTree.TreeNode;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BinaryTreeTests {

    @Test
    public void test_001() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(new Integer[] {3,5,1,6,2,0,8,null,null,7,4});
        List<Integer> traversal = binaryTree.printInOrder();
        assertEquals(
                Arrays.toString(new int[] {6, 5, 7, 2, 4, 3, 0, 1, 8}),
                traversal.toString()
        );
    }

    @Test
    public void test_002() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(new Integer[] {3,5,1,6,2,0,8,null,null,7,4});
        List<Integer> traversal = binaryTree.printInOrder();
        for (int e : traversal) {
            assertEquals(
                    e,
                    binaryTree.dfsSearch_recursive(e).data
            );
        }
    }

    @Test
    public void test_003() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(new Integer[] {3,5,1,6,2,0,8,null,null,7,4});
        List<Integer> traversal = binaryTree.printInOrder();
        for (int e : traversal) {
            assertEquals(
                    binaryTree.dfsSearch_recursive(e),
                    binaryTree.bfsSearch_nonRecursive(e)
            );
        }
    }


    @Test
    public void test_004() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(new Integer[] {3,5,1,6,2,0,8,null,null,7,4});
        List<Integer> traversal = binaryTree.printInOrder();
        for (int e : traversal) {
            assertEquals(
                    binaryTree.dfsSearch_nonRecursive(e),
                    binaryTree.bfsSearch_nonRecursive(e)
            );
        }
    }

    @Test
    public void test_005() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(new Integer[] {3,5,1,6,2,0,8,null,null,7,4});

        Deque<TreeNode> result;
        List<Integer> expected;

        result = binaryTree.dfsSearchWithPath_nonRecursive(3);
        expected = Arrays.asList(3);
        assertEquals(expected.size(), result.size());
        for (Integer i : expected) {
            assertEquals(i.intValue(), result.removeFirst().data);
        }

        result = binaryTree.dfsSearchWithPath_nonRecursive(5);
        expected = Arrays.asList(3, 5);
        assertEquals(expected.size(), result.size());
        for (Integer i : expected) {
            assertEquals(i.intValue(), result.removeFirst().data);
        }

        result = binaryTree.dfsSearchWithPath_nonRecursive(1);
        expected = Arrays.asList(3, 1);
        assertEquals(expected.size(), result.size());
        for (Integer i : expected) {
            assertEquals(i.intValue(), result.removeFirst().data);
        }

        result = binaryTree.dfsSearchWithPath_nonRecursive(6);
        expected = Arrays.asList(3, 5, 6);
        assertEquals(expected.size(), result.size());
        for (Integer i : expected) {
            assertEquals(i.intValue(), result.removeFirst().data);
        }

        result = binaryTree.dfsSearchWithPath_nonRecursive(2);
        expected = Arrays.asList(3, 5, 2);
        assertEquals(expected.size(), result.size());
        for (Integer i : expected) {
            assertEquals(i.intValue(), result.removeFirst().data);
        }

        result = binaryTree.dfsSearchWithPath_nonRecursive(7);
        expected = Arrays.asList(3, 5, 2, 7);
        assertEquals(expected.size(), result.size());
        for (Integer i : expected) {
            assertEquals(i.intValue(), result.removeFirst().data);
        }

        result = binaryTree.dfsSearchWithPath_nonRecursive(4);
        expected = Arrays.asList(3, 5, 2, 4);
        assertEquals(expected.size(), result.size());
        for (Integer i : expected) {
            assertEquals(i.intValue(), result.removeFirst().data);
        }

        result = binaryTree.dfsSearchWithPath_nonRecursive(0);
        expected = Arrays.asList(3, 1, 0);
        assertEquals(expected.size(), result.size());
        for (Integer i : expected) {
            assertEquals(i.intValue(), result.removeFirst().data);
        }

        result = binaryTree.dfsSearchWithPath_nonRecursive(8);
        expected = Arrays.asList(3, 1, 8);
        assertEquals(expected.size(), result.size());
        for (Integer i : expected) {
            assertEquals(i.intValue(), result.removeFirst().data);
        }
    }

    @Test
    public void test_006() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(new Integer[] {3,5,1,6,2,0,8,null,null,7,4});

        assertEquals(2,
                binaryTree.findLowestCommonAncestor_recursive(7, 4).data
        );
        assertEquals(3,
                binaryTree.findLowestCommonAncestor_recursive(2, 0).data
        );
        assertEquals(5,
                binaryTree.findLowestCommonAncestor_recursive(5, 6).data
        );
        assertEquals(1,
                binaryTree.findLowestCommonAncestor_recursive(1, 8).data
        );
        assertEquals(5,
                binaryTree.findLowestCommonAncestor_recursive(5, 4).data
        );
        assertEquals(2,
                binaryTree.findLowestCommonAncestor_recursive(4, 2).data
        );
        assertEquals(3,
                binaryTree.findLowestCommonAncestor_recursive(1, 7).data
        );
        assertEquals(5,
                binaryTree.findLowestCommonAncestor_recursive(6, 4).data
        );
    }

    @Test
    public void test_007() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(new Integer[] {3,5,1,6,2,0,8,null,null,7,4});

        assertEquals(
                binaryTree.findLowestCommonAncestor_recursive(7, 4).data,
                binaryTree.findLowestCommonAncestor_nonRecursive(7, 4).data
        );
        assertEquals(
                binaryTree.findLowestCommonAncestor_recursive(2, 0).data,
                binaryTree.findLowestCommonAncestor_nonRecursive(2, 0).data
        );
        assertEquals(
                binaryTree.findLowestCommonAncestor_recursive(5, 6).data,
                binaryTree.findLowestCommonAncestor_nonRecursive(5, 6).data
        );
        assertEquals(
                binaryTree.findLowestCommonAncestor_recursive(1, 8).data,
                binaryTree.findLowestCommonAncestor_nonRecursive(1, 8).data
        );
        assertEquals(
                binaryTree.findLowestCommonAncestor_recursive(5, 4).data,
                binaryTree.findLowestCommonAncestor_nonRecursive(5, 4).data
        );
        assertEquals(
                binaryTree.findLowestCommonAncestor_recursive(4, 2).data,
                binaryTree.findLowestCommonAncestor_nonRecursive(4, 2).data
        );
        assertEquals(
                binaryTree.findLowestCommonAncestor_recursive(1, 7).data,
                binaryTree.findLowestCommonAncestor_nonRecursive(1, 7).data
        );
        assertEquals(
                binaryTree.findLowestCommonAncestor_recursive(6, 4).data,
                binaryTree.findLowestCommonAncestor_nonRecursive(6, 4).data
        );
        assertNull(binaryTree.findLowestCommonAncestor_nonRecursive(9, 4));
        assertNull(binaryTree.findLowestCommonAncestor_nonRecursive(9, 12));
    }
}
