package net.keinesorgen.alg.counting;

import static net.keinesorgen.alg.counting.CountingElements.counting;
import static net.keinesorgen.alg.counting.CountingElements.sum;

/**
 * Swap elements (in one step) to reach two arrays with the same sum.
 */
public class SwapElements {

    boolean solution(int[] A, int[] B, int maxValue) {
        int sum_a = sum(A);
        int sum_b = sum(B);

        int difference = sum_b - sum_a;

        // odd number
        if (difference % 2 == 1) {
            return false;
        }

        // half
        difference /= 2;

        int counts[] = counting(A, maxValue);

        for (int i = 0; i < A.length; i++) {
            if ((0 <= B[i] - difference)
                    && (B[i] - difference <= maxValue)
                    && (counts[B[i] - difference] > 0)) {

                return true;
            }
        }

        return false;
    }

}
