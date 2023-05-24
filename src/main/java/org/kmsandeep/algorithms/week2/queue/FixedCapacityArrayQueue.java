package org.kmsandeep.algorithms.week2.queue;

import org.kmsandeep.algorithms.week2.stack.FixedCapacityArrayStack;

import java.util.Iterator;

public class FixedCapacityArrayQueue<E> implements Queue<E> {

    private E[] items;
    private int first = -1;
    private int last = -1;
    private int size = 0;
    private int capacity;

    public FixedCapacityArrayQueue(int capacity) {
        this.capacity = capacity;
        items = (E[]) new Object[capacity];
    }

    private class FixedCapacityArrayQueueIterator<E> implements Iterator<E> {
        private int f = first;
        private int c = 0;
        @Override
        public boolean hasNext() {
            return f != -1 && c++ < size;
        }

        @Override
        public E next() {
            E item = (E) items[f];
            f = (f + 1) % capacity;
            return item;
        }
    }

    @Override
    public void enqueue(E e) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        } else {
            if (first == -1){
                first = 0;
            }
            last = (last + 1) % capacity;
            items[last] = e;
            size++;
        }

    }

    private boolean isFull() {
        return (first == 0 && last == capacity - 1) || (first == last + 1);
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        } else {
            E item = items[first];
            if (first == last) {
                first = last = -1;
            } else {
                first = (first + 1) % capacity;
            }
            size--;
            return item;

        }
    }

    @Override
    public boolean isEmpty() {
        return first == -1;
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new FixedCapacityArrayQueueIterator();
    }
}
