package org.kmsandeep.algorithms.week3.mergesort;

public class MergeSort {
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(a, aux, 0, a.length - 1);
    }

    private void sort(Comparable[] a, Comparable[] aux, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            sort(a, aux, low, mid);
            sort(a, aux, mid + 1, high);
            merge(a, aux, low, mid, high);
        }
    }

    private void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high) {
        for (int k = 0; k <= high; k++) {
            aux[k] = a[k];
        }
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > high) a[k] = aux[i++];
            else if (aux[i].compareTo(aux[j]) <= 0) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }
}
