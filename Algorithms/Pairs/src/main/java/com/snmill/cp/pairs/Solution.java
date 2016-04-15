package com.snmill.cp.pairs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 */
public class Solution {
    
    public static void main(String[] args) {
        SolutionFinal.main(args);
    }
    
    public static void main2(String[] args) {
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
//            long[] deltas = deltas(input);
//            return countK(deltas, k);
            //return countBasedOnStack(input, k);
            //return countBasedOnComplexityOpow2(input, k);
            return countStackAndDeltas(input, k);
        }
        
        int countStackAndDeltas(int[] input, int k) {
            long[] deltas = computeDeltas(input);
            int counter = 0;
            LinkedList<Stack<Long>> stacks = new LinkedList<>();
            Stack<Long> stack = new Stack<>();
            for (int i = 0; i < deltas.length; i++) {
                if (deltas[i] == k) {
                    counter++;
                    if (!stack.isEmpty()) {
                        stacks.add(stack);
                        stack = new Stack<>();
                        // verification of stack
                    }
                }
                if (deltas[i] < k) {
                    stack.push(deltas[i]);
                }
                if (deltas[i] > k) {
                    if (!stack.isEmpty()) {
                        stacks.add(stack);
                        stack = new Stack<>();
                        // verification of stack
                    }
                }
            }
            if (!stack.isEmpty()) {
                stacks.add(stack);
            }
            
            for (Stack<Long> substack : stacks) {
                counter += countKInStack(substack, k);
            }
            
            return counter;
        }
        
        int countKInStack(Stack<Long> stack, int k) {
            
            int counter = 0;
            
            LinkedList<Long> backup = new LinkedList<>();
            
            long sum = 0;
            while (!stack.isEmpty()) {
                Long diff = stack.pop();
                sum += diff;
                backup.push(diff);
                if (sum == k) {
                    counter++;
                    sum = sum - backup.pollLast();
                    continue;
                }
                
                if (sum > k) {
                    while (sum > k) {
                        sum = sum - backup.pollLast();
                    }
                    
                    if (sum == k) {
                        counter++;
                        sum = sum - backup.pollLast();
                    }
                }
            }
            
            return counter;
        }
        
        int countBasedOnComplexityOpow2(int[] input, int k) {
            int count = 0;
            
            for (int i = 0; i < input.length; i++) {
                for (int j = i; j < input.length; j++) {
                    int difference = Math.abs(input[i] - input[j]);
                    if (difference == k) {
                        count++;
                    }
                }
            }
            
            return count;
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
                        copySecondStackIntoFirstAndThenClearSecond(stack, backup);
                        break;
                    } else if (difference < k) {
                        backup.push(lower);
                    } else {
                        // difference>k
                        // nie ma sensu dalej sprawdzac
                        stack.push(lower);
                        copySecondStackIntoFirstAndThenClearSecond(stack, backup);
                        break;
                    }
                }
            }

            //
            return counter;
        }
        
        void copySecondStackIntoFirstAndThenClearSecond(Stack first, Stack second) {
            while (!second.isEmpty()) {
                first.push(second.pop());
            }
            second.clear();
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
            //     deltas[0] = input[0];
            return deltas;
        }
    }
    
}
