package net.keinesorgen.alg.counting.FrogRiverOne;

/**
 *
 */
public class FrogRiverOne {

    /**
     * step 1: make counters array with size 0...X
     *
     * step 2: iterate through A and update counters (may be boolean)
     *
     * step 3: if all itemas are true then we have the solution
     */
    public int solution(int X, int[] A) {

        final int ERROR = -1;
        final int NOT_FOUND = -1;

        boolean[] counters = new boolean[X];
        int waiting = X;

        for (int i = 0; i < A.length; i++) {
            int value = A[i];
            if (isValid(value)) {
                if (!counters[value - 1]) {
                    counters[value - 1] = true;
                    waiting--;
                }
                if (waiting <= 0) {
                    return i;
                }
            } else {
                return ERROR;
            }
        }
        return NOT_FOUND;
    }

    private boolean isValid(int value) {
        return value > 0 && value <= 100000;
    }

}
