package net.keinesorgen.alg.prefix;

/**
 * Allows for O(n+m) time complexity when we try to determine the sum of any
 * slice.
 */
public class PrefixSums {

    /**
     * O(n)
     *
     * @param A
     * @return
     */
    public static int[] prefixSums(int[] A) {
        int[] prefix = new int[A.length + 1];
        for (int k = 1; k < A.length + 1; k++) {
            prefix[k] = prefix[k - 1] + A[k - 1];
        }
        return prefix;
    }

    public static int countTotal(int[] P, int x, int y) {
        return P[y + 1] - P[x];
    }
}
