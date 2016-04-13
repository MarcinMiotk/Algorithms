package net.keinesorgen.alg.prefix.PassingCars;

/**
 *
 */
public class PassingCars {

    /**
     *
     * @param A
     * @return count passing cars
     */
    public int solution(int[] A) {

        final int ERROR = -1;
        // O(n)
        int[] prefixSums = prefixSums(A);

        int sum = 0;
        // O(n)
        for (int p = 0; p < A.length; p++) {
            if (A[p] == 0) {
                sum += countTotal(prefixSums, p, A.length - 1);

                if (sum > 1000000000) {
                    return ERROR;
                }
            }
        }

        return sum;
    }

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
