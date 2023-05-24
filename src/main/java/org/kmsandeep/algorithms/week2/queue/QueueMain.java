package org.kmsandeep.algorithms.week2.queue;

import org.kmsandeep.algorithms.week2.stack.LinkedListStack;
import org.kmsandeep.algorithms.week2.stack.Stack;

public class QueueMain {
    public static void main(String[] args) {
//        Queue<Integer> ints = new FixedCapacityArrayQueue<>(5);
//        Queue<Integer> ints = new DynamicCapacityArrayQueue<>(2);
        Queue<Integer> ints = new LinkedListQueue<>();
//        System.out.println(ints.);

//        ints.enqueue(5);
//        System.out.println("-->" + ints.dequeue());

//        ints.enqueue(1);
//        System.out.println("-->" + ints.dequeue());

        ints.enqueue(7);
        ints.enqueue(3);
        ints.enqueue(2);
        System.out.println(ints.dequeue());
        System.out.println(ints.dequeue());
        ints.enqueue(17);
        ints.enqueue(98);
        ints.enqueue(12);
        System.out.println(ints.dequeue());
        System.out.println(ints.dequeue());
        ints.enqueue(14);
        ints.enqueue(23);
//        ints.enqueue(45);

//        System.out.println(ints.dequeue());
//        System.out.println(ints.dequeue());
        System.out.println("---------------------");
        ints.forEach(System.out::println);
    }
}
