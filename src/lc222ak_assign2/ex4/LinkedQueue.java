package lc222ak_assign2.ex4;

import java.util.Iterator;

public class LinkedQueue<T> implements Queue<T>{
    private Node head;
    private Node tail;
    private int size;

    /**
     * @return - Returns size of Queue
     */
    public int size() {
        return size;
    }

    /**
     * @return - Returns true if there is at least one element in the Queue
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @param element - Element to be added to the queue
     */
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

    /**
     * @return - Element that got removed from the queue
     */
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

    /**
     * @return - Return the first element in the queue
     */
    public T first() {
        if (head != null) {
            return head.data;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * @return - Returns the last element in the queue
     */
    public T last() {
        if (tail != null) {
            return tail.data;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * @return - A new instance of the QueueIterator
     */
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class Node {
        T data;
        Node next;

        /**
         * @param data - Element to be added to the queue
         */
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private class QueueIterator implements Iterator<T> {
        Node next = head;

        /**
         * @return - Returns true if there is a element next in the queue
         */
        public boolean hasNext() {
            return next != null;
        }

        /**
         * @return - Returns the element next in the queue
         */
        public T next() {
            if (!hasNext()) throw new IndexOutOfBoundsException();
            T result = next.data;
            next = next.next;
            return result;
        }
    }
}
