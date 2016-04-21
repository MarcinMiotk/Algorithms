package com.snmill.cp;

import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int lengthOfString = in.nextInt();
            in.nextLine();
            String string = in.nextLine();
            int key = in.nextInt();
            System.out.println(encrypt(string, lengthOfString, key));
        }
    }

    public static String encrypt(String text, int lengthOfString, int key) {
        SignsRange bigLetters = new SignsRange(97, 122);
        SignsRange smallLetters = new SignsRange(65, 90);
        byte[] input = text.substring(0, lengthOfString).getBytes();
        for (int i = 0; i < input.length; i++) {
            if (!bigLetters.change(input, i, key)) {
                smallLetters.change(input, i, key);
            }
        }
        return new String(input);
    }

    static class SignsRange {

        final int asciiMinCode;
        final int asciiMaxCode;
        final int rotationFactor;

        SignsRange(int asciiMinCode, int asciiMaxCode) {
            this.asciiMinCode = asciiMinCode;
            this.asciiMaxCode = asciiMaxCode;
            this.rotationFactor = asciiMaxCode - asciiMinCode + 1;
        }

        boolean change(byte[] input, int i, int key) {
            key = key % rotationFactor;
            if (input[i] >= asciiMinCode && input[i] <= asciiMaxCode) {
                int suggestion = input[i] + key;
                if (suggestion > asciiMaxCode) {
                    suggestion = suggestion - asciiMaxCode - 1 + asciiMinCode;
                }
                input[i] = (byte) suggestion;
                return true;
            }
            return false;
        }

    }
}
