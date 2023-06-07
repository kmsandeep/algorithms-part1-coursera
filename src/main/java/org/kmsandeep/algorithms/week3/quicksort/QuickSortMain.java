package org.kmsandeep.algorithms.week3.quicksort;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickSortMain {
    private List<Integer> randomIntegers(int min, int max, int size) {
        return Stream.generate(() -> new Random().nextInt(max))
                .map(n -> n + min)
                .filter(n -> n <= max)
                .limit(size)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        QuickSortMain main = new QuickSortMain();
        List<Integer> integers = main.randomIntegers(5, 100, 20);
        Integer[] array = integers.toArray(Integer[]::new);
//        QuickSort.sort(array);
        QuickSort3Way.sort(array);


        Arrays.asList(array).forEach(System.out::println);
    }
}
