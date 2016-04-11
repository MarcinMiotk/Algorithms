package com.snmill.cp;

import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        int sum;
        try (Scanner in = new Scanner(System.in)) {
            int count = in.nextInt();
            sum = 0;
            while (in.hasNextInt()) {
                sum += in.nextInt();
            }
        }

        System.out.println(sum);
    }

}
