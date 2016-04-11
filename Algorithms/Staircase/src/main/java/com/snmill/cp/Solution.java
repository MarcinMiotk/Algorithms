package com.snmill.cp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            List<String> result = staircase(n);
            for (String line : result) {
                System.out.println(line);
            }
        }
    }

    public static List<String> staircase(int n) {
        List<String> stairs = new ArrayList<>();

        int hash = 1;
        while (hash <= n) {
            StringBuilder buffer = new StringBuilder(n);
            for (int i = 0; i < n - hash; i++) {
                buffer.append(" ");
            }
            for (int i = 0; i < hash; i++) {
                buffer.append("#");
            }
            stairs.add(buffer.toString());
            hash++;
        }
        return stairs;
    }

}
