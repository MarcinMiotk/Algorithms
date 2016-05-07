package com.snmill.cp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
                    System.out.print(rotated[row][col]);
                }
                System.out.println();
            }
        }
    }

    public static int[][] rotate(int[][] matrix, int rotations) {
        List<LinkedList<Integer>> rings = createRings(matrix);

        for (LinkedList<Integer> ring : rings) {
            int cycle = ring.size();
            int newHeadPosition = rotations % cycle;
            if (newHeadPosition > 0) {
                for (int i = 0; i < newHeadPosition; i++) {
                    ring.addFirst(ring.removeLast());
                }
            }
        }

        int[][] rotated = createMatrixFromRings(rings, matrix);

        return rotated;
    }

    public static int[][] createMatrixFromRings(List<LinkedList<Integer>> rings, int[][] matrix) {
        int[][] rotated = new int[matrix.length][matrix[0].length];

        int maxRings = maxRings(matrix.length, matrix[0].length);
        for (int ring = 0; ring < maxRings; ring++) {
            MatrixIterator iterator = new MatrixIterator(matrix, matrix[0].length, matrix.length, ring);
            int step = 0;
            while (iterator.hasNext()) {
                Coordinates coordinates = iterator.next();
                rotated[coordinates.row][coordinates.col] = rings.get(ring).get(step++);
            }
        }
        return rotated;
    }

    public static List<LinkedList<Integer>> createRings(int[][] matrix) {
        List<LinkedList<Integer>> rings = new ArrayList<>();
        int maxRings = maxRings(matrix.length, matrix[0].length);
        for (int ring = 0; ring < maxRings; ring++) {
            LinkedList<Integer> linkedList = new LinkedList<>();
            MatrixIterator iterator = new MatrixIterator(matrix, matrix[0].length, matrix.length, ring);
            while (iterator.hasNext()) {
                Coordinates coordinates = iterator.next();
                linkedList.add(matrix[coordinates.row][coordinates.col]);
            }
            rings.add(linkedList);
        }
        return rings;
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
