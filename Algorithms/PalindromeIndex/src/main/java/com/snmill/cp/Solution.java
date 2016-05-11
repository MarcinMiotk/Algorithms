package com.snmill.cp;

import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int testCases = in.nextInt();
            assert testCases <= 20;
            in.nextLine();
            for (int t = 0; t < testCases; t++) {
                String line = in.nextLine();
                int index = indexOfTheCharacterWhoseRemovalWillMakeTheStringPalindrome(line);
                System.out.println(index);
            }
        }
    }

    static int indexOfTheCharacterWhoseRemovalWillMakeTheStringPalindrome(String input) {
        int length = input.length();
        int half = length / 2;

        for (int left = 0; left < half; left++) {
            int right = length - 1 - left;

            char leftChar = input.charAt(left);
            char rightChar = input.charAt(right);

            if (leftChar != rightChar) {
                 // subarray without left

                // for abcaggadcba left=3 and righ=7
                // i have ggad
                if (verifyPalindrome(input, left + 1, right)) {
                    return left;
                } else {
                    return right;
                }
            }
        }

        return -1;
    }

    static boolean verifyPalindrome(String input, int from, int to) {
        int half = to - from + 1;

        for (int left = 0; left < half; left++) {
            char leftChar = input.charAt(left + from);
            char rightChar = input.charAt(to - left);
            if (leftChar != rightChar) {
                return false;
            }
        }

        return true;
    }

}
