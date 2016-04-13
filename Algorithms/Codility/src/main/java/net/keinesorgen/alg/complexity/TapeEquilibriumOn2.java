package net.keinesorgen.alg.complexity;

/**
 * O(n2) complexity
 */
public class TapeEquilibriumOn2 extends TapeEquilibrium {

    @Override
    public int solution(int[] A) {
        int P = 1;
        int minimal = divide(A, P).difference();
        P++;
        while (P < A.length) {
            int temp = divide(A, P).difference();
            if (temp < minimal) {
                minimal = temp;
            }
            P++;
        }

        return minimal;
    }

    Parts divide(int[] A, int P) {
        Parts result = new Parts();
        result.partFirst = new int[P];
        result.partSecond = new int[A.length - P];

        System.arraycopy(A, 0, result.partFirst, 0, P);
        System.arraycopy(A, P, result.partSecond, 0, A.length - P);

        return result;
    }

    static class Parts {

        int[] partFirst;
        int[] partSecond;

        int difference() {
            return Math.abs(sum(partFirst) - sum(partSecond));
        }
    }

    protected static int sum(int[] arg) {
        int sum = 0;
        for (int i : arg) {
            sum += i;
        }
        return sum;
    }
}
