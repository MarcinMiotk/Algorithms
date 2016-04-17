package com.snmill.cp;

import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        System.out.println(solution.getIndexOfV(input, v));
    }

    public int getIndexOfV(int[] input, int v) {
        int result = -1;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == v) {
                result = i;
                break;
            }
        }
        return result;
    }

}
