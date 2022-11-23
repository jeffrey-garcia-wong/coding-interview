package io.jeffrey.hackkerank.lists;

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
