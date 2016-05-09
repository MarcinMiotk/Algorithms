package com.snmill.cp;

import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            scanner.nextLine();
            for (int t = 0; t < testCases; t++) {
                String input = scanner.nextLine();
                boolean isFunny = isFunny(input);
                if (isFunny) {
                    System.out.println("Funny");
                } else {
                    System.out.println("Not Funny");
                }
            }
        }
    }

    static boolean isFunny(String s) {
        String r = new StringBuilder(s).reverse().toString();
        int length = s.length();
        for (int i = 1; i < length; i++) {
            int sValue = Math.abs((int) s.charAt(i) - (int) s.charAt(i - 1));
            int rValue = Math.abs((int) r.charAt(i) - (int) r.charAt(i - 1));
            if (sValue != rValue) {
                return false;
            }
        }
        return true;
    }
}
