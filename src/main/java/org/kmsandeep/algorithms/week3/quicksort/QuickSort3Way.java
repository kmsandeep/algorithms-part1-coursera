package org.kmsandeep.algorithms.week3.quicksort;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuickSort3Way {
//    public static void sort(List <? extends Comparable> a) {
//        Random rn = new Random();
//        Collections.shuffle(a);
//        Comparable[] array = a.toArray(Comparable[]::new);
//        new QuickSort3Way().sort(array, 0, array.length - 1);
//    }
    public static void sort(Comparable[] a) {
        Random rn = new Random();
//        Collections.shuffle(List.of(a));
        new QuickSort3Way().sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int low, int high) {
        if (low > high)
            return;
        int i = low;
        int lt = low;
        int gt = high;
        Comparable v = a[low];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exchange(a, i++, lt++);
            else if (cmp > 0) exchange(a, i, gt--);
            else i++;
        }
        sort(a, low, lt - 1);
        sort(a, gt + 1, high);
    }

    private void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
