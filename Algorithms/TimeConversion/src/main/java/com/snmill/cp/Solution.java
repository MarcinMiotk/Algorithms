package com.snmill.cp;

import java.text.NumberFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String line = in.next();
            System.out.println(convertTo24Hour(line));
        }
    }

    public static String convertTo24Hour(String input) {
        Pattern pattern = Pattern.compile("([0-9]{2,2}):([0-9]{2,2}):([0-9]{2,2})(PM|AM)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            int hour = Integer.parseInt(matcher.group(1));
            int minute = Integer.parseInt(matcher.group(2));
            int second = Integer.parseInt(matcher.group(3));
            boolean pm = "PM".equals(matcher.group(4));

            if (pm) {
                if (hour != 12) {
                    hour += 12;
                }
            } else {
                if (hour == 12) {
                    hour = 0;
                }
            }

            NumberFormat nf = NumberFormat.getInstance();
            nf.setMaximumIntegerDigits(2);
            nf.setMinimumIntegerDigits(2);
            nf.setMaximumFractionDigits(0);

            return nf.format(hour) + ":" + nf.format(minute) + ":" + nf.format(second);
        }
        throw new IllegalArgumentException("Invalid input " + input);
    }
}
