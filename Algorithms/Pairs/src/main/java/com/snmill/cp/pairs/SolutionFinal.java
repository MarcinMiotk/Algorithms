package com.snmill.cp.pairs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 */
public class SolutionFinal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arrayOfNelements = create(n, scanner);
        SolutionFinal solution = new SolutionFinal();
        int count = solution.countTheNumberOfPairsOfIntegersWhoseDifferenceIsK(arrayOfNelements, k);
        System.out.println(count);
    }

    private static int[] create(int n, Scanner scanner) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = scanner.nextInt();
        }
        return result;
    }

    int countTheNumberOfPairsOfIntegersWhoseDifferenceIsK(int[] input, int k) {
        Arrays.sort(input);
        long[] deltas = deltas(input);
        int pairs = 0;

        LinkedList<Stack<Long>> slices = new LinkedList<>();
        Stack<Long> slice = new Stack<>();
        for (int i = 0; i < deltas.length; i++) {
            if (deltas[i] == k) {
                pairs++;
                if (!slice.isEmpty()) {
                    slices.add(slice);
                    slice = new Stack<>();
                }
            }
            if (deltas[i] < k) {
                slice.push(deltas[i]);
            }
            if (deltas[i] > k) {
                if (!slice.isEmpty()) {
                    slices.add(slice);
                    slice = new Stack<>();
                }
            }
        }
        if (!slice.isEmpty()) {
            slices.add(slice);
        }

        for (Stack<Long> substack : slices) {
            pairs += countPairsInSlice(substack, k);
        }

        return pairs;
    }

    int countPairsInSlice(Stack<Long> slice, int k) {

        int pairs = 0;

        LinkedList<Long> cache = new LinkedList<>();

        long sum = 0;
        while (!slice.isEmpty()) {
            Long diff = slice.pop();
            sum += diff;
            cache.push(diff);
            if (sum == k) {
                pairs++;
                sum = sum - cache.pollLast();
                continue;
            }

            if (sum > k) {
                while (sum > k) {
                    sum = sum - cache.pollLast();
                }

                if (sum == k) {
                    pairs++;
                    sum = sum - cache.pollLast();
                }
            }
        }

        return pairs;
    }

    long[] deltas(int[] input) {
        long[] deltas = new long[input.length];
        int i = input.length - 1;
        while (i > 0) {
            deltas[i] = input[i] - input[i - 1];
            i--;
        }
        return deltas;
    }

}
