package net.keinesorgen.alg.counting.MaxCounters;

/**
 * expected worst-case time complexity is O(N+M);
 *
 * expected worst-case space complexity is O(N)
 */
public class MaxCounters {

    public int[] solution(int N /* counters */, int[] A) {
        Counters counters = new Counters(N);
        for (int k = 0; k < A.length; k++) {
            counters.update(A[k]);
        }
        return counters.getResult();
    }

    static class Counters {

        private final int[] counters;
        private int max = 0;
        private int base = 0;

        enum Operation {

            INCREASE,
            MAX,
            IGNORE
        };

        void update(int value) {
            Operation operation = job(value);
            switch (operation) {
                case INCREASE:
                    increase(value);
                    break;
                case MAX:
                    max();
                    break;
                case IGNORE:
                    break;
                default:
                    break;
            }
        }

        Operation job(int value) {
            if (value >= 1 && value <= counters.length) {
                return Operation.INCREASE;
            }
            if (value == counters.length + 1) {
                return Operation.MAX;
            }
            return Operation.IGNORE;
        }

        Counters(int N) {
            this.counters = new int[N];
        }

        /**
         * thanks to this I reduce time complexity
         *
         */
        void updateByBase(int X) {
            if (counters[X - 1] <= base) {
                counters[X - 1] = base;
            }
        }

        void increase(int X) {
            updateByBase(X);

            counters[X - 1]++;

            // update max
            if (max < counters[X - 1]) {
                max = counters[X - 1];
            }
        }

        void max() {
            base = max;
        }

        int[] getResult() {

            for (int i = 0; i < counters.length; i++) {
                if (counters[i] < base) {
                    counters[i] = base;
                }
            }

            return counters;
        }
    }

}
