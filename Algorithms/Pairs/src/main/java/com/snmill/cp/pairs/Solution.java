package com.snmill.cp.pairs;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * 21:36
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        ArrayCreator arrayCreator = new ArrayCreatorImpl();
        PairsOfIntegersWhoseDifferenceIsKImpl solution = new PairsOfIntegersWhoseDifferenceIsKImpl();
        int[] arrayOfNelements = arrayCreator.create(n, scanner);

        int count = solution.countPairsOfIntegersWhoseDifferenceIsK(arrayOfNelements, k);

        System.out.println(count);
    }

    interface PairsOfIntegersWhoseDifferenceIsK {

        int countPairsOfIntegersWhoseDifferenceIsK(int[] input, int k);
    }

    interface ArrayCreator {

        int[] create(int n, Scanner scanner);
    }

    static class ArrayCreatorImpl implements ArrayCreator {

        @Override
        public int[] create(int n, Scanner scanner) {
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                result[i] = scanner.nextInt();
            }
            return result;
        }

    }

    static class PairsOfIntegersWhoseDifferenceIsKImpl implements PairsOfIntegersWhoseDifferenceIsK {

        @Override
        public int countPairsOfIntegersWhoseDifferenceIsK(int[] input, int k) {
            if (input.length > 100_000) {
                throw new IllegalArgumentException("Constraint N<10^5");
            }
            if (k <= 0 || k >= 1_000_000_000) {
                throw new IllegalArgumentException("Constraint 0<K<10^9");
            }

            // to refactor
            for (int i = 0; i < input.length; i++) {
                if (input[i] <= 0) {
                    throw new IllegalArgumentException("Each array element should be >0 and <2^31-1");
                }
            }

            // to refactor
            if (input.length > 2 && input[0] == 1 && input[1] == 1) {
                throw new IllegalArgumentException("Each array element should be unique");
            }

            Arrays.sort(input);
//            long[] deltas = computeDeltas(input);
//            return countK(deltas, k);
            return countBasedOnStack(input, k);
        }

        int countBasedOnStack(int[] input, int k) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < input.length; i++) {
                stack.push(input[i]);
            }

            int counter = 0;
            //

            Stack<Integer> backup = new Stack<>();
            while (stack.size() >= 2) {
                Integer bigger = stack.pop();
                while (!stack.isEmpty()) {
                    Integer lower = stack.pop();
                    int difference = bigger - lower;
                    if (difference == k) {
                        counter++;
                        stack.push(lower);
                        stack.addAll(backup);
                        backup.clear();
                        break;
                    } else if (difference < k) {
                        backup.push(lower);
                    } else {
                        // difference>k
                        // nie ma sensu dalej sprawdzac
                        stack.push(lower);
                        stack.addAll(backup);
                        backup.clear();
                        break;
                    }
                }

            }

            //
            return counter;
        }

        int countK(long[] deltas, int k) {
            int count = 0;
            long klong = (long) k;
            for (int i = 0; i < deltas.length; i++) {
                if (deltas[i] == klong) {
                    count++;
                }
            }
            return count;
        }

        long[] computeDeltas(int[] input) {
            long[] deltas = new long[input.length];
            int i = input.length - 1;
            while (i > 0) {
                deltas[i] = input[i] - input[i - 1];
                i--;
            }
            return deltas;
        }
    }

}
