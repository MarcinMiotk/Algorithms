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
                int n = scanner.nextInt();
                int foundDigits = findDigits(n);
                System.out.println(foundDigits);
            }
        }
    }

    static int findDigits(int n) {
        int[] digits = integerToArray(n);
        int howManyDigitsEvenlyDivideN = 0;
        for (int d : digits) {
            if (d>0 && n % d == 0) {
                howManyDigitsEvenlyDivideN++;
            }
        }

        return howManyDigitsEvenlyDivideN;
    }

    static int[] integerToArray(int n) {
        int[] temp = new int[32];
        int i = 0;
        while (n != 0) {
            temp[i] = n % 10;
            n = n / 10;
            i++;
        }
        int[] result = new int[i];
        System.arraycopy(temp, 0, result, 0, result.length);
        return result;
    }

}
