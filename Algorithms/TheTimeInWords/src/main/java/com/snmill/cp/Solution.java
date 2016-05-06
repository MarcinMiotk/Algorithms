package com.snmill.cp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int hours = in.nextInt();
            int minutes = in.nextInt();
            Solution solution = new Solution();
            System.out.println(solution.timeInWords(hours, minutes));
        }
    }

    Map<Integer, String> numberUnits = new HashMap<>();

    public Solution() {
        numberUnits.put(1, "one");
        numberUnits.put(2, "two");
        numberUnits.put(3, "three");
        numberUnits.put(4, "four");
        numberUnits.put(5, "five");
        numberUnits.put(6, "six");
        numberUnits.put(7, "seven");
        numberUnits.put(8, "eight");
        numberUnits.put(9, "nine");
        numberUnits.put(10, "ten");
        numberUnits.put(11, "eleven");
        numberUnits.put(12, "twelve");
        numberUnits.put(13, "thirteen");
        numberUnits.put(14, "fourteen");
        numberUnits.put(15, "fifteen");
        numberUnits.put(16, "sixteen");
        numberUnits.put(17, "seventeen");
        numberUnits.put(18, "eighteen");
        numberUnits.put(19, "nineteen");
        numberUnits.put(20, "twenty");
        numberUnits.put(30, "thirty");
        numberUnits.put(40, "fourty");
        numberUnits.put(50, "fifty");
        numberUnits.put(60, "sixty");
    }

    public String timeInWords(int hours, int minutes) {
        String minutesInWords = minutesInWords(minutes);

        if (minutes > 0) {
            if (minutes > 30) {
                return minutesInWords + " " + hoursInWords(hours + 1);
            } else {
                return minutesInWords + " " + hoursInWords(hours);
            }
        } else {
            return hoursInWords(hours) + " " + minutesInWords;
        }

    }

    public String minutesInWords(int minutes) {

        if (minutes == 0) {
            return "o' clock";
        }

        if (minutes == 15) {
            return "quarter past";
        }

        if (minutes == 1) {
            return numberUnits.get(minutes) + " minute past";
        }

        if (minutes <= 20) {
            return numberUnits.get(minutes) + " minutes past";
        }

        if (minutes > 20 && minutes < 30) {
            int firstDigit = minutes - 20;
            String result = numberUnits.get(20);
            if (firstDigit > 0) {
                result += " " + numberUnits.get(firstDigit);
            }
            return result + " minutes past";
        }

        if (minutes == 30) {
            return "half past";
        }

        if (minutes == 45) {
            return "quarter to";
        }

        if (minutes > 30) {
            // reverse
            int reverseMinutes = 60 - minutes;

            if (reverseMinutes == 1) {
                return numberUnits.get(reverseMinutes) + " minute to";
            }

            if (reverseMinutes <= 20) {
                return numberUnits.get(reverseMinutes) + " minutes to";
            }

            if (reverseMinutes > 20 && reverseMinutes < 30) {
                int firstDigit = reverseMinutes - 20;
                String result = numberUnits.get(20);
                if (firstDigit > 0) {
                    result += " " + numberUnits.get(firstDigit);
                }
                return result + " minutes to";
            }

        }

        return null;
    }

    public String hoursInWords(int hours) {

        return numberUnits.get(hours);
    }

}
