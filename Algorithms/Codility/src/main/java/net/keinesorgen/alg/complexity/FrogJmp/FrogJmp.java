package net.keinesorgen.alg.complexity.FrogJmp;

/**
 *
 */
public class FrogJmp {

    boolean assumptions(int t) {
        return t >= 1 && t <= 1000000000;
    }

    boolean assumptions(int X, int Y) {
        return X <= Y;
    }

    public int solution(int X, int Y, int D) {
        if (assumptions(X) && assumptions(Y) && assumptions(D) && assumptions(X, Y)) {
            return ((Y - X) / D) + (((Y - X) % D) > 0 ? 1 : 0);
        } else {
            throw new RuntimeException("Assumtions error");
        }
    }
}
