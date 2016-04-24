package com.snmill.cp;

import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int t = 0; t < testCases; t++) {
                int money = scanner.nextInt();
                int price = scanner.nextInt();
                int bonus = scanner.nextInt();
                int numberOfChocolates = numberOfChocolates(money, price, bonus);
                System.out.println(numberOfChocolates);
            }
        }
    }

    static int numberOfChocolates(int money, int price, int bonus) {
        int chocolades = money / price;
        MainAndRest accumulated = accumulate(chocolades, bonus);
        if (accumulated.rest >= bonus) {
            MainAndRest accumulatedRests = accumulate(accumulated.rest, bonus);
            int result = chocolades + accumulated.main + accumulatedRests.main;
            return result;
        } else {
            int result = chocolades + accumulated.main;
            return result;
        }
    }

    static class MainAndRest {

        int main;
        int rest;

        public MainAndRest(int main, int rest) {
            this.main = main;
            this.rest = rest;
        }

    }

    static MainAndRest accumulate(int subMoney, int bonus) {
        int main = subMoney / bonus;
        int rest = subMoney % bonus;
        if ((main + rest) < bonus) {
            return new MainAndRest(main, rest);
        } else {
            MainAndRest sub = accumulate(main, bonus);
            return new MainAndRest(main + sub.main, rest + sub.rest);
        }
    }
}
