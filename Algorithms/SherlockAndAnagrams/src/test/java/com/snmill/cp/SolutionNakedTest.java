package com.snmill.cp;

import static com.snmill.cp.Solution.findTheNumberOfUnorderedAnagrammaticPairs;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class SolutionNakedTest {

    @Test
    public void find_4_pairs() {
        // iwwhrlkpek
        int anagrammicPairs = findTheNumberOfUnorderedAnagrammaticPairs("abba");
        Assert.assertEquals(4, anagrammicPairs);
    }

    @Test
    public void find_3_pairs() {
        // iwwhrlkpek
        int anagrammicPairs = findTheNumberOfUnorderedAnagrammaticPairs("iwwhrlkpek");
        Assert.assertEquals(3, anagrammicPairs);
    }

}
