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
                String word = in.nextLine();
                System.out.println(findTheNumberOfUnorderedAnagrammaticPairs(word));
            }
        }
    }

    static int findTheNumberOfUnorderedAnagrammaticPairs(String word) {
//        int[] asciiCounters = asciiCountrs(word);

        int anagramPairsSum = 0;

        for (int substringLength = 1; substringLength < word.length(); substringLength++) {
            for (int i = 0; i + substringLength <= word.length(); i++) {
                String firstSubstring = word.substring(i, i + substringLength);
                for (int j = i + 1; j + substringLength <= word.length(); j++) {
                    String secondSubstring = word.substring(j, j + substringLength);
                    if (isAnagram(firstSubstring, secondSubstring)) {
                        anagramPairsSum++;
                    }
                }
            }
        }
        return anagramPairsSum;
    }

    static boolean isAnagram(String first, String second) {
        int[] countersFirst = asciiCountrs(first);
        int[] countersSecond = asciiCountrs(second);
        for (int i = 0; i < countersFirst.length; i++) {
            if (countersFirst[i] != countersSecond[i]) {
                return false;
            }
        }
        return true;
    }

    static int[] asciiCountrs(String word) {
        int[] counters = new int[(int) 'z' - 'a' + 1];
        word.chars().forEach((int i) -> {
            counters[i - 'a']++;
        });
        return counters;
    }

}
