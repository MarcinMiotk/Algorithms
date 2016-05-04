package com.snmill.cp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int testCases = in.nextInt();
            assert testCases <= 10;
            for (int t = 0; t < testCases; t++) {
                int stones = in.nextInt();
                int a = in.nextInt();
                int b = in.nextInt();

                int[] possibleValues = listOfNumbersWhichAreThePossibleValuesOfTheLastStone(stones, a, b);
                for (int p = 0; p < possibleValues.length; p++) {
                    if (p > 0) {
                        System.out.print(" ");
                    }
                    System.out.print(possibleValues[p]);
                }
                System.out.println();
            }
        }
    }

    /**
     * https://pl.wikipedia.org/wiki/Wariacja_z_powt%C3%B3rzeniami
     *
     * @param n
     * @param k
     * @return
     */
    public static int variationsWithRepetitions(int k, int n) {
        return (int) Math.pow(n, k);
    }

    public static int[] listOfNumbersWhichAreThePossibleValuesOfTheLastStone(int stones, int a, int b) {
        assert a <= 1000;
        assert b <= 1000;
        assert stones <= 1000;

        Set<Integer> uniqueLastValues = new HashSet<>();

        // 4	-	0
        // 3	-	1
        // 2	-	2
        // 1	-	3
        // 0    -       4
        stones--;
        for (int howMuchA = 0; howMuchA <= stones; howMuchA++) {
            int howMuchB = stones - howMuchA;
            int sum = howMuchA * a + howMuchB * b;
            uniqueLastValues.add(sum);
        }

        int[] result = new int[uniqueLastValues.size()];
        int i = 0;
        Iterator<Integer> it = uniqueLastValues.iterator();
        while (it.hasNext()) {
            result[i] = it.next();
            i++;
        }
        Arrays.sort(result);

        return result;
    }

    // guess the value of the last stone
    // the number on the first stone was 0
    // find all the possible values for the number on the last stone.
    public static int[] listOfNumbersWhichAreThePossibleValuesOfTheLastStone_not_efficient(int stones, int a, int b) {
        assert a <= 1000;
        assert b <= 1000;
        assert stones <= 1000;

        Set<Integer> uniqueLastValues = new HashSet<>();

        variationsWithRepetitions(stones - 1, new int[]{a, b}, (int[] variation) -> {
            int sum = 0;
            for (int add : variation) {
                sum += add;
            }
            uniqueLastValues.add(sum);
        });

        int[] result = new int[uniqueLastValues.size()];
        int i = 0;
        Iterator<Integer> it = uniqueLastValues.iterator();
        while (it.hasNext()) {
            result[i] = it.next();
            i++;
        }
        Arrays.sort(result);

        return result;
    }

    public interface VariationsListener {

        void onVariation(int[] variation);
    }

    public static void variationsWithRepetitions(int k, int[] n, VariationsListener listener) {
        Iterator<int[]> iterator = new VariationWithoutRepetitions(k, n.length);
        while (iterator.hasNext()) {
            int[] indexes = iterator.next();
            int[] variation = new int[k];
            for (int i = 0; i < indexes.length; i++) {
                variation[i] = n[indexes[i]];
            }
            listener.onVariation(variation);
        }
    }

    public static int[][] variationsWithRepetitions(int k, int[] n) {
        final int[][] variations = new int[variationsWithRepetitions(k, n.length)][k];

        Iterator<int[]> iterator = new VariationWithoutRepetitions(k, n.length);
        int variationIndex = 0;

        while (iterator.hasNext()) {
            int[] indexes = iterator.next();
            int[] variation = new int[k];
            for (int i = 0; i < indexes.length; i++) {
                variation[i] = n[indexes[i]];
            }
            variations[variationIndex] = variation;
            variationIndex++;
        }

        return variations;
    }

    static class VariationWithoutRepetitions implements Iterator<int[]> {

        final int k;
        final int n;
        final int count;

        VariationWithoutRepetitions(int k, int n) {
            this.k = k;
            this.n = n;
            this.count = variationsWithRepetitions(k, n);
        }

        int index = 0;

        @Override
        public boolean hasNext() {
            return index < count;
        }

        @Override
        public int[] next() {
            int[] variation = new int[k];
            int dispaching = index;
            int cursor = k - 1;
            while (cursor >= 0) {
                int divideBy = (int) Math.pow(n, cursor);
                if (divideBy > 0) {
                    int variationPart = dispaching / divideBy;
                    variation[cursor] = variationPart;
                    dispaching = dispaching % divideBy;
                } else {
                    variation[cursor] = dispaching;
                }
                cursor--;
            }
            index++;
            return variation;
        }

        private int variationsWithRepetitions(int k, int n) {
            return (int) Math.pow(n, k);
        }
    }

}
