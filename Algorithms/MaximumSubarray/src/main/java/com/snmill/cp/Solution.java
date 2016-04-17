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

        int findMaxContiguousSum() {

            if (input.length == 1) {
                return input[0];
            }

            int[] prefixes = PrefixSums.sums(input);
            Place place = new Place(0, input.length - 1);
            int sum = PrefixSums.countTotal(prefixes, place.xIndex, place.yIndex);
            while (place.hasNextSlicesToCheck()) {
                int candidateSum = PrefixSums.countTotal(prefixes, place.xIndex, place.yIndex);
                if (candidateSum > sum) {
                    sum = candidateSum;
                }
//                if (candidateSum < sum) {
//                    place.onLowerSumThanLastMax();
//                } else {
                    place.nextSlice();
//                }
            }
            return sum;
        }

        static class Place {

            final int x;
            final int y;
            int xIndex;
            int yIndex;

            public Place(int x, int y) {
                this.x = x;
                this.y = y;
                xIndex = x;
                yIndex = y;
            }

            boolean hasNextSlicesToCheck() {
                if (xIndex <= y) {
                    return true;
                } else {
                    return false;
                }
            }

            void nextSlice() {
                yIndex--;
                if (yIndex < xIndex) {
                    xIndex++;
                    yIndex = y;
                }
            }

//            private void onLowerSumThanLastMax() {
//                xIndex++;
//                yIndex = y;
//            }
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
            result.maxContiguousSum = findMaxContiguousSum();
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
