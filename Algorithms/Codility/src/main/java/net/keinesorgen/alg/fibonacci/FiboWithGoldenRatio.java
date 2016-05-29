package net.keinesorgen.alg.fibonacci;

/**
 *
 */
public class FiboWithGoldenRatio {

    double GOLDEN_RATIO = 1.61803398875;

    // ROUND( GOLDEN_RATIO^n / SQRT(5) )
    public int find(int n) {
        double up = Math.pow(GOLDEN_RATIO, (double) n);
        double down = Math.sqrt(5);
        double fib = up / down;
        int fibInteger = (int) Math.round(fib);
        return fibInteger;
    }
}
