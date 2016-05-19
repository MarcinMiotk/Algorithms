package com.snmill.cp;

import org.junit.Test;

/**
 *
 */
public class InsertionSortPartFirstNakedTest {

    @Test
    public void insertionSortShifting() {
        InsertionSortPartFirst.printInsertionSortStages(new int[]{2, 4, 6, 8, 3});
    }

    @Test
    public void insertionSortShifting2() {
        InsertionSortPartFirst.printInsertionSortStages(new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 1});
    }
}
