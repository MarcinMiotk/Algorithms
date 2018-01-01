package com.snmill.cp.greedy;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class MinimumAbsoluteDifferenceTest {


    MinimumAbsoluteDifference sut;

    @Before
    public void up() {
        sut = new MinimumAbsoluteDifference();
    }

    @Test
    public void example() {
        sut.append(3);
        sut.append(-7);
        sut.append(0);
        assertEquals(3, sut.getResult());
    }

    @Test
    public void absoluteDifference_10() {
        int difference = MinimumAbsoluteDifference.absoluteDifference(3, -7);
        assertEquals(10, difference);
    }

    @Test
    public void absoluteDifference_3() {
        int difference = MinimumAbsoluteDifference.absoluteDifference(3, 0);
        assertEquals(3, difference);
    }

    @Test
    public void absoluteDifference_7() {
        int difference = MinimumAbsoluteDifference.absoluteDifference(-7, 0);
        assertEquals(7, difference);
    }

    @Test
    public void pairs_count_1() {
        Set<MinimumAbsoluteDifference.Pair> pairs = MinimumAbsoluteDifference.pairs(0, 1);
        assertEquals(1, pairs.size());
    }

    @Test
    public void pairs_count_3() {
        Set<MinimumAbsoluteDifference.Pair> pairs = MinimumAbsoluteDifference.pairs(3, -7, 0);
        assertEquals(3, pairs.size());
    }

}