package com.snmill.cp;

import java.util.Scanner;

/**
 *
 */
public class Solution {
    
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int boundFrom = in.nextInt();
            int boundTo = in.nextInt();
            
            int found = 0;
            for (int number = boundFrom; number <= boundTo; number++) {
                long power2 = power2(number);
                Parts parts = split(power2);
                if (parts.sumLeftAndRight == number) {
                    if (found > 0) {
                        System.out.print(" ");
                    }
                    System.out.print(number);
                    found++;
                }
            }
            if (found == 0) {
                System.out.print("INVALID RANGE");
            }
        }
    }
    
    static long power2(int number) {
        return number * (long) number;
    }
    
    static long[] digitsAsEvenArray(long number) {
        long temp[] = new long[100];
        int i = 0;
        while (number != 0) {
            temp[i] = number % 10;
            number /= 10;
            i++;
        }
        int size = i;
        if (size % 2 != 0) {
            size++; // we need even array
        }
        long result[] = new long[size];
        System.arraycopy(temp, 0, result, 0, i);
        return result;
    }
    
    static Parts split(long number) {
        long[] digitsAsEventArray = digitsAsEvenArray(number);
        int half = digitsAsEventArray.length / 2;
        
        Parts parts = new Parts();
        parts.leftDigits = new long[half];
        parts.rightDigits = new long[half];
        
        System.arraycopy(digitsAsEventArray, 0, parts.rightDigits, 0, half);
        System.arraycopy(digitsAsEventArray, half, parts.leftDigits, 0, half);
        
        parts.initSums();
        
        return parts;
    }
    
    static class Parts {
        
        long[] leftDigits;
        long[] rightDigits;
        
        long left = 0;
        long right = 0;
        long sumLeftAndRight = 0;
        
        int len() {
            return leftDigits.length;
        }
        
        void initSums() {
            left = sum(leftDigits);
            right = sum(rightDigits);
            sumLeftAndRight = left + right;
        }
        
        public static long sum(long[] array) {
            long result = 0;
            for (int i = 0; i < array.length; i++) {
                if (i == 0) {
                    result += (long) array[i];
                } else {
                    long tens = (long) Math.pow(10, i);
                    result += (long) array[i] * tens;
                }
            }
            return result;
        }
        
    }
    
}
