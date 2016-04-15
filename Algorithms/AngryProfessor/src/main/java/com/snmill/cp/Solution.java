package com.snmill.cp;

import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        for (int i = 0; i < numberOfTestCases; i++) {
            int studentsInClass = scanner.nextInt();
            int cancellationThreshold = scanner.nextInt();
            int[] arrivalTimesOfStudents = new int[studentsInClass];
            for (int j = 0; j < arrivalTimesOfStudents.length; j++) {
                arrivalTimesOfStudents[j] = scanner.nextInt();
            }
            TestCase tc = new TestCase(cancellationThreshold, arrivalTimesOfStudents);
            System.out.println(tc.isTheClassCancelled().name());
        }
    }

    static enum Cancelled {

        YES, NO;
    }

    static class TestCase {

        final int studentsInClass;
        final int cancellationThreshold;
        final int[] arrivalTimesOfStudents;

        public TestCase(int cancellationThreshold, int[] arrivalTimesOfStudents) {
            this.studentsInClass = arrivalTimesOfStudents.length;
            this.cancellationThreshold = cancellationThreshold;
            this.arrivalTimesOfStudents = arrivalTimesOfStudents;
        }

        public Cancelled isTheClassCancelled() {
            int attended = 0;
            Cancelled result;
            for (int student = 0; student < studentsInClass; student++) {
                if (arrivalTimesOfStudents[student] <= 0) {
                    attended++;
                    if (attended >= cancellationThreshold) {
                        return Cancelled.NO;
                    }
                }
            }
            return Cancelled.YES;
        }
    }

}
