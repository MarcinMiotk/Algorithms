package com.snmill.cp;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 */
public class InsertionSortPartFirst {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int arraySize = scanner.nextInt();
            int[] unsortedArray = new int[arraySize];
            for (int index = 0; index < unsortedArray.length; index++) {
                unsortedArray[index] = scanner.nextInt();
            }
            printInsertionSortStages(unsortedArray);
        }
    }

    static void printInsertionSortStages(int[] array) {
        int indexOfSortableElement = array.length - 1;
        int sortedValue = array[array.length - 1];
        int[] shifted = array;
        while (!isAtRightPlace(indexOfSortableElement, shifted, sortedValue)) {
            shifted = shiftLeft(indexOfSortableElement, array);
            out.println(toString(shifted));
            --indexOfSortableElement;
        }
        shifted[indexOfSortableElement] = sortedValue;
        out.println(toString(shifted));
    }

    static int[] shiftLeft(int theIndexOf, int[] array) {
        int previous = array[theIndexOf - 1];
        array[theIndexOf] = previous;
        return array;
    }

    static boolean isAtRightPlace(int theIndexOf, int[] array, int sortedValue) {
        if(theIndexOf==0) {
            return true;
        }
        if (theIndexOf - 1 >= 0) {
            int previous = array[theIndexOf - 1];
            return previous <= sortedValue;
        } else {
            return false;
        }
    }

    static String toString(int[] array) {
        StringBuilder buffer = new StringBuilder();
        boolean first = true;
        for (int element : array) {
            if (first) {
                first = false;
            } else {
                buffer.append(" ");
            }
            buffer.append(element);
        }
        return buffer.toString();
    }
}
