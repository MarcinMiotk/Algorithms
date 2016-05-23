package com.snmill.cp;

import java.util.Scanner;

/**
 *
 */
public class QuicksortSorting {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int size = scanner.nextInt();
            int[] unsortedArray = new int[size];
            for (int t = 0; t < size; t++) {
                unsortedArray[t] = scanner.nextInt();
            }
            sorting(unsortedArray, (int[] merged) -> {
                boolean first = true;
                for (int element : merged) {
                    if (first) {
                        first = false;
                    } else {
                        System.out.print(" ");
                    }
                    System.out.print(element);
                }
                System.out.println();
            });
        }
    }

    interface OnMerged {

        void onMerges(int[] merged);
    }

    static int[] sorting(int[] input, OnMerged mergeListener) {
        Partitions partitions = partitions(input);

        if (partitions.getSize() == 1) {
            return partitions.getJoined();
        } else if (partitions.getSize() > 1) {
            int[] mergedLeft = null;
            int[] mergedEqual = null;
            int[] mergedRigth = null;
            int size = 0;

            if (partitions.left.length > 0) {
                mergedLeft = sorting(partitions.left, mergeListener);
                size += mergedLeft.length;

            }
            if (partitions.equal.length > 0) {
                mergedEqual = sorting(partitions.equal, mergeListener);
                size += mergedEqual.length;
            }
            if (partitions.right.length > 0) {
                mergedRigth = sorting(partitions.right, mergeListener);
                size += mergedRigth.length;
            }

            int[] merged = new int[size];
            int m = 0;

            if (mergedLeft != null) {
                for (int x : mergedLeft) {
                    merged[m++] = x;
                }
            }
            if (mergedEqual != null) {
                for (int x : mergedEqual) {
                    merged[m++] = x;
                }
            }
            if (mergedRigth != null) {
                for (int x : mergedRigth) {
                    merged[m++] = x;
                }
            }

            mergeListener.onMerges(merged);

            return merged;

        } else {
            throw new RuntimeException("bad argument");
        }
    }

    static Partitions partitions(int[] input) {
        QuickSortPartitions qs = new QuickSortPartitions(input.length);
        int pivot = input[0];
        for (int element : input) {
            qs.addToPartition(pivot, element);
        }
        return qs.getPartitions();
    }

    static class QuickSortPartitions {

        final int[] left;
        final int[] equal;
        final int[] right;

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

        Partitions getPartitions() {
            int[] l = new int[leftSize];
            System.arraycopy(left, 0, l, 0, leftSize);

            int[] e = new int[equalSize];
            System.arraycopy(equal, 0, e, 0, equalSize);

            int[] r = new int[rightSize];
            System.arraycopy(right, 0, r, 0, rightSize);

            return new Partitions(l, e, r);
        }

    }

    static class Partitions {

        int[] left;
        int[] equal;
        int[] right;

        public Partitions(int[] left, int[] equal, int[] right) {
            this.left = left;
            this.equal = equal;
            this.right = right;
        }

        int getSize() {
            return left.length + equal.length + right.length;
        }

        int[] getJoined() {
            int[] joined = new int[getSize()];
            int j = 0;
            for (int l : left) {
                joined[j++] = l;
            }
            for (int e : equal) {
                joined[j++] = e;
            }
            for (int r : right) {
                joined[j++] = r;
            }
            return joined;
        }
    }
}
