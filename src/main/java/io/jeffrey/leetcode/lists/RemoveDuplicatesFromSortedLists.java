package io.jeffrey.leetcode.lists;

/**
 * <h1>Remove Duplicates from Sorted List</h1><p/>
 *
 * Given the head of a sorted linked list, delete all duplicates
 * such that each element appears only once. Return the linked
 * list sorted as well.<p/>
 *
 * <b>Example 1:</b><br/>
 * <pre>
 * {@code
 * Input: head = [1,1,2]
 * Output: [1,2]
 * }
 * </pre>
 *
 * <b>Example 2:</b><br/>
 * <pre>
 * {@code
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 * }
 * </pre>
 *
 * <b>Constraints:</b><br/>
 * <ul>
 *     <li>The number of nodes in the list is in the range [0, 300].</li>
 *     <li>-100 <= Node.val <= 100</li>
 *     <li>The list is guaranteed to be sorted in ascending order.</li>
 * </ul>
 *
 */
class RemoveDuplicatesFromSortedLists {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    static ListNode execute(ListNode head) {
        return solutionV1(head);
    }

    private static ListNode solutionV1(ListNode head) {
        // Design the algorithm here
        /*
         * The idea is to iterate every node in the list,
         * since the nodes are sorted, nodes with equal
         * values must be grouped in sequence.
         *
         * So for each element we processed, we only
         * need to remember the last node whose value
         * is same as current node, instead of keeping
         * track to all the node's value that has been
         * visited. This keeps the space complexity as
         * O(1).
         *
         * Whenever we visit a new element, we compare
         * the current node value with the previous node
         * value, if they are equal, then we can remove
         * this node (de-reference it) by assigning prev's
         * next to current's next:
         * 1 (prev) -> 1 (current) -> 3 (current's next)
         * 1 (prev) -> 3 (current's next)
         *
         * This process repeats until current pointer
         * reached the last node in list.
         *
         * We need 3 pointers for the algorithm to work:
         * - the new head pointer
         * - the previous node pointer
         * - the current node pointer
         */

        // Write the code here
        if (head == null) return head;

        ListNode newHead = head;
        ListNode prevNode = null;
        ListNode current = head;

        while (current.next != null) {
            if (prevNode!=null && prevNode.val==current.val) {
                prevNode.next = current.next;
            } else {
                prevNode = current;
            }
            current = current.next;
        }

        if (prevNode!=null && prevNode.val==current.val) {
            prevNode.next = current.next;
        }

        return newHead;
    }
}
