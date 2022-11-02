package io.jeffrey.leetcode.lists;

/**
 * <h1>Merge Two Sorted Lists</h1><p/>
 *
 * You are given the heads of two sorted linked lists list1 and list2.<br/>
 * Merge the two lists in a one sorted list. The list should be made by
 * splicing together the nodes of the first two lists.<br/>
 * Return the head of the merged linked list.<p/>
 *
 * <b>Example 1:</b><br/>
 * <pre>
 * {@code
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * }
 * </pre>
 *
 * <b>Example 2:</b><br/>
 * <pre>
 * {@code
 * Input: list1 = [], list2 = []
 * Output: []
 * }
 * </pre>
 *
 * <b>Example 3:</b><br/>
 * <pre>
 * {@code
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 * }
 * </pre>
 *
 * <b>Constraints:</b>
 * <ul>
 *     <li>The number of nodes in both lists is in the range [0, 50].</li>
 *     <li>-100 <= Node.val <= 100</li>
 *     <li>Both list1 and list2 are sorted in non-decreasing order.</li>
 * </ul>
 */
class MergeTwoSortedLists {

    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    static ListNode execute(ListNode list1, ListNode list2) {
        return solutionV1(list1, list2);
    }

    private static ListNode solutionV1(ListNode list1, ListNode list2) {
        // Design the algorithm here
        /*
         * Iterate every node in both lists and compare the value
         * of the nodes, if the smaller node is found in list 1,
         * the smaller node will be linked and the current node's
         * pointer of list 1 will be advanced, vice versa if the
         * smaller node is found in list 2. This process repeats
         * until either the current node in list 1 or 2 become
         * null.
         *
         * At the end of the process, if there is any remaining
         * node found from either of the list, simply link
         * the first node in the remaining list with the current
         * node of the result list.
         *
         * The space complexity is O(N) since the merging is
         * happens in-place and does not incur additional storage
         * for the result list. And the time complexity is O(N)
         * as only one traversal is required.
         *
         * To achieve this operation, we require 2 pointers
         * - a current node pointer for list 1
         * - a current node pointer for list 2
         * - a head node pointer for the result list
         * - a current node pointer for the result list
         */

        // Write the code here
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode currNode1 = list1;
        ListNode currNode2 = list2;
        ListNode headNode = null;
        ListNode currNode = null;

        while (currNode1!=null && currNode2!=null) {
            if (currNode1.val <= currNode2.val) {
                if (currNode == null) {
                    currNode = currNode1;
                } else {
                    currNode.next = currNode1;
                    currNode = currNode.next;
                }
                currNode1 = currNode1.next;
            } else {
                if (currNode == null) {
                    currNode = currNode2;
                } else {
                    currNode.next = currNode2;
                    currNode = currNode.next;
                }
                currNode2 = currNode2.next;
            }
            if (headNode == null) headNode = currNode;
        }

        if (currNode1 != null) {
            currNode.next = currNode1;
        }
        if (currNode2 != null) {
            currNode.next = currNode2;
        }

        return headNode;
    }
}
