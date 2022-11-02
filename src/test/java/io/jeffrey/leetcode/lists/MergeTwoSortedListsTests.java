package io.jeffrey.leetcode.lists;

import static io.jeffrey.leetcode.lists.MergeTwoSortedLists.ListNode;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class MergeTwoSortedListsTests {

    private void check(ListNode expectedHead, ListNode actualHead) {
        if (expectedHead==null && actualHead==null) return;

        ListNode expectedNode = expectedHead;
        ListNode actualNode = actualHead;

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
        ListNode list1 = null;
        ListNode list2 = null;
        check(expectedHead, MergeTwoSortedLists.execute(list1, list2));
    }

    @Test
    public void test_002() {
        ListNode expectedHead = new ListNode(1);
        ListNode list1 = new ListNode(1);
        ListNode list2 = null;
        check(expectedHead, MergeTwoSortedLists.execute(list1, list2));
    }

    @Test
    public void test_003() {
        ListNode expectedHead = new ListNode(1);
        ListNode list1 = null;
        ListNode list2 = new ListNode(1);
        check(expectedHead, MergeTwoSortedLists.execute(list1, list2));
    }

    @Test
    public void test_004() {
        ListNode expectedHead = new ListNode(1);
        expectedHead.next = new ListNode(1);

        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(1);

        check(expectedHead, MergeTwoSortedLists.execute(list1, list2));
    }

    @Test
    public void test_005() {
        ListNode expectedHead = new ListNode(1);
        expectedHead.next = new ListNode(1);
        expectedHead.next.next = new ListNode(2);
        expectedHead.next.next.next = new ListNode(3);
        expectedHead.next.next.next.next = new ListNode(4);
        expectedHead.next.next.next.next.next = new ListNode(4);

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        check(expectedHead, MergeTwoSortedLists.execute(list1, list2));
    }

    @Test
    public void test_006() {
        ListNode expectedHead = new ListNode(1);
        expectedHead.next = new ListNode(1);
        expectedHead.next.next = new ListNode(2);
        expectedHead.next.next.next = new ListNode(4);
        expectedHead.next.next.next.next = new ListNode(4);
        expectedHead.next.next.next.next.next = new ListNode(4);
        expectedHead.next.next.next.next.next.next = new ListNode(5);

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        list1.next.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(4);

        check(expectedHead, MergeTwoSortedLists.execute(list1, list2));
    }
}
