package com.snmill.cp;

import java.util.Scanner;

/**
 *
 */
public class QuicksortPartition {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int size = scanner.nextInt();
            int[] unsortedArray = new int[size];
            for (int t = 0; t < size; t++) {
                unsortedArray[t] = scanner.nextInt();
            }
            int[][] partitions = partitions(unsortedArray);
            for (int[] partition : partitions) {
                for (int element : partition) {
                    System.out.print(element + " ");
                }
            }
        }
    }

    static int[][] partitions(int[] input) {
        QuickSortPartitions qs = new QuickSortPartitions(input.length);
        int pivot = input[0];
        for (int element : input) {
            qs.addToPartition(pivot, element);
        }

        return qs.getPartitions();
    }

    static class QuickSortPartitions {

        int[] left;
        int[] equal;
        int[] right;

        int leftSize = 0;
        int rightSize = 0;
        int equalSize = 0;

        public QuickSortPartitions(int size) {
            left = new int[size];
            right = new int[size];
            equal = new int[size];
        }

        void addToPartition(int pivot, int value) {
            if (pivot == value) {
                equal[equalSize++] = value;
            } else if (value > pivot) {
                right[rightSize++] = value;
            } else {
                left[leftSize++] = value;
            }
        }

        int[][] getPartitions() {

            int[] l = new int[leftSize];
            System.arraycopy(left, 0, l, 0, leftSize);

            int[] e = new int[equalSize];
            System.arraycopy(equal, 0, e, 0, equalSize);

            int[] r = new int[rightSize];
            System.arraycopy(right, 0, r, 0, rightSize);

            return new int[][]{l, e, r};
        }

    }

}
