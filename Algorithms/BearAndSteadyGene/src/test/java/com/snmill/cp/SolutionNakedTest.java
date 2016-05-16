package com.snmill.cp;

import com.snmill.cp.Solution.SqueezeIterator;
import org.junit.Assert;
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
        boolean steady = Solution.isSteady("GACT");
        assertTrue(steady);
    }

    @Test
    public void isSteady_n8_v2() {
        boolean steady = Solution.isSteady("AAGTGCCT");
        assertTrue(steady);
    }

    @Test
    public void isSteady_false_n8_v2() {
        boolean steady = Solution.isSteady("GAAATAAA");
        assertFalse(steady);
    }

    @Test
    public void isSteady_false_n40_v10() {
        boolean steady = Solution.isSteady("TGATGCCGTCCCCTCAACTTGAGTGCTCCTAATGCGTTGC");
        assertFalse(steady);
    }

    @Test
    public void SqueezeIterator_4() {
        SqueezeIterator iterator = new SqueezeIterator("GACT");
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals('G', iterator.next().character);
        Assert.assertEquals('T', iterator.next().character);
        Assert.assertEquals('A', iterator.next().character);
        Assert.assertEquals('C', iterator.next().character);
        Assert.assertFalse(iterator.hasNext());
    }
}
