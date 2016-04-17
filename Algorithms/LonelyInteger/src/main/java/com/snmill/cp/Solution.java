package com.snmill.cp;

import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();      // 1<n<100 & odd (like 1, 3)
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();       // each value <100
        }
        Solution solution = new Solution();
        int found = solution.findTheNumberThatOccursOnlyOnce_better(input);
        System.out.println(found);
    }

    public int findTheNumberThatOccursOnlyOnce_better(int[] input) {
        int result = 0;
        for (int x : input) {
            result ^= x;
        }
        return result;
    }

    public int findTheNumberThatOccursOnlyOnce(int[] input) {
        byte[] cache = new byte[100];
        for (int x : input) {
            cache[x]++;
        }
        for (int i = 0; i < cache.length; i++) {
            if (cache[i] == 1) {
                return i;
            }
        }
        throw new IllegalArgumentException("No number with 1 occurence");
    }

}
