package io.jeffrey.hackkerank.lists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Merge2SortedLinkedListsTests {

    @Test
    public void test_001() {
        Merge2SortedLinkedLists.SinglyLinkedList list1 = new Merge2SortedLinkedLists.SinglyLinkedList();
        list1.insertNode(1);
        list1.insertNode(2);
        list1.insertNode(3);

        Merge2SortedLinkedLists.SinglyLinkedList list2 = new Merge2SortedLinkedLists.SinglyLinkedList();
        list2.insertNode(3);
        list2.insertNode(4);

        Merge2SortedLinkedLists.SinglyLinkedListNode mergedHead = Merge2SortedLinkedLists.execute(list1.head, list2.head);
        assertEquals("1 2 3 3 4 ", mergedHead.toString());
    }

}
