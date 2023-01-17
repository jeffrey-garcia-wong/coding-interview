package io.jeffrey.leetcode.lists;

/**
 * <h1>Remove Linked List Elements</h1><p/>
 *
 * Given the head of a linked list and an integer val,
 * remove all the nodes of the linked list that has
 * Node.val == val, and return the new head.<p/>
 *
 * <b>Example 1:</b><br/>
 * <pre>
 * {@code
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 * }
 * </pre>
 *
 * <b>Example 2:</b><br/>
 * <pre>
 * {@code
 * Input: head = [], val = 1
 * Output: []
 * }
 * </pre>
 *
 * <b>Example 3:</b><br/>
 * <pre>
 * {@code
 * Input: head = [7,7,7,7], val = 7
 * Output: []
 * }
 * </pre>
 *
 * <b>Constraints:</b><br/>
 * <ul>
 *     <li>The number of nodes in the list is in the range [0, 104].</li>
 *     <li>1 <= Node.val <= 50</li>
 *     <li>0 <= val <= 50</li>
 * </ul>
 */
class RemoveElements {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    static ListNode execute(ListNode head, int val) {
        return solutionV1(head, val);
    }

    private static ListNode solutionV1(ListNode head, int val) {
        // Design the algorithm here
        /*
         * Iterate through every node in the list.
         * If the current node value equals to the
         * target value, remove the current node
         * (de-reference it) by assigning prev's
         * next pointer to current's next node.
         * 1 (prev) -> 2 (current) -> 3 (current's next)
         * 1 (prev) -> 3 (current's next)
         *
         * This process repeats until current pointer
         * reached the last node in list.
         *
         * We need 2 pointers for the algorithm to work:
         * - the previous node pointer
         * - the current node pointer
         */

        // Write the code here
        if (head == null) return head;

        ListNode currNode = head;
        ListNode prevNode = null;

        while (currNode.next != null) {
            if (currNode.val==val) {
                if (prevNode!=null) {
                    prevNode.next = currNode.next;
                } else {
                    head = currNode.next;
                }
            } else {
                prevNode = currNode;
            }
            currNode = currNode.next;
        }

        if (currNode.val==val) {
            if (prevNode!=null) {
                prevNode.next = currNode.next;
            } else {
                head = currNode.next;
            }
        }

        return head;
    }
}
