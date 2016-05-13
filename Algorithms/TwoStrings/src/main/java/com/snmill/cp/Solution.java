package com.snmill.cp;

import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int testCases = in.nextInt();
            in.nextLine();
            for (int t = 0; t < testCases; t++) {
                String a = in.nextLine();
                String b = in.nextLine();
                System.out.println(ifThereIsACommonSubstring(a, b) ? "YES" : "NO");
            }
        }
    }

    static boolean ifThereIsACommonSubstring(String first, String second) {
        int[] countersOfFirst = asciiCounters(first);
        int[] countersOfSecond = asciiCounters(second);

        for (int i = 0; i < countersOfFirst.length; i++) {
            int a = countersOfFirst[i];
            int b = countersOfSecond[i];
            if (a > 0 && b > 0) {
                return true;
            }
        }

        return false;
    }

    static int[] asciiCounters(String string) {
        int[] asciiCounters = new int[(int) 'z' - 'a' + 1];
        string.chars().forEach((int i) -> {
            asciiCounters[i - 'a']++;
        });
        return asciiCounters;
    }

}
