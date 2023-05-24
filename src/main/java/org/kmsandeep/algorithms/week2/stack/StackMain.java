package org.kmsandeep.algorithms.week2.stack;

public class StackMain {
    public static void main(String[] args) {
//        Stack<Integer> ints = new FixedCapacityArrayStack<>(5);
//        Stack<Integer> ints = new DynamicCapacityArrayStack<>();
        Stack<Integer> ints = new LinkedListStack<>();
//        System.out.println(ints.);
        ints.push(5);
        ints.push(1);
        ints.push(7);
        ints.push(3);
        ints.push(3);
        ints.push(12);
        ints.push(45);
//        System.out.println(ints.pop());
//        System.out.println(ints.pop());
//        System.out.println(ints.pop());
//        System.out.println(ints.pop());
//        System.out.println(ints.pop());

        ints.forEach(System.out::println);

    }
}
