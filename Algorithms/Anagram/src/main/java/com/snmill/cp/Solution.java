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
                int minimum = minimumNumberOfCharactersOfTheFirstStringHeNeedsToChangeToEnableHimToMakeItAnAnagramOfTheSecondString(word);
                System.out.println(minimum);
            }
        }
    }

    static int minimumNumberOfCharactersOfTheFirstStringHeNeedsToChangeToEnableHimToMakeItAnAnagramOfTheSecondString(String concatenatedWords) {
        int length = concatenatedWords.length();
        if (length % 2 != 0) {
            return -1;
        }
        TwoAsciiTablesForLeftAndRigtPartOfWord parts = createAsciiTablesForTwoPartsOfWord(concatenatedWords);

        // dla kazdej lewej
        // patrze na odpowiedknik z prawej
        // jesli liczba sie zgadza, to skacze dalej
        // jesli liczba sie NIE zgadza, to licze roznice i dodaje ja do sumy roznic
        // xaxbbbxx = xaxb + bbxx = (2x+1a+1b) + (2b+2x) = 
        // aaabbb = aaa + bbb = (3a) + (3b) = 3
        int sum = 0;
        for (int i = 0; i < parts.left.length; i++) {
            int l = parts.left[i];
            int r = parts.right[i];
            int difference = l - r;
            if (difference > 0) {
                sum += difference;
            }
        }

        return sum;
    }

    static int[] createCountersTableFor(String word, int from, int to) {
        int[] ascii = new int[(int) 'z' - 'a' + 1];
        for (int i = from; i <= to; i++) {
            ascii[(int) word.charAt(i) - 'a']++;
        }
        return ascii;
    }

    static TwoAsciiTablesForLeftAndRigtPartOfWord createAsciiTablesForTwoPartsOfWord(String word) {
        int length = word.length();
        int half = length / 2;

        int[] left = createCountersTableFor(word, 0, half - 1);
        int[] right = createCountersTableFor(word, half, length - 1);

        return new TwoAsciiTablesForLeftAndRigtPartOfWord(left, right);
    }

    static class TwoAsciiTablesForLeftAndRigtPartOfWord {

        int[] left;
        int[] right;

        public TwoAsciiTablesForLeftAndRigtPartOfWord(int[] left, int[] right) {
            this.left = left;
            this.right = right;
        }
    }

}
