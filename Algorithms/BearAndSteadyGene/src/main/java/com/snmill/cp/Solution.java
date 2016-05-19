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
        int[] countersOfDnaParts = counters(dna);
        if (isSteadyCandidate(countersOfDnaParts, dna.length)) {
            return 0;
        } else {
            int answer = dna.length;

            // two pointers i,j
            int j = 0;

            for (int i = 0; i < dna.length; ++i) {
                while (j < dna.length && !isSteadyCandidate(countersOfDnaParts, dna.length)) {
                    --countersOfDnaParts[dna[j++]];
                }

                if (isSteadyCandidate(countersOfDnaParts, dna.length)) {
                    answer = Math.min(answer, j - i);
                    ++countersOfDnaParts[dna[i]];
                }

            }

            return answer;
        }
    }

    static int[] counters(int[] dna) {
        int[] dnaCounters = new int[MAP.length];
        for (int dnaPart : dna) {
            dnaCounters[dnaPart]++;
        }
        return dnaCounters;
    }

    static boolean isSteadyCandidate(int[] dnaCounters, int dnaLength) {
        for (int i = 0; i < dnaCounters.length; ++i) {
            if (dnaCounters[i] > (dnaLength / 4)) {
                return false;
            }
        }
        return true;
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

    // =================================================================
}
