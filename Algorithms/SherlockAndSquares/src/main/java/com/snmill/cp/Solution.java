package com.snmill.cp;

import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int t = 0; t < testCases; t++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                System.out.println(countTheNumberOfSquareIntegersBetween(a, b));
            }
        }
    }

    static int countTheNumberOfSquareIntegersBetween(int a, int b) {
        int minIndex = (int) Math.ceil(Math.sqrt(a));
        int maxIndex = (int) Math.floor(Math.sqrt(b));
        int count = 0;
        for (int i = minIndex; i <= maxIndex; i++) {
            int powerI = i * i;
            if (powerI >= a && powerI <= b) {
                count++;
            }
        }
        return count;
    }

    static int countTheNumberOfSquareIntegersBetween_backup(int a, int b) {
        int[] map = consecutiveIntegerSquares(b);

        int maxIndexLessOrEqualValueThanA = 1;
        int maxIndexLessOrEqualValueThanB = 1;

        int exact = 0;

        for (int i = 1; i < map.length; i++) {
            if (map[i] <= a) {
                maxIndexLessOrEqualValueThanA = i;
                if (map[i] == a) {
                    exact++;
                }
            }
            if (map[i] <= b) {
                maxIndexLessOrEqualValueThanB = i;
            }
        }

        return maxIndexLessOrEqualValueThanB - maxIndexLessOrEqualValueThanA + exact;
    }

    static int[] consecutiveIntegerSquares(int finalValue) {
        int i = 1;
        int powerI = 0;
        int[] toCut = new int[32000];
        while (powerI <= finalValue) {
            powerI = i * i;
            //        System.out.println(i + " gives \t" + powerI);
            toCut[i] = powerI;
            i++;
        }
        int[] result = new int[i - 1];
        System.arraycopy(toCut, 0, result, 0, result.length);

        return result;
    }

    /* #################################################################### */
    static double sqrt(double n) {
        double low = 0.0;
        double high = n + 1;

        while ((high - low) > 0.00001) {
            double mid = (high + low) / 2.0;
            if (mid * mid < n) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }

    static double sqrt_v2(double n) {
        return Math.sqrt(n);
    }

    static double absolute(double num) {
        if (num < 0) {
            num = -num;
        }
        return num;
    }

    static double sqrt_NewtonRaphson(double x) {
        final double difference = 0.00001;
        double guess = 1.0;
        while (absolute(guess * guess - x) >= difference) {
            guess = (x / guess + guess) / 2.0;
        }
        return guess;
    }
}
