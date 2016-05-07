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
                LinkedList<Integer> expected = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    expected.add(scanner.nextInt());
                }
                Integer requiredBribes = howManyBribesAreRequired(expected);
                if (requiredBribes != null) {
                    System.out.println(requiredBribes);
                } else {
                    System.out.println("Too chaotic");
                }
            }
        }
    }

    /**
     * if e[0]=a[0] then Bribe(+0) and remove First from both Queues.
     *
     * if e[0]=a[1] then Bribe(+1) and take a[0] removeFirst() and addFirst(took
     * value) and removeFirst from e
     *
     * if e[0]=a[2] then Bribe(+2) and removeFirst form Expected and remove(2)
     * from A LinkedList.
     *
     * @param expected
     * @return
     */
    public static Integer howManyBribesAreRequired(LinkedList<Integer> expected) {
        int n = expected.size();
        LinkedList<Integer> initial = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            initial.add(i);
        }

        Integer requiredBribes = 0;
        while (!initial.isEmpty()) {
            Integer expectedValue = expected.removeFirst();

            if (expectedValue.intValue() == initial.get(0).intValue()) {
                initial.removeFirst();
            } else if (expectedValue.intValue() == initial.get(1).intValue()) {
                requiredBribes += 1;
                Integer toShift = initial.removeFirst();
                initial.removeFirst();
                initial.addFirst(toShift);
            } else if (expectedValue.intValue() == initial.get(2).intValue()) {
                requiredBribes += 2;
                initial.remove(2);
            } else {

//                int got0 = initial.get(0);
//                int got1 = initial.get(1);
//                int got2 = initial.get(2);
//                int got3 = initial.get(3);

                return null;
            }

        }
        return requiredBribes;
    }
}
