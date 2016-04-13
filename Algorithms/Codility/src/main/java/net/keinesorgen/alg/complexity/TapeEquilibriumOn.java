package net.keinesorgen.alg.complexity;

/**
 *
 */
public class TapeEquilibriumOn extends TapeEquilibrium {

    @Override
    public int solution(int[] A) {
        int total = sum(A);
        int left = A[0];
        int minimal = Integer.MAX_VALUE;
        for (int p = 1; p < A.length; p++) {
            int right = total - left;
            int difference = Math.abs(left - right);
            left += A[p];
            if (difference < minimal) {
                minimal = difference;
            }
        }
        return minimal;
    }

    protected static int sum(int[] arg) {
        int sum = 0;
        for (int i : arg) {
            sum += i;
        }
        return sum;
    }
}
