package com.jeffrey.hackkerank.linkedlists;

class InsertNodeAtPosition {

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }

        @Override
        public String toString() {
            SinglyLinkedListNode curr = head;
            StringBuilder sb = new StringBuilder();
            while (curr != null) {
                sb.append(curr.data);
                sb.append(" ");
                curr = curr.next;
            }
            return sb.toString();
        }
    }


    public static SinglyLinkedListNode execute(SinglyLinkedListNode list, int data, int position) {
        return solutionV1(list, data, position);
    }

    /**
     * Complete the 'insertNodeAtPosition' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts following parameters:
     *  1. INTEGER_SINGLY_LINKED_LIST llist
     *  2. INTEGER data
     *  3. INTEGER position
     */
    private static SinglyLinkedListNode solutionV1(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode curr = head;
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

        int counter = 0;

        do {
            if (position == 0) {
                newNode.next = curr.next;
                head = newNode;
                break;
            } else {
                if (counter == position) {
                    newNode.next = curr;
                    prev.next = newNode;
                    curr = newNode;
                    break;
                }
            }

            prev = curr;
            curr = curr.next;
            counter++;
        } while (curr != null);

        return head;
    }
}
