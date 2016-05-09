package com.snmill.cp;

import org.junit.Assert;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 */
public class SolutionNakedTest {

    @Test
    public void notPangram_1() {
        boolean response = Solution.isPangram("abc");
        Assert.assertFalse(response);
    }

    @Test
    public void table_has_26_elements() {
        int[] asciiCounters = Solution.table();
        assertEquals(26, asciiCounters.length);
    }

    @Test
    public void increment_a_z() {
        int[] asciiCounters = Solution.table();
        Solution.increment(asciiCounters, 'a');
        Solution.increment(asciiCounters, 'z');
        assertEquals(1, asciiCounters[0]);
        assertEquals(1, asciiCounters[asciiCounters.length - 1]);
    }

    @Test
    public void increment_A_Z() {
        int[] asciiCounters = Solution.table();
        Solution.increment(asciiCounters, 'A');
        Solution.increment(asciiCounters, 'Z');
        assertEquals(1, asciiCounters[0]);
        assertEquals(1, asciiCounters[asciiCounters.length - 1]);
    }

    @Test
    public void increment_outOfArray() {
        int[] asciiCounters = Solution.table();
        int[] empty = new int[asciiCounters.length];
        Solution.increment(asciiCounters, ' ');
        Solution.increment(asciiCounters, '1');
        Solution.increment(asciiCounters, '*');
        assertArrayEquals(empty, asciiCounters);
    }

}
