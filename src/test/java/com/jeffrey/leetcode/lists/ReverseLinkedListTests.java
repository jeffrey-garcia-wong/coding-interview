package com.jeffrey.leetcode.lists;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.fail;

public class ReverseLinkedListTests {

    private void check(ReverseLinkedList.ListNode resultHead, ReverseLinkedList.ListNode reversedHead) {
        if (resultHead==null && reversedHead==null) return;

        ReverseLinkedList.ListNode resultNode;
        ReverseLinkedList.ListNode reversedNode;

        resultNode = resultHead;
        reversedNode = reversedHead;
        while (resultNode.next!=null && reversedHead.next!=null) {
            if (resultNode.val != reversedNode.val)
                fail("node value un-matched");
            resultNode = resultNode.next;
            reversedNode = reversedNode.next;
        }

        if (resultNode.next!=null || reversedNode.next!=null)
            fail("reversed list un-match");
    }

    @Test
    public void test_001() {
        check(null, ReverseLinkedList.execute(null));
    }

    @Test
    public void test_002() {
        ReverseLinkedList.ListNode resultHead = new ReverseLinkedList.ListNode(1);
        ReverseLinkedList.ListNode head = new ReverseLinkedList.ListNode(1);
        check(resultHead, ReverseLinkedList.execute(head));
    }

    @Test
    public void test_003() {
        ReverseLinkedList.ListNode resultHead = new ReverseLinkedList.ListNode(2);
        resultHead.next = new ReverseLinkedList.ListNode(1);
        ReverseLinkedList.ListNode head = new ReverseLinkedList.ListNode(1);
        head.next = new ReverseLinkedList.ListNode(2);
        check(resultHead, ReverseLinkedList.execute(head));
    }

    @Test
    public void test_004() {
        ReverseLinkedList.ListNode resultHead = new ReverseLinkedList.ListNode(5);
        resultHead.next = new ReverseLinkedList.ListNode(4);
        resultHead.next.next = new ReverseLinkedList.ListNode(3);
        resultHead.next.next.next = new ReverseLinkedList.ListNode(2);
        resultHead.next.next.next.next = new ReverseLinkedList.ListNode(1);

        ReverseLinkedList.ListNode head = new ReverseLinkedList.ListNode(1);
        head.next = new ReverseLinkedList.ListNode(2);
        head.next.next = new ReverseLinkedList.ListNode(3);
        head.next.next.next = new ReverseLinkedList.ListNode(4);
        head.next.next.next.next = new ReverseLinkedList.ListNode(5);

        check(resultHead, ReverseLinkedList.execute(head));
    }

}
