package io.jeffrey.leetcode.lists;

/**
 * <h1>Reverse Linked List</h1><p/>
 *
 * Given the head of a singly linked list, reverse the list,
 * and return the reversed list.<p/>
 *
 * <b>Example 1</b><br/>
 * <pre>
 * {@code
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * }
 * </pre>
 *
 * <b>Example 2</b><br/>
 * <pre>
 * {@code
 * Input: head = [1,2]
 * Output: [2,1]
 * }
 * </pre>
 *
 * <b>Example 3</b><br/>
 * <pre>
 * {@code
 * Input: head = []
 * Output: []
 * }
 * </pre>
 *
 * <b>Constraints:</b><br/>
 * <ul>
 *     <li>The number of nodes in the list is the range [0, 5000].</li>
 *     <li>-5000 <= Node.val <= 5000</li>
 * </ul>
 *
 */
class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    static ListNode execute(ListNode head) {
        // Design the algorithm here
        /*
         * Aim to reverse the list in 1 traverse, 3 pointers are required:
         * 1) current - for referencing the node being traversed
         * 2) new head - for referencing the new head of the reversed list
         * 3) previous - for referencing the next node of new head
         *
         * As we move along the list:
         * a) assign the previous node to new head node,
         * b) assign the new head to current node,
         * c) assign the current node to the next node
         *
         * The process repeats until there is no more
         * node remaining to be traversed.
         *
         * Time complexity = O(N)
         * Space complexity = O(N)
         */

        // Write the code here
        if (head == null) return head;

        ListNode newHead;
        ListNode curr;
        ListNode prev;

        // at the fist node
        curr = head;
        newHead = null;
        prev = null;

        while (curr.next != null) {
            ListNode tmp = curr.next;
            prev = newHead;
            newHead = curr;
            newHead.next = prev;
            curr = tmp;
        }

        // at the last node
        prev = newHead;
        newHead = curr;
        newHead.next = prev;

        return newHead;
    }

}
