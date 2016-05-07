package com.snmill.cp;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int t = 0; t < testCases; t++) {
                int size = scanner.nextInt();
                LinkedList<Integer> chain = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    chain.add(scanner.nextInt());
                }
                boolean canFullySort = doesTheRobotCanFullySortA(chain);
                if (canFullySort) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    static boolean doesTheRobotCanFullySortA(LinkedList<Integer> chain) {
        int findThisValue = 1;

        while (chain.size() > 2) {
            int index = indexOfThisValue(chain, findThisValue);
            if (index == 0 || index % 2 == 0) {
                // remove only
                chain.remove(index);
            } else {
                // remove and swap [0] with [1]
                chain.remove(index);

                int a = chain.removeFirst();
                int b = chain.removeFirst();

                chain.addFirst(a);
                chain.addFirst(b);
            }
            findThisValue++;
        }

        if (chain.get(0) < chain.get(1)) {
            return true;
        } else {
            return false;
        }
    }

    static int indexOfThisValue(LinkedList<Integer> chain, int findThisValue) {
        int size = chain.size();
        for (int i = 0; i < size; i++) {
            if (chain.get(i) == findThisValue) {
                return i;
            }
        }
        throw new IllegalArgumentException("Cannot find the value");
    }

}
