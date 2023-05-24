package org.kmsandeep.algorithms.week2.queue;

import java.util.Iterator;

public class DynamicCapacityArrayQueue<E> implements Queue<E> {
    private static final int DEFAULT_CAPACITY = 8;
    private E[] items;
    private int first = -1;
    private int last = -1;
    private int size = 0;
    private int capacity;

    public DynamicCapacityArrayQueue(int capacity) {
        this.capacity = capacity;
        items = (E[]) new Object[capacity];
    }

    public DynamicCapacityArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    private class DynamicCapacityArrayQueueIterator implements Iterator {
        private int f = first;
        private int c = 0;

        @Override
        public boolean hasNext() {
            return f != -1 && c++ < size;
        }

        @Override
        public E next() {
            E item = items[f];
            f = (f + 1) % capacity;
            return item;
        }
    }

    @Override
    public void enqueue(E e) {
        if (isFull()) {
            resize(2 * capacity);
        }
        if (first == -1) {
            first = 0;
        }
        last = (last + 1) % capacity;
        items[last] = e;
        size++;
    }

    private boolean isFull() {
        return (first == 0 && last == capacity - 1) || first == last + 1;
    }

    private void resize(int newCapacity) {
        E[] copy = (E[]) new Object[newCapacity];
        int c = 0;
        for (int i = first; c < size; i = (i + 1) % capacity) {
            copy[c++] = items[i];
        }
        items = copy;
        first = 0;
        last = capacity-1;
        this.capacity = newCapacity;
    }

    @Override
    public E dequeue() {
        if (size == capacity / 4) {
            resize(capacity / 2);
        }
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty.");
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
        return new DynamicCapacityArrayQueueIterator();
    }
}
