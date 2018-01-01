package com.snmill.cp.greedy;

import org.junit.Test;

import static org.junit.Assert.*;

public class CombinationsTest {

    @Test
    public void countCombinationsWithoutRepetitions_6() {
        int count = Combinations.countCombinationsWithoutRepetitions(2, 4);
        assertEquals(6, count);
    }

    @Test
    public void countCombinationsWithoutRepetitions_3() {
        int count = Combinations.countCombinationsWithoutRepetitions(2, 3);
        assertEquals(3, count);
    }

}