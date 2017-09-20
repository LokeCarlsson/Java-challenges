package lc222ak_assign2.ex4;

import java.util.Iterator;

public class LinkedQueue<T> implements Queue<T>{
    private Node head;
    private Node tail;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(T element) {
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

    public T dequeue() {
        if(head == null) {
            throw new IndexOutOfBoundsException();
        }
        T returnValue = head.data;
        if (size == 1) {
            head = null;
            tail = null;
        } else if (size > 1) {
            head = head.next;
        }
        size--;
        return returnValue;
    }

    public T first() {
        if (head != null) {
            return head.data;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public T last() {
        if (tail != null) {
            return tail.data;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private class QueueIterator implements Iterator<T> {
        Node next = head;

        public boolean hasNext() {
            return next != null;
        }

        public T next() {
            if (!hasNext()) throw new IndexOutOfBoundsException();
            T result = next.data;
            next = next.next;
            return result;
        }
    }
}
