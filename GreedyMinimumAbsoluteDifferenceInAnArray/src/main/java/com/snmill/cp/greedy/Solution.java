package com.snmill.cp.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            int[] array = new int[count];
            for(int i=0; i<count; i++) {
                array[i] = scanner.nextInt();
            }
            Arrays.sort(array);
            int minimumAbsoluteDifference = Integer.MAX_VALUE;
            for(int i=1; i<array.length; i++) {
                int a = array[i-1];
                int b = array[i];
                int difference = Math.abs(a-b);
                if(difference<minimumAbsoluteDifference) {
                    minimumAbsoluteDifference = difference;
                }
            }
            System.out.println(minimumAbsoluteDifference);
        }
    }
}
