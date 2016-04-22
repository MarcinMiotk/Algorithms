package com.snmill.cp;

import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int count = in.nextInt();
            for (int i = 0; i < count; i++) {
                int n = in.nextInt();
//                System.out.println(utopianTree(n));
                System.out.println(utopianTree_math(n));
            }
        }
    }

    static int utopianTree_math(int n) {
        return ~(~1 << (n >> 1)) << n % 2;
    }

    static int utopianTree(int n) {
        if (n == 0) {
            return 1;
        } else {
            // n=1 => *2
            // n=2 => +1            
            // (1) vs (1*2) vs  (1*2 +1) vs (1*2 +1)*2 vs (1*2 +1)*2 +1          
            int sum = 1;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    sum *= 2;
                } else {
                    sum++;
                }
            }
            return sum;
        }
    }

}
