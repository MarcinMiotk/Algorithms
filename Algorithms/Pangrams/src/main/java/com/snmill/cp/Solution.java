package com.snmill.cp;

import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            if (isPangram(input)) {
                System.out.println("pangram");
            } else {
                System.out.println("not pangram");
            }
        }
    }

    /**
     * Pangrams are sentences constructed by using every letter of the alphabet
     * at least once.
     *
     * @param input
     * @return
     */
    public static boolean isPangram(String input) {
        int[] asciiCounters = Solution.table();
        for (int i = 0; i < input.length(); i++) {
            increment(asciiCounters, input.charAt(i));
        }

        for(int counter : asciiCounters) {
            if(counter<=0) {
                return false;
            }
        }
        
        return true;
    }

    static int[] table() {
        int first = 'a';
        int end = 'z';
        int length = end - first + 1;
        return new int[length];
    }

    static void increment(int[] table, char character) {
        int position = (int) character;

        // big into small
        if (position >= 'A' && position <= 'Z') {
            position += ('a' - 'A');
        }

        // increment
        if (position >= 'a' && position <= 'z') {
            table[position - 'a']++;
        }
    }

}
