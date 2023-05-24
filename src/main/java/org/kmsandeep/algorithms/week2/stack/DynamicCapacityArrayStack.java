package org.kmsandeep.algorithms.week2.stack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.function.Consumer;

public class DynamicCapacityArrayStack<E> implements Stack<E> {
    private static int DEFAULT_CAPACITY = 8;
    private  int capacity;
    private E[] items;
    private int top = 0;

    public DynamicCapacityArrayStack(int capacity) {
        this.capacity = capacity;
        this.items = (E[]) new Object[this.capacity];
    }

    public DynamicCapacityArrayStack() {
         this(DEFAULT_CAPACITY);
    }
    class DynamicCapacityArrayStackIterator implements Iterator<E> {
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

    private void resize(int newCapacity) {
        E[] copy = (E[]) new Object[newCapacity];
        for (int i = 0; i < top ; i++) {
            copy[i] = this.items[i];
        }
        this.items = copy;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public void push(E e) {
        if (top == capacity) {
            resize(2 * capacity);
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
        if(top>0 && top == capacity/4){
            resize(capacity/2);
        }
        return item;
    }

    @Override
    public int capacity() {
        return this.capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new DynamicCapacityArrayStackIterator();
    }

}
