package com.snmill.cp;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            System.out.println(factorialOf(n));
        }
    }

    public static String factorialOf(int n) {
        assert n >= 1 && n <= 100;
        BigInteger factorial = new BigInteger("1");

        for (int k = 2; k <= n; k++) {
            factorial = factorial.multiply(BigInteger.valueOf(k));
        }

        return factorial.toString();
    }
}
