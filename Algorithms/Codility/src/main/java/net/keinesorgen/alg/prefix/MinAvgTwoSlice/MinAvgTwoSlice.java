package net.keinesorgen.alg.prefix.MinAvgTwoSlice;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * O(N) for time and space complexity
 */
public class MinAvgTwoSlice {

    private static class MinimalAndIndex {

        double minimal;
        int index;

        public MinimalAndIndex(double minimal, int index) {
            this.minimal = minimal;
            this.index = index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(minimal, index);
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof MinimalAndIndex) {
                return ((MinimalAndIndex) o).index == index && ((MinimalAndIndex) o).minimal == minimal;
            }
            return false;
        }
    }

    public int solutionZZZZ(int[] A) {

//        for (int i = 0; i < A.length; i++) {
//            A[i] = A[i] + 10000;
//        }

        long[] prefix = prefixSums(A);
        double minimal = Double.MAX_VALUE;

        // default
        int indexLeft = 0;

        List<MinimalAndIndex> minimals = new ArrayList<>();

        for (int left = 0; left < prefix.length - 2; left++) {
            double avFirst = average(prefix, left, computeRightIndexFirst(left, prefix));
            double avSecond = average(prefix, left, computeRightIndexSecond(left, prefix));
            double av = Math.min(avFirst, avSecond);
            if (av <= minimal) {
                minimal = av;
                indexLeft = left;
                minimals.add(new MinimalAndIndex(minimal, indexLeft));
            }
        }

        final double minimalThreshold = minimal;
        // usuniecie starszych niz minimal
        minimals.removeIf(new Predicate<MinimalAndIndex>() {

            @Override
            public boolean test(MinimalAndIndex t) {
                return t.minimal > minimalThreshold;
            }
        });

        System.out.println("Acceptable starts count=" + minimals.size());

        for (MinimalAndIndex check : minimals) {
            int right = prefix.length - 2;
            // find minimum
            while (check.index < right) {
                double av = average(prefix, check.index, right);
                if (av < minimal) {
                    minimal = av;
                    indexLeft = check.index;
                }
                right--;
            }
        }

        return indexLeft;
    }

    private final static int ERROR = -1;

    private int computeRightIndexFirst(int left, long[] prefix) {
        if (left + 1 < prefix.length) {
            return left + 1;
        } else {
            return ERROR;
        }
    }

    private int computeRightIndexSecond(int left, long[] prefix) {
        if (left < prefix.length - 2) {
            return prefix.length - 2;
        } else {
            return ERROR;
        }
    }

    public int solution(int[] A) {
        long[] prefix = prefixSums(A);
        double minimal = Double.MAX_VALUE;

        // default
        int indexRight = (prefix.length - 2);
        int indexLeft = 0;

        for (int left = 0; left < prefix.length - 2; left++) {
            for (int right = prefix.length - 2; right >= 1; right--) {
                if (left < right) {
                    double av = average(prefix, left, right);
                    if (av < minimal) {
                        minimal = av;
                        indexLeft = left;
                        indexRight = right;
                    }
                }
            }
        }

        return indexLeft;
    }
//
//    public int solution4(int[] A) {
//        int[] prefix = prefixSums(A);
//        double minimal = Double.MAX_VALUE;
//
//        // default
//        int indexRight = (prefix.length - 2);
//        int indexLeft = 0;
//
//        for (int right = indexRight; right >= 1; right--) {
//            double av = average(prefix, 0, right);
//            if (av < minimal) {
//                minimal = av;
//                indexRight = right;
//            } else {
//                // found best right index
//                break;
//            }
//        }
//
//        for (int left = 0; left < indexRight; left++) {
//            double av = average(prefix, left, indexRight);
//            if (av < minimal) {
//                minimal = av;
//                indexLeft = left;
//            }
//
//        }
//
//        return indexLeft;
//    }

    double average(long[] P, int x, int y) {
        long value = countTotal(P, x, y);
        int count = y - x + 1;
        return (double) value / (double) count;
    }

    boolean isSlice(int P, int Q, int[] in) {
        return 0 <= P && P < Q && Q < in.length && Q - P >= 1;
    }

    public static long[] prefixSums(int[] A) {
        long[] prefix = new long[A.length + 1];
        for (int k = 1; k < A.length + 1; k++) {
            prefix[k] = prefix[k - 1] + A[k - 1];
        }
        return prefix;
    }

    public static long countTotal(long[] P, int x, int y) {
        return P[y + 1] - P[x];
    }

}
