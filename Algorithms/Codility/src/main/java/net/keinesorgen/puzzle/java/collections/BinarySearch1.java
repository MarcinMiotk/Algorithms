package net.keinesorgen.puzzle.java.collections;

import java.util.Arrays;

/**
 *
 */
public class BinarySearch1 {

    public static void main(String[] args) {
        String[] arr = {"java", "champ", "champion"};
        Arrays.sort(arr);
        System.out.print(Arrays.binarySearch(arr, "champion"));
        System.out.print(Arrays.binarySearch(arr, "You"));
    }

}
