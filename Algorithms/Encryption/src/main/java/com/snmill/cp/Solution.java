package com.snmill.cp;

import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            System.out.println(encode(input));
        }
    }

    public static String encode(String input) {
        char[][] translationTable = convert(input);
        return encode(translationTable, input.length());
    }

    static String encode(char[][] translationTable, int length) {
        StringBuilder buffer = new StringBuilder(length + translationTable.length);

        int rows = translationTable.length;
        int cols = translationTable[0].length;

        int addedCharacters = 0;

        int iRow = 0;
        int iCol = 0;

        while (addedCharacters < length) {
            char character = translationTable[iRow][iCol];
            if (character != 0) {
                buffer.append(character);
                addedCharacters++;
            }
            iRow++;
            if (iRow == rows) {
                iCol++;
                iRow = 0;
                buffer.append(" ");
            }
        }
        return buffer.toString();
    }

    static char[][] convert(String input) {
        char[][] empty = grid(input.length());
        int rows = empty.length;
        int cols = empty[0].length;

        int iRow = 0;
        int iCol = 0;
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            empty[iRow][iCol] = character;
            iCol++;
            if (iCol == cols) {
                iRow++;
                iCol = 0;
            }
        }

        return empty;
    }

    static char[][] grid(int length) {
        int rows = (int) Math.floor(Math.sqrt(length));
        int cols = (int) Math.ceil(Math.sqrt(length));
        if (!(rows * cols >= length)) {
            rows++;
        }
        char[][] grid = new char[rows][cols];
        return grid;
    }
}
