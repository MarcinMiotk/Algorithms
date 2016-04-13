package net.keinesorgen.alg.counting;

/**
 *
 *
 */
public class CountingElements {

    public static int sum(int[] arg) {
        int sum = 0;
        for (int i : arg) {
            sum += i;
        }
        return sum;
    }

    public static int max(int[] from) {
        int max = Integer.MIN_VALUE;
        for (int check : from) {
            if (check > max) {
                max = check;
            }
        }
        return max;
    }

    public static int min(int[] from) {
        int min = Integer.MAX_VALUE;
        for (int check : from) {
            if (check < min) {
                min = check;
            }
        }
        return min;
    }

    public static int[] counting(int[] from) {
        int max = Integer.MIN_VALUE;
        for (int check : from) {
            if (check > max) {
                max = check;
            }
        }
        return counting(from, max);
    }

    public static int[] counting(int[] from, int maxValue) {
        int count = maxValue + 1;
        int[] result = new int[count];
        for (int i = 0; i < from.length; i++) {
            result[from[i]] = result[from[i]] + 1;
        }
        return result;
    }
}
