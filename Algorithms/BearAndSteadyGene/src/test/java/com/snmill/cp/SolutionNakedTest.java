package com.snmill.cp;

import static com.snmill.cp.Solution.convert;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 */
public class SolutionNakedTest {

    // It is considered to be steady if each of the four letters occurs exactly n/4 times
    @Test
    public void isSteady_n4_v1() {
        boolean steady = Solution.isSteady(convert("GACT"));
        assertTrue(steady);
    }

    @Test
    public void isSteady_n8_v2() {
        boolean steady = Solution.isSteady(convert("AAGTGCCT"));
        assertTrue(steady);
    }

    @Test
    public void isSteady_false_n8_v2() {
        boolean steady = Solution.isSteady(convert("GAAATAAA"));
        assertFalse(steady);
    }

    @Test
    public void isSteady_false_n40_v10() {
        boolean steady = Solution.isSteady(convert("TGATGCCGTCCCCTCAACTTGAGTGCTCCTAATGCGTTGC"));
        assertFalse(steady);
    }

    @Test
    public void countersMissing_2ofC() {
        String dna = "GAAATAAA";
        int required = 2;
        int[] counters = Solution.counters(convert(dna));
        int[] missing = Solution.countersMissing(counters, required);
        // ACTG
        assertEquals(0, missing[0]);    // A
        assertEquals(2, missing[1]);    // C
        assertEquals(1, missing[2]);    // T
        assertEquals(1, missing[3]);    // G
    }

    @Test
    public void createMutingDna_1() {
        int[] dna = new int[]{3, 0, 0, 0, 2, 0, 0, 0};
        int[] countersNow = Solution.counters(dna);
        int mutationLength = dna.length / 4;
        int[] countersMissing = Solution.countersMissing(countersNow, mutationLength);
        // 0 - 0
        // 1 - 2
        // 2 - 1
        // 3 - 1      
        int[] muting = Solution.createMutingDna(countersMissing);

        int[] mutingExpected = new int[]{
            1, 1, 2, 3
        };

        assertArrayEquals(mutingExpected, muting);
    }

}
