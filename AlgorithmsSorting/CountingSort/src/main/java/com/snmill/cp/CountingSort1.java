package com.snmill.cp;

import java.util.Scanner;

/**
 *
 */
public class CountingSort1 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int size = scanner.nextInt();
            int[] uncounted = new int[size];
            for (int i = 0; i < size; i++) {
                uncounted[i] = scanner.nextInt();
            }
            int[] counters = count(uncounted);

            for (int i = 0; i < counters.length; i++) {
                if (i > 0) {
                    System.out.print(" ");
                }
                System.out.print(counters[i]);
            }

        }
    }

    static int[] count(int[] uncounted) {
        int[] counters = new int[100];
        for (int i : uncounted) {
            counters[i]++;
        }
        return counters;
    }

}
