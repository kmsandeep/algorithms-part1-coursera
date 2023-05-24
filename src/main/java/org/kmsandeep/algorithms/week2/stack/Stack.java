package org.kmsandeep.algorithms.week2.stack;

import java.util.Iterator;
import java.util.function.Consumer;

public interface  Stack<E> extends Iterable<E>{
   public boolean isEmpty();
   public void push(E e);
   public E pop();
   public int capacity();
}
