package com.snmill.cp;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int numberOfPeople = in.nextInt();
            int numberOfTopics = in.nextInt();

            boolean topic[][] = new boolean[numberOfPeople][numberOfTopics];
            for (int person_i = 0; person_i < numberOfPeople; person_i++) {
                String string = in.next();
                for (int topic_i = 0; topic_i < numberOfTopics; topic_i++) {
                    char c = string.charAt(topic_i);
                    if (c == '1') {
                        topic[person_i][topic_i] = true;
                    } else {
                        topic[person_i][topic_i] = false;
                    }
                }
            }

            // sets
            Set<Set<Integer>> sets = new HashSet<>();
            // for each two person
            for (int a = 0; a < numberOfPeople; a++) {
                for (int b = 0; b < numberOfPeople; b++) {
                    if (a != b) {
                        Set<Integer> candidate = new HashSet<>(2);
                        candidate.add(a);
                        candidate.add(b);
                        sets.add(candidate);
                    }
                }
            }

            Iterator<Set<Integer>> iterator = sets.iterator();

            int maximumNumberOfTopics = Integer.MIN_VALUE;
            int pairsKnowMaxNumberOfTopics = 0;

            while (iterator.hasNext()) {
                Set<Integer> ab = iterator.next();
                Iterator<Integer> abIterator = ab.iterator();
                int a = abIterator.next();
                int b = abIterator.next();
                int localNumberOfTopics = 0;
                boolean[] crossTopics = new boolean[numberOfTopics];
                for (int i = 0; i < numberOfTopics; i++) {
                    crossTopics[i] = topic[a][i] | topic[b][i];
                    if (crossTopics[i]) {
                        localNumberOfTopics++;
                    }
                }
                if (localNumberOfTopics > maximumNumberOfTopics) {
                    maximumNumberOfTopics = localNumberOfTopics;
                    pairsKnowMaxNumberOfTopics = 1;
                } else if (localNumberOfTopics == maximumNumberOfTopics) {
                    pairsKnowMaxNumberOfTopics++;
                }
            }

            System.out.println(maximumNumberOfTopics);
            System.out.println(pairsKnowMaxNumberOfTopics);
        }
    }
}
