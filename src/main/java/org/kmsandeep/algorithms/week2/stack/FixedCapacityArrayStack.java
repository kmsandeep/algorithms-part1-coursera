package org.kmsandeep.algorithms.week2.stack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.function.Consumer;

public class FixedCapacityArrayStack<E> implements Stack<E> {

    private int capacity;
    private E[] items;
    private int top = 0;

    class FixedCapacityArrayStackIterator implements Iterator<E> {
        private int i = top;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public E next() {
            return (E) items[--i];
        }
    }

    public FixedCapacityArrayStack(int capacity) {
        this.capacity = capacity;
        items = (E[]) new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public void push(E e) {
        if (top == capacity) {
            throw new ArrayIndexOutOfBoundsException("Stack capacity reached.");
        }
        items[top++] = e;
    }

    @Override
    public E pop() {
        if (top == 0) {
            throw new EmptyStackException();
        }
        E item = items[--top];
        items[top] = null;
        return item;
    }

    @Override
    public int capacity() {
        return this.capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new FixedCapacityArrayStackIterator();
    }

}
