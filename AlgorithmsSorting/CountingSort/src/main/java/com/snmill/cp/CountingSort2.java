package com.snmill.cp;

import java.util.Scanner;

/**
 *
 */
public class CountingSort2 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int size = scanner.nextInt();
            int[] uncounted = new int[size];
            for (int i = 0; i < size; i++) {
                uncounted[i] = scanner.nextInt();
            }
            int[] sorted = sortWithCounters(count(uncounted), size);
            for (int i = 0; i < sorted.length; i++) {
                if (i > 0) {
                    System.out.print(" ");
                }
                System.out.print(sorted[i]);
            }

        }
    }

    static int[] sortWithCounters(int[] counters, int size) {
        int[] sorted = new int[size];
        int index = 0;

        for (int value = 0; value < counters.length; value++) {
            int toRepeat = counters[value];
            while (toRepeat-- > 0) {
                sorted[index] = value;
                index++;
            }
        }

        return sorted;
    }

    static int[] count(int[] uncounted) {
        int[] counters = new int[100];
        for (int i : uncounted) {
            counters[i]++;
        }
        return counters;
    }
}
