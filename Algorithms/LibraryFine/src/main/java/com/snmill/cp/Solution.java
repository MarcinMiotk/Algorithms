package com.snmill.cp;

import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int d1 = in.nextInt();
            int m1 = in.nextInt();
            int y1 = in.nextInt();
            int d2 = in.nextInt();
            int m2 = in.nextInt();
            int y2 = in.nextInt();
            System.out.println(fine(d1, m1, y1, d2, m2, y2));
        }
    }

    public static int fine(
            int actualDay, int actualMonth, int actualYear,
            int expectedDay, int expectedMonth, int expectedYear
    ) {
        if (actualYear == expectedYear) {
            if (actualMonth == expectedMonth) {
                if (actualDay == expectedDay) {
                    return 0;
                } else if (actualDay < expectedDay) {
                    return 0;
                } else { // actualDay > expectedDay
                    return 15 * (actualDay - expectedDay);
                }
            } else if (actualMonth < expectedMonth) {
                return 0;
            } else { // actualMonth>expectedMonth
                return 500 * (actualMonth - expectedMonth);
            }
        } else if (actualYear < expectedYear) {
            return 0;
        } else { // actualYear>expectedYear
            return 10000;
        }
    }

}
