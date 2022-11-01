package com.jeffrey.leetcode.lists;

import org.junit.jupiter.api.Test;

import static com.jeffrey.leetcode.lists.RemoveDuplicatesFromSortedLists.ListNode;

import static org.junit.jupiter.api.Assertions.fail;

public class RemoveDuplicatesFromSortedListsTests {

    private void check(ListNode expectedHead, ListNode actualHead) {
        if (expectedHead==null && actualHead==null) return;

        ListNode expectedNode;
        ListNode actualNode;

        expectedNode = expectedHead;
        actualNode = actualHead;
        while (expectedNode.next!=null && actualHead.next!=null) {
            if (expectedNode.val != actualNode.val)
                fail("node value un-matched");
            expectedNode = expectedNode.next;
            actualNode = actualNode.next;
        }

        if (expectedNode.next!=null || actualNode.next!=null)
            fail("result list un-match");
    }

    @Test
    public void test_001() {
        ListNode expectedHead = null;
        ListNode head = null;
        check(expectedHead, RemoveDuplicatesFromSortedLists.execute(head));
    }

    @Test
    public void test_002() {
        ListNode expectedHead = new ListNode(1);
        ListNode head = new ListNode(1);
        check(expectedHead, RemoveDuplicatesFromSortedLists.execute(head));
    }

    @Test
    public void test_003() {
        ListNode expectedHead = new ListNode(1);
        expectedHead.next = new ListNode(2);

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);

        check(expectedHead, RemoveDuplicatesFromSortedLists.execute(head));
    }


    @Test
    public void test_004() {
        ListNode expectedHead = new ListNode(1);

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);

        check(expectedHead, RemoveDuplicatesFromSortedLists.execute(head));
    }

    @Test
    public void test_005() {
        ListNode expectedHead = new ListNode(1);
        expectedHead.next = new ListNode(2);
        expectedHead.next.next = new ListNode(4);

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);

        check(expectedHead, RemoveDuplicatesFromSortedLists.execute(head));
    }

    public void test_006() {
        ListNode expectedHead = new ListNode(1);
        expectedHead.next = new ListNode(2);
        expectedHead.next.next = new ListNode(4);
        expectedHead.next.next.next = new ListNode(5);

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(5);

        check(expectedHead, RemoveDuplicatesFromSortedLists.execute(head));
    }
}
