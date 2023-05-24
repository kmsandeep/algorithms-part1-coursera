package org.kmsandeep.algorithms.week2.queue;

public interface Queue<E> extends Iterable<E>{
    public void enqueue(E e);
    public E dequeue();
    public boolean isEmpty();
    public int capacity();
}
