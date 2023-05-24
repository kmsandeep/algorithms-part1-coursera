package org.kmsandeep.algorithms.week2.stack;

import java.util.EmptyStackException;
import java.util.Iterator;

public class LinkedListStack<E> implements Stack<E> {
    private Node first = null;

    private class Node {
        E item;
        Node next;

        Node(E e) {
            item = e;
            next = null;
        }
    }
    class LinkedListStackIterator implements Iterator<E> {
        private Node node = first;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public E next() {
            E item = node.item;
            node = node.next;
            return item;
        }
    }
    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void push(E e) {
        Node oldFirst = first;
        first = new Node(e);
        first.next = oldFirst;
    }

    @Override
    public E pop() {
        if (first == null) {
            throw new EmptyStackException();
        }
        E item = first.item;
        first = first.next;
        return item;
    }

    @Override
    public int capacity() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListStackIterator();
    }
}
