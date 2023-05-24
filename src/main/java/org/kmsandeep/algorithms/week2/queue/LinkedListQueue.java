package org.kmsandeep.algorithms.week2.queue;

import java.util.Iterator;

public class LinkedListQueue<E> implements Queue<E> {
    private Node first = null;

    private class Node {
        E item;
        Node next;

        Node(E item) {
            this.item = item;
            this.next = null;
        }
    }

    private class LinkedListQueueIterator<E> implements Iterator<E> {

        Node f = first;

        @Override
        public boolean hasNext() {
            return f != null;
        }

        @Override
        public E next() {
            Node node = f;
            f = f.next;
            return (E) node.item;
        }
    }

    @Override
    public void enqueue(E e) {
        if (first == null) {
            first = new Node(e);
        } else {
            Node node = first;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(e);
        }
    }

    @Override
    public E dequeue() {
        if (first == null) {
            throw new RuntimeException("Queue is empty.");
        }
        E item = first.item;
        first = first.next;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int capacity() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListQueueIterator<>();
    }
}
