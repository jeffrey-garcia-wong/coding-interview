package io.jeffrey.hackkerank.lists;

import org.junit.jupiter.api.Test;

import static io.jeffrey.hackkerank.lists.InsertNodeInSortedDoublyLinkedLists.DoublyLinkedListNode;
import static io.jeffrey.hackkerank.lists.InsertNodeInSortedDoublyLinkedLists.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class InsertNodeInSortedDoublyLinkedListsTests {

    private void check(int [] expected, DoublyLinkedListNode rNode) {
        DoublyLinkedListNode currNode = rNode;

        for (int i=0; i<expected.length; i++) {
            assertEquals(expected[i], currNode.data);
            if (i==0) {
                assertNull(currNode.prev);
            } else {
                assertEquals(expected[i-1], currNode.prev.data);
            }
            if (i==expected.length-1) {
                assertNull(currNode.next);
            } else {
                assertEquals(expected[i+1], currNode.next.data);
            }
            currNode = currNode.next;
        }
    }

    private DoublyLinkedListNode generateList(int length) {
        DoublyLinkedListNode headNode = null;
        DoublyLinkedListNode prevNode = null;
        for (int i=1; i<=length; i++) {
            DoublyLinkedListNode node = new DoublyLinkedListNode();
            if (headNode == null) headNode = node;
            node.data = i;
            node.prev = prevNode;
            if (prevNode != null) prevNode.next = node;
            prevNode = node;
        }
        return headNode;
    }

    @Test
    public void test_001() {
        int [] expected = {10};
        check(expected, execute(null, 10));
    }

    @Test
    public void test_002() {
        DoublyLinkedListNode node = generateList(1);
        int [] expected = {1,10};
        check(expected, execute(node, 10));
    }

    @Test
    public void test_003() {
        DoublyLinkedListNode node = generateList(1);
        int [] expected = {0,1};
        check(expected, execute(node, 0));
    }

    @Test
    public void test_004() {
        DoublyLinkedListNode node = generateList(4);
        int [] expected = {1,2,2,3,4};
        check(expected, execute(node, 2));
    }

    @Test
    public void test_005() {
        DoublyLinkedListNode node = generateList(4);
        int [] expected = {1,2,3,4,5};
        check(expected, execute(node, 5));
    }

}
