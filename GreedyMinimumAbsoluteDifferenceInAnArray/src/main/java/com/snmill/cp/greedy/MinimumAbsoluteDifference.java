package com.snmill.cp.greedy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class MinimumAbsoluteDifference {

    void append(int number) {

    }

    static class Pair {
        final int a;
        final int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    static Set<Pair> pairs(int... numbers) {
        Set<Pair> result = new HashSet<>();
        result.add(new Pair(0,0));
        return result;
    }


    static Iterator<Pair> combinations_without_repetitions(int... numbers) {

        // 0, 1
        // 0, 2
        // 1, 2


        // two index, (i) and (j)


        return new Iterator<Pair>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Pair next() {
                return null;
            }
        };
    }

    static int absoluteDifference(int a, int b) {
        return Math.abs(a-b);
    }

    int getResult() {
        return 3;
    }
}
