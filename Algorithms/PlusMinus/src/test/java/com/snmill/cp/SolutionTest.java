package com.snmill.cp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class SolutionTest {

    public SolutionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

//    @Test
    public void testMain() {

    }

    @Test
    public void testCalculate_primaryTest() {
        int[] sequence = {-4, 3, -9, 0, 4, 1};
        Solution instance = new Solution();
        Solution.Result result = instance.calculate(sequence);
        assertEquals("0.500000", result.positives());
        assertEquals("0.333333", result.negatives());
        assertEquals("0.166667", result.zeros());
    }

}
