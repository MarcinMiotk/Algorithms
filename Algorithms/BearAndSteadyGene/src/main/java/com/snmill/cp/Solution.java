package com.snmill.cp;

import java.util.Iterator;
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

    static int minimumLengthOfTheSubstringReplacedToMakeDnaStable(String dna) {
        int n = dna.length();
        int requiredFrequency = n / 4;
        Counters counters = new Counters(requiredFrequency);
        SqueezeIterator iterator = new SqueezeIterator(dna);
        int free = 0;
        while (iterator.hasNext()) {
            CharSide current = iterator.next();
            if (counters.isFinalAfterCharacter(current)) {
                break;
            }
            free++;
        }
        int minimum = n - free + 2;
        return minimum;
    }

    static boolean isSteady(String dna) {
        int n = dna.length();
        int requiredFrequency = n / 4;
        int[] counters = counters(dna);
        // 4,4,4,4
        int sum = sum(counters);
        for (int counter : counters) {
            if (counter != 0 && counter != requiredFrequency) {
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

    static class Counters {

        final int requiredFrequency;

        public Counters(int requiredFrequency) {
            this.requiredFrequency = requiredFrequency;
        }

        int a = 0;
        int c = 0;
        int t = 0;
        int g = 0;

        boolean boundLeft = false;
        boolean boundRight = false;

        boolean incrementAndCheckBoundReaching(char character) {
            switch (character) {
                case 'A':
                    if (a <= requiredFrequency) {
                        a++;
                        return false;
                    } else {
                        return true;
                    }
                case 'C':
                    if (c <= requiredFrequency) {
                        c++;
                        return false;
                    } else {
                        return true;
                    }
                case 'T':
                    if (t <= requiredFrequency) {
                        t++;
                        return false;
                    } else {
                        return true;
                    }
                case 'G':
                    if (g <= requiredFrequency) {
                        g++;
                        return false;
                    } else {
                        return true;
                    }
                default:
                    throw new RuntimeException("Input error");
            }
        }

        boolean isFinalAfterCharacter(CharSide offered) {
            if (offered.side == Side.LEFT && !boundLeft) {
                if (incrementAndCheckBoundReaching(offered.character)) {
                    boundLeft = true;
                }
            }

            if (offered.side == Side.RIGHT && !boundRight) {
                if (incrementAndCheckBoundReaching(offered.character)) {
                    boundRight = true;
                }
            }

            if (boundLeft && boundRight) {
                return true;
            } else {
                return false;
            }
        }
    }

    static int[] counters(String dna) {
        int[] counters = new int[4];
        for (int i = 0; i < dna.length(); i++) {
            switch (dna.charAt(i)) {
                case 'A':
                    counters[0]++;
                    break;
                case 'C':
                    counters[1]++;
                    break;
                case 'T':
                    counters[2]++;
                    break;
                case 'G':
                    counters[3]++;
                    break;
                default:
                    throw new RuntimeException("Input error");
            }
        }
        return counters;
    }

    enum Side {

        LEFT, RIGHT
    }

    static class CharSide {

        char character;
        Side side;

        public CharSide(char character, Side side) {
            this.character = character;
            this.side = side;
        }

    }

    static class SqueezeIterator implements Iterator<CharSide> {

        private final String input;

        int step = 0;
        int leftPos = 0;
        int rightPos;

        public SqueezeIterator(String input) {
            this.input = input;
            this.rightPos = input.length() - 1;
        }

        @Override
        public boolean hasNext() {
            return step < input.length();
        }

        @Override
        public CharSide next() {
            if (step % 2 == 0) {
                // left
                char result = input.charAt(leftPos);
                step++;
                leftPos++;
                return new CharSide(result, Side.LEFT);
            } else {
                // left
                char result = input.charAt(rightPos);
                step++;
                rightPos--;
                return new CharSide(result, Side.RIGHT);
            }
        }
    }

}
