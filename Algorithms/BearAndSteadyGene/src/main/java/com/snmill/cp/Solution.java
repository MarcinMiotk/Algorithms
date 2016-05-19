package com.snmill.cp;

import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int nDividableBy4 = in.nextInt();
            in.nextLine();
            String dna = in.nextLine();
            System.out.println(minimumMutationLength(convertDna(dna)));
        }
    }

    static int minimumMutationLength(int[] dna) {
        int[] counters = buildCountersOf(dna);
        if (!isBadDna(counters, dna.length)) {
            return 0;
        } else {
            int answer = dna.length;

            int rightPointer = 0;
            int leftPointer = 0;

            while (leftPointer < dna.length) {

                while (rightPointer < dna.length && isBadDna(counters, dna.length)) {
                    in(counters).of(dna).decrementCounterPointedBy(rightPointer);
                    ++rightPointer;
                }

                if (!isBadDna(counters, dna.length)) {
                    answer = Math.min(answer, rightPointer - leftPointer);
                    in(counters).of(dna).incrementCounterPointedBy(leftPointer);
                }

                ++leftPointer;
            }

            return answer;
        }
    }

    static class Builder {

        private final int[] counters;
        private int[] dna;

        public Builder(int[] counters) {
            this.counters = counters;
        }

        Builder of(int[] dna) {
            this.dna = dna;
            return this;
        }

        void incrementCounterPointedBy(int pointer) {
            ++counters[dna[pointer]];
        }

        void decrementCounterPointedBy(int pointer) {
            --counters[dna[pointer]];
        }
    }

    static Builder in(int[] counters) {
        return new Builder(counters);
    }

    static int[] buildCountersOf(int[] dna) {
        int[] dnaCounters = new int[MAP.length];
        for (int dnaPart : dna) {
            dnaCounters[dnaPart]++;
        }
        return dnaCounters;
    }

    static boolean isBadDna(int[] dnaCounters, int dnaLength) {
        for (int i = 0; i < dnaCounters.length; ++i) {
            if (dnaCounters[i] > (dnaLength / 4)) {
                return true;
            }
        }
        return false;
    }

    final static char[] MAP = new char[]{'A', 'C', 'T', 'G'};

    static int[] convertDna(String dnaAsString) {
        int[] dna = new int[dnaAsString.length()];
        for (int i = 0; i < dnaAsString.length(); i++) {
            dna[i] = convertCharacter(dnaAsString.charAt(i));
        }
        return dna;
    }

    static int convertCharacter(char character) {
        for (int i = 0; i < MAP.length; i++) {
            if (MAP[i] == character) {
                return i;
            }
        }
        throw new RuntimeException();
    }
}
