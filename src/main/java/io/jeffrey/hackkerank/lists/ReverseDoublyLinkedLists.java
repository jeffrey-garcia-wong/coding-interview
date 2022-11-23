package io.jeffrey.hackkerank.lists;

/**
 * <h1>Reverse a doubly linked list</h1>
 *
 * Given the pointer to the head node of a doubly linked list, reverse
 * the order of the nodes in place. That is, change the next and prev
 * pointers of the nodes so that the direction of the list is reversed.
 * Return a reference to the head node of the reversed list.<p/>
 *
 * Note: The head node might be NULL to indicate that the list is empty.<p/>
 *
 * <b>Function Description</b><br/>
 * Complete the reverse function in the editor below.<br/>
 * <ul>
 *     <li>
 *         Reverse has the following parameter(s):<br/>
 *         - DoublyLinkedListNode head: a reference to the head of a DoublyLinkedList
 *     </li>
 *     <li>
 *         Returns:<br/>
 *         - DoublyLinkedListNode: a reference to the head of the reversed list
 *     </li>
 * </ul>
 *
 * <b>Constraints</b><br/>
 * <ul>
 *     <li>1 <= t <= 10</li>
 *     <li>0 <= n <= 1000</li>
 *     <li>1 <= DoublyLinkedListNode.data <= 1000</li>
 * </ul>
 *
 * <b>Sample Input</b><br/>
 * <pre>
 * {@code
 * 1 2 3 4
 * }
 * </pre>
 *
 * <b>Sample Output</b><br/>
 * <pre>
 * {@code
 * 4 3 2 1
 * }
 * </pre>
 *
 * <b>Explanation</b><br/>
 * The initial doubly linked list is:
 * <pre>
 * {@code
 * 1 <-> 2 <-> 3 <-> 4 <-> NULL
 * }
 * </pre>
 * The reversed doubly linked list is:
 * <pre>
 * {@code
 * 4 <-> 3 <-> 2 <-> 1 <-> NULL
 * }
 * </pre>
 */
class ReverseDoublyLinkedLists {

    static class DoublyLinkedListNode {
        int data;
        DoublyLinkedListNode next;
        DoublyLinkedListNode prev;
    }

    static DoublyLinkedListNode execute(DoublyLinkedListNode node) {
        return solutionV1(node);
    }

    private static DoublyLinkedListNode solutionV1(DoublyLinkedListNode node) {
        // Design the algorithm here
        /*
         * There are 2 main requirements
         * - reverse the list in one pass
         * - reverse the list in-place
         *
         * The solution must be traversing all the nodes in the list for once
         * and swap the pointers as the traversal take place.
         *
         * Implement a for-loop to iterate through all the node
         * until there is no more node.
         *
         * For each iteration, do the following 4 steps:
         * - current node's next point to previous node
         * - current node's prev point to next node
         * - advance the previous node to current node
         * - advance the current node to next node
         *
         * To achieve first 2 steps we need additional references:
         * - a prev node reference outside the for-loop
         * - a next node reference (tmp) inside the for-loop
         *
         * Once the for-loop is exited the current node should be
         * at the last node:
         * - set the next node to previous node
         * - set the previous node to null
         */

        // Write the code here
        if (node == null) return null;

        DoublyLinkedListNode currNode = node;
        DoublyLinkedListNode prevNode = null;

        while (currNode.next != null) {
            DoublyLinkedListNode tmp = currNode.next;
            currNode.next = prevNode;
            currNode.prev = tmp;
            prevNode = currNode;
            currNode = tmp;
        }

        currNode.next = prevNode;
        currNode.prev = null;

        return currNode;
    }
}
