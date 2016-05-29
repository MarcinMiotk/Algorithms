package com.snmill.cp;

import java.util.Optional;
import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            scanner.nextLine();
            while (testCases-- > 0) {
                String line = scanner.nextLine();
                System.out.println(rearrange(line));
            }
        }
    }

    static String rearrange(String input) {
        int size = input.length();
        int[] counters = createEmptyCounters();
        Optional<Pivot> pivot = findPivot(counters, input);
        if (pivot.isPresent()) {
            decrementCounter(counters, pivot.get().character);
            String beforePivot = input.substring(0, pivot.get().index);
            String afterPivot = createAscendingStringWithCounters(counters);
            return beforePivot + pivot.get().character + afterPivot;
        } else {
            return "no answer";
        }
    }

    static String createAscendingStringWithCounters(int[] counters) {
        StringBuilder asc = new StringBuilder();
        for (int i = 0; i < counters.length; i++) {
            while (counters[i]-- > 0) {
                asc.append((char) (i + 'a'));
            }
        }
        return asc.toString();
    }

    static Optional<Pivot> findPivot(int[] counters, String input) {
        int size = input.length();
        int i = size - 1;
        // find pivot
        for (; i >= 0; i--) {
            char character = input.charAt(i);
            incrementCounter(counters, character);
            Optional<Character> found = findMinimumButGreaterThan(counters, character);
            if (found.isPresent()) {
                return Optional.of(new Pivot(found.get().charValue(), i));
            }
        }
        return Optional.empty();
    }

    static class Pivot {

        public final char character;
        public final int index;

        public Pivot(char character, int index) {
            this.character = character;
            this.index = index;
        }

    }

    static int[] createEmptyCounters() {
        return new int[(int) 'z' - (int) 'a' + 1];
    }

    static void incrementCounter(int[] counters, char character) {
        counters[character - (int) 'a']++;
    }

    static void decrementCounter(int[] counters, char character) {
        counters[character - (int) 'a']--;
    }

    static Optional<Character> findMinimumButGreaterThan(int[] counters, char character) {
        int than = (int) character - 'a';
        if (than < counters.length) {
            for (int i = than + 1; i < counters.length; i++) {
                if (counters[i] > 0) {
                    return Optional.of(new Character((char) (i + 'a')));
                }
            }
        }
        return Optional.empty();
    }
}
