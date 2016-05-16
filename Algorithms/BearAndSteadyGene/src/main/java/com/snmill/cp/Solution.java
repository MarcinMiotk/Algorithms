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
            System.out.println(minimumLengthOfTheSubstringReplacedToMakeDnaStable(dna));
        }
    }

    static int[] convert(String dnaAsString) {
        int[] dna = new int[dnaAsString.length()];
        for (int i = 0; i < dna.length; i++) {
            char characterToMap = dnaAsString.charAt(i);
            switch (characterToMap) {
                case 'A':
                    dna[i] = 0;
                    break;
                case 'C':
                    dna[i] = 1;
                    break;
                case 'T':
                    dna[i] = 2;
                    break;
                case 'G':
                    dna[i] = 3;
                    break;
                default:
                    throw new RuntimeException();
            }
        }
        return dna;
    }

    static int minimumLengthOfTheSubstringReplacedToMakeDnaStable(String dnaAsString) {
        return minimumLengthOfTheSubstringReplacedToMakeDnaStable(convert(dnaAsString));
    }

    static int minimumLengthOfTheSubstringReplacedToMakeDnaStable(int[] dna) {
        int n = dna.length;
        int requiredFrequency = n / 4;

        int[] countersDna = counters(dna);
        int[] missingCountersInDna = countersMissing(countersDna, requiredFrequency);
        int mutationLength = sum(missingCountersInDna);

        while (mutationLength < dna.length) {
            // dla 4

            int exceededType = -1;

            for (int excludeDnaFrom = 0; excludeDnaFrom <= dna.length - mutationLength; excludeDnaFrom++) {

                if (exceededType == -1 || (excludeDnaFrom > 0 && (dna[excludeDnaFrom - 1] == exceededType || dna[excludeDnaFrom] == exceededType))) {

                    int[] meybeSteadyCounters = countersWithout(dna, excludeDnaFrom, excludeDnaFrom + mutationLength - 1, requiredFrequency);
                    if (canBeSteady(meybeSteadyCounters, requiredFrequency)) {
                        return mutationLength;
                    } else {
                        for (int t = 0; t < meybeSteadyCounters.length; t++) {
                            if (meybeSteadyCounters[t] > requiredFrequency) {
                                exceededType = t;
                            }
                        }
                    }
                }
            }
            mutationLength++;
        }

        return -1;
    }

    static boolean canBeSteady(int[] counters, int required) {
        for (int c : counters) {
            if (c > required) {
                return false;
            }
        }
        return true;
    }

    static int[] createMutingDna(int[] missing) {
        int mutationLength = sum(missing);
        int[] mutedSubDna = new int[mutationLength];
        int index = 0;
        for (int i = 0; i < missing.length; i++) {
            for (int copy = 0; copy < missing[i]; copy++) {
                mutedSubDna[index++] = i;
            }
        }
        return mutedSubDna;
    }

    static boolean search(int[] dna, int[] missing, int mutationLength) {
        int[] muting = createMutingDna(missing);
        for (int i = 0; i <= dna.length - mutationLength; i++) {
            int[] working = copy(dna);
            for (int m = 0; m < muting.length; m++) {
                working[i + m] = muting[m];
            }
            if (isSteady(working)) {
                return true;
            }
        }
        return false;
    }

    static int[] copy(int[] from) {
        int[] copy = new int[from.length];
        System.arraycopy(from, 0, copy, 0, from.length);
        return copy;
    }

    static int[] countersMissing(int[] countersNow, int required) {
        int[] missing = new int[countersNow.length];
        for (int i = 0; i < countersNow.length; i++) {
            if (countersNow[i] >= required) {
                missing[i] = 0;
            } else {
                missing[i] = required - countersNow[i];
            }
        }
        return missing;
    }

    static boolean isSteady(int[] dna) {
        int n = dna.length;
        int requiredFrequency = n / 4;
        int[] counters = counters(dna);
        for (int counter : counters) {
            if (counter != requiredFrequency) {
                return false;
            }
        }
        return true;
    }

    static int sum(int[] counters) {
        int sum = 0;
        for (int i : counters) {
            sum += i;
        }
        return sum;
    }

    static int[] counters(int[] dna) {
        int[] counters = new int[4];
        for (int i = 0; i < dna.length; i++) {
            counters[dna[i]]++;
        }
        return counters;
    }

    static int[] countersWithout(int[] dna, int silenceFrom, int silenceTo) {
        int[] counters = new int[4];
        for (int i = 0; i < dna.length; i++) {
            if (i >= silenceFrom && i <= silenceTo) {

            } else {
                counters[dna[i]]++;
            }
        }
        return counters;
    }

    static int[] countersWithout(int[] dna, int silenceFrom, int silenceTo, int maxValue) {
        int[] counters = new int[4];
        for (int i = 0; i < dna.length; i++) {
            if (i >= silenceFrom && i <= silenceTo) {

            } else {
                counters[dna[i]]++;

                // shorten !!!
                if (counters[dna[i]] > maxValue) {
                    return counters;
                }
            }
        }
        return counters;
    }
}
