package com.snmill.cp;

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
            long minimumMiles = 0;
            for(int i=array.length-1, j=0; i>=0; i--, j++) {
                int calories = array[i];
                minimumMiles += calories*Math.pow(2, j);
            }
            System.out.println(minimumMiles);
        }
    }
}
