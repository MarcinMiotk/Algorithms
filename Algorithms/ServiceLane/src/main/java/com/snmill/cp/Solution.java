package com.snmill.cp;

import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int freeway = scanner.nextInt();
            int testCases = scanner.nextInt();

            int[] bikes = new int[freeway];
            int[] cars = new int[freeway];
            int[] trunks = new int[freeway];

            for (int f = 0; f < freeway; f++) {
                int type = scanner.nextInt();
                if (type == 1) {
                    bikes[f] = 1;
                }
                if (type == 2) {
                    cars[f] = 1;
                }

                if (type == 3) {
                    trunks[f] = 1;
                }
            }

            long[] prefixBikes = prefixSums(bikes);
            long[] prefixCars = prefixSums(cars);
            long[] prefixTrunks = prefixSums(trunks);

            for (int t = 0; t < testCases; t++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                long difBikes = countTotal(prefixBikes, x, y);
                long difCars = countTotal(prefixCars, x, y);
                long difTrunks = countTotal(prefixTrunks, x, y);

                if (difBikes > 0) {
                    System.out.println("1");
                } else if (difCars > 0) {
                    System.out.println("2");
                } else if (difTrunks > 0) {
                    System.out.println("3");
                }
            }
        }
    }

    public static long[] prefixSums(int[] A) {
        long[] prefix = new long[A.length + 1];
        for (int k = 1; k < A.length + 1; k++) {
            prefix[k] = prefix[k - 1] + A[k - 1];
        }
        return prefix;
    }

    public static long countTotal(long[] P, int x, int y) {
        return P[y + 1] - P[x];
    }
}
