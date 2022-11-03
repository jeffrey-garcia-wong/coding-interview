package io.jeffrey.facebook.lists;

import org.junit.jupiter.api.Test;

import static io.jeffrey.facebook.lists.ReverseWhenEven.Node;
import static org.junit.jupiter.api.Assertions.fail;

public class ReverseWhenEvenTests {

    private void check(Node expectedHead, Node actualHead) {
        if (expectedHead==null && actualHead==null) return;

        Node expectedNode = expectedHead;
        Node actualNode = actualHead;

        while (expectedNode.next!=null && actualNode.next!=null) {
            if (expectedNode.data != actualNode.data)
                fail("node value un-matched");
            expectedNode = expectedNode.next;
            actualNode = actualNode.next;
        }

        if (actualNode.next!=null || expectedNode.next!=null)
            fail("result list un-match");
    }

    @Test
    public void test_001() {
        Node expectedHead = null;
        Node head = null;
        check(expectedHead, ReverseWhenEven.execute(head));
    }

    @Test
    public void test_002() {
        Node expectedHead = new Node(2);
        Node head = new Node(2);
        check(expectedHead, ReverseWhenEven.execute(head));
    }

    @Test
    public void test_003() {
        Node expectedHead = new Node(1);
        expectedHead.next = new Node(2);
        Node head = new Node(1);
        head.next = new Node(2);
        check(expectedHead, ReverseWhenEven.execute(head));
    }

    @Test
    public void test_004() {
        Node expectedHead = new Node(2);
        expectedHead.next = new Node(1);
        Node head = new Node(2);
        head.next = new Node(1);
        check(expectedHead, ReverseWhenEven.execute(head));
    }

    @Test
    public void test_005() {
        Node expectedHead = new Node(2);
        expectedHead.next = new Node(4);
        Node head = new Node(4);
        head.next = new Node(2);
        check(expectedHead, ReverseWhenEven.execute(head));
    }

    @Test
    public void test_006() {
        Node expectedHead = new Node(1);
        expectedHead.next = new Node(2);
        expectedHead.next.next = new Node(4);
        Node head = new Node(1);
        head.next = new Node(4);
        head.next.next = new Node(2);
        check(expectedHead, ReverseWhenEven.execute(head));
    }

    @Test
    public void test_007() {
        Node expectedHead = new Node(2);
        expectedHead.next = new Node(4);
        expectedHead.next.next = new Node(1);
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        check(expectedHead, ReverseWhenEven.execute(head));
    }

    @Test
    public void test_008() {
        Node expectedHead = new Node(1);
        expectedHead.next = new Node(4);
        expectedHead.next.next = new Node(2);
        expectedHead.next.next.next = new Node(3);
        expectedHead.next.next.next.next = new Node(5);
        expectedHead.next.next.next.next.next = new Node(6);

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(4);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        check(expectedHead, ReverseWhenEven.execute(head));
    }

    @Test
    public void test_009() {
        Node expectedHead = new Node(1);
        expectedHead.next = new Node(4);
        expectedHead.next.next = new Node(2);
        expectedHead.next.next.next = new Node(3);
        expectedHead.next.next.next.next = new Node(8);
        expectedHead.next.next.next.next.next = new Node(6);

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(4);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(6);
        head.next.next.next.next.next = new Node(8);

        check(expectedHead, ReverseWhenEven.execute(head));
    }
}
