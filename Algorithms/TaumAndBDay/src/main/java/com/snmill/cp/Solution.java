package com.snmill.cp;

import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int testCases = in.nextInt();
            for (int t = 0; t < testCases; t++) {
                long blackGifts = in.nextInt();
                long whiteGifts = in.nextInt();
                long blackCost = in.nextInt();
                long whiteCost = in.nextInt();
                long conversionCost = in.nextInt();
                System.out.println(minimumAmountToSpend(blackGifts, whiteGifts, blackCost, whiteCost, conversionCost));
            }
        }
    }

    public static long minimumAmountToSpend(long blackGifts, long whiteGifts, long blackCost, long whiteCost, long conversionCost) {

        // There is no benefit to converting the white gifts into black or the black gifts into white
        if (conversionCost >= blackCost && conversionCost >= whiteCost) {
            return blackGifts * blackCost + whiteGifts * whiteCost;
        }

        if (whiteCost <= blackCost) {
            long sum = 0;
            sum += whiteCost * whiteGifts;

            long choosedBlackCost = 0;
            long whiteWithConversionIntoBlack = whiteCost + conversionCost;
            if (whiteWithConversionIntoBlack > blackCost) {
                choosedBlackCost = blackCost;
            } else {
                choosedBlackCost = whiteWithConversionIntoBlack;
            }

            sum += choosedBlackCost * blackGifts;
            return sum;
        }

        if (blackCost <= whiteCost) {
            long sum = 0;
            sum += blackCost * blackGifts;

            long choosedBlackCost = 0;
            long blackWithConversionIntoWhite = blackCost + conversionCost;
            if (blackWithConversionIntoWhite > whiteCost) {
                choosedBlackCost = whiteCost;
            } else {
                choosedBlackCost = blackWithConversionIntoWhite;
            }

            sum += choosedBlackCost * whiteGifts;
            return sum;
        }

        return 0;
    }

}
