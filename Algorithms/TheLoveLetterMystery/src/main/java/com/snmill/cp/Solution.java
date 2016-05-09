package com.snmill.cp;

import java.util.Iterator;
import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            scanner.nextLine();
            for (int t = 0; t < testCases; t++) {
                String word = scanner.nextLine();
                System.out.println(minimumOperationsToCreatePalindrome(word));
            }
        }
    }

    static int minimumOperationsToCreatePalindrome(String word) {
        if (word.length() == 1) {
            return 0;
        }

        RightToLeftIterator rightIterator = new RightToLeftIterator(word);
        LeftToRigthIterator leftIterator = new LeftToRigthIterator(word);

        int changes = 0;

        while (leftIterator.hasNext()) {
            Integer left = leftIterator.next();
            Integer right = rightIterator.next();
            int difference = Math.abs(left - right);
            changes += difference;
        }

        return changes;
    }

    static class LeftToRigthIterator implements Iterator<Integer> {

        private final String input;
        private final int leftHalf;

        public LeftToRigthIterator(String input) {
            this.input = input;
            int length = input.length();
            this.leftHalf = length / 2;
        }

        int index = 0;

        @Override
        public boolean hasNext() {
            return index < leftHalf;
        }

        @Override
        public Integer next() {
            int asciiCode = input.charAt(index);
            index++;
            return asciiCode;
        }
    }

    static class RightToLeftIterator implements Iterator<Integer> {

        private final String input;
        private final int half;
        private final int length;

        public RightToLeftIterator(String input) {
            this.input = input;
            this.length = input.length();
            this.half = length / 2;
        }

        int index = 0;

        @Override
        public boolean hasNext() {
            return index < half;
        }

        @Override
        public Integer next() {
            int asciiCode = input.charAt(length - index - 1);
            index++;
            return asciiCode;
        }
    }

}
