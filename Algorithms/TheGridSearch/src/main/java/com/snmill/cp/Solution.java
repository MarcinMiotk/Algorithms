package com.snmill.cp;

import java.util.Iterator;
import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int testCase = 0; testCase < testCases; testCase++) {
                int bigRows = scanner.nextInt();
                int bigColumns = scanner.nextInt();
                int[][] big = grid(bigRows, bigColumns, scanner);

                int smallRows = scanner.nextInt();
                int smallColumns = scanner.nextInt();
                int[][] small = grid(smallRows, smallColumns, scanner);

                boolean exists = isSmallExistsInBig(big, small);
                if (exists) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static int[][] grid(int rows, int columns, Scanner scanner) {
        int[][] grid = new int[rows][columns];
        for (int r = 0; r < rows; r++) {
            String row = scanner.next();
            if (row.equals("")) {
                row = scanner.next();
            }
            for (int c = 0; c < columns; c++) {
                int cell = Integer.valueOf(row.substring(c, c + 1));
                grid[r][c] = cell;
            }
        }
        return grid;
    }

    public static boolean isSmallExistsInBig(int[][] big, int[][] small) {
        int smallRows = small.length;
        int smallCols = small[0].length;

        for (int bRow = 0; bRow < big.length; bRow++) {
            for (int bCol = 0; bCol < big[bRow].length; bCol++) {
                if (big[bRow][bCol] == small[0][0]) {
                    if (bRow + smallRows <= big.length && bCol + smallCols <= big[0].length) {
                        if (big[bRow + smallRows - 1][bCol + smallCols - 1] == small[smallRows - 1][smallCols - 1]) {
                            if (check(big, small, bRow, bCol)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean check(int[][] big, int[][] small, int bRow, int bCol) {
        Iterator<Integer> bigItems = gridItems(big, bRow, bCol, small.length, small[0].length);
        Iterator<Integer> smallItems = gridItems(small, 0, 0, small.length, small[0].length);
        while (smallItems.hasNext()) {
            int smallCell = smallItems.next();
            int bigCell = bigItems.next();
            if (smallCell != bigCell) {
                return false;
            }
        }
        return true;
    }

    public static Iterator<Integer> gridItems(int[][] grid, int relativeStartRow, int relativeStartCol, int rows, int cols) {
        return new Iterator<Integer>() {

            int walk = 0;
            int walkEnd = rows * cols;

            @Override
            public boolean hasNext() {
                return walk < walkEnd;
            }

            @Override
            public Integer next() {
                int row = walk / cols;
                int col = walk % cols;

                int cell = grid[row + relativeStartRow][col + relativeStartCol];

                walk++;

                return cell;
            }

        };
    }
}
