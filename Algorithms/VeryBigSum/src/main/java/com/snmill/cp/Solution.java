package com.snmill.cp;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        BigInteger sum;
        try (Scanner in = new Scanner(System.in)) {
            int count = in.nextInt();
            sum = new BigInteger("0");
            while (in.hasNextBigInteger()) {
                sum = sum.add(in.nextBigInteger());
            }
        }

        System.out.println(sum);
    }

}
