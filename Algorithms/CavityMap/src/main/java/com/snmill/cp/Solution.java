package com.snmill.cp;

import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            scanner.nextLine();
            int[][] map = new int[n][n];
            for (int y = 0; y < n; y++) {
                String line = scanner.nextLine();
                for (int x = 0; x < n; x++) {
                    int val = line.charAt(x) - 48;
                    map[y][x] = val;
                }
            }
            countCavities(map);
        }
    }

    /**
     * We will call a cell of the map a cavity if and only if this cell is not
     * on the border of the map and each cell adjacent to it has strictly
     * smaller depth. Two cells are adjacent if they have a common side (edge).
     *
     * @param map
     * @return
     */
    static void countCavities(int[][] map) {
        int borderFrom = 1;                 // border edge
        int borderTo = map.length - 2;      // border edge

        for (int y = 0; y < map.length; y++) {
            StringBuilder line = new StringBuilder(map.length);
            for (int x = 0; x < map.length; x++) {
                boolean cavity = false;
                if (x >= borderFrom && x <= borderTo && y >= borderFrom && y <= borderTo) {
                    cavity = isCavity(map, x, y);
                }
                if (cavity) {
                    line.append("X");
                } else {
                    char number = (char) (map[y][x] + 48);
                    line.append(number);
                }
            }
            System.out.println(line.toString());
        }
    }

    static boolean isCavity(int[][] map, int x, int y) {
        int myValue = map[y][x];

        if (myValue <= map[y - 1][x]) {
            return false;
        }
        if (myValue <= map[y + 1][x]) {
            return false;
        }
        if (myValue <= map[y][x + 1]) {
            return false;
        }
        if (myValue <= map[y][x - 1]) {
            return false;
        }
        return true;
    }
}
