package com.snmill.cp;

import java.util.Scanner;

/**
 *
 */
public class QuicksortInPlace {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int size = scanner.nextInt();
            int[] unsortedArray = new int[size];
            for (int t = 0; t < size; t++) {
                unsortedArray[t] = scanner.nextInt();
            }
            sorting(unsortedArray, (int[] afterPartition) -> {
                boolean first = true;
                for (int element : afterPartition) {
                    if (first) {
                        first = false;
                    } else {
                        System.out.print(" ");
                    }
                    System.out.print(element);
                }
                System.out.println();
            });
        }
    }

    interface OnPartition {

        void afterPartition(int[] afterPartition);
    }

    static void sorting(int[] unsorted, OnPartition listener) {
        sorting(unsorted, 0, unsorted.length, listener);
    }

    static void sorting(int[] unsorted, int indexFrom, int indexTo, OnPartition listener) {
        if (indexTo - indexFrom > 1) {
            int nextIndexOfPivot = partition(unsorted, indexFrom, indexTo);
            listener.afterPartition(unsorted);
            sorting(unsorted, indexFrom, nextIndexOfPivot, listener);
            sorting(unsorted, nextIndexOfPivot + 1, indexTo, listener);
        }
    }

    static int partition(int[] input, int indexFrom, int indexTo) {
        int pivotValue = input[indexTo - 1];

        FirstGreaterThanPivotCache firstGreaterThanPivotCache = new FirstGreaterThanPivotCache();

        for (int considerIndex = indexFrom; considerIndex < indexTo - 1; considerIndex++) {
            int considerValue = input[considerIndex];
            if (considerValue >= pivotValue) {
                if (firstGreaterThanPivotCache.hasNotFoundYet()) {
                    firstGreaterThanPivotCache.found(considerIndex, considerValue);
                }
            } else if (considerValue < pivotValue && firstGreaterThanPivotCache.wasFound()) {
                // swap
                input[firstGreaterThanPivotCache.index] = input[considerIndex];
                input[considerIndex] = firstGreaterThanPivotCache.value;

                int indexOfFirstGreater = indexOfFirstGreaterValue(input, firstGreaterThanPivotCache.index, pivotValue);
                int valueOfFirstGreater = input[indexOfFirstGreater];

                firstGreaterThanPivotCache.found(indexOfFirstGreater, valueOfFirstGreater);
            }
        }

        if (firstGreaterThanPivotCache.wasFound()) {
            input[firstGreaterThanPivotCache.index] = pivotValue;
            input[indexTo - 1] = firstGreaterThanPivotCache.value;
            return firstGreaterThanPivotCache.index;
        } else {
            return indexTo - 1;
        }

    }

    static int indexOfFirstGreaterValue(int[] input, int indexFrom, int pivot) {
        for (int i = indexFrom; i < input.length; i++) {
            if (input[i] >= pivot) {
                return i;
            }
        }
        throw new RuntimeException();
    }

    static class FirstGreaterThanPivotCache {

        int index;
        int value;
        boolean found = false;

        void found(int index, int value) {
            this.index = index;
            this.value = value;
            found = true;
        }

        boolean wasFound() {
            return found;
        }

        boolean hasNotFoundYet() {
            return !found;
        }
    }

}
