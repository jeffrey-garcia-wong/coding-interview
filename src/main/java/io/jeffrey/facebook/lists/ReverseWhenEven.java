package io.jeffrey.facebook.lists;

class ReverseWhenEven {

    static class Node {
        int data;
        Node next;
        public Node(int val) {
            this.data = val;
        }
    }

    static Node execute(Node head) {
        return solutionV1(head);
    }

    private static Node solutionV1(Node head) {
        // Design the algorithm here
        /*
         * Iterate through each node in the list, if the
         * current node's value is even number, pass the
         * current node into a reverse routine, the reverse
         * routine should return the head node and tail node
         * of the reversed sub-list, even if there is only
         * one node.
         *
         * The reversed sub-list must then be connected
         * back to both end of the list, this is achieved
         * by having the previous node to link with head
         * node of sub-list, while tail node of sub-list
         * link with the next node.
         *
         * Since this operation is in-place, space complexity
         * is therefore O(1), while we iterate through all
         * the nodes for once only, the time-complexity
         * is O(N).
         */

        // Write the code here
        if (head == null) return head;
        Node currNode = head;
        Node prevNode = null;

        while (currNode!=null && currNode.next!=null) {
            if (currNode.data % 2 == 0) {
                SubList subList = reverse(currNode);
                if (prevNode == null) {
                    head = subList.headNode;
                } else {
                    prevNode.next = subList.headNode;
                }
                currNode = subList.tailNode.next;
            } else {
                prevNode = currNode;
                currNode = currNode.next;
            }
        }

        return head;
    }

    private static SubList reverse(Node currNode) {
        Node headNode = null;
        Node tailNode = currNode;
        Node nextNode = currNode.next;

        while (nextNode!=null && nextNode.data%2==0) {
            Node prevNode = currNode;
            currNode = nextNode;
            nextNode = nextNode.next;
            currNode.next = prevNode;
        }

        headNode = currNode;
        tailNode.next = nextNode;
        return new SubList(headNode, tailNode);
    }

    private static class SubList {
        Node headNode;
        Node tailNode;
        SubList(Node headNode, Node tailNode) {
            this.headNode = headNode;
            this.tailNode = tailNode;
        }
    }
}
