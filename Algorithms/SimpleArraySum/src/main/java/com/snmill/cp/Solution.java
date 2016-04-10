package com.snmill.cp;

import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();

        int sum = 0;
        while (in.hasNextInt()) {
            sum += in.nextInt();
        }

        System.out.println(sum);
    }

}
