package io.jeffrey.facebook.trees;

import org.junit.jupiter.api.Test;

import static io.jeffrey.facebook.trees.NumOfVisibleNodes.Node;
import static io.jeffrey.facebook.trees.NumOfVisibleNodes.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumOfVisibleNodesTests {

    @Test
    public void test_001() {
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        root.right.right.left = new Node(13);
        assertEquals(4, execute(root));
    }

    @Test
    public void test_002() {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(15);
        root.left.left = new Node(4);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right.left = new Node(14);
        root.right.right = new Node(16);
        assertEquals(5, execute(root));
    }

}
