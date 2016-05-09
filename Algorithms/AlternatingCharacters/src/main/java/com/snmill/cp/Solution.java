package com.snmill.cp;

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
                String input = scanner.nextLine();
                assert input.length() > 0;
                int minimum = minimumNumberOfDeletionsRequiredToHaveConsecutiveCharactersDifferent(input);
                System.out.println(minimum);
            }
        }
    }

    static int minimumNumberOfDeletionsRequiredToHaveConsecutiveCharactersDifferent(String input) {
        int deletionsRequired = 0;

        int length = input.length();
        for (int i = 1; i < length; i++) {
            char back = input.charAt(i - 1);
            char current = input.charAt(i);
            if (current == back) {
                deletionsRequired++;
            }
        }

        return deletionsRequired;
    }

}
