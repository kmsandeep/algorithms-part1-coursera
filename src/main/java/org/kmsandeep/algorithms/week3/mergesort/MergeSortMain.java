package org.kmsandeep.algorithms.week3.mergesort;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeSortMain {

    private List<Integer> randomIntegers(int min, int max, int size) {
        return Stream.generate(() -> new Random().nextInt(max))
                .map(n -> n + min)
                .filter(n -> n <= max)
                .limit(size)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        MergeSortMain main = new MergeSortMain();
        List<Integer> integers = main.randomIntegers(5, 100, 20);
        Integer[] array = integers.toArray(Integer[]::new);
        MergeSort.sort(array);


        Arrays.stream(array).sorted().forEach(System.out::println);
    }
}
