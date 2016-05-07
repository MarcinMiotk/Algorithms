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
                int size = scanner.nextInt();
                int[] array = new int[size];
                for (int i = 0; i < size; i++) {
                    array[i] = scanner.nextInt();
                }
                boolean canFullySort = doesTheRobotCanFullySortA(array);
                if (canFullySort) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    static boolean doesTheRobotCanFullySortA(int[] a) {
        int n = a.length;
        // Choose any 3 consecutive indices and rotate their elements in such 
        // a way that ABC rotates to BCA, which rotates to CAB, which rotates 
        // back to ABC.
        for (int i = 0; i <= n - 3; i++) {
            if (!sort(a, i)) {
                return false;
            }
        }
        return true;
    }

    static boolean sort(int[] array, int fromIndex) {
        int a = array[fromIndex];
        int b = array[fromIndex + 1];
        int c = array[fromIndex + 2];
        if (a <= b && b <= c) {
            return true;
        }
        if (b <= c && c <= a) {
            array[fromIndex] = b;
            array[fromIndex + 1] = c;
            array[fromIndex + 2] = a;
            return true;
        }
        if (c <= a && a <= b) {
            array[fromIndex] = c;
            array[fromIndex + 1] = a;
            array[fromIndex + 2] = b;
            return true;
        }
        return false;
    }

}
