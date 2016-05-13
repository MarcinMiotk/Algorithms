package com.snmill.cp;

import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String first = in.nextLine();
            String second = in.nextLine();
            System.out.println(minimumNumberOfCharacterDeletionsRequiredToMakeTwoStringsAnagrams(first, second));
        }
    }

    static int minimumNumberOfCharacterDeletionsRequiredToMakeTwoStringsAnagrams(String first, String second) {
        int[] countersOfFirst = asciiCounters(first);
        int[] countersOfSecond = asciiCounters(second);

        int differencesSum = 0;

        for (int i = 0; i < countersOfFirst.length; i++) {
            int a = countersOfFirst[i];
            int b = countersOfSecond[i];
            int diff = Math.abs(a - b);
            differencesSum += diff;
        }

        return differencesSum;
    }

    static int[] asciiCounters(String string) {
        int[] asciiCounters = new int[(int) 'z' - 'a' + 1];
        string.chars().forEach((int i) -> {
            asciiCounters[i - 'a']++;
        });
        return asciiCounters;
    }

}
