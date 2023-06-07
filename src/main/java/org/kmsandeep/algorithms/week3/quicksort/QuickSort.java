package org.kmsandeep.algorithms.week3.quicksort;

import java.util.Random;

public class QuickSort {
    public static void sort(Comparable[] a) {
        Random rn = new Random();
//        Collections.shuffle(List.of(a));
        new QuickSort().sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int low, int high) {
        if (low < high) {
            int j = partition(a, low, high);
            sort(a, low, j - 1);
            sort(a, j + 1, high);
        }
    }

    private int partition(Comparable[] a, int low, int high) {
        int i = low;
        int j = high + 1;
        while (true) {
            while (a[++i].compareTo(a[low]) <= 0) {
                if (i == high) break;
            }
            while (a[--j].compareTo(a[low]) > 0) {
                if (j == low) break;
            }
            if (i >= j) break;
            exchange(a, i, j);
        }
        exchange(a,low,j);
        return j;
    }

    private void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
