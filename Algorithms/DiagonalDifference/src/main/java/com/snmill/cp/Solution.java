package com.snmill.cp;

import com.snmill.cp.Solution.DiagonalType;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        MatrixFactory factory = new Solution().new MatrixFactoryImpl();
        int[] matrix = factory.createMatrix(System.in);
        int n = (int) Math.sqrt(matrix.length);
        GetValue xyGetter = new Solution().new MatrixGetValue(matrix, n);
        DifferenceOfSums solution = new Solution().new DifferenceOfSumsImpl();
        int result = solution.difference(xyGetter, n);
        System.out.println(result);
    }

    interface GetValue {

        int get(int x, int y);
    }

    class MatrixGetValue implements GetValue {

        private final int[] matrix;
        private final int n;

        public MatrixGetValue(int[] matrix, int n) {
            this.matrix = matrix;
            this.n = n;
        }

        @Override
        public int get(int x, int y) {
            return matrix[x * n + y];
        }

    }

    interface MatrixFactory {

        int[] createMatrix(InputStream is);
    }

    class MatrixFactoryImpl implements MatrixFactory {

        @Override
        public int[] createMatrix(InputStream is) {
            int[] matrix;
            try (Scanner in = new Scanner(is)) {
                int count = in.nextInt();
                matrix = new int[count * count];
                int col = 0;
                int row = 0;
                while (in.hasNextInt()) {
                    matrix[row * count + col] = in.nextInt();
                    col++;
                    if (col == count) {
                        row++;
                        col = 0;
                    }
                }
            }
            return matrix;
        }
    }

    interface SolucationCalculate {

        int calculate(int[] matrix);
    }

    enum DiagonalType {

        PRIMARY,
        SECONDARY;
    }

    interface DiagonalGetter {

        Iterator<Integer> iterator(GetValue xy, DiagonalType type, int in);
    }

    class DiagonalGetterImpl implements DiagonalGetter {

        @Override
        public Iterator<Integer> iterator(GetValue xy, DiagonalType type, int n) {

            if (DiagonalType.PRIMARY.equals(type)) {
                return new Iterator<Integer>() {

                    int step = 0;

                    @Override
                    public boolean hasNext() {
                        return step < n;
                    }

                    @Override
                    public Integer next() {
                        int value = xy.get(step, step);
                        step++;
                        return value;
                    }
                };
            } else {
                return new Iterator<Integer>() {

                    int step = 0;

                    @Override
                    public boolean hasNext() {
                        return step < n;
                    }

                    @Override
                    public Integer next() {
                        int value = xy.get(step, n - step - 1);
                        step++;
                        return value;
                    }
                };

            }

        }

    }

    interface DifferenceOfSums {

        int difference(GetValue xyGetter, int n);
    }

    class DifferenceOfSumsImpl implements DifferenceOfSums {

        final DiagonalGetter diagonalGetter = new DiagonalGetterImpl();

        @Override
        public int difference(GetValue xyGetter, int n) {
            Iterator<Integer> primary = diagonalGetter.iterator(xyGetter, DiagonalType.PRIMARY, n);
            Iterator<Integer> secondary = diagonalGetter.iterator(xyGetter, DiagonalType.SECONDARY, n);
            int primarySum = 0;
            int secondarySum = 0;
            while (primary.hasNext()) {
                primarySum += primary.next();
            }
            while (secondary.hasNext()) {
                secondarySum += secondary.next();
            }
            return Math.abs(primarySum - secondarySum);
        }

    }

}
