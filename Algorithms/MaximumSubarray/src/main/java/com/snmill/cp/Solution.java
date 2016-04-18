package com.snmill.cp;

import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            int[] input = new int[n];
            for (int ni = 0; ni < n; ni++) {
                input[ni] = scanner.nextInt();
            }
            FindMaxSum find = new FindMaxSum(input);
            System.out.println(find.findMaxSums().toString());
        }
    }

    static class Result {

        int maxContiguousSum;
        int maxNoncontiguousSum;

        public Result() {
        }

        public Result(int maxContiguousSum, int maxNoncontiguousSum) {
            this.maxContiguousSum = maxContiguousSum;
            this.maxNoncontiguousSum = maxNoncontiguousSum;
        }

        @Override
        public String toString() {
            return maxContiguousSum + " " + maxNoncontiguousSum;
        }
    }

    static class FindMaxSum {

        private final int[] input;

        public FindMaxSum(int[] input) {
            this.input = input;
        }

        int findMaxContiguousSum_faster() {
            int sum = 0;
            int maxValue = Integer.MIN_VALUE;
            for (int x : input) {

                sum += x;

                if (sum > maxValue) {
                    maxValue = sum;
                }

                if (sum < 0) {
                    sum = 0;
                }

            }
            return maxValue;
        }

        int findMaxContiguousSum() {
            if (input.length == 1) {
                return input[0];
            }

            int[] prefixes = PrefixSums.sums(input);

            int maxY = input.length - 1;

            int maxSum = Integer.MIN_VALUE;

            for (int x = 0; x < input.length; x++) {
                int y = findBestY(prefixes, x, maxY);
                //int y = findBestY_recurrency(prefixes, x, maxY);
                int suggestion = PrefixSums.countTotal(prefixes, x, y);
                if (suggestion > maxSum) {
                    maxSum = suggestion;
                }
            }

            return maxSum;
        }

        int findBestY_recurrency(int[] prefixes, int x, int maxY) {
            return findBestY_recurrency(prefixes, x, x, maxY);
        }

        int findBestY_recurrency(int[] prefixes, int x, int yMin, int yMax) {
            int half = (yMax - yMin) / 2;
            if (yMin == yMax) {
                return yMin;
            }
            if (yMin == yMax - 1) {
                int left = PrefixSums.countTotal(prefixes, x, yMin);
                int right = PrefixSums.countTotal(prefixes, x, yMax);
                if (left > right) {
                    return yMin;
                }
                if (right >= left) {
                    return yMax;
                }
            }
            int left = PrefixSums.countTotal(prefixes, x, yMin + half);
            int right = PrefixSums.countTotal(prefixes, x, yMax);
            if (left > right) {
                return findBestY_recurrency(prefixes, x, yMin, yMin + half);
            } else if (right > left) {
                return findBestY_recurrency(prefixes, x, yMin + half, yMax);
            } else {
                return findBestY_recurrency(prefixes, x, yMin + half, yMax);
            }
        }

        int findBestY(int[] prefixes, int x, int maxY) {
            int bestY = x;
            int bestSum = PrefixSums.countTotal(prefixes, x, bestY);
            for (int y = x; y <= maxY; y++) {
                int candidateSum = PrefixSums.countTotal(prefixes, x, y);
                if (candidateSum > bestSum) {
                    bestSum = candidateSum;
                    bestY = y;
                }
            }
            return bestY;
        }

        int findMaxNonContiguousSum() {
            int sum = 0;
            int maxValue = Integer.MIN_VALUE;
            for (int x : input) {
                if (x > maxValue) {
                    maxValue = x;
                }
                if (x > 0) {
                    sum += x;
                }
            }
            if (maxValue <= 0) {
                return maxValue;
            } else {
                return sum;
            }
        }

        Result findMaxSums() {
            Result result = new Result();
            result.maxNoncontiguousSum = findMaxNonContiguousSum();
            result.maxContiguousSum = findMaxContiguousSum_faster();
            return result;
        }
    }

    static class PrefixSums {

        static int[] sums(int[] input) {
            int[] prefixes = new int[input.length + 1];
            prefixes[0] = 0;
            for (int i = 1; i < prefixes.length; i++) {
                prefixes[i] = prefixes[i - 1] + input[i - 1];
            }
            return prefixes;
        }

        static int countTotal(int[] prefixSums, int x, int y) {
            return prefixSums[y + 1] - prefixSums[x];
        }
    }
}
