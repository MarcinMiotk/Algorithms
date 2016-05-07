package com.snmill.cp;

import java.util.Iterator;
import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            int rotations = scanner.nextInt();
            int[][] matrix = new int[rows][columns];
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < columns; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int[][] rotated = rotate(matrix, rotations);
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < columns; col++) {
                    if (col > 0) {
                        System.out.print(" ");
                    }
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
    }

    public static int[][] rotate(int[][] matrix, int rotations) {
        return null;
    }

    public static int maxRings(int rows, int cols) {
        int min = (rows < cols ? rows : cols);

        return min / 2;
    }

    public static class Coordinates {

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 61 * hash + this.row;
            hash = 61 * hash + this.col;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Coordinates other = (Coordinates) obj;
            if (this.row != other.row) {
                return false;
            }
            if (this.col != other.col) {
                return false;
            }
            return true;
        }

        int row;
        int col;

        public Coordinates(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }

    public static class MatrixIterator implements Iterator<Coordinates> {

        final int[][] matrix;
        final int matrixCols;
        final int matrixRows;
        final int ring;
        final int allSteps;
        //
        final int internalCols;
        final int internalRows;

        public MatrixIterator(int[][] matrix, int matrixCols, int matrixRows, int ring) {
            this.matrix = matrix;
            this.matrixCols = matrixCols;
            this.matrixRows = matrixRows;
            this.ring = ring;
            //
            this.internalCols = matrixCols - 2 * ring;
            this.internalRows = matrixRows - 2 * ring;
            //
            this.allSteps = (internalCols - 1) * 2 + (internalRows - 1) * 2;
            //
            row = ring;
            col = ring;
        }

        int step = 0;

        @Override
        public boolean hasNext() {
            return step < allSteps;
        }

        int row;
        int col;
        StepStrategy strategy = new Down();

        @Override
        public Coordinates next() {
            Coordinates prepare = new Coordinates(row, col);

            if (step == internalRows - 1) {
                strategy = new Right();
            }
            if (step == ((internalRows - 1) + (internalCols - 1))) {
                strategy = new Up();
            }
            if (step == ((internalRows - 1) + (internalCols - 1) + (internalRows - 1))) {
                strategy = new Left();
            }
            strategy.change();
            step++;
            return prepare;
        }

        interface StepStrategy {

            void change();
        }

        class Down implements StepStrategy {

            @Override
            public void change() {
                row++;
            }
        }

        class Right implements StepStrategy {

            @Override
            public void change() {
                col++;
            }
        }

        class Up implements StepStrategy {

            @Override
            public void change() {
                row--;
            }
        }

        class Left implements StepStrategy {

            @Override
            public void change() {
                col--;
            }
        }

    }

}
