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
                int numberOfDigits = scanner.nextInt();
                System.out.println(largestDecentNumberAsString(numberOfDigits));
            }
        }
    }

    /**
     * 1≤N≤100000
     *
     * Skoro do wyboru jest 3 lub 5 i mamy wybrac najwieksza to trzeba na
     * poczatku umieszczac jak najwiecej 5, a na koncu jak najmniej 3.
     *
     * Rule
     *
     * The number of 3's it contains is divisible by 5.
     *
     * The number of 5's it contains is divisible by 3.
     *
     */
    static String largestDecentNumberAsString(int havingNDigits) {
        Response response = largestDecentNumber(havingNDigits);
        if (response.isFail()) {
            return "-1";
        } else {
            StringBuilder buffer = new StringBuilder(havingNDigits);
            for (int i = 0; i < response.count5; i++) {
                buffer.append("5");
            }
            for (int i = 0; i < response.count3; i++) {
                buffer.append("3");
            }
            return buffer.toString();
        }
    }

    static Response largestDecentNumber(int havingNDigits) {
        if (havingNDigits < 3) {
            return Response.fail();
        } else {
            int max5div = (havingNDigits / 3);     // for 8 is 2
            int max3div = (havingNDigits / 5);     // for 8 is 1

            int max5val = max5div * 3;             // for 8 is 6
            int max3val = max3div * 5;             // for 8 is 5

            for (int a = 0; a <= max5div; a++) {
                for (int b = max3div; b >= 0; b--) {
                    int suggest5 = max5val - 3 * a;
                    int suggest3 = max3val - 5 * b;
                    if (suggest3 + suggest5 == havingNDigits) {
                        return new Response(suggest3, suggest5);
                    }

                    if (suggest3 < 0 || suggest5 < 0) {
                        break;
                    }
                }
            }
            return Response.fail();

        }
    }

    static class Response {

        int count3;
        int count5;

        static Response fail() {
            return new Response(-1, -1);
        }

        boolean isFail() {
            return count3 == -1 && count5 == -1;
        }

        public Response() {
            this.count3 = 0;
            this.count5 = 0;
        }

        public Response(int count3, int count5) {
            this.count3 = count3;
            this.count5 = count5;
        }
    }
}
