package com.jeffrey.hackkerank.linkedlists;

import com.jeffrey.hackkerank.linkedlists.InsertNodeAtPosition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsertNodeAtPositionTests {

    @Test
    public void test_001() {
        InsertNodeAtPosition.SinglyLinkedList list = new InsertNodeAtPosition.SinglyLinkedList();
        list.insertNode(16);
        list.insertNode(13);
        list.insertNode(7);

        InsertNodeAtPosition.SinglyLinkedListNode head = InsertNodeAtPosition.execute(list.head, 1, 2);
        assertEquals("16 13 1 7 ", list.toString());
    }

    @Test
    public void test_002() {
        Object b = new Object();
        Object a = b;
        b = null;
        System.out.println(a);
    }

}
