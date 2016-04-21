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
        key = key % 26; // roznica max-min

        byte[] input = text.substring(0, lengthOfString).getBytes();
        for (int i = 0; i < input.length; i++) {

            // big letters
            if (input[i] >= (byte) 65 && input[i] <= (byte) 90) {
                int suggestion = input[i] + key;
                if (suggestion > 90) {
                    suggestion = suggestion - 90 - 1 + 65;
                }
                input[i] = (byte) suggestion;
                continue;
            }

            // small letters
            if (input[i] >= (byte) 97 && input[i] <= (byte) 122) {
                int suggestion = input[i] + key;
                if (suggestion > (byte) 122) {
                    suggestion = suggestion - 122 - 1 + 97;
                }
                input[i] = (byte) suggestion;
            }

            // other
        }
        return new String(input);
    }
}
