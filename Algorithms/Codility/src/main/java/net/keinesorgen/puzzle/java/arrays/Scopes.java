package net.keinesorgen.puzzle.java.arrays;

/**
 *
 */
public class Scopes {

    final static int x[] = new int[5];

    public void test1() {
        double x = (double) 2;
    }

    public void test2() {
        int x = 2;
        x = Scopes.x[3];
    }
}
