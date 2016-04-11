package com.snmill.cp;

import java.io.InputStream;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] matrix = solution.createMatrix(System.in);
        Result result = solution.calculate(matrix);
        System.out.println(result.positives());
        System.out.println(result.negatives());
        System.out.println(result.zeros());
    }

    public int[] createMatrix(InputStream is) {
        int[] matrix;
        try (Scanner in = new Scanner(is)) {
            int count = in.nextInt();
            matrix = new int[count];
            int col = 0;
            while (in.hasNextInt()) {
                matrix[col] = in.nextInt();
                col++;
            }
        }
        return matrix;
    }

    static class Result {

        double negatives;
        double positives;
        double zeros;

        final NumberFormat nf = NumberFormat.getInstance(Locale.ENGLISH);

        public Result() {
            nf.setMaximumFractionDigits(6);
            nf.setMinimumFractionDigits(6);
            nf.setRoundingMode(RoundingMode.HALF_DOWN);
        }

        String positives() {
            return nf.format(positives);
        }

        String negatives() {
            return nf.format(negatives);
        }

        String zeros() {
            return nf.format(zeros);
        }
    }

    Result calculate(int[] sequence) {
        List<Counter> counters = counters(sequence,
                (CounterQualifier) (int value) -> value > 0,
                (CounterQualifier) (int value) -> value < 0,
                (CounterQualifier) (int value) -> value == 0
        );
        Result result = new Result();
        result.positives = (double) counters.get(0).accumulation / (double) sequence.length;
        result.negatives = (double) counters.get(1).accumulation / (double) sequence.length;
        result.zeros = (double) counters.get(2).accumulation / (double) sequence.length;
        return result;
    }

    List<Counter> counters(int[] sequence, CounterQualifier... qualifiers) {
        List<Counter> result = new ArrayList<>();
        for (CounterQualifier q : qualifiers) {
            result.add(new Counter());
        }
        for (int s : sequence) {
            for (int counter = 0; counter < qualifiers.length; counter++) {
                if (qualifiers[counter].qualify(s)) {
                    result.get(counter).inc();
                    break;
                }
            }
        }
        return result;

    }

    static class Counter {

        int accumulation = 0;

        void inc() {
            accumulation++;
        }
    }

    interface CounterQualifier {

        boolean qualify(int value);
    }

}
