package com.snmill.cp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int rocks = scanner.nextInt();
            scanner.nextLine();
            List<String> compositions = new ArrayList<>();
            for (int r = 0; r < rocks; r++) {
                String composition = scanner.nextLine();
                compositions.add(composition);
            }
            System.out.println(numberOfGemElementsThatExistInThoseRocks(compositions));
        }
    }

    // An element is called a gem-element if it occurs at least once in each of the rocks
    static int numberOfGemElementsThatExistInThoseRocks(List<String> compositions) {
        int rocks = compositions.size();
        int alphabetCharactersCount = (int) 'z' - (int) 'a' + 1;

        List<boolean[]> counters = new ArrayList<>();
        compositions.forEach((String t) -> {
            boolean[] incrementableAsciiTables = new boolean[alphabetCharactersCount];
            t.chars().forEach((int i) -> {
                incrementableAsciiTables[i - 'a'] = true;
            });
            counters.add(incrementableAsciiTables);
        });

        int hasAtLeastSuchRocks = 0;
        for (int index = 0; index < alphabetCharactersCount; index++) {
            boolean inAllRocks = true;
            for (int rock = 0; rock < rocks; rock++) {
                boolean[] subCounters = counters.get(rock);
                if (subCounters[index]) {

                } else {
                    inAllRocks = false;
                    break;
                }
            }
            if (inAllRocks) {
                hasAtLeastSuchRocks++;
            }
        }
        return hasAtLeastSuchRocks;
    }

}
