package lc222ak_assign1;

import java.util.Iterator;

public class Queue implements QueueInterface, Iterable {

    private Node head;
    private Node tail;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public void enqueue(Object element) {
        Node newNode = new Node(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public Object dequeue() throws IndexOutOfBoundsException {
        if(head == null) {
            throw new IndexOutOfBoundsException();
        }

        Object returnValue = head.data;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }

        size--;
        return returnValue;
    }

    public Object first() throws IndexOutOfBoundsException {
        if (head != null) {
            return head.data;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public Object last() throws IndexOutOfBoundsException {
        if (tail != null) {
            return tail.data;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean contains(Object o) {
        Node next = head;
        boolean result = false;
        while (next != null) {
            if (next.data.equals(o)) {
                result = true;
                break;
            }
            next = next.next;
        }
        return result;
    }

    public Iterator iterator() {
        return new QueueIterator();
    }

    private class Node {
        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    private class QueueIterator implements Iterator {
        Node next = head;

        public boolean hasNext() {
            return next != null;
        }

        public Object next() {
            Object result = next.data;
            next = next.next;
            return result;
        }
    }
}
