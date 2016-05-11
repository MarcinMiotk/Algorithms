package com.snmill.cp;

import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String word = in.nextLine();
            System.out.println(whetherAnyAnagramOfTheStringCanBeAPalindrome(word) ? "YES" : "NO");
        }
    }

    static boolean whetherAnyAnagramOfTheStringCanBeAPalindrome(String input) {
        // jesli dlugosc jest parzysta, to kazdy znak musi byc podzielny przez 2
        // jesli dlugosc jest nieparzysta, to kazdy znak (oprocz jednego) musi byc podzielny przez 2

        // ascii counters        
        int[] counters = createCountersTableFor(input);
        boolean oneCounterCanBeOdd = oneCounterCanBeOdd(input);

        int odds = 0;

        for (int counter : counters) {
            if (counter % 2 != 0) {
                odds++;
                if (odds > 1) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean oneCounterCanBeOdd(String input) {
        return input.length() % 2 != 0;
    }

    static int[] createCountersTableFor(String word) {
        int[] ascii = new int[(int) 'z' - 'a' + 1];
        for (int i = 0; i < word.length(); i++) {
            ascii[(int) word.charAt(i) - 'a']++;
        }
        return ascii;
    }
}
