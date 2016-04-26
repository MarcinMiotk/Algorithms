package com.snmill.cp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            LinkedList<Integer> sticks = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                sticks.addLast(scanner.nextInt());
            }

            List<Integer> leftList = numberOfSticksThatAreLeftBeforeEachSubsequentCutOperations(sticks);
            for (Integer left : leftList) {
                System.out.println(left);
            }

        }
    }

    private static List<Integer> numberOfSticksThatAreLeftBeforeEachSubsequentCutOperations(LinkedList<Integer> sticks) {
        List<Integer> left = new ArrayList<>();
        Collections.sort(sticks);
        while (sticks.size() > 0) {
            left.add(sticks.size());
            Integer first = sticks.getFirst();
            int n = sticks.size();
            for (int i = 0; i < n; i++) {
                Integer newValue = sticks.get(i) - first;
                if (newValue == 0) {
                    sticks.remove(i);
                    n--;
                    i--;
                } else {
                    sticks.set(i, newValue);
                }
            }
        }
        return left;
    }

}
