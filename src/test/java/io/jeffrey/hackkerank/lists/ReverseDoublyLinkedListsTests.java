package io.jeffrey.hackkerank.lists;

import org.junit.jupiter.api.Test;

import static io.jeffrey.hackkerank.lists.ReverseDoublyLinkedLists.execute;
import static io.jeffrey.hackkerank.lists.ReverseDoublyLinkedLists.DoublyLinkedListNode;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ReverseDoublyLinkedListsTests {

    private void check(int length, DoublyLinkedListNode rNode) {
        DoublyLinkedListNode currNode = rNode;

        for (int i=length; i>=1; i--) {
            assertEquals(i, currNode.data);
            if (i==length) {
                assertNull(currNode.prev);
            } else {
                assertEquals(i+1, currNode.prev.data);
            }
            if (i==1) {
                assertNull(currNode.next);
            } else {
                assertEquals(i-1, currNode.next.data);
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
        assertEquals(null, execute(null));
    }

    @Test
    public void test_002() {
        int length = 4;
        DoublyLinkedListNode node = generateList(length);
        check(length, execute(node));
    }

    @Test
    public void test_003() {
        int length = 10;
        DoublyLinkedListNode node = generateList(length);
        check(length, execute(node));
    }
}
