package io.jeffrey.facebook.trees;

import org.junit.jupiter.api.Test;

import io.jeffrey.facebook.trees.NodesInASubtree.Node;
import io.jeffrey.facebook.trees.NodesInASubtree.Query;

import java.util.ArrayList;
import java.util.Arrays;

import static io.jeffrey.facebook.trees.NodesInASubtree.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NodesInASubtreeTests {

    @Test
    public void test_001() {
        String s = "aba";
        Node root = new Node(1);
        root.children.add(new Node(2));
        root.children.add(new Node(3));
        ArrayList<Query> queries = new ArrayList<>();
        queries.add(new Query(1, 'a'));
        assertEquals(
                Arrays.toString(new int[] {2}),
                Arrays.toString(execute(root, queries, s))
        );
    }

    @Test
    public void test_002() {
        String s = "abaacab";
        Node root = new Node(1);
        root.children.add(new Node(2));
        root.children.add(new Node(3));
        root.children.add(new Node(7));
        root.children.get(0).children.add(new Node(4));
        root.children.get(0).children.add(new Node(5));
        root.children.get(1).children.add(new Node(6));
        ArrayList<Query> queries = new ArrayList<>();
        queries.add(new Query(1, 'a'));
        queries.add(new Query(2, 'b'));
        queries.add(new Query(3, 'a'));
        assertEquals(
                Arrays.toString(new int[] {4, 1, 2}),
                Arrays.toString(execute(root, queries, s))
        );
    }

}
