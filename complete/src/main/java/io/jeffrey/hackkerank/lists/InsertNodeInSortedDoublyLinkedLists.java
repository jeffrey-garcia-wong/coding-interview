package io.jeffrey.hackkerank.lists;

/**
 * <h1>Insert a node into a sorted doubly linked list.</h1>
 *
 * Given a reference to the head of a doubly-linked list and an integer, <i>data</i>,
 * create a new DoublyLinkedListNode object having data value <i>data</i> and insert
 * it at the proper location to maintain the sort.<p/>
 *
 * <b>Example</b><br/>
 * head refers to the list:
 * <pre>
 * {@code
 * 1 <-> 2 <-> 4 <-> NULL
 * data = 3
 * }
 * </pre>
 * return a reference to the new list:
 * <pre>
 * {@code
 * 1 <-> 2 <-> 3 <-> 4 <-> NULL
 * }
 * </pre>
 *
 * <b>Function Description</b><br/>
 * Complete the sortedInsert function in the editor below,
 * sortedInsert has two parameters:
 * <ul>
 *     <li>
 *         DoublyLinkedListNode pointer head: a reference
 *         to the head of a doubly-linked list
 *     </li>
 *     <li>
 *         int data: An integer denoting the value of the
 *         <i>data</i> field for the DoublyLinkedListNode
 *         you must insert into the list.
 *     </li>
 * </ul>
 *
 * <b>Returns</b><br/>
 * <ul>
 *     <li>
 *         DoublyLinkedListNode pointer: a reference to the
 *         head of the list
 *     </li>
 * </ul>
 *
 * Note: Recall that an empty list (i.e., where head=NULL) and a
 * list with one element are sorted lists.
 *
 * <b>Constraints</b><br/>
 * <ul>
 *     <li>
 *         1 <= t <= 10
 *     </li>
 *     <li>
 *         1 <= n <= 1000
 *     </li>
 *     <li>
 *         1 <= DoublyLinkedListNode.data <= 1000
 *     </li>
 * </ul>
 *
 * <b>Sample Input</b><br/>
 * <pre>
 * {@code
 * list = 1 <=> 3 <=> 4 <=> 10
 * add 5
 * }
 * </pre>
 *
 * <b>Sample Output</b><br/>
 * <pre>
 * {@code
 * list = 1 <=> 3 <=> 4 <=> 5 <=> 10
 * }
 * </pre>
 */
class InsertNodeInSortedDoublyLinkedLists {

    static class DoublyLinkedListNode {
        int data;
        DoublyLinkedListNode next;
        DoublyLinkedListNode prev;
    }

    static DoublyLinkedListNode execute(DoublyLinkedListNode node, int data) {
        return solutionV1(node, data);
    }

    private static DoublyLinkedListNode solutionV1(DoublyLinkedListNode node, int data) {
        // Design the algorithm here
        /*
         * There are 2 main requirements
         * - traverse the list in one pass
         * - insert the node in-place
         *
         * The solution must be traversing all the nodes in the list for once
         * and swap the pointers as the traversal take place.
         *
         * Implement a for-loop to iterate through all the node
         * until there is no more node.
         *
         * For each iteration, do the following 4 steps:
         * - check whether the new node's value is less than current node's value
         *   - if YES
         *     - insert the node before current node
         *     - new node's prev point to previous node
         *     - new node's next point to next node
         *     - previous node's next point to new node
         *     - current node's previous point to new node
         *   - if NO
         *     - advance the previous node to current node
         *     - advance the current node to next node
         *
         * To achieve first 2 steps we need additional references:
         * - a prev node reference outside the for-loop
         * - a next node reference (tmp) inside the for-loop
         *
         * Once the for-loop is exited, if current node is the last node
         * (current node's next == NULL), then we know the insertion have
         * not happened, there are 2 possible cases:
         * - new node's value is larger than the last node (insert after)
         * - new node's value is smaller or equal to the last node (insert before)
         */

        // Write the code here
        DoublyLinkedListNode currNode = node;
        DoublyLinkedListNode headNode = node;
        DoublyLinkedListNode prevNode = null;

        DoublyLinkedListNode newNode = new DoublyLinkedListNode();
        newNode.data = data;

        if (node == null) return newNode;

        while (currNode.next != null) {
            if (currNode.data >= newNode.data) {
                newNode.prev = prevNode;
                newNode.next = currNode;
                currNode.prev = newNode;
                if (prevNode == null) {
                    headNode = newNode;
                } else {
                    prevNode.next = newNode;
                }
                break;
            }

            prevNode = currNode;
            currNode = currNode.next;
        }

        // at the last node of the initial list and the new node not inserted
        if (currNode.next == null) {
            if (currNode.data >= newNode.data) {
                // add before the last node
                newNode.prev = prevNode;
                newNode.next = currNode;
                currNode.prev = newNode;
                if (prevNode == null) {
                    headNode = newNode;
                } else {
                    prevNode.next = newNode;
                }
            } else {
                // add after the last node
                currNode.next = newNode;
                newNode.prev = currNode;
                newNode.next = null;
            }
        }

        return headNode;
    }
}
