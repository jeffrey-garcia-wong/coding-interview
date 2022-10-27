package com.jeffrey.hackkerank.lists;

class Merge2SortedLinkedLists {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }

        @Override
        public String toString() {
            SinglyLinkedListNode curr = this;
            StringBuilder sb = new StringBuilder();
            while (curr != null) {
                sb.append(curr.data);
                sb.append(" ");
                curr = curr.next;
            }
            return sb.toString();
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
    }

    public static SinglyLinkedListNode execute(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        return solutionV1(head1, head2);
    }

    /**
     * complete the mergeLists function below.
     */
    private static SinglyLinkedListNode solutionV1(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        SinglyLinkedListNode curr1 = head1;
        SinglyLinkedListNode curr2 = head2;

        SinglyLinkedListNode mergeHead = null;
        SinglyLinkedListNode mergeCurr = null;

        while (true) {
            if (curr2!=null && curr1!=null) {
                if (curr2.data < curr1.data) {
                    if (mergeHead==null) {
                        mergeCurr = new SinglyLinkedListNode(curr2.data);
                        mergeHead = mergeCurr;
                    } else {
                        mergeCurr.next = new SinglyLinkedListNode(curr2.data);
                        mergeCurr = mergeCurr.next;
                    }
                    curr2 = curr2.next;
                } else {
                    if (mergeHead==null) {
                        mergeCurr = new SinglyLinkedListNode(curr1.data);
                        mergeHead = mergeCurr;
                    } else {
                        mergeCurr.next = new SinglyLinkedListNode(curr1.data);
                        mergeCurr = mergeCurr.next;
                    }
                    curr1 = curr1.next;
                }
            } else if (curr2 == null) {
                mergeCurr.next = curr1;
                break;
            } else {
                mergeCurr.next = curr2;
                break;
            }
        }

        return mergeHead;
    }

}
