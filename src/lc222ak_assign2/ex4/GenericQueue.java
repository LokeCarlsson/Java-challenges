package lc222ak_assign2.ex4;

import java.util.Iterator;

public class GenericQueue implements Queue{
    private Node head;
    private Node tail;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
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

    public Object dequeue() {
        if(head == null) {
            throw new IndexOutOfBoundsException();
        }
        Object returnValue = head.data;
        if (size > 1) {
            head = head.next;
        } else {
            head = null;
            tail = null;
        }
        size--;
        return returnValue;
    }

    public Object first() {
        if (head != null) {
            return head.data;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public Object last() {
        if (tail != null) {
            return tail.data;
        } else {
            throw new IndexOutOfBoundsException();
        }
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
            if (!hasNext()) throw new IndexOutOfBoundsException();
            Object result = next.data;
            next = next.next;
            return result;
        }
    }
}
